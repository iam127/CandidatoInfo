
##                   - Transparencia Electoral Perú 2026




## 📱 Descripción

**CandidatoInfo** es una aplicación móvil Android que permite a los ciudadanos peruanos consultar información pública verificada sobre los 10 principales candidatos a la presidencia del Perú 2026, incluyendo:

- ✅ **Biografía y trayectoria política**
- ✅ **Denuncias y antecedentes judiciales**
- ✅ **Proyectos de ley y propuestas**
- ✅ **Enlaces directos a fuentes oficiales** (JNE, Congreso, Poder Judicial)
- ✅ **Comparación entre candidatos**
- ✅ **Búsqueda y filtros avanzados**
- ✅ **Compartir información verificada**

---


## 👥 Equipo de Desarrollo

| Rol | Nombre | Responsabilidades |
|-----|--------|-------------------|
| 🔴 Líder Técnico | Matías Galván Guerrero | Arquitectura MVVM, ViewModels, Navegación, Repository, Intents |
| 🎨 Diseñador UI/UX | Luis Enrique Galván Morales | Diseño Figma, Pantallas Compose, Animaciones, Componentes UI |
| 📚 Documentador | Wilson López | Modelos de datos, Datos verificados, Documentación, Testing |

**Docente:** Juan León S.  
**Curso:** Aplicaciones Móviles con Android  
**Institución:** Tecsup  
**Fecha:** 22 de Octubre 2025

---
## Presentación y demo
**Enlace:** https://youtu.be/7l83OjLk_WI

## 🎨 Diseño

### Prototipo Figma
**Enlace:** https://www.figma.com/proto/MIwZiduHrUCnIq8KTZ4ejq/Untitled?node-id=0-1&t=lDoomBAQN8u9P6Bn-1

**Pantallas diseñadas:**
1. **Pantalla Home** - Lista de candidatos con búsqueda y filtros
2. **Pantalla Detalle** - Información completa del candidato
3. **Pantalla Comparador** - Comparación lado a lado de candidatos
4. **Dialogs** - Selector de candidatos y menús

**Paleta de colores:**
- 🔵 Primario: #1976D2 (Azul institucional)
- 🟢 Secundario: #388E3C (Verde verificación)
- 🔴 Error: #D32F2F (Rojo alerta)
- ⚪ Fondo: #FFFFFF
- 🔳 Superficie: #F5F5F5

---

## 🛠️ Stack Tecnológico

### Lenguaje y Framework
- **Kotlin** 1.9.22
- **Jetpack Compose** - UI declarativa moderna
- **Material Design 3** - Sistema de diseño Google

### Arquitectura
- **MVVM** (Model-View-ViewModel)
- **Repository Pattern** para abstracción de datos
- **StateFlow** para manejo de estado reactivo
- **Kotlin Coroutines** para operaciones asíncronas
- **Navigation Compose** para navegación entre pantallas

### Dependencias principales
```gradle
// Compose BOM
implementation(platform("androidx.compose:compose-bom:2024.02.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.ui:ui-tooling-preview")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.7")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

// Icons
implementation("androidx.compose.material:material-icons-extended")
```

---

## 📂 Estructura del Proyecto
```
app/src/main/java/com/equipo/candidatoinfo/
├── ui/
│   ├── home/
│   │   ├── HomeScreen.kt          # Pantalla principal con lista
│   │   └── HomeViewModel.kt       # Lógica de búsqueda y filtros
│   ├── detail/
│   │   ├── DetailScreen.kt        # Detalle del candidato
│   │   └── DetailViewModel.kt     # Carga de información
│   ├── compare/
│   │   ├── CompareScreen.kt       # Comparador de candidatos
│   │   └── CompareViewModel.kt    # Lógica de comparación
│   └── theme/
│       ├── Color.kt               # Paleta de colores
│       ├── Theme.kt               # Tema Material 3
│       └── Type.kt                # Tipografía
├── model/
│   ├── Candidato.kt               # Modelo de candidato
│   ├── Denuncia.kt                # Modelo de denuncia
│   └── Proyecto.kt                # Modelo de proyecto
├── data/
│   ├── CandidatoData.kt           # Datos de 10 candidatos
│   └── CandidatoRepository.kt     # Abstracción de datos
├── navigation/
│   └── Navigation.kt              # Sistema de navegación
├── util/
│   └── IntentUtils.kt             # Utilidades para Intents
├── main/
│   └── MainScreen.kt             # Pantalla principal
└── MainActivity.kt                # Actividad principal
```

---

## ✨ Funcionalidades Implementadas


### 📱 Pantallas
- ✅ **HomeScreen**: Lista con 10 candidatos, búsqueda y filtros
- ✅ **DetailScreen**: Información completa, denuncias y proyectos
- ✅ **CompareScreen**: Comparación de 2 candidatos
- ✅ **MainScreen**: Pantalla principa

### 🔍 Búsqueda y Filtros
- ✅ Búsqueda por nombre, partido o región
- ✅ Filtro por cargo (Todos/Presidencia)
- ✅ Ordenamiento por: Nombre, Menos denuncias, Más denuncias, Más proyectos
- ✅ Contador de resultados
- ✅ Mensaje cuando no hay resultados

### 📊 Visualización de Datos
- ✅ 10 candidatos presidenciales 2026
- ✅ Biografía y trayectoria
- ✅ Denuncias con estado (En proceso/Archivado/Sentenciado)
- ✅ Proyectos con estado (Presentado/En debate/Aprobado/Rechazado)
- ✅ Badges informativos con colores
- ✅ Iconos descriptivos

