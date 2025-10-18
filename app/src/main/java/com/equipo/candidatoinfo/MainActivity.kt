package com.equipo.candidatoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.equipo.candidatoinfo.navigation.AppNavigation
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
