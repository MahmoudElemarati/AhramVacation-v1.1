/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_0_AccessServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_1_0_5_Dash_EmpCount_KaderAndOrg_AccessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String plotType = request.getParameter("plotType");
        String generalCode = request.getParameter("generalCode");
        String locationCode = request.getParameter("locationCode");
        String sexFlag = request.getParameter("sexFlag");
        String SearchType = request.getParameter("SearchType");
        String OrgId = request.getParameter("OrgId");
        String FiscalDegreeCode = request.getParameter("FiscalDegreeCode");

        String color_1 = request.getParameter("color_1");
        String color_2 = request.getParameter("color_2");
        
        request.getSession().setAttribute("OpenHTMLFile", "Open");
        request.getSession().setAttribute("plotType", plotType);
        request.getSession().setAttribute("generalCode", generalCode);
        request.getSession().setAttribute("locationCode", locationCode);
        request.getSession().setAttribute("sexFlag", sexFlag);
        request.getSession().setAttribute("SearchType", SearchType);
        request.getSession().setAttribute("OrgId", OrgId);
        request.getSession().setAttribute("FiscalDegreeCode", FiscalDegreeCode);

        request.getSession().setAttribute("color_1", color_1);
        request.getSession().setAttribute("color_2", color_2);

        //request.getRequestDispatcher("/_0_0_0_1_0_3_Dash_EmpCount.jsp").forward(request, response);
        response.sendRedirect("_0_0_0_1_0_5_Dash_EmpCount_KaderAndOrg.jsp");
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
