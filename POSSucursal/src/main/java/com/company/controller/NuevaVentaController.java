
package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class NuevaVentaController implements Initializable{

    @FXML private Label lblTitle;
    @FXML private Label lblDescription;
    @FXML private Button btnGenerateSale;
    @FXML private TextField txtHour;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    @FXML private TextField txtFolio;
    @FXML private TextField txtTotal;
    @FXML private Button btnReturnEmployeeSale;
    @FXML private TextField txtDateSale;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PrincipalController.dateAndHour(this.txtDate);
    }

    @FXML private void generateSale(ActionEvent event) {
        
        Object ev = event.getSource();
        
        if(ev.equals(this.btnGenerateSale)){
            
        }
    
        try {
            
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alerta de nueva venta");
            alert.setContentText("Nueva venta reguistrada con exito!!");
            alert.setHeaderText(null);
            alert.showAndWait();
        
    }

    @FXML private void switchToEmployee(ActionEvent event) { 
    
        try {
            App.setRoot("VistaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

}
