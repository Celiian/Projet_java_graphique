module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
    exports com.example.demo2.Controller;
    opens com.example.demo2.Controller to javafx.fxml;
    exports com.example.demo2.classes;
    opens com.example.demo2.classes to javafx.fxml;
}