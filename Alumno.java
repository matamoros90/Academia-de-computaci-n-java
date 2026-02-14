// Subclase que hereda de Persona.
// Agrega atributos propios: carnet y promedio.

public class Alumno extends Persona {

    // Atributos privados propios de Alumno
    private String carnet;
    private double promedio;

    // Constructor: usa super() para inicializar nombre y edad de Persona
    public Alumno(String nombre, int edad, String carnet, double promedio) {
        super(nombre, edad);
        this.carnet = carnet;
        this.promedio = promedio;
    }

    // Getters y Setters
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

    // toString sobreescrito: reutiliza el de Persona con super.toString()
    @Override
    public String toString() {
        return super.toString() + ", Carnet: " + carnet + ", Promedio: " + promedio;
    }
}
