package com.equipo.candidatoinfo.ui.main
import androidx.compose.ui.tooling.preview.Preview
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.equipo.candidatoinfo.ui.theme.*
import com.equipo.candidatoinfo.util.IntentUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigateToCandidatos: () -> Unit = {},
    onNavigateToCompare: () -> Unit = {}
) {
    val context = LocalContext.current
    var showDenunciasDialog by remember { mutableStateOf(false) }
    var showProyectosDialog by remember { mutableStateOf(false) }
    var showCompartirDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "CandidatoInfo",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ===== HEADER =====
            item {
                HeaderSection()
            }

            // ===== OPCIONES PRINCIPALES =====
            item {
                Text(
                    text = "Funciones Principales",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MainOptionCard(
                        title = "Ver Candidatos",
                        icon = Icons.Default.Person,
                        description = "Lista completa de 10 candidatos",
                        onClick = onNavigateToCandidatos,
                        modifier = Modifier.weight(1f),
                        backgroundColor = Primary
                    )

                    MainOptionCard(
                        title = "Comparar",
                        icon = Icons.Default.Add,
                        description = "Compara 2 candidatos",
                        onClick = onNavigateToCompare,
                        modifier = Modifier.weight(1f),
                        backgroundColor = Secondary
                    )
                }
            }

            // ===== FUNCIONES DESTACADAS =====
            item {
                Text(
                    text = "Funciones Destacadas",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // ✅ BÚSQUEDA AVANZADA - Clickeable
            item {
                FeatureCard(
                    icon = Icons.Default.Search,
                    title = "Búsqueda Avanzada",
                    description = "Busca por nombre, partido o región",
                    onClick = onNavigateToCandidatos  // ✅ Va a HomeScreen
                )
            }

            // ✅ DENUNCIAS - Clickeable (Abre dialog)
            item {
                FeatureCard(
                    icon = Icons.Default.Warning,
                    title = "Denuncias Verificadas",
                    description = "Información de fuentes oficiales del Estado",
                    onClick = { showDenunciasDialog = true }  // ✅ Abre dialog
                )
            }

            // ✅ PROYECTOS - Clickeable (Abre dialog)
            item {
                FeatureCard(
                    icon = Icons.Default.Star,
                    title = "Proyectos de Ley",
                    description = "Propuestas presentadas por cada candidato",
                    onClick = { showProyectosDialog = true }  // ✅ Abre dialog
                )
            }

            // ✅ COMPARTIR - Clickeable (Abre sheet)
            item {
                FeatureCard(
                    icon = Icons.Default.Share,
                    title = "Compartir Información",
                    description = "Difunde datos verificados en redes sociales",
                    onClick = { showCompartirDialog = true }  // ✅ Abre dialog
                )
            }

            // ===== FUENTES OFICIALES (Con links clickeables) =====
            item {
                Text(
                    text = "Fuentes Oficiales",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                FuentesOficialesCard(
                    onFuenteClick = { url ->
                        IntentUtils.openUrl(context, url)  // ✅ Abre navegador
                    }
                )
            }

            // ===== ESTADÍSTICAS =====
            item {
                Text(
                    text = "Estadísticas",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard(
                        title = "10",
                        subtitle = "Candidatos",
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "6",
                        subtitle = "Denuncias",
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "19",
                        subtitle = "Proyectos",
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // ===== FOOTER =====
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Versión 1.0 • Elecciones 2026",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    // ===== DIALOGS =====
    if (showDenunciasDialog) {
        InfoDialog(
            title = "Denuncias Verificadas",
            description = "Todas las denuncias mostradas en esta aplicación provienen de:\n\n" +
                    "• Poder Judicial del Perú\n" +
                    "• Ministerio Público\n" +
                    "• JNE - Jurado Nacional de Elecciones\n\n" +
                    "La información es de dominio público y está actualizada a octubre 2025.",
            onDismiss = { showDenunciasDialog = false }
        )
    }

    if (showProyectosDialog) {
        InfoDialog(
            title = "Proyectos de Ley",
            description = "Los proyectos de ley mostrados incluyen:\n\n" +
                    "• Propuestas presentadas en el Congreso\n" +
                    "• Estado actual de cada proyecto\n" +
                    "• Fecha de presentación\n\n" +
                    "Información verificada del portal del Congreso de la República.",
            onDismiss = { showProyectosDialog = false }
        )
    }

    if (showCompartirDialog) {
        CompartirDialog(
            onDismiss = { showCompartirDialog = false },
            onCompartir = {
                val shareText = """
                    📱 CandidatoInfo - Transparencia Electoral 2026
                    
                    Conoce la información verificada de los 10 candidatos presidenciales:
                    • Biografía completa
                    • Denuncias judiciales
                    • Proyectos de ley
                    • Fuentes oficiales
                    
                    ¡Vota informado! 🗳️
                """.trimIndent()

                IntentUtils.shareText(context, shareText)
                showCompartirDialog = false
            }
        )
    }
}

// ===== COMPONENTES =====

@Composable
fun HeaderSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Primary.copy(alpha = 0.1f),
                            Color.White
                        )
                    )
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(80.dp),
                shape = RoundedCornerShape(16.dp),
                color = Primary.copy(alpha = 0.1f)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Logo",
                        modifier = Modifier.size(48.dp),
                        tint = Primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "CandidatoInfo",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Transparencia Electoral Perú 2026",
                style = MaterialTheme.typography.titleMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Información verificada de candidatos presidenciales",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MainOptionCard(
    title: String,
    icon: ImageVector,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Primary
) {
    Card(
        modifier = modifier
            .aspectRatio(1f)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(48.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FeatureCard(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit = {}  // ✅ Ahora es clickeable
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),  // ✅ Clickeable
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(12.dp),
                color = Primary.copy(alpha = 0.1f)
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = Primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Ver más",
                tint = TextSecondary
            )
        }
    }
}

@Composable
fun FuentesOficialesCard(
    onFuenteClick: (String) -> Unit  // ✅ Callback para abrir URLs
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Toda la información proviene de:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(12.dp))

            FuenteItem(
                emoji = "🏛️",
                text = "Jurado Nacional de Elecciones (JNE)",
                url = "https://www.jne.gob.pe",
                onClick = onFuenteClick
            )
            FuenteItem(
                emoji = "🏛️",
                text = "Congreso de la República",
                url = "https://www.congreso.gob.pe",
                onClick = onFuenteClick
            )
            FuenteItem(
                emoji = "⚖️",
                text = "Poder Judicial del Perú",
                url = "https://www.pj.gob.pe",
                onClick = onFuenteClick
            )
            FuenteItem(
                emoji = "🗳️",
                text = "ONPE - Oficina Nacional de Procesos Electorales",
                url = "https://www.onpe.gob.pe",
                onClick = onFuenteClick
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Última verificación: Octubre 2025",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }
    }
}

@Composable
fun FuenteItem(
    emoji: String,
    text: String,
    url: String,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(url) }  // ✅ Clickeable
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = emoji,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = Primary,  // ✅ Azul para indicar que es clickeable
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Abrir",
            tint = TextSecondary,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun StatCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Primary.copy(alpha = 0.1f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
    }
}

// ===== DIALOGS =====

@Composable
fun InfoDialog(
    title: String,
    description: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                tint = Primary,
                modifier = Modifier.size(32.dp)
            )
        },
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(text = description)
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Entendido")
            }
        }
    )
}

@Composable
fun CompartirDialog(
    onDismiss: () -> Unit,
    onCompartir: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = Primary,
                modifier = Modifier.size(32.dp)
            )
        },
        title = {
            Text(
                text = "Compartir CandidatoInfo",
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = "Ayuda a difundir información verificada sobre los candidatos presidenciales.\n\n" +
                        "¿Deseas compartir la aplicación?"
            )
        },
        confirmButton = {
            TextButton(onClick = onCompartir) {
                Text("Compartir")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}