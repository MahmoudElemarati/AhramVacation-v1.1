/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_0_2_AhramLib.Encryption;
import com.ahramattend.www._0_0_0_0_2_AhramLib.FileOp;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _0_0_0_0_0_0_LIC_Ajax_1_LoadTable_AjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String keyLIC = request.getParameter("keyLIC");
            String EnchDate = keyLIC;//2021-01-01
            String currentDate = new DateOp().getCustomSysDate("yyyy-MM-dd");
            String LastDate = new Encryption().decrypt_LIC(EnchDate).get(1);
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + LastDate);
            long diff = new DateOp().differentsBetweenTwoDates(LastDate, currentDate, "yyyy-MM-dd");
            if (diff < 1) {
                throw new Exception("License Expired");
            }
            new File("C:\\LIC").mkdir();
            FileOp file = new FileOp("C:\\LIC\\LIC.txt");
            boolean FileDeleted = true;
            try {
                file.ReadFile();
                file.DeleteFile();
                throw new Exception();
            } catch (Exception e) {
                List<String> lines = new ArrayList<>();
                lines.add(keyLIC);
                file.CreateAndWriteFile(lines);
            }
            if (!FileDeleted) {
                throw new Exception();
            }
            response.getWriter().write(LastDate);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
