package com.equipo.candidatoinfo.model

import androidx.annotation.DrawableRes
import com.equipo.candidatoinfo.R

data class Candidato(
    val id: String,
    val nombre: String,
    val apellido: String,
    val partidoPolitico: String,
    val cargo: Cargo,
    val region: String,
    val edad: Int,
    val biografia: String,
    @DrawableRes val fotoResId: Int = R.drawable.candidato_placeholder,
    val fotoUrl: String = "",
    val fuenteOficial: String = "https://www.jne.gob.pe",
    val denuncias: List<Denuncia> = emptyList(),
    val proyectos: List<Proyecto> = emptyList(),
    val asistencia: Int? = null
) {
    val nombreCompleto: String
        get() = "$nombre $apellido"

    val numeroDenuncias: Int
        get() = denuncias.size

    val numeroProyectos: Int
        get() = proyectos.size
}

enum class Cargo {
    CONGRESO,
    PRESIDENCIA
}