package com.sayuri.instituto.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sayuri.instituto.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttonAlta;

    @FXML
    private Button bttonUpdate;

    @FXML
    void bttonAlta(MouseEvent event) {
        HelloApplication.newStage("save", "Save");
    }

    @FXML
    void bttonUpdate(MouseEvent event) {
        HelloApplication.newStage("update", "Update");
    }

    @FXML
    void initialize() {
        assert bttonAlta != null : "fx:id=\"bttonAlta\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert bttonUpdate != null : "fx:id=\"bttonUpdate\" was not injected: check your FXML file 'hello-view.fxml'.";

    }
}
