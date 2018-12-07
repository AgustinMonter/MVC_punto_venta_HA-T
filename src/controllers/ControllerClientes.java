/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelClientes;
import views.ViewClientes;

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
public class ControllerClientes {
    public ModelClientes modelClientes;
    public ViewClientes viewClientes;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
            } else if (e.getSource() == viewClientes.jmi_menu) {
                jmi_menu_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_nuevo) {
                jbtn_limpiar_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_cancelarnuevo) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_borrar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_cancelarmodificar) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_guardarm) {
                jbtn_guardarCambios_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewClientes.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
        
    }
};
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        initComponents();
        setActionListener();
        initDB();
    }
    private void setActionListener() {
        viewClientes.jbtn_primero.addActionListener(actionListener);
        viewClientes.jbtn_anterior.addActionListener(actionListener);
        viewClientes.jbtn_siguiente.addActionListener(actionListener);
        viewClientes.jbtn_ultimo.addActionListener(actionListener);
        viewClientes.jbtn_nuevo.addActionListener(actionListener);
        viewClientes.jbtn_guardar.addActionListener(actionListener);
        viewClientes.jbtn_modificar.addActionListener(actionListener);
        viewClientes.jbtn_borrar.addActionListener(actionListener);
        viewClientes.jbtn_cancelarmodificar.addActionListener(actionListener);
        viewClientes.jbtn_cancelarnuevo.addActionListener(actionListener);
        viewClientes.jbtn_guardarm.addActionListener(actionListener);      
        viewClientes.jmi_cerrar_sesion.addActionListener(actionListener);      
        viewClientes.jmi_menu.addActionListener(actionListener);
    }
    private void initDB() {
        modelClientes.conectarDB();
        viewClientes.jtf_id.setText(modelClientes.getId());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_apaterno.setText(modelClientes.getApellidop());
        viewClientes.jtf_amaterno.setText(modelClientes.getApellidom());
        viewClientes.jtf_telefono.setText((modelClientes.getTelefono()));
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_e.setText(modelClientes.getNumero());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_codigo_p.setText(modelClientes.getCp());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
    }
    public void noEditar(){
        viewClientes.jtf_id.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_apaterno.setEditable(false);
        viewClientes.jtf_amaterno.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
        viewClientes.jtf_calle.setEditable(false);
        viewClientes.jtf_numero_e.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_ciudad.setEditable(false);
        viewClientes.jtf_codigo_p.setEditable(false);
        viewClientes.jtf_estado.setEditable(false);
        viewClientes.jtf_rfc.setEditable(false);
    }
    public void editar(){
        viewClientes.jtf_id.setEditable(false);
        viewClientes.jtf_nombre.setEditable(true);
        viewClientes.jtf_apaterno.setEditable(true);
        viewClientes.jtf_amaterno.setEditable(true);
        viewClientes.jtf_telefono.setEditable(true);
        viewClientes.jtf_calle.setEditable(true);
        viewClientes.jtf_numero_e.setEditable(true);
        viewClientes.jtf_colonia.setEditable(true);
        viewClientes.jtf_ciudad.setEditable(true);
        viewClientes.jtf_codigo_p.setEditable(true);
        viewClientes.jtf_estado.setEditable(true);
        viewClientes.jtf_rfc.setEditable(true);
    }
    public void initComponents() {
        viewClientes.setLocationRelativeTo(null);
        viewClientes.setVisible(false);
        viewClientes.jbtn_guardar.setVisible(false);
        viewClientes.jbtn_cancelarmodificar.setVisible(false);
        viewClientes.jbtn_cancelarnuevo.setVisible(false);
        viewClientes.jbtn_guardarm.setVisible(false);
        noEditar();
    }
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelClientes.moverPrimerRegistro();
        setValues();
    }
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelClientes.moverAnteriorRegistro();
        setValues();
    }
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelClientes.moverUltimoRegistro();
        setValues();
    }
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelClientes.moverSiguienteRegistro();
        setValues();
    }
    private void setValues() {
        viewClientes.jtf_id.setText(modelClientes.getId());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_apaterno.setText(modelClientes.getApellidop());
        viewClientes.jtf_amaterno.setText(modelClientes.getApellidom());
        viewClientes.jtf_telefono.setText((modelClientes.getTelefono()));
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero_e.setText(modelClientes.getNumero());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_codigo_p.setText(modelClientes.getCp());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
    }
    public void jbtn_limpiar_actionPerformed(){
        viewClientes.jbtn_guardar.setVisible(true);
        viewClientes.jp_navegacion.setVisible(false);
        viewClientes.jbtn_modificar.setVisible(false);
        viewClientes.jbtn_nuevo.setVisible(false);
        viewClientes.jbtn_borrar.setVisible(false);
        viewClientes.jbtn_cancelarnuevo.setVisible(true);
        viewClientes.jtf_id.setText("");
        viewClientes.jtf_nombre.setText("");
        viewClientes.jtf_apaterno.setText("");
        viewClientes.jtf_amaterno.setText("");
        viewClientes.jtf_telefono.setText("");
        viewClientes.jtf_calle.setText("");
        viewClientes.jtf_numero_e.setText("");
        viewClientes.jtf_colonia.setText("");
        viewClientes.jtf_ciudad.setText("");
        viewClientes.jtf_codigo_p.setText("");
        viewClientes.jtf_estado.setText("");
        viewClientes.jtf_rfc.setText("");
        editar();
    }
    private void jbtn_guardar_actionPerformed(){
        modelClientes.setId(viewClientes.jtf_id.getText());
        modelClientes.setNombre(viewClientes.jtf_nombre.getText());
        modelClientes.setApellidop(viewClientes.jtf_apaterno.getText()); 
        modelClientes.setApellidom(viewClientes.jtf_amaterno.getText()); 
        modelClientes.setTelefono(viewClientes.jtf_telefono.getText()); 
        modelClientes.setCalle(viewClientes.jtf_calle.getText());
        modelClientes.setNumero(viewClientes.jtf_numero_e.getText());
        modelClientes.setColonia(viewClientes.jtf_colonia.getText());
        modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
        modelClientes.setCp(viewClientes.jtf_codigo_p.getText());
        modelClientes.setEstado(viewClientes.jtf_estado.getText());
        modelClientes.setRfc(viewClientes.jtf_rfc.getText());
        modelClientes.guardarRegistro();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewClientes.setVisible(true);
    }
    public void cancelarNuevo_actionPerformed(){
        modelClientes.conectarDB();
        viewClientes.jbtn_cancelarnuevo.setVisible(false);
        viewClientes.jbtn_guardar.setVisible(false);
        viewClientes.jp_navegacion.setVisible(true);
        viewClientes.jbtn_modificar.setVisible(true);
        viewClientes.jbtn_borrar.setVisible(true);
        viewClientes.jbtn_nuevo.setVisible(true);
        noEditar();
        setValues();
        initComponents();
        viewClientes.setVisible(true);
    }
    private void jbtn_modificar_actionPerformed(){
        viewClientes.jbtn_nuevo.setVisible(false);
        viewClientes.jbtn_cancelarmodificar.setVisible(true);
        viewClientes.jp_navegacion.setVisible(false);
        viewClientes.jbtn_guardarm.setVisible(true);
        viewClientes.jbtn_borrar.setVisible(false);
        viewClientes.jbtn_modificar.setVisible(false);
        editar();
    }
    private void jbtn_guardarCambios_actionPerformed(){
        modelClientes.setId(viewClientes.jtf_id.getText());
        modelClientes.setNombre(viewClientes.jtf_nombre.getText());
        modelClientes.setApellidop(viewClientes.jtf_apaterno.getText()); 
        modelClientes.setApellidom(viewClientes.jtf_amaterno.getText()); 
        modelClientes.setTelefono(viewClientes.jtf_telefono.getText()); 
        modelClientes.setCalle(viewClientes.jtf_calle.getText());
        modelClientes.setNumero(viewClientes.jtf_numero_e.getText());
        modelClientes.setColonia(viewClientes.jtf_colonia.getText());
        modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
        modelClientes.setCp(viewClientes.jtf_codigo_p.getText());
        modelClientes.setEstado(viewClientes.jtf_estado.getText());
        modelClientes.setRfc(viewClientes.jtf_rfc.getText());
        modelClientes.guardarCambios();
        modelClientes.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewClientes.setVisible(true);
    }
    private void jbtn_eliminar_actionPerformed(){
        modelClientes.setId(viewClientes.jtf_id.getText());
        modelClientes.setNombre(viewClientes.jtf_nombre.getText());
        modelClientes.setApellidop(viewClientes.jtf_apaterno.getText()); 
        modelClientes.setApellidom(viewClientes.jtf_amaterno.getText()); 
        modelClientes.setTelefono(viewClientes.jtf_telefono.getText()); 
        modelClientes.setCalle(viewClientes.jtf_calle.getText());
        modelClientes.setNumero(viewClientes.jtf_numero_e.getText());
        modelClientes.setColonia(viewClientes.jtf_colonia.getText());
        modelClientes.setCiudad(viewClientes.jtf_ciudad.getText());
        modelClientes.setCp(viewClientes.jtf_codigo_p.getText());
        modelClientes.setEstado(viewClientes.jtf_estado.getText());
        modelClientes.setRfc(viewClientes.jtf_rfc.getText()); 
        modelClientes.borrarRegistro();
        modelClientes.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewClientes.setVisible(true);
    }
    private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_cerrar_sesion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ModelLogin modelLogin = new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
                viewLogin.setVisible(true);
                viewClientes.setVisible(false);
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
                viewClientes.setVisible(false);
            }
        }
}
