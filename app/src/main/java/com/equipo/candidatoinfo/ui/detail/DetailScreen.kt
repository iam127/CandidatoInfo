package com.equipo.candidatoinfo.ui.detail

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.equipo.candidatoinfo.util.IntentUtils
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.equipo.candidatoinfo.model.*
import com.equipo.candidatoinfo.ui.theme.*
import com.equipo.candidatoinfo.util.IntentUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    candidateId: String = "",
    onNavigateBack: () -> Unit = {},
    viewModel: DetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

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

                    // Botones de acción
                    item {
                        Spacer(modifier = Modifier.height(16.dp))

                        // Botón Ver en JNE
                        Button(
                            onClick = {
                                IntentUtils.openUrl(context, candidato.fuenteOficial)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Primary
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Ver en JNE")
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Botón Compartir
                        OutlinedButton(
                            onClick = {
                                val shareText = IntentUtils.getCandidatoShareText(
                                    nombre = candidato.nombreCompleto,
                                    partido = candidato.partidoPolitico,
                                    cargo = if (candidato.cargo == Cargo.CONGRESO) "Congreso" else "Presidencia",
                                    denuncias = candidato.numeroDenuncias,
                                    proyectos = candidato.numeroProyectos
                                )
                                IntentUtils.shareText(context, shareText)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Compartir información")
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
            .background(Surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto del candidato (placeholder)
        Surface(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            color = Primary.copy(alpha = 0.1f)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = candidato.nombre.first().toString(),
                    style = MaterialTheme.typography.displayLarge,
                    color = Primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre completo
        Text(
            text = candidato.nombreCompleto,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Partido político
        Text(
            text = candidato.partidoPolitico,
            style = MaterialTheme.typography.titleMedium,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Chips de información básica
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Edad
            AssistChip(
                onClick = { },
                label = { Text("${candidato.edad} años") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            )

            // Cargo
            AssistChip(
                onClick = { },
                label = {
                    Text(if (candidato.cargo == Cargo.CONGRESO) "Congreso" else "Presidencia")
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Primary.copy(alpha = 0.1f),
                    labelColor = Primary
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
                                imageVector = Icons.Default.Warning,
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
                                imageVector = Icons.Default.Description,
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
            // Biografía
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

            Spacer(modifier = Modifier.height(16.dp))

            // Región
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Región: ${candidato.region}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Asistencia (si aplica)
            if (candidato.asistencia != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Secondary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Asistencia: ${candidato.asistencia}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextPrimary
                    )
                }
            }
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
                // Título con ícono
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = when (denuncia.tipo) {
                            TipoDenuncia.PENAL -> Icons.Default.Gavel
                            TipoDenuncia.ADMINISTRATIVA -> Icons.Default.AccountBalance
                            TipoDenuncia.CIVIL -> Icons.Default.Balance
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

                // Badge de estado
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

            // Descripción
            Text(
                text = denuncia.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Fecha con ícono
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
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
                // Título
                Text(
                    text = proyecto.titulo,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )

                // Badge de estado
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = when (proyecto.estado) {
                                EstadoProyecto.PRESENTADO -> "Presentado"
                                EstadoProyecto.EN_DEBATE -> "En debate"
                                EstadoProyecto.APROBADO -> "Aprobado"
                                EstadoProyecto.RECHAZADO -> "Rechazado"
                            },
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = when (proyecto.estado) {
                            EstadoProyecto.PRESENTADO -> Color(0xFFE3F2FD)
                            EstadoProyecto.EN_DEBATE -> Color(0xFFFFF3E0)
                            EstadoProyecto.APROBADO -> Secondary.copy(alpha = 0.1f)
                            EstadoProyecto.RECHAZADO -> Error.copy(alpha = 0.1f)
                        },
                        labelColor = when (proyecto.estado) {
                            EstadoProyecto.PRESENTADO -> Primary
                            EstadoProyecto.EN_DEBATE -> Color(0xFFFF6F00)
                            EstadoProyecto.APROBADO -> Secondary
                            EstadoProyecto.RECHAZADO -> Error
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción
            Text(
                text = proyecto.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Fecha
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = TextSecondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = proyecto.fecha,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
        }
    }
}