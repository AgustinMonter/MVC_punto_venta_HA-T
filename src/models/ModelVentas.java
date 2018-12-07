package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ModelVentas {
    
     private Connection conexion;
    private Statement st;
    private ResultSet rs;

    
    private int id_venta;
    private int id_usuario;
    private int id_sucursal;
    private int id_cliente;
    private Date fecha;
    private int total_productos;
    private float iva;
    private float subtotal;
    private float importe_total;
    private String forma_pago;
   
    
    private ArrayList sucursales;
    private ArrayList empleados;
    private ArrayList clientes;
    private ArrayList productos;

   
    
    private String nom_empleado;
    private String nom_cliente;
    private String nom_sucursal;

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

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal_productos() {
        return total_productos;
    }

    public void setTotal_productos(int total_productos) {
        this.total_productos = total_productos;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(float importe_total) {
        this.importe_total = importe_total;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public ArrayList getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList empleados) {
        this.empleados = empleados;
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }

    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getNom_sucursal() {
        return nom_sucursal;
    }

    public void setNom_sucursal(String nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }
  
    private String nom_producto;  

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

 /**  public ResultSet getCons_detalle() {
        return cons_detalle;
    }

    public void setCons_detalle(ResultSet cons_detalle) {
        this.cons_detalle = cons_detalle;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
   
    
    **/
   // detalle_venta
     private int id_det_venta;
    private int id_venta_2;
    private int id_producto;
    private int cantidad;
    private float precio_venta;
    private float total_producto;
    private int id_promocion;
    private float total_descuento;

    public int getId_det_venta() {
        return id_det_venta;
    }

    public void setId_det_venta(int id_det_venta) {
        this.id_det_venta = id_det_venta;
    }

    public int getId_venta_2() {
        return id_venta_2;
    }

    public void setId_venta_2(int id_venta_2) {
        this.id_venta_2 = id_venta_2;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getTotal_producto() {
        return total_producto;
    }

    public void setTotal_producto(float total_producto) {
        this.total_producto = total_producto;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public float getTotal_descuento() {
        return total_descuento;
    }

    public void setTotal_descuento(float total_descuento) {
        this.total_descuento = total_descuento;
    }
    
    
     public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/htaac", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/ferreteriaacme", "tic41", "tic41");
            st = conexion.createStatement();
            String sql = "SELECT * FROM ventas;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelVentas 001: " + err.getMessage());
        }
    }
     
      public void llenarComboBox() {
      
        ResultSet cons_combo;
        
        try {
            cons_combo = st.executeQuery("SELECT * FROM usuarios_sistema;");
            ArrayList empv = new ArrayList();
            while (cons_combo.next()) {

                String nom = cons_combo.getString("nombre_usuario");
                String ap1 = cons_combo.getString("apellido_paterno");
                String ap2 = cons_combo.getString("apellido_materno");
                String elemento_empv = nom + " " + ap1 + " " + ap2;
                empv.add(elemento_empv);
            }
            this.setEmpleados(empv); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            cons_combo = st.executeQuery("SELECT * FROM clientes;");
            ArrayList cli = new ArrayList(); 
            while (cons_combo.next()) {

                String nom = cons_combo.getString("nombre_cliente");
                String ap1 = cons_combo.getString("apellido_paterno");
                String ap2 = cons_combo.getString("apellido_materno");
                String elemento_cli = nom + " " + ap1 + " " + ap2;
                cli.add(elemento_cli);
            }
            this.setClientes(cli);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try { 
            cons_combo = st.executeQuery("SELECT * FROM producto;");
            ArrayList prod = new ArrayList(); 
            while (cons_combo.next()) {
                String elem_producto = cons_combo.getString("nombre_producto");
                prod.add(elem_producto);
            }
            this.setProductos(prod); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
      public void setValues() {
        try {
            id_venta = rs.getInt("id_venta");
            id_cliente = rs.getInt("id_cliente");
            id_usuario = rs.getInt("id_usuario");
            fecha= rs.getDate("fecha_venta");
            total_productos = rs.getInt("total_productos");
            iva = rs.getInt("iva");
            importe_total = rs.getFloat("importe_total");;
            forma_pago = rs.getString("forma_pago");
            id_sucursal = rs.getInt("id_sucursal");
            
          
            ResultSet cons_suc = st.executeQuery("SELECT id_sucursal FROM sucursales WHERE id_sucursal = " + id_sucursal + "; ");
            if (cons_suc.next()) {
                nom_sucursal = cons_suc.getString(1);
            }
           
            ResultSet cons_empv = st.executeQuery("SELECT nombre_usuario, apellido_paterno, apellido_materno FROM usuarios_sistema WHERE id_usuario = " + id_usuario + "; ");
            if (cons_empv.next()) {
                String nombre = cons_empv.getString(1);
                String ape1 = cons_empv.getString(2);
                String ape2 = cons_empv.getString(3);
                nom_empleado = nombre + " " + ape1 + " " + ape2;
            }
            ResultSet cons_cli = st.executeQuery("SELECT nombre_cliente, apellido_paterno, apellido_paterno FROM clientes WHERE id_cliente = " + id_cliente + "; ");
            if (cons_cli.next()) {
                String nombre = cons_cli.getString(1);
                String ape1 = cons_cli.getString(2);
                String ape2 = cons_cli.getString(3);
                nom_cliente = nombre + " " + ape1 + " " + ape2;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 106: " + err.getMessage());
        }
    }
    
     
     public void insertarRegistro() {
        try {
          
            ResultSet cons = st.executeQuery("SELECT * FROM sucursales WHERE id_sucursal = '" + this.getNom_sucursal() + "'; ");
            if (cons.next()) {
                id_sucursal = cons.getInt("id_sucursal");
            }
            String concat_nomempv = nom_empleado.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM usuarios_sistema WHERE CONCAT(nombre_usuario, apellido_paterno, apellido_mataterno) = '"+ concat_nomempv +"'; ");
            if (cons.next()) {
                id_usuario = cons.getInt("id_usuario");
            }
            String concat_nomcli = nom_cliente.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM clientes WHERE CONCAT(nombre_cliente, apellido_paterno, apellido_materno) = '"+ concat_nomcli +"'; ");
            if (cons.next()) {
                id_cliente = cons.getInt("id_cliente");
            }
            
            id_venta = this.getId_venta(); 
            subtotal = this.getSubtotal();
            iva = this.getIva();
            importe_total = this.getImporte_total();
           
            forma_pago = this.getForma_pago();

            
            st.executeUpdate("INSERT INTO ventas (id_cliente, id_usuario, id_cliente, total_productos, iva, subtotal, importe_total, forma_pago,id_sucursal)"
                    + " VALUES (" + id_cliente + "," + id_usuario + ", " + total_productos + ", " + iva + ", " + subtotal + ", " + importe_total + ", '" + forma_pago + "', " + id_sucursal + "); ");
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            this.conectarDB();
            
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
 /**     private ResultSet cons_detalle; 
    public void setValuesDetalleVenta() {
        try {
            id_venta_2 = id_venta;
            precio_venta = cons_detalle.getFloat("precio_venta");
            cantidad = cons_detalle.getInt("cantidad");
            total_producto = cons_detalle.getFloat("total_producto");
            id_producto = cons_detalle.getInt("id_producto");            
            id_promocion = cons_detalle.getInt("id_promocion");
            total_descuento = cons_detalle.getFloat("total_con_descuento");
            // Obtiene los nombres de productos existentes en la BD, para asginarlos al ComboBox...
            ResultSet cons_prod = st.executeQuery("SELECT nombre_producto FROM productos WHERE id_producto = " + id_producto + "; ");
            if (cons_prod.next()) {
                nom_producto = cons_prod.getString(1);
            }
            
          //  registro_det[0] = Integer.toString(id_venta_2);
            //registro_det[1] = nom_producto;
            //registro_det[2] = Float.toString(precio_venta);
            //registro_det[3] = Integer.toString(cantidad);
            //registro_det[4] = Float.toString(total_producto);
            //registro_det[5] = Integer.toString(id_promocion);
            //registro_det[6] = Float.toString(total_final);
            //tabla_detalle.addRow(registro_det);

      //  } catch (SQLException err) {
        //    JOptionPane.showMessageDialog(null, "Error model 103: " + err.getMessage());
   //     }
    //}
    
    
    private int cursor = 1;**/
    
}
