/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Date;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "processAddCliente", urlPatterns = {"/processAddCliente"})

public class processAddCliente extends HttpServlet {

    @Resource(mappedName = "alaferia")
    DataSource ds;
    Date d = new Date();
    String mensaje;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("nombre"));
        out.println(request.getParameter("rut"));
        out.println(request.getParameter("es_cliente"));
        out.println(request.getParameter("cmbServicio"));
        out.println(request.getParameter("comentario"));
        out.println(d);

        try {

            if (request.getParameter("nombre") != null //|| request.getParameter("nombre").isEmpty()
                    && request.getParameter("rut") != null //|| request.getParameter("rut").isEmpty()
                    ) {
                if ( //Agregamos Cliente
                        new Datos.DAOCliente(ds.getConnection()).agregarCliente(new Dominio.Cliente(
                                        Integer.parseInt(request.getParameter("rut")),
                                        request.getParameter("nombre")))
                        && //Agregamos Atencion
                        new Datos.DAOAtencion(ds.getConnection()).agregar(new Dominio.Atencion(
                                        59,
                                        true,
                                        2, Integer.parseInt(request.getParameter("rut")) ,
                                        request.getParameter("comentario")
                                            )))  {

                    request.setAttribute("msj", "Datos incorrectos!");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);

                }
                

            } else {
                out.print("Error");
            }
        } catch (Exception e) {
            out.print("Excepcion: " + e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
