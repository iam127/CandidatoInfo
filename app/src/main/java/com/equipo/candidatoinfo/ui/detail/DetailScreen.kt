@file:OptIn(ExperimentalMaterial3Api::class)

package com.equipo.candidatoinfo.ui.detail

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.equipo.candidatoinfo.model.*
import com.equipo.candidatoinfo.ui.theme.*
import com.equipo.candidatoinfo.util.IntentUtils

@Composable
fun DetailScreen(
    candidateId: String = "",
    onNavigateBack: () -> Unit = {},
    viewModel: DetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

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
                DetailScreenContent(
                    candidato = candidato,
                    paddingValues = paddingValues,
                    context = context
                )
            }
        }
    }
}

@Composable
fun DetailScreenContent(
    candidato: Candidato,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    context: android.content.Context = LocalContext.current
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        item {
            CandidatoHeader(candidato)
        }

        item {
            SectionTitle("Información Personal")
            InformacionPersonalCard(candidato)
        }

        if (candidato.denuncias.isNotEmpty()) {
            item {
                SectionTitle("Denuncias y Antecedentes")
            }
            items(candidato.denuncias) { denuncia ->
                DenunciaCard(denuncia)
            }
        }

        if (candidato.proyectos.isNotEmpty()) {
            item {
                SectionTitle("Proyectos Presentados")
            }
            items(candidato.proyectos) { proyecto ->
                ProyectoCard(proyecto)
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

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
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Ver en JNE")
            }

            Spacer(modifier = Modifier.height(8.dp))

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

@Composable
fun CandidatoHeader(candidato: Candidato) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = candidato.fotoResId),
            contentDescription = "Foto de ${candidato.nombreCompleto}",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = candidato.nombreCompleto,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = candidato.partidoPolitico,
            style = MaterialTheme.typography.titleMedium,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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

            if (candidato.numeroProyectos > 0) {
                AssistChip(
                    onClick = { },
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
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

            Spacer(modifier = Modifier.height(16.dp))

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

            if (candidato.asistencia != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
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
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
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
                    imageVector = Icons.Default.DateRange,
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
                            EstadoProyecto.PRESENTADO -> Color(0xFFE3F2FD)
                            EstadoProyecto.EN_DEBATE -> Color(0xFFFFF3E0)
                            EstadoProyecto.APROBADO -> Secondary.copy(alpha = 0.1f)
                            EstadoProyecto.RECHAZADO -> Error.copy(alpha = 0.1f)
                            EstadoProyecto.ARCHIVADO -> Surface
                        },
                        labelColor = when (proyecto.estado) {
                            EstadoProyecto.PRESENTADO -> Primary
                            EstadoProyecto.EN_DEBATE -> Color(0xFFFF6F00)
                            EstadoProyecto.APROBADO -> Secondary
                            EstadoProyecto.RECHAZADO -> Error
                            EstadoProyecto.ARCHIVADO -> TextSecondary
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

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
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
// ✅ ============ PREVIEWS ============ ✅
@Preview(showBackground = true, name = "Perfil Completo - Keiko Fujimori")
@Composable
fun PreviewDetailScreenComplete() {
    CandidatoInfoTheme {
        val candidato = Candidato(
            id = "candidato_1",
            nombre = "Keiko",
            apellido = "Fujimori",
            edad = 48,
            partidoPolitico = "Fuerza Popular",
            cargo = Cargo.CONGRESO,
            region = "Lima",
            biografia = "Política peruana, hija del expresidente Alberto Fujimori. Lideró Fuerza Popular y ha sido candidata presidencial en tres ocasiones.",
            denuncias = listOf(
                Denuncia(
                    titulo = "Caso Odebrecht",
                    descripcion = "Investigación por presunto lavado de activos relacionado con aportes de Odebrecht a su campaña electoral.",
                    fecha = "2018",
                    tipo = TipoDenuncia.PENAL,
                    estado = EstadoDenuncia.EN_PROCESO
                ),
                Denuncia(
                    titulo = "Obstrucción a la justicia",
                    descripcion = "Acusación por presunta obstrucción a la justicia en el marco del caso Odebrecht.",
                    fecha = "2020",
                    tipo = TipoDenuncia.PENAL,
                    estado = EstadoDenuncia.EN_PROCESO
                )
            ),
            proyectos = emptyList(),
            asistencia = 85
        )
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Perfil") },
                    navigationIcon = {
                        IconButton(onClick = {}) {
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
        ) { padding ->
            DetailScreenContent(candidato = candidato, paddingValues = padding)
        }
    }
}
@Preview(showBackground = true, name = "Header del Candidato")
@Composable
fun PreviewCandidatoHeader() {
    CandidatoInfoTheme {
        CandidatoHeader(
            candidato = Candidato(
                id = "1",
                nombre = "Verónika",
                apellido = "Mendoza",
                edad = 43,
                partidoPolitico = "Juntos por el Perú",
                cargo = Cargo.CONGRESO,
                region = "Cusco",
                biografia = "Psicóloga y política peruana.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Ley de Consulta Previa",
                        descripcion = "Proyecto para fortalecer el derecho de consulta previa.",
                        fecha = "2019",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                asistencia = 92
            )
        )
    }
}
@Preview(showBackground = true, name = "Card de Denuncia")
@Composable
fun PreviewDenunciaCard() {
    CandidatoInfoTheme {
        DenunciaCard(
            denuncia = Denuncia(
                titulo = "Caso Odebrecht",
                descripcion = "Investigación por presunto lavado de activos relacionado con aportes de Odebrecht a su campaña electoral.",
                fecha = "2018",
                tipo = TipoDenuncia.PENAL,
                estado = EstadoDenuncia.EN_PROCESO
            )
        )
    }
}
@Preview(showBackground = true, name = "Card de Proyecto")
@Composable
fun PreviewProyectoCard() {
    CandidatoInfoTheme {
        ProyectoCard(
            proyecto = Proyecto(
                titulo = "Ley de Protección Animal",
                descripcion = "Iniciativa para proteger los derechos de los animales en el país.",
                fecha = "2020",
                estado = EstadoProyecto.APROBADO
            )
        )
    }
}
