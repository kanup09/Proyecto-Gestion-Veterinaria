package modelo;

/**
 * Representa a un Veterinario del personal.
 * Esta clase HEREDA de Persona y añade atributos específicos.
 */
public class Veterinario extends Persona {

    // --- Atributos Propios ---
    private String especialidad;
    private String matricula; // Nro de licencia médica

    // --- Constructores ---

    public Veterinario() {
        super(); // Llama al constructor vacío de Persona
    }

    /**
     * Constructor completo.
     * Recibe los datos de Persona Y los datos de Veterinario.
     */
    public Veterinario(String identificacion, String nombre, String apellido,
                       String telefono, String email, String direccion,
                       String especialidad, String matricula) {

        // 1. Llama al constructor de Persona para los datos comunes
        super(identificacion, nombre, apellido, telefono, email, direccion);

        // 2. Asigna los atributos propios de esta clase
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    // --- Getters y Setters (Solo para atributos propios) ---

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "ID='" + getIdentificacion() + '\'' +
                ", Nombre='" + getNombre() + " " + getApellido() + '\'' +
                ", Especialidad='" + especialidad + '\'' +
                ", Matrícula='" + matricula + '\'' +
                '}';
    }
}