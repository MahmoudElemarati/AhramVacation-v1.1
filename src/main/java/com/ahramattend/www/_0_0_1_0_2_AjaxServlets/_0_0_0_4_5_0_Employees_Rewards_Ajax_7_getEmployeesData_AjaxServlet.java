/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeMaster_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
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
public class _0_0_0_4_5_0_Employees_Rewards_Ajax_7_getEmployeesData_AjaxServlet extends HttpServlet {

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
        HibernateSessionCon.OpenCon();
        try {

            String searchEmpName = request.getParameter("searchEmpName");
            String LocCode = request.getParameter("LocCode");
            String LocationCode = request.getParameter("LocationCode");

            String HTML_TEXT = "";

            List<PayEmployeeMaster> pList = new PayEmployeeMaster_DAO().getPayEmployeeMasterByName(searchEmpName);
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr><td>لا توجد بيانات</td></tr>";
            } else {
                for (PayEmployeeMaster p : pList) {
                    String color = (p.getPerEmploymentMasters().getPerLocationCodes().getId().getLocCode().equals(LocCode)
                            && p.getPerEmploymentMasters().getPerLocationCodes().getId().getLocationCode().equals(LocationCode)) ? "" : "style='background-color : #ffbdbd;'";
                    HTML_TEXT += "<tr " + color + ">\n"
                            + "           <td>" + p.getEmployeeNo() + "</td>\n"
                            + "           <td>" + p.getEmpAname() + "</td>\n"
                            + "           <td>" + p.getPerEmploymentMasters().getPerLocationCodes().getLocName() + "</td>\n"
                            + "           <td>"
                            + "             <button type=\"button\" onclick=\"getEmployeeNoOut('" + p.getEmployeeNo() + "');\" data-dismiss=\"modal\" class=\"fa fa-copy btn btn-success\" style=\"border: 2px solid white;\"></button>"
                            + "           </td>\n"
                            + "</tr>";
                }
            }

            response.getWriter().write(HTML_TEXT);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }

        HibernateSessionCon.closeConn();
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
