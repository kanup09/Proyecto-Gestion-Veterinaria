package modelo;

/**
 * Representa al dueño o cliente propietario de las mascotas.
 * Esta clase almacena la información de contacto y personal del cliente.
 */
public class Cliente {

    /**
     * Identificador único para el cliente.
     * Podría ser un DNI, CUIT o un ID interno de la base de datos.
     */
    private String idCliente;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;

    // --- Constructores ---

    /**
     * Constructor vacío.
     * Permite crear una instancia de Cliente sin datos iniciales.
     */
    public Cliente() {
    }

    /**
     * Constructor completo.
     * Permite crear una instancia de Cliente con todos los datos necesarios.
     *
     * @param idCliente Identificador único (ej. DNI)
     * @param nombre El nombre del cliente
     * @param apellido El apellido del cliente
     * @param telefono Número de contacto
     * @param email Correo electrónico
     * @param direccion Domicilio del cliente
     */
    public Cliente(String idCliente, String nombre, String apellido, String telefono, String email, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    // --- Getters y Setters ---
    // Estos métodos nos permiten acceder y modificar los atributos privados
    // de forma controlada.

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // --- Métodos Adicionales (Opcional) ---

    /**
     * Devuelve una representación en texto del Cliente (útil para depuración).
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}