
package main;

import controllers.ControllerVentas;
import models.ModelVentas;
import views.ViewVentas;


public class MainVentas {
     public static void main(String [] args) {
        
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        
    }
}
