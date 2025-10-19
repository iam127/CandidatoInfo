package com.equipo.candidatoinfo.ui.compare

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompareScreen(
    onNavigateBack: () -> Unit = {}
) {
    // Para el Día 3, usaremos 2 candidatos fijos para demostración
    val candidatos = CandidatoData.getCandidatosEjemplo()
    val candidato1 = candidatos.getOrNull(0)
    val candidato2 = candidatos.getOrNull(1)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comparar Candidatos") },
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
        if (candidato1 != null && candidato2 != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Headers de candidatos
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CandidatoCompareHeader(candidato1, Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(16.dp))
                        CandidatoCompareHeader(candidato2, Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                // Comparación de denuncias
                item {
                    CompareRow(
                        label = "Denuncias",
                        value1 = candidato1.numeroDenuncias.toString(),
                        value2 = candidato2.numeroDenuncias.toString(),
                        highlightLower = true
                    )
                }

                // Comparación de proyectos
                item {
                    CompareRow(
                        label = "Proyectos",
                        value1 = candidato1.numeroProyectos.toString(),
                        value2 = candidato2.numeroProyectos.toString(),
                        highlightLower = false
                    )
                }

                // Comparación de asistencia
                if (candidato1.asistencia != null && candidato2.asistencia != null) {
                    item {
                        CompareRow(
                            label = "Asistencia",
                            value1 = "${candidato1.asistencia}%",
                            value2 = "${candidato2.asistencia}%",
                            highlightLower = false
                        )
                    }
                }

                // Comparación de edad
                item {
                    CompareRow(
                        label = "Edad",
                        value1 = "${candidato1.edad} años",
                        value2 = "${candidato2.edad} años",
                        highlightLower = false
                    )
                }

                // Botones para ver perfiles completos
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        OutlinedButton(
                            onClick = { /* TODO: Navegar a detalle */ },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Ver perfil")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        OutlinedButton(
                            onClick = { /* TODO: Navegar a detalle */ },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Ver perfil")
                        }
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Selecciona candidatos para comparar")
            }
        }
    }
}

@Composable
fun CandidatoCompareHeader(
    candidato: Candidato,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            color = Surface
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = candidato.nombre.first().toString(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Primary
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = candidato.nombreCompleto,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = candidato.partidoPolitico,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = TextSecondary
        )
    }
}

@Composable
fun CompareRow(
    label: String,
    value1: String,
    value2: String,
    highlightLower: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Valor 1
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value1,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (highlightLower && value1.toIntOrNull() ?: 0 < value2.toIntOrNull() ?: 0)
                        Secondary else TextPrimary
                )
            }

            // Label central
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )
            }

            // Valor 2
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = value2,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (highlightLower && value2.toIntOrNull() ?: 0 < value1.toIntOrNull() ?: 0)
                        Secondary else TextPrimary
                )
            }
        }
    }
}
