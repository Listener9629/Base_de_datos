/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clases.ConsultasDB;
import Clases.Producto;
import Controlador.Controlador;
import Vistas.Articulo;


public class Principal {
    
        
    public static void main(String[] args) {
            
        Producto MiProducto = new Producto();
        Articulo MiArticulo = new Articulo();
        ConsultasDB MiConsulta = new ConsultasDB();
        Controlador MiControlador = new Controlador(MiProducto, MiArticulo, MiConsulta);
                 
        MiArticulo.setVisible(true);
        
                                
    }
    
}