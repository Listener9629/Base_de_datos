/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Clases.ConsultasDB;
import Clases.Producto;
import Vistas.Articulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Controlador implements ActionListener{
    private Producto MiProducto;
    private Articulo MiArticulo;
    private ConsultasDB MiConsultasDB;

    public Controlador(Producto MiProducto, Articulo MiArticulo, ConsultasDB MiConsultasDB) {
        this.MiProducto = MiProducto;
        this.MiArticulo = MiArticulo;
        this.MiConsultasDB = MiConsultasDB;
        
        
        MiArticulo.btnguardar.addActionListener(this);
        MiArticulo.btneliminar.addActionListener(this);
        MiArticulo.btnconsultar.addActionListener(this);
        MiArticulo.btnactualizar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Boton Guardar
        if(e.getSource() == MiArticulo.btnguardar){
           MiProducto.setNombre(MiArticulo.txtnombre.getText());
           MiProducto.setCantidad(Integer.parseInt(MiArticulo.txtcantidad.getText()));
           MiProducto.setPrecio(Double.parseDouble(MiArticulo.txtprecio.getText()));
           MiProducto.setCategoria(MiArticulo.comboboxcategoria.getSelectedItem().toString());
       
           if (MiConsultasDB.Guardar(MiProducto)){
               JOptionPane.showMessageDialog(null,"Registro almacenado exitosamente");
               MiArticulo.txtnombre.setText("");
               MiArticulo.txtcantidad.setText("");
               MiArticulo.txtprecio.setText("");
           }else{
               JOptionPane.showMessageDialog(null, "Error al Guardar");
           }
        }
        
        //Boton Eliminar
        if(e.getSource() == MiArticulo.btneliminar){
           MiProducto.setId(Integer.parseInt(MiArticulo.txtidconsultar.getText()));
           MiProducto.setNombre(MiArticulo.txtnombreconsultar.getText());
           MiProducto.setCantidad(Integer.parseInt(MiArticulo.txtcantidadconsultar.getText()));
           MiProducto.setPrecio(Double.parseDouble(MiArticulo.txtprecioconsultar.getText()));
           MiProducto.setCategoria(MiArticulo.comboboxcategoriaconsultar.getSelectedItem().toString());
       
           if (MiConsultasDB.Eliminar(MiProducto)){
               JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
               MiArticulo.txtidconsultar.setText("");
               MiArticulo.txtnombreconsultar.setText("");
               MiArticulo.txtcantidadconsultar.setText("");
               MiArticulo.txtprecioconsultar.setText("");
           }else{
               JOptionPane.showMessageDialog(null, "Error al Eliminar");
           }
        }
       
        
        //Boton Consultar
        if(e.getSource() == MiArticulo.btnconsultar){
           MiProducto.setNombre(MiArticulo.txtnombre.getText());
           MiProducto.setCantidad(Integer.parseInt(MiArticulo.txtcantidad.getText()));
           MiProducto.setPrecio(Double.parseDouble(MiArticulo.txtprecio.getText()));
           MiProducto.setCategoria(MiArticulo.comboboxcategoria.getSelectedItem().toString());
        }
       
        
        //Boton Actualizar
        if(e.getSource() == MiArticulo.btnactualizar){
           MiProducto.setNombre(MiArticulo.txtnombreconsultar.getText());
           MiProducto.setCantidad(Integer.parseInt(MiArticulo.txtcantidadconsultar.getText()));
           MiProducto.setPrecio(Double.parseDouble(MiArticulo.txtprecioconsultar.getText()));
           MiProducto.setCategoria(MiArticulo.comboboxcategoriaconsultar.getSelectedItem().toString());
       
           if (MiConsultasDB.Actualizar(MiProducto)){
               JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente");
               MiArticulo.txtnombreconsultar.setText("");
               MiArticulo.txtcantidadconsultar.setText("");
               MiArticulo.txtprecioconsultar.setText("");
           }else{
               JOptionPane.showMessageDialog(null, "Error al Actualizar");
           }
        }
       
        
    }
}
