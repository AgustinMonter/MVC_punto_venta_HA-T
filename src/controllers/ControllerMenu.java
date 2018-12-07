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

import views.ViewClientes;
import models.ModelClientes;
import controllers.ControllerClientes;

import views.ViewCrearCuenta;
import models.ModelNuevaCuenta;
import controllers.ControllerNuevaCuenta;

import views.ViewSucursales;
import models.ModelSucursales;
import controllers.ControllerSucursales;

import views.ViewCompras;
import models.ModelCompras;
import controllers.ControllerCompras;

import views.ViewProducto;
import models.ModelProducto;
import controllers.ControllerProducto;

import views.ViewVentas;
import models.ModelVentas;
import controllers.ControllerVentas;

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
            } else if (e.getSource() == viewMenu.jbtn_clientes) {
                jbtn_clientes_actionPerformed();
            } else if (e.getSource() == viewMenu.jmi_cerrar_sesion) {
                jmi_cerrar_sesion_actionPerformed();
            } else if (e.getSource() == viewMenu.jmi_crear_cuenta) {
                jmi_crear_usuario_actionPerformed();
          
            } else if (e.getSource() == viewMenu.jbtn_sucursales) {
                jbtn_sucursales_actionPerformed();
            } else if (e.getSource() == viewMenu.jbtn_compras) {
                jbtn_compras_actionPerformed();
            } else if (e.getSource() == viewMenu.jbtn_ventas) {
                jbtn_ventas_actionPerformed();
            }
        }
        
    };
    
    private void setActionListener() {
        viewMenu.jbtn_productos.addActionListener(actionListener);
        viewMenu.jmi_cerrar_sesion.addActionListener(actionListener);
        viewMenu.jbtn_proveedores.addActionListener(actionListener);
        viewMenu.jbtn_clientes.addActionListener(actionListener);
        viewMenu.jmi_crear_cuenta.addActionListener(actionListener);
        viewMenu.jbtn_ventas.addActionListener(actionListener);
        viewMenu.jbtn_sucursales.addActionListener(actionListener);
        viewMenu.jbtn_compras.addActionListener(actionListener);
       
    }
        
        private void jbtn_productos_actionPerformed() {
        System.out.println("Action del boton jbtn_iniciar_secion");
        ModelProducto modelProducto = new ModelProducto();
        ViewProducto viewProducto = new ViewProducto();
        ControllerProducto controllerProducto = new ControllerProducto(modelProducto, viewProducto);
        viewProducto.setVisible(true);
        viewMenu.setVisible(false); 
        }
        private void jbtn_proveedores_actionPerformed() {
        System.out.println("Action del boton jbtn_proveedores");
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        viewProveedores.setVisible(true);
        viewMenu.setVisible(false); 
        }
        private void jbtn_clientes_actionPerformed() {
        System.out.println("Action del boton jbtn_clientes");
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        viewClientes.setVisible(true);
        viewMenu.setVisible(false); 
        }
        private void jbtn_sucursales_actionPerformed() {
        System.out.println("Action del boton jbtn_clientes");
        ModelSucursales modelSucursales = new ModelSucursales();
        ViewSucursales viewSucursales = new ViewSucursales();
        ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        viewSucursales.setVisible(true);
        viewMenu.setVisible(false); 
        }
        
        private void jbtn_compras_actionPerformed() {
        System.out.println("Action del boton jbtn_clientes");
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(modelCompras, viewCompras);
        viewCompras.setVisible(true);
        viewMenu.setVisible(false); 
        }
        
        
        private void jmi_crear_usuario_actionPerformed() {
        System.out.println("Action del boton jmi_crear usuario");
        ModelNuevaCuenta modelNuevaCuenta = new ModelNuevaCuenta();
        ViewCrearCuenta viewCrearCuenta = new ViewCrearCuenta();
        ControllerNuevaCuenta controllerNuevaCuenta = new ControllerNuevaCuenta(modelNuevaCuenta, viewCrearCuenta);
        viewCrearCuenta.setVisible(true);
        viewMenu.setVisible(false); 
        }
        private void jbtn_ventas_actionPerformed() {
        System.out.println("Action del boton jbtn_clientes");
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        viewVentas.setVisible(true);
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
