/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author Aldhair
 */
public class EmpleadoController {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private Button btnNewSale;
    @FXML
    private TableView<?> tbSalesRegister;
    @FXML
    private Button btnLoginMain1;
    @FXML
    private Button btnSignOut;

    @FXML
    private void newSale(ActionEvent event) {
        try {
            App.setRoot("VistaNuevaVenta");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void signOutEmployee(ActionEvent event) {
        try {
            App.setRoot("VistaIniciarSesionEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
