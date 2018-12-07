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
public class ModelDetalleCompra {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String id_detalle_compra;
    private String id_compra;
    private String id_producto;
    private String id_producto_actual;
    private String cantidad;
    private String cantidad_actual;
    private String precio_compra;
    private String precio_compra_actual;
    private String fecha_pedido;
    private String fecha_entrega;
    private String total_producto;
    

    

    /**
     * Método que realiza las siguietnes acciones:
     * Conecta con la base ferreteriaacme.
     * 
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM detalle_compra;");
            rs.next();
            llenarDatos();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 01: " + err.getMessage());
        }

    }
    public void llenarDatos(){
        try {
            id_detalle_compra = rs.getString("id_detalle_compra");
            id_compra = rs.getString("id_compra");
            id_producto = rs.getString("id_producto");
            cantidad = rs.getString("cantidad");
            precio_compra = rs.getString("precio_compra");
            fecha_pedido = rs.getString("fecha_pedido");
            fecha_entrega = rs.getString("fecha_entrega");
            total_producto = rs.getString("total_producto");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
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
     * 1.- Moverse al siguiente registro
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
     * 1.- Moverse al anterior registro
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
        float cantidadd=Float.parseFloat(cantidad);
        float precio_compraa=Float.parseFloat(precio_compra);
        float total_productoo= cantidadd * precio_compraa ;
        try {
            st.executeUpdate("insert into detalle_compra(id_compra, id_producto, cantidad, precio_compra, fecha_pedido, fecha_entrega, total_producto)"+" values ('"+id_compra+"','"+id_producto+"','"+cantidad+"','"+precio_compra+"','"+fecha_pedido+"','"+fecha_entrega+"','"+total_productoo+"');");
        } catch (SQLException ex) {
            Logger.getLogger(ModelCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Se a guardado la compra");
    }
    public void actualizarProductos(){
        System.out.println("actualizar");
        System.out.println(id_producto);
        try {
            rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
            rs.first();
            int cantidadd=Integer.parseInt(cantidad);
            int existencia = rs.getInt("existencia");
            System.out.println("Existencia"+existencia);
            int total_productos= cantidadd + existencia;
            System.out.println(total_productos);
            System.out.println(id_producto);
            String sql=("update producto set existencia='" +total_productos+ "' where id_producto='" +id_producto+ "';");
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda : " + ex.getMessage());
        }JOptionPane.showMessageDialog(null,"Se actualizo el producto");
            
        
            
        
    }
    public void actualizarDetalleCompra(){
        System.out.println(precio_compra_actual);
        try {
            //Si los dos id son iguales 
            if(id_producto==id_producto_actual){
                System.out.println("if 1");
                //Si los id y la cantidad son iguales
                if(cantidad==cantidad_actual){
                    System.out.println("if 2");
                    //Si los id, la cantidad son iguales y el precio
                    if(precio_compra==precio_compra_actual){
                        System.out.println("if 3");
                    String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto+"', cantidad='" +cantidad+ "', precio_compra='" +precio_compra+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "' where id_detalle_compra='" +id_detalle_compra+ "';");
                    System.out.println(sql);
                    st.executeUpdate(sql);
                    }else{
                        //Si los id, la cantidad son iguales y el precio son diferentes
                        System.out.println("else 1");
                        float cantidadd1=Float.parseFloat(cantidad_actual);
                        float precio_actual=Float.parseFloat(precio_compra_actual);
                        float precio_total= cantidadd1 * precio_actual;
                        String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto+"', cantidad='" +cantidad+ "', precio_compra='" +precio_compra+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "', precio_total='" +precio_total+ "' where id_detalle_compra='" +id_detalle_compra+ "';");
                        System.out.println(sql);
                        st.executeUpdate(sql);
                        
                    }
                }else{
                    //Si los id son iguales  y la cantidad son diferentes
                    System.out.println("else 2");
                    int cantidadd=Integer.parseInt(cantidad);
                    int cantidad_actuall=Integer.parseInt(cantidad_actual);
                    if(cantidadd<cantidad_actuall){
                        //si el id son iguales, la cantidad y la cantidad actual es mayor
                        System.out.println("if 4");
                        if(precio_compra==precio_compra_actual){
                            //si el id son iguales, la cantidad, la cantidad actual es mayor y los precios son iguales
                            System.out.println("if 5");
                            int total=cantidad_actuall - cantidadd;
                            String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto+"', cantidad='" +cantidad_actual+ "', precio_compra='" +precio_compra+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "' where id_detalle_compra='" +id_detalle_compra+ "';");
                            System.out.println(sql);
                            st.executeUpdate(sql);
                            rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                            rs.first();
                            int existencia = rs.getInt("existencia");
                            int total_prod= existencia + total;
                            String sqll=("update producto set existencia='" +total_prod+ "' where id_producto='" +id_producto+ "';");
                            System.out.println(sqll);
                            st.executeUpdate(sqll);
                        }else{
                            //si el id son iguales, la cantidad, la cantidad actual es mayor y los precios son diferentes
                            System.out.println("else 3");
                            float cantidadd1=Float.parseFloat(cantidad_actual);
                            float precio_actual=Float.parseFloat(precio_compra_actual);
                            float precio_total= cantidadd1 * precio_actual;
                            int total=cantidad_actuall - cantidadd;
                            String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto+"', cantidad='" +cantidad_actual+ "', precio_compra='" +precio_compra+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "', precio_total='" +precio_total+ "'where id_detalle_compra='" +id_detalle_compra+ "';");
                            System.out.println(sql);
                            st.executeUpdate(sql);
                            rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                            rs.first();
                            int existencia = rs.getInt("existencia");
                            int total_prod= existencia + total;
                            String sqll=("update producto set existencia='" +total_prod+ "' where id_producto='" +id_producto+ "';");
                            System.out.println(sqll);
                            st.executeUpdate(sqll);
                            
                        }
                    }else{
                        //si el id son iguales, la cantidad, la cantidad actual es menor y los precios son deciguales
                        System.out.println("else 3");
                        int total_p=cantidadd - cantidad_actuall;
                        rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                        rs.first();
                        int existencia = rs.getInt("existencia");
                        int total_produ= existencia - total_p;
                        String sqll=("update producto set existencia='" +total_produ+ "' where id_producto='" +id_producto+ "';");
                        System.out.println(sqll);
                        st.executeUpdate(sqll);
                    }
                    
                }
                
            }else{
                //Si los id son diferentes
                System.out.println("else 4");
                if(precio_compra==precio_compra_actual){
                    if(cantidad==cantidad_actual){
                    String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto_actual+"', cantidad='" +cantidad_actual+ "', precio_compra='" +precio_compra+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "' where id_detalle_compra='" +id_detalle_compra+ "';");
                    System.out.println(sql);
                    st.executeUpdate(sql);
                    rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto_actual+"';");
                    rs.first();
                    int existencia = rs.getInt("existencia");
                    int cantidad_actuall=Integer.parseInt(cantidad_actual);
                    int total_pro= existencia + cantidad_actuall;
                    String ssql=("update producto set existencia='" +total_pro+ "' where id_producto='" +id_producto_actual+ "';");
                    System.out.println(ssql);
                    st.executeUpdate(ssql);
                    rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                        rs.first();
                        int existenciaa = rs.getInt("existencia");
                        int cantidadd=Integer.parseInt(cantidad);
                        int total_produ= existenciaa - cantidadd;
                        String sqll=("update producto set existencia='" +total_produ+ "' where id_producto='" +id_producto+ "';");
                        System.out.println(sqll);
                        st.executeUpdate(sqll);
                }else{
                    System.out.println("else 5");
                    float cantidadd1=Float.parseFloat(cantidad_actual);
                    float precio_actual=Float.parseFloat(precio_compra_actual);
                    float precio_total= cantidadd1 * precio_actual;
                    System.out.println(precio_compra);
                    String sql=("update detalle_compra set id_compra='" +id_compra+ "', id_producto='" +id_producto_actual+"', cantidad='" +cantidad_actual+ "', precio_compra='" +precio_compra_actual+ "', fecha_pedido='" +fecha_pedido+ "', fecha_entrega='" +fecha_entrega+ "',  total_producto='" +precio_total+ "' where id_detalle_compra='" +id_detalle_compra+ "';");
                    System.out.println(sql);
                    st.executeUpdate(sql);
                    int cantidadd2=Integer.parseInt(cantidad);
                    int cantidad_actuall1=Integer.parseInt(cantidad_actual);
                    if (cantidadd2 < cantidad_actuall1){
                    rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                        rs.first();
                        int existenciaa = rs.getInt("existencia");
                        int cantidadd=Integer.parseInt(cantidad_actual);
                        int cant= cantidad_actuall1 - cantidadd2;
                        int total_produ= existenciaa + cant;
                        String sqll=("update producto set existencia='" +total_produ+ "' where id_producto='" +id_producto+ "';");
                        System.out.println(sqll);
                        st.executeUpdate(sqll);
                        }
                    else{
                        rs = st.executeQuery("SELECT existencia FROM producto where id_producto='"+id_producto+"';");
                        rs.first();
                        int existenciaa = rs.getInt("existencia");
                        int cantidadd=Integer.parseInt(cantidad_actual);
                        int cant= cantidadd2 - cantidad_actuall1 ;
                        int total_produ= existenciaa - cant;
                        String sqll=("update producto set existencia='" +total_produ+ "' where id_producto='" +id_producto+ "';");
                        System.out.println(sqll);
                        st.executeUpdate(sqll);
                    
                    }
                }
                }
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda : " + ex.getMessage());
        }JOptionPane.showMessageDialog(null,"Se actualizo el producto");
        
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

    public String getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(String id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getTotal_producto() {
        return total_producto;
    }

    public void setTotal_producto(String total_producto) {
        this.total_producto = total_producto;
    }

    public String getId_producto_actual() {
        return id_producto_actual;
    }

    public void setId_producto_actual(String id_producto_actual) {
        this.id_producto_actual = id_producto_actual;
    }

    public String getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(String cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public String getPrecio_compra_actual() {
        return precio_compra_actual;
    }

    public void setPrecio_compra_actual(String precio_compra_actual) {
        this.precio_compra_actual = precio_compra_actual;
    }

    

    
    
}