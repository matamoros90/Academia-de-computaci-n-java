// ============================================================================
// ACADEMIA.java — LÓGICA DE NEGOCIO
// ============================================================================
//
// 📚 CONCEPTO: COLECCIONES DINÁMICAS (ArrayList)
//
// Un array normal (int[] numeros = new int[10]) tiene tamaño FIJO.
// Si necesitas más espacio, estás en problemas.
//
// ArrayList es como un array que CRECE automáticamente.
// Puedes agregar y quitar elementos sin preocuparte por el tamaño.
//
// Métodos principales de ArrayList:
//   .add(elemento)    → Agrega al final
//   .get(i)           → Obtiene el elemento en posición i
//   .size()           → Cuántos elementos hay
//   .remove(i)        → Elimina el elemento en posición i
//
// 📚 CONCEPTO: SEPARACIÓN DE RESPONSABILIDADES
//
// Esta clase se encarga SOLO de la lógica (inscribir, buscar, listar).
// NO se encarga de leer datos del teclado ni mostrar menús.
// Eso lo hace Main.java. Así cada clase tiene UNA responsabilidad clara.
// ============================================================================

import java.util.ArrayList;

public class Academia {

    // -----------------------------------------------------------------------
    // ATRIBUTO: Lista dinámica de alumnos
    // -----------------------------------------------------------------------
    // Es private porque nadie externo debe manipular la lista directamente.
    // Solo se puede agregar alumnos a través de inscribir().
    // -----------------------------------------------------------------------
    private ArrayList<Alumno> alumnos;

    // -----------------------------------------------------------------------
    // CONSTRUCTOR
    // -----------------------------------------------------------------------
    // Inicializa la lista vacía. Sin esto, la lista sería null
    // y al intentar usar .add() daría NullPointerException.
    // -----------------------------------------------------------------------
    public Academia() {
        this.alumnos = new ArrayList<>();
        // ArrayList<>() — el "<>" infiere automáticamente que es <Alumno>
        // porque la variable ya dice ArrayList<Alumno>
    }

    // -----------------------------------------------------------------------
    // INSCRIBIR — Agrega un alumno validando carnet único
    // -----------------------------------------------------------------------
    // Retorna boolean:
    // true → se inscribió exitosamente
    // false → el carnet ya existía (no se inscribió)
    //
    // 📚 CONCEPTO: VALIDACIÓN DE DATOS
    // Antes de agregar, recorremos toda la lista para verificar que
    // no exista otro alumno con el mismo carnet. Esto se llama
    // "validación de unicidad" o "constraint de negocio".
    // -----------------------------------------------------------------------
    public boolean inscribir(Alumno nuevoAlumno) {
        // Recorremos la lista buscando si ya existe ese carnet
        for (Alumno alumnoExistente : alumnos) {
            // .equals() compara el CONTENIDO de los Strings
            // NO uses == para comparar Strings en Java (compara referencias, no contenido)
            if (alumnoExistente.getCarnet().equals(nuevoAlumno.getCarnet())) {
                return false; // Ya existe → no inscribir
            }
        }

        // Si llegamos aquí, el carnet no existe → lo agregamos
        alumnos.add(nuevoAlumno);
        return true; // Inscripción exitosa
    }

    // -----------------------------------------------------------------------
    // LISTAR — Muestra todos los alumnos inscritos
    // -----------------------------------------------------------------------
    // 📚 CONCEPTO: FOR-EACH (for mejorado)
    // "for (Alumno a : alumnos)" significa:
    // "Para cada Alumno 'a' dentro de la lista 'alumnos', haz esto..."
    // Es más limpio que: for (int i = 0; i < alumnos.size(); i++)
    // -----------------------------------------------------------------------
    public void listar() {
        if (alumnos.isEmpty()) {
            System.out.println("  No hay alumnos inscritos.");
            return; // Sale del método, no ejecuta el for
        }

        System.out.println("  ┌─────────────────────────────────────────────────────┐");
        System.out.println("  │            LISTA DE ALUMNOS INSCRITOS               │");
        System.out.println("  └─────────────────────────────────────────────────────┘");

        int contador = 1;
        for (Alumno a : alumnos) {
            // a.toString() se llama automáticamente dentro de println
            System.out.println("  " + contador + ". " + a);
            contador++;
        }

        System.out.println("  ─────────────────────────────────────────────────────");
        System.out.println("  Total de alumnos: " + alumnos.size());
    }

    // -----------------------------------------------------------------------
    // BUSCAR — Encuentra un alumno por su carnet
    // -----------------------------------------------------------------------
    // Retorna:
    // El objeto Alumno si lo encuentra
    // null si no existe
    //
    // 📚 CONCEPTO: RETORNAR null
    // "null" significa "no hay objeto" o "vacío".
    // Es la forma estándar en Java de indicar "no se encontró".
    // Quien llame a este método debe verificar: if (resultado != null)
    // -----------------------------------------------------------------------
    public Alumno buscar(String carnet) {
        for (Alumno a : alumnos) {
            if (a.getCarnet().equals(carnet)) {
                return a; // Lo encontró → lo devuelve
            }
        }
        return null; // Recorrió toda la lista y no lo encontró
    }
}
