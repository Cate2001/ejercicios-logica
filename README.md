# 🧠 Ejercicios de Lógica y Programación Orientada a Objetos en Java

Este repositorio contiene una colección estructurada de **ejercicios de lógica de programación, proyectos de POO y prácticas con Colecciones** desarrollados en Java, organizados siguiendo estándares profesionales de arquitectura de software y buenas prácticas de desarrollo.

El proyecto demuestra dominio técnico en **pensamiento lógico**, **estructuras de datos**, **colecciones**, **patrones de diseño**, y **arquitectura orientada a objetos**, simulando escenarios reales del entorno corporativo de desarrollo Java.

---

## 🎯 Objetivo del Proyecto

- **Fortalecer la lógica algorítmica** mediante ejercicios progresivos de complejidad
- **Aplicar principios SOLID** y patrones de diseño en arquitectura orientada a objetos
- **Dominar el uso de Colecciones** (List, Set, Map) en sistemas de gestión
- **Demostrar capacidad de análisis** y diseño de soluciones escalables y mantenibles
- **Implementar buenas prácticas de Clean Code** y organización de paquetes
- **Servir como portafolio técnico** profesional para procesos de selección en desarrollo Java

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura modular organizada en tres grandes categorías:

### 📂 Estructura de Directorios

```
src/com/cate/
├── ejercicios/
│   └── basicos/                 # Ejercicios fundamentales de lógica
│       ├── arreglos/           # Manipulación de arrays y algoritmos
│       ├── basicos/            # Conceptos básicos de Java
│       ├── ciclos/             # Estructuras iterativas
│       ├── condicionales/      # Lógica condicional
│       ├── funciones/         # Métodos y programación funcional
│       ├── matrices/           # Matrices bidimensionales
│       └── recursividad/       # Algoritmos recursivos
│
├── practica/
│   └── nuevos/
│       └── conceptos/
│           └── colecciones/    # Prácticas con el framework de Colecciones
│               ├── SGB/        # Sistema de Gestión de Biblioteca
│               │   ├── app/
│               │   ├── enums/
│               │   ├── model/
│               │   ├── repository/
│               │   ├── services/
│               │   └── util/
│               └── SGCM/       # Sistema de Gestión de Concierto Masivo
│                   ├── app/
│                   ├── enums/
│                   ├── model/
│                   ├── service/
│                   └── util/
│
└── proyectos/
    └── poo/
        └── basico/
            ├── SIGRAV/              # Sistema de Gestión de Rutas Aéreas
            │   ├── app/
            │   └── model/
            ├── SIMAP/               # Sistema de Gestión de Parqueaderos
            │   ├── app/
            │   └── model/
            ├── herencia/
            │   └── abstraccion/
            │       └── interfaces/  # Proyectos de herencia, abstracción e interfaces
            │           ├── GestionPersonasUniversidad/
            │           │   ├── app/
            │           │   ├── enums/
            │           │   ├── model/
            │           │   └── services/
            │           ├── SGVE/      # Sistema de Gestión de Vehículos de Envío
            │           │   ├── app/
            │           │   ├── enums/
            │           │   ├── interfaces/
            │           │   ├── model/
            │           │   ├── services/
            │           │   └── util/
            │           ├── SportifyTech/
            │           │   ├── app/
            │           │   ├── enums/
            │           │   ├── model/
            │           │   └── services/
            │           └── fitlife/
            │               ├── app/
            │               ├── enums/
            │               ├── model/
            │               ├── services/
            │               └── util/
            └── orden/
                └── compra/          # Sistema de órdenes de compra
```

### 🎨 Patrones de Arquitectura Implementados

- **Separación de Responsabilidades**: Capas diferenciadas (app, model, services, util, enums, interfaces, repository)
- **Domain-Driven Design**: Organización por dominios de negocio
- **Repository Pattern**: Capa de acceso a datos abstraída (SGB)
- **Encapsulamiento**: Clases con atributos privados y acceso controlado
- **Herencia y Polimorfismo**: Uso de clases abstractas y interfaces
- **Interfaces**: Contratos de comportamiento (GPS, Recargable)
- **Inmutabilidad**: Objetos con atributos finales donde aplica
- **Validación de Dominio**: Lógica de validación en constructores y setters
- **Servicios**: Capa de lógica de negocio separada del modelo

---

## 🧩 Contenidos Técnicos

### 🔹 Fundamentos de Lógica de Programación

**Arreglos y Algoritmos**
- Rotación de arreglos
- Eliminación de duplicados
- Inversión de arrays
- Reorganización de elementos (ceros al final)
- Orden inverso

**Matrices**
- Suma de matrices
- Transposición
- Matriz identidad
- Operaciones bidimensionales

