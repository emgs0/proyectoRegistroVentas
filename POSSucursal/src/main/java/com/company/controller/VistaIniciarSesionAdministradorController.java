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

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class VistaIniciarSesionAdministradorController implements Initializable {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblSelection;
    @FXML
    private Button btnLoginMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void switchToAdmin(ActionEvent event) {
        try {
            App.setRoot("VistaAdministrador");//cambiar a admin
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void switchToPrincipal(ActionEvent event) {
        try {
            App.setRoot("VistaPrincipal");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
