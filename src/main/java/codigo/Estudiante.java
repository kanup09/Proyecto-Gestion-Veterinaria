package codigo;

public class Estudiante extends Usuario {
    private String nombre;
    private int cantAlumnos;

    public Estudiante() {
        super();
        this.nombre = null;
    }

    public Estudiante(String usuario, String contraseña, String nombre) {
        super(usuario, contraseña);
        this.nombre = nombre;
    }

    // Setters y Getters
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getNombre() {
        return nombre;
    }

    //Metodos

}
