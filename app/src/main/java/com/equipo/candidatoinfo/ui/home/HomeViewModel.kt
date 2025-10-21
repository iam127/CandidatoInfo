package com.equipo.candidatoinfo.ui.home

kotlindata class HomeUiState(
    val candidatos: List<Candidato> = emptyList(),           // Todos los candidatos
    val filteredCandidatos: List<Candidato> = emptyList(),   // Candidatos filtrados
    val searchQuery: String = "",                            // Texto de búsqueda
    val isLoading: Boolean = true,                           // Estado de carga
    val error: String? = null,                               // Mensaje de error
    val selectedFilter: FilterOption = FilterOption.TODOS    // Filtro seleccionado
)
Funciones públicas:

onSearchQueryChange(query: String) - Actualizar búsqueda
onFilterChange(filter: FilterOption) - Cambiar filtro
clearSearch() - Limpiar búsqueda

Ejemplo de uso:
kotlin@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Usar estado
    if (uiState.isLoading) {
        CircularProgressIndicator()
    }

    // Actualizar estado
    TextField(
        value = uiState.searchQuery,
        onValueChange = { viewModel.onSearchQueryChange(it) }
    )
}
