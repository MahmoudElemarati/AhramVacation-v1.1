/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_0_AccessServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_3_Employees_Rewards_Dashboard_Build_AccessServlet extends HttpServlet {

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
        String date_from = request.getParameter("date_from");
        String date_to = request.getParameter("date_to");
        String LocationCode_Global = request.getParameter("LocationCode_Global");

        String[] LocTableArr = request.getParameter("LocTableArr").split(",");
        String useBandAttribute = request.getParameter("useBandAttribute");

        String rejects = request.getParameter("rejects");
        String parts = request.getParameter("parts");
        String detailType = request.getParameter("detailType");

        request.getSession().setAttribute("OpenHTMLFile", "Open");
        request.getSession().setAttribute("date_from", date_from);
        request.getSession().setAttribute("date_to", date_to);
        request.getSession().setAttribute("LocationCode_Global", LocationCode_Global);
        request.getSession().setAttribute("LocTableArr", LocTableArr);

        request.getSession().setAttribute("useBandAttribute", useBandAttribute);
        if (useBandAttribute.equals("true")) {
            String[] BandTableArr = request.getParameter("BandTableArr").split(",");
            for (String s : BandTableArr) {
                System.out.println(s);
            }
            request.getSession().setAttribute("BandTableArr", BandTableArr);
        }

        request.getSession().setAttribute("rejects", rejects);
        request.getSession().setAttribute("parts", parts);
        request.getSession().setAttribute("detailType", detailType);
        //request.getRequestDispatcher("/_0_0_0_0_8_2_PayEmployeeReq_print.jsp").forward(request, response);
        response.sendRedirect("_0_0_0_4_5_3_Employees_Rewards_Dashboard_Build.jsp");

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
