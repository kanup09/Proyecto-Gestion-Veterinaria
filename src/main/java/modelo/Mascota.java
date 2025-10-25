package modelo;

import java.time.LocalDate;

/**
 * Representa a la mascota (paciente) de la veterinaria.
 * (Actualizada para incluir un veterinario a cargo).
 */
public class Mascota {

    private int idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNacimiento;

    // Relaciones
    private Cliente duenio;
    private Veterinario veterinarioAcargo; // <-- NUEVO ATRIBUTO

    // --- Constructores ---

    public Mascota() {
    }

    /**
     * Constructor completo actualizado.
     * @param duenio El objeto Cliente que es propietario
     * @param veterinarioAcargo El objeto Veterinario asignado (NUEVO)
     */
    public Mascota(int idMascota, String nombre, String especie, String raza,
                   LocalDate fechaNacimiento, Cliente duenio, Veterinario veterinarioAcargo) { // <-- AÑADIR VET
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.duenio = duenio;
        this.veterinarioAcargo = veterinarioAcargo; // <-- ASIGNAR VET
    }

    // --- Getters y Setters ---

    // (Getters y Setters de Mascota, Nombre, Especie, Raza, FechaNac, Duenio...
    // ... no los repito, pero asegúrate de que estén)

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

    // --- NUEVOS GETTERS Y SETTERS para Veterinario ---

    public Veterinario getVeterinarioAcargo() {
        return veterinarioAcargo;
    }

    public void setVeterinarioAcargo(Veterinario veterinarioAcargo) {
        this.veterinarioAcargo = veterinarioAcargo;
    }

    // --- Métodos Adicionales ---

    public int getEdad() {
        if (this.fechaNacimiento != null) {
            return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
        }
        return 0;
    }

    @Override
    public String toString() {
        String nombreDuenio = (this.duenio != null) ? this.duenio.getNombre() : "Sin Dueño";
        String nombreVet = (this.veterinarioAcargo != null) ? this.veterinarioAcargo.getNombre() : "Sin Vet";

        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", duenio=" + nombreDuenio +
                ", vet=" + nombreVet +
                '}';
    }
}