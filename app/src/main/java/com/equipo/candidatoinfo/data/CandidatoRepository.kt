package com.equipo.candidatoinfo.data

import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.model.Cargo
import kotlinx.coroutines.delay

/**
 * Repositorio para manejar los datos de candidatos
 * En el futuro, esto podría conectarse a una API real
 */
class CandidatoRepository {

    /**
     * Obtener todos los candidatos
     * Simula una llamada a API con delay
     */
    suspend fun getCandidatos(): List<Candidato> {
        // Simular latencia de red
        delay(500)
        return CandidatoData.getCandidatosEjemplo()
    }

    /**
     * Obtener un candidato por ID
     */
    suspend fun getCandidatoById(id: String): Candidato? {
        delay(300)
        return CandidatoData.getCandidatoById(id)
    }

    /**
     * Buscar candidatos por nombre o partido
     */
    suspend fun searchCandidatos(query: String): List<Candidato> {
        delay(400)
        return CandidatoData.getCandidatosEjemplo().filter {
            it.nombreCompleto.contains(query, ignoreCase = true) ||
                    it.partidoPolitico.contains(query, ignoreCase = true) ||
                    it.region.contains(query, ignoreCase = true)
        }
    }

    /**
     * Filtrar candidatos por cargo
     */
    suspend fun getCandidatosByCargo(cargo: Cargo): List<Candidato> {
        delay(300)
        return CandidatoData.getCandidatosPorCargo(cargo)
    }

    /**
     * Filtrar candidatos por partido
     */
    suspend fun getCandidatosByPartido(partido: String): List<Candidato> {
        delay(300)
        return CandidatoData.getCandidatosPorPartido(partido)
    }

    /**
     * Filtrar candidatos por región
     */
    suspend fun getCandidatosByRegion(region: String): List<Candidato> {
        delay(300)
        return CandidatoData.getCandidatosPorRegion(region)
    }

    companion object {
        @Volatile
        private var instance: CandidatoRepository? = null

        fun getInstance(): CandidatoRepository {
            return instance ?: synchronized(this) {
                instance ?: CandidatoRepository().also { instance = it }
            }
        }
    }
}
