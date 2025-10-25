package prueba;

import logica.GestorVeterinaria;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Veterinario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class PruebaVeterinaria {

    private static GestorVeterinaria gestor = new GestorVeterinaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("--- BIENVENIDO AL GESTOR DE VETERINARIA ---");

        boolean corriendo = true;
        while (corriendo) {
            mostrarMenu(); // <-- MÉTODO ACTUALIZADO

            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo un número.");
                continue;
            }

            switch (opcion) { // <-- SWITCH ACTUALIZADO
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                    registrarNuevoVeterinario();
                    break;
                case 3:
                    registrarNuevaMascota(); // <-- MÉTODO ACTUALIZADO
                    break;
                case 4:
                    buscarMascotasPorCliente();
                    break;
                case 5:
                    buscarMascotasPorVeterinario(); // <-- NUEVA OPCIÓN
                    break;
                case 6:
                    listarTodosLosClientes();
                    break;
                case 7:
                    listarTodosLosVeterinarios(); // <-- CAMBIO DE NÚMERO
                    break;
                case 0:
                    corriendo = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            if (corriendo) {
                System.out.println("\n(Presione Enter para continuar...)");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú actualizado
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Registrar nuevo veterinario");
        System.out.println("3. Registrar nueva mascota (con dueño y vet)"); // <-- CAMBIO
        System.out.println("4. Ver mascotas de un cliente");
        System.out.println("5. Ver mascotas de un veterinario"); // <-- NUEVO
        System.out.println("6. Listar todos los clientes"); // <-- CAMBIO
        System.out.println("7. Listar todos los veterinarios"); // <-- CAMBIO
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // --- Métodos de Ayuda (Nuevo y Modificado) ---

    /**
     * NUEVO MÉTODO DE AYUDA
     * Busca un cliente por ID. Si no existe, lo crea en el momento.
     * @return El Cliente (existente o nuevo).
     */
    private static Cliente gestionarRegistroCliente() {
        System.out.println("\n--- Paso 1: Asignar Dueño ---");
        System.out.print("Ingrese la Identificación del cliente (dueño): ");
        String idCliente = scanner.nextLine();

        Cliente duenio = gestor.buscarClientePorId(idCliente);

        if (duenio == null) {
            System.out.println("Cliente no encontrado. Registrando nuevo cliente...");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Teléfono: ");
            String tel = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Dirección: ");
            String dir = scanner.nextLine();

            duenio = new Cliente(idCliente, nombre, apellido, tel, email, dir);
            gestor.registrarCliente(duenio);
            System.out.println("¡Nuevo cliente registrado!");
        } else {
            System.out.println("Dueño encontrado: " + duenio.getNombre() + " " + duenio.getApellido());
        }
        return duenio;
    }

    /**
     * NUEVO MÉTODO DE AYUDA
     * Muestra los veterinarios y permite seleccionar uno.
     * @return El Veterinario seleccionado, o null si no hay.
     */
    private static Veterinario gestionarSeleccionVeterinario() {
        System.out.println("\n--- Paso 2: Asignar Veterinario ---");
        List<Veterinario> veterinarios = gestor.obtenerVeterinarios();

        if (veterinarios.isEmpty()) {
            System.out.println("Error: No hay veterinarios registrados.");
            System.out.println("Por favor, registre un veterinario (Opción 2) primero.");
            return null; // No podemos continuar
        }

        System.out.println("Veterinarios disponibles:");
        for (int i = 0; i < veterinarios.size(); i++) {
            Veterinario v = veterinarios.get(i);
            System.out.println("  " + (i + 1) + ". " + v.getNombre() + " " + v.getApellido() + " (Esp: " + v.getEspecialidad() + ")");
        }

        int opcionVet = -1;
        while (opcionVet < 1 || opcionVet > veterinarios.size()) {
            System.out.print("Seleccione el veterinario a cargo (1-" + veterinarios.size() + "): ");
            try {
                opcionVet = Integer.parseInt(scanner.nextLine());
                if (opcionVet < 1 || opcionVet > veterinarios.size()) {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número.");
            }
        }

        Veterinario vetSeleccionado = veterinarios.get(opcionVet - 1);
        System.out.println("Veterinario asignado: " + vetSeleccionado.getNombre());
        return vetSeleccionado;
    }

    /**
     * MÉTODO PRINCIPAL ACTUALIZADO
     * Lógica para la Opción 3: Registrar Mascota (Actualizado)
     */
    private static void registrarNuevaMascota() {
        System.out.println("\n--- Registro de Nueva Mascota ---");

        // Paso 1: Gestionar Dueño
        Cliente duenio = gestionarRegistroCliente();

        // Paso 2: Gestionar Veterinario
        Veterinario vetAcargo = gestionarSeleccionVeterinario();
        if (vetAcargo == null) {
            // Si no hay veterinarios, no podemos registrar la mascota
            return;
        }

        // Paso 3: Pedir datos de la mascota
        System.out.println("\n--- Paso 3: Datos de la Mascota ---");
        System.out.print("ID interno de la mascota (ej. 1, 2, 3...): ");
        int idMascota = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre de la mascota: ");
        String nombre = scanner.nextLine();
        System.out.print("Especie (Perro, Gato...): ");
        String especie = scanner.nextLine();
        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        LocalDate fechaNac = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (fechaNac == null) {
            System.out.print("Fecha de Nacimiento (formato dd/MM/yyyy): ");
            String fechaStr = scanner.nextLine();
            try {
                fechaNac = LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha incorrecto. Use dd/MM/yyyy.");
            }
        }

        // Paso 4: Crear la mascota con TODOS los datos
        Mascota nuevaMascota = new Mascota(idMascota, nombre, especie, raza, fechaNac, duenio, vetAcargo);

        // 5. Registrarla en el gestor
        gestor.registrarMascota(nuevaMascota);
        System.out.println("¡Mascota registrada con éxito!");
        System.out.println("  Dueño: " + duenio.getNombre());
        System.out.println("  Veterinario a cargo: " + vetAcargo.getNombre());
    }

    /**
     * NUEVO MÉTODO
     * Lógica para la Opción 5: Buscar Mascotas de un Veterinario
     */
    private static void buscarMascotasPorVeterinario() {
        System.out.println("\n--- Búsqueda de Mascotas por Veterinario ---");
        System.out.print("Ingrese la Identificación del veterinario a buscar: ");
        String idVet = scanner.nextLine();

        // Validamos que el veterinario exista
        Veterinario vet = gestor.buscarVeterinarioPorId(idVet);
        if (vet == null) {
            System.out.println("Error: Veterinario no encontrado.");
            return;
        }

        System.out.println("Mostrando mascotas a cargo de: " + vet.getNombre() + " " + vet.getApellido());

        List<Mascota> mascotasEncontradas = gestor.buscarMascotasPorVeterinario(idVet);

        if (mascotasEncontradas.isEmpty()) {
            System.out.println("Este veterinario no tiene mascotas a cargo.");
        } else {
            // Recorremos la lista e imprimimos los detalles
            for (Mascota m : mascotasEncontradas) {
                System.out.println("---------------------------");
                System.out.println("  ID: " + m.getIdMascota());
                System.out.println("  Nombre: " + m.getNombre());
                System.out.println("  Especie: " + m.getEspecie());
                System.out.println("  Dueño: " + m.getDuenio().getNombre() + " " + m.getDuenio().getApellido());
                System.out.println("---------------------------");
            }
        }
    }

    // --- Métodos antiguos (sin cambios, solo los pongo por completitud) ---

    private static void registrarNuevoCliente() {
        System.out.println("\n--- Registro de Cliente ---");
        System.out.print("Identificación (DNI/CUIT): ");
        String id = scanner.nextLine();

        // Verificación para no duplicar
        if (gestor.buscarClientePorId(id) != null) {
            System.out.println("Error: Ya existe un cliente con esa identificación.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String tel = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Dirección: ");
        String dir = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, apellido, tel, email, dir);
        gestor.registrarCliente(nuevoCliente);

        System.out.println("¡Cliente registrado con éxito!");
    }

    private static void registrarNuevoVeterinario() {
        System.out.println("\n--- Registro de Veterinario ---");
        System.out.print("Identificación (DNI): ");
        String id = scanner.nextLine();

        // Verificación para no duplicar
        if (gestor.buscarVeterinarioPorId(id) != null) {
            System.out.println("Error: Ya existe un veterinario con esa identificación.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String tel = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Dirección: ");
        String dir = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Matrícula (Licencia): ");
        String matricula = scanner.nextLine();

        Veterinario nuevoVet = new Veterinario(id, nombre, apellido, tel, email, dir, especialidad, matricula);
        gestor.registrarVeterinario(nuevoVet);

        System.out.println("¡Veterinario registrado con éxito!");
    }

    private static void buscarMascotasPorCliente() {
        System.out.println("\n--- Búsqueda de Mascotas por Cliente ---");
        System.out.print("Ingrese la Identificación del cliente a buscar: ");
        String idCliente = scanner.nextLine();

        Cliente cliente = gestor.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        System.out.println("Mostrando mascotas de: " + cliente.getNombre() + " " + cliente.getApellido());

        List<Mascota> mascotasEncontradas = gestor.buscarMascotasPorCliente(idCliente);

        if (mascotasEncontradas.isEmpty()) {
            System.out.println("Este cliente no tiene mascotas registradas.");
        } else {
            for (Mascota m : mascotasEncontradas) {
                System.out.println("---------------------------");
                System.out.println("  ID: " + m.getIdMascota());
                System.out.println("  Nombre: " + m.getNombre());
                System.out.println("  Vet. a cargo: " + (m.getVeterinarioAcargo() != null ? m.getVeterinarioAcargo().getNombre() : "N/A"));
                System.out.println("---------------------------");
            }
        }
    }

    private static void listarTodosLosClientes() {
        System.out.println("\n--- Listado de Clientes ---");
        List<Cliente> clientes = gestor.obtenerClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdentificacion() + " | Nombre: " + c.getNombre() + " " + c.getApellido());
            }
        }
    }

    private static void listarTodosLosVeterinarios() {
        System.out.println("\n--- Listado de Veterinarios ---");
        List<Veterinario> veterinarios = gestor.obtenerVeterinarios();

        if (veterinarios.isEmpty()) {
            System.out.println("No hay veterinarios registrados.");
        } else {
            for (Veterinario v : veterinarios) {
                System.out.println("ID: " + v.getIdentificacion() + " | Nombre: " + v.getNombre() + " | Esp: " + v.getEspecialidad());
            }
        }
    }
}