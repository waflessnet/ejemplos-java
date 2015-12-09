/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Felipe
 */
public class DAOCliente implements DAO.ClienteDAO{
    Connection conex;

    public DAOCliente(Connection conex) {
        this.conex = conex;
    }
    
    @Override
    public boolean agregarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente VALUES (?,?)";
            PreparedStatement sentencia = conex.prepareStatement(sql);
            sentencia.setInt(1, cliente.getRut());
            sentencia.setString(2, cliente.getNombre());
            sentencia.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
