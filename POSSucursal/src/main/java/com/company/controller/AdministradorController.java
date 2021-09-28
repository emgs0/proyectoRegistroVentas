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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author e-emgarza
 */
public class AdministradorController implements Initializable {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private TableView<?> tbSalesAdmin;
    @FXML
    private Button btnFilterUsers;
    @FXML
    private ComboBox<String> cBoxUsers;
    @FXML
    private Button btnSignOutAdmin;
    @FXML
    private TextField txtSales;
    @FXML
    private Button btnAddModUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void filterUsers(ActionEvent event) {
    }

    @FXML
    private void signOutAdmin(ActionEvent event) {
                try {
            App.setRoot("VistaPrincipal");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void addModUser(ActionEvent event) {
                try {
            App.setRoot("VistaListaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
