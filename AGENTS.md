# AGENTS.md — ejercicios-logica

## Project type
- Plain Java / IntelliJ IDEA module — **no Maven, no Gradle, no build tool**
- JDK 21 (with preview features) configured in IDE; JDK 24 available on PATH
- No `.gitignore` at root — only `.idea/.gitignore`

## No test framework
- Zero JUnit or any test library. "Tests" are `System.out.println` in `main()` methods — visually inspected only.
- JUnit 5 is on the roadmap (not yet implemented).
- Each POO project's `app/Main.java` doubles as a manual test harness.

## Conventions
- **All identifiers, comments, and output in Spanish** (descripcion, vehiculo, cliente).
- Package root: `com.cate.*`
- POO projects follow consistent layering under `<project>/`:
  - `app/` — entry point (`Main.java`)
  - `model/` — domain classes
  - `services/` or `service/` — business logic
  - `enums/` — enumerations
  - `util/` — helpers
  - `repository/` — data access (SGB only)
  - `interfaces/` — interface definitions (SGVE only)

## Package structure
```
com.cate.ejercicios.basicos/{arreglos,basicos,ciclos,condicionales,funciones,matrices,recursividad}
com.cate.proyectos.poo.basico.{SIGRAV,SIMAP,orden.compra,herencia.abstraccion.interfaces.{fitlife,GestionPersonasUniversidad,SGVE,SportifyTech}}
com.cate.practica.nuevos.conceptos.colecciones.{SGB,SGCM}
```

## Entry points (fully-qualified class names)
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
com.cate.practica.nuevos.conceptos.colecciones.SGCM.app.Main
```

## Compile & run (terminal)
```bash
javac -d out/production/ejercicios-logica src/com/cate/**/*.java
java -cp out/production/ejercicios-logica com.cate.proyectos.poo.basico.SIGRAV.app.Main
```

## README is outdated
- Directory tree in README is simplified and does not match the actual deeper package layout.
- Metrics (52 files, 7 POO projects) exclude the two practice projects under `practica/` (SGB, SGCM — ~extra files).
- README claims Maven/Gradle "según configuración del proyecto" — neither is present.

## Undocumented projects
- `com.cate.practica.nuevos.conceptos.colecciones.SGB` (Biblioteca)
- `com.cate.practica.nuevos.conceptos.colecciones.SGCM` (Conciertos Musicales)
- Not listed in README metrics or tree.

## Code style quirks
- `static void main` (without `public`) found in SGVE::Main — likely a typo, not idiomatic.
- `IllegalArgumentException` for validation errors.
- `StringBuilder` for `toString()`.
- Auto-increment via `static int ultimoId` in model classes.
- Javadoc in Spanish with `@author` and `@version` tags.
