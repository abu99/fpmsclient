/*
 * 23/05/2013
 */
package com.fpms.server.servlets;

import com.fpms.controllers.ProfitMngrLocal;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author faizbash
 */
@WebServlet(name = "ProfitServlet", urlPatterns = {"/ProfitServlet"})
public class ProfitServlet extends HttpServlet {
    
    @EJB private ProfitMngrLocal reportMngr;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        ServletOutputStream out = response.getOutputStream();
        
        byte[] report = null;
        
        report = reportMngr.getProfitReport();
        
        //set response params
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment");       
        response.setContentLength(report.length);

        //convert report to buffered input stream
        ByteArrayInputStream bais = new ByteArrayInputStream(report);
        BufferedInputStream bufStream = new BufferedInputStream(bais);
        
        try {
            //write report
            int readBytes = 0;
            while ((readBytes = bufStream.read()) != -1) {
                out.write(readBytes);
            }
        } finally {
            out.close();
            bufStream.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
