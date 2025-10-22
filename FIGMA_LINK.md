# 🎨 Diseño Figma - CandidatoInfo

## 🔗 Enlace al Prototipo

**URL:** https://www.figma.com/proto/MIwZiduHrUCnIq8KTZ4ejq/Untitled?node-id=0-1&t=lDoomBAQN8u9P6Bn-1

---

## 📱 Pantallas Diseñadas

### 1. MainScreen (Dashboard)
- Logo e iconografía
- 2 botones principales grandes
- 4 funciones destacadas
- Fuentes oficiales con enlaces
- Estadísticas (3 cards)
- Footer con versión

### 2. HomeScreen (Lista de Candidatos)
- Barra de búsqueda
- Chips de filtros (Todos/Congreso/Presidencia)
- Botón de ordenamiento
- Lista de candidatos con:
    - Foto circular
    - Nombre y partido
    - Badges de cargo y denuncias
- FAB verde para comparar
- Contador de resultados

### 3. DetailScreen (Perfil del Candidato)
- Header con:
    - Foto grande circular
    - Nombre completo
    - Partido político
    - Chips de edad, cargo, denuncias, proyectos
- Sección Información Personal
- Sección Denuncias (si aplica)
- Sección Proyectos (si aplica)
- Botones de acción (Ver en JNE, Compartir)

### 4. CompareScreen (Comparador)
- 2 columnas lado a lado
- Fotos circulares arriba
- Nombres y partidos
- Comparación visual de:
    - Denuncias (con colores verde/rojo)
    - Proyectos
    - Edad
    - Asistencia
- Selector de candidatos clickeable

---

## 🎨 Sistema de Diseño

### Paleta de Colores
```
Primary (Azul Institucional)
- HEX: #1976D2
- RGB: 25, 118, 210
- Uso: Botones principales, iconos, headers

Secondary (Verde Verificación)
- HEX: #388E3C
- RGB: 56, 142, 60
- Uso: FAB, estados positivos, aprobados

Error (Rojo Alerta)
- HEX: #D32F2F
- RGB: 211, 47, 47
- Uso: Denuncias, rechazados, advertencias

Background
- HEX: #FFFFFF
- RGB: 255, 255, 255

Surface
- HEX: #F5F5F5
- RGB: 245, 245, 245

Text Primary
- HEX: #212121
- RGB: 33, 33, 33

Text Secondary
- HEX: #757575
- RGB: 117, 117, 117
```

---

## 📐 Tipografía

**Familia:** Roboto (Sistema Android)

### Escalas
- **Display Large:** 57sp, Bold (Logos, títulos principales)
- **Headline Large:** 32sp, Bold (Nombres de candidatos)
- **Headline Medium:** 28sp, Bold (Títulos de secciones)
- **Title Large:** 22sp, Bold (Subtítulos)
- **Title Medium:** 16sp, Medium (Cards)
- **Body Large:** 16sp, Regular (Biografías)
- **Body Medium:** 14sp, Regular (Descripciones)
- **Label Small:** 11sp, Medium (Badges)

---

## 🧩 Componentes Material 3

### Navegación
- **TopAppBar** - Primary con título blanco
- **NavigationBar** - No usado (navegación por botones)

### Botones
- **Button** - Primary, elevación 2dp
- **OutlinedButton** - Borde Primary
- **FloatingActionButton** - Secondary, icono centrado

### Inputs
- **OutlinedTextField** - Bordes suaves, foco Primary

### Contenedores
- **Card** - Elevación 2dp, esquinas 12dp
- **Surface** - Fondo blanco o Surface

### Selectores
- **FilterChip** - Estados selected/unselected
- **AssistChip** - Informativos, no clickeables (en algunos)

### Feedback
- **CircularProgressIndicator** - Primary
- **Snackbar** - No implementado aún
- **Dialog** - Bordes redondeados, elevación 6dp

---

## 📏 Espaciados y Márgenes

### Sistema de 8dp
- **XS:** 4dp (espacios mínimos)
- **S:** 8dp (entre elementos relacionados)
- **M:** 16dp (padding de contenedores, estándar)
- **L:** 24dp (separación de secciones)
- **XL:** 32dp (márgenes grandes)

### Elevaciones
- **0dp:** Fondo, Surface
- **2dp:** Cards estándar
- **4dp:** Cards principales (Main options)
- **6dp:** Dialogs
- **8dp:** FAB

---

## 🖼️ Iconografía

**Familia:** Material Icons (Filled + Extended)

### Iconos Principales
- **Person** - Candidatos
- **Search** - Búsqueda
- **Add** - Comparar (FAB)
- **ArrowBack** - Volver
- **Info** - Información, JNE
- **Warning** - Denuncias
- **Star** - Proyectos
- **Share** - Compartir
- **Done** - Asistencia
- **LocationOn** - Región
- **DateRange** - Fechas
- **MoreVert** - Menú ordenamiento
- **Close** - Limpiar búsqueda
- **KeyboardArrowRight** - Navegación

---

## 📸 Capturas de Pantalla

### MainScreen
![MainScreen](./screenshots/main_screen.png)

### HomeScreen
![HomeScreen](./screenshots/home_screen.png)

### DetailScreen
![DetailScreen](./screenshots/detail_screen.png)

### CompareScreen
![CompareScreen](./screenshots/compare_screen.png)

---

## 🎯 Principios de Diseño Aplicados

### 1. Claridad
- Jerarquía visual clara
- Información organizada por prioridad
- Sin elementos innecesarios

### 2. Accesibilidad
- Contraste mínimo 4.5:1 (WCAG AA)
- Textos legibles (14sp mínimo)
- Áreas táctiles 48dp mínimo
- Colores semánticos (rojo=alerta, verde=positivo)

### 3. Consistencia
- Mismos componentes en toda la app
- Paleta limitada y coherente
- Espaciados del sistema de 8dp
- Elevaciones estandarizadas

### 4. Feedback
- Estados de carga visibles
- Animaciones en transiciones
- Ripple effect en clickeables
- Mensajes claros de error

---

## 🔄 Estados de la Interfaz

### Loading
- CircularProgressIndicator centrado
- Fondo Surface

### Error
- Mensaje en color Error
- Texto explicativo
- Sin crash

### Empty
- Mensaje "No se encontraron candidatos"
- Sugerencia de acción
- Icono ilustrativo

### Success
- Contenido visible
- Scroll habilitado
- Interacciones activas

---

## 📱 Responsive Design

### Tamaños Soportados
- **Phones:** 360dp - 420dp width
- **Tablets:** No optimizado en v1.0 (futuro)

### Orientación
- **Portrait:** Totalmente optimizado
- **Landscape:** No optimizado en v1.0 (futuro)

---

**Diseñado por:** Luis Enrique Galván  
**Herramienta:** Figma  
**Versión:** v1.0  
**Fecha:** 22 de Octubre 2025

---

<p align="center">
  CandidatoInfo - Diseño para Transparencia Electoral
</p>
