package com.equipo.candidatoinfo.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.model.Cargo
import com.equipo.candidatoinfo.model.Denuncia
import com.equipo.candidatoinfo.model.EstadoDenuncia
import com.equipo.candidatoinfo.model.EstadoProyecto
import com.equipo.candidatoinfo.model.Proyecto
import com.equipo.candidatoinfo.ui.theme.*
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CalendarToday



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    candidateId: String = "",
    onNavigateBack: () -> Unit = {},
    viewModel: DetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Cargar candidato cuando cambia el ID
    LaunchedEffect(candidateId) {
        viewModel.loadCandidato(candidateId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            uiState.error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = uiState.error ?: "Error desconocido",
                        color = Error
                    )
                }
            }
            uiState.candidato != null -> {
                val candidato = uiState.candidato!!
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    // Header con foto y datos básicos
                    item {
                        CandidatoHeader(candidato)
                    }

                    // Información Personal
                    item {
                        SectionTitle("Información Personal")
                        InformacionPersonalCard(candidato)
                    }

                    // Denuncias y Antecedentes
                    if (candidato.denuncias.isNotEmpty()) {
                        item {
                            SectionTitle("Denuncias y Antecedentes")
                        }
                        items(candidato.denuncias) { denuncia ->
                            DenunciaCard(denuncia)
                        }
                    }

                    // Proyectos Presentados
                    if (candidato.proyectos.isNotEmpty()) {
                        item {
                            SectionTitle("Proyectos Presentados")
                        }
                        items(candidato.proyectos) { proyecto ->
                            ProyectoCard(proyecto)
                        }
                    }

                    // Botón para ver fuente oficial
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* TODO: Abrir URL */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Primary
                            )
                        ) {
                            Text("Ver en JNE")
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun CandidatoHeader(candidato: Candidato) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary.copy(alpha = 0.05f))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto grande
        if (candidato.fotoUrl.isNotEmpty()) {
            val drawableId = getDrawableId(candidato.fotoUrl)
            if (drawableId != null) {
                Image(
                    painter = painterResource(id = drawableId),
                    contentDescription = "Foto de ${candidato.nombreCompleto}",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                // Fallback si no encuentra la imagen
                AvatarFallback(candidato.nombre.first(), Modifier.size(120.dp))
            }
        } else {
            AvatarFallback(candidato.nombre.first(), Modifier.size(120.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = candidato.nombreCompleto,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = candidato.partidoPolitico,
            style = MaterialTheme.typography.titleMedium,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AssistChip(
                onClick = { },
                label = {
                    Text(
                        text = if (candidato.cargo == Cargo.CONGRESO) "Congreso" else "Presidencia"
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Primary,
                    labelColor = Color.White
                )
            )

            AssistChip(
                onClick = { },
                label = {
                    Text("${candidato.edad} años")
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Surface,
                    labelColor = TextPrimary
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

// Indicadores de transparencia
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Badge de denuncias
            if (candidato.numeroDenuncias > 0) {
                AssistChip(
                    onClick = { },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,  // Agregar import
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("${candidato.numeroDenuncias} denuncia${if (candidato.numeroDenuncias > 1) "s" else ""}")
                        }
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Error.copy(alpha = 0.1f),
                        labelColor = Error
                    )
                )
            }

            // Badge de proyectos
            if (candidato.numeroProyectos > 0) {
                AssistChip(
                    onClick = { },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Description,  // Agregar import
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("${candidato.numeroProyectos} proyecto${if (candidato.numeroProyectos > 1) "s" else ""}")
                        }
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Secondary.copy(alpha = 0.1f),
                        labelColor = Secondary
                    )
                )
            }
        }


    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = TextPrimary,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}

@Composable
fun InformacionPersonalCard(candidato: Candidato) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Biografía",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = candidato.biografia,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
    }
}

@Composable
fun DenunciaCard(denuncia: Denuncia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // ← AGREGAR ÍCONO
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = when (denuncia.tipo) {
                            TipoDenuncia.PENAL -> Icons.Default.Gavel  // Agregar import
                            TipoDenuncia.ADMINISTRATIVA -> Icons.Default.AccountBalance
                            TipoDenuncia.CIVIL -> Icons.Default.BalanceIcon  // o cualquier otro
                        },
                        contentDescription = null,
                        tint = Error,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = denuncia.titulo,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }

                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = when (denuncia.estado) {
                                EstadoDenuncia.EN_PROCESO -> "En proceso"
                                EstadoDenuncia.ARCHIVADO -> "Archivado"
                                EstadoDenuncia.SENTENCIADO -> "Sentenciado"
                            },
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = when (denuncia.estado) {
                            EstadoDenuncia.EN_PROCESO -> Color(0xFFFFF3E0)
                            EstadoDenuncia.ARCHIVADO -> Surface
                            EstadoDenuncia.SENTENCIADO -> Error.copy(alpha = 0.1f)
                        },
                        labelColor = when (denuncia.estado) {
                            EstadoDenuncia.EN_PROCESO -> Color(0xFFFF6F00)
                            EstadoDenuncia.ARCHIVADO -> TextSecondary
                            EstadoDenuncia.SENTENCIADO -> Error
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = denuncia.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,  // Agregar import
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = TextSecondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = denuncia.fecha,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
        }
    }
}


@Composable
fun ProyectoCard(proyecto: Proyecto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = proyecto.titulo,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )

                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = when (proyecto.estado) {
                                EstadoProyecto.PRESENTADO -> "Presentado"
                                EstadoProyecto.EN_DEBATE -> "En debate"
                                EstadoProyecto.APROBADO -> "Aprobado"
                                EstadoProyecto.RECHAZADO -> "Rechazado"
                                EstadoProyecto.ARCHIVADO -> "Archivado"
                            },
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = when (proyecto.estado) {
                            EstadoProyecto.APROBADO -> Secondary.copy(alpha = 0.1f)
                            EstadoProyecto.EN_DEBATE -> Primary.copy(alpha = 0.1f)
                            EstadoProyecto.RECHAZADO -> Error.copy(alpha = 0.1f)
                            else -> Surface
                        },
                        labelColor = when (proyecto.estado) {
                            EstadoProyecto.APROBADO -> Secondary
                            EstadoProyecto.EN_DEBATE -> Primary
                            EstadoProyecto.RECHAZADO -> Error
                            else -> TextSecondary
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = proyecto.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = proyecto.fecha,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
    }
}

@Composable
private fun AvatarFallback(initial: Char, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.clip(CircleShape),
        color = getColorForInitial(initial)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = initial.toString(),
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun getColorForInitial(initial: Char): Color {
    return when (initial.uppercaseChar()) {
        'K' -> Color(0xFF9C27B0) // Morado
        'V' -> Color(0xFF4CAF50) // Verde
        'R' -> Color(0xFFFF5722) // Naranja
        'H' -> Color(0xFF2196F3) // Azul
        'C' -> Color(0xFFFF9800) // Amarillo
        'Y' -> Color(0xFF795548) // Café
        'G' -> Color(0xFF00BCD4) // Cyan
        'A' -> Color(0xFF607D8B) // Gris
        'P' -> Color(0xFFE91E63) // Rosa
        else -> Primary
    }
}

@Composable
private fun getDrawableId(imageName: String): Int? {
    val context = LocalContext.current
    return try {
        context.resources.getIdentifier(
            imageName,
            "drawable",
            context.packageName
        ).takeIf { it != 0 }
    } catch (e: Exception) {
        null
    }
}