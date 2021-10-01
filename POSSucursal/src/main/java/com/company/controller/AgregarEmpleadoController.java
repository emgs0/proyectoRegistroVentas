package com.company.controller;

import ConnectionDB.ConnDBH2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AgregarEmpleadoController implements Initializable {

    @FXML private Label lblTitle1;
    @FXML private Label lblDescription1;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    @FXML private TextField txtUsuario;
    @FXML private TextField txtContrasena;
    @FXML private PasswordField txtContrasena2;
    @FXML private RadioButton radioAdmin;
    @FXML private RadioButton radioEmpleado;
    @FXML private Button btnRegistrarEmpleado;
    @FXML private Button btnCancelarRegistro;
    private Button btnSee;
    
    // Agrupar radio buttons
    ToggleGroup tg = new ToggleGroup();

    // Generar la conexion
    private static final ConnDBH2 sql = new ConnDBH2();
    private static final Connection conn = sql.connectionDbH2();

    // Query
    private static String querySql = "";
    
    // Declaracion de la alerta
    Alert alert = new Alert(Alert.AlertType.NONE);
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Cargar la hora 
        PrincipalController.dateAndHour(this.txtDate);
        
        // Cargar la imagen
        Image img = new Image("/images/image-main.png");
        this.imageMain.setImage(img);
        
        this.radioAdmin.setToggleGroup(this.tg);
        this.radioEmpleado.setToggleGroup(this.tg);
        this.radioAdmin.setSelected(true);
        
    }

    @FXML
    private void insertToDB(ActionEvent event) {

        // Saber que en que nodo se acciona el evento
        Object evt = event.getSource();

        if (evt.equals(this.btnRegistrarEmpleado)) {

            if (!this.txtContrasena.getText().isEmpty() && !this.txtContrasena2.getText().isEmpty() && !this.txtUsuario.getText().isEmpty()) {
                
                if (this.txtContrasena.getText().equals(this.txtContrasena2.getText())) {

                    // Crear el query
                    querySql = "INSERT INTO useremployee(user, password, typeEmployee) VALUES(?,?,?)";
                    
                    try {
                        
                        //PreparedStatment
                        //bucar para que sirve esto
                        PreparedStatement preparedStatement = conn.prepareStatement(querySql);
                        preparedStatement.setString(1, this.txtUsuario.getText());
                        preparedStatement.setString(2, this.txtContrasena.getText());
             
                        // Obtener el tipo de emplado (Administrador / Empleado)
                        if(this.radioAdmin.isSelected()) {

                            preparedStatement.setString(3, "Administrador");

                        } else {

                            preparedStatement.setString(3, "Empleado");

                        }

                        this.alert = new Alert(Alert.AlertType.CONFIRMATION);
                        this.alert.setTitle("Nuevo empleado");
                        this.alert.setContentText("¿Desea agregar un nuevo usuario al sistema?");
                        this.alert.setHeaderText(null);
                        // Se agrega esto para obtener el resultado de la alerta de la confirmación
                        Optional<ButtonType> action = this.alert.showAndWait();
                       
                        // confirmacion de la alerta
                        if(action.get() == ButtonType.OK) {
                            
                            this.alert = new Alert(Alert.AlertType.INFORMATION);
                            this.alert.setTitle("Nuevo empleado");
                            this.alert.setContentText("¡Usuario agregado con exito!");
                            this.alert.setHeaderText(null);
                            this.alert.showAndWait();
                            
                            // Ejecutar el query 
                            preparedStatement.execute();
                            
                            // Limpiar los campos
                            this.txtUsuario.setText("");
                            this.txtContrasena.setText("");
                            this.txtContrasena2.setText("");
                            this.radioAdmin.setSelected(true);
                            
                        } else {
                            
                            preparedStatement.cancel();
                            System.out.println("no execute");
                            
                        }
                    
                    } catch (SQLException e) {
                    
                        System.out.println("Algo fallo: " + e.toString());
                        //buscar para que sirve esto
                        Logger.getLogger(AgregarEmpleadoController.class.getName()).log(Level.SEVERE, null, e);
                    
                    }

                } else {

                    this.alert = new Alert(Alert.AlertType.WARNING);
                    this.alert.setTitle("Nuevo empleado");
                    this.alert.setContentText("La contraseña no coinciden, verificalo por favor");
                    this.alert.setHeaderText(null);
                    this.alert.showAndWait();

                }

            } else {
                
                this.alert = new Alert(Alert.AlertType.WARNING);
                this.alert.setTitle("Nuevo empleado");
                this.alert.setContentText("Existe campos vacios");
                this.alert.setHeaderText(null);
                this.alert.showAndWait();
                
            }

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
