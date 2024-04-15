module com.sayuri.instituto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens com.sayuri.instituto to javafx.fxml;
    exports com.sayuri.instituto;
    exports com.sayuri.instituto.controllers;
    exports com.sayuri.instituto.models;
    opens com.sayuri.instituto.controllers to javafx.fxml;
}