package com.equipo.candidatoinfo.model

data class Proyecto(
    val id: String,
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val estado: EstadoProyecto,
    val fuenteUrl: String
)

enum class EstadoProyecto {
    PRESENTADO,
    EN_DEBATE,
    APROBADO,
    RECHAZADO,
    ARCHIVADO
}
