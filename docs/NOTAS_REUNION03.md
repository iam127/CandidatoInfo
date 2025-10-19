# 🧩 Proyecto CandidatoInfo — Día 3

📅 **Estructura Base del Proyecto**

---

## 📍 Información General

**Repositorio principal:**  
🔗 https://github.com/iam127/CandidatoInfo.git

**Objetivo del Día 3:**  
Actualizar  **base del proyecto Android en Kotlin con Jetpack Compose**, definiendo una arquitectura limpia, navegación funcional y estructura de paquetes organizada para el desarrollo del resto del equipo.

---

## 🧱 Estructura del Proyecto

```
CandidatoInfo/
├── app/
│   ├── src/main/java/com/equipo/candidatoinfo/
│   │   ├── ui/
│   │   │   ├── home/
│   │   │   │   └── HomeScreen.kt
│   │   │   ├── detail/
│   │   │   │   └── DetailScreen.kt
│   │   │   ├── compare/
│   │   │   │   └── CompareScreen.kt
│   │   │   └── theme/
│   │   │       ├── Color.kt
│   │   │       ├── Theme.kt
│   │   │       └── Type.kt
│   │   ├── model/
│   │   │   ├── Candidato.kt
│   │   │   ├── Denuncia.kt
│   │   │   └── Proyecto.kt
│   │   ├── data/
│   │   │   └── CandidatoData.kt
│   │   ├── navigation/
│   │   │   └── Navigation.kt
│   │   └── MainActivity.kt
│   └── build.gradle.kts
└── README.md
```

---

## 🌿 Preparación — Antes de Comenzar

Todos los integrantes deben actualizar su rama con los cambios del Día 1:

```bash
cd Proyecto/CandidatoInfo
git checkout develop
git pull origin develop
git checkout feature/TU-NOMBRE
git merge develop
```

---

## 👨‍💻 Matías Galván — Líder Técnico

**Rama:** `feature/matias-setup`  
**Rol:** Líder Técnico / Arquitecto del proyecto

### 🎯 Responsabilidades

- Ayudar a Luis si tiene problemas con la UI
- Ayudar a Wilson si tiene dudas sobre los datos
- Verificar que la app compila sin errores
- Probar la aplicación en el emulador


### 🧩 Tareas Realizadas

**1. Creación y Actualizar el Proyecto**
-   Pantalla Comparador
- Probar la aplicación completa
- Mínimo SDK: API 24 (Android 7.0)
- Crear archivo Theme.kt completo

**2. Configuración de Dependencias (build.gradle.kts)**

Se agregaron librerías para:
- Compose BOM
- Navigation Compose
- ViewModel y Lifecycle
- Material 3
- Testing básico



**4. Implementación de Navegación**

Archivo `Navigation.kt` con rutas:
- Home: `home`
- Detalle: `detail/{candidateId}`
- Comparador: `compare`

**5. Actualización de MainActivity.kt**

Configuración de `AppNavigation()` como contenido principal.

**6. Definición de Paleta de Colores (Color.kt)**

Colores oficiales del proyecto:
- Azul Primario: `#1976D2`
- Verde Secundario: `#388E3C`
- Rojo Alerta: `#D32F2F`
- Blanco Fondo: `#FFFFFF`

### ✅ Entregables

- Navigation.kt funcional
- MainActivity.kt actualizado
- Color.kt con paleta del proyecto
- Proyecto sincronizado y sin errores

### 📦 Commits Realizados

```bash
git commit -m "feat: configurar proyecto Android Studio con navegación base"
git commit -m "style: agregar paleta de colores institucional"
git commit -m "docs: documentar estructura base del proyecto"
```

----------------------------------------------------------------------

## 🎨 Luis Galván — Diseñador UI/UX
-----------------------------------------------------------------------

**Rama:** `feature/luis-ui-design`  
**Rol:** Diseñador de interfaz y flujo visual

### 🎯 Responsabilidades   de Actualizar

1️⃣ Implementar HomeScreen.kt
2️⃣ Implementar DetailScreen.kt
3️⃣ Implementar CompareScreen.kt
4️⃣ Actualizar Navigation.kt
### 🧩 Tareas Realizadas

**1. Pantalla Home (HomeScreen.kt)**
- TopAppBar con título "CandidatoInfo"
- Texto descriptivo inicial
- Espacio para lista de candidatos y campo de búsqueda

