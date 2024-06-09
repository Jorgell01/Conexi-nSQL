import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaCRUD agenda = new AgendaCRUD();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            imprimirMenuPrincipal();

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    manejarCategorias(agenda, scanner);
                    break;
                case "2":
                    manejarProvincias(agenda, scanner);
                    break;
                case "3":
                    manejarContactos(agenda, scanner);
                    break;
                case "4":
                    DatabaseConnection.cerrarConexion();
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void imprimirMenuPrincipal() {
        System.out.println("\n========= Menú Principal =========");
        System.out.println("1. Operaciones con Categorías");
        System.out.println("2. Operaciones con Provincias");
        System.out.println("3. Operaciones con Contactos");
        System.out.println("4. Salir");
        System.out.println("==================================");
        System.out.print("Seleccione una opción: ");
    }

    private static void imprimirMenuOperaciones(String tipo) {
        System.out.println("\n==== Operaciones con " + tipo + " ====");
        System.out.println("1. Insertar");
        System.out.println("2. Leer");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("5. Volver al Menú Principal");
        System.out.println("=================================");
        System.out.print("Seleccione una opción: ");
    }

    private static void manejarCategorias(AgendaCRUD agenda, Scanner scanner) {
        while (true) {
            imprimirMenuOperaciones("Categorías");

            String subOpcion = scanner.nextLine();
            switch (subOpcion) {
                case "1":
                    System.out.print("Ingrese el código de la categoría: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Ingrese la descripción: ");
                    String descripcion = scanner.nextLine();
                    agenda.insertCategoria(categoria, descripcion);
                    break;
                case "2":
                    agenda.readCategorias();
                    break;
                case "3":
                    System.out.print("Ingrese el código de la categoría: ");
                    categoria = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción: ");
                    descripcion = scanner.nextLine();
                    agenda.updateCategoria(categoria, descripcion);
                    break;
                case "4":
                    System.out.print("Ingrese el código de la categoría a eliminar: ");
                    categoria = scanner.nextLine();
                    agenda.deleteCategoria(categoria);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void manejarProvincias(AgendaCRUD agenda, Scanner scanner) {
        while (true) {
            imprimirMenuOperaciones("Provincias");

            String subOpcion = scanner.nextLine();
            switch (subOpcion) {
                case "1":
                    System.out.print("Ingrese el número de la provincia: ");
                    int provincia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nombre de la provincia: ");
                    String nombreProvincia = scanner.nextLine();
                    agenda.insertProvincia(provincia, nombreProvincia);
                    break;
                case "2":
                    agenda.readProvincias();
                    break;
                case "3":
                    System.out.print("Ingrese el número de la provincia: ");
                    provincia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nuevo nombre de la provincia: ");
                    nombreProvincia = scanner.nextLine();
                    agenda.updateProvincia(provincia, nombreProvincia);
                    break;
                case "4":
                    System.out.print("Ingrese el número de la provincia a eliminar: ");
                    provincia = Integer.parseInt(scanner.nextLine());
                    agenda.deleteProvincia(provincia);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void manejarContactos(AgendaCRUD agenda, Scanner scanner) {
        while (true) {
            imprimirMenuOperaciones("Contactos");

            String subOpcion = scanner.nextLine();
            switch (subOpcion) {
                case "1":
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Ingrese el DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    String ecorreo = scanner.nextLine();
                    System.out.print("Ingrese la fecha de cumpleaños (YYYY-MM-DD): ");
                    String fechacumple = scanner.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese la población: ");
                    String poblacion = scanner.nextLine();
                    System.out.print("Ingrese el número de la provincia: ");
                    int provincia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el código postal: ");
                    String codigoPostal = scanner.nextLine();
                    System.out.print("Ingrese el código de la categoría: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Ingrese la deuda: ");
                    int deuda = Integer.parseInt(scanner.nextLine());
                    agenda.insertContacto(nombre, apellidos, dni, telefono, ecorreo, fechacumple, direccion, poblacion, provincia, codigoPostal, categoria, deuda);
                    break;
                case "2":
                    agenda.readContactos();
                    break;
                case "3":
                    System.out.print("Ingrese el ID del contacto: ");
                    int idContacto = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    apellidos = scanner.nextLine();
                    System.out.print("Ingrese el DNI: ");
                    dni = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    telefono = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    ecorreo = scanner.nextLine();
                    System.out.print("Ingrese la fecha de cumpleaños (YYYY-MM-DD): ");
                    fechacumple = scanner.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    direccion = scanner.nextLine();
                    System.out.print("Ingrese la población: ");
                    poblacion = scanner.nextLine();
                    System.out.print("Ingrese el número de la provincia: ");
                    provincia = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el código postal: ");
                    codigoPostal = scanner.nextLine();
                    System.out.print("Ingrese el código de la categoría: ");
                    categoria = scanner.nextLine();
                    System.out.print("Ingrese la deuda: ");
                    deuda = Integer.parseInt(scanner.nextLine());
                    agenda.updateContacto(idContacto, nombre, apellidos, dni, telefono, ecorreo, fechacumple, direccion, poblacion, provincia, codigoPostal, categoria, deuda);
                    break;
                case "4":
                    System.out.print("Ingrese el ID del contacto a eliminar: ");
                    idContacto = Integer.parseInt(scanner.nextLine());
                    agenda.deleteContacto(idContacto);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
