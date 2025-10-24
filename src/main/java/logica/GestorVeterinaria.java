package logica;

// Importamos las clases que necesitamos
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente; // Importamos la clase Cliente del paquete modelo
import modelo.Mascota;  // Importamos la clase Mascota del paquete modelo

/**
 * Clase principal de lógica de negocio.
 * Esta clase actúa como un controlador central que maneja
 * las operaciones de la veterinaria, como el registro y
 * la búsqueda de clientes y mascotas.
 * * Utiliza Listas en memoria (ArrayList) para persistencia simple.
 */
public class GestorVeterinaria {

    // --- Atributos ---
    // Estas listas actuarán como nuestra "base de datos" temporal en memoria.
    private List<Cliente> listaClientes;
    private List<Mascota> listaMascotas;

    // --- Constructor ---
    /**
     * Constructor que inicializa las listas vacías
     * cuando se crea un nuevo GestorVeterinaria.
     */
    public GestorVeterinaria() {
        this.listaClientes = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
    }

    // --- Métodos de Gestión (CRUD Básico) ---

    // --- CLIENTES ---

    /**
     * Añade un nuevo cliente a la lista.
     * @param cliente El objeto Cliente completo para agregar.
     */
    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    /**
     * Devuelve la lista completa de clientes registrados.
     * @return Una Lista de Clientes.
     */
    public List<Cliente> obtenerClientes() {
        return this.listaClientes;
    }

    /**
     * Busca un cliente específico por su ID (DNI, CUIT, etc.).
     * @param idCliente El ID del cliente a buscar.
     * @return El objeto Cliente si se encuentra, o null si no existe.
     */
    public Cliente buscarClientePorId(String idCliente) {
        // Recorremos la lista de clientes
        for (Cliente cliente : this.listaClientes) {
            // Comparamos el ID de cada cliente con el ID buscado
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente; // Lo encontramos, lo devolvemos
            }
        }
        return null; // No se encontró, devolvemos null
    }

    // --- MASCOTAS ---

    /**
     * Añade una nueva mascota a la lista.
     * Asume que la mascota ya tiene su 'duenio' (Cliente) asignado.
     * @param mascota El objeto Mascota completo para agregar.
     */
    public void registrarMascota(Mascota mascota) {
        this.listaMascotas.add(mascota);
        System.out.println("Mascota registrada: " + mascota.getNombre() + ", Dueño: " + mascota.getDuenio().getNombre());
    }

    /**
     * Devuelve la lista completa de mascotas registradas.
     * @return Una Lista de Mascotas.
     */
    public List<Mascota> obtenerMascotas() {
        return this.listaMascotas;
    }

    /**
     * Busca mascotas que pertenecen a un cliente específico.
     * @param idCliente El ID del cliente del cual queremos ver las mascotas.
     * @return Una lista de Mascotas (puede estar vacía si el cliente no tiene).
     */
    public List<Mascota> buscarMascotasPorCliente(String idCliente) {
        // Creamos una lista temporal para guardar las mascotas encontradas
        List<Mascota> mascotasDelCliente = new ArrayList<>();

        // Recorremos TODAS las mascotas
        for (Mascota mascota : this.listaMascotas) {
            // Verificamos que la mascota tenga un dueño asignado
            if (mascota.getDuenio() != null) {
                // Comparamos el ID del dueño de la mascota con el ID que buscamos
                if (mascota.getDuenio().getIdCliente().equals(idCliente)) {
                    mascotasDelCliente.add(mascota); // Coincide, la agregamos
                }
            }
        }
        return mascotasDelCliente; // Devolvemos la lista de mascotas encontradas
    }
}