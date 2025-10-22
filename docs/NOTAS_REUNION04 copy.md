# Día 4 – Lógica y Manejo de Datos

## 🎯 Objetivo

Integrar ViewModels para gestionar el estado y la lógica de negocio, implementar el patrón Repository, y conectar la interfaz de usuario con flujos de datos reactivos utilizando StateFlow y Coroutines.

## ⚙️ Implementación

### ViewModels

Se desarrollaron tres ViewModels siguiendo el patrón MVVM:

- **HomeViewModel**: Gestiona la búsqueda, filtros y listado de candidatos
- **DetailViewModel**: Maneja la carga y presentación de datos individuales
- **CompareViewModel**: Facilita la comparación de métricas entre candidatos

Cada ViewModel utiliza StateFlow para mantener la reactividad del estado en la interfaz.

### Repository Pattern

Se implementó `CandidatoRepository` para centralizar el acceso a datos, simulando llamadas asíncronas mediante `delay()` y obteniendo información desde `CandidatoData`.

### Actualización de UI

- **HomeScreen**: Consume datos reactivos desde `HomeViewModel`
- **DetailScreen**: Se conecta con `DetailViewModel` para renderizar información dinámica
- **CompareScreen**: Incorpora un selector interactivo de candidatos

## 🧱 Estructura del Proyecto

```
app/
├── ui/
│   ├── home/
│   │   ├── HomeScreen.kt
│   │   └── HomeViewModel.kt
│   ├── detail/
│   │   ├── DetailScreen.kt
│   │   └── DetailViewModel.kt
│   └── compare/
│       ├── CompareScreen.kt
│       └── CompareViewModel.kt
├── data/
│   ├── CandidatoData.kt
│   └── CandidatoRepository.kt
├── model/
│   ├── Candidato.kt
│   ├── Denuncia.kt
│   └── Proyecto.kt
└── navigation/
    └── Navigation.kt
```

## 🧠 Conceptos Clave

- **MVVM**: Separación clara entre interfaz de usuario y lógica de negocio
- **StateFlow**: Actualización automática de la UI ante cambios en el ViewModel
- **Repository Pattern**: Abstracción del acceso a datos para facilitar escalabilidad
- **Buenas prácticas en Compose**:
  - Separación de lógica de los Composables
  - Inmutabilidad del estado mediante `copy()`

## 📊 Estado de Componentes

| Componente                      | Estado |          Descripción                       |
|---------------------------------|--------|--------------------------------------------|
| HomeViewModel                   | ✅     | Búsqueda y filtros implementados          |
| DetailViewModel                 | ✅     | Carga dinámica de datos por ID            |
| CompareViewModel                | ✅     | Comparación con selector interactivo      |
| CandidatoRepository             | ✅     | Simulación de API y obtención de datos    |
| Pantallas (Home/Detail/Compare) | ✅     | Conectadas a sus ViewModels respectivos   |
| Documentación técnica           | ✅     | `FUENTES_DATOS.md` y `README.md`      |

## 📝 Documentación

Se generó documentación técnica completa:
- Actualización de `FUENTES_DATOS.md` con arquitectura MVVM
- Creación de `README.md` con guías de uso y buenas prácticas

---

**Nota**: Este proyecto implementa una arquitectura MVVM robusta y escalable, preparada para la integración futura con APIs reales.