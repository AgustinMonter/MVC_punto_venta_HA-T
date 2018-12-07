/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewDescuentoCompra;
import models.ModelDescuentoCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelDetalleCompra;
import views.ViewDetalleCompra;
/**
 *
 * @author Jose Felix
 */
public class ControllerDescuentoCompra {
    ModelDescuentoCompra modelDescuentoCompra;
    ViewDescuentoCompra viewDescuentoCompra;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewDescuentoCompra.jbtn_primer_registro) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_registro_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_siguiente_registro) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_ultimo_registro) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_nuevo) {
                jbtn_nuevo_producto_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_atras) {
                jbtn_atras_actionPerformed();
            } else if (e.getSource() == viewDescuentoCompra.jbtn_cancelar) {
                jbtn_cancelar_actionPerformed();
            }else if (e.getSource() == viewDescuentoCompra.jbtn_actualizar) {
                jbtn_actualizar_actionPerformed();
            }else if (e.getSource() == viewDescuentoCompra.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelDescuetoCompra y ViewDescuentoCompra
     *
     * @param modelAgenda objeto de ModelDescuetoCompra
     * @param viewAgenda objeto de tipo ViewDescuentoCompra
     */
    public ControllerDescuentoCompra(ModelDescuentoCompra modelDescuentoCompra, ViewDescuentoCompra viewDescuentoCompra) {
        this.modelDescuentoCompra = modelDescuentoCompra;
        this.viewDescuentoCompra = viewDescuentoCompra;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y llena los jtf de ViewDescuentoCompra.
     */
    public void initDB(){
        modelDescuentoCompra.conectarDB();
        viewDescuentoCompra.jtf_id_descuento.setText(modelDescuentoCompra.getId_descuento_compra());
        viewDescuentoCompra.jtf_id_producto.setText(modelDescuentoCompra.getId_producto());
        viewDescuentoCompra.jtf_id_proveedor.setText(modelDescuentoCompra.getId_proveedor());
        viewDescuentoCompra.jtf_id_detalle_compra.setText(modelDescuentoCompra.getId_detalle_compra());
        viewDescuentoCompra.jtf_porcentaje_descontar.setText(modelDescuentoCompra.getPorcentaje_descontar());
        
    }
    /**
     * Metodo para inicializar la ViewDescuentoCompra
     */
    public void initComponents() {
        viewDescuentoCompra.jbtn_cancelar.setVisible(false);
        viewDescuentoCompra.jbtn_actualizar.setVisible(false);
        //viewDetalleCompra.jbtn_actualizar.setVisible(false);
        viewDescuentoCompra.jbtn_guardar.setVisible(false);
        viewDescuentoCompra.setLocationRelativeTo(null);
        viewDescuentoCompra.setTitle("Detalle compra");
        viewDescuentoCompra.setVisible(true);
        
    }


    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewDescuentoCompra.jbtn_primer_registro.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_registro_anterior.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_siguiente_registro.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_ultimo_registro.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_guardar.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_nuevo.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_atras.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_cancelar.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_actualizar.addActionListener(actionListener);
        viewDescuentoCompra.jbtn_modificar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla descuento compra
     */
    private void jbtn_primero_actionPerformed() {
        modelDescuentoCompra.moverPrimerRegistro();
        viewDescuentoCompra.jtf_id_descuento.setText(modelDescuentoCompra.getId_descuento_compra());
        viewDescuentoCompra.jtf_id_producto.setText(modelDescuentoCompra.getId_producto());
        viewDescuentoCompra.jtf_id_proveedor.setText(modelDescuentoCompra.getId_proveedor());
        viewDescuentoCompra.jtf_id_detalle_compra.setText(modelDescuentoCompra.getId_detalle_compra());
        viewDescuentoCompra.jtf_porcentaje_descontar.setText(modelDescuentoCompra.getPorcentaje_descontar());
        
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla descuento compra
     */
    private void jbtn_anterior_actionPerformed() {
        modelDescuentoCompra.moverAnteriorRegistro();
        viewDescuentoCompra.jtf_id_descuento.setText(modelDescuentoCompra.getId_descuento_compra());
        viewDescuentoCompra.jtf_id_producto.setText(modelDescuentoCompra.getId_producto());
        viewDescuentoCompra.jtf_id_proveedor.setText(modelDescuentoCompra.getId_proveedor());
        viewDescuentoCompra.jtf_id_detalle_compra.setText(modelDescuentoCompra.getId_detalle_compra());
        viewDescuentoCompra.jtf_porcentaje_descontar.setText(modelDescuentoCompra.getPorcentaje_descontar());
        
    }

    /**
     * Método para ver el último registro de la tabla descuento compra
     */
    private void jbtn_ultimo_actionPerformed() {
        modelDescuentoCompra.moverUltimoRegistro();
        viewDescuentoCompra.jtf_id_descuento.setText(modelDescuentoCompra.getId_descuento_compra());
        viewDescuentoCompra.jtf_id_producto.setText(modelDescuentoCompra.getId_producto());
        viewDescuentoCompra.jtf_id_proveedor.setText(modelDescuentoCompra.getId_proveedor());
        viewDescuentoCompra.jtf_id_detalle_compra.setText(modelDescuentoCompra.getId_detalle_compra());
        viewDescuentoCompra.jtf_porcentaje_descontar.setText(modelDescuentoCompra.getPorcentaje_descontar());
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla descuento compra
     */
    private void jbtn_siguiente_actionPerformed() {
        modelDescuentoCompra.moverSiguienteRegistro();
        viewDescuentoCompra.jtf_id_descuento.setText(modelDescuentoCompra.getId_descuento_compra());
        viewDescuentoCompra.jtf_id_producto.setText(modelDescuentoCompra.getId_producto());
        viewDescuentoCompra.jtf_id_proveedor.setText(modelDescuentoCompra.getId_proveedor());
        viewDescuentoCompra.jtf_id_detalle_compra.setText(modelDescuentoCompra.getId_detalle_compra());
        viewDescuentoCompra.jtf_porcentaje_descontar.setText(modelDescuentoCompra.getPorcentaje_descontar());
        
    }
    /**
     * Metodo para hacer editable los jtf de la vista y borrar el texto que tienen
     */
    private void jbtn_nuevo_producto_actionPerformed(){
        viewDescuentoCompra.jtf_id_producto.setEditable(true);
        viewDescuentoCompra.jtf_id_producto.setText("");
        viewDescuentoCompra.jtf_id_proveedor.setEditable(true);
        viewDescuentoCompra.jtf_id_proveedor.setText("");
        viewDescuentoCompra.jtf_id_detalle_compra.setEditable(true);
        viewDescuentoCompra.jtf_id_detalle_compra.setText("");
        viewDescuentoCompra.jtf_porcentaje_descontar.setEditable(true);
        viewDescuentoCompra.jtf_porcentaje_descontar.setText("");
        viewDescuentoCompra.jtf_id_descuento.setVisible(false);
        viewDescuentoCompra.jl_id_descuento.setVisible(false);
        viewDescuentoCompra.jbtn_cancelar.setVisible(true);
        viewDescuentoCompra.jbtn_guardar.setVisible(true);
        viewDescuentoCompra.jbtn_cancelar.setVisible(true);
        viewDescuentoCompra.jbtn_nuevo.setVisible(false);
        viewDescuentoCompra.jbtn_modificar.setVisible(false);
        viewDescuentoCompra.jbtn_actualizar.setVisible(false);
        viewDescuentoCompra.jbtn_atras.setVisible(false);
        viewDescuentoCompra.jbtn_salir.setVisible(false);
        viewDescuentoCompra.jbtn_primer_registro.setVisible(false);
        viewDescuentoCompra.jbtn_registro_anterior.setVisible(false);
        viewDescuentoCompra.jbtn_siguiente_registro.setVisible(false);
        viewDescuentoCompra.jbtn_ultimo_registro.setVisible(false);
        
    }
    /**
     * Metodo toma el texto que tienen los jtf de la vista y los guarda las variables del modelo, invoca guardar del modelo 
     */
    private void jbtn_guardar_actionPerformed(){
        modelDescuentoCompra.setId_producto(viewDescuentoCompra.jtf_id_producto.getText()); 
        modelDescuentoCompra.setId_proveedor(viewDescuentoCompra.jtf_id_proveedor.getText()); 
        modelDescuentoCompra.setId_detalle_compra(viewDescuentoCompra.jtf_id_detalle_compra.getText()); 
        modelDescuentoCompra.setPorcentaje_descontar(viewDescuentoCompra.jtf_porcentaje_descontar.getText()); 
        modelDescuentoCompra.guardar();
        
        
        
    }
    /**
     * Metodo permite regresar a la vista de detalle compra 
     */
    private void jbtn_atras_actionPerformed(){
        ModelDetalleCompra modelDetalleCompra = new ModelDetalleCompra();
        ViewDetalleCompra viewDetalleCompra = new ViewDetalleCompra();
        ControllerDetalleCompra controllerDeatalleCompra = new ControllerDetalleCompra(modelDetalleCompra, viewDetalleCompra);
        viewDescuentoCompra.setVisible(false);
    }
    /**
     * Metodo que hace que los jtf de la vista no sean editables
     */
    private void jbtn_cancelar_actionPerformed() {
        viewDescuentoCompra.jtf_id_producto.setEditable(false);
        viewDescuentoCompra.jtf_id_proveedor.setEditable(false);
        viewDescuentoCompra.jtf_id_detalle_compra.setEditable(false);
        viewDescuentoCompra.jtf_porcentaje_descontar.setEditable(false);
        viewDescuentoCompra.jtf_id_descuento.setVisible(true);
        viewDescuentoCompra.jl_id_descuento.setVisible(true);
        viewDescuentoCompra.jbtn_cancelar.setVisible(false);
        viewDescuentoCompra.jbtn_guardar.setVisible(false);
        viewDescuentoCompra.jbtn_nuevo.setVisible(true);
        viewDescuentoCompra.jbtn_modificar.setVisible(true);
        viewDescuentoCompra.jbtn_actualizar.setVisible(false);
        viewDescuentoCompra.jbtn_atras.setVisible(true);
        viewDescuentoCompra.jbtn_salir.setVisible(true);
        viewDescuentoCompra.jbtn_primer_registro.setVisible(true);
        viewDescuentoCompra.jbtn_registro_anterior.setVisible(true);
        viewDescuentoCompra.jbtn_siguiente_registro.setVisible(true);
        viewDescuentoCompra.jbtn_ultimo_registro.setVisible(true);
        initDB();
    }
    /**
     * Metodo que hace que los jtf sean editables
     */
    public void jbtn_modificar_actionPerformed(){
        viewDescuentoCompra.jtf_id_producto.setEditable(true);
        viewDescuentoCompra.jtf_id_proveedor.setEditable(true);
        viewDescuentoCompra.jtf_id_detalle_compra.setEditable(true);
        viewDescuentoCompra.jtf_porcentaje_descontar.setEditable(true);
        viewDescuentoCompra.jtf_id_descuento.setVisible(false);
        viewDescuentoCompra.jl_id_descuento.setVisible(false);
        viewDescuentoCompra.jbtn_cancelar.setVisible(true);
        viewDescuentoCompra.jbtn_guardar.setVisible(false);
        viewDescuentoCompra.jbtn_cancelar.setVisible(true);
        viewDescuentoCompra.jbtn_nuevo.setVisible(false);
        viewDescuentoCompra.jbtn_modificar.setVisible(false);
        viewDescuentoCompra.jbtn_actualizar.setVisible(true);
        viewDescuentoCompra.jbtn_atras.setVisible(false);
        viewDescuentoCompra.jbtn_salir.setVisible(false);
        viewDescuentoCompra.jbtn_primer_registro.setVisible(false);
        viewDescuentoCompra.jbtn_registro_anterior.setVisible(false);
        viewDescuentoCompra.jbtn_siguiente_registro.setVisible(false);
        viewDescuentoCompra.jbtn_ultimo_registro.setVisible(false);
        
    }
    /**
     * Metodo que toma el texto de los jtf y lo guarda en la variables correspondientes e invoca al metodo del modelo actualizar
     */
    public void jbtn_actualizar_actionPerformed(){
        modelDescuentoCompra.setId_producto(viewDescuentoCompra.jtf_id_producto.getText()); 
        modelDescuentoCompra.setId_proveedor(viewDescuentoCompra.jtf_id_proveedor.getText()); 
        modelDescuentoCompra.setId_detalle_compra(viewDescuentoCompra.jtf_id_detalle_compra.getText()); 
        modelDescuentoCompra.setPorcentaje_descontar(viewDescuentoCompra.jtf_porcentaje_descontar.getText()); 
        modelDescuentoCompra.actualizar();
        viewDescuentoCompra.jtf_id_producto.setEditable(false);
        viewDescuentoCompra.jtf_id_proveedor.setEditable(false);
        viewDescuentoCompra.jtf_id_detalle_compra.setEditable(false);
        viewDescuentoCompra.jtf_porcentaje_descontar.setEditable(false);
        viewDescuentoCompra.jtf_id_descuento.setVisible(true);
        viewDescuentoCompra.jl_id_descuento.setVisible(true);
        viewDescuentoCompra.jbtn_cancelar.setVisible(false);
        viewDescuentoCompra.jbtn_guardar.setVisible(false);
        viewDescuentoCompra.jbtn_cancelar.setVisible(false);
        viewDescuentoCompra.jbtn_nuevo.setVisible(true);
        viewDescuentoCompra.jbtn_modificar.setVisible(true);
        viewDescuentoCompra.jbtn_actualizar.setVisible(false);
        viewDescuentoCompra.jbtn_atras.setVisible(true);
        viewDescuentoCompra.jbtn_salir.setVisible(true);
        viewDescuentoCompra.jbtn_primer_registro.setVisible(true);
        viewDescuentoCompra.jbtn_registro_anterior.setVisible(true);
        viewDescuentoCompra.jbtn_siguiente_registro.setVisible(true);
        viewDescuentoCompra.jbtn_ultimo_registro.setVisible(true);
        initDB();
    }
    
    
}
