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
import views.ViewLogin;
import views.ViewMenu;
import views.ViewProveedores;
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
        viewMenu.setVisible(true);
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
        ViewProveedores proveedores = new ViewProveedores();
        ViewMenu menu = new ViewMenu();
        proveedores.setVisible(true);
        menu.setVisible(false);
        }
        private void jmi_cerrar_sesion_actionPerformed() {
        System.out.println("Action del boton jbtn_iniciar_secion");
        int resp=JOptionPane.showConfirmDialog(null,"Desea Cerrar sesión?");
            if (JOptionPane.OK_OPTION == resp){
                ViewLogin login=new ViewLogin();
                ViewMenu menu=new ViewMenu();
                login.setVisible(true);
                menu.setVisible(false);
            }
        }
}
