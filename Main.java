// Punto de entrada del programa.
// Muestra un menú interactivo por consola usando while + switch.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Academia academia = new Academia();
        int opcion;

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE GESTIÓN — ACADEMIA DE COMPUTACIÓN    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // Bucle infinito del menú
        while (true) {

            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│        MENÚ PRINCIPAL        │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Inscribir alumno         │");
            System.out.println("│  2. Listar alumnos           │");
            System.out.println("│  3. Buscar alumno por carnet │");
            System.out.println("│  4. Salir                    │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("  Seleccione una opción: ");

            // Validar que la entrada sea un número
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("  ⚠ Error: Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); // Limpiar el Enter pendiente

            switch (opcion) {

                case 1:
                    // Inscribir alumno
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

                    Alumno nuevoAlumno = new Alumno(nombre, edad, carnet, promedio);

                    if (academia.inscribir(nuevoAlumno)) {
                        System.out.println("  ✓ Alumno inscrito exitosamente.");
                    } else {
                        System.out.println("  ✗ Error: El carnet '" + carnet + "' ya está registrado.");
                    }
                    break;

                case 2:
                    // Listar alumnos
                    System.out.println("\n  ── LISTADO DE ALUMNOS ──");
                    academia.listar();
                    break;

                case 3:
                    // Buscar alumno por carnet
                    System.out.println("\n  ── BUSCAR ALUMNO ──");
                    System.out.print("  Ingrese el carnet a buscar: ");
                    String carnetBuscar = scanner.nextLine();

                    Alumno encontrado = academia.buscar(carnetBuscar);

                    if (encontrado != null) {
                        System.out.println("  ✓ Alumno encontrado:");
                        System.out.println("    " + encontrado);
                    } else {
                        System.out.println("  ✗ No se encontró un alumno con carnet: " + carnetBuscar);
                    }
                    break;

                case 4:
                    // Salir del programa
                    System.out.println("\n  Gracias por usar el sistema. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("  ⚠ Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
