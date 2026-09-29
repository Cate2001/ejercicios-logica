# Ejercicios de lógica de programación

Repositorio dedicado a la práctica y fortalecimiento de la lógica de programación mediante ejercicios desarrollados en Java.

El repositorio reúne ejercicios progresivos orientados a desarrollar la capacidad de análisis, resolución de problemas y aplicación de fundamentos de programación, junto con **ocho sistemas de gestión de dominio** que aplican esos fundamentos en un contexto de negocio real.

---

## 🎯 Objetivo

El objetivo principal de este proyecto es fortalecer la lógica de programación mediante la resolución progresiva de problemas en Java.

A través de los ejercicios se busca desarrollar:

* Capacidad de análisis y descomposición de problemas.
* Pensamiento algorítmico.
* Manejo de estructuras de control.
* Uso de estructuras de datos.
* Programación orientada a objetos.
* Aplicación de buenas prácticas de programación.
* Capacidad para identificar, analizar y mejorar soluciones.

El repositorio tiene dos partes, y ambas se sostienen mutuamente:

* **23 ejercicios** de sintaxis y algoritmia, organizados de menor a mayor dificultad.
* **8 sistemas de gestión de dominio** donde esos conceptos se aplican sobre problemas reales, con arquitectura por capas, herencia, interfaces, enumeraciones y validación de dominio.

Los ejercicios son la base; los sistemas son donde se aplica.

---

## 🛠️ Tecnologías y herramientas

* Java
* JDK 21
* Maven 3.9 o superior
* IntelliJ IDEA
* Git
* GitHub

---

## 📚 Contenido

Los ejercicios se organizan progresivamente de acuerdo con los conceptos de programación que se van trabajando.

### Fundamentos

* Variables y tipos de datos.
* Operadores.
* Entrada y salida de datos.
* Conversión de tipos.

### Estructuras de control

* Condicionales.
* Operadores lógicos.
* Ciclos.
* Acumuladores y contadores.

### Métodos

* Declaración y uso de métodos.
* Parámetros.
* Retorno de valores.
* Descomposición de problemas.

### Estructuras de datos

* Arrays.
* Strings.
* Colecciones.
* Manejo y recorrido de datos.

### Programación orientada a objetos

* Clases y objetos.
* Encapsulamiento.
* Constructores.
* Herencia.
* Polimorfismo.
* Interfaces.
* Enumeraciones.
* Excepciones.

### Resolución de problemas

Ejercicios que combinan progresivamente diferentes conceptos para resolver problemas de mayor complejidad.

### Sistemas de gestión de dominio

Ocho sistemas donde los conceptos anteriores se aplican sobre un problema de negocio concreto. Cada uno tiene su propia capa de modelo, servicio y punto de entrada.

| Sistema | Problema que resuelve |
|---|---|
| **SGVE** — Gestión de Vehículos de Envío | Cálculo de costos de envío sobre una flota heterogénea (drones, motos, camiones) con contratos `GPS` y `Recargable` |
| **SGB** — Gestión de Biblioteca | Catálogo, préstamos y devoluciones de materiales heterogéneos con horario semanal y control de disponibilidad |
| **FitLife** — Gestión de Gimnasio | Membresías, asistencias e ingresos, con tres tipos de socio y cálculo de pagos con descuentos e IVA |
| **SportifyTech** — Plataforma Deportiva | Asignación de competidores a entrenadores según nivel, con validación de aptitud física |
| **SIGRAV** — Gestión de Rutas Aéreas | Optimización y costeo de rutas comerciales mediante matriz de adyacencia |
| **SIMAP** — Gestión de Parqueaderos | Registro de vehículos y cobro por tiempo de estadía con tarifas por espacio |
| **Gestión de Personas Universidad** | Jerarquía de tipos de persona con responsabilidades diferenciadas según rol |
| **Órdenes de Compra** | Ciclo de compra con cálculo de totales, límites de capacidad y control de fechas |

Cada sistema incluye un `Main` con escenarios de prueba manual que ejercitan sus casos principales.

---

## 🗺️ Ruta de aprendizaje

El proyecto sigue una progresión desde fundamentos de programación hacia conceptos de mayor complejidad.

```text
Fundamentos
    ↓
Estructuras de control
    ↓
Métodos
    ↓
Arrays y Strings
    ↓
Colecciones
    ↓
Programación Orientada a Objetos
    ↓
Excepciones
    ↓
Genéricos
    ↓
Problemas integradores
```

> **Estado real de la ruta:** los pasos de *Fundamentos* a *Programación Orientada a Objetos* tienen ejercicios que los ejercitan. *Excepciones* se aplica dentro de los sistemas. *Genéricos* y *Problemas integradores* están planificados y aún no tienen ejercicios propios.

---

## 📁 Organización del proyecto

