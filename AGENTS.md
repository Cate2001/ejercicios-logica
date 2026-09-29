# AGENTS.md — ejercicios-logica

> **Este archivo es la política permanente del proyecto.** Las reglas generales de rol, diseño,
> mentoría y tono están en el `AGENTS.md` global. Aquí solo está lo que es propio de este
> repositorio.
>
> **Antes de cualquier tarea, leer `MEMORY.md`** — ahí está el estado volátil: dónde se quedó el
> trabajo, qué bugs hay, qué sigue. Este archivo tiene las convenciones; ese tiene el progreso.

---

## 📋 Reglas propias del proyecto

### El rol aquí es documental

**No entregues soluciones a ejercicios ni refactors de la autora.** Da criterio, preguntas guía y
señala el problema. La implementación es de ella. Escribir el código por ella invierte el orden y
le quita el aprendizaje.

**No inventes métricas ni decisiones técnicas.** Todo número se cuenta desde el sistema de
archivos; toda justificación debe ser defendible en una entrevista.

**No crees, edites ni muevas archivos de código, configuración ni tests** salvo petición explícita.

### Límites

- No hagas `git commit`, `git push` ni crees ramas salvo petición expresa.
- No agregues dependencias ni build tools sin consultarlo.
- No modifiques `.gitignore` sin consultarlo.

### README — estructura fijada por la autora

El README es **público y para reclutadores**. No es documentación interna.

- **La estructura de secciones está fijada. No agregar, quitar ni renombrar secciones sin que la
  autora lo pida.** Se completa contenido dentro de las existentes.
  - Orden: `Objetivo` · `Tecnologías y herramientas` · `Contenido` · `Ruta de aprendizaje` ·
    `Organización del proyecto` · `Ejecución` · `Estado actual` · `Documentación` ·
    `Propósito del repositorio`.
  - Los sistemas de dominio viven **dentro de `## 📚 Contenido`**, no en una sección propia.
- **Los hallazgos de revisión, bugs abiertos y el punto de reanudación van en `MEMORY.md`, nunca
  en el README.**
- Se actualiza en la misma tarea que el cambio de código, nunca después. Cargar la skill
  `actualizar-readme`.
- **Todo link del README debe apuntar a un archivo que exista.** Verificar antes de escribir.
- `LICENSE` es un archivo real. Si no existe, el README no lleva sección de licencia.
- **Nunca subir al README:** LOC como métrica de logro, checklists redundantes, ni el estado de
  avance de la revisión.

### El README se actualiza después del refactor, nunca antes

Si se escribe antes, la sección de decisiones técnicas documenta decisiones que todavía no
existen, y queda obsoleta al día siguiente.

---

## 🏗️ Info del proyecto

Verificado contra el código el 2026-09-29. Si alguno de estos hechos queda obsoleto, corregirlo
aquí.

**Maven 3.9.16** — `pom.xml` en la raíz. `maven.compiler.release=21` (no `source`/`target`).
**JDK 21** (`javac 21.0.12.1`).

**Maven no está en el PATH.** Está empaquetado dentro de IntelliJ:

```powershell
$mvn = "C:\Program Files\JetBrains\IntelliJ IDEA 2026.2.1\plugins\maven-plugin\lib\maven3\bin\mvn.cmd"

& $mvn -B clean compile
& $mvn -B -q exec:java "-Dexec.mainClass=com.cate.proyectos.poo.basico.SIMAP.app.Main"
```

> `exec:java` funciona aunque `exec-maven-plugin` no esté declarado: Maven resuelve el plugin
> automáticamente. Si algún día deja de funcionar, es porque no logra resolver el prefijo — la
> solución es declararlo explícitamente con su versión.

**Entry points** — uno por sistema. Cada `app/Main.java` es el arnés de prueba manual:

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

**Raíz de paquetes:** `com.cate.*` bajo `src/main/java`. Capas por proyecto: `app`, `model`,
`services`, `enums`, `util`, `repository` (solo SGB), `interfaces` (solo SGVE).

**Los paquetes Java no cambiaron al migrar a Maven** — solo se movieron los archivos de `src/com/`
a `src/main/java/com/`.

---

## ☕ Convenciones del código

- **Todos los identificadores, comentarios y output en español** (`descripcion`, `vehiculo`,
  `cliente`).
- `IllegalArgumentException` para errores de validación.
- `StringBuilder` en `toString()`.
- Auto-incremento vía `static int ultimoId` en clases de modelo.
- Estado actual del JavaDoc: las clases públicas de POO y SGB lo llevan en español con `@author`
  y `@version`; los ejercicios básicos no. Es la convención que ya existe, no una obligación de
  completarla — el criterio para agregar o no está en la skill `javadocs`.
- **Los ejercicios básicos usan minúsculas en nombres de clase** (`triqui.java`,
  `eliminarCaracteresRepetidos.java`) — viola UpperCamelCase. Los proyectos POO sí siguen la
  convención. Corregir los nombres es un refactor, no una limpieza: reportar, no arreglar.

### Pruebas

**Cero librerías de test.** El `pom.xml` no declara dependencias — el proyecto no usa ninguna.
`src/test/java/` existe por el layout estándar de Maven pero está vacía. Los "tests" son
`System.out.println` en `main()`, revisados visualmente.

JUnit está en el roadmap, no implementado. Los requisitos para agregarlo están en `MEMORY.md`
(buscar el paso de pruebas).

### `MEMORY.md` está ignorado a propósito

El `.gitignore` excluye `MEMORY.md` y `docs/`. Contiene los bugs confirmados, el detalle de la
revisión interna y notas de trabajo: no es documentación pública. Verificado con
`git check-ignore -v MEMORY.md`.
