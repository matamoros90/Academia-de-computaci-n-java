// Clase base (superclase) que representa a una persona genérica.
// Usa encapsulamiento: atributos private + getters/setters public.

public class Persona {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Representación en texto del objeto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
