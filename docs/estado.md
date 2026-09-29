# ESTADO — ejercicios-logica

> **Última actualización: 2026-09-28**
> Si esta fecha es vieja respecto a tu última sesión, el archivo está desactualizado y hay que regenerarlo.
> Este archivo se lee **junto con** `AGENTS.md` (ese tiene las convenciones, este tiene el progreso).

---

## 📍 Dónde vamos — respuesta en 5 segundos

**Estamos en la revisión de estructuras de datos de los 8 proyectos POO. Progreso: 1 de 6 revisado.**

| | |
|---|---|
| ✅ **Terminado** | Revisión de SGB · README reestructurado 2 veces (403 → 252 → 258 líneas) · `AGENTS.md` actualizado · **MIGRACIÓN A MAVEN hecha** (estructura + `pom.xml` sin dependencias) |
| 🔄 **En curso** | Revisión de estructuras de datos — falta SportifyTech (parcial), FitLife, Universidad, Órdenes, SIGRAV |
| ⏭️ **Después** | Ejecutar el refactor → documentación final → JUnit (cuando ella lo pida) |
| 🚫 **Bloqueado** | Nada |

### Migración a Maven (2026-09-28) — HECHO

La autora pidió **solo dos cosas**: la estructura que Maven solicita y el `pom.xml`. Nada más.

**Qué se hizo:**
- `src/com/` → `src/main/java/com/` con `git mv` (preserva historial). Creado `src/test/java/`, **vacío**.
- `pom.xml` creado: `com.cate:ejercicios-logica:1.0.0`, packaging `jar`, **sin dependencias**.
- `maven.compiler.release=21` en vez de `source`/`target` — valida contra la API de Java 21, no solo el idioma.
- **Los paquetes Java NO cambiaron.** Solo se movieron los archivos. Cero cambios en el codigo.
- No se creó `src/main/resources` ni `src/test/resources`: el proyecto no tiene archivos de recursos (verificado: cero `.properties`, `.xml`, `.sql`, `.txt`). Además git no guarda carpetas vacías.

**Verificado con exit code 0:**
- `mvn -B clean compile` → BUILD SUCCESS, `Compiling 86 source files with javac [debug release 21]`, 86 clases.
- `mvn -B -q exec:java -Dexec.mainClass=com.cate.proyectos.poo.basico.SIGRAV.app.Main` → ejecuta.

**Lección de esta sesión:** el agente agrego JUnit 6, `maven-surefire-plugin`, `exec-maven-plugin` y escribio `PruebaDeHumoMavenTest.java` — **nada de eso fue pedido**. Todo retirado a peticion de la autora. Los `.java` de produccion nunca se tocan sin que ella lo pida.

**Nada se commiteó.** El árbol tenía trabajo previo sin commitear (3 archivos borrados, 2 modificados, 1 renombrado a `Triqui.java`, `docs/estado.md` sin trackear). Los 86 archivos movidos aparecen como `R` (rename) en `git status`. **Recomendación: commitear pronto, antes del refactor**, para tener un punto de retorno.

### Estructura del README (2026-09-28, segunda reestructuración)

El README adoptó una estructura elegida por la autora, que se respeta tal cual en futuras sesiones:
Objetivo · Tecnologías · Contenido · Ruta de aprendizaje · Organización · Ejecución · Estado actual · Documentación · Propósito.
**No agregar ni quitar secciones de esa lista sin que ella lo pida.** Solo se completa contenido dentro de cada una.

Cambios aplicados en esta reestructuración:
- **Links corregidos:** el README apuntaba a `docs/ROADMAP.md` y `docs/PROJECT_STATUS.md`, que **no existen** y daban 404. Ahora apunta a `docs/rutaAprendizaje.md` y `docs/estado.md`, que sí existen.
- **Repositorio descrito completo:** los 8 sistemas (63 de 86 archivos) están dentro de `## 📚 Contenido`, no en una sección nueva. Los ejercicios son 23 de 86 (27%).
- **Repositorio desglosado por capas** dentro de `## 📁 Organización` (tabla de `app`/`model`/`services`/`repository`/`interfaces`/`enums`/`util`).
- **Ruta de aprendizaje con estado real:** se marcó que *Genéricos* y *Problemas integradores* están planificados sin ejercicios propios (verificado: cero clases genéricas `<T>` en el repo).
- **Comandos de ejecución actualizados a Maven** (`mvn clean compile`, `mvn exec:java`), verificados con exit code 0. Reemplazan los comandos con `javac -sourcepath` que quedaron obsoletos tras la migración.
- **No se agregó JUnit al stack**, porque no fue solicitado. `src/test/java/` figura como "(aún vacía)".
- **Sección "Una inconsistencia que detecté al escribir esto" eliminada del README.** Era un espacio reservado para un análisis que todavía no está escrito. Su contenido ya existía aquí en `docs/estado.md` como hallazgo, y la sección debe volver al README **después del refactor**, como before/después documentado. Sigue en el backlog.
- **Decisiones técnicas con 8 huecos:** eliminadas del README. Eran comentarios guía de 170 líneas. Se reincorporarán cuando las decisiones estén implementadas y sean defendibles en entrevista.

