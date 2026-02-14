// ============================================================================
// MAIN.java — PUNTO DE ENTRADA (Interfaz de Usuario por Consola)
// ============================================================================
//
// 📚 CONCEPTO: MENÚ INFINITO con while(true) + switch
//
// El programa se queda corriendo en un bucle infinito mostrando opciones.
// La ÚNICA forma de salir es eligiendo la opción "Salir".
//
// while(true) → se repite PARA SIEMPRE (hasta que algo lo detenga)
// switch(opcion) → evalúa el valor de 'opcion' y ejecuta el caso que coincida
//
// 📚 CONCEPTO: Scanner
// Scanner es la clase de Java para leer datos del teclado.
// - scanner.nextLine() → lee un texto completo (String)
// - scanner.nextInt()  → lee un número entero
// - scanner.nextDouble() → lee un decimal
//
// ⚠️ TRAP COMÚN: Después de nextInt() o nextDouble(), queda un "Enter"
// pendiente. Si luego usas nextLine(), leerá ese Enter vacío.
// Solución: poner un scanner.nextLine() extra para "limpiar" el Enter.
// ============================================================================

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creamos los objetos principales
        Scanner scanner = new Scanner(System.in);
        Academia academia = new Academia();

        // Variable para almacenar la opción del usuario
        int opcion;

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE GESTIÓN — ACADEMIA DE COMPUTACIÓN    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // ===================================================================
        // BUCLE INFINITO — El corazón del menú
        // ===================================================================
        // while(true) significa "repite esto por siempre".
        // Solo se detiene cuando ejecutamos "break" o "return" o "System.exit(0)".
        // ===================================================================
        while (true) {

            // Mostrar las opciones
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│        MENÚ PRINCIPAL        │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Inscribir alumno         │");
            System.out.println("│  2. Listar alumnos           │");
            System.out.println("│  3. Buscar alumno por carnet │");
            System.out.println("│  4. Salir                    │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("  Seleccione una opción: ");

            // ---------------------------------------------------------------
            // MANEJO DE ERRORES con try-catch
            // ---------------------------------------------------------------
            // Si el usuario escribe letras en vez de un número,
            // scanner.nextInt() lanzaría una excepción y el programa
            // se caería. Con try-catch lo ATRAPAMOS y manejamos.
            // ---------------------------------------------------------------
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("  ⚠ Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue; // Volver al inicio del while
            }
            scanner.nextLine(); // ← Limpiar el Enter pendiente después de nextInt()

            // ---------------------------------------------------------------
            // SWITCH — Evalúa la opción y ejecuta el caso correspondiente
            // ---------------------------------------------------------------
            // switch es como múltiples if-else pero más limpio.
            // Cada "case" es un valor posible.
            // "break" sale del switch (NO del while).
            // "default" se ejecuta si ningún case coincide.
            // ---------------------------------------------------------------
            switch (opcion) {

                case 1:
                    // ═══════════════════════════════════════════════════════
                    // OPCIÓN 1: INSCRIBIR ALUMNO
                    // ═══════════════════════════════════════════════════════
                    System.out.println("\n  ── INSCRIBIR NUEVO ALUMNO ──");

                    System.out.print("  Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("  Edad: ");
                    int edad;
                    try {
                        edad = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("  ⚠ Error: La edad debe ser un número.");
                        break;
                    }

                    System.out.print("  Carnet: ");
                    String carnet = scanner.nextLine();

                    System.out.print("  Promedio: ");
                    double promedio;
                    try {
                        promedio = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("  ⚠ Error: El promedio debe ser un número.");
                        break;
                    }

                    // Crear el objeto Alumno con los datos ingresados
                    Alumno nuevoAlumno = new Alumno(nombre, edad, carnet, promedio);

                    // Intentar inscribirlo (academia valida si el carnet ya existe)
                    if (academia.inscribir(nuevoAlumno)) {
                        System.out.println("  ✓ Alumno inscrito exitosamente.");
                    } else {
                        System.out.println("  ✗ Error: El carnet '" + carnet + "' ya está registrado.");
                    }
                    break;

                case 2:
                    // ═══════════════════════════════════════════════════════
                    // OPCIÓN 2: LISTAR ALUMNOS
                    // ═══════════════════════════════════════════════════════
                    System.out.println("\n  ── LISTADO DE ALUMNOS ──");
                    academia.listar();
                    break;

                case 3:
                    // ═══════════════════════════════════════════════════════
                    // OPCIÓN 3: BUSCAR POR CARNET
                    // ═══════════════════════════════════════════════════════
                    System.out.println("\n  ── BUSCAR ALUMNO ──");
                    System.out.print("  Ingrese el carnet a buscar: ");
                    String carnetBuscar = scanner.nextLine();

                    // buscar() retorna el Alumno o null si no existe
                    Alumno encontrado = academia.buscar(carnetBuscar);

                    if (encontrado != null) {
                        System.out.println("  ✓ Alumno encontrado:");
                        System.out.println("    " + encontrado);
                    } else {
                        System.out.println("  ✗ No se encontró un alumno con carnet: " + carnetBuscar);
                    }
                    break;

                case 4:
                    // ═══════════════════════════════════════════════════════
                    // OPCIÓN 4: SALIR
                    // ═══════════════════════════════════════════════════════
                    System.out.println("\n  Gracias por usar el sistema. ¡Hasta luego!");
                    scanner.close(); // Cerramos el Scanner (buena práctica)
                    return; // Sale del main() → termina el programa
                // También podrías usar: System.exit(0);

                default:
                    // Si el usuario escribió un número que no es 1, 2, 3 ni 4
                    System.out.println("  ⚠ Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
