// Subclase que hereda de Persona.
// Agrega atributo propio: especialidad.

public class Instructor extends Persona {

    // Atributo privado propio de Instructor
    private String especialidad;

    // Constructor: usa super() para inicializar nombre y edad
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
