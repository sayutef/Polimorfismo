package com.sayuri.instituto.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sayuri.instituto.HelloApplication;
import com.sayuri.instituto.models.BaseDeDatos;
import com.sayuri.instituto.models.Instituto;
import com.sayuri.instituto.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UpdateControllers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttonAlta;

    @FXML
    private Button bttonReturn;

    @FXML
    private TextField textMatriculaExist;

    @FXML
    private TextField textMatricula;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> tableName;

    @FXML
    private TableColumn<Student, String> tableLastName;

    @FXML
    private TableColumn<Student, String> tableMatricula;

    @FXML
    private Button bttonSee;

    @FXML
    private ComboBox<BaseDeDatos> medioComboBox;

    private Instituto instituto;

    @FXML
    void bttonAlta(MouseEvent event) {
        String matriculaExistente = textMatriculaExist.getText();
        String nuevaMatricula = textMatricula.getText();

        if (!matriculaExistente.isEmpty() && !nuevaMatricula.isEmpty()) {

            for (Student student : tableView.getItems()) {

                String matriculaEstudiante = String.valueOf(student.getMatricula());
                if (matriculaEstudiante.equals(matriculaExistente)) {

                    student.setMatricula(Integer.parseInt(nuevaMatricula));

                    instituto.update(student);

                    mostrarAlerta("Éxito", "Actualización exitosa", "La matrícula se actualizó correctamente.", Alert.AlertType.INFORMATION);

                    textMatriculaExist.clear();
                    textMatricula.clear();
                    return;
                }
            }

            mostrarAlerta("Error", "Matrícula no encontrada", "La matrícula existente no se encontró en la tabla.", Alert.AlertType.ERROR);
        } else {

            mostrarAlerta("Error", "Campos vacíos", "Por favor, complete ambos campos de matrícula.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void bttonReturn(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void bttonSee(MouseEvent event) {
       Instituto instituto1 = HelloApplication.getInstituto();
       tableView.getItems().clear();
       if (instituto1.getListStudents().isEmpty()){
           mostrarAlerta("Informacion", "", "No hay estudiantes", Alert.AlertType.INFORMATION);
       }else {
           tableView.getItems().addAll(instituto1.getListStudents());
       }
    }

    @FXML
    void medioComboBox(MouseEvent event) {
        BaseDeDatos value = medioComboBox.getValue();
        if (value.equals("MySQL")) {
            instituto.getBaseDeDatos();
        } else if (value.equals("OracleDataBase")) {
            instituto.getBaseDeDatos();
        } else if (value.equals("PostgreSQL")) {
            instituto.getBaseDeDatos();
        }
    }

    @FXML
    void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tableLastName.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        tableMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));

        instituto = new Instituto();
    }
    private void mostrarAlerta(String titulo, String encabezado, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
