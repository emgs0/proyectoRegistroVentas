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

public class PrincipalController implements Initializable {

    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblSelection;
    @FXML
    private ComboBox<String> rbSelectOptionMain;
    @FXML
    private Button btnLoginMain;
    @FXML
    private TextField txtDate;

    ObservableList<String> optionEmployee
            = FXCollections.observableArrayList(
                    "Administrador",
                    "Empleado"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rbSelectOptionMain.setItems(optionEmployee);
        try {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 
                    LocalDateTime now = LocalDateTime.now();
                    txtDate.setText(dtf.format(now));
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
