# AGENTS.md — ejercicios-logica

> **Este archivo es la memoria estable del proyecto.** Un agente NO conserva memoria entre sesiones.
>
> **Antes de cualquier tarea, leer ADEMÁS `docs/estado.md`** — ahí está el estado volátil: dónde se quedó el trabajo, qué está abierto, qué sigue. Este archivo (AGENTS.md) tiene las convenciones y las reglas; ese tiene el progreso.

---

## 📋 Workflow para el agente

### Antes de cualquier tarea

1. **Leer este archivo entero.** No asumir contexto de sesiones anteriores.
2. **Leer `docs/estado.md`.** Ahí está el punto exacto donde se quedó el trabajo: qué se terminó, qué está abierto, qué sigue.
3. Verificar el estado **real** del código con comandos antes de afirmar cualquier cosa. Nunca describir código sin leerlo.

### Al terminar una tarea

1. Si el cambio altera el progreso → actualizar **`docs/estado.md`** (estado volátil: qué se hizo, qué sigue, dónde se quedó).
2. Si el cambio altera estructura, entry points, métricas o el estado de una sección → **actualizar `README.md` en la misma tarea**. No dejarlo pendiente.
3. Si se resolvió un hallazgo de revisión → moverlo a "Hecho" en `docs/estado.md`, con la fecha.
4. Si se descubrió algo nuevo → agregarlo a la sección de hallazgos de `docs/estado.md`.
5. Si se cambió una convención o una regla permanente → actualizar **este** archivo.

### Al agregar un proyecto o cambiar la estructura

Ejecutar el checklist de la skill `actualizar-readme` y el bloque **Verificación** de abajo.

### Regla de oro del proyecto

- **No entregar soluciones a ejercicios o refactors de la autora.** Dar criterio, preguntas guía y señalar el problema. La implementación es de ella.
- **No inventar métricas ni decisiones técnicas.** Todo número se cuenta desde el sistema de archivos; toda justificación debe ser defendible en una entrevista.

---

## 🏗️ Project type

- **Maven** (3.9.16) — `pom.xml` en la raíz. Estructura estándar `src/main/java` + `src/test/java`.
- Maven **no está en el PATH**. Está empaquetado dentro de IntelliJ:
  `C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.1\plugins\maven-plugin\lib\maven3\bin\mvn.cmd`
  IntelliJ lo usa automáticamente al abrir el proyecto como modulo Maven.
- **JDK 21** en IDE y en PATH (`javac --version` → 21.0.12.1, verificado). ~~JDK 24~~ — dato corregido, nunca estuvo en el PATH.
- Compilación con `maven.compiler.release=21` (no `source`/`target`).
- Root `.gitignore` existe (ignora `.idea/`, `out/`, `target/`, `bin/`, `build/`, `node_modules/`, `*.iml`)
- ⚠️ `docs/estado.md` **NO está bien ignorado**: la regla es `docs/estado.md/` con barra final, y git trata eso como directorio. Ver `## Bugs de configuración` abajo.

## Tests

- **Cero librerías de test.** El `pom.xml` **no declara dependencias** — el proyecto no usa ninguna.
- Los "tests" son `System.out.println` en `main()` — revisados visualmente.
- `src/test/java/` existe (parte del layout estándar de Maven) pero está **vacía**.
- JUnit sigue en el roadmap, **no implementado**. Cuando se agregue, habrá que declarar
  `junit-bom` + `junit-jupiter` y **fijar `maven-surefire-plugin`**: la versión por defecto
  de Maven es anterior a JUnit 5 y no ejecuta las pruebas (falla en silencio).
- Cada `app/Main.java` de proyecto POO sigue funcionando como arnés de prueba manual.

## Convenciones

