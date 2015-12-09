/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Felipe
 */
public class DAOServicio {
    Connection conex;

    public DAOServicio(Connection conex) {
        this.conex = conex;
    }
    
    public boolean agregarServicio(Servicio servicio) {
        try {
            String sql = "INSERT INTO servicio VALUES (?,?,?)";
            PreparedStatement sentencia = conex.prepareStatement(sql);
            sentencia.setInt(1, servicio.getIdServicio());
            sentencia.setString(2, servicio.getDescripcion());
            sentencia.setBoolean(3, servicio.getSolicitarComentario());   
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
