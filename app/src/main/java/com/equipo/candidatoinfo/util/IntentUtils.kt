package com.equipo.candidatoinfo.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object IntentUtils {

    /**
     * Abre una URL en el navegador
     */
    fun openUrl(context: Context, url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "No se puede abrir el enlace",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    /**
     * Comparte texto usando el selector de Android
     */
    fun shareText(context: Context, text: String, title: String = "Compartir") {
        try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }
            context.startActivity(Intent.createChooser(intent, title))
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "No se puede compartir",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    /**
     * Genera texto para compartir información de un candidato
     */
    fun getCandidatoShareText(
        nombre: String,
        partido: String,
        cargo: String,
        denuncias: Int,
        proyectos: Int
    ): String {
        return """
            📊 CandidatoInfo - Transparencia Electoral
            
            👤 $nombre
            🏛️ $partido
            📋 Cargo: $cargo
            ⚠️ Denuncias: $denuncias
            📄 Proyectos: $proyectos
            
            #TransparenciaElectoral #PerúElecciones
        """.trimIndent()
    }
}
