/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelProveedores;
import views.ViewMenu;
import views.ViewProveedores;

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
public class ControllerProveedores {
    public ModelProveedores modelProveedores;
    public ViewProveedores viewProveedores;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedores.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
            } else if (e.getSource() == viewProveedores.jmi_menu) {
                jmi_menu_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_nuevo) {
                jbtn_limpiar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_cancelarnuevo) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_borrar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_cancelarmodificar) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_guardarm) {
                jbtn_guardarCambios_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewProveedores.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
        
    }
};
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        initComponents();
        setActionListener();
        initDB();
    }
    private void setActionListener() {
        viewProveedores.jbtn_primero.addActionListener(actionListener);
        viewProveedores.jbtn_anterior.addActionListener(actionListener);
        viewProveedores.jbtn_siguiente.addActionListener(actionListener);
        viewProveedores.jbtn_ultimo.addActionListener(actionListener);
        viewProveedores.jbtn_nuevo.addActionListener(actionListener);
        viewProveedores.jbtn_guardar.addActionListener(actionListener);
        viewProveedores.jbtn_modificar.addActionListener(actionListener);
        viewProveedores.jbtn_borrar.addActionListener(actionListener);
        viewProveedores.jbtn_cancelarmodificar.addActionListener(actionListener);
        viewProveedores.jbtn_cancelarnuevo.addActionListener(actionListener);
        viewProveedores.jbtn_guardarm.addActionListener(actionListener);      
        viewProveedores.jmi_cerrar_sesion.addActionListener(actionListener);      
        viewProveedores.jmi_menu.addActionListener(actionListener);
    }
    private void initDB() {
        modelProveedores.conectarDB();
        viewProveedores.jtf_id.setText(modelProveedores.getId());
        viewProveedores.jtf_nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_apaterno.setText(modelProveedores.getApellidop());
        viewProveedores.jtf_amaterno.setText(modelProveedores.getApellidom());
        viewProveedores.jtf_telefono.setText((modelProveedores.getTelefono()));
        viewProveedores.jtf_correo.setText(modelProveedores.getCorreo());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_e.setText(modelProveedores.getNumero());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_codigo_p.setText(modelProveedores.getCp());
        viewProveedores.jtf_estado.setText(modelProveedores.getEstado());
        viewProveedores.jtf_rfc.setText(modelProveedores.getRfc());
        viewProveedores.jtf_razon_social.setText(modelProveedores.getRazon_social());
    }
    public void noEditar(){
        viewProveedores.jtf_id.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(false);
        viewProveedores.jtf_apaterno.setEditable(false);
        viewProveedores.jtf_amaterno.setEditable(false);
        viewProveedores.jtf_telefono.setEditable(false);
        viewProveedores.jtf_correo.setEditable(false);
        viewProveedores.jtf_calle.setEditable(false);
        viewProveedores.jtf_numero_e.setEditable(false);
        viewProveedores.jtf_colonia.setEditable(false);
        viewProveedores.jtf_ciudad.setEditable(false);
        viewProveedores.jtf_codigo_p.setEditable(false);
        viewProveedores.jtf_estado.setEditable(false);
        viewProveedores.jtf_rfc.setEditable(false);
        viewProveedores.jtf_razon_social.setEditable(false);
    }
    public void editar(){
        viewProveedores.jtf_id.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(true);
        viewProveedores.jtf_apaterno.setEditable(true);
        viewProveedores.jtf_amaterno.setEditable(true);
        viewProveedores.jtf_telefono.setEditable(true);
        viewProveedores.jtf_correo.setEditable(true);
        viewProveedores.jtf_calle.setEditable(true);
        viewProveedores.jtf_numero_e.setEditable(true);
        viewProveedores.jtf_colonia.setEditable(true);
        viewProveedores.jtf_ciudad.setEditable(true);
        viewProveedores.jtf_codigo_p.setEditable(true);
        viewProveedores.jtf_estado.setEditable(true);
        viewProveedores.jtf_rfc.setEditable(true);
        viewProveedores.jtf_razon_social.setEditable(true);
    }
    public void initComponents() {
        viewProveedores.setLocationRelativeTo(null);
        viewProveedores.setVisible(true);
        viewProveedores.jbtn_guardar.setVisible(false);
        viewProveedores.jbtn_cancelarmodificar.setVisible(false);
        viewProveedores.jbtn_cancelarnuevo.setVisible(false);
        viewProveedores.jbtn_guardarm.setVisible(false);
        noEditar();
    }
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelProveedores.moverPrimerRegistro();
        setValues();
    }
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelProveedores.moverAnteriorRegistro();
        setValues();
    }
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelProveedores.moverUltimoRegistro();
        setValues();
    }
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelProveedores.moverSiguienteRegistro();
        setValues();
    }
    private void setValues() {
        viewProveedores.jtf_id.setText(modelProveedores.getId());
        viewProveedores.jtf_nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_apaterno.setText(modelProveedores.getApellidop());
        viewProveedores.jtf_amaterno.setText(modelProveedores.getApellidom());
        viewProveedores.jtf_telefono.setText((modelProveedores.getTelefono()));
        viewProveedores.jtf_correo.setText(modelProveedores.getCorreo());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_numero_e.setText(modelProveedores.getNumero());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_codigo_p.setText(modelProveedores.getCp());
        viewProveedores.jtf_estado.setText(modelProveedores.getEstado());
        viewProveedores.jtf_rfc.setText(modelProveedores.getRfc());
        viewProveedores.jtf_razon_social.setText(modelProveedores.getRazon_social());
    }
    public void jbtn_limpiar_actionPerformed(){
        viewProveedores.jbtn_guardar.setVisible(true);
        viewProveedores.jp_navegacion.setVisible(false);
        viewProveedores.jbtn_modificar.setVisible(false);
        viewProveedores.jbtn_nuevo.setVisible(false);
        viewProveedores.jbtn_borrar.setVisible(false);
        viewProveedores.jbtn_cancelarnuevo.setVisible(true);
        viewProveedores.jtf_id.setText("");
        viewProveedores.jtf_nombre.setText("");
        viewProveedores.jtf_apaterno.setText("");
        viewProveedores.jtf_amaterno.setText("");
        viewProveedores.jtf_telefono.setText("");
        viewProveedores.jtf_correo.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_numero_e.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_ciudad.setText("");
        viewProveedores.jtf_codigo_p.setText("");
        viewProveedores.jtf_estado.setText("");
        viewProveedores.jtf_rfc.setText("");
        viewProveedores.jtf_razon_social.setText("");
        editar();
    }
    private void jbtn_guardar_actionPerformed(){
        modelProveedores.setId(viewProveedores.jtf_id.getText());
        modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
        modelProveedores.setApellidop(viewProveedores.jtf_apaterno.getText()); 
        modelProveedores.setApellidom(viewProveedores.jtf_amaterno.getText()); 
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText()); 
        modelProveedores.setCorreo(viewProveedores.jtf_correo.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setNumero(viewProveedores.jtf_numero_e.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setCp(viewProveedores.jtf_codigo_p.getText());
        modelProveedores.setEstado(viewProveedores.jtf_estado.getText());
        modelProveedores.setRfc(viewProveedores.jtf_rfc.getText());
        modelProveedores.setRazon_social(viewProveedores.jtf_razon_social.getText());
        modelProveedores.guardarRegistro();
        cancelarNuevo_actionPerformed();
        initComponents();
    }
    public void cancelarNuevo_actionPerformed(){
        modelProveedores.conectarDB();
        viewProveedores.jbtn_cancelarnuevo.setVisible(false);
        viewProveedores.jbtn_guardar.setVisible(false);
        viewProveedores.jp_navegacion.setVisible(true);
        viewProveedores.jbtn_modificar.setVisible(true);
        viewProveedores.jbtn_borrar.setVisible(true);
        viewProveedores.jbtn_nuevo.setVisible(true);
        noEditar();
        setValues();
        initComponents();
    }
    private void jbtn_modificar_actionPerformed(){
        viewProveedores.jbtn_nuevo.setVisible(false);
        viewProveedores.jbtn_cancelarmodificar.setVisible(true);
        viewProveedores.jp_navegacion.setVisible(false);
        viewProveedores.jbtn_guardarm.setVisible(true);
        viewProveedores.jbtn_borrar.setVisible(false);
        viewProveedores.jbtn_modificar.setVisible(false);
        editar();
    }
    private void jbtn_guardarCambios_actionPerformed(){
        modelProveedores.setId(viewProveedores.jtf_id.getText());
        modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
        modelProveedores.setApellidop(viewProveedores.jtf_apaterno.getText()); 
        modelProveedores.setApellidom(viewProveedores.jtf_amaterno.getText()); 
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText()); 
        modelProveedores.setCorreo(viewProveedores.jtf_correo.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setNumero(viewProveedores.jtf_numero_e.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setCp(viewProveedores.jtf_codigo_p.getText());
        modelProveedores.setEstado(viewProveedores.jtf_estado.getText());
        modelProveedores.setRfc(viewProveedores.jtf_rfc.getText()); 
        modelProveedores.setRazon_social(viewProveedores.jtf_razon_social.getText());
        modelProveedores.guardarCambios();
        modelProveedores.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
    }
    private void jbtn_eliminar_actionPerformed(){
        modelProveedores.setId(viewProveedores.jtf_id.getText());
        modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
        modelProveedores.setApellidop(viewProveedores.jtf_apaterno.getText()); 
        modelProveedores.setApellidom(viewProveedores.jtf_amaterno.getText()); 
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText()); 
        modelProveedores.setCorreo(viewProveedores.jtf_correo.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setNumero(viewProveedores.jtf_numero_e.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setCp(viewProveedores.jtf_codigo_p.getText());
        modelProveedores.setEstado(viewProveedores.jtf_estado.getText());
        modelProveedores.setRfc(viewProveedores.jtf_rfc.getText()); 
        modelProveedores.setRazon_social(viewProveedores.jtf_razon_social.getText());
        modelProveedores.borrarRegistro();
        modelProveedores.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
    }
    private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_cerrar_sesion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ModelLogin modelLogin = new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
                viewLogin.setVisible(true);
                viewProveedores.setVisible(false);
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
                viewProveedores.setVisible(false);
            }
        }
}
