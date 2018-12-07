/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import views.ViewProducto;
import models.ModelProducto;
import controllers.ControllerProducto;



/**
 *
 * @author HP
 */
public class Mainproducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ModelProducto modelProducto = new ModelProducto();
        ViewProducto viewProducto = new ViewProducto();
        ControllerProducto controllerProducto = new ControllerProducto(modelProducto, viewProducto);
        
       
    }
    
}
