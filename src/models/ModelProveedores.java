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

import views.ViewProveedores;
/**
 *
 * @author Edgar
 */
public class ModelProveedores {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String id;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String telefono;
    private String correo;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String cp;
    private String estado;
    private String razon_social;
    private String rfc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    
    
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM proveedor;";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelProveedor 001:Conexion con la base de datos " + err.getMessage());
        }
    }
    public void setValues() {
        try {
            id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: Erro al llenar datos " + err.getMessage());
        }
    }
    public void moverPrimerRegistro() {
        try {
            rs.first();
            id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : Al mover primer registro " + ex.getMessage());
        }
    }
    public void moverSiguienteRegistro() {
        try {
            if (!rs.isLast()) {
                rs.next();
                id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al mover siguiente registro" + ex.getMessage());
        }
    }
    public void moverAnteriorRegistro() {
        try {
            if (!rs.isFirst()) {
                rs.previous();
                id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al mover anterior registro" + ex.getMessage());
        }
    }
    public void moverUltimoRegistro() {
        try {
            rs.last();
            id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al  mover ultimo registro" + ex.getMessage());
        }
    }
    public void guardarRegistro(){
        try {
            id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
            st.executeUpdate("INSERT INTO proveedor (id_proveedor, nombre_proveedor, apellido_paterno, apellido_materno, telefono, correo, calle, no_exterior, colonia, ciudad, cp, estado, rfc, razon_social)" + " VALUES ('"+ id +"','"+ nombre +"','"+ apellidop +"',"+ apellidom +"','"+ telefono +"','"+ correo +"','"+ calle +"','"+ numero +"','"+ colonia +"','"+ ciudad +"','"+ cp +"','"+ estado +"','"+ rfc +"','"+ razon_social +"');");
            this.conectarDB();
            this.moverUltimoRegistro();
            JOptionPane.showMessageDialog(null, "Dato guardado Correctamente" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Registro" + ex.getMessage());
        }
    }
    public void guardarCambios(){
        try {
            id = rs.getString("id_proveedor");
            nombre = rs.getString("nombre_proveedor");
            apellidop = rs.getString("apellido_paterno");
            apellidom = rs.getString("apellido_materno");
            telefono = rs.getString("telefono");
            correo = rs.getString("correo");
            calle = rs.getString("calle");
            numero = rs.getString("no_exterior");
            colonia = rs.getString("colonia");
            ciudad = rs.getString("ciudad");
            cp = rs.getString("cp");
            estado = rs.getString("estado");
            razon_social = rs.getString("razon_social");
            rfc = rs.getString("rfc");
            st.executeUpdate("UPDATE proveedor SET nombre_proveedor = '"+ nombre +"', apellido_paterno = '"+ apellidop +"', apellido_materno = '"+ apellidom +"', telefono = '"+ telefono +"', correo = '"+ correo +"', calle = '"+ calle +"', no_exterior = '"+ numero +"', colonia = '"+ colonia +"', ciudad = '"+ ciudad +"', cp = '"+ cp +"', estado = '"+ estado +"', rfc = '"+ rfc +"', razon_social = '"+ razon_social +"' WHERE id_proveedor = "+ id +"; ");
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
            id = rs.getString("id_proveedor");
            st.executeUpdate("DELETE FROM proveedor WHERE id_proveedor = "+ id +"; ");
            this.conectarDB();
            this.moverUltimoRegistro();
            }
            else{
                moverPrimerRegistro();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar" + ex.getMessage());
        }
        
    }
}