- **Todos los identificadores, comentarios y output en español** (descripcion, vehiculo, cliente).
- Package root: `com.cate.*`
- Capas por proyecto:
  - `app/` — punto de entrada
  - `model/` — entidades de negocio
  - `services/` — lógica de negocio
  - `enums/` — enumeraciones
  - `util/` — helpers
  - `repository/` — acceso a datos (solo SGB)
  - `interfaces/` — contratos (solo SGVE)

## Package structure

```text
src/main/java/com/cate/{ejercicios.basicos,proyectos.poo.basico.*,practica.nuevos.conceptos.colecciones.SGB}
src/test/java/     # pruebas unitarias
pom.xml            # Maven
```

**Los paquetes Java NO cambiaron al migrar a Maven** — solo se movieron los archivos de `src/com/` a `src/main/java/com/`.

## Entry points

```
com.cate.ejercicios.basicos.recursividad.Main
com.cate.proyectos.poo.basico.SIGRAV.app.Main
com.cate.proyectos.poo.basico.SIMAP.app.Main
com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.app.Main
com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.app.Main
com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.app.Main
com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.app.Main
com.cate.proyectos.poo.basico.orden.compra.EjemploOrdenes
com.cate.practica.nuevos.conceptos.colecciones.SGB.app.Main
```

## Compile & run (VERIFICADO)

Comandos **probados y con exit code 0** el 2026-09-28:

```bash
# Maven empaquetado en IntelliJ (mvn NO esta en el PATH)
$mvn = "C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.1\plugins\maven-plugin\lib\maven3\bin\mvn.cmd"

# Compilar (86 archivos)
& $mvn -B clean compile

# Ejecutar un sistema
& $mvn -B -q exec:java "-Dexec.mainClass=com.cate.proyectos.poo.basico.SIMAP.app.Main"
```

> `exec:java` funciona aunque `exec-maven-plugin` no esté declarado en el `pom.xml`:
> Maven resuelve el plugin automáticamente. Verificado con exit code 0. Si algún dia
> deja de funcionar, es porque Maven no logra resolver el prefijo — la solucion es
> declarar el plugin explicitamente con su version.

En IntelliJ, el proyecto se reconoce como modulo Maven automaticamente y aparecen
los objetivos de Maven en la ventana lateral.

> Para agregar maven al PATH de forma permanente: agrega el directorio
> `...\maven3\bin` a la variable de sistema `Path`. Opcional — el proyecto funciona
> sin esto desde IntelliJ.

El glob `**` **no funciona** en PowerShell. Para compilar sin Maven:
`javac -encoding UTF-8 -d out/clases -sourcepath src/main/java src/main/java/com/cate/practica/nuevos/conceptos/colecciones/SGB/app/Main.java`

## Code style quirks

- `IllegalArgumentException` para errores de validación.
- `StringBuilder` para `toString()`.
- Auto-incremento vía `static int ultimoId` en clases de modelo.
- Basic exercises usan minúsculas en nombres de clase (`eliminarCaracteresRepetidos.java`, `triqui.java`) — viola UpperCamelCase; los proyectos POO sí siguen la convención.
- JavaDoc en español con `@author` y `@version`; presente en clases públicas de POO/SGB (50 de 86 archivos). Los ejercicios básicos no tienen por diseño.

## ⚠️ Typos conocidos en el código (NO corregir sin avisar)

Renombrar cualquier cosa aquí es un refactor, no una limpieza cosmetics:

- `Disponinabilidad` → debería ser `Disponibilidad` (enum, SGB)
- `DiaSemana` → sin tilde, debería ser `DíaSemana` (2 enums: SGB y fitlife)
- `validarNumeroNagativo` → `validarNumeroNegativo`
- `validarObjetosnNulo` → `validarObjetosSinNulo`
- `DiaSemanaArr` en `Biblioteca.java:25` → no es lowerCamelCase ni es un arreglo de días, es `DiaSemana.values()`

---

## 📊 Métricas verificadas

Contadas desde el sistema de archivos el 2026-09-28. **Volver a contar antes de publicarlas.**

