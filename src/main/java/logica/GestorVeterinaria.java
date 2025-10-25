package logica;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Veterinario; // <-- IMPORTAR NUEVA CLASE

/**
 * Clase principal de lógica de negocio.
 * (Añadimos la gestión de Veterinarios)
 */
public class GestorVeterinaria {

    // --- Atributos ---
    // Estas listas actuarán como nuestra "base de datos" temporal en memoria.
    private List<Cliente> listaClientes;
    private List<Mascota> listaMascotas;
    private List<Veterinario> listaVeterinarios; // <-- AÑADIR LISTA

    // --- Constructor ---
    /**
     * Constructor que inicializa las listas vacías
     */
    public GestorVeterinaria() {
        this.listaClientes = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        this.listaVeterinarios = new ArrayList<>(); // <-- INICIALIZAR LISTA
    }

    // --- Métodos de CLIENTES ---

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
            // Usamos el getter heredado
            if (cliente.getIdentificacion().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    // --- Métodos de MASCOTAS ---

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
                // Usamos el getter heredado
                if (mascota.getDuenio().getIdentificacion().equals(idCliente)) {
                    mascotasDelCliente.add(mascota);
                }
            }
        }
        return mascotasDelCliente;
    }

    // --- MÉTODOS DE VETERINARIO (NUEVOS) ---

    /**
     * Añade un nuevo veterinario a la lista.
     * @param vet El objeto Veterinario completo para agregar.
     */
    public void registrarVeterinario(Veterinario vet) {
        this.listaVeterinarios.add(vet);
        System.out.println("Veterinario registrado: " + vet.getNombre());
    }

    /**
     * Devuelve la lista completa de veterinarios.
     * @return Una Lista de Veterinarios.
     */
    public List<Veterinario> obtenerVeterinarios() {
        return this.listaVeterinarios;
    }

    /**
     * Busca un veterinario específico por su ID (Identificación).
     * @param id El ID del veterinario a buscar.
     * @return El objeto Veterinario si se encuentra, o null si no existe.
     */
    public Veterinario buscarVeterinarioPorId(String id) {
        for (Veterinario vet : this.listaVeterinarios) {
            if (vet.getIdentificacion().equals(id)) {
                return vet;
            }
        }
        return null;
    }
    /**
     * Busca mascotas que están a cargo de un veterinario específico.
     * @param idVet La Identificación del veterinario.
     * @return Una lista de Mascotas (puede estar vacía).
     */
    public List<Mascota> buscarMascotasPorVeterinario(String idVet) {
        List<Mascota> mascotasDelVet = new ArrayList<>();

        for (Mascota mascota : this.listaMascotas) {
            // Verificamos que la mascota tenga un veterinario asignado
            if (mascota.getVeterinarioAcargo() != null) {
                // Comparamos el ID del vet de la mascota con el ID que buscamos
                if (mascota.getVeterinarioAcargo().getIdentificacion().equals(idVet)) {
                    mascotasDelVet.add(mascota); // Coincide, la agregamos
                }
            }
        }
        return mascotasDelVet;
    }

}