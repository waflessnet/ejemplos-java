/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Modulo;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Felipe
 */
public class DAOModulo implements DAO.ModuloDAO{
   Connection conex;

    public DAOModulo(Connection conex) {
        this.conex = conex;
    }
    
     public boolean agregarModulo(Modulo modulo) {
        try {
            String sql = "INSERT INTO modulo VALUES (?,?)";
            PreparedStatement sentencia = conex.prepareStatement(sql);
            sentencia.setInt(1, modulo.getNroModulo());
            sentencia.setInt(2, modulo.getCargaActual());
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}
