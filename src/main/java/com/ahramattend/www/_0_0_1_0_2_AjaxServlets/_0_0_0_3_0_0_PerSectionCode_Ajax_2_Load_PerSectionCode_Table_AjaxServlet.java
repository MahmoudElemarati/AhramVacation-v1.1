/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_1_MainMenu.SystemMainCodes;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerSectionCode;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpVacationReqJava_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerSectionCode_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_3_0_0_PerSectionCode_Ajax_2_Load_PerSectionCode_Table_AjaxServlet extends HttpServlet {

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
            List<PerSectionCode> pList = new PerSectionCode_DAO().getAllPerSectionCode();
            String HTML_TEXT = "";
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (PerSectionCode p : pList) {
                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;font-size: 15px;\">" + p.getPerLocationCodes().getBudLocation().getLocationName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;font-size: 15px;\">" + p.getPerLocationCodes().getLocName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;font-size: 15px;\">" + p.getSecName() + "</td>\n";
                    String Floor = p.getSecFloor();
                    if (Floor == null) {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;font-size: 15px;\"></td>\n";
                    } else {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;font-size: 15px;\">" + p.getSecFloor() + "</td>\n";
                    }
                    //+ "                    <td><button class=\"btn btn-success form-group fa fa-edit\" style=\"width: 90%;height: 5%;box-shadow: -1px 2px 5px 1px black;\" onclick=\"DeleteFrom_PerEmpVacationReqJava(" + p.getId().getSecCode() + ");\" type=\"button\"></button></td>\n"
                    HTML_TEXT += "                    <td style=\"width: 5%;\"><button class=\"btn btn-danger form-group fa fa-trash\" style=\"width: 80%;height: 3%;box-shadow: -1px 2px 5px 1px black;\" onclick=\"DeleteFrom_PerSectionCode(" + p.getId().getSecCode() + ");\" type=\"button\"></button></td>\n";
                    HTML_TEXT += "                </tr>";
                }
            }

            response.getWriter().write(HTML_TEXT);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
