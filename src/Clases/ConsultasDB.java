/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ConsultasDB extends Conexion{
    
    // Guardar Elementos en la Tabla
    public boolean Guardar(Producto NewProducto) {
        PreparedStatement preparar_statement_insert = null;
        Connection con = getConexion();

        String sql = "INSERT INTO listaproductosdb (nombre, cantidad, categoria, precio) VALUES(?,?,?,?)";
        try {
            preparar_statement_insert = con.prepareStatement(sql);
            preparar_statement_insert.setString(1, NewProducto.getNombre());
            preparar_statement_insert.setInt(2, NewProducto.getCantidad());
            preparar_statement_insert.setString(3, NewProducto.getCategoria());
            preparar_statement_insert.setDouble(4, NewProducto.getPrecio());
            preparar_statement_insert.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    // Actualizar Elementos en la Tabla
    public ResultSet Actualizar(Producto NewProducto) {
        PreparedStatement preparar_statement_actualizar = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM listaproductosdb ORDER BY id";
        
        try {
            preparar_statement_actualizar = con.prepareStatement(sql);
            preparar_statement_actualizar.execute();
            return ;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
    
    // Eliminar Elementos en la Tabla
    public boolean Eliminar(Producto NewProducto) {
        PreparedStatement preparar_statement_delete = null;
        Connection con = getConexion();

        String sql = "DELETE FROM listaproductosdb WHERE id = ?";
        try {
            preparar_statement_delete = con.prepareStatement(sql);
            preparar_statement_delete.setInt(1, NewProducto.getId());
            preparar_statement_delete.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
    
}
