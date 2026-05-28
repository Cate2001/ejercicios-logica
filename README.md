# 🧠 Ejercicios de Lógica y Programación Orientada a Objetos en Java

Este repositorio contiene una colección estructurada de **ejercicios de lógica de programación y proyectos de Programación Orientada a Objetos (POO)** desarrollados en Java, organizados siguiendo estándares profesionales de arquitectura de software y buenas prácticas de desarrollo.

El proyecto demuestra dominio técnico en **pensamiento lógico**, **estructuras de datos**, **patrones de diseño**, y **arquitectura orientada a objetos**, simulando escenarios reales del entorno corporativo de desarrollo Java.

---

## 🎯 Objetivo del Proyecto

- **Fortalecer la lógica algorítmica** mediante ejercicios progresivos de complejidad
- **Aplicar principios SOLID** y patrones de diseño en arquitectura orientada a objetos
- **Demostrar capacidad de análisis** y diseño de soluciones escalables y mantenibles
- **Implementar buenas prácticas de Clean Code** y organización de paquetes
- **Servir como portafolio técnico** profesional para procesos de selección en desarrollo Java

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura modular organizada en dos grandes categorías:

### 📂 Estructura de Directorios

```
src/
├── ejercicios_basicos/          # Ejercicios fundamentales de lógica
│   ├── arreglos/                # Manipulación de arrays y algoritmos
│   ├── basicos/                 # Conceptos básicos de Java
│   ├── ciclos/                  # Estructuras iterativas
│   ├── condicionales/           # Lógica condicional
│   ├── funciones/              # Métodos y programación funcional
│   ├── matrices/                # Matrices bidimensionales
│   └── recursividad/            # Algoritmos recursivos
│
└── proyectos_poo/               # Proyectos de Programación Orientada a Objetos
    └── poo_basico/
        ├── SIGRAV/              # Sistema de Gestión de Rutas Aéreas
        │   ├── app/             # Capa de aplicación/presentación
        │   └── model/           # Modelo de dominio
        ├── SIMAP/               # Sistema de Gestión de Parqueaderos
        │   ├── app/
        │   └── model/
        ├── herencia_abstraccion/# Proyectos de herencia y abstracción
        │   ├── GestionPersonasUniversidad/
        │   │   ├── app/
        │   │   ├── enums/
        │   │   ├── model/
        │   │   └── services/
        │   ├── PersonasCompania/
        │   │   ├── app/
        │   │   └── model/
        │   ├── SportifyTech/
        │   │   ├── app/
        │   │   ├── enums/
        │   │   ├── model/
        │   │   └── services/
        │   └── fitlife/
        │       ├── app/
        │       ├── enums/
        │       ├── model/
        │       ├── services/
        │       └── util/
        └── orden_compra/        # Sistema de órdenes de compra
```

### 🎨 Patrones de Arquitectura Implementados

- **Separación de Responsabilidades**: Capas diferenciadas (app, model, services, util, enums)
- **Domain-Driven Design**: Organización por dominios de negocio
- **Encapsulamiento**: Clases con atributos privados y acceso controlado
- **Herencia y Polimorfismo**: Uso de clases abstractas y interfaces
- **Inmutabilidad**: Objetos con atributos finales donde aplica
- **Validación de Dominio**: Lógica de validación en constructores

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
- Algoritmos recursivos
- División y conquista
- Backtracking básico

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

**Orden de Compra**
- Gestión de clientes y productos
- Cálculo de totales
- Fechas de orden

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

- **Java 17+**: Lenguaje de programación principal
- **IntelliJ IDEA**: IDE de desarrollo
- **Git**: Control de versiones
- **Maven/Gradle**: Gestión de dependencias (según configuración del proyecto)

---

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- JDK 17 o superior instalado
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
   - Navegar a `src/ejercicios_basicos/[categoria]`
   - Seleccionar el archivo Main.java o clase principal
   - Click derecho → Run 'NombreClase'

4. **Ejecutar proyectos POO**
   - Navegar a `src/proyectos_poo/poo_basico/[proyecto]/app`
   - Ejecutar la clase Main.java
   - Verificar la salida en consola

### Ejemplos de Ejecución

**Ejercicio Básico - Arreglos**
```bash
# Ejecutar eliminación de duplicados
Run: ejercicios_basicos.arreglos.eliminarValoresDupli
```

**Proyecto POO - SIGRAV**
```bash
# Ejecutar sistema de rutas aéreas
Run: proyectos_poo.poo_basico.SIGRAV.app.Main
```

**Proyecto POO - FitLife**
```bash
# Ejecutar sistema de gimnasio
Run: proyectos_poo.poo_basico.herencia_abstraccion_interfaces.fitlife.app.Main
```

---

## 📊 Métricas del Proyecto

- **Total de ejercicios básicos**: 19
- **Total de proyectos POO**: 6
- **Clases implementadas**: 35+
- **Líneas de código**: ~3000+
- **Complejidad algorítmica**: Básica a Intermedia
- **Patrones de diseño**: Strategy, Template Method, Factory (implícitos)

---

## 🎓 Conceptos Clave Demostrados

### Lógica de Programación
- ✅ Análisis de complejidad algorítmica
- ✅ Optimización de estructuras de datos
- ✅ Manejo eficiente de memoria
- ✅ Algoritmos de ordenamiento y búsqueda

### Programación Orientada a Objetos
- ✅ Encapsulamiento y abstracción
- ✅ Herencia y polimorfismo
- ✅ Interfaces y clases abstractas
- ✅ Composición sobre herencia
- ✅ Principios SOLID

### Arquitectura de Software
- ✅ Separación de capas
- ✅ Domain-Driven Design básico
- ✅ Inyección de dependencias (manual)
- ✅ Manejo de excepciones
- ✅ Validación de dominio

---

## 👩‍💻 Autora

**Caterine Salinas Bolaños**  
Desarrolladora Java Junior  
Colombia 🇨🇴  

📌 Repositorio desarrollado como portafolio técnico y proceso de fortalecimiento en desarrollo Java profesional.

---

## 📈 Roadmap de Mejoras Futuras

- [ ] Implementar tests unitarios con JUnit 5
- [ ] Agregar integración continua con GitHub Actions
- [ ] Documentación con JavaDoc
- [ ] Implementar patrones de diseño adicionales
- [ ] Agregar persistencia con JDBC/JPA
- [ ] Crear API REST con Spring Boot
- [ ] Implementar logging con SLF4J/Logback

---

## 📄 Licencia

Este proyecto es de uso educativo y portafolio técnico. El código es propiedad de la autora y puede ser utilizado como referencia para fines de aprendizaje.

---

⭐ *Este repositorio representa el compromiso con la excelencia técnica y el aprendizaje continuo en desarrollo de software profesional.*