| Dato | Valor |
|---|---|
| Archivos Java | 86 (bajo `src/main/java`) + 1 prueba |
| Líneas sin vacías | 6296 |
| Proyectos POO | 7 |
| Prácticas con Colecciones | 1 (SGB) |
| Ejercicios básicos | 23 |
| Clases abstractas | 3 (`Material`, `Miembro`, `Vehiculo`) |
| Interfaces | 2 (`GPS`, `Recargable`) — ambas en SGVE |
| Enumeraciones | 9 |
| Clases en `util/` | 5 |
| Archivos con JavaDoc | 50 de 86 |
| Pruebas automatizadas | 0% — `src/test/java/` vacío, sin dependencias de test |
| Build | Maven 3.9.16 · `mvn clean compile` en verde |

**El estado de avance, los bugs abiertos, los hallazgos de revisión y el punto de reanudación NO viven aquí.** Viven en `docs/estado.md`.

---

## 📄 README — reglas de mantenimiento

- El README es **público y para reclutadores**. No es documentación interna.
- Los hallazgos de revisión, bugs abiertos y el punto de reanudación van en `docs/estado.md`, **nunca en el README**.
- **La estructura de secciones del README está fijada por la autora. No agregar, quitar ni renombrar secciones sin que ella lo pida.** Se completa contenido dentro de las existentes.
  - Orden: `Objetivo` · `Tecnologías y herramientas` · `Contenido` · `Ruta de aprendizaje` · `Organización del proyecto` · `Ejecución` · `Estado actual` · `Documentación` · `Propósito del repositorio`.
  - Los 8 sistemas de dominio viven **dentro de `## 📚 Contenido`**, no en una sección propia.
- Se actualiza **en la misma tarea** que el cambio de código, nunca después.
- Toda métrica se cuenta desde el sistema de archivos antes de escribirla.
- Toda entrada debe ser verificable contra el código.
- **Todo link del README debe apuntar a un archivo que exista.** Verificar antes de escribir. Durante años estuvo apuntando a `docs/ROADMAP.md` y `docs/PROJECT_STATUS.md`, que nunca existieron.
- `LICENSE` es un archivo real. Si no existe, el README no lleva sección de licencia.
- **Nunca subir al README:** LOC como métrica de logro, checklists redundantes, ni el estado de avance de la revisión.

---

## 🐛 Bugs de configuración

### 1. `docs/estado.md` NO está ignorado por git

La regla en `.gitignore` es:

```
docs/estado.md/
```

Esa **barra final** le dice a git "ignora un **directorio** llamado `estado.md`". Como
`estado.md` es un **archivo**, la regla no aplica. Verificado con `git check-ignore`:
devuelve que NO está ignorado, y `git status` lo muestra como `?? docs/estado.md`.

**Consecuencia:** el archivo se sube al repositorio público. Contiene 9 bugs confirmados,
el detalle de la revisión interna y notas de trabajo.

**Arreglo:** quitar la barra final → `docs/estado.md`. Lo tiene que hacer la autora, no el agente.

### 2. Maven no está en el PATH

Funciona desde IntelliJ, pero `mvn` no existe como comando. Ver `## Compile & run`.

---

## 🔍 Verificación antes de afirmar

```powershell
# Contar archivos Java de producción
(Get-ChildItem -Path src\main\java -Recurse -Filter *.java).Count

# Entry points reales
Get-ChildItem -Path src\main\java -Recurse -Filter *.java |
  Where-Object { $_.Name -in @('Main.java','EjemploOrdenes.java') }

# Versión de Java real
javac --version

# Version de Maven (empaquetada en IntelliJ)
& "C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.1\plugins\maven-plugin\lib\maven3\bin\mvn.cmd" -version

# Build completo + pruebas
& "C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.1\plugins\maven-plugin\lib\maven3\bin\mvn.cmd" -B clean test

# Verificar si un archivo esta realmente ignorado
git check-ignore -v docs/estado.md
```

---

