/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewDetalleCompra;
import models.ModelDetalleCompra;
import controllers.ControllerDetalleCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelCompras;
import views.ViewCompras;
import views.ViewDetalleCompra;
/**
 *
 * @author Jose Felix
 */
public class ControllerCompras {
    ModelCompras modelCompras;
    ViewCompras viewCompras;
    ViewDetalleCompra viewDetalleCompra;
    ModelDetalleCompra modelDetalleCompra;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCompras.jbtn_primer_registro) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_registro_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_siguiente_registro) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_ultimo_registro) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_nueva_compra) {
                jbtn_nueva_compra_actionPerformed();
            }else if (e.getSource() == viewCompras.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_actualizar) {
                jbtn_actualizar_actionPerformed();
            } else if (e.getSource() == viewCompras.jbtn_detalle_compra) {
                jbtn_detalle_compra_actionPerformed();
            } /*else if (e.getSource() == viewCompras.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            }*/ else if (e.getSource() == viewCompras.jbtn_cancelar) {
                jbtn_cancelar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelCompras y ViewCompras
     *
     * @param modelAgenda objeto de tipo ModelCompras
     * @param viewAgenda objeto de tipo ViewCompras
     */
    public ControllerCompras(ModelCompras modelCompras, ViewCompras viewCompras) {
        this.modelCompras = modelCompras;
        this.viewCompras = viewCompras;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y mustra en la vista los registros ViewCompras.
     */
    public void initDB(){
        modelCompras.conectarDB();
        viewCompras.jtf_id_compra.setText(modelCompras.getId_compra());
        viewCompras.jtf_id_proveedor.setText(modelCompras.getId_proveedor());
        viewCompras.jtf_subtotal.setText(modelCompras.getSubtotal());
        viewCompras.jtf_fecha_compra.setText(modelCompras.getFecha_compra());
        viewCompras.jtf_iva.setText(modelCompras.getIva());
        viewCompras.jtf_importe_total.setText(modelCompras.getImporte_total());
        viewCompras.jtf_id_usuario.setText(modelCompras.getId_usuario());
    }
    /**
     * Metodo para inicializar la ViewCompras
     */
    public void initComponents() {
        viewCompras.jbtn_cancelar.setVisible(false);
        viewCompras.jbtn_actualizar.setVisible(false);
        viewCompras.jbtn_guardar.setVisible(false);
        viewCompras.setLocationRelativeTo(null);
        viewCompras.setTitle("Compras");
        viewCompras.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewCompras.jbtn_primer_registro.addActionListener(actionListener);
        viewCompras.jbtn_registro_anterior.addActionListener(actionListener);
        viewCompras.jbtn_siguiente_registro.addActionListener(actionListener);
        viewCompras.jbtn_ultimo_registro.addActionListener(actionListener);
        viewCompras.jbtn_nueva_compra.addActionListener(actionListener);
        viewCompras.jbtn_guardar.addActionListener(actionListener);
        viewCompras.jbtn_modificar.addActionListener(actionListener);
        viewCompras.jbtn_actualizar.addActionListener(actionListener);
        viewCompras.jbtn_cancelar.addActionListener(actionListener);
        viewCompras.jbtn_detalle_compra.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla compras
     */
    private void jbtn_primero_actionPerformed() {
        modelCompras.moverPrimerRegistro();
        viewCompras.jtf_id_compra.setText(modelCompras.getId_compra());
        viewCompras.jtf_id_proveedor.setText(modelCompras.getId_proveedor());
        viewCompras.jtf_subtotal.setText(modelCompras.getSubtotal());
        viewCompras.jtf_fecha_compra.setText(modelCompras.getFecha_compra());
        viewCompras.jtf_iva.setText(modelCompras.getIva());
        viewCompras.jtf_importe_total.setText(modelCompras.getImporte_total());
        viewCompras.jtf_id_usuario.setText(modelCompras.getId_usuario());
        
        
    }

    /**
     * Método para ver el registro anterior de la tabla compras
     */
    private void jbtn_anterior_actionPerformed() {
        modelCompras.moverAnteriorRegistro();
        viewCompras.jtf_id_compra.setText(modelCompras.getId_compra());
        viewCompras.jtf_id_proveedor.setText(modelCompras.getId_proveedor());
        viewCompras.jtf_subtotal.setText(modelCompras.getSubtotal());
        viewCompras.jtf_fecha_compra.setText(modelCompras.getFecha_compra());
        viewCompras.jtf_iva.setText(modelCompras.getIva());
        viewCompras.jtf_importe_total.setText(modelCompras.getImporte_total());
        viewCompras.jtf_id_usuario.setText(modelCompras.getId_usuario());
        
    }

    /**
     * Método para ver el último registro de la tabla compras
     */
    private void jbtn_ultimo_actionPerformed() {
        modelCompras.moverUltimoRegistro();
        viewCompras.jtf_id_compra.setText(modelCompras.getId_compra());
        viewCompras.jtf_id_proveedor.setText(modelCompras.getId_proveedor());
        viewCompras.jtf_subtotal.setText(modelCompras.getSubtotal());
        viewCompras.jtf_fecha_compra.setText(modelCompras.getFecha_compra());
        viewCompras.jtf_iva.setText(modelCompras.getIva());
        viewCompras.jtf_importe_total.setText(modelCompras.getImporte_total());
        viewCompras.jtf_id_usuario.setText(modelCompras.getId_usuario());
        
    }

    /**
     * Método para ver el siguiente registro de la tabla compras
     */
    private void jbtn_siguiente_actionPerformed() {
        modelCompras.moverSiguienteRegistro();
        viewCompras.jtf_id_compra.setText(modelCompras.getId_compra());
        viewCompras.jtf_id_proveedor.setText(modelCompras.getId_proveedor());
        viewCompras.jtf_subtotal.setText(modelCompras.getSubtotal());
        viewCompras.jtf_fecha_compra.setText(modelCompras.getFecha_compra());
        viewCompras.jtf_iva.setText(modelCompras.getIva());
        viewCompras.jtf_importe_total.setText(modelCompras.getImporte_total());
        viewCompras.jtf_id_usuario.setText(modelCompras.getId_usuario());
        
    }
    /**
     * Permite limpiar los jtf de la vista e hacerlos editables
     * oculta los jbtn nuevo, modificar, y los de moverse entre los registros
     */
    private void jbtn_nueva_compra_actionPerformed() {
        viewCompras.jtf_id_compra.setVisible(false);
        viewCompras.jl_id_compra.setVisible(false);
        viewCompras.jtf_id_proveedor.setEditable(true);
        viewCompras.jtf_id_proveedor.setText("");
        viewCompras.jtf_subtotal.setEditable(true);
        viewCompras.jtf_subtotal.setText("");
        viewCompras.jtf_importe_total.setVisible(false);
        viewCompras.jl_importe_total.setVisible(false);
        viewCompras.jtf_fecha_compra.setVisible(false);
        viewCompras.jl_fecha_compra.setVisible(false);
        viewCompras.jtf_importe_total.setEditable(true);
        viewCompras.jtf_importe_total.setText("");
        viewCompras.jtf_id_usuario.setEditable(true);
        viewCompras.jtf_id_usuario.setText("");
        viewCompras.jbtn_nueva_compra.setVisible(false);
        //viewCompras.jbtn_eliminar.setVisible(false);
        viewCompras.jbtn_modificar.setVisible(false);
        viewCompras.jbtn_actualizar.setVisible(false);
        viewCompras.jbtn_primer_registro.setVisible(false);
        viewCompras.jbtn_siguiente_registro.setVisible(false);
        viewCompras.jbtn_registro_anterior.setVisible(false);
        viewCompras.jbtn_ultimo_registro.setVisible(false);
        //viewCompras.jbtn_insertar.setVisible(true);
        viewCompras.jbtn_guardar.setVisible(true);
        viewCompras.jbtn_cancelar.setVisible(true);
        viewCompras.jbtn_detalle_compra.setVisible(false);
        viewCompras.jbtn_salir.setVisible(false);
        viewCompras.jl_iva.setVisible(false);
        viewCompras.jtf_iva.setVisible(false);
    }
    private void jbtn_guardar_actionPerformed(){
        modelCompras.setId_proveedor(viewCompras.jtf_id_proveedor.getText()); 
        modelCompras.setSubtotal(viewCompras.jtf_subtotal.getText()); 
        modelCompras.setId_usuario(viewCompras.jtf_id_usuario.getText()); 
        modelCompras.guardar();
        viewCompras.jtf_id_compra.setVisible(true);
        viewCompras.jl_id_compra.setVisible(true);
        viewCompras.jtf_id_proveedor.setEditable(false);
        viewCompras.jtf_subtotal.setEditable(false);
        viewCompras.jtf_fecha_compra.setVisible(true);
        viewCompras.jl_fecha_compra.setVisible(true);
        viewCompras.jtf_iva.setEditable(false);
        viewCompras.jtf_importe_total.setEditable(false);
        viewCompras.jtf_id_usuario.setEditable(false);
        viewCompras.jtf_importe_total.setEditable(false);
        viewCompras.jl_importe_total.setVisible(true);
        viewCompras.jtf_importe_total.setVisible(true);
        viewCompras.jbtn_nueva_compra.setVisible(true);
        //viewCompras.jbtn_eliminar.setVisible(false);
        viewCompras.jbtn_modificar.setVisible(true);
        viewCompras.jbtn_actualizar.setVisible(false);
        viewCompras.jbtn_primer_registro.setVisible(true);
        viewCompras.jbtn_siguiente_registro.setVisible(true);
        viewCompras.jbtn_registro_anterior.setVisible(true);
        viewCompras.jbtn_ultimo_registro.setVisible(true);
        //viewCompras.jbtn_insertar.setVisible(true);
        viewCompras.jbtn_cancelar.setVisible(false);
        viewCompras.jbtn_guardar.setVisible(false);
        viewCompras.jbtn_detalle_compra.setVisible(true);
        viewCompras.jbtn_salir.setVisible(true);
        viewCompras.jl_iva.setVisible(true);
        viewCompras.jtf_iva.setVisible(true);
        initDB();
        
        
        
        
    }
    private void jbtn_detalle_compra_actionPerformed(){
        ModelDetalleCompra modelDetalleCompra = new ModelDetalleCompra();
        ViewDetalleCompra viewDetalleCompra = new ViewDetalleCompra();
        ControllerDetalleCompra controllerDetalleCompra = new ControllerDetalleCompra(modelDetalleCompra, viewDetalleCompra);
        viewCompras.setVisible(false);
    }
            
    
    private void jbtn_modificar_actionPerformed() {
        viewCompras.jbtn_modificar.setVisible(false);
        viewCompras.jbtn_actualizar.setVisible(true);
        viewCompras.jbtn_primer_registro.setVisible(false);
        viewCompras.jbtn_siguiente_registro.setVisible(false);
        viewCompras.jbtn_registro_anterior.setVisible(false);
        viewCompras.jbtn_ultimo_registro.setVisible(false);
        viewCompras.jtf_id_proveedor.setEditable(true);
        viewCompras.jtf_subtotal.setEditable(true);
        viewCompras.jtf_iva.setEditable(true);
        viewCompras.jtf_id_usuario.setEditable(true);
        viewCompras.jbtn_nueva_compra.setVisible(false);
        viewCompras.jbtn_cancelar.setVisible(true);
        viewCompras.jl_id_compra.setVisible(false);
        viewCompras.jtf_id_compra.setVisible(false);
        viewCompras.jl_fecha_compra.setVisible(false);
        viewCompras.jtf_fecha_compra.setVisible(false);
        viewCompras.jl_importe_total.setVisible(false);
        viewCompras.jtf_importe_total.setVisible(false);
        viewCompras.jbtn_salir.setVisible(false);
        viewCompras.jbtn_detalle_compra.setVisible(false);
        viewCompras.jl_iva.setVisible(false);
        viewCompras.jtf_iva.setVisible(false);
    }
    
    private void jbtn_cancelar_actionPerformed() {
        viewCompras.jtf_id_compra.setVisible(true);
        viewCompras.jl_id_compra.setVisible(true);
        viewCompras.jtf_id_proveedor.setEditable(false);
        viewCompras.jtf_subtotal.setEditable(false);
        viewCompras.jtf_fecha_compra.setVisible(true);
        viewCompras.jl_fecha_compra.setVisible(true);
        viewCompras.jtf_iva.setEditable(false);
        viewCompras.jtf_importe_total.setEditable(false);
        viewCompras.jtf_id_usuario.setEditable(false);
        viewCompras.jtf_importe_total.setEditable(false);
        viewCompras.jl_importe_total.setVisible(true);
        viewCompras.jtf_importe_total.setVisible(true);
        viewCompras.jbtn_nueva_compra.setVisible(true);
        viewCompras.jbtn_modificar.setVisible(true);
        viewCompras.jbtn_actualizar.setVisible(false);
        viewCompras.jbtn_primer_registro.setVisible(true);
        viewCompras.jbtn_siguiente_registro.setVisible(true);
        viewCompras.jbtn_registro_anterior.setVisible(true);
        viewCompras.jbtn_ultimo_registro.setVisible(true);
        viewCompras.jbtn_cancelar.setVisible(false);
        viewCompras.jbtn_guardar.setVisible(false);
        viewCompras.jbtn_detalle_compra.setVisible(true);
        viewCompras.jbtn_salir.setVisible(true);
        viewCompras.jl_iva.setVisible(true);
        viewCompras.jtf_iva.setVisible(true);
        initDB();
    }
    private void jbtn_actualizar_actionPerformed(){
        modelCompras.setId_compra(viewCompras.jtf_id_compra.getText());
        modelCompras.setId_proveedor(viewCompras.jtf_id_proveedor.getText()); 
        modelCompras.setSubtotal(viewCompras.jtf_subtotal.getText()); 
        modelCompras.setId_usuario(viewCompras.jtf_id_usuario.getText()); 
        modelCompras.setIva(viewCompras.jtf_iva.getText()); 
        modelCompras.actualizar();
        jbtn_cancelar_actionPerformed();
    }
    
}
