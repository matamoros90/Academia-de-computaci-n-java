// ============================================================================
// PERSONA.java — CLASE BASE (Superclase)
// ============================================================================
// 
// 📚 CONCEPTO: HERENCIA y ENCAPSULAMIENTO
// 
// Esta es la clase "padre" o "base". Las clases Alumno e Instructor
// van a HEREDAR de esta clase, es decir, van a recibir automáticamente
// los atributos y métodos que definamos aquí.
//
// 🔒 ENCAPSULAMIENTO: Los atributos son "private" (privados).
// Esto significa que NADIE fuera de esta clase puede acceder directamente
// a ellos. Para leer o modificar los datos, se usan métodos públicos
// llamados "getters" (para obtener) y "setters" (para modificar).
//
// ¿Por qué hacemos esto? 
// → Para PROTEGER los datos. Si alguien quiere cambiar el nombre,
//   tiene que pasar por nuestro método setNombre(), donde podríamos
//   agregar validaciones (ej: que no sea vacío).
// ============================================================================

public class Persona {

    // -----------------------------------------------------------------------
    // ATRIBUTOS PRIVADOS (encapsulamiento)
    // -----------------------------------------------------------------------
    // "private" = solo esta clase puede ver estas variables directamente
    // Nadie más puede hacer: persona.nombre = "Juan"; ← ERROR
    // Tienen que usar: persona.setNombre("Juan"); ← CORRECTO
    // -----------------------------------------------------------------------
    private String nombre;
    private int edad;

    // -----------------------------------------------------------------------
    // CONSTRUCTOR
    // -----------------------------------------------------------------------
    // El constructor es un método especial que se ejecuta cuando creas
    // un nuevo objeto con "new Persona(...)".
    // Su trabajo es INICIALIZAR los atributos del objeto.
    //
    // Ejemplo de uso:
    //   Persona p = new Persona("María", 20);
    //   → nombre queda como "María", edad queda como 20
    // -----------------------------------------------------------------------
    public Persona(String nombre, int edad) {
        // "this" se refiere al objeto actual.
        // this.nombre = el atributo de la clase
        // nombre (sin this) = el parámetro que recibimos
        this.nombre = nombre;
        this.edad = edad;
    }

    // -----------------------------------------------------------------------
    // GETTERS — Métodos para OBTENER (leer) los valores
    // -----------------------------------------------------------------------
    // Son públicos porque queremos que otras clases puedan LEER los datos,
    // pero no modificarlos directamente.
    // -----------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // -----------------------------------------------------------------------
    // SETTERS — Métodos para MODIFICAR (escribir) los valores
    // -----------------------------------------------------------------------
    // Aquí podrías agregar validaciones, por ejemplo:
    //   if (edad < 0) throw new IllegalArgumentException("Edad inválida");
    // -----------------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // -----------------------------------------------------------------------
    // toString() — Representación en texto del objeto
    // -----------------------------------------------------------------------
    // Cuando haces System.out.println(persona), Java llama automáticamente
    // a este método para convertir el objeto en un String legible.
    // Si no lo defines, imprimiría algo como: Persona@1a2b3c4 (inútil)
    // -----------------------------------------------------------------------
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
