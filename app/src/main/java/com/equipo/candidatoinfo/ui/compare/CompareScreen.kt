package com.equipo.candidatoinfo.ui.compare

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompareScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToDetail: (String) -> Unit = {},
    viewModel: CompareViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showSelector1 by remember { mutableStateOf(false) }
    var showSelector2 by remember { mutableStateOf(false) }

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
            uiState.selectedCandidato1 != null && uiState.selectedCandidato2 != null -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    // Selectores de candidatos
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CandidatoSelector(
                                candidato = uiState.selectedCandidato1!!,
                                onClick = { showSelector1 = true },
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            CandidatoSelector(
                                candidato = uiState.selectedCandidato2!!,
                                onClick = { showSelector2 = true },
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }

                    // Comparación de denuncias
                    item {
                        CompareRow(
                            label = "Denuncias",
                            value1 = uiState.selectedCandidato1!!.numeroDenuncias.toString(),
                            value2 = uiState.selectedCandidato2!!.numeroDenuncias.toString(),
                            highlightLower = true
                        )
                    }

                    // Comparación de proyectos
                    item {
                        CompareRow(
                            label = "Proyectos",
                            value1 = uiState.selectedCandidato1!!.numeroProyectos.toString(),
                            value2 = uiState.selectedCandidato2!!.numeroProyectos.toString(),
                            highlightLower = false
                        )
                    }

                    // Comparación de asistencia
                    if (uiState.selectedCandidato1!!.asistencia != null &&
                        uiState.selectedCandidato2!!.asistencia != null) {
                        item {
                            CompareRow(
                                label = "Asistencia",
                                value1 = "${uiState.selectedCandidato1!!.asistencia}%",
                                value2 = "${uiState.selectedCandidato2!!.asistencia}%",
                                highlightLower = false
                            )
                        }
                    }

                    // Comparación de edad
                    item {
                        CompareRow(
                            label = "Edad",
                            value1 = "${uiState.selectedCandidato1!!.edad} años",
                            value2 = "${uiState.selectedCandidato2!!.edad} años",
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
                                onClick = { onNavigateToDetail(uiState.selectedCandidato1!!.id) },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Ver perfil")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            OutlinedButton(
                                onClick = { onNavigateToDetail(uiState.selectedCandidato2!!.id) },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Ver perfil")
                            }
                        }
                    }
                }
            }
        }
    }

    // Dialog para seleccionar Candidato 1
    if (showSelector1) {
        CandidatoSelectorDialog(
            candidatos = uiState.allCandidatos,
            onDismiss = { showSelector1 = false },
            onSelect = {
                viewModel.selectCandidato1(it)
                showSelector1 = false
            }
        )
    }

    // Dialog para seleccionar Candidato 2
    if (showSelector2) {
        CandidatoSelectorDialog(
            candidatos = uiState.allCandidatos,
            onDismiss = { showSelector2 = false },
            onSelect = {
                viewModel.selectCandidato2(it)
                showSelector2 = false
            }
        )
    }
}

@Composable
fun CandidatoSelector(
    candidato: Candidato,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
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
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = candidato.partidoPolitico,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = TextSecondary,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cambiar",
                    style = MaterialTheme.typography.labelSmall,
                    color = Primary
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Cambiar",
                    tint = Primary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatoSelectorDialog(
    candidatos: List<Candidato>,
    onDismiss: () -> Unit,
    onSelect: (Candidato) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Seleccionar Candidato") },
        text = {
            LazyColumn {
                items(candidatos.size) { index ->
                    val candidato = candidatos[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { onSelect(candidato) }
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape),
                                color = Surface
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = candidato.nombre.first().toString(),
                                        style = MaterialTheme.typography.titleMedium,
                                        color = Primary
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = candidato.nombreCompleto,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = candidato.partidoPolitico,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
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
