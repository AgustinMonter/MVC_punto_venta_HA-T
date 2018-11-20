/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelLogin;
import views.ViewLogin;
/**
 *
 * @author Edgar
 */
public class ControllerLogin {
    public ModelLogin modelLogin;
    public ViewLogin viewLogin;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewLogin.jbtn_iniciar_sesion) {
                jbtn_iniciar_secion_actionPerformed();
            } else if (e.getSource() == viewLogin.jbtn_salir) {
                jbtn_salir_actionPerformed();
        }
        }
        
    };
        public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin) {
            this.modelLogin = modelLogin;
            this.viewLogin = viewLogin;
            setActionListener();
            initComponents();
            initDB();
        }
        private void setActionListener() {
        viewLogin.jbtn_iniciar_sesion.addActionListener(actionListener);
        viewLogin.jbtn_salir.addActionListener(actionListener);
        }
        private void initDB() {
        modelLogin.conectarDB();
        viewLogin.jtf_nom_usuario.setText(modelLogin.getNombreusuario());
        viewLogin.jfp_contrasenia.setText(modelLogin.getContrasenia());
        }
        public void initComponents() {
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setTitle("");
        viewLogin.setVisible(true);
        }
        private void jbtn_iniciar_secion_actionPerformed() {
        System.out.println("Action del boton jbtn_iniciar_secion");
        modelLogin.setNombreusuario(viewLogin.jtf_nom_usuario.getText());
        modelLogin.setContrasenia(viewLogin.jfp_contrasenia.getText());
        viewLogin.jtf_nom_usuario.setText("");
        viewLogin.jfp_contrasenia.setText("");
        modelLogin.iniciarSecion();
        viewLogin.setVisible(false);
        // setValues();
        }
        private void jbtn_salir_actionPerformed() {
        System.out.println("Action del boton jbtn_salir");
        modelLogin.salir();
        }
        private void setValues() {
        viewLogin.jtf_nom_usuario.setText(modelLogin.getNombreusuario());
        viewLogin.jfp_contrasenia.setText(modelLogin.getContrasenia());
        }
}
