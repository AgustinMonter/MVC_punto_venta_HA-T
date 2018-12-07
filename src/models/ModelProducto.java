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
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ModelProducto {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
  private String id_producto;
    private String nombre;
    private String tipo;
    private String marca;
    private String existencia;
    private String precio_unitario;
    private String precio_mayoreo;
    private String descripcion;
     private String id_sucursal;

  public String getNombre() {
        return nombre;
    }
    public void setTipo_producto(String tipo) {
        this.nombre = tipo;
    } public String getTipo_producto() {
        return tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
     public String getExistencia() {
        return existencia;
    }
    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }
     public String getPrecioMayor() {
        return precio_mayoreo;
    }
    public void setPrecioMayor(String precio_mayoreo) {
        this.precio_mayoreo = precio_mayoreo;
    }
   
 public String getIdproducto() {
        return id_producto;
    }
    public void setIdproducto(String id_producto) {
        this.id_producto = id_producto;
    }public String getPreciouni() {
        return precio_unitario;
    }
    public void setPreciouni(String preciouni) {
        this.precio_unitario = preciouni;
    }
    public String getIdsucursal() {
        return id_sucursal;
    }
    public void setIdsucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
     public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }
    
    
    public void conectarDB() {
         try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            String sql = "SELECT * FROM producto;";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model Clientes 001:Conexion con la base de datos " + err.getMessage());
        }}
    
    public void setValues() {
        try {
         nombre = rs.getString("nombre_producto");
            marca = rs.getString("marca");
            tipo = rs.getString("tipo_producto");
            id_producto = rs.getString("id_producto");
            precio_unitario = rs.getString("precio_unitario");
            precio_mayoreo = rs.getString("precio_mayoreo");
            existencia= rs.getString("existencia");
            descripcion  = rs.getString("descripcion");
            id_sucursal= rs.getString("id_sucursal");
           
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: Erro al llenar datos " + err.getMessage());
        }
    }
    public void getValues(){
        try{
            id_producto = this.getIdproducto();
            nombre=this.getNombre();
            marca = this.getMarca();
            tipo = this.getTipo_producto();
            existencia = this.getExistencia();
            precio_mayoreo = this.getPrecioMayor();
            precio_unitario= this.getPreciouni();
            descripcion= this.getDescripcion();
            id_sucursal= this.getIdsucursal();  
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error model 103: Erro al obtener datos " + err.getMessage());
        }
    }
    public void moverPrimerRegistro() {
        try {
            rs.first();
            setValues();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : Al mover primer registro " + ex.getMessage());
        }
    JOptionPane.showMessageDialog(null, "Llegaste al primero");
    }
    
    public void moverSiguienteRegistro() {
        try {
            if (!rs.isLast()) {
                rs.next();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al mover siguiente registro" + ex.getMessage());
        }
    }
    public void moverAnteriorRegistro() {
        try {
            if (!rs.isFirst()) {
                rs.previous();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al mover anterior registro" + ex.getMessage());
        }
    }
    public void moverUltimoRegistro() {
        try {
            rs.last();
            setValues();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al  mover ultimo registro" + ex.getMessage());
        
        }
     
    }
    public void guardarRegistro(){
        try {
            getValues();
            st.executeUpdate("INSERT INTO producto ( nombre_producto,tipo_producto, marca, precio_unitario, precio_mayoreo, existencia, descripcion, id_sucursal)" + " VALUES ('"+ nombre +"','"+ marca +"','"+ tipo +"','"+ precio_unitario +"','"+ precio_mayoreo +"','"+ existencia +"','"+ descripcion+"','"+ id_sucursal+"');");
            this.conectarDB();                                                                                                                                                  //id_producto, nombre_producto, marca, precio_unitario, precio_mayoreo, existencia, descripcion, id_sucursal//           
            this.moverUltimoRegistro();
            JOptionPane.showMessageDialog(null, "Dato guardado Correctamente" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Registro" + ex.getMessage());
        }
    }
    public void guardarCambios(){
        try {
            getValues();
           st.executeUpdate("UPDATE producto SET nombre_producto = '"+ nombre +"', marca = '"+ marca +"', tipo_producto = '"+ tipo +"', existencia = '"+ existencia +"', id_sucursal= '"+ id_sucursal +"', descripcion = '"+ descripcion +"', precion_mayoreo = '"+ precio_mayoreo +"', precio_unitario = '"+ precio_unitario +"' WHERE id_producto = "+ id_producto +"; ");
            this.conectarDB();
            this.moverUltimoRegistro();
            JOptionPane.showMessageDialog(null, "Dato modificado" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar" + ex.getMessage());
        }
        
    }
    public void borrarRegistro(){
        try {
            int resp=JOptionPane.showConfirmDialog(null,"Esta seguro de que desea eliminar el registro actual?");
            if (JOptionPane.OK_OPTION == resp){
            id_producto = rs.getString("id_producto");
            st.executeUpdate("DELETE FROM producto WHERE id_producto = "+ id_producto +"; ");
            this.conectarDB();
            this.moverUltimoRegistro();
            JOptionPane.showMessageDialog(null, "Registro eliminado" );
            }
            else{
                moverPrimerRegistro();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar" + ex.getMessage());
        }
        
    }
}
