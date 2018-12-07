/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewCompras;
import models.ModelCompras;
import controllers.ControllerCompras;
import views.ViewDescuentoCompra;
import models.ModelDescuentoCompra;
import controllers.ControllerDescuentoCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelDetalleCompra;
import views.ViewDetalleCompra;
/**
 *
 * @author Jose Felix
 */
public class ControllerDetalleCompra {
    ModelDetalleCompra modelDetalleCompra;
    ViewDetalleCompra viewDetalleCompra;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewDetalleCompra.jbtn_primer_registro) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_registro_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_siguiente_registro) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_ultimo_registro) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_nuevo_producto) {
                jbtn_nuevo_producto_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_atras) {
                jbtn_atras_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_descuento) {
                jbtn_descuento_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_cancelar) {
                jbtn_cancelar_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewDetalleCompra.jbtn_actualizar) {
                jbtn_actualizar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelDetalleCompra
     * @param viewAgenda objeto de tipo ViewDetalleCompra
     */
    public ControllerDetalleCompra(ModelDetalleCompra modelDetalleCompra, ViewDetalleCompra viewDetalleCompra) {
        this.modelDetalleCompra = modelDetalleCompra;
        this.viewDetalleCompra = viewDetalleCompra;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muwestra los registros de la tabla DetalleCompra
     */
    public void initDB(){
        modelDetalleCompra.conectarDB();
        viewDetalleCompra.jtf_id_detalle_compra.setText(modelDetalleCompra.getId_detalle_compra());
        viewDetalleCompra.jtf_id_compra.setText(modelDetalleCompra.getId_compra());
        viewDetalleCompra.jtf_id_producto.setText(modelDetalleCompra.getId_producto());
        viewDetalleCompra.jtf_cantidad.setText(modelDetalleCompra.getCantidad());
        viewDetalleCompra.jtf_precio_compra.setText(modelDetalleCompra.getPrecio_compra());
        viewDetalleCompra.jtf_fecha_pedido.setText(modelDetalleCompra.getFecha_pedido());
        viewDetalleCompra.jtf_fecha_entrega.setText(modelDetalleCompra.getFecha_entrega());
        viewDetalleCompra.jtf_total_producto.setText(modelDetalleCompra.getTotal_producto());
    }
    /**
     * Metodo para inicializar la ViewDetalleCompra
     */
    public void initComponents() {
        viewDetalleCompra.jbtn_cancelar.setVisible(false);
        viewDetalleCompra.jbtn_actualizar.setVisible(false);
        viewDetalleCompra.jbtn_guardar.setVisible(false);
        viewDetalleCompra.setLocationRelativeTo(null);
        viewDetalleCompra.setTitle("Detalle compra");
        viewDetalleCompra.setVisible(true);
        
    }


    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewDetalleCompra.jbtn_primer_registro.addActionListener(actionListener);
        viewDetalleCompra.jbtn_registro_anterior.addActionListener(actionListener);
        viewDetalleCompra.jbtn_siguiente_registro.addActionListener(actionListener);
        viewDetalleCompra.jbtn_ultimo_registro.addActionListener(actionListener);
        viewDetalleCompra.jbtn_guardar.addActionListener(actionListener);
        viewDetalleCompra.jbtn_nuevo_producto.addActionListener(actionListener);
        viewDetalleCompra.jbtn_atras.addActionListener(actionListener);
        viewDetalleCompra.jbtn_descuento.addActionListener(actionListener);
        viewDetalleCompra.jbtn_cancelar.addActionListener(actionListener);
        viewDetalleCompra.jbtn_modificar.addActionListener(actionListener);
        viewDetalleCompra.jbtn_actualizar.addActionListener(actionListener);
        //viewDetalleCompra.jbtn_guardar.addActionListener(actionListener);
    }
    
    private void jbtn_descuento_actionPerformed(){
        ModelDescuentoCompra modelDescuentoCompra = new ModelDescuentoCompra();
        ViewDescuentoCompra viewDescuentoCompra = new ViewDescuentoCompra();
        ControllerDescuentoCompra controllerDescuentoCompra = new ControllerDescuentoCompra(modelDescuentoCompra, viewDescuentoCompra);
        viewDetalleCompra.setVisible(false);
    }

    /**
     * Método para ver el primer registro de la tabla detalle compra
     */
    private void jbtn_primero_actionPerformed() {
        modelDetalleCompra.moverPrimerRegistro();
        viewDetalleCompra.jtf_id_detalle_compra.setText(modelDetalleCompra.getId_detalle_compra());
        viewDetalleCompra.jtf_id_compra.setText(modelDetalleCompra.getId_compra());
        viewDetalleCompra.jtf_id_producto.setText(modelDetalleCompra.getId_producto());
        viewDetalleCompra.jtf_cantidad.setText(modelDetalleCompra.getCantidad());
        viewDetalleCompra.jtf_precio_compra.setText(modelDetalleCompra.getPrecio_compra());
        viewDetalleCompra.jtf_fecha_pedido.setText(modelDetalleCompra.getFecha_pedido());
        viewDetalleCompra.jtf_fecha_entrega.setText(modelDetalleCompra.getFecha_entrega());
        viewDetalleCompra.jtf_total_producto.setText(modelDetalleCompra.getTotal_producto());
    }

    /**
     * Método para ver el registro anterior de la tabla detalle compra
     */
    private void jbtn_anterior_actionPerformed() {
        modelDetalleCompra.moverAnteriorRegistro();
        viewDetalleCompra.jtf_id_detalle_compra.setText(modelDetalleCompra.getId_detalle_compra());
        viewDetalleCompra.jtf_id_compra.setText(modelDetalleCompra.getId_compra());
        viewDetalleCompra.jtf_id_producto.setText(modelDetalleCompra.getId_producto());
        viewDetalleCompra.jtf_cantidad.setText(modelDetalleCompra.getCantidad());
        viewDetalleCompra.jtf_precio_compra.setText(modelDetalleCompra.getPrecio_compra());
        viewDetalleCompra.jtf_fecha_pedido.setText(modelDetalleCompra.getFecha_pedido());
        viewDetalleCompra.jtf_fecha_entrega.setText(modelDetalleCompra.getFecha_entrega());
        viewDetalleCompra.jtf_total_producto.setText(modelDetalleCompra.getTotal_producto());
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla detalle compra
     */
    private void jbtn_ultimo_actionPerformed() {
        modelDetalleCompra.moverUltimoRegistro();
        viewDetalleCompra.jtf_id_detalle_compra.setText(modelDetalleCompra.getId_detalle_compra());
        viewDetalleCompra.jtf_id_compra.setText(modelDetalleCompra.getId_compra());
        viewDetalleCompra.jtf_id_producto.setText(modelDetalleCompra.getId_producto());
        viewDetalleCompra.jtf_cantidad.setText(modelDetalleCompra.getCantidad());
        viewDetalleCompra.jtf_precio_compra.setText(modelDetalleCompra.getPrecio_compra());
        viewDetalleCompra.jtf_fecha_pedido.setText(modelDetalleCompra.getFecha_pedido());
        viewDetalleCompra.jtf_fecha_entrega.setText(modelDetalleCompra.getFecha_entrega());
        viewDetalleCompra.jtf_total_producto.setText(modelDetalleCompra.getTotal_producto());
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla detalle compra
     */
    private void jbtn_siguiente_actionPerformed() {
        modelDetalleCompra.moverSiguienteRegistro();
        viewDetalleCompra.jtf_id_detalle_compra.setText(modelDetalleCompra.getId_detalle_compra());
        viewDetalleCompra.jtf_id_compra.setText(modelDetalleCompra.getId_compra());
        viewDetalleCompra.jtf_id_producto.setText(modelDetalleCompra.getId_producto());
        viewDetalleCompra.jtf_cantidad.setText(modelDetalleCompra.getCantidad());
        viewDetalleCompra.jtf_precio_compra.setText(modelDetalleCompra.getPrecio_compra());
        viewDetalleCompra.jtf_fecha_pedido.setText(modelDetalleCompra.getFecha_pedido());
        viewDetalleCompra.jtf_fecha_entrega.setText(modelDetalleCompra.getFecha_entrega());
        viewDetalleCompra.jtf_total_producto.setText(modelDetalleCompra.getTotal_producto());
    }
   /**
    * Metodo que permite hacer editable los jtf de la vista y borra el texto
    */ 
    private void jbtn_nuevo_producto_actionPerformed(){
        viewDetalleCompra.jtf_id_compra.setEditable(true);
        viewDetalleCompra.jtf_id_compra.setText("");
        viewDetalleCompra.jtf_id_producto.setEditable(true);
        viewDetalleCompra.jtf_id_producto.setText("");
        viewDetalleCompra.jtf_cantidad.setEditable(true);
        viewDetalleCompra.jtf_cantidad.setText("");
        viewDetalleCompra.jtf_precio_compra.setEditable(true);
        viewDetalleCompra.jtf_precio_compra.setText("");
        viewDetalleCompra.jtf_fecha_pedido.setEditable(true);
        viewDetalleCompra.jtf_fecha_pedido.setText("");
        viewDetalleCompra.jtf_fecha_entrega.setEditable(true);
        viewDetalleCompra.jtf_fecha_entrega.setText("");
        viewDetalleCompra.jtf_id_detalle_compra.setVisible(false);
        viewDetalleCompra.jl_id_detalle_compra.setVisible(false);
        viewDetalleCompra.jtf_total_producto.setVisible(false);
        viewDetalleCompra.jl_total_producto.setVisible(false);
        viewDetalleCompra.jbtn_cancelar.setVisible(true);
        viewDetalleCompra.jbtn_nuevo_producto.setVisible(false);
        viewDetalleCompra.jbtn_guardar.setVisible(true);
        viewDetalleCompra.jbtn_descuento.setVisible(false);
        viewDetalleCompra.jbtn_modificar.setVisible(false);
        viewDetalleCompra.jbtn_atras.setVisible(false);
        viewDetalleCompra.jbtn_primer_registro.setVisible(false);
        viewDetalleCompra.jbtn_siguiente_registro.setVisible(false);
        viewDetalleCompra.jbtn_registro_anterior.setVisible(false);
        viewDetalleCompra.jbtn_ultimo_registro.setVisible(false);
        
    }
    /**
     * Metodo que permite obtener el texto de los jtf y guardarlo en las variables del modelo ademas de invocar el metodo de guardar que esta en el modelo 
     */
    private void jbtn_guardar_actionPerformed(){
        modelDetalleCompra.setId_compra(viewDetalleCompra.jtf_id_compra.getText()); 
        modelDetalleCompra.setId_producto(viewDetalleCompra.jtf_id_producto.getText()); 
        modelDetalleCompra.setCantidad(viewDetalleCompra.jtf_cantidad.getText()); 
        modelDetalleCompra.setPrecio_compra(viewDetalleCompra.jtf_precio_compra.getText()); 
        modelDetalleCompra.setFecha_pedido(viewDetalleCompra.jtf_fecha_pedido.getText()); 
        modelDetalleCompra.setFecha_entrega(viewDetalleCompra.jtf_fecha_entrega.getText()); 
        modelDetalleCompra.guardar();
        modelDetalleCompra.actualizarProductos();
        viewDetalleCompra.jtf_id_compra.setEditable(false);
        viewDetalleCompra.jtf_id_producto.setEditable(false);
        viewDetalleCompra.jtf_cantidad.setEditable(false);
        viewDetalleCompra.jtf_precio_compra.setEditable(false);
        viewDetalleCompra.jtf_fecha_pedido.setEditable(false);
        viewDetalleCompra.jtf_fecha_entrega.setEditable(false);
        viewDetalleCompra.jtf_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jl_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jtf_total_producto.setVisible(true);
        viewDetalleCompra.jl_total_producto.setVisible(true);
        viewDetalleCompra.jbtn_cancelar.setVisible(false);
        viewDetalleCompra.jbtn_descuento.setVisible(true);
        viewDetalleCompra.jbtn_modificar.setVisible(true);
        viewDetalleCompra.jbtn_actualizar.setVisible(false);
        viewDetalleCompra.jbtn_guardar.setVisible(false);
        viewDetalleCompra.jbtn_atras.setVisible(true);
        viewDetalleCompra.jbtn_nuevo_producto.setVisible(true);
        viewDetalleCompra.jbtn_primer_registro.setVisible(true);
        viewDetalleCompra.jbtn_siguiente_registro.setVisible(true);
        viewDetalleCompra.jbtn_registro_anterior.setVisible(true);
        viewDetalleCompra.jbtn_ultimo_registro.setVisible(true);
        viewDetalleCompra.jbtn_salir.setVisible(true);
        initDB();
        
        
    }
    /**
     * Metodo que permite regresar a compras
     */
    private void jbtn_atras_actionPerformed(){
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(modelCompras, viewCompras);
        viewDetalleCompra.setVisible(false);
    }
    
    private void jbtn_cancelar_actionPerformed() {
        viewDetalleCompra.jtf_id_compra.setEditable(false);
        viewDetalleCompra.jtf_id_producto.setEditable(false);
        viewDetalleCompra.jtf_cantidad.setEditable(false);
        viewDetalleCompra.jtf_precio_compra.setEditable(false);
        viewDetalleCompra.jtf_fecha_pedido.setEditable(false);
        viewDetalleCompra.jtf_fecha_entrega.setEditable(false);
        viewDetalleCompra.jtf_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jl_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jtf_total_producto.setVisible(true);
        viewDetalleCompra.jl_total_producto.setVisible(true);
        viewDetalleCompra.jbtn_cancelar.setVisible(false);
        viewDetalleCompra.jbtn_descuento.setVisible(true);
        viewDetalleCompra.jbtn_modificar.setVisible(true);
        viewDetalleCompra.jbtn_actualizar.setVisible(false);
        viewDetalleCompra.jbtn_guardar.setVisible(false);
        viewDetalleCompra.jbtn_atras.setVisible(true);
        viewDetalleCompra.jbtn_nuevo_producto.setVisible(true);
        viewDetalleCompra.jbtn_primer_registro.setVisible(true);
        viewDetalleCompra.jbtn_siguiente_registro.setVisible(true);
        viewDetalleCompra.jbtn_registro_anterior.setVisible(true);
        viewDetalleCompra.jbtn_ultimo_registro.setVisible(true);
        viewDetalleCompra.jbtn_salir.setVisible(true);
        initDB();
    }
    private void jbtn_modificar_actionPerformed(){
        viewDetalleCompra.jtf_id_compra.setEditable(true);
        viewDetalleCompra.jtf_id_producto.setEditable(true);
        viewDetalleCompra.jtf_cantidad.setEditable(true);
        viewDetalleCompra.jtf_precio_compra.setEditable(true);
        viewDetalleCompra.jtf_fecha_pedido.setEditable(true);
        viewDetalleCompra.jtf_fecha_entrega.setEditable(true);
        viewDetalleCompra.jtf_id_detalle_compra.setVisible(false);
        viewDetalleCompra.jl_id_detalle_compra.setVisible(false);
        viewDetalleCompra.jtf_total_producto.setVisible(false);
        viewDetalleCompra.jl_total_producto.setVisible(false);
        viewDetalleCompra.jbtn_cancelar.setVisible(true);
        viewDetalleCompra.jbtn_descuento.setVisible(false);
        viewDetalleCompra.jbtn_modificar.setVisible(false);
        viewDetalleCompra.jbtn_atras.setVisible(false);
        viewDetalleCompra.jbtn_actualizar.setVisible(true);
        viewDetalleCompra.jbtn_nuevo_producto.setVisible(false);
        viewDetalleCompra.jbtn_primer_registro.setVisible(false);
        viewDetalleCompra.jbtn_siguiente_registro.setVisible(false);
        viewDetalleCompra.jbtn_registro_anterior.setVisible(false);
        viewDetalleCompra.jbtn_ultimo_registro.setVisible(false);
        viewDetalleCompra.jbtn_salir.setVisible(false);
    }
    private void jbtn_actualizar_actionPerformed(){
         
        modelDetalleCompra.setId_compra(viewDetalleCompra.jtf_id_compra.getText()); 
        modelDetalleCompra.setId_producto_actual(viewDetalleCompra.jtf_id_producto.getText()); 
        modelDetalleCompra.setCantidad_actual(viewDetalleCompra.jtf_cantidad.getText()); 
        modelDetalleCompra.setPrecio_compra_actual(viewDetalleCompra.jtf_precio_compra.getText()); 
        modelDetalleCompra.setFecha_pedido(viewDetalleCompra.jtf_fecha_pedido.getText()); 
        modelDetalleCompra.setFecha_entrega(viewDetalleCompra.jtf_fecha_entrega.getText());
        modelDetalleCompra.actualizarDetalleCompra();
        viewDetalleCompra.jtf_id_compra.setEditable(false);
        viewDetalleCompra.jtf_id_producto.setEditable(false);
        viewDetalleCompra.jtf_cantidad.setEditable(false);
        viewDetalleCompra.jtf_precio_compra.setEditable(false);
        viewDetalleCompra.jtf_fecha_pedido.setEditable(false);
        viewDetalleCompra.jtf_fecha_entrega.setEditable(false);
        viewDetalleCompra.jtf_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jl_id_detalle_compra.setVisible(true);
        viewDetalleCompra.jtf_total_producto.setVisible(true);
        viewDetalleCompra.jl_total_producto.setVisible(true);
        viewDetalleCompra.jbtn_cancelar.setVisible(false);
        viewDetalleCompra.jbtn_descuento.setVisible(true);
        viewDetalleCompra.jbtn_modificar.setVisible(true);
        viewDetalleCompra.jbtn_atras.setVisible(true);
        viewDetalleCompra.jbtn_actualizar.setVisible(false);
        viewDetalleCompra.jbtn_nuevo_producto.setVisible(true);
        initDB();
        
    }
    
}
