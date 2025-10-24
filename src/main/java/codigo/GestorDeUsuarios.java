package codigo;

import java.util.Scanner;

//Clase de SERVICIO/CONTROLADOR
public class GestorDeUsuarios {

    // Este método usa el Scanner y crea el objeto
    public Usuario crearUsuario(Scanner scanner) {
        System.out.println("Ingrese su Usuario: ");
        String u = scanner.nextLine();

        System.out.println("Ingrese su Contraseña: ");
        String c = scanner.nextLine();

        // Retorna el objeto, delegando la creación al constructor de Usuario
        return new Usuario(u, c);
    }

    // Este método es una función de servicio, no requiere el objeto en sí como parámetro si se asume que es una nueva entrada.
    public boolean validarDatos(String usuario, String contrasena) {
        // La lógica de isBlank() y null va aquí
        if (usuario == null || contrasena == null ||
                usuario.isBlank() || contrasena.isBlank()) {
            System.out.println("Faltan datos de usuario o contraseña.");
            return false;
        }
        return true;
    }

    // Este método usa el gestor para todo el flujo de inicio de sesión
    public void iniciarSesion(Scanner scanner) {

        // 1. Obtener los datos del usuario usando el método de creación/captura
        Usuario intentoUsuario = crearUsuario(scanner);

        // 2. Validar el objeto que se acaba de crear
        if (validarDatos(intentoUsuario.getUsuario(), intentoUsuario.getContraseña())) {

            // 3. Lógica de autenticación real (comparar con base de datos, etc.)
            System.out.println("Datos válidos. Intentando autenticar...");
            // if (autenticarEnSistema(intentoUsuario)) { ... }

        } else {
            System.out.println("No se pudo iniciar sesión. Los datos ingresados son inválidos o están vacíos.");
            // Aquí podrías pedirle que lo intente de nuevo, en lugar de la recursividad que tenías.
        }
    }
}
