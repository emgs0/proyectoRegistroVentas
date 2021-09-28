
package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class IniciarSesionEmpleadoController implements Initializable {

    @FXML private Label lblTitle;
    @FXML private Label lblDescription;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    @FXML private TextField txtUserName;
    @FXML private TextField txtContrasena;
    @FXML private Button btnLoginEmpleoyee;
    @FXML private Button btnReturnEmployee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrincipalController.dateAndHour(this.txtDate);
    }    

    @FXML
    private void switchToEmployee(ActionEvent event) {
        try {
            App.setRoot("VistaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void switchToLogin(ActionEvent event) {
        try {
            App.setRoot("VistaPrincipal");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
