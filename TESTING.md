# 🧪 Guía de Pruebas - CandidatoInfo

**Proyecto:** Aplicación móvil de transparencia electoral - Perú  
**Versión:** v0.3 - Día 3  
**Fecha:** 19 de octubre de 2025  
**Probado por:** Matías Galván Guerrero

---

## 📋 Requisitos Previos

- ✅ Android Studio instalado
- ✅ Emulador Android configurado (API 24+)
- ✅ Proyecto sincronizado con Gradle
- ✅ Dependencias descargadas

---

## 🚀 Instrucciones de Ejecución

### Paso 1: Abrir el proyecto
1. Abrir Android Studio
2. File → Open → Seleccionar carpeta `CandidatoInfo`
3. Esperar a que termine el Gradle Sync

### Paso 2: Ejecutar la aplicación
1. Click en el botón **Run** ▶️ (o presionar `Shift + F10`)
2. Seleccionar emulador o dispositivo físico
3. Esperar a que la app se instale y ejecute

---

## 🧪 Casos de Prueba

### ✅ Test 1: Pantalla Home - Lista de Candidatos

**Objetivo:** Verificar que la lista de candidatos se muestra correctamente.

**Pasos:**
1. La aplicación abre automáticamente en `HomeScreen`
2. Observar la lista de candidatos

**Resultados esperados:**
- ✅ Se muestran 10 candidatos en total
- ✅ Cada card muestra: foto, nombre completo, partido político
- ✅ Badge azul indica el cargo (Congreso/Presidencia)
- ✅ Badge rojo indica número de denuncias (si las tiene)
- ✅ Scroll vertical funciona correctamente

**Captura de pantalla:**

<img width="298" height="540" alt="image" src="https://github.com/user-attachments/assets/9422ae83-c3d3-4784-b8ac-06168efe9653" />


**Estado:** ✅ **PASÓ**

---
### ✅ Test 2: Búsqueda de Candidatos

**Objetivo:** Verificar que el filtro de búsqueda funciona correctamente.

**Pasos:**
1. En `HomeScreen`, hacer click en la barra de búsqueda
2. Escribir "Keiko"
3. Observar los resultados filtrados
4. Borrar el texto de búsqueda
5. Observar que vuelven todos los candidatos

**Resultados esperados:**
- ✅ Al escribir "Keiko", aparece solo Keiko Fujimori
- ✅ La búsqueda no distingue mayúsculas/minúsculas
- ✅ También busca por partido político
- ✅ Al borrar la búsqueda, vuelven los 10 candidatos

**Captura de pantalla:**

<img width="265" height="535" alt="Test 2 - Búsqueda" src="https://github.com/user-attachments/assets/06dedd93-b523-4b1e-9b28-8657340fba80e" />

**Estado:** ✅ **PASÓ**

---

### ✅ Test 3: Detalle del Candidato

**Objetivo:** Verificar que la pantalla de detalle muestra toda la información.

**Pasos:**
1. Desde `HomeScreen`, hacer click en cualquier candidato
2. Observar la pantalla `DetailScreen`
3. Hacer scroll hacia abajo
4. Observar denuncias y proyectos
5. Hacer click en el botón "Volver"

**Resultados esperados:**
- ✅ Se muestra foto grande del candidato
- ✅ Nombre completo y partido político visibles
- ✅ Edad y cargo mostrados correctamente
- ✅ Biografía completa se muestra
- ✅ Denuncias listadas con:
  - Título, descripción, fecha
  - Badge de estado (En proceso/Archivado/Sentenciado)
  - Colores apropiados según estado
- ✅ Proyectos listados con:
  - Título, descripción, fecha
  - Badge de estado (Presentado/En debate/Aprobado/Rechazado)
  - Colores apropiados según estado
- ✅ Botón "Ver en JNE" visible
- ✅ Botón "Volver" regresa a `HomeScreen`

**Captura de pantalla:**


<img width="290" height="529" alt="image" src="https://github.com/user-attachments/assets/28fd2bc4-412a-4ffb-813f-9a3aa92b3160" />

