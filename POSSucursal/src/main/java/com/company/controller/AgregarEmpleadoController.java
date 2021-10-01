package com.company.controller;

import ConnectionDB.ConnDBH2;

import com.company.controller.App;
import com.company.controller.App;
import com.company.controller.PrincipalController;
import com.company.controller.PrincipalController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class AgregarEmpleadoController implements Initializable {

    @FXML private Label lblTitle1;
    @FXML private Label lblDescription1;
    @FXML private TextField txtDate;
    @FXML private ImageView imageMain;
    @FXML private TextField txtUsuario;
    @FXML private TextField txtContrasena;
    @FXML private TextField txtContrasena2;
    @FXML private RadioButton radioAdmin;
    @FXML private RadioButton radioEmpleado;
    @FXML private Button btnRegistrarEmpleado;
    @FXML private Button btnCancelarRegistro;
    
    // Agrupar radio buttons
    ToggleGroup tg = new ToggleGroup();

    // Generar la conexion
    private static final ConnDBH2 sql = new ConnDBH2();
    private static final Connection conn = sql.connectionDbH2();

    // Query
    private static String querySql = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PrincipalController.dateAndHour(this.txtDate);
        
        this.radioAdmin.setToggleGroup(this.tg);
        this.radioEmpleado.setToggleGroup(this.tg);
        
        //this.txtContrasena.set

    }

    @FXML
    private void insertToDB(ActionEvent event) {

        // Saber que en que nodo se acciona el evento
        Object evt = event.getSource();

        if (evt.equals(this.btnRegistrarEmpleado)) {

            if (!this.txtContrasena.getText().isEmpty() && !this.txtContrasena2.getText().isEmpty() && !this.txtUsuario.getText().isEmpty()) {
                
                if (this.txtContrasena.getText().equals(this.txtContrasena2.getText())) {

                    // Crear el query
                    querySql = "INSERT INTO usersemployees(userName, password) VALUES(?,?)";
                    
                    try {
                    
                        //PreparedStatment
                        //bucar para que sirve esto
                        PreparedStatement preparedStatement = conn.prepareStatement(querySql);
                        preparedStatement.setString(1, this.txtUsuario.getText());
                        preparedStatement.setString(2, this.txtContrasena.getText());
                        preparedStatement.execute();
                        //conn.close();

                        System.out.println("datos almacenados");
                    
                    } catch (SQLException e) {
                    
                        System.out.println("Algo fallo: " + e.toString());
                        //bucar para que sirve esto
                        Logger.getLogger(AgregarEmpleadoController.class.getName()).log(Level.SEVERE, null, e);
                    
                    }

                } else {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Nuevo empleado");
                    alert.setContentText("La contraseña no coinciden, verificalo por favor");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                }

            } else {
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nuevo empleado");
                alert.setContentText("Existe campos vacios");
                alert.setHeaderText(null);
                alert.showAndWait();
                
            }

        }

        /*
        try {
            App.setRoot("VistaListaEmpleado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        for(TextField item: CleanTextField){
            item.setText = "";
        }
        
         */
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
