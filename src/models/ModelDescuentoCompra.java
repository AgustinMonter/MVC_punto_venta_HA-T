/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Felix
 */
public class ModelDescuentoCompra {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String id_descuento_compra;
    private String id_producto;
    private String id_proveedor;
    private String id_detalle_compra;
    private String porcentaje_descontar;
    
    

    

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base ferreteriaacme.
     * 2.- Consulta todo los registros de la tabla descuento_compra.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM descuento_compra;");
            rs.next();
            llenarDatos();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 01: " + err.getMessage());
        }

    }
    /**
     * Metodo que obtiene de la base de tatos los registros de la tabla descuento compra y los guarda el variables
     */
    public void llenarDatos(){
        try {
            id_descuento_compra = rs.getString("id_descuento_compra");
            id_producto = rs.getString("id_producto");
            id_proveedor = rs.getString("id_proveedor");
            id_detalle_compra = rs.getString("id_detalle_compra");
            porcentaje_descontar = rs.getString("porcentaje_descontar");
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * Moverse al primer registro, invoca a llenar datos
     *
     */
    public void moverPrimerRegistro(){
        try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 02" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * Moverse al siguiente registro invoca a llenar datos
     * 
     */
    public void moverSiguienteRegistro(){
        try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 03" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * Moverse al anterior registro invoca a llenar datos
     *
     */
    public void moverAnteriorRegistro(){
         try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 04" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro, invoca a llenar datos
     */
    public void moverUltimoRegistro(){
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 05" + ex.getMessage());
        }
    }
    /**
     * Metodo que permite guardar en la tabla descuento compra
     */
    public void guardar(){ 
        try {
           st.executeUpdate("insert into detalle_compra(id_producto, id_proveedor, id_detalle_compra, porcentaje_descontar)"+" values ('"+id_producto+"','"+id_proveedor+"','"+id_detalle_compra+"','"+porcentaje_descontar+"');");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se a guardado el descuento");
    }
    /**
     * Metodo que permite actualizar descuento compras
     */
    public void actualizar(){
        try {
            st.executeUpdate("update descuento_compra set id_producto='" +id_producto+ "', id_proveedor='"+id_proveedor+"', id_detalle_compra='"+id_detalle_compra+"', porcentaje_descontar='"+porcentaje_descontar+"' where id_descuento_compra='" +id_descuento_compra+ "';");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se actualizo el descuento");
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getId_descuento_compra() {
        return id_descuento_compra;
    }

    public void setId_descuento_compra(String id_descuento_compra) {
        this.id_descuento_compra = id_descuento_compra;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(String id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public String getPorcentaje_descontar() {
        return porcentaje_descontar;
    }

    public void setPorcentaje_descontar(String porcentaje_descontar) {
        this.porcentaje_descontar = porcentaje_descontar;
    }

    
    
}

