/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelNuevaCuenta;
import views.ViewCrearCuenta;

import views.ViewLogin;
import models.ModelLogin;
import controllers.ControllerLogin;

import views.ViewMenu;
import models.ModelMenu;
import controllers.ControllerMenu;
import models.ModelClientes;
import views.ViewClientes;
/**
 *
 * @author Edgar
 */
public class ControllerNuevaCuenta {
    public ModelNuevaCuenta modelNuevaCuenta;
    public ViewCrearCuenta viewCrearCuenta;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCrearCuenta.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jmi_menu) {
                jmi_menu_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_nuevo) {
                jbtn_limpiar_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_cancelarnuevo) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_borrar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_cancelarmodificar) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_guardarm) {
                jbtn_guardarCambios_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewCrearCuenta.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
        }
};
    public ControllerNuevaCuenta(ModelNuevaCuenta modelNuevaCuenta, ViewCrearCuenta viewnuCrearCuenta) {
        this.modelNuevaCuenta = modelNuevaCuenta;
        this.viewCrearCuenta = viewnuCrearCuenta;
        initComponents();
        setActionListener();
        initDB();
    }
    private void setActionListener() {
        viewCrearCuenta.jbtn_primero.addActionListener(actionListener);
        viewCrearCuenta.jbtn_anterior.addActionListener(actionListener);
        viewCrearCuenta.jbtn_siguiente.addActionListener(actionListener);
        viewCrearCuenta.jbtn_ultimo.addActionListener(actionListener);
        viewCrearCuenta.jbtn_nuevo.addActionListener(actionListener);
        viewCrearCuenta.jbtn_guardar.addActionListener(actionListener);
        viewCrearCuenta.jbtn_modificar.addActionListener(actionListener);
        viewCrearCuenta.jbtn_borrar.addActionListener(actionListener);
        viewCrearCuenta.jbtn_cancelarmodificar.addActionListener(actionListener);
        viewCrearCuenta.jbtn_cancelarnuevo.addActionListener(actionListener);
        viewCrearCuenta.jbtn_guardarm.addActionListener(actionListener);      
        viewCrearCuenta.jmi_cerrar_sesion.addActionListener(actionListener);      
        viewCrearCuenta.jmi_menu.addActionListener(actionListener);
    }
    private void initDB() {
        modelNuevaCuenta.conectarDB();
        viewCrearCuenta.jtf_id.setText(modelNuevaCuenta.getId());
        viewCrearCuenta.jtf_nombre.setText(modelNuevaCuenta.getNombre());
        viewCrearCuenta.jtf_apaterno.setText(modelNuevaCuenta.getApellidop());
        viewCrearCuenta.jtf_amaterno.setText(modelNuevaCuenta.getApellidom());
        viewCrearCuenta.jtf_telefono.setText((modelNuevaCuenta.getTelefono()));
        viewCrearCuenta.jtf_calle.setText(modelNuevaCuenta.getCalle());
        viewCrearCuenta.jtf_numero.setText(modelNuevaCuenta.getNumero());
        viewCrearCuenta.jtf_colonia.setText(modelNuevaCuenta.getColonia());
        viewCrearCuenta.jtf_ciudad.setText(modelNuevaCuenta.getCiudad());
        viewCrearCuenta.jtf_cp.setText(modelNuevaCuenta.getCp());
        viewCrearCuenta.jtf_estado.setText(modelNuevaCuenta.getEstado());
        viewCrearCuenta.jpf_contrasenia.setText(modelNuevaCuenta.getPassword());       
        viewCrearCuenta.jtf_sucursal.setText(modelNuevaCuenta.getId_sucursal());
        viewCrearCuenta.jtf_nombre_usuario.setText(modelNuevaCuenta.getNombre_usuario());
    }
    public void noEditar(){
        viewCrearCuenta.jtf_id.setEditable(false);
        viewCrearCuenta.jtf_nombre.setEditable(false);
        viewCrearCuenta.jtf_apaterno.setEditable(false);
        viewCrearCuenta.jtf_amaterno.setEditable(false);
        viewCrearCuenta.jtf_telefono.setEditable(false);
        viewCrearCuenta.jtf_calle.setEditable(false);
        viewCrearCuenta.jtf_numero.setEditable(false);
        viewCrearCuenta.jtf_colonia.setEditable(false);
        viewCrearCuenta.jtf_ciudad.setEditable(false);
        viewCrearCuenta.jtf_cp.setEditable(false);
        viewCrearCuenta.jtf_estado.setEditable(false);
        viewCrearCuenta.jpf_contrasenia.setEditable(false);
        viewCrearCuenta.jpf_rep_contrasenia.setEditable(false);
        viewCrearCuenta.jtf_sucursal.setEditable(false);
        viewCrearCuenta.jtf_nombre_usuario.setEditable(false);
    }
    public void editar(){
        viewCrearCuenta.jtf_nombre.setEditable(true);
        viewCrearCuenta.jtf_apaterno.setEditable(true);
        viewCrearCuenta.jtf_amaterno.setEditable(true);
        viewCrearCuenta.jtf_telefono.setEditable(true);
        viewCrearCuenta.jtf_calle.setEditable(true);
        viewCrearCuenta.jtf_numero.setEditable(true);
        viewCrearCuenta.jtf_colonia.setEditable(true);
        viewCrearCuenta.jtf_ciudad.setEditable(true);
        viewCrearCuenta.jtf_cp.setEditable(true);
        viewCrearCuenta.jtf_estado.setEditable(true);
        viewCrearCuenta.jpf_contrasenia.setEditable(true);
        viewCrearCuenta.jpf_rep_contrasenia.setEditable(true);
        viewCrearCuenta.jtf_sucursal.setEditable(true);
        viewCrearCuenta.jtf_nombre_usuario.setEditable(true);
    }
    public void initComponents() {
        viewCrearCuenta.setLocationRelativeTo(null);
        viewCrearCuenta.setVisible(false);
        viewCrearCuenta.jbtn_guardar.setVisible(false);
        viewCrearCuenta.jbtn_cancelarmodificar.setVisible(false);
        viewCrearCuenta.jbtn_cancelarnuevo.setVisible(false);
        viewCrearCuenta.jbtn_guardarm.setVisible(false);
        noEditar();
    }
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelNuevaCuenta.moverPrimerRegistro();
        setValues();
    }
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelNuevaCuenta.moverAnteriorRegistro();
        setValues();
    }
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelNuevaCuenta.moverUltimoRegistro();
        setValues();
    }
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelNuevaCuenta.moverSiguienteRegistro();
        setValues();
    }
    private void setValues() {
        viewCrearCuenta.jtf_id.setText(modelNuevaCuenta.getId());
        viewCrearCuenta.jtf_nombre.setText(modelNuevaCuenta.getNombre());
        viewCrearCuenta.jtf_apaterno.setText(modelNuevaCuenta.getApellidop());
        viewCrearCuenta.jtf_amaterno.setText(modelNuevaCuenta.getApellidom());
        viewCrearCuenta.jtf_telefono.setText((modelNuevaCuenta.getTelefono()));
        viewCrearCuenta.jtf_calle.setText(modelNuevaCuenta.getCalle());
        viewCrearCuenta.jtf_numero.setText(modelNuevaCuenta.getNumero());
        viewCrearCuenta.jtf_colonia.setText(modelNuevaCuenta.getColonia());
        viewCrearCuenta.jtf_ciudad.setText(modelNuevaCuenta.getCiudad());
        viewCrearCuenta.jtf_cp.setText(modelNuevaCuenta.getCp());
        viewCrearCuenta.jtf_estado.setText(modelNuevaCuenta.getEstado());
        viewCrearCuenta.jtf_sucursal.setText(modelNuevaCuenta.getId_sucursal());
        viewCrearCuenta.jtf_nombre_usuario.setText(modelNuevaCuenta.getNombre_usuario());
    }
    public void jbtn_limpiar_actionPerformed(){
        viewCrearCuenta.jbtn_guardar.setVisible(true);
        viewCrearCuenta.jp_navegacion.setVisible(false);
        viewCrearCuenta.jbtn_modificar.setVisible(false);
        viewCrearCuenta.jbtn_nuevo.setVisible(false);
        viewCrearCuenta.jbtn_borrar.setVisible(false);
        viewCrearCuenta.jbtn_cancelarnuevo.setVisible(true);
        viewCrearCuenta.jtf_id.setText("");
        viewCrearCuenta.jtf_nombre.setText("");
        viewCrearCuenta.jtf_apaterno.setText("");
        viewCrearCuenta.jtf_amaterno.setText("");
        viewCrearCuenta.jtf_telefono.setText("");
        viewCrearCuenta.jtf_calle.setText("");
        viewCrearCuenta.jtf_numero.setText("");
        viewCrearCuenta.jtf_colonia.setText("");
        viewCrearCuenta.jtf_ciudad.setText("");
        viewCrearCuenta.jtf_cp.setText("");
        viewCrearCuenta.jtf_estado.setText("");
        viewCrearCuenta.jpf_contrasenia.setText("");
        viewCrearCuenta.jpf_rep_contrasenia.setText("");
        viewCrearCuenta.jtf_cp.setText("");
        viewCrearCuenta.jtf_sucursal.setText("");
        viewCrearCuenta.jtf_nombre_usuario.setText("");
        editar();
    }
    private void jbtn_guardar_actionPerformed(){
        modelNuevaCuenta.setNombre(viewCrearCuenta.jtf_nombre.getText());
        modelNuevaCuenta.setApellidop(viewCrearCuenta.jtf_apaterno.getText()); 
        modelNuevaCuenta.setApellidom(viewCrearCuenta .jtf_amaterno.getText()); 
        modelNuevaCuenta.setTelefono(viewCrearCuenta.jtf_telefono.getText()); 
        modelNuevaCuenta.setCalle(viewCrearCuenta.jtf_calle.getText());
        modelNuevaCuenta.setNumero(viewCrearCuenta.jtf_numero.getText());
        modelNuevaCuenta.setColonia(viewCrearCuenta.jtf_colonia.getText());
        modelNuevaCuenta.setCiudad(viewCrearCuenta.jtf_ciudad.getText());
        modelNuevaCuenta.setCp(viewCrearCuenta.jtf_cp.getText());
        modelNuevaCuenta.setEstado(viewCrearCuenta.jtf_estado.getText());
        modelNuevaCuenta.setPassword(viewCrearCuenta.jpf_contrasenia.getText());
        modelNuevaCuenta.setPassword(viewCrearCuenta.jpf_rep_contrasenia.getText());
        modelNuevaCuenta.setTipo_usuario(viewCrearCuenta.jcb_tipo_usuario.getItemAt(0));
        modelNuevaCuenta.setId_sucursal(viewCrearCuenta.jtf_sucursal.getText());
        modelNuevaCuenta.setNombre_usuario(viewCrearCuenta.jtf_nombre_usuario.getText());
        modelNuevaCuenta.guardarRegistro();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewCrearCuenta.setVisible(true);
    }
    public void cancelarNuevo_actionPerformed(){
        modelNuevaCuenta.conectarDB();
        viewCrearCuenta.jbtn_cancelarnuevo.setVisible(false);
        viewCrearCuenta.jbtn_guardar.setVisible(false);
        viewCrearCuenta.jp_navegacion.setVisible(true);
        viewCrearCuenta.jbtn_modificar.setVisible(true);
        viewCrearCuenta.jbtn_borrar.setVisible(true);
        viewCrearCuenta.jbtn_nuevo.setVisible(true);
        noEditar();
        setValues();
        initComponents();
        viewCrearCuenta.setVisible(true);
    }
    private void jbtn_modificar_actionPerformed(){
        viewCrearCuenta.jbtn_nuevo.setVisible(false);
        viewCrearCuenta.jbtn_cancelarmodificar.setVisible(true);
        viewCrearCuenta.jp_navegacion.setVisible(false);
        viewCrearCuenta.jbtn_guardarm.setVisible(true);
        viewCrearCuenta.jbtn_borrar.setVisible(false);
        viewCrearCuenta.jbtn_modificar.setVisible(false);
        editar();
    }
    private void jbtn_guardarCambios_actionPerformed(){
        modelNuevaCuenta.setNombre(viewCrearCuenta.jtf_nombre.getText());
        modelNuevaCuenta.setApellidop(viewCrearCuenta.jtf_apaterno.getText()); 
        modelNuevaCuenta.setApellidom(viewCrearCuenta.jtf_amaterno.getText()); 
        modelNuevaCuenta.setTelefono(viewCrearCuenta.jtf_telefono.getText()); 
        modelNuevaCuenta.setCalle(viewCrearCuenta.jtf_calle.getText());
        modelNuevaCuenta.setNumero(viewCrearCuenta.jtf_numero.getText());
        modelNuevaCuenta.setColonia(viewCrearCuenta.jtf_colonia.getText());
        modelNuevaCuenta.setCiudad(viewCrearCuenta.jtf_ciudad.getText());
        modelNuevaCuenta.setCp(viewCrearCuenta.jtf_cp.getText());
        modelNuevaCuenta.setEstado(viewCrearCuenta.jtf_estado.getText());
        modelNuevaCuenta.setPassword(viewCrearCuenta.jpf_contrasenia.getText());
        modelNuevaCuenta.setTipo_usuario(viewCrearCuenta.jcb_tipo_usuario.getItemAt(0));
        modelNuevaCuenta.setId_sucursal(viewCrearCuenta.jtf_sucursal.getText());
        modelNuevaCuenta.setNombre_usuario(viewCrearCuenta.jtf_nombre_usuario.getText());
        modelNuevaCuenta.guardarCambios();
        modelNuevaCuenta.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewCrearCuenta.setVisible(true);
    }
    private void jbtn_eliminar_actionPerformed(){
          modelNuevaCuenta.setId(viewCrearCuenta.jtf_id.getText());
//        modelClientes.setNombre(viewClientes.jtf_nombre.getText());
//        modelClientes.setApellidop(viewClientes.jtf_apaterno.getText()); 
//        modelClientes.setApellidom(viewClientes.jtf_amaterno.getText()); 
//        modelClientes.setTelefono(viewClientes.jtf_telefono.getText()); 
//        modelClientes.setCalle(viewClientes.jtf_calle.getText());
//        modelClientes.setNumero(viewClientes.jtf_numero_e.getText());
//        modelClientes.setColonia(viewClientes.jtf_colonia.getText());
//        modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
//        modelClientes.setCp(viewClientes.jtf_codigo_p.getText());
//        modelClientes.setEstado(viewClientes.jtf_estado.getText());
//        modelClientes.setRfc(viewClientes.jtf_rfc.getText()); 
        modelNuevaCuenta.borrarRegistro();
        modelNuevaCuenta.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewCrearCuenta.setVisible(true);
    }
    private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_cerrar_sesion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ModelLogin modelLogin= new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
                viewLogin.setVisible(true);
                viewCrearCuenta.setVisible(false);
            }
        }
    private void jmi_menu_actionPerformed() {
        System.out.println("Action del boton jbtn_menu");
        int resp=JOptionPane.showConfirmDialog(null,"Desea ir a menu?");
            if (JOptionPane.OK_OPTION == resp){
                ModelMenu modelMenu = new ModelMenu();
                ViewMenu viewMenu = new ViewMenu();
                ControllerMenu controllerMenu = new ControllerMenu(modelMenu, viewMenu);
                viewMenu.setVisible(true);
                viewCrearCuenta.setVisible(false);
            }
        }
}
