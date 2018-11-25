/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import controllers.ControllerLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import views.ViewLogin;
import models.ModelLogin;
import controllers.ControllerLogin;

import views.ViewMenu;
import models.ModelMenu;
import controllers.ControllerMenu;
/**
 *
 * @author Edgar
 */
public class ModelLogin {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String nombreusuario;
    private String contrasenia;
    
    private Object controllers[];
    private ControllerLogin controllerlogin;

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    private void setControllers() {
        controllerlogin = (ControllerLogin) controllers[0];
    }
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            String sql = "SELECT * FROM usuarios_sistema;";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            //rs.next();
            //setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelLogin 001:Conexion con la base de datos " + err.getMessage());
        }
    }
    public void setValues() {
        try {
            nombreusuario = rs.getString("usuario");
            contrasenia = rs.getString("password");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: Erro al llenar datos " + err.getMessage());
        }
    }
    public void iniciarSecion(){
        try{
            nombreusuario = this.getNombreusuario();
            contrasenia = this.getContrasenia();
            rs=st.executeQuery("select count(usuario) as existe from usuarios_sistema where usuario='"+nombreusuario+"' and password='"+contrasenia+"';");
            rs.first();
            int Existe;
            String existe=rs.getString("existe");
            Existe=Integer.parseInt(existe);
            if (Existe==1){
                ModelMenu modelMenu = new ModelMenu();
                ViewMenu viewMenu = new ViewMenu();
                ControllerMenu controllerMenu = new ControllerMenu(modelMenu, viewMenu);
                viewMenu.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Verfica que el Usuario o la Contraseña sean correctas");
                ModelLogin modelLogin = new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
           }
         } catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }         
    }
    public void salir(){
        System.exit(0);
    }
}
