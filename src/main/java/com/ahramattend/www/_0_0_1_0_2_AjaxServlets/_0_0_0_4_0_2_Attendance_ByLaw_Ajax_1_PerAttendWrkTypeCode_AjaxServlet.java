/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerAttendanceWrkTypeCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerAttendanceWrkTypeDetail;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerAttendanceWrkTypeCode_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _0_0_0_4_0_2_Attendance_ByLaw_Ajax_1_PerAttendWrkTypeCode_AjaxServlet extends HttpServlet {

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

            String HTML_TEXT = "";
            List<PerAttendanceWrkTypeCode> pList = new PerAttendanceWrkTypeCode_DAO().getAllPerAttendanceWrkTypeCode();
            if (pList.isEmpty()) {
                throw new Exception();
            }

            for (PerAttendanceWrkTypeCode pawtc : pList) {
                int no_of_dtl = pawtc.getPerAttendanceWrkTypeDetails().size();
                long no_of_emp = 0;
                for (PerAttendanceWrkTypeDetail pawtd : pawtc.getPerAttendanceWrkTypeDetails()) {
                    no_of_emp += pawtd.getPerEmploymentMasterses().size();
                }
                HTML_TEXT += "<tr>\n"
                        + "      <td>" + pawtc.getWorkTypeCode() + "</td>\n"
                        + "      <td>" + pawtc.getWorkTypeName() + "</td>\n"
                        + "      <td>" + pawtc.getWorkTypeKind() + "</td>\n"
                        + "      <td>" + no_of_dtl + "</td>\n"
                        + "      <td>" + no_of_emp + "</td>\n"
                        + "      <td>\n"
                        + "          <button type=\"button\" class=\"fa fa-search btn btn-primary form-control\" data-toggle=\"modal\" data-target=\".attendWrkTypeDtlModal\" onclick=\"QueryPerAttendWrkTypeDtl('" + pawtc.getWorkTypeCode() + "','" + pawtc.getWorkTypeName() + "');\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>\n"
                        + "      </td>\n"
                        + "  </tr> ";
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
