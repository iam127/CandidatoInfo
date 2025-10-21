package com.equipo.candidatoinfo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equipo.candidatoinfo.data.CandidatoData
import com.equipo.candidatoinfo.model.Candidato
import com.equipo.candidatoinfo.model.Cargo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeUiState(
    val candidatos: List<Candidato> = emptyList(),
    val filteredCandidatos: List<Candidato> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = true,
    val error: String? = null,
    val selectedFilter: FilterOption = FilterOption.TODOS
)

enum class FilterOption {
    TODOS,
    CONGRESO,
    PRESIDENCIA
}

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCandidatos()
    }

    private fun loadCandidatos() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)

                // Simular carga de datos
                val candidatos = CandidatoData.getCandidatosEjemplo()

                _uiState.value = _uiState.value.copy(
                    candidatos = candidatos,
                    filteredCandidatos = candidatos,
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

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        filterCandidatos()
    }

    fun onFilterChange(filter: FilterOption) {
        _uiState.value = _uiState.value.copy(selectedFilter = filter)
        filterCandidatos()
    }

    private fun filterCandidatos() {
        val query = _uiState.value.searchQuery
        val filter = _uiState.value.selectedFilter
        val allCandidatos = _uiState.value.candidatos

        val filtered = allCandidatos.filter { candidato ->
            // Filtro por búsqueda
            val matchesSearch = if (query.isEmpty()) {
                true
            } else {
                candidato.nombreCompleto.contains(query, ignoreCase = true) ||
                        candidato.partidoPolitico.contains(query, ignoreCase = true) ||
                        candidato.region.contains(query, ignoreCase = true)
            }

            // Filtro por cargo
            val matchesFilter = when (filter) {
                FilterOption.TODOS -> true
                FilterOption.CONGRESO -> candidato.cargo == Cargo.CONGRESO
                FilterOption.PRESIDENCIA -> candidato.cargo == Cargo.PRESIDENCIA
            }

            matchesSearch && matchesFilter
        }

        _uiState.value = _uiState.value.copy(filteredCandidatos = filtered)
    }

    fun clearSearch() {
        _uiState.value = _uiState.value.copy(searchQuery = "")
        filterCandidatos()
    }
}
