package com.equipo.candidatoinfo.model

data class Denuncia(
    val id: String = "",  // ✅ AGREGAR VALOR POR DEFECTO
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val estado: EstadoDenuncia,
    val tipo: TipoDenuncia,
    val fuenteUrl: String = ""  // ✅ AGREGAR VALOR POR DEFECTO
)

enum class EstadoDenuncia {
    EN_PROCESO,
    ARCHIVADO,
    SENTENCIADO
}

enum class TipoDenuncia {
    PENAL,
    ADMINISTRATIVA,
    CIVIL
}