**Estado:** ✅ **PASÓ**

---

### ✅ Test 4: Comparador de Candidatos

**Objetivo:** Verificar que se pueden comparar 2 candidatos lado a lado.

**Pasos:**
1. Navegar a `CompareScreen` (temporalmente desde navegación directa)
2. Observar la comparación de 2 candidatos
3. Verificar métricas comparadas
4. Hacer click en "Ver perfil"
5. Hacer click en "Volver"

**Resultados esperados:**
- ✅ Se muestran 2 candidatos lado a lado
- ✅ Fotos y nombres visibles para ambos
- ✅ Comparación de denuncias con números
- ✅ Comparación de proyectos presentados
- ✅ Comparación de asistencia (si aplica)
- ✅ Comparación de edad
- ✅ Valores menores en denuncias resaltados en verde
- ✅ Botones "Ver perfil" visibles
- ✅ Botón "Volver" funciona correctamente

**Captura de pantalla:**

<img width="287" height="511" alt="image" src="https://github.com/user-attachments/assets/b358ccd8-3546-43c2-94e6-d8fb302bfe8d" />


**Estado:** ✅ **PASÓ**

---

### ✅ Test 5: Navegación General

**Objetivo:** Verificar que toda la navegación funciona correctamente.

**Pasos:**
1. Home → Click en candidato → Detail
2. Detail → Click "Volver" → Home
3. Home → Comparador
4. Comparador → Click "Volver" → Home

**Resultados esperados:**
- ✅ Todas las transiciones son fluidas
- ✅ No hay crashes durante la navegación
- ✅ Los botones "Volver" funcionan correctamente
- ✅ La navegación con parámetros (ID candidato) funciona

**Estado:** ✅ **PASÓ**

---

## 🎨 Verificación de Diseño

### Colores Material 3
- ✅ **Primario:** Azul institucional `#1976D2` aplicado
- ✅ **Secundario:** Verde `#388E3C` aplicado
- ✅ **Error:** Rojo `#D32F2F` aplicado
- ✅ **Fondo:** Blanco `#FFFFFF`
- ✅ **Superficie:** Gris claro `#F5F5F5`

### Componentes UI
- ✅ TopAppBar con colores correctos
- ✅ Cards con elevación sutil (2dp)
- ✅ Chips con colores según estado
- ✅ TextField de búsqueda con ícono
- ✅ LazyColumn con scroll suave
- ✅ Textos con jerarquía clara

### Responsividad
- ✅ Funciona en diferentes tamaños de pantalla
- ✅ Scroll funciona correctamente
- ✅ No hay desbordamiento de texto

---

## 📊 Resumen de Resultados

| Test | Descripción | Estado | Notas |
|------|-------------|--------|-------|
| Test 1 | Lista de candidatos | ✅ PASÓ | 10 candidatos mostrados correctamente |
| Test 2 | Búsqueda y filtrado | ✅ PASÓ | Búsqueda por nombre y partido funciona |
| Test 3 | Detalle del candidato | ✅ PASÓ | Toda la información se muestra |
| Test 4 | Comparador | ✅ PASÓ | Comparación de 2 candidatos funcional |
| Test 5 | Navegación general | ✅ PASÓ | Sin crashes, navegación fluida |

---

## 🐛 Bugs Encontrados

**Ninguno** ✅

---

## ✅ Conclusión

**Estado general del Día 3:** ✅ **COMPLETADO EXITOSAMENTE**

La aplicación cumple con todos los requerimientos funcionales del Día 3:
- ✅ RF11: Pantalla Inicio con barra de búsqueda implementada
- ✅ RF12: Lista de candidatos mostrando datos completos
- ✅ RF13: Pantalla Detalle con datos personales y antecedentes
- ✅ RF14: Diseño Material 3 aplicado correctamente
- ✅ RF15: Navegación de lista → detalle funcional

**La aplicación está lista para continuar con el Día 4: Lógica y manejo de datos.**

---

**Probado por:** Matías Galván Guerrero
**Fecha:** 19/10/2025  

---

