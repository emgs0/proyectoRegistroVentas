package com.company.controller;

import Configurations.LoadImage;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable{
    
    private Boolean administrador =false;    
    // Controlls
    @FXML private Label lblTitle;
    @FXML private Label lblDescription;
    @FXML private ComboBox<String> rbSelectOptionMain;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    @FXML private Label lblSelection;
    @FXML private TextField txtUserName;
    @FXML private TextField txtPassword;
    @FXML private Button btnLogin;
      
    ObservableList<String> optionEmployee = FXCollections.observableArrayList(
                    "Administrador",
                    "Empleado");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        rbSelectOptionMain.setItems(optionEmployee);
        dateAndHour(this.txtDate);
        
        LoadImage.loadImageMain(this.imageMain);
        
    }
    
    @FXML
    private void switchToEmployee(ActionEvent event) {
        if (rbSelectOptionMain.getSelectionModel().getSelectedItem() == "Administrador") {
            administrador=true;
            try {
                App.setRoot("VistaAdministrador");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if(rbSelectOptionMain.getSelectionModel().getSelectedItem() == "Empleado"){
            administrador = false;
            try {
                App.setRoot("VistaEmpleado");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Selección invalida");
            alert.setContentText("Selecciona un puesto válido");
            alert.showAndWait();
        }
            
    }
    
    public static void dateAndHour(TextField txtdate){
        //cambair a la clase
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
    
}
