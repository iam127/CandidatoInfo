# 🇵🇪 PROYECTO: CANDIDATOINFO  
### Aplicación Móvil – Transparencia Electoral Ciudadana  

**Curso:** Aplicaciones Móviles con Android – TECSUP 2025-II

**Docente:** Juan León S.  


**Integrantes:**  
- 🎯 Matías Galván – Líder Técnico  
- 🎨 Luis Galván – Diseñador UI/UX  
- 📝 Wilson López – Documentador / Tester  



## 🧾 DESCRIPCIÓN GENERAL

**CandidatoInfo** es una aplicación móvil que promueve la transparencia electoral en el Perú.  
Permite consultar información pública y verificada de candidatos al Congreso y Presidencia, incluyendo denuncias, proyectos de ley, historial político y enlaces oficiales.

---

## 👥 EQUIPO DE TRABAJO

| Rol                | Nombre        |             Rama       |          Responsabilidad                             |
|--------------------|---------------|------------------------|------------------------------------------------------|
| 🎯 Líder Técnico   | Matías Galván | `feature/matias-setup` | Configuración del proyecto, navegación e integración |
| 🎨 Diseñador UI/UX | Luis Galván   | `feature/luis-ui-design` | Diseño en Figma y pantallas Compose |
| 📝 Documentador / Tester | Wilson López | `feature/wilson-documentation` | Investigación de fuentes, modelos de datos y documentación |

---

## 📦 REQUISITOS PREVIOS

- ✅ Cuenta de GitHub  
- ✅ Git instalado → `git --version`  
- ✅ Android Studio instalado  
Descarga Git: [https://git-scm.com/downloads]

---

## ⚙️ CONFIGURACIÓN INICIAL DE GIT

```bash
git config --global user.name  "Tu Nombre Completo"
git config --global user.email "tu-correo@ejemplo.com"

##🌿 ESTRUCTURA DE RAMAS DEL PROYECTO

main        → versión estable (producción)
develop     → integración principal
feature/matias-setup
feature/luis-ui-design
feature/wilson-documentation

### 🧠 COMANDOS GIT BÁSICOS
git status              # Estado actual
git add .               # Agregar cambios
git commit -m "msg"     # Guardar cambios
git push origin rama    # Subir al repositorio
git pull origin develop # Traer últimos cambios
git merge develop        # Integrar develop
git log --oneline        # Ver historial resumido

🚀 Instalación y Ejecución
Requisitos

Android Studio Hedgehog (2023.1.1) o superior
JDK 17 o superior
Emulador Android o dispositivo físico (API 24+)

 #pasos a seguir

Clonar el repositorio:

bashgit clone https://github.com/iam127/CandidatoInfo.git
cd CandidatoInfo
```

2. **Abrir en Android Studio:**
```
File → Open → Seleccionar carpeta CandidatoInfo
```

3. **Sincronizar dependencias:**
```
Gradle Sync automático o Tools → Android → Sync Project with Gradle Files
```

4. **Ejecutar la aplicación:**
```
Run → Run 'app' (Shift + F10)
```

---


## 🎨 Diseño

### Prototipo Figma
**Enlace:** https://www.figma.com/proto/MIwZiduHrUCnIq8KTZ4ejq/Untitled?node-id=0-1&t=lDoomBAQN8u9P6Bn-1

### Pantallas diseñadas:
1. **Home/Búsqueda** - Lista de candidatos con filtros
2. **Detalle del Candidato** - Información completa
3. **Comparador** - Comparación lado a lado
4. **Selector de candidatos** - Dialog interactivo

---

## 🛠️ Stack Tecnológico

### Lenguaje y Framework
- **Kotlin** 1.9+
- **Jetpack Compose** - UI declarativa
- **Material Design 3** - Sistema de diseño

### Arquitectura
- **MVVM** (Model-View-ViewModel)
- **Repository Pattern**
- **StateFlow** para manejo de estado
- **Kotlin Coroutines** para operaciones asíncronas

### Dependencias principales
```gradle
// Compose BOM
implementation(platform("androidx.compose:compose-bom:2024.02.00"))

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.7")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
```

---

## 📂 Estructura del Proyecto
app/src/main/java/com/equipo/candidatoinfo/
├── ui/
│   ├── home/
│   │   ├── HomeScreen.kt
│   │   └── HomeViewModel.kt
│   ├── detail/
│   │   ├── DetailScreen.kt
│   │   └── DetailViewModel.kt
│   ├── compare/
│   │   ├── CompareScreen.kt
│   │   └── CompareViewModel.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
├── model/
│   ├── Candidato.kt
│   ├── Denuncia.kt
│   └── Proyecto.kt
├── data/
│   ├── CandidatoData.kt
│   └── CandidatoRepository.kt
├── navigation/
│   └── Navigation.kt
├── util/
│   └── IntentUtils.kt
└── MainActivity.kt

### Pruebas realizadas

**HomeScreen:**
- ✅ Lista muestra 10 candidatos
- ✅ Búsqueda funciona correctamente
- ✅ Filtros por cargo funcionan
- ✅ Ordenamiento funcional
- ✅ FAB aparece cuando hay 2+ candidatos

**DetailScreen:**
- ✅ Muestra información completa
- ✅ Denuncias con estados correctos
- ✅ Proyectos con colores apropiados
- ✅ Botón "Ver en JNE" abre navegador
- ✅ Botón "Compartir" funciona

**CompareScreen:**
- ✅ Selector de candidatos funcional
- ✅ Comparación de métricas correcta
- ✅ Navegación a detalles funciona

**Navegación:**
- ✅ Home ↔ Detail funciona
- ✅ Home ↔ Compare funciona
- ✅ Compare → Detail funciona
- ✅ Botones "Volver" funcionan


## 📸 Capturas de Pantalla

### HomeScreen
*Lista de candidatos con búsqueda y filtros*

### DetailScreen
*Información detallada con denuncias y proyectos*

### CompareScreen
*Comparación lado a lado de candidatos*

---


## 📚 Documentación por Día
__________________________________________________________________________________________________________________________________
| Día       |      Descripción |                                                                                         

🗓️ Día 1  Configuración inicial, estructura Git, definición de roles y fuentes oficiales | [Ver Día 1](./docs/NOTAS_REUNION01.md) 
🗓️ Día 2  Creación del proyecto en Android Studio y estructura base en Kotlin + Compose | [Ver Día 2](./docs/NOTAS_REUNION02.md)

🗓️ Día 3  Actualizacions de los archivos par el buen funcionamiento del proyecto | [Ver Día 3](./docs/NOTAS_REUNION03.md) |

🗓️ Día 4  Lógica y Manejo de Datos | [Ver Día 4](./docs/NOTAS_REUNION04.md) |
🗓️ Día 5  prueba de la aplicacion | [Ver Día 5](./docs/NOTAS_REUNION05.md) |





