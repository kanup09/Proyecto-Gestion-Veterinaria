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

    private List<Cliente> listaClientes;
    private List<Mascota> listaMascotas;
    private List<Veterinario> listaVeterinarios; // <-- AÑADIR LISTA

    /**
     * Constructor que inicializa las listas vacías
     */
    public GestorVeterinaria() {
        this.listaClientes = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        this.listaVeterinarios = new ArrayList<>(); // <-- INICIALIZAR LISTA
    }

    // --- Métodos de CLIENTES ---

    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    public List<Cliente> obtenerClientes() {
        return this.listaClientes;
    }

    public Cliente buscarClientePorId(String idCliente) {
        for (Cliente cliente : this.listaClientes) {
            // Usamos el getter heredado
            if (cliente.getIdentificacion().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    // --- Métodos de MASCOTAS ---

    public void registrarMascota(Mascota mascota) {
        this.listaMascotas.add(mascota);
        System.out.println("Mascota registrada: " + mascota.getNombre() + ", Dueño: " + mascota.getDuenio().getNombre());
    }

    public List<Mascota> obtenerMascotas() {
        return this.listaMascotas;
    }

    public List<Mascota> buscarMascotasPorCliente(String idCliente) {
        List<Mascota> mascotasDelCliente = new ArrayList<>();
        for (Mascota mascota : this.listaMascotas) {
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