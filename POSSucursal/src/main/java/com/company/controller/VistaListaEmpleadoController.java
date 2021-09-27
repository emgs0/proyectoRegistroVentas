package com.company.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class VistaListaEmpleadoController implements Initializable {

    @FXML
    private Label lblDescription;
    @FXML
    private Label lblTitle;
    @FXML
    private TableView<?> tableEmployees;
    @FXML
    private Button btnGenerateEmployee;
    @FXML
    private Button btnModEmployee;
    @FXML
    private Button btnDelEmployee;
    @FXML
    private Button btnReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void generateNewEmployee(ActionEvent event) {
        try {
            App.setRoot("VistaAgregarEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void modifyEmployee(ActionEvent event) {
        try {
            App.setRoot("VistaModificarEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
    }

    @FXML
    private void returnToAdministrador(ActionEvent event) {
        try {
            App.setRoot("VistaAdministrador");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
