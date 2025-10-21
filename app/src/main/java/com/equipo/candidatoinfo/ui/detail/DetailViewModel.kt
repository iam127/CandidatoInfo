package com.equipo.candidatoinfo.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DetailUiState(
    val candidato: Candidato? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

class DetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadCandidato(candidatoId: String) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)

                val candidato = CandidatoData.getCandidatoById(candidatoId)

                if (candidato != null) {
                    _uiState.value = _uiState.value.copy(
                        candidato = candidato,
                        isLoading = false
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Candidato no encontrado"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Error al cargar candidato: ${e.message}"
                )
            }
        }
    }
}
