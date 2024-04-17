package com.sayuri.instituto.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sayuri.instituto.HelloApplication;
import com.sayuri.instituto.models.BaseDeDatos;
import com.sayuri.instituto.models.Instituto;
import com.sayuri.instituto.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ComboBox<?> medioComboBox;
    private BaseDeDatos database01;
    private BaseDeDatos database02;
    private BaseDeDatos database03;
    private ArrayList<BaseDeDatos> dataBases = new ArrayList<>();
    private Instituto general = HelloApplication.getMiniInstituto();


    @FXML
    void bttonAlta(MouseEvent event) {
        String matriculaExistente = textMatriculaExist.getText();
        String nuevaMatricula = textMatricula.getText();

        if (!matriculaExistente.isEmpty() && !nuevaMatricula.isEmpty()){
            for (Student student : tableView.getItems()){
                String matriculaEstudiante = String.valueOf(student.getMatricula());
                if (matriculaEstudiante.equals(matriculaExistente)){
                    student.setMatricula(Integer.parseInt(nuevaMatricula));
                    general.updateAll(student);
                    textMatriculaExist.clear();
                    textMatricula.clear();
                    tableView.refresh();
                }
            }
        }
    }

    @FXML
    void bttonReturn(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void bttonSee(MouseEvent event) {
        if (general != null && general.getBaseDeDatos2() != null){
            ArrayList<Student> listNew = general.getBaseDeDatos2().getListPostgre();
            ObservableList<Student> listNewObservable = FXCollections.observableArrayList(listNew);
            tableView.setItems(listNewObservable);
        }
    }

    @FXML
    void medioComboBox(MouseEvent event) {

    }

    @FXML
    void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tableLastName.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        tableMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));

    }
}
