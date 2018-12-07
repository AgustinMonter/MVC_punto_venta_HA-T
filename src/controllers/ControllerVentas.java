
package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import models.ModelVentas;
import views.ViewVentas;

public class ControllerVentas {
     ModelVentas modelVentas;
    ViewVentas viewVentas;
    
   
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewVentas.jb_nuevo) {
               jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_guardar) {
//               jb_guardar_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_modificar) {

            }
           
        }
    };
    
    
    public ControllerVentas(ModelVentas modelVentas, ViewVentas viewVentas) {
        this.modelVentas = modelVentas;
        this.viewVentas = viewVentas;
        
        setActionListener();
        initDB();
        
        modelVentas.llenarComboBox();
        for (int v = 0; v < modelVentas.getEmpleados().size(); v++) {
            viewVentas.jC_id_usuario.addItem((String) modelVentas.getEmpleados().get(v));
        }
        for (int c = 0; c < modelVentas.getClientes().size(); c++) {
            viewVentas.jC_cliente.addItem((String) modelVentas.getClientes().get(c));
        }

        initDB();
        initComponents();
    }
    
    
    private void initDB() {
        modelVentas.conectarDB();
        String id_vta = Integer.toString(modelVentas.getId_venta());
        viewVentas.jT_id_venta.setText(id_vta);

        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date fecha_vta = modelVentas.getFecha();
        String fechaSQL = df.format(fecha_vta);
        viewVentas.jtf_fecha.setText(fechaSQL);
        
        viewVentas.cb_sucursal.setSelectedItem(modelVentas.getNom_sucursal());
        viewVentas.jC_id_usuario.setSelectedItem(modelVentas.getNom_empleado());
        viewVentas.jC_cliente.setSelectedItem(modelVentas.getNom_cliente());
        viewVentas.jtf_totalproductos.setText(Integer.toString(modelVentas.getTotal_productos()));
        
        viewVentas.jtf_subtotal.setText(Float.toString(modelVentas.getSubtotal()));
        viewVentas.jT_iva.setText(Float.toString(modelVentas.getIva()));
        
        viewVentas.jtf_importe_total.setText(Float.toString(modelVentas.getImporte_total()));

        viewVentas.cb_forma_pago.setSelectedItem(modelVentas.getForma_pago());
      
    }
    
    
    public void initComponents() {
        viewVentas.setLocationRelativeTo(null);
        viewVentas.setTitle("Ventas ACME");
        viewVentas.setVisible(true);
    }
     private void setActionListener() {
       
        
        viewVentas.jb_nuevo.addActionListener(actionListener);
        viewVentas.jb_guardar.addActionListener(actionListener);
        viewVentas.jb_modificar.addActionListener(actionListener);
        
     
     
     }
     private void setValues() {
        String id_venta = Integer.toString(modelVentas.getId_venta());
        viewVentas.jT_id_venta.setText(id_venta);
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date fecha_veta = modelVentas.getFecha();
        String fechaSQL = df.format(fecha_veta);
        viewVentas.jtf_fecha.setText(fechaSQL);
        
        viewVentas.cb_sucursal.setSelectedItem(modelVentas.getNom_sucursal());
        viewVentas.jC_id_usuario.setSelectedItem(modelVentas.getNom_empleado());
        viewVentas.jC_cliente.setSelectedItem(modelVentas.getNom_cliente());
        
        viewVentas.jtf_totalproductos.setText(Integer.toString(modelVentas.getTotal_productos()));
        
       
        viewVentas.jtf_subtotal.setText(Float.toString(modelVentas.getSubtotal()));
        viewVentas.jT_iva.setText(Float.toString(modelVentas.getIva()));
       
        viewVentas.jtf_importe_total.setText(Float.toString(modelVentas.getImporte_total()));
        viewVentas.cb_forma_pago.setSelectedItem(modelVentas.getForma_pago());
    
    }

      private void jb_nuevo_actionPerformed() {
        viewVentas.jT_id_venta.setText("0");
        viewVentas.jtf_fecha.setText("");
        viewVentas.cb_sucursal.setSelectedIndex(0);
        viewVentas.jC_id_usuario.setSelectedIndex(0);
        viewVentas.jC_cliente.setSelectedIndex(0);
       
        viewVentas.jtf_subtotal.setText("0.0");
        viewVentas.jT_iva.setText("0.0");
        viewVentas.jtf_importe_total.setText("0.0");
       
        viewVentas.cb_forma_pago.setSelectedIndex(0);
        
        
       
    }
        
      
 /**      private void jb_guardar_actionPerformed() {
        modelVentas.setNom_sucursal((String) viewVentas.cb_sucursal.getSelectedItem());
        modelVentas.setNom_empleado((String) viewVentas.jC_id_usuario.getSelectedItem());
        modelVentas.setNom_cliente((String) viewVentas.jC_cliente.getSelectedItem());
        
        modelVentas.setSubtotal(Float.parseFloat(viewVentas.jtf_subtotal.getText()));
        modelVentas.setIva(Float.parseFloat(viewVentas.jT_iva.getText()));
       
        modelVentas.setImporte_total(Float.parseFloat(viewVentas.jtf_importe_total.getText()));
        
        modelVentas.setForma_pago((String) viewVentas.cb_forma_pago.getSelectedItem());
       
        
        modelVentas.insertarRegistro();
    }
    **/
}

