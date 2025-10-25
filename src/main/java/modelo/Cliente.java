package modelo;

/**
 * Representa al dueño o cliente.
 * Esta clase HEREDA de Persona.
 * No necesita atributos propios por ahora, pero podría tenerlos
 * (ej. numeroDeCliente, puntosDeFidelidad, etc.).
 */
public class Cliente extends Persona {

    // --- Constructores ---

    /**
     * Constructor vacío.
     * Llama al constructor vacío de Persona.
     */
    public Cliente() {
        super(); // Llama al constructor Persona()
    }

    /**
     * Constructor completo.
     * Recibe todos los datos y se los pasa al constructor de Persona
     * usando la palabra clave 'super'.
     */
    public Cliente(String identificacion, String nombre, String apellido, String telefono, String email, String direccion) {
        // Llama al constructor de Persona(String, String, ...)
        super(identificacion, nombre, apellido, telefono, email, direccion);
    }

    // --- Getters y Setters ---
    // ¡No necesitamos escribirlos! Los hereda automáticamente de Persona.
    // (getNombre(), getIdentificacion(), etc. ya existen)

    // --- Métodos Adicionales ---

    @Override
    public String toString() {
        // Podemos usar los getters heredados
        return "Cliente{" +
                "ID='" + getIdentificacion() + '\'' +
                ", Nombre='" + getNombre() + " " + getApellido() + '\'' +
                '}';
    }
}