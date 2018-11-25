/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import models.ModelMenu;
import views.ViewMenu;


import views.ViewLogin;
import models.ModelLogin;
import controllers.ControllerLogin;

import views.ViewProveedores;
import models.ModelProveedores;
import controllers.ControllerProveedores;
/**
 *
 * @author Edgar
 */
public class ControllerMenu {
    public ModelMenu modelMenu;
    public ViewMenu viewMenu;
    
    
    public ControllerMenu(ModelMenu modelMenu, ViewMenu viewMenu) {
        this.modelMenu = modelMenu;
        this.viewMenu = viewMenu;
        setActionListener();
        
        initComponents();
    }
    
 
    public void initComponents() {
        viewMenu.setLocationRelativeTo(null);
        System.out.println("menu");
        viewMenu.setVisible(false);
        }
    
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMenu.jbtn_productos) {
                jbtn_productos_actionPerformed();
            } else if (e.getSource() == viewMenu.jbtn_proveedores) {
                jbtn_proveedores_actionPerformed();
            } else if (e.getSource() == viewMenu.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
        }
        }
        
    };
    
    private void setActionListener() {
        viewMenu.jbtn_productos.addActionListener(actionListener);
        viewMenu.jmi_cerrar_sesion.addActionListener(actionListener);
        viewMenu.jbtn_proveedores.addActionListener(actionListener);
    }
        
        private void jbtn_productos_actionPerformed() {
        System.out.println("Action del boton jbtn_iniciar_secion");
        //modelMenu.iniciarSecion();
        // setValues();
        }
        private void jbtn_proveedores_actionPerformed() {
        System.out.println("Action del boton jbtn_proveedores");
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        viewProveedores.setVisible(true);
        viewMenu.setVisible(false); 
        }
        private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_iniciar_secion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ModelLogin modelLogin = new ModelLogin();
                ViewLogin viewLogin = new ViewLogin();
                ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
                viewLogin.setVisible(true);
                viewMenu.setVisible(false);
            }
        }
}
