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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class VistaModificarEmpleadoController implements Initializable {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContrasena;
    @FXML
    private TextField txtContrasena2;
    @FXML
    private RadioButton radioAdmin;
    @FXML
    private RadioButton radioEmpleado;
    @FXML
    private Button btnModificarEmpleado;
    @FXML
    private Button btnCancelarRegistro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void updateDB(ActionEvent event) {
        try {
            App.setRoot("VistaListaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void returnToAdministrador(ActionEvent event) {
        try {
            App.setRoot("VistaListaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
