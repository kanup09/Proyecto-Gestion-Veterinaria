package modelo;

// Importamos la clase LocalDate para manejar fechas de forma moderna.
// Nota: Esta clase está en el paquete java.time, por lo que la importación no cambia.
import java.time.LocalDate;

/**
 * Representa a la mascota (paciente) de la veterinaria.
 * Esta clase contiene la información del animal y, crucialmente,
 * mantiene una referencia a su dueño (Cliente).
 */
public class Mascota {

    /**
     * Identificador único de la mascota (ej. número de chip o ID interno).
     */
    private int idMascota;
    private String nombre;
    private String especie; // Ej: "Perro", "Gato", "Hámster"
    private String raza;
    private LocalDate fechaNacimiento;

    /**
     * Relación: Esta es la clave.
     * Almacenamos el objeto Cliente completo que es dueño de esta mascota.
     * Como Cliente.java está en el mismo paquete 'modelo', no necesitamos importarlo.
     */
    private Cliente duenio;

    // --- Constructores ---

    public Mascota() {
    }

    /**
     * Constructor completo para crear una Mascota.
     *
     * @param idMascota ID interno
     * @param nombre Nombre de la mascota (ej. "Fido")
     * @param especie Especie (ej. "Perro")
     * @param raza Raza (ej. "Labrador")
     * @param fechaNacimiento Fecha de nacimiento
     * @param duenio El objeto Cliente que es propietario
     */
    public Mascota(int idMascota, String nombre, String especie, String raza, LocalDate fechaNacimiento, Cliente duenio) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.duenio = duenio;
    }

    // --- Getters y Setters ---

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente getDuenio() {
        return duenio;
    }

    public void setDuenio(Cliente duenio) {
        this.duenio = duenio;
    }

    // --- Métodos Adicionales (Opcional) ---

    /**
     * Método de utilidad para calcular la edad (simple).
     * @return La edad en años.
     */
    public int getEdad() {
        if (this.fechaNacimiento != null) {
            // Comparamos el año actual con el año de nacimiento
            return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
        }
        return 0; // O manejar como error
    }

    @Override
    public String toString() {
        // Mostramos el nombre del dueño usando el getter de Cliente
        String nombreDuenio = (this.duenio != null) ? this.duenio.getNombre() + " " + this.duenio.getApellido() : "Sin Dueño";

        return "Mascota{" +
                "idMascota=" + idMascota +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", duenio=" + nombreDuenio +
                '}';
    }
}
