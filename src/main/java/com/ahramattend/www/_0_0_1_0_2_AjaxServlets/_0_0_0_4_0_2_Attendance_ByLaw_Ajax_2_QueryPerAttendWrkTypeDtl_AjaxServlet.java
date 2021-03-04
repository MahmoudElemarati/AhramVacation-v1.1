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
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerAttendanceWrkTypeDetail_DAO;
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
public class _0_0_0_4_0_2_Attendance_ByLaw_Ajax_2_QueryPerAttendWrkTypeDtl_AjaxServlet extends HttpServlet {

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
            String wrkTypeCode = request.getParameter("wrkTypeCode");
            String HTML_TEXT = "";
            List<PerAttendanceWrkTypeDetail> pList = new PerAttendanceWrkTypeDetail_DAO().getPerAttendanceWrkTypeDetailByworkTypeCode(wrkTypeCode);
            if (pList.isEmpty()) {
                throw new Exception();
            }

            for (PerAttendanceWrkTypeDetail pawtd : pList) {
                long no_of_emp = pawtd.getPerEmploymentMasterses().size();
                HTML_TEXT += "<tr>\n"
                        + "      <td>" + pawtd.getId().getWorkTypeCode() + " - " + pawtd.getId().getWorkTypeSeq() + "</td>\n"
                        + "      <td>" + pawtd.getWorkDays() + "</td>\n"
                        + "      <td>" + pawtd.getWorkDaysType() + "</td>\n"
                        + "      <td>" + pawtd.getAttendanceHour() + ":" + pawtd.getAttendanceMin() + "</td>\n"
                        + "      <td>" + pawtd.getAttendanceDelayHour() + ":" + pawtd.getAttendanceDelayMin() + "</td>\n"
                        + "      <td>" + pawtd.getDismissHour() + ":" + pawtd.getDismissMin() + "</td>\n"
                        + "      <td>" + pawtd.getDismissEarlyHour() + ":" + pawtd.getDismissEarlyMin() + "</td>\n"
                        + "      <td>" + no_of_emp + "</td>\n"
                        + "      <td>\n"
                        + "          <button type=\"button\" class=\"fa fa-search btn btn-primary form-control\" onclick=\"window.open('_0_0_0_4_0_3_Attendance_ByLaw_Emp_Query.jsp?WorkTypeCode="+pawtd.getId().getWorkTypeCode()+"&WorkTypeSeq="+pawtd.getId().getWorkTypeSeq()+"', '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=500,width=1000,scrollbars=no,status=no');\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>\n"
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
