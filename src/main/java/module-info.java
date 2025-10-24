
module com.example.pruebafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens vista to javafx.fxml;
    exports vista;
}
