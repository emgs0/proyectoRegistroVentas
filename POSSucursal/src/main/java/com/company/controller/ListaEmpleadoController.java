/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class ListaEmpleadoController implements Initializable {

    @FXML private Label lblDescription;
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
    @FXML
    private TextField txtDate;
    @FXML
    private ImageView imageMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrincipalController.dateAndHour(this.txtDate);

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