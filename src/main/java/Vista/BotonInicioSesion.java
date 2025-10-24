package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BotonInicioSesion {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Iniciando Sesion");
    }
}
