
package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VistaIniciarSesionEmpleadoController implements Initializable {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblSelection;
    @FXML
    private Button btnLoginMain;
    @FXML
    private Label lblSelection1;
    @FXML
    private Button btnLoginMain1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToPrincipal(ActionEvent event) {
        try {
            App.setRoot("VistaPrincipal");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void switchToEmployee(ActionEvent event) {
        try {
            App.setRoot("VistaEmpleado");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
