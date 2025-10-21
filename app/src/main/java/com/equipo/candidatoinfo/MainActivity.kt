package com.equipo.candidatoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.equipo.candidatoinfo.navigation.AppNavigation
import com.equipo.candidatoinfo.ui.compare.CompareScreen
import com.equipo.candidatoinfo.ui.detail.DetailScreen
import com.equipo.candidatoinfo.ui.theme.CandidatoInfoTheme

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

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AppNavigation()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            DetailScreen(
                candidateId = "1", // Usa un ID válido de tu CandidatoData
                onNavigateBack = {} // Función vacía para el preview
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCompareScreen() {
    CandidatoInfoTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            CompareScreen(
                onNavigateBack = {} // Función vacía para el preview
            )
        }
    }
}