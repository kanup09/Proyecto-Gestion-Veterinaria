package codigo;

import java.util.Scanner;

public class GestorDeCursos {


    public Curso crearCurso(Scanner scanner) {

        System.out.println("--- Creación de Nuevo Curso ---");

        System.out.println("Ingrese la cantidad de alumnos: ");
        int alumnos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de profesores: ");
        int profesores = scanner.nextInt();

        // Limpiamos el buffer del Scanner después de leer números|
        scanner.nextLine();

        // Creamos y retornamos el objeto, delegando la creación al constructor de Curso
        return new Curso(alumnos, profesores);
    }
}
