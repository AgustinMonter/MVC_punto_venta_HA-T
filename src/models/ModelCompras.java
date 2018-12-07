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
public class ModelCompras {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String id_compra;
    private String id_proveedor;
    private String subtotal;
    private String fecha_compra;
    private String iva;
    private String importe_total;
    private String id_usuario;

    

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base ferreteriaacme.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM compra;");
            rs.next();
            llenarDatos();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 01: " + err.getMessage());
        }

    }
    public void llenarDatos(){
        try {
            id_compra = rs.getString("id_compra");
            id_proveedor = rs.getString("id_proveedor");
            subtotal = rs.getString("subtotal");
            fecha_compra = rs.getString("fecha_compra");
            iva = rs.getString("iva");
            importe_total = rs.getString("importe_total");
            id_usuario = rs.getString("id_usuario");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
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
     * 1.- Moverse al siguiente registro
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
     * 1.- Moverse al anterior registro
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
     * 1.- Moverse al ultimo registro
     */
    public void moverUltimoRegistro(){
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 05" + ex.getMessage());
        }
    }
    public void guardar(){
        float total=Float.parseFloat(subtotal);
        double importe_totall= total * .16 + total;
        try {
            st.executeUpdate("insert into compra(id_proveedor, id_usuario, subtotal, iva, importe_total)"+" values ('"+id_proveedor+"','"+id_usuario+"','"+subtotal+"','"+16+"','"+importe_totall+"');");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se a guardado la compra");
    }
    public void actualizar(){
        float total=Float.parseFloat(subtotal);
        float ivaa=Float.parseFloat(iva);
        float importe_totall= total / ivaa + total;
        try {
            st.executeUpdate("update compra set id_usuario='" +id_usuario+ "', id_proveedor='"+id_proveedor+"', subtotal='"+subtotal+"', importe_total='"+importe_totall+"' where id_compra='" +id_compra+ "';");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se actualizo la compra");
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

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(String importe_total) {
        this.importe_total = importe_total;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}

