// Clase que maneja la lógica de negocio de la academia.
// Usa ArrayList para almacenar alumnos de forma dinámica.

import java.util.ArrayList;

public class Academia {

    // Lista dinámica de alumnos (private para proteger el acceso)
    private ArrayList<Alumno> alumnos;

    // Constructor: inicializa la lista vacía
    public Academia() {
        this.alumnos = new ArrayList<>();
    }

    // Inscribe un alumno validando que el carnet no esté duplicado
    public boolean inscribir(Alumno nuevoAlumno) {
        for (Alumno alumnoExistente : alumnos) {
            if (alumnoExistente.getCarnet().equals(nuevoAlumno.getCarnet())) {
                return false; // Carnet duplicado
            }
        }
        alumnos.add(nuevoAlumno);
        return true;
    }

    // Lista todos los alumnos inscritos
    public void listar() {
        if (alumnos.isEmpty()) {
            System.out.println("  No hay alumnos inscritos.");
            return;
        }

        System.out.println("  ┌─────────────────────────────────────────────────────┐");
        System.out.println("  │            LISTA DE ALUMNOS INSCRITOS               │");
        System.out.println("  └─────────────────────────────────────────────────────┘");

        int contador = 1;
        for (Alumno a : alumnos) {
            System.out.println("  " + contador + ". " + a);
            contador++;
        }

        System.out.println("  ─────────────────────────────────────────────────────");
        System.out.println("  Total de alumnos: " + alumnos.size());
    }

    // Busca un alumno por carnet. Retorna el alumno o null si no existe.
    public Alumno buscar(String carnet) {
        for (Alumno a : alumnos) {
            if (a.getCarnet().equals(carnet)) {
                return a;
            }
        }
        return null;
    }
}
