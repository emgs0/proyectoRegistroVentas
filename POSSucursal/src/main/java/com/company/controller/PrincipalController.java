package com.company.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable{
    
    // Controlls
    @FXML private Label lblTitle;
    @FXML private Label lblDescription;
    @FXML private ComboBox<?> rbSelectOptionMain;
    @FXML private Button btnLoginMain;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    
      
    ObservableList<String> optionEmployee
            = FXCollections.observableArrayList(
                    "Administrador",
                    "Empleado"
            );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateAndHour(this.txtDate);
    }
    
    // Login as 'Empledo' or 'Administrador'
    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {

        try {
            App.setRoot("VistaIniciarSesionEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void dateAndHour(TextField txtdate){
         // Time and date
        try {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 
                    LocalDateTime now = LocalDateTime.now();
                    txtdate.setText(dtf.format(now));
                }
            };

            timer.schedule(task, 0, 1000);
           
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        if (rbSelectOptionMain.getSelectionModel().getSelectedItem() == "Administrador") {
            try {
                App.setRoot("VistaIniciarSesionAdministrador");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                App.setRoot("VistaIniciarSesionEmpleado");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