Los ejercicios se organizan de acuerdo con los conceptos que se están practicando. Los sistemas se organizan por dominio de negocio.

```text
.
├── pom.xml                         # Configuración de Maven
│
src/
├── main/java/com/cate/         # Código de producción (86 archivos)
│   ├── ejercicios/basicos/         # Práctica de lógica algorítmica (23 archivos)
│   │   ├── arreglos/  basicos/  ciclos/  coleccion/
│   │   └── condicionales/  funciones/  matrices/  recursividad/
│   │
│   ├── proyectos/poo/basico/       # Sistemas de gestión de dominio (42 archivos)
│   │   ├── SIGRAV/                 # Gestión de rutas aéreas
│   │   ├── SIMAP/                  # Gestión de parqueaderos
│   │   ├── orden/compra/           # Órdenes de compra
│   │   └── herencia/abstraccion/interfaces/
│   │       ├── SGVE/               # Gestión de vehículos de envío
│   │       ├── fitlife/            # Gestión de gimnasio
│   │       ├── SportifyTech/       # Plataforma deportiva
│   │       └── GestionPersonasUniversidad/
│   │
│   └── practica/nuevos/conceptos/colecciones/
│       └── SGB/                # Gestión de biblioteca (21 archivos)
│
└── test/java/                  # Pruebas unitarias (aún vacía)
```

La estructura puede evolucionar conforme aumente la cantidad y complejidad de los ejercicios.

### Capas por sistema

| Capa | Responsabilidad |
|---|---|
| `app` | Punto de entrada y escenarios de prueba manual |
| `model` | Entidades de negocio y datos |
| `services` | Lógica de negocio separada del modelo |
| `repository` | Acceso a datos (solo SGB) |
| `interfaces` | Contratos de comportamiento (solo SGVE) |
| `enums` | Enumeraciones de dominio |
| `util` | Utilidades, constantes y validaciones |

---

## ▶️ Ejecución

### Con IntelliJ IDEA

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar el JDK 21.
4. Seleccionar el ejercicio o el `Main.java` del sistema a ejecutar.
5. Ejecutar la clase correspondiente.

### Desde la terminal

Requiere JDK 21 y Maven 3.9 o superior.

```bash
# Clonar
git clone https://github.com/Cate2001/ejercicios-logica.git
cd ejercicios-logica

# Compilar
mvn clean compile

# Ejecutar un sistema
mvn -q compile exec:java -Dexec.mainClass="com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.app.Main"
```

Desde IntelliJ: abrir la carpeta del proyecto. IntelliJ detecta el `pom.xml` y lo importa
como módulo Maven automáticamente; luego se elige el `Main.java` del sistema y se ejecuta.

### Puntos de entrada

| Sistema | Clase principal |
|---|---|
| SGVE | `com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.app.Main` |
| SGB | `com.cate.practica.nuevos.conceptos.colecciones.SGB.app.Main` |
| FitLife | `com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.app.Main` |
| SportifyTech | `com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SportifyTech.app.Main` |
| SIGRAV | `com.cate.proyectos.poo.basico.SIGRAV.app.Main` |
| SIMAP | `com.cate.proyectos.poo.basico.SIMAP.app.Main` |
| Universidad | `com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.GestionPersonasUniversidad.app.Main` |
| Órdenes | `com.cate.proyectos.poo.basico.orden.compra.EjemploOrdenes` |
| Ejercicios | `com.cate.ejercicios.basicos.recursividad.Main` |

---

## 📊 Estado actual

El estado se actualiza en este README a medida que avanza el proyecto.

| Área | Estado |
|---|---|
| Ejercicios de lógica (23) | Completos, organizados por concepto y dificultad |
| Sistemas de dominio (8) | Completos, con escenarios de prueba manual |
| SGB — modelo y repositorio | En construcción: 1 de 4 repositorios con métodos implementados |
| SGB — capa de servicio | Pendiente: lógica de préstamo y devolución |
| Build | Maven — `pom.xml` sin dependencias externas |
| Pruebas automatizadas | No iniciadas — `src/test/java/` está vacía |
| Persistencia | Solo en memoria |

**Tema en el que se está trabajando actualmente:** revisión de elección de estructuras de datos en los sistemas, con el fin de justificar cada decisión de colección —array, `List` o `Map`— según el problema que resuelve y no por costumbre.

---

## 🎓 Propósito del repositorio

Este repositorio forma parte del proceso de aprendizaje y fortalecimiento de habilidades de programación en Java.

Los ejercicios pueden ser modificados, refactorizados y mejorados a medida que se incorporan nuevos conocimientos y mejores prácticas.

---

**Caterine Salinas Bolaños** — Desarrolladora Java Junior · Colombia
[caterines2001@gmail.com](mailto:caterines2001@gmail.com) · [LinkedIn](https://www.linkedin.com/in/caterine-salinas-bolaños-2078781a4)
