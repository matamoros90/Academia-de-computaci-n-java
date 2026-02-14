// ============================================================================
// INSTRUCTOR.java — SUBCLASE que hereda de Persona
// ============================================================================
//
// 📚 Misma lógica que Alumno, pero con atributos diferentes.
//
// Esto demuestra el PODER de la herencia:
// Tanto Alumno como Instructor comparten nombre y edad (de Persona),
// pero cada uno tiene sus propios datos adicionales:
//   → Alumno tiene carnet y promedio
//   → Instructor tiene especialidad
//
// Si el ejercicio lo pidiera, podrías tener un ArrayList<Persona>
// que almacene TANTO alumnos como instructores, porque ambos "son" Persona.
// Eso se llama POLIMORFISMO (tratar diferentes tipos como si fueran uno).
// ============================================================================

public class Instructor extends Persona {

    // Atributo propio de Instructor
    private String especialidad;

    // Constructor: inicializa Persona (con super) + especialidad
    public Instructor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    // Getter y Setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // toString sobreescrito
    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}
