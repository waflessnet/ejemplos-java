/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Dominio.Atencion;



import Dominio.Servicio;

/**
 *
 * @author Felipe
 */
public class DAOAtencion implements DAO.AtencionDAO {

    Connection conex;

    public DAOAtencion(Connection conex) {
        this.conex = conex;
    }

    @Override
    public boolean agregar(Atencion atencion) {
        
          //Cliente c = new Cliente();
        try {
            String sql = "INSERT INTO atencion  (rut,id_servicio,nro_modulo,es_cliente,tiempo_espera,comentario,fecha_creacion) "
                    +    "  values(?,?,?,?,?,?,now())";
            System.out.println(" ********************************************* " +atencion.getRut().getRut());
            PreparedStatement sentencia = conex.prepareStatement(sql);
            sentencia.setInt(1,atencion.getRut().getRut() );
            sentencia.setInt(2, atencion.getIdServicio().getIdServicio());
            sentencia.setInt(3, atencion.getNroModulo().getNroModulo());
            sentencia.setBoolean(4, atencion.getEsCliente());
            sentencia.setInt(5, atencion.getTiempoEspera());
            sentencia.setString(6, atencion.getComentario());
            
            
            //sentencia.executeUpdate();
            sentencia.execute();
            System.out.println( sql.toString()  );
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


}
