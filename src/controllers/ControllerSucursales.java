/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelSucursales;
import views.ViewSucursales;

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
public class ControllerSucursales {
    public ModelSucursales modelSucursales;
    public ViewSucursales viewSucursales;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursales.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
            } else if (e.getSource() == viewSucursales.jmi_menu) {
                jmi_menu_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_nuevo) {
                jbtn_limpiar_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_cancelarnuevo) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_borrar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_cancelarmodificar) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_guardarm) {
                jbtn_guardarCambios_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewSucursales.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }       
    }
};
    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        initComponents();
        setActionListener();
        initDB();
    }
    private void setActionListener() {
        viewSucursales.jbtn_primero.addActionListener(actionListener);
        viewSucursales.jbtn_anterior.addActionListener(actionListener);
        viewSucursales.jbtn_siguiente.addActionListener(actionListener);
        viewSucursales.jbtn_ultimo.addActionListener(actionListener);
        viewSucursales.jbtn_nuevo.addActionListener(actionListener);
        viewSucursales.jbtn_guardar.addActionListener(actionListener);
        viewSucursales.jbtn_modificar.addActionListener(actionListener);
        viewSucursales.jbtn_borrar.addActionListener(actionListener);
        viewSucursales.jbtn_cancelarmodificar.addActionListener(actionListener);
        viewSucursales.jbtn_cancelarnuevo.addActionListener(actionListener);
        viewSucursales.jbtn_guardarm.addActionListener(actionListener);      
        viewSucursales.jmi_cerrar_sesion.addActionListener(actionListener);      
        viewSucursales.jmi_menu.addActionListener(actionListener);
    }
    private void initDB() {
        modelSucursales.conectarDB();
        viewSucursales.jtf_id.setText(modelSucursales.getId());
        viewSucursales.jtf_estado.setText(modelSucursales.getEstado());
        viewSucursales.jtf_calle.setText(modelSucursales.getCalle());
        viewSucursales.jtf_numero.setText(modelSucursales.getNumero());
        viewSucursales.jtf_colonia.setText(modelSucursales.getColonia());
        viewSucursales.jtf_ciudad.setText(modelSucursales.getCiudad());
        viewSucursales.jtf_cp.setText(modelSucursales.getCp());
        viewSucursales.jtf_telefono.setText(modelSucursales.getTelefono());
    }
    public void noEditar(){
        viewSucursales.jtf_id.setEditable(false);
        viewSucursales.jtf_calle.setEditable(false);
        viewSucursales.jtf_numero.setEditable(false);
        viewSucursales.jtf_colonia.setEditable(false);
        viewSucursales.jtf_ciudad.setEditable(false);
        viewSucursales.jtf_cp.setEditable(false);
        viewSucursales.jtf_estado.setEditable(false);
        viewSucursales.jtf_telefono.setEditable(false);
    }
    public void editar(){
        viewSucursales.jtf_id.setEditable(true);
        viewSucursales.jtf_calle.setEditable(true);
        viewSucursales.jtf_numero.setEditable(true);
        viewSucursales.jtf_colonia.setEditable(true);
        viewSucursales.jtf_ciudad.setEditable(true);
        viewSucursales.jtf_cp.setEditable(true);
        viewSucursales.jtf_estado.setEditable(true);
        viewSucursales.jtf_telefono.setEditable(true);
    }
    public void initComponents() {
        viewSucursales.setLocationRelativeTo(null);
        viewSucursales.setVisible(false);
        viewSucursales.jbtn_guardar.setVisible(false);
        viewSucursales.jbtn_cancelarmodificar.setVisible(false);
        viewSucursales.jbtn_cancelarnuevo.setVisible(false);
        viewSucursales.jbtn_guardarm.setVisible(false);
        noEditar();
    }
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelSucursales.moverPrimerRegistro();
        setValues();
    }
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelSucursales.moverAnteriorRegistro();
        setValues();
    }
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelSucursales.moverUltimoRegistro();
        setValues();
    }
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelSucursales.moverSiguienteRegistro();
        setValues();
    }
    private void setValues() {
        viewSucursales.jtf_id.setText(modelSucursales.getId());
        viewSucursales.jtf_telefono.setText((modelSucursales.getTelefono()));
        viewSucursales.jtf_calle.setText(modelSucursales.getCalle());
        viewSucursales.jtf_numero.setText(modelSucursales.getNumero());
        viewSucursales.jtf_colonia.setText(modelSucursales.getColonia());
        viewSucursales.jtf_ciudad.setText(modelSucursales.getCiudad());
        viewSucursales.jtf_cp.setText(modelSucursales.getCp());
        viewSucursales.jtf_estado.setText(modelSucursales.getEstado());
    }
    public void jbtn_limpiar_actionPerformed(){
        viewSucursales.jbtn_guardar.setVisible(true);
        viewSucursales.jp_navegacion.setVisible(false);
        viewSucursales.jbtn_modificar.setVisible(false);
        viewSucursales.jbtn_nuevo.setVisible(false);
        viewSucursales.jbtn_borrar.setVisible(false);
        viewSucursales.jbtn_cancelarnuevo.setVisible(true);
        viewSucursales.jtf_id.setText("");
        viewSucursales.jtf_telefono.setText("");
        viewSucursales.jtf_calle.setText("");
        viewSucursales.jtf_numero.setText("");
        viewSucursales.jtf_colonia.setText("");
        viewSucursales.jtf_ciudad.setText("");
        viewSucursales.jtf_cp.setText("");
        viewSucursales.jtf_estado.setText("");
        editar();
    }
    private void jbtn_guardar_actionPerformed(){
        modelSucursales.setId(viewSucursales.jtf_id.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_telefono.getText()); 
        modelSucursales.setCalle(viewSucursales.jtf_calle.getText());
        modelSucursales.setNumero(viewSucursales.jtf_numero.getText());
        modelSucursales.setColonia(viewSucursales.jtf_colonia.getText());
        modelSucursales.setCiudad(viewSucursales.jtf_ciudad.getText());
        modelSucursales.setCp(viewSucursales.jtf_cp.getText());
        modelSucursales.setEstado(viewSucursales.jtf_estado.getText());
        modelSucursales.guardarRegistro();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewSucursales.setVisible(true);
    }
    public void cancelarNuevo_actionPerformed(){
        modelSucursales.conectarDB();
        viewSucursales.jbtn_cancelarnuevo.setVisible(false);
        viewSucursales.jbtn_guardar.setVisible(false);
        viewSucursales.jp_navegacion.setVisible(true);
        viewSucursales.jbtn_modificar.setVisible(true);
        viewSucursales.jbtn_borrar.setVisible(true);
        viewSucursales.jbtn_nuevo.setVisible(true);
        noEditar();
        setValues();
        initComponents();
        viewSucursales.setVisible(true);
    }
    private void jbtn_modificar_actionPerformed(){
        viewSucursales.jbtn_nuevo.setVisible(false);
        viewSucursales.jbtn_cancelarmodificar.setVisible(true);
        viewSucursales.jp_navegacion.setVisible(false);
        viewSucursales.jbtn_guardarm.setVisible(true);
        viewSucursales.jbtn_borrar.setVisible(false);
        viewSucursales.jbtn_modificar.setVisible(false);
        editar();
    }
    private void jbtn_guardarCambios_actionPerformed(){
        modelSucursales.setId(viewSucursales.jtf_id.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_telefono.getText()); 
        modelSucursales.setCalle(viewSucursales.jtf_calle.getText());
        modelSucursales.setNumero(viewSucursales.jtf_numero.getText());
        modelSucursales.setColonia(viewSucursales.jtf_colonia.getText());
        modelSucursales.setCiudad(viewSucursales.jtf_ciudad.getText());
        modelSucursales.setCp(viewSucursales.jtf_cp.getText());
        modelSucursales.setEstado(viewSucursales.jtf_estado.getText());
        modelSucursales.guardarCambios();
        modelSucursales.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewSucursales.setVisible(true);
    }
    private void jbtn_eliminar_actionPerformed(){
        modelSucursales.setId(viewSucursales.jtf_id.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_telefono.getText()); 
        modelSucursales.setCalle(viewSucursales.jtf_calle.getText());
        modelSucursales.setNumero(viewSucursales.jtf_numero.getText());
        modelSucursales.setColonia(viewSucursales.jtf_colonia.getText());
        modelSucursales.setCiudad(viewSucursales.jtf_ciudad.getText());
        modelSucursales.setCp(viewSucursales.jtf_cp.getText());
        modelSucursales.setEstado(viewSucursales.jtf_estado.getText());
        modelSucursales.borrarRegistro();
        modelSucursales.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewSucursales.setVisible(true);
    }
    private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_cerrar_sesion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ModelLogin modelLogin = new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
                viewLogin.setVisible(true);
                viewSucursales.setVisible(false);
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
                viewSucursales.setVisible(false);
            }
        }
}

