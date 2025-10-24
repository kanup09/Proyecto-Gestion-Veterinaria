package codigo;

public class Usuario {

    protected String usuario;
    protected String contraseña;


    protected Usuario(String usuario, String contraseña) {
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    protected Usuario() {
        this.setUsuario(null);
        this.setContraseña(null);
    }

    // Setters y Getters

    protected String getContraseña() {
        return contraseña;
    }

    protected void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    protected String getUsuario() {
        return usuario;
    }

    protected void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    // Metodos

}
