package com.equipo.candidatoinfo.ui.compare

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class CompareUiState(
    val allCandidatos: List<Candidato> = emptyList(),
    val selectedCandidato1: Candidato? = null,
    val selectedCandidato2: Candidato? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

class CompareViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CompareUiState())
    val uiState: StateFlow<CompareUiState> = _uiState.asStateFlow()

    init {
        loadCandidatos()
    }

    private fun loadCandidatos() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)

                val candidatos = CandidatoData.getCandidatosEjemplo()

                // Por defecto, seleccionar los 2 primeros
                _uiState.value = _uiState.value.copy(
                    allCandidatos = candidatos,
                    selectedCandidato1 = candidatos.getOrNull(0),
                    selectedCandidato2 = candidatos.getOrNull(1),
                    isLoading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Error al cargar candidatos: ${e.message}"
                )
            }
        }
    }

    fun selectCandidato1(candidato: Candidato) {
        _uiState.value = _uiState.value.copy(selectedCandidato1 = candidato)
    }

    fun selectCandidato2(candidato: Candidato) {
        _uiState.value = _uiState.value.copy(selectedCandidato2 = candidato)
    }
}
