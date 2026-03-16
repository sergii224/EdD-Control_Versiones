## Fases Realizadas

### Fase 1: Análisis y Planning

1. Clonado del repositorio original con Git
2. Creación de rama de trabajo:  
   `bugfix/library-issues`
3. Ejecución de la aplicación → **Bugs identificados**:

   - Permitir libros duplicados (mismo ISBN)
   - Búsqueda sensible a mayúsculas/minúsculas
   - Faltan getters/setters en algunos campos
   - No se valida si un libro ya está prestado antes de prestarlo
   - No se valida correctamente devolución de libro ya disponible
   - Error de concurrencia (`ConcurrentModificationException`) al listar libros
   - Comprobación de disponibilidad errónea (condición literal `true`)
   - Falta método para eliminar libros
   - Posibilidad de prestar un libro dos veces sin control
   - Posibilidad de devolver un libro dos veces sin control
   - Posibilidad de agregar el mismo libro varias veces

### Fase 2: Depuración (con Debugger)

Se utilizó el debugger para reproducir cada bug principal:

| Bug                              | Breakpoint aproximado | Comportamiento observado con Step Into / Step Over / Watch                              |
|----------------------------------|------------------------|-------------------------------------------------------------------------------------------|
| Libros duplicados                | línea ~8              | Se añade el mismo libro varias veces sin control de ISBN                                 |
| Búsqueda sensible a mayúsculas  | línea ~12             | `equals()` devuelve `false` cuando debería ser `true` (diferencia may/min)               |
| Prestar libro ya prestado        | línea ~19             | Sobrescribe `available = false` sin lanzar error ni mensaje                              |
| Devolver libro ya disponible     | línea ~21             | Sobrescribe `available = true` sin control                                               |
| Lista de libros disponibles      | línea ~25             | Condición literal `true` → devuelve **todos** los libros (no consulta `isAvailable()`)  |

### Fase 3: Corrección Sistematizada (Commits)

| Commit | Descripción principal                                                                 | Archivos modificados/principales cambios                              |
|--------|---------------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| 1      | Creación de clase de pruebas `LibraryTest.java` + prueba de duplicados               | `LibraryTest.java`                                                    |
| 2      | ISBN único + getters `getIsbn()` y `isAvailable()`                                   | `Book.java` + `Library.addBook()`                                     |
| 3      | Prueba unitaria de búsqueda en `LibraryTest`                                         | `LibraryTest.java`                                                    |
| 4      | Cambio a `equalsIgnoreCase()` en búsqueda por título                                 | `Library.java` (método de búsqueda)                                   |
| 5      | Refactor: limpieza y extracción de lógica de validación de ISBN                      | `Library.java`                                                        |
| 6      | Validación real de disponibilidad al prestar/devolver                                | `Book.java` + `Library.borrowBook()` / `returnBook()`                 |
| 7      | Implementación de método `removeBook()`                                              | `Library.java`                                                        |
| 8      | Corrección `ConcurrentModificationException` → copia defensiva del ArrayList         | `Library.findAvailableBooks()` → nueva copia de `books`               |

### Fase 4: Integración y Code Review

1. `git pull origin main` → resolución de conflictos
2. Commit de integración en rama `bugfix/library-issues`
3. Creación de **Pull Request** hacia `main`
4. Realización de **code review** al compañero
5. Revisión recíproca del código por parte del compañero

## Mejoras Implementadas (Resumen)

- ISBN como identificador único (evita duplicados)
- Búsqueda **case-insensitive**
- Validación robusta en préstamo y devolución
- Método `removeBook()` añadido
- Corrección de concurrencia en `findAvailableBooks()`
- Tests básicos en `LibraryTest.java`
- Getters necesarios añadidos en `Book`

## Tecnologías / Herramientas utilizadas

- Java (versión recomendada: 11+)
- Git + GitHub (ramas, pull requests, code review)
- Debugger de IntelliJ / Eclipse / VS Code
- JUnit (tests básicos)

## Estado Actual (marzo 2026)

Todos los bugs críticos identificados han sido corregidos y probados manualmente.  
Se recomienda añadir más pruebas unitarias automáticas y documentación Javadoc.

---

¡Gracias por revisar el proyecto!  
Cualquier sugerencia o mejora adicional es bienvenida mediante issues o pull requests.