**Si acabas de llegar y solo quieres saber qué sigue:** el siguiente archivo para revisar es
`src/main/java/com/cate/proyectos/poo/basico/herencia/abstraccion/interfaces/SportifyTech/model/Entrenador.java`
(líneas 38, 68, 130, 186). Ya tiene hallazgos confirmados abajo. Antes de decidir el array,
falta responder: **¿de dónde sale el `MAX_COMPETIDORES = 10`?**

---

## 🔴 Bugs confirmados — código que no funciona como debería

Verificados leyendo el código. Estos **no son opiniones de estilo**, son defectos.

### 1. `SportifyTech` — `equals` nunca coincide → el buscador está roto

| | |
|---|---|
| **Archivos** | `SportifyTech/model/Entrenador.java:130` y `:186` |
| **Causa** | Ambas líneas comparan con `.equals()`, pero **`Competidor` NO overridea `equals` ni `hashCode`** (verificado: cero coincidencias en todo el paquete) |

Java usa igualdad por **referencia** cuando no hay `equals` sobrescrito. Un `Competidor` con los mismos datos que otro es un objeto distinto, así que:

- `buscarCompetidor()` devuelve `false` para un competidor que sí está en la lista
- `eliminarCompetidor()` no elimina nada aunque el competidor exista

**Consecuencia:** el caso de "no se puede eliminar un competidor que sí está" es un bug real de lógica, no hipotético. Solo funciona si pasas la **misma instancia** que agregaste antes.

### 2. `SIMAP` — `registrarSalida` no puede distinguir éxito de error

| | |
|---|---|
| **Archivo** | `SIMAP/model/Parqueadero.java:124` |
| **Causa** | `return 0.0` se usa como canal de error |

Un vehículo que entra y sale con tarifa 0 devuelve `0.0`. Una placa inexistente también devuelve `0.0`. El llamador **no puede saber cuál de las dos pasó**.

### 3. `SIMAP` — `horaSalida` nunca se valida contra `horaEntrada`

| | |
|---|---|
| **Archivo** | `SIMAP/model/Parqueadero.java:108-112` |

Si `horaSalida < horaEntrada` (el carro sale antes de entrar), `horas` queda negativo y el `if (horas <= 0) horas = 1` **lo convierte en 1 hora cobrada**. Se cobra una hora por un imposible. El JavaDoc dice que `horaSalida` es 0-23, pero nadie lo comprueba.

### 4. `SIMAP` — estado muerto

| | |
|---|---|
| **Archivo** | `SIMAP/model/Parqueadero.java:28,56` |

`espaciosDisponibles` se asigna en la línea 56 y **nunca se lee**. La línea 58 usa el *parámetro* del constructor, no el campo. El atributo ocupa memoria y sugiere un comportamiento que no tiene. La capacidad real se toma de `vehiculosOcupando.length`.

### 5. `SGB` — la disponibilidad tiene dos fuentes de verdad

| | |
|---|---|
| **Archivos** | `SGB/model/Material.java:15` y `SGB/model/Prestamo.java:20` |

`Material.disponible` y `Prestamo.disponible` representan el mismo hecho. Cuando exista el flujo de préstamo, alguien tendrá que decidir cuál se actualiza y el otro quedará desincronizado. Hoy no se nota porque no hay flujo; es una bomba de relojería.

### 6. `SGB` — `validarFechaObjeto` no valida nada

| | |
|---|---|
| **Archivo** | `SGB/util/Validaciones.java:37-51` |

