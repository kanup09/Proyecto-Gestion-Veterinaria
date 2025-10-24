package prueba;

// Importamos las clases de los OTROS paquetes (logica y modelo)
import logica.GestorVeterinaria;
import modelo.Cliente;
import modelo.Mascota;

import java.time.LocalDate; // Necesario para crear fechas de nacimiento

/**
 * Clase principal para probar el funcionamiento del GestorVeterinaria.
 * Esta clase contiene el método main() para iniciar la simulación.
 * Simula la creación de clientes y mascotas y prueba las búsquedas.
 */
public class PruebaVeterinaria {

    /**
     * Método principal (main) que ejecuta la prueba.
     * @param args Argumentos de línea de comandos (no los usaremos)
     */
    public static void main(String[] args) {

        System.out.println("--- Iniciando Sitema de Veterinaria (Prueba de Backend) ---");

        // 1. Crear el CEREBRO de la aplicación
        // Creamos una (y solo una) instancia del Gestor.
        GestorVeterinaria gestor = new GestorVeterinaria();

        // 2. Simular el registro de Clientes
        System.out.println("\n--- Registrando Clientes ---");
        // Creamos un objeto Cliente con datos
        Cliente cliente1 = new Cliente("12345678A", "Ana", "García", "555-1111", "ana@mail.com", "Calle Falsa 123");
        // Creamos otro objeto Cliente
        Cliente cliente2 = new Cliente("98765432B", "Luis", "Martínez", "555-2222", "luis@mail.com", "Avenida Siempre 456");

        // Usamos el Gestor para guardarlos
        gestor.registrarCliente(cliente1);
        gestor.registrarCliente(cliente2);

        // 3. Simular el registro de Mascotas
        System.out.println("\n--- Registrando Mascotas ---");

        // Mascota para Ana (Cliente 1).
        // Usamos LocalDate.of(año, mes, dia) para la fecha.
        // Le pasamos el objeto 'cliente1' como dueño.
        Mascota mascota1 = new Mascota(1, "Fido", "Perro", "Labrador", LocalDate.of(2020, 5, 15), cliente1);

        // Mascota para Luis (Cliente 2)
        Mascota mascota2 = new Mascota(2, "Misi", "Gato", "Siamés", LocalDate.of(2022, 1, 10), cliente2);

        // Segunda mascota para Ana (Cliente 1)
        Mascota mascota3 = new Mascota(3, "Pipo", "Pájaro", "Canario", LocalDate.of(2023, 3, 20), cliente1);

        // Usamos el Gestor para guardarlas
        gestor.registrarMascota(mascota1);
        gestor.registrarMascota(mascota2);
        gestor.registrarMascota(mascota3);

        // 4. Probar las BÚSQUEDAS
        System.out.println("\n--- Probando Búsquedas ---");

        // A. Buscar un cliente por ID
        String idABuscar = "12345678A";
        Cliente clienteEncontrado = gestor.buscarClientePorId(idABuscar);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado (" + idABuscar + "): " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellido());
        } else {
            System.out.println("Cliente (" + idABuscar + ") NO encontrado.");
        }

        // B. Buscar las mascotas de Ana (cliente1)
        System.out.println("\n--- Mascotas de Ana García (ID: 12345678A) ---");
        // Recorremos la lista que nos devuelve el gestor
        for (Mascota m : gestor.buscarMascotasPorCliente("12345678A")) {
            // Usamos los getters de Mascota (incluyendo getEdad())
            System.out.println("* " + m.getNombre() + " (Especie: " + m.getEspecie() + ", Edad: " + m.getEdad() + " años)");
        }

        // C. Buscar las mascotas de Luis (cliente2)
        System.out.println("\n--- Mascotas de Luis Martínez (ID: 98765432B) ---");
        for (Mascota m : gestor.buscarMascotasPorCliente("98765432B")) {
            System.out.println("* " + m.getNombre() + " (Especie: " + m.getEspecie() + ", Edad: " + m.getEdad() + " años)");
        }

        System.out.println("\n--- Prueba Finalizada ---");
    }
}