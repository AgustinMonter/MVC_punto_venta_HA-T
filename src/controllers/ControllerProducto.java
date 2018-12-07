/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProducto;
import views.ViewProducto;



/**
 *
 * @author HP
 */
public final class ControllerProducto {
    public ModelProducto modelProducto;
    public ViewProducto viewProducto;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProducto.jbtn_nuevo) {
                jbtn_limpiar_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_cancelarnuevo) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_modificar) {
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_borrar) {
                jbtn_eliminar_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_cancelarmodificar) {
                cancelarNuevo_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_guardar1) {
                jbtn_guardarCambios_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewProducto.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
        
    }
};
    public ControllerProducto(ModelProducto modelProveedores, ViewProducto viewProveedores) {
        this.modelProducto = modelProveedores;
        this.viewProducto = viewProveedores;
        initComponents();
        setActionListener();
        initDB();
    }
    private void setActionListener() {
        viewProducto.jbtn_primero.addActionListener(actionListener);
        viewProducto.jbtn_anterior.addActionListener(actionListener);
        viewProducto.jbtn_siguiente.addActionListener(actionListener);
        viewProducto.jbtn_ultimo.addActionListener(actionListener);
        viewProducto.jbtn_nuevo.addActionListener(actionListener);
        viewProducto.jbtn_guardar.addActionListener(actionListener);
        viewProducto.jbtn_modificar.addActionListener(actionListener);
        viewProducto.jbtn_borrar.addActionListener(actionListener);
        viewProducto.jbtn_cancelarmodificar.addActionListener(actionListener);
        viewProducto.jbtn_cancelarnuevo.addActionListener(actionListener);
        viewProducto.jbtn_guardar1.addActionListener(actionListener);      
        
    }
    private void initDB() {
        modelProducto.conectarDB();
        viewProducto.jtf_idproducto.setText(modelProducto.getIdproducto());
        viewProducto.jtf_nombre.setText(modelProducto.getNombre());
        viewProducto.jtf_marca.setText(modelProducto.getMarca());
        viewProducto.jtf_tipo_producto.setText(modelProducto.getTipo_producto());
        viewProducto.jtf_existencia.setText((modelProducto.getExistencia()));
        viewProducto.jtf_preciounitario.setText(modelProducto.getPreciouni());
        viewProducto.jtf_preciomayoreo.setText(modelProducto.getPrecioMayor());
        viewProducto.jtf_descripcion.setText(modelProducto.getDescripcion());
       
        viewProducto.jtf_idsucursal.setText(modelProducto.getIdsucursal());
        
    }
    public void noEditar(){
        viewProducto.jtf_idproducto.setEditable(false);
        viewProducto.jtf_nombre.setEditable(false);
        viewProducto.jtf_marca.setEditable(false);
        viewProducto.jtf_tipo_producto.setEditable(false);
        viewProducto.jtf_existencia.setEditable(false);
        viewProducto.jtf_preciounitario.setEditable(false);
        viewProducto.jtf_descripcion.setEditable(false);
        viewProducto.jtf_idsucursal.setEditable(false);
       viewProducto.jtf_preciomayoreo.setEditable(false);
    }
    public void editar(){
        viewProducto.jtf_idproducto.setEditable(false);
        viewProducto.jtf_nombre.setEditable(true);
        viewProducto.jtf_marca.setEditable(true);
        viewProducto.jtf_tipo_producto.setEditable(true);
        viewProducto.jtf_existencia.setEditable(true);
        viewProducto.jtf_preciounitario.setEditable(true);
        viewProducto.jtf_descripcion.setEditable(true);
        viewProducto.jtf_idsucursal.setEditable(true);
        viewProducto.jtf_preciomayoreo.setEditable(true);
    }
    public void initComponents() {
        viewProducto.setLocationRelativeTo(null);
        viewProducto.setVisible(false);
        viewProducto.jbtn_guardar.setVisible(false);
        viewProducto.jbtn_cancelarmodificar.setVisible(false);
        viewProducto .jbtn_cancelarnuevo.setVisible(false);
        viewProducto.jbtn_guardar1.setVisible(false);
        noEditar();
    }
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelProducto.moverPrimerRegistro();
        setValues();
        
    }
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelProducto.moverAnteriorRegistro();
        setValues();
    }
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelProducto.moverUltimoRegistro();
        setValues();
    }
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelProducto.moverSiguienteRegistro();
        setValues();
    }
    private void setValues() {
        viewProducto.jtf_idproducto.setText(modelProducto.getIdproducto());
        viewProducto.jtf_nombre.setText(modelProducto.getNombre());
        viewProducto.jtf_marca.setText(modelProducto.getMarca());
        viewProducto.jtf_tipo_producto.setText(modelProducto.getTipo_producto());
        viewProducto.jtf_existencia.setText((modelProducto.getExistencia()));
        viewProducto.jtf_preciounitario.setText(modelProducto.getPreciouni());
        viewProducto .jtf_descripcion.setText(modelProducto.getDescripcion());
        viewProducto.jtf_idsucursal.setText(modelProducto.getIdsucursal());
        viewProducto.jtf_preciomayoreo.setText(modelProducto.getPrecioMayor());
    }
    public void jbtn_limpiar_actionPerformed(){
        viewProducto.jbtn_guardar.setVisible(true);
        viewProducto.jp_navegacion.setVisible(false);
        viewProducto.jbtn_modificar.setVisible(false);
        viewProducto.jbtn_nuevo.setVisible(false);
        viewProducto.jbtn_borrar.setVisible(false);
        viewProducto.jbtn_cancelarnuevo.setVisible(true);
        viewProducto.jtf_idproducto.setText("");
        viewProducto.jtf_nombre.setText("");
        viewProducto.jtf_marca.setText("");
        viewProducto.jtf_tipo_producto.setText("");
        viewProducto.jtf_existencia.setText("");
        viewProducto.jtf_preciounitario.setText("");
        viewProducto.jtf_descripcion.setText(""); 
        viewProducto.jtf_idsucursal.setText("");
        viewProducto.jtf_preciomayoreo.setText("");
        editar();
    }
    private void jbtn_guardar_actionPerformed(){
        modelProducto.setIdproducto(viewProducto.jtf_idproducto.getText());
        modelProducto.setNombre(viewProducto.jtf_nombre.getText());
        modelProducto.setMarca(viewProducto.jtf_marca.getText()); 
        modelProducto.setTipo_producto(viewProducto.jtf_tipo_producto.getText()); 
        modelProducto.setExistencia(viewProducto.jtf_existencia.getText()); 
        modelProducto.setPreciouni(viewProducto.jtf_preciounitario.getText());
        modelProducto.setDescripcion(viewProducto.jtf_descripcion.getText());
        modelProducto.setIdsucursal(viewProducto.jtf_idsucursal.getText());
        modelProducto.setPrecioMayor(viewProducto.jtf_preciomayoreo.getText());
        modelProducto.guardarRegistro();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewProducto.setVisible(true);
    }
    public void cancelarNuevo_actionPerformed(){
        modelProducto.conectarDB();
        viewProducto.jbtn_cancelarnuevo.setVisible(false);
        viewProducto.jbtn_guardar.setVisible(false);
        viewProducto.jp_navegacion.setVisible(true);
        viewProducto.jbtn_modificar.setVisible(true);
        viewProducto.jbtn_borrar.setVisible(true);
        viewProducto.jbtn_nuevo.setVisible(true);
        noEditar();
        setValues();
        initComponents();
        viewProducto.setVisible(true);
    }
    private void jbtn_modificar_actionPerformed(){
        viewProducto.jbtn_nuevo.setVisible(false);
        viewProducto.jbtn_cancelarmodificar.setVisible(true);
        viewProducto.jp_navegacion.setVisible(false);
        viewProducto.jbtn_guardar1.setVisible(true);
        viewProducto.jbtn_borrar.setVisible(false);
        viewProducto.jbtn_modificar.setVisible(false);
        editar();
    }
    private void jbtn_guardarCambios_actionPerformed(){
        modelProducto.setIdproducto(viewProducto.jtf_idproducto.getText());
        modelProducto.setNombre(viewProducto.jtf_nombre.getText());
        modelProducto.setMarca(viewProducto.jtf_marca.getText()); 
        modelProducto.setTipo_producto(viewProducto.jtf_tipo_producto.getText()); 
        modelProducto.setExistencia(viewProducto.jtf_existencia.getText()); 
        modelProducto.setPreciouni(viewProducto.jtf_preciounitario.getText());
        modelProducto.setDescripcion(viewProducto.jtf_descripcion.getText());
        modelProducto.setIdsucursal(viewProducto.jtf_idsucursal.getText()); 
        modelProducto.setPrecioMayor(viewProducto.jtf_preciomayoreo.getText());
        modelProducto.guardarCambios();
        modelProducto.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewProducto.setVisible(true);
    }
    private void jbtn_eliminar_actionPerformed(){
        modelProducto.setIdproducto(viewProducto.jtf_idproducto.getText());
        modelProducto.setNombre(viewProducto.jtf_nombre.getText());
        modelProducto.setMarca(viewProducto.jtf_marca.getText()); 
        modelProducto.setTipo_producto(viewProducto.jtf_tipo_producto.getText()); 
        modelProducto.setExistencia(viewProducto.jtf_existencia.getText()); 
        modelProducto.setPreciouni(viewProducto.jtf_preciounitario.getText());
        modelProducto.setDescripcion(viewProducto.jtf_descripcion.getText());
        modelProducto.setIdsucursal(viewProducto.jtf_idsucursal.getText()); 
        modelProducto.setPrecioMayor(viewProducto.jtf_preciomayoreo.getText());
        modelProducto.borrarRegistro();
        modelProducto.conectarDB();
        cancelarNuevo_actionPerformed();
        initComponents();
        viewProducto.setVisible(true);
    }
  

}
