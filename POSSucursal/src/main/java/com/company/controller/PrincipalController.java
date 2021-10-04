package com.company.controller;

import Configurations.Alerts;
import Configurations.DataAndHour;
import Configurations.LoadImage;
import ConnectionDB.ConnDBH2;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable {

    private Boolean administrador = false;

    // Instancias la clase que hemos creado anteriormente
    private static ConnDBH2 SQL = new ConnDBH2();

    // Llamas al método que tiene la clase y te devuelve una conexión
    private static Connection conn;

    // Query que usarás para hacer lo que necesites
    private static String sSQL = "";

    private ResultSet rs;

    // Controlls    
    @FXML    private ComboBox<String> rbSelectOptionMain;
    @FXML    private TextField txtDate;
    @FXML    private ImageView imageMain;
    @FXML    private TextField txtUserName;
    @FXML    private TextField txtPassword;
    @FXML    private Button btnLogin;

    ObservableList<String> optionEmployee = FXCollections.observableArrayList(
            "Administrador",
            "Empleado");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rbSelectOptionMain.setItems(optionEmployee);
        DataAndHour.dateAndHour(this.txtDate);
        LoadImage.loadImageMain(this.imageMain);
    }

    @FXML
    private void switchToEmployee(ActionEvent event) {

        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String typeEmployee = rbSelectOptionMain.getSelectionModel().getSelectedItem();

        if (username.equals("")) {
            Alerts.alertWarning("Campo USUARIO vacio", "Escribe un usuario válido");
        } else if (password.equals("")) {
            Alerts.alertWarning("Campo CONTRASEÑA vacio", "Escribe una contraseña válida");
        } else {
            conn = SQL.connectionDbH2();
            sSQL = "SELECT * FROM useremployee WHERE user=? AND password=? AND typeEmployee=?";
            try {
                // PreparedStatement
                PreparedStatement pstm = conn.prepareStatement(sSQL);
                pstm.setString(1, username);
                pstm.setString(2, password);
                pstm.setString(3, typeEmployee);
                rs = pstm.executeQuery();

                if (rs.next()) {
                    if (rbSelectOptionMain.getSelectionModel().getSelectedItem() == "Administrador") {
                        administrador = true;
                        try {
                            App.setRoot("VistaAdministrador");
                            Alerts.alertConfirmation("Inicio de Sesión Exitoso", "Bienvenido " + username);
                        } catch (IOException e) {
                            Alerts.alertError("Error inesperado", "Error: " + e.getMessage());
                        }
                    } else if (rbSelectOptionMain.getSelectionModel().getSelectedItem() == "Empleado") {
                        administrador = false;
                        try {
                            App.setRoot("VistaEmpleado");
                            Alerts.alertConfirmation("Inicio de Sesión Exitoso", "Bienvenido " + username);
                        } catch (IOException e) {
                            Alerts.alertError("Error inesperado", "Error: " + e.getMessage());
                        }
                    } else {
                        Alerts.alertWarning("Selección invalida", "Selecciona un puesto válido");
                    }
                } else {
                    Alerts.alertError("Error en Inicio de sesión", "Ingrese usuario y contraseña válidos");
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}