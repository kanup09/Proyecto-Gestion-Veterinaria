module com.example.pruebafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens Vista to javafx.fxml;
    exports Vista;
}