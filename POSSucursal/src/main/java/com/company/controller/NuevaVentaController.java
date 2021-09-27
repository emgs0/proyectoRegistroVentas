/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Aldhair
 */
public class NuevaVentaController implements Initializable{

    @FXML private Label lblTitle;
    @FXML private Label lblDescription;
    @FXML private Button btnCancelEmployee;
    @FXML private Button btnGenerateSale;
    @FXML private TextField txtHour;
    @FXML private TextField txtDate;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
            @Override
                public void run() {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");//yyyy/MM/dd 
                      LocalDateTime now = LocalDateTime.now();
                      txtHour.setText(dtf.format(now));
                }
            };
        
            timer.schedule(task, 0, 1000);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    @FXML
    private void exitSale(ActionEvent event) {
        try {
            App.setRoot("VistaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void generateNewSale(ActionEvent event) {
        
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alerta de nueva venta");
            alert.setContentText("Nueva venta reguistrada con exito!!");
            alert.setHeaderText(null);
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
            
    }

    
    
}
