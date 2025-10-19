package com.equipo.candidatoinfo.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.model.Cargo
import com.equipo.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail: (String) -> Unit = {},
    onNavigateToCompare: () -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }
    val candidatos = CandidatoData.getCandidatosEjemplo()

    val filteredCandidatos = remember(searchText, candidatos) {
        if (searchText.isEmpty()) {
            candidatos
        } else {
            candidatos.filter {
                it.nombreCompleto.contains(searchText, ignoreCase = true) ||
                        it.partidoPolitico.contains(searchText, ignoreCase = true)
            }
        }
    }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Barra de búsqueda
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Buscar candidato...") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Buscar")
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Primary,
                    focusedLeadingIconColor = Primary
                )
            )

            // Lista de candidatos
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredCandidatos) { candidato ->
                    CandidatoCard(
                        candidato = candidato,
                        onClick = { onNavigateToDetail(candidato.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun CandidatoCard(
    candidato: Candidato,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto del candidato (placeholder)
            Surface(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                color = Surface
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = candidato.nombre.first().toString(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = Primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Información del candidato
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = candidato.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = candidato.partidoPolitico,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Badge del cargo
                    AssistChip(
                        onClick = { },
                        label = {
                            Text(
                                text = if (candidato.cargo == Cargo.CONGRESO) "Congreso" else "Presidencia",
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Primary.copy(alpha = 0.1f),
                            labelColor = Primary
                        )
                    )

                    // Badge de denuncias (si tiene)
                    if (candidato.numeroDenuncias > 0) {
                        AssistChip(
                            onClick = { },
                            label = {
                                Text(
                                    text = "${candidato.numeroDenuncias} denuncia${if (candidato.numeroDenuncias > 1) "s" else ""}",
                                    style = MaterialTheme.typography.labelSmall
                                )
                            },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Error.copy(alpha = 0.1f),
                                labelColor = Error
                            )
                        )
                    }
                }
            }
        }
    }
}
