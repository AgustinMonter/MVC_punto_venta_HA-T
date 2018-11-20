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
        
    }
    
}