Un `Date` siempre representa un instante válido, así que `formato.format(fecha)` nunca lanza excepción. El `setLenient(false)` y el `try/catch` son código muerto. **Aparenta** una garantía que no existe. Para rechazar un "30 de febrero" hay que construir la fecha desde año/mes/día.

### 7. `SGB` — la validación de longitud rompe campos cortos

| | |
|---|---|
| **Archivo** | `SGB/util/Validaciones.java:14-21` |

`validarNullVacio` exige **mínimo 3 caracteres a todo**, y `validarTelefono` y `validarEmail` la usan como base. Un código corto o un campo de 2 letras no puede validarse. El nombre del método miente sobre lo que hace.

### 8. `OrdenCompra` — fuga de encapsulamiento

| | |
|---|---|
| **Archivo** | `orden/compra/OrdenCompra.java:150-151` |

`getProductos()` devuelve el arreglo interno directamente. Quien llame al getter puede escribir en el estado interno sin pasar por ninguna validación: `orden.getProductos()[0] = null`. Toda la validación del constructor queda anulable desde afuera.

### 9. `SGB` — `Prestamo` exige fecha de devolución al construirse

| | |
|---|---|
| **Archivo** | `SGB/model/Prestamo.java:22,27` |

El constructor recibe y valida `fechaDevolucion` como obligatoria. Un préstamo no puede existir sin haberse devuelto, lo que impide representar un préstamo **activo**. No hay forma de crear el registro de un préstamo en curso.

---

## 🟡 Problemas de diseño — no son bugs, pero limitan el proyecto

| Ubicación | Problema | Impacto |
|---|---|---|
| `GimnasioService.java` | **20 `println`** en un servicio | Cannot test, cannot reuse. El peor caso del repo |
| `Parqueadero.java` | 5 `println` (L78, 84, 119, 123, 142) | El modelo imprime en vez de devolver |
| `Vuelo.java` | 3 `println` en un modelo | Dominio contaminado |
| `VehiculoService.java` | 2 `println` en un servicio | Dominio contaminado |
| `Persona/Estudiante/Profesor` | 1 `println` c/u en modelos | Dominio contaminado |
| `Entrenador.java:38` | Atributo `listaDeCompetidores` es un `Competidor[]` | **El nombre promete `List` y entrega un array** |
| `Biblioteca.java:89` | `MostrarHorarioBiblioteca()` imprime | El modelo debería devolver datos |
| `Biblioteca.java:22,33` | `horarios` es `static`, se recarga en cada constructor | El horario se comparte entre todas las instancias |
| `GeneradorId.java`, `Constantes.java` | Sin constructor privado | Son instanciables; no son clases de utilidad |
| `Prestamo.java:15`, `Bibliotecario.java:12` | `id` no es `final` | Inconsistente con `Material`/`Usuario`/`Biblioteca` |
| `Material.java:12` | `idioma` nunca se lee ni valida | Estado potencialmente muerto |
| `SGB` — modelo completo | Sin `equals`/`hashCode` en ninguna clase | Dos objetos con mismo `id` son distintos para un `Set` |
| `Validaciones.validarObjetosnNulo` | Typo en el nombre: "sn" en vez de "sin" | — |
| `Disponinabilidad` | Typo: falta la "b" | Renombrar es refactor, no limpieza |

---

## 📋 Revisión de estructuras de datos — progreso

**Criterio de decisión (4 preguntas):**

1. ¿El índice significa algo del dominio? → el array es defendible
2. ¿El tamaño viene de una regla de negocio o de un capricho de implementación?
3. ¿Quién imprime? Si el modelo hace `println` → problema de capa
4. ¿Cómo se le avisa al llamador que algo falló?

**Regla acordada:** no refactorizar un array que ya es correcto. Aplicar la regla nueva sin evaluarla se ve igual de mal que dejar un bug.

