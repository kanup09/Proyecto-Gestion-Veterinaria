package codigo;

public class Curso {
    private int cantAlumnos;
    private int cantProfesores;


    public Curso(int alumnos, int profesores) {
        this.setCantAlumnos(alumnos);
        this.setCantProfesores(profesores);
    }

    // Setters y Getters

    public int getCantProfesores() {
        return cantProfesores;
    }

    public void setCantProfesores(int cantProfesores) {
        this.cantProfesores = cantProfesores;
    }

    public int getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(int cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    // Metodos


}
