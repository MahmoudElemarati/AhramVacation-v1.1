/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerAttendanceExistZk;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerAttendanceExistZk_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_2_0_1_PerAttendanceExistZk_Ajax_1_LoadTable_AjaxServlet extends HttpServlet {

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
            String searchType = request.getParameter("searchType");
            String employeeId = request.getParameter("employeeId");
            String OrgCode = request.getParameter("OrgCode");
            String SearchstartDate = request.getParameter("SearchstartDate");
            String SearchEndDate = request.getParameter("SearchEndDate");

            String HQL = " p.id.attendanceDate between to_date('" + SearchstartDate + "','dd-MM-yyyy') and to_date('" + SearchEndDate + "','dd-MM-yyyy') ";
            switch (searchType) {
                case "all":
                    HQL += "";
                    break;
                case "emp":
                    HQL += " and p.perEmploymentMasters.employeeId = " + employeeId + " ";
                    break;
                case "org":
                    HQL += " and p.perEmploymentMasters.perOrganizationStructureByOrgId.orgCode = " + OrgCode + "";
                    break;
                default:
                    throw new Exception();
            }

            String HTML_TEXT = "";
            List<PerAttendanceExistZk> pList = new PerAttendanceExistZk_DAO().getAttendanceExistZkCustom(HQL);
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"7\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                List<Date> setAttendanceDateArry = new ArrayList<Date>();
                for (PerAttendanceExistZk p : pList) {

                    byte Kind = p.getId().getTransKind();
                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMasters().getEmployeeId() + "</td>\n";
                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMasters().getEmpAname() + "</td>\n";
                    try {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMasters().getPerOrganizationStructureByOrgId().getOrgName() + "</td>\n";
                    } catch (Exception ex) {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;\">لا يوجد إدارة</td>\n";
                    }
                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getId().getAttendanceDate() + "</td>\n";
                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getTimeHh() + ':' + p.getTimeMm() + ':' + p.getTimeSs() + "</td>\n";
                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getTimeHh() + ':' + p.getTimeMm() + ':' + p.getTimeSs() + "</td>\n";
                    HTML_TEXT += "                    <td style=\"font-weight: bold;\"></td>\n";

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
