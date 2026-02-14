// ============================================================================
// ALUMNO.java — SUBCLASE que hereda de Persona
// ============================================================================
//
// 📚 CONCEPTO: HERENCIA con "extends"
//
// "extends Persona" significa que Alumno HEREDA todo lo de Persona:
//   → Los atributos (nombre, edad) — aunque son private, se acceden por getters
//   → Los métodos (getNombre, getEdad, setNombre, setEdad, toString)
//
// Alumno agrega sus PROPIOS atributos: carnet y promedio.
// Así evitamos repetir código. Si mañana necesitamos agregar "teléfono"
// a todas las personas, solo lo agregamos en Persona y todas las subclases
// lo heredan automáticamente.
//
// 📚 CONCEPTO: "super()"
// Cuando Alumno tiene un constructor, necesita llamar al constructor de 
// Persona para inicializar nombre y edad. Esto se hace con super(nombre, edad).
// "super" = "llama al constructor de mi clase padre"
// ============================================================================

public class Alumno extends Persona {

    // -----------------------------------------------------------------------
    // ATRIBUTOS PROPIOS de Alumno (además de los heredados)
    // -----------------------------------------------------------------------
    // Estos son EXCLUSIVOS de Alumno. La clase Persona no los tiene.
    // También son private (encapsulamiento).
    // -----------------------------------------------------------------------
    private String carnet;
    private double promedio;

    // -----------------------------------------------------------------------
    // CONSTRUCTOR de Alumno
    // -----------------------------------------------------------------------
    // Recibe TODO: nombre, edad (para Persona) + carnet, promedio (para Alumno)
    //
    // Ejemplo de uso:
    // Alumno a = new Alumno("Carlos", 19, "2024-001", 85.5);
    //
    // Lo que sucede internamente:
    // 1. super("Carlos", 19) → llama al constructor de Persona
    // → Persona guarda nombre="Carlos" y edad=19
    // 2. this.carnet = "2024-001" → Alumno guarda su propio carnet
    // 3. this.promedio = 85.5 → Alumno guarda su propio promedio
    // -----------------------------------------------------------------------
    public Alumno(String nombre, int edad, String carnet, double promedio) {
        super(nombre, edad); // ← Llama al constructor de Persona
        this.carnet = carnet;
        this.promedio = promedio;
    }

    // -----------------------------------------------------------------------
    // GETTERS y SETTERS propios de Alumno
    // -----------------------------------------------------------------------
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    // -----------------------------------------------------------------------
    // toString() — Sobreescribimos el de Persona
    // -----------------------------------------------------------------------
    // @Override indica que estamos REEMPLAZANDO el toString() de Persona.
    // Usamos super.toString() para reutilizar lo que ya hace Persona
    // y le agregamos nuestros datos propios.
    //
    // Resultado: "Nombre: Carlos, Edad: 19, Carnet: 2024-001, Promedio: 85.5"
    // -----------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + ", Carnet: " + carnet + ", Promedio: " + promedio;
    }
}
