/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_1_MainMenu.SystemMainCodes;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpVacationReqJava_DAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_4_1_PerEmpVacationReqJava_Ajax_3_LoadTable_AjaxServlet extends HttpServlet {

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
            String PageSource = request.getParameter("PageSource");
            String employeeId = request.getParameter("employeeId");

            String HTML_TEXT = "";

            if (PageSource.equals("0")) { // vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد

                List<PerEmpVacationReqJava> pList = new PerEmpVacationReqJava_DAO().getAll_PerEmpVacationReqJavaByEmp(employeeId);
                if (pList.isEmpty()) {
                    HTML_TEXT = "<tr>\n"
                            + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                            + "</tr>";
                } else {
                    for (PerEmpVacationReqJava p : pList) {
                        String vacNote = p.getVacNote();
                        HTML_TEXT += "<tr>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacEditDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                        if (vacNote == null) {
                            HTML_TEXT += "                    <td></td>\n";
                        } else {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                        }
                        String vacStatus[] = new SystemMainCodes().getVacStatusName(Integer.parseInt(p.getVacStatus()));
                        String VacStatus = p.getVacStatus();
                        HTML_TEXT += "               <td style=\"color: " + vacStatus[1] + " ;font-weight: bold;font-size: 15px\"><img src=\"" + vacStatus[2] + "\" height=30 width=30>" + vacStatus[0] + " </td>\n";
                        if (VacStatus.equals("0")) {
                            HTML_TEXT += " <td><button class=\"btn btn-danger form-group fa fa-trash\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;\" onclick=\"DeleteFrom_PerEmpVacationReqJava(" + p.getVacTransSp() + ");\" type=\"button\"></button></td>\n";
                        } else if (VacStatus.equals("1")) {
                            HTML_TEXT += " <td></td>";
                        } else if (VacStatus.equals("2")) {
                            HTML_TEXT += " <td><button class=\"btn btn-warning form-group fa fa-search\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;\" data-toggle=\"modal\" data-target=\".ElMarfodat\" onclick=\"getTafaseal('" + p.getDirectBossReason() + "');\" type=\"button\"></button></td>\n";
                        }
                        HTML_TEXT += "                </tr>";

                    }
                }
            } else if (PageSource.equals("1")) { // vacStatus = "1" Deal With Ajax Request from (.jsp) عرض اجازات الموظفين التي لم يتم اعتمادها على المدير
                List<PerEmpVacationReqJava> pList = new PerEmpVacationReqJava_DAO().getAll_PerEmpVacationReqJavaByBossId(employeeId);
                if (pList.isEmpty()) {
                    HTML_TEXT = "<tr>\n"
                            + "    <td colspan=\"9\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                            + "</tr>";
                } else {
                    for (PerEmpVacationReqJava p : pList) {
                        String vacNote = p.getVacNote();
                        HTML_TEXT += "<tr>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMastersByEmployeeId().getEmpAname() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacEditDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                        if (vacNote == null) {
                            HTML_TEXT += "                    <td></td>\n";
                        } else {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                        }

                        HTML_TEXT += "                    <td><button class=\"btn btn-success form-group fa fa-check\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;font-weight: bold;\" data-toggle=\"modal\" data-target=\".AlertModal\" onclick=\"StatusVacReq(" + p.getVacTransSp() + ",1);\" type=\"button\"> قبول </button></td>\n"
                                + "                       <td><button class=\"btn btn-danger form-group fa fa-close\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;font-weight: bold;\" data-toggle=\"modal\" data-target=\".AlertModal\" onclick=\"StatusVacReq(" + p.getVacTransSp() + ",2);\" type=\"button\"> رفض </button></td>\n"
                                + "                </tr>";
                    }
                }
            } else {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"8\">لا توجد بيانات</td>\n"
                        + "</tr>";
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