### 🔗 Integración
- ✅ Intent para abrir JNE en navegador
- ✅ Compartir información por WhatsApp/Email/etc
- ✅ FAB (botón flotante) para acceso rápido al comparador
- ✅ Navegación fluida entre pantallas

### 🎨 Experiencia de Usuario
- ✅ Animaciones de entrada/salida
- ✅ Estados de carga
- ✅ Manejo de errores
- ✅ Feedback visual en todas las interacciones
- ✅ Diseño Material 3 moderno

---

## 📊 Candidatos Incluidos (Elecciones 2026)

| # |         Nombre      | Partido             | Denuncias | Proyectos |
|---|---------------------|---------------------|-----------|-----------|
| 1 | Rafael López Aliaga | Renovación Popular  | 1          | 2 |
| 2 | Keiko Fujimori      | Fuerza Popular      | 2 | 1 |
| 3 | Julio Guzmán        | Partido Morado      | 0 | 2 |
| 4 | Verónika Mendoza    | Nuevo Perú          | 0 | 3 |
| 5 | Daniel Urresti      | Podemos Perú         | 1 | 1 |
| 6 | George Forsyth      | Somos Perú          | 0 | 2 |
| 7 | Hernando de Soto    | Avanza País          | 0 | 2 |
| 8 | César Acuña         | APP                  | 1 | 2 |
| 9 | Antauro Humala      | A.N.T.A.U.R.O       | 1 | 2 |
| 10 | Yonhy Lescano      | Acción Popular      | 0 | 2 |

**Total:** 10 candidatos | 6 denuncias | 19 propuestas

---

## 🔗 Fuentes Oficiales Verificadas

Toda la información fue verificada en:

- **JNE** - Jurado Nacional de Elecciones: https://www.jne.gob.pe
- **Congreso de la República**: https://www.congreso.gob.pe
- **Poder Judicial del Perú**: https://www.pj.gob.pe
- **ONPE** - Oficina Nacional de Procesos Electorales: https://www.onpe.gob.pe

**Última verificación:** 22 de Octubre 2025

---

## 🚀 Instalación y Ejecución

### Requisitos
- **Android Studio** Hedgehog (2023.1.1) o superior
- **JDK** 17 o superior
- **Emulador Android** o dispositivo físico (API 24+)
- **Gradle** 8.0+

### Pasos

1. **Clonar el repositorio:**
```bash
git clone https://github.com/iam127/CandidatoInfo.git
cd CandidatoInfo
```

2. **Abrir en Android Studio:**
```
File → Open → Seleccionar carpeta CandidatoInfo
```

3. **Sincronizar dependencias:**
```
Gradle Sync automático
o
Tools → Android → Sync Project with Gradle Files
```

4. **Ejecutar la aplicación:**
```
Run → Run 'app' (Shift + F10)
o
Click en el botón ▶️
```

---

## 🧪 Testing

### Pruebas Manuales Realizadas
- ✅ Búsqueda por nombre, partido y región
- ✅ Filtros por cargo
- ✅ Ordenamiento por diferentes criterios
- ✅ Navegación entre todas las pantallas
- ✅ Intent para abrir URLs
- ✅ Compartir información
- ✅ Selector de candidatos en comparador
- ✅ Estados de carga y errores
- ✅ Animaciones y transiciones

**Ver:** [TESTING.md](./TESTING.md) para reporte completo

### Cobertura
- ✅ 100% de funcionalidades implementadas
- ✅ 0 crashes detectados
- ✅ Navegación sin errores
- ✅ Datos verificados

---

## 📸 Capturas de Pantalla

### Pantalla Home

<img width="414" height="929" alt="image" src="https://github.com/user-attachments/assets/10dd5f7c-4b33-42c1-9c75-d97a5b6f946f" />

### Pantalla Detalle

<img width="417" height="929" alt="image" src="https://github.com/user-attachments/assets/7f07a08f-1491-492f-9b37-f10101c6f3ed" />

### Pantalla Comparador

<img width="411" height="928" alt="image" src="https://github.com/user-attachments/assets/9756fb2a-b88d-4051-9e00-3fbc8466004b" />

---

## 🎯 Cumplimiento de Requerimientos

### ✅ Día 1-2: Base
- [x] RF01-RF05: Investigación, diseño Figma y GitHub

### ✅ Día 2: Estructura
- [x] RF06-RF10: Proyecto Android con navegación

### ✅ Día 3: UI
- [x] RF11-RF15: Pantallas completas Material 3

### ✅ Día 4: Lógica
- [x] RF16-RF20: ViewModels y Repository

### ✅ Día 5: Funcionalidades
- [x] RF21-RF25: Búsqueda, comparador e intents

### ✅ Día 6: Documentación
- [x] RF26-RF30: README, testing y v1.0

**Cumplimiento: 100%** ✅

---

## 📚 Documentación Adicional

- [FUENTES_DATOS.md](./FUENTES_DATOS.md) - Información sobre fuentes oficiales
- [VIEWMODELS.md](./VIEWMODELS.md) - Guía de arquitectura MVVM
- [TESTING.md](./TESTING.md) - Reporte de pruebas

---

**Versión:** v1.0  
**Fecha:** 22 de Octubre 2025  
**Estado:** ✅ Completado y listo para presentación

---