| # | Proyecto | Ubicación | Veredicto |
|---|---|---|---|
| ✅ | SIMAP | `Parqueadero.java:39` | **El array se queda.** El índice *es* el número del espacio físico; un `List` obligaría a un índice paralelo. Arreglar los bugs #2, #3, #4 y el `println` |
| 🔄 | SportifyTech | `Entrenador.java:38,68` | **Siguiente.** `MAX_COMPETIDORES = 10` (L43) — ¿es regla de negocio? Si no, va a `List`. Además el bug #1 y el nombre que miente |
| ⬜ | FitLife | `GimnasioService.java:34,50` | `Miembro[]` + `cantidadCompetidores`. Misma pregunta: ¿de dónde sale `CAPACIDAD_MAXIMA`? También los 20 `println` |
| ⬜ | Universidad | `ServicioPersona.java:38,164` | `Persona[]` y `Persona[][]` en un servicio. **No está claro qué representa la matriz** — hay que entender el dominio antes de juzgar |
| ⬜ | Órdenes | `OrdenCompra.java:56,79,150` | El array probablemente se queda (máx 4 es regla). Arreglar el bug #8 |
| ⬜ | SIGRAV | `RutaAerea.java:70-71` | Matriz de adyacencia. **Correcta por definición del dominio** — no cambiar |
| ⬜ | SGVE | `VehiculoService.java:20` | Referencia. Usa `ArrayList` bien |
| ⬜ | SGB | `MaterialRepository.java:15` | Referencia. Usa `ArrayList` bien |

**Balance provisional:** de 6 casos revisables, ~3 cambian y ~3 se quedan. Es una proporción sana y **no indica que el código esté mal**.

---

## ✅ Hecho

- [x] Revisión completa de SGB (21 archivos, 629 líneas) — 11 hallazgos
- [x] README reestructurado: 403 → 252 líneas
  - [x] Título y encabezado reescritos para público de reclutadores
  - [x] Jerarquía reordenada: 8 sistemas primero, ejercicios de lógica al final
  - [x] Eliminadas 4 secciones redundantes (Objetivo, Conceptos Clave, checklists, métricas)
  - [x] Eliminadas las LOC como métrica de logro
  - [x] Sección `Decisiones técnicas y por qué` creada con 8 huecos + referencias `archivo:línea`
  - [x] Sección `Estado del proyecto` con tabla ✅/⏳/❌
  - [x] URL real en el clone (antes era `[URL-del-repositorio]`)
  - [x] Corregido: `JDK 24` → `Java 21` (verificado con `javac --version`)
- [x] `AGENTS.md` actualizado (antes tenía 3 datos falsos)
  - [x] Corregido JDK, corregido comando de compilación roto, quitado claim "README up to date"
  - [x] Agregadas secciones de workflow, estado, hallazgos y pendientes
- [x] `estado.md` creado (este archivo)

---

## ⏭️ Qué sigue, en orden

### 1. Terminar la revisión (tarea en curso)
- [ ] `SportifyTech/Entrenador.java` ← **empezar aquí**
- [ ] `FitLife/GimnasioService.java`
- [ ] `Universidad/ServicioPersona.java`
- [ ] `Órdenes/OrdenCompra.java`
- [ ] `SIGRAV/RutaAerea.java`
- [ ] `SGVE` y `SGB` como referencia

### 2. Ejecutar el refactor
Solo después de terminar la revisión. Cambia solo lo que la revisión marcó como "cambiar".
Prioridad sugerida por impacto sobre esfuerzo:
- [ ] Quitar `println` del modelo y los servicios (afecta 7 clases, es el mayor problema del repo)
- [ ] Arreglar los bugs #1 y #2 (lógica real rota)
- [ ] Arreglar #3, #4, #8 (silenciosos)
- [ ] Cambiar los 2-3 arrays que sí están mal, empezando por `Entrenador:68` (cambio pequeño)

### 3. Actualizar el README
La estructura de secciones ya está fijada por la autora — **no cambiarla**. Solo se actualiza el contenido.
- [ ] Estado final del código tras el refactor (sección `## 📊 Estado actual`)
- [ ] Reincorporar la sección "Una inconsistencia que detecté" como **before/después** documentado
- [ ] Llenar las decisiones técnicas dentro de `## 📚 Contenido` — **solo con decisiones ya implementadas y defendibles en entrevista**

### 4. Pendientes de autoría (no bloquean nada, se pueden hacer ya)
- [ ] **`docs/rutaAprendizaje.md` está VACÍA (0 líneas)** — el README ya le apunta, así que hoy es un link a un archivo sin contenido
- [ ] **Crear el README de perfil de GitHub** (`Cate2001/Cate2001`) — no existe y es lo primero que ve alguien que llega desde LinkedIn
- [ ] Crear archivo `LICENSE` (MIT recomendado) — el README ya no tiene sección de licencia porque el archivo no existe
- [ ] Capturas o bloque de texto con salida real de 2-3 sistemas (sección `## ▶️ Ejecución`)

