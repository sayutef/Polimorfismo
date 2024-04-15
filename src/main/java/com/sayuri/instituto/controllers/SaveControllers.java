package com.sayuri.instituto.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sayuri.instituto.HelloApplication;
import com.sayuri.instituto.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;

public class SaveControllers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttonAlta;

    @FXML
    private Button bttonReturn;

    @FXML
    private TextField textName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textMatricula;
    @FXML
    private ComboBox<String> medioComboBox;
    private Instituto inst;

    @FXML
    void bttonAlta(MouseEvent event) {
        try{
            String nombre = textName.getText();
            String apellido = textLastName.getText();
            String matriculas = textMatricula.getText();

            if (nombre.isEmpty() || apellido.isEmpty() || matriculas.isEmpty()){
                showAlert(Alert.AlertType.WARNING, "Faltan datos ", "Por favor, complete todos los campos...");
                return;
            }
            int matricula =Integer.parseInt(matriculas);
            Student student = new Student(nombre, apellido, matricula);
            HelloApplication.getInstituto().save(student);

            System.out.println("Nombre: "+ student.getNombre() + " . ");
            System.out.println("Apellido: "+ student.getApellido() + " . ");
            System.out.println("Matricula: "+ student.getMatricula() + " . ");

        }catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Error en el costo", "El costo debe ser un número entero válido.");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.WARNING, "Faltan datos", e.getMessage());
        }

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void medioComboBox(MouseEvent event) {
        switch (medioComboBox.getValue()){
            case "MySQL":
                inst.setBaseDeDatos(new MySQL());
                break;
            case "OracleDataBase":
                inst.setBaseDeDatos(new OracleDataBase());
                break;
            case "PostgreSQL":
                inst.setBaseDeDatos(new PostgreSQL());
        }

    }
    @FXML
    void bttonReturn(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        medioComboBox.getItems().addAll("MySQL", "OracleDataBase", "PostgreSQL");
        inst = new Instituto();
    }

}