**2. Pantalla Detalle (DetailScreen.kt)**
- Barra superior con botón de retroceso
- Sección central con información del candidato
- Texto con ID de candidato dinámico

**3. Pantalla Comparador (CompareScreen.kt)**
- TopAppBar con título "Comparar Candidatos"
- Layout vertical con espacio para 2–3 perfiles

**4. Actualización de Navigation.kt**
- Integración de pantallas reales con NavHost y NavController

### ✅ Entregables

- HomeScreen.kt
- DetailScreen.kt
- CompareScreen.kt
- Navegación funcional probada

### 📦 Commits Realizados

```bash
git commit -m "feat: actualizar los campos"

```

--------------------------------------------------------------------------

## 🧾 Wilson López — Documentador / Tester
-------------------------------------------------------------------------------


**Rama:** `feature/wilson-documentation`  
**Rol:** Documentador / Tester de datos

### 🎯 Responsabilidades

- Crear modelos de datos del dominio
- Implementar base de datos simulada 
- Actualizar documentación de fuentes reales
-Actualizar Datos de los Candidatos


**1. Creación de Modelos (model/)**

- `Candidato.kt` → define estructura del candidato
- `Denuncia.kt` → define tipo, estado y descripción de denuncias
- `Proyecto.kt` → contiene título, descripción y estado del proyecto

**2. Inserción de Datos Reales (data/CandidatoData.kt)**

Incluye 10 candidatos con información educativa, pública y de dominio oficial:
- Keiko Fujimori
- Verónika Mendoza
- Rafael López Aliaga
- Hernando de Soto
- César Acuña
- Yonhy Lescano
- George Forsyth
- Alberto Fujimori
- Pedro Castillo
- Antauro Humala

Todos los datos provienen de fuentes públicas: JNE, Congreso, Poder Judicial y medios verificados.

**3. Actualización de FUENTES_DATOS.md**

Se añadieron URLs reales, categorías de datos y resumen de verificación.

### ✅ Entregables

- Candidato.kt, Denuncia.kt, Proyecto.kt
- CandidatoData.kt con 10 registros educativos
- FUENTES_DATOS.md actualizado

### 📦 Commits Realizados

```bash
git commit -m "feat: creacion de carpeta y 3 archivos"
git commit -m "data: creacion de carpeeta"
git commit -m "docs: actualizar FUENTES_DATOS.md con fuentes verificadas"
```

---

## 🧠 Resultados Técnicos del Día 2

✅ Proyecto base creado en Android Studio  
✅ Navegación Compose funcional  
✅ Pantallas conectadas correctamente  
✅ Modelos y datos integrados  
✅ Paleta de colores institucional definida  
✅ Sin errores de compilación  

---

## ✅ Estado del Proyecto

**Día 2:** ✔️ Completado

Hemos completado toda la estructura base del proyecto Android con navegación funcional, modelos de datos y pantallas integradas.
## ✅ HomeScreen
- [x] Lista muestra 10 candidatos
- [x] Búsqueda por nombre funciona
- [x] Búsqueda por partido funciona
- [x] Cards muestran foto placeholder
- [x] Cards muestran badge de cargo
- [x] Cards muestran badge de denuncias
- [x] Click en card navega a detalle

## ✅ DetailScreen
- [x] Muestra foto grande del candidato
- [x] Muestra nombre completo
- [x] Muestra partido político
- [x] Muestra edad y cargo
- [x] Muestra biografía
- [x] Muestra lista de denuncias
- [x] Muestra lista de proyectos
- [x] Estados de denuncias con colores correctos
- [x] Estados de proyectos con colores correctos
- [x] Botón "Volver" funciona

## ✅ CompareScreen
- [x] Muestra 2 candidatos
- [x] Muestra comparación de denuncias
- [x] Muestra comparación de proyectos
- [x] Muestra comparación de asistencia
- [x] Botones "Ver perfil" (pendiente funcionalidad)
- [x] Botón "Volver" funciona

## ✅ Navegación
- [x] Home → Detail funciona
- [x] Detail → Home funciona
- [x] Home → Compare funciona
- [x] Compare → Home funciona

## 🐛 Bugs encontrados
- Ninguno

