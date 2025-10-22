package com.equipo.candidatoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.equipo.candidatoinfo.navigation.AppNavigation
import com.equipo.candidatoinfo.ui.theme.CandidatoInfoTheme
import com.equipo.candidatoinfo.model.*
import com.equipo.candidatoinfo.ui.detail.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplica el tema global de la app
            CandidatoInfoTheme {
                // Surface establece el fondo con el color del tema actual
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Llama al componente principal de navegación
                    AppNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "App Completa")
@Composable
fun PreviewApp() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AppNavigation()
        }
    }
}

@Preview(showBackground = true, name = "Detalle - Keiko Fujimori")
@Composable
fun PreviewDetailScreen() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DetailScreen(
                candidateId = "candidato_1",  // ✅ ID CORRECTO
                onNavigateBack = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "Detalle - Verónika Mendoza")
@Composable
fun PreviewDetailScreen2() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DetailScreen(
                candidateId = "candidato_2",  // ✅ Otro candidato
                onNavigateBack = {}
            )
        }
    }
}

