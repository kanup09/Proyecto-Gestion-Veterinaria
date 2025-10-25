package modelo;

/**
 * Clase Padre (Superclase) abstracta.
 * Define los atributos y comportamientos comunes para
 * cualquier persona en el sistema (Clientes, Veterinarios, etc.).
 */
public abstract class Persona {

    // Usamos 'protected' para que las clases hijas (Cliente, Veterinario)
    // puedan acceder a ellos si es necesario, aunque es mejor usar getters/setters.
    protected String identificacion; // ID, DNI, CUIT, etc.
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected String direccion;

    // --- Constructores ---

    public Persona() {
    }

    public Persona(String identificacion, String nombre, String apellido, String telefono, String email, String direccion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    // --- Getters y Setters ---
    // Todas las clases hijas heredarán estos métodos.

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    @Override
    public String toString() {
        return "ID: " + identificacion + ", Nombre: " + nombre + " " + apellido;
    }
}