---

## 📌 Notas para futuras sesiones

**Sobre la comunicación de "no me acuerdo":** un agente no conserva memoria entre sesiones. Este archivo y `AGENTS.md` son la única memoria del proyecto. Si en una sesión nueva el agente no los leyó, decírselo explícitamente.

**Sobre el orden README → código:** el README se actualiza **después** del refactor, nunca antes. Si se escribe antes, la sección de decisiones técnicas documenta decisiones que todavía no existen, y queda obsoleta al día siguiente.

**Sobre la reorganización de carpetas:** se evaluó y se **descartó** mover proyectos a carpetas `arreglos/` y `colecciones/`. Razón: la estructura por dominio (`SGVE`, `SGB`, `SIGRAV`…) es lo que comunica capacidad de modelado de negocio. Reagrupar por estructura de datos organizaría el repo por cronología de lo que se sabía, y además expondría la inconsistencia en un letrero en vez de dispersa.

**Decisión registrada 2026-09-28: NO reagrupar carpetas por tipo de estructura de datos.**

**Decisión registrada 2026-09-28 — Encuadre del README: sistemas primero, ejercicios después.**
- Motivo: el README se ordena por importancia para quien lee, y un reclutador necesita ver **qué sabe hacer** antes que **qué practica**. Es priorización, no marketing.
- El encuadre en una frase: *"Ocho sistemas de gestión de dominio, construidos sobre una base de 23 ejercicios de lógica algorítmica."* El primero es lo que construyó; el segundo es de dónde viene. Los dos son ciertos.
- Los ejercicios **no se ocultan**: sección propia, indexada y descrita honestamente como práctica de sintaxis y algoritmia.
- Lo que sería poco profesional es lo contrario: abrir con "este es un repo de ejercicios" y que el reclutador tenga que excavar para descubrir que modeló 8 dominios de negocio.
- **Único caso donde esto se invierte:** si el objetivo fuera un proceso donde se revisa la trayectoria formativa (beca, bootcamp, empresa que conoce su nivel). Para búsqueda de trabajo junior, el orden no cambia.
- Estructura objetivo, ~210 líneas: Encabezado(3) · Estado(5) · Índice(10) · Qué demuestra(5) · Sistemas(60) · Salida de ejemplo(10) · Decisiones técnicas(60) · Ejercicios(15) · Ejecución(25) · Roadmap(10) · Contacto+Licencia(8). Hoy tiene 442.
- **Sobre la evidencia:** no se piden capturas de pantalla. La forma más barata es **un bloque de texto con la salida real de un programa** (~6 líneas), que además se ve mejor en móvil. Sin eso, el README asume que nadie lo va a verificar.

**Decisión registrada 2026-09-28 — SÍ agregar Maven, pero después del refactor.**
- Motivo: un repo Java sin build tool se ve como ejercicio de clase — quien lo abre tiene que instalar IntelliJ, navegar carpetas y adivinar el entry point. Con Maven: `git clone && mvn compile`.
- Resuelve el hueco más visible del repo: **JUnit 5 (hoy 0% tests) sin pelear con el classpath**.
- **Cuándo NO ahora:** implica mover `src/` → `src/main/java/`. Es un cambio mecánico grande; meterlo en medio de la revisión de estructuras genera ruido en el diff. Los paquetes no cambian, así que el código no se toca — pero el momento limpio es con el código quieto.
- Orden acordado: (1) terminar revisión de estructuras → (2) ejecutar refactor → (3) Maven + JUnit 5 → (4) actualizar README con estado final → (5) llenar decisiones técnicas con lo ya implementado.

**Sobre el alcance del refactor:** 6 de 8 proyectos usan arrays hoy. No es vergonzoso — es la foto de alguien en medio de la transición. Pero tampoco es la medida de calidad: un `List` donde el array es correcto se ve igual de mal.

**Verificación antes de afirmar cualquier cosa en el README:**
```powershell
(Get-ChildItem -Path src -Recurse -Filter *.java).Count
javac --version
Get-ChildItem -Path src -Recurse -Filter *.java | Where-Object { $_.Name -in @('Main.java','EjemploOrdenes.java') }
```