**Estructuras de Control**
- Condicionales anidados
- Bucles for/while
- Control de flujo complejo

**Recursividad**
- Suma recursiva de arrays
- Conteo hacia atrás y adelante
- Suma de números consecutivos
- Cálculo de potencias
- Búsqueda de números en arrays
- Búsqueda del número mayor
- División y conquista
- Backtracking básico

### 🔹 Colecciones en Java

**SGB - Sistema de Gestión de Biblioteca**
- Gestión de libros, usuarios y préstamos con ArrayList y HashMap
- CRUD completo con búsqueda por múltiples criterios
- Repositorio en memoria usando colecciones
- Validación de préstamos activos y fechas de devolución
- Separación en capas: service, repository, model, util

**SGCM - Sistema de Gestión de Concierto Masivo**
- Gestión de bandas, boletas, sillas y asistentes
- Clasificación de boletas por tipo (VIP, General) con precios
- Organización de sillas por categoría y disposición en el estadio
- Uso de enums para estado de boleta, género musical y categoría
- Validaciones de dominio y generación de IDs

### 🔹 Programación Orientada a Objetos Avanzada

**SIGRAV - Sistema de Gestión de Rutas Aéreas**
- Cálculo de costos de vuelos
- Motor de rutas con matriz de adyacencia
- Asignación de aviones a rutas
- Validación de rutas posibles/imposibles

**SIMAP - Sistema de Gestión de Parqueaderos**
- Registro de entrada/salida de vehículos
- Cálculo de tarifas por tiempo
- Gestión de espacios disponibles
- Validación de placas

**Gestión de Personas Universidad**
- Herencia: Persona → Estudiante/Profesor
- Enumeraciones para tipos de persona
- Servicio de gestión de personas
- Validación de dominio

**SGVE - Sistema de Gestión de Vehículos de Envío**
- Clase abstracta Vehiculo con atributos comunes (placa, marca, capacidadCarga, estado, distanciaRecorrida)
- Clases concretas: Dron, Moto, Camion con atributos específicos
  - Dron: nivelBateria, alturaMaxima, consumoBateria (implementa GPS y Recargable)
  - Moto: cilindraje, consumoGasolina (implementa GPS)
  - Camion: numeroEjes, pesoActualCarga, costoPeajes (implementa GPS)
- Interfaces: GPS (ubicación) y Recargable (batería)
- Enumeración de estados: DISPONIBLE, EN_RUTA, MANTENIMIENTO
- Clase de utilidades Constantes con valores centralizados (COSTO_BASE, BATERIA_MAXIMA, COSTO_KM_CAMION)
- Servicio VehiculoService con gestión dinámica usando ArrayList
- Validaciones exhaustivas de dominio en constructores y setters
- Cálculo de costos de envío personalizado por tipo de vehículo
- Pruebas unitarias con 19 casos de prueba

**SportifyTech - Plataforma Deportiva**
- Competidores y entrenadores
- Niveles de habilidad (PRINCIPIANTE, INTERMEDIO, AVANZADO)
- Asignación inteligente de entrenadores
- Validación de aptitud física

**FitLife - Sistema de Gimnasio**
- Clases abstractas: Miembro → Estudiantil/Estandar/VIP
- Tipos de membresía con precios y beneficios
- Registro de asistencia por día
- Cálculo de pagos con descuentos
- Utilidades de cálculo (IVA, precios)

**Sistema de Órdenes de Compra**
- Clase OrdenCompra con identificador único autoincremental
- Gestión de clientes (nombre, apellido)
- Gestión de productos (fabricante, nombre, precio)
- Capacidad máxima de 4 productos por orden
- Cálculo automático del gran total de la orden
- Validaciones exhaustivas de dominio en constructores y setters
- Manejo de fechas de orden
- Clases: Cliente, Producto, OrdenCompra, EjemploOrdenes
- Validación de límites de capacidad de productos
- Excepciones con mensajes claros para validaciones

### 🔹 Buenas Prácticas Implementadas

- **Clean Code**: Nombres descriptivos, métodos cortos, responsabilidad única
- **SOLID**: Principios de diseño orientado a objetos
- **Validaciones**: Excepciones con mensajes claros
- **Encapsulamiento**: Getters/Setters controlados
- **Constantes**: Uso de final para valores inmutables
- **Equals/HashCode**: Implementación correcta para comparación de objetos
- **ToString**: Representación legible de objetos
- **Documentación**: Comentarios explicativos en código complejo

---

## 🛠️ Stack Tecnológico

- **Java 21**: Lenguaje de programación principal
- **IntelliJ IDEA**: IDE de desarrollo
- **Git**: Control de versiones

