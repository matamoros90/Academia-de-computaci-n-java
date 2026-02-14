# 🔒 Encapsulamiento en el Proyecto JavaLegacyChallenge

**Curso:** Programación III  
**Tema:** Encapsulamiento en Java  
**Proyecto:** Sistema de Gestión — Academia de Computación

---

## ¿Qué es el Encapsulamiento?

El encapsulamiento es un pilar fundamental de la Programación Orientada a Objetos (POO) que consiste en **ocultar los datos internos** de una clase y exponer únicamente una interfaz controlada (métodos públicos) para interactuar con ellos. Esto se logra mediante:

- **Atributos `private`**: no son accesibles directamente desde fuera de la clase.
- **Métodos `public` (getters/setters)**: permiten leer y modificar los datos de forma controlada.

---

## Aplicación en el Proyecto

### 1. Clase `Persona` (Superclase)

Los atributos `nombre` y `edad` están declarados como `private`, lo que impide el acceso directo desde otras clases o subclases:

```java
private String nombre;
private int edad;
```

Para acceder a estos datos se proporcionan **getters y setters** públicos:

```java
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }

public int getEdad() { return edad; }
public void setEdad(int edad) { this.edad = edad; }
```

> **Beneficio:** Si en el futuro se necesita validar que la edad no sea negativa, solo se modifica el método `setEdad()` sin afectar el resto del código.

---

### 2. Clase `Alumno` (Subclase de Persona)

Extiende de `Persona` y agrega sus propios atributos privados:

```java
private String carnet;
private double promedio;
```

Con sus respectivos getters y setters:

```java
public String getCarnet() { return carnet; }
public void setCarnet(String carnet) { this.carnet = carnet; }

public double getPromedio() { return promedio; }
public void setPromedio(double promedio) { this.promedio = promedio; }
```

> **Dato clave:** Aunque `Alumno` hereda `nombre` y `edad` de `Persona`, no puede acceder directamente a esos atributos (son `private` en `Persona`). Debe usar `getNombre()` y `getEdad()` heredados, respetando el encapsulamiento del padre.

---

### 3. Clase `Instructor` (Subclase de Persona)

Mismo patrón de encapsulamiento con su atributo propio:

```java
private String especialidad;

public String getEspecialidad() { return especialidad; }
public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
```

---

### 4. Clase `Academia` (Lógica de negocio)

Encapsula la colección interna de alumnos:

```java
private ArrayList<Alumno> alumnos;
```

La lista **no se expone directamente**. En su lugar, se ofrecen métodos controlados:

| Método                  | Descripción                                        |
| ----------------------- | -------------------------------------------------- |
| `inscribir(Alumno)`     | Agrega un alumno validando que el carnet sea único |
| `listar()`              | Muestra todos los alumnos inscritos                |
| `buscar(String carnet)` | Busca un alumno por su carnet                      |

> **Beneficio:** Nadie puede manipular la lista directamente (agregar duplicados, eliminar sin validar, etc.). Toda operación pasa por los métodos de la clase, que incluyen las reglas de negocio.

---

## Diagrama Resumen

```
┌──────────────────────────────────────────────────────┐
│                    ENCAPSULAMIENTO                    │
├──────────────────────────────────────────────────────┤
│                                                      │
│  Clase Persona                                       │
│  ├─ private nombre, edad        ← Datos protegidos  │
│  └─ public get/set              ← Acceso controlado │
│                                                      │
│  Clase Alumno extends Persona                        │
│  ├─ private carnet, promedio    ← Datos protegidos  │
│  └─ public get/set              ← Acceso controlado │
│                                                      │
│  Clase Instructor extends Persona                    │
│  ├─ private especialidad        ← Datos protegidos  │
│  └─ public get/set              ← Acceso controlado │
│                                                      │
│  Clase Academia                                      │
│  ├─ private alumnos (ArrayList) ← Colección oculta  │
│  └─ public inscribir/listar/    ← Operaciones       │
│          buscar                    controladas       │
│                                                      │
└──────────────────────────────────────────────────────┘
```

---

## Conclusión

El encapsulamiento se aplicó de manera consistente en **todas las clases** del proyecto:

1. **Todos los atributos** son `private` — ningún dato queda expuesto directamente.
2. **Todos los accesos** se realizan mediante getters y setters públicos.
3. **La lógica de negocio** en `Academia` protege la integridad de los datos (validación de carnet único).
4. **Las subclases** respetan el encapsulamiento del padre, accediendo a los atributos heredados solo a través de métodos públicos.

Esto garantiza **protección de datos, mantenibilidad y flexibilidad** para futuras modificaciones sin romper el código existente.

---

**Repositorio GitHub:** _(agregar enlace aquí)_
