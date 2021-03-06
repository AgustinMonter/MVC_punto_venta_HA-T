/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import views.ViewLogin;
import models.ModelLogin;
import controllers.ControllerLogin;

import views.ViewMenu;
import models.ModelMenu;
import controllers.ControllerMenu;

import views.ViewProveedores;
import models.ModelProveedores;
import controllers.ControllerProveedores;

import views.ViewClientes;
import models.ModelClientes;
import controllers.ControllerClientes;

import views.ViewCrearCuenta;
import models.ModelNuevaCuenta;
import controllers.ControllerNuevaCuenta;
/**
 *
 * @author Edgar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin controllerLogin = new ControllerLogin(modelLogin, viewLogin);
        
        ModelMenu modelMenu = new ModelMenu();
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu controllerMenu = new ControllerMenu(modelMenu, viewMenu);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
        ModelNuevaCuenta modelNuevaCuenta = new ModelNuevaCuenta();
        ViewCrearCuenta viewCrearCuenta = new ViewCrearCuenta();
        ControllerNuevaCuenta controllerNuevaCuenta = new ControllerNuevaCuenta(modelNuevaCuenta, viewCrearCuenta);
    }
    
}