---

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- JDK 21 o superior instalado
- IntelliJ IDEA o IDE compatible con Java
- Git (para clonar el repositorio)

### Pasos de Ejecución

1. **Clonar el repositorio**
   ```bash
   git clone [URL-del-repositorio]
   cd ejercicios-logica
   ```

2. **Abrir en IntelliJ IDEA**
   - File → Open → Seleccionar directorio del proyecto
   - Esperar a que IntelliJ indexe el proyecto

3. **Ejecutar ejercicios básicos**
   - Navegar a `src/com/cate/ejercicios/basicos/[categoria]`
   - Seleccionar el archivo Java correspondiente
   - Click derecho → Run 'NombreClase'

4. **Ejecutar proyectos POO y prácticas**
   - Navegar a `src/com/cate/[proyecto]/app`
   - Ejecutar la clase Main.java

### Ejemplos de Ejecución

**Ejercicio Básico - Arreglos**
```bash
Run: com.cate.ejercicios.basicos.arreglos.EliminarValoresDuplicados
```

**Práctica - SGB (Biblioteca)**
```bash
Run: com.cate.practica.nuevos.conceptos.colecciones.SGB.app.Main
```

**Práctica - SGCM (Concierto Masivo)**
```bash
Run: com.cate.practica.nuevos.conceptos.colecciones.SGCM.app.Main
```

**Proyecto POO - SIGRAV**
```bash
Run: com.cate.proyectos.poo.basico.SIGRAV.app.Main
```

**Proyecto POO - SGVE**
```bash
Run: com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.SGVE.app.Main
```

**Proyecto POO - FitLife**
```bash
Run: com.cate.proyectos.poo.basico.herencia.abstraccion.interfaces.fitlife.app.Main
```

**Proyecto POO - Órdenes de Compra**
```bash
Run: com.cate.proyectos.poo.basico.orden.compra.EjemploOrdenes
```

---

## 📊 Métricas del Proyecto

- **Total de ejercicios básicos**: 19
- **Total de proyectos POO**: 7
- **Total de prácticas con Colecciones**: 2
- **Total de proyectos**: 9
- **Total de archivos Java**: 99
- **Clases abstractas**: 3 (Material, Miembro, Vehiculo)
- **Interfaces implementadas**: 2 (GPS, Recargable)
- **Enumeraciones**: 14
- **Clases de utilidades**: 4
- **Líneas de código**: ~5000+
- **Complejidad algorítmica**: Básica a Intermedia
- **Patrones de diseño**: Strategy, Template Method, Factory, Service Layer, Repository (implícitos)
- **Casos de prueba unitarios**: 19 (SGVE)

---

## 🎓 Conceptos Clave Demostrados

### Lógica de Programación
- ✅ Análisis de complejidad algorítmica
- ✅ Optimización de estructuras de datos
- ✅ Manejo eficiente de memoria
- ✅ Algoritmos de ordenamiento y búsqueda

### Colecciones de Java
- ✅ ArrayList y LinkedList
- ✅ HashMap y TreeMap
- ✅ HashSet y TreeSet
- ✅ Iteración y búsqueda en colecciones
- ✅ Complejidad Big-O en operaciones con colecciones

### Programación Orientada a Objetos
- ✅ Encapsulamiento y abstracción
- ✅ Herencia y polimorfismo
- ✅ Interfaces y clases abstractas
- ✅ Implementación de múltiples interfaces
- ✅ Composición sobre herencia
- ✅ Principios SOLID

### Arquitectura de Software
- ✅ Separación de capas
- ✅ Domain-Driven Design básico
- ✅ Repository Pattern
- ✅ Inyección de dependencias (manual)
- ✅ Manejo de excepciones
- ✅ Validación de dominio

---

## 👩‍💻 Autora

**Caterine Salinas Bolaños**  
Desarrolladora Java Junior  
Colombia  

📌 Repositorio desarrollado como portafolio técnico y proceso de fortalecimiento en desarrollo Java profesional.

---

## 📈 Roadmap de Mejoras Futuras

- [ ] Implementar tests unitarios con JUnit 5
- [ ] Agregar integración continua con GitHub Actions
- [x] Documentación con JavaDoc
- [ ] Implementar patrones de diseño adicionales
- [ ] Agregar persistencia con JDBC/JPA
- [ ] Crear API REST con Spring Boot
- [ ] Implementar logging con SLF4J/Logback

---

## 📄 Licencia

Este proyecto es de uso educativo y portafolio técnico. El código es propiedad de la autora y puede ser utilizado como referencia para fines de aprendizaje.

---

⭐ *Este repositorio representa el compromiso con la excelencia técnica y el aprendizaje continuo en desarrollo de software profesional.*
