/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.controller.App;
import com.company.controller.App;
import com.company.controller.PrincipalController;
import com.company.controller.PrincipalController;
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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class AgregarEmpleadoController implements Initializable {

    @FXML
    private Label lblTitle1;
    @FXML
    private Label lblDescription1;
    @FXML
    private TextField txtDate;
    @FXML
    private ImageView imageMain;
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
    private Button btnRegistrarEmpleado;
    @FXML
    private Button btnCancelarRegistro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrincipalController.dateAndHour(this.txtDate);
    }

    @FXML
    private void insertToDB(ActionEvent event) {
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
