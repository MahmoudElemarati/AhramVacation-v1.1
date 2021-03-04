/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationTrans;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpVacationTrans_DAO;
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
public class _0_0_0_0_5_1_PerEmpVacationTrans_Ajax_1_LoadAllPerEmpVacationTransTable_AjaxServlet extends HttpServlet {

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
            String employeeId = request.getParameter("employeeId");
            String vacationCode = request.getParameter("vacationCode");
            String SearchType = request.getParameter("SearchType");
            String SearchstartDate = request.getParameter("SearchstartDate");
            String SearchEndDate = request.getParameter("SearchEndDate");
            String HQL = "where ";
            String HTML_TEXT = "";
            switch (SearchType) {                
                case "1": 
                    ///لو البحث بالكل 
                    if (vacationCode.equals("0")) {
                        HQL += "p.perEmploymentMasters.employeeId=" + employeeId + " ORDER BY p.vacStartDate desc";
                        List<PerEmpVacationTrans> pList = new PerEmpVacationTrans_DAO().All_PerEmpVacationTrans(HQL);
                        if (pList.isEmpty()) {
                            HTML_TEXT = "<tr>\n"
                                    + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                    + "</tr>";
                        } else {
                            for (PerEmpVacationTrans p : pList) {
                                String vacNote = p.getVacNote();
                                HTML_TEXT += "<tr>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPostDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                                if (vacNote == null) {
                                    HTML_TEXT += "                    <td></td>\n";
                                } else {
                                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                                }
                                HTML_TEXT += "                </tr>";

                            }
                        }
                    } else if (!vacationCode.equals("0")) {
                        HQL += "p.perEmploymentMasters.employeeId=" + employeeId + " and p.id.vacationCode=" + vacationCode + " ORDER BY p.vacStartDate desc";
                        List<PerEmpVacationTrans> pList = new PerEmpVacationTrans_DAO().All_PerEmpVacationTrans(HQL);
                        if (pList.isEmpty()) {
                            HTML_TEXT = "<tr>\n"
                                    + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                    + "</tr>";
                        } else {
                            for (PerEmpVacationTrans p : pList) {
                                String vacNote = p.getVacNote();
                                HTML_TEXT += "<tr>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPostDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                                if (vacNote == null) {
                                    HTML_TEXT += "                    <td></td>\n";
                                } else {
                                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                                }
                                HTML_TEXT += "                </tr>";

                            }
                        }
                    } else {
                        HTML_TEXT = "<tr>\n"
                                + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                + "</tr>";
                    }
                    response.getWriter().write(HTML_TEXT);
                    break;
                    
                    ///لو البحث بالفترة الزمنية
                    case "2":
                    if (vacationCode.equals("0")) {
                        HQL += "p.perEmploymentMasters.employeeId=" + employeeId + " and p.vacStartDate between to_date('" + SearchstartDate + "','dd-MM-yyyy') and to_date('" + SearchEndDate + "','dd-MM-yyyy') ORDER BY p.vacStartDate desc";
                        List<PerEmpVacationTrans> pList = new PerEmpVacationTrans_DAO().All_PerEmpVacationTrans(HQL);
                        if (pList.isEmpty()) {
                            HTML_TEXT = "<tr>\n"
                                    + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                    + "</tr>";
                        } else {
                            for (PerEmpVacationTrans p : pList) {
                                String vacNote = p.getVacNote();
                                HTML_TEXT += "<tr>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPostDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                                if (vacNote == null) {
                                    HTML_TEXT += "                    <td></td>\n";
                                } else {
                                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                                }
                                HTML_TEXT += "                </tr>";

                            }
                        }
                    } else if (!vacationCode.equals("0")) {
                        HQL += "p.perEmploymentMasters.employeeId=" + employeeId + " and p.id.vacationCode=" + vacationCode + " and p.vacStartDate between to_date('" + SearchstartDate + "','dd-MM-yyyy') and to_date('" + SearchEndDate + "','dd-MM-yyyy') ORDER BY p.vacStartDate desc";
                        List<PerEmpVacationTrans> pList = new PerEmpVacationTrans_DAO().All_PerEmpVacationTrans(HQL);
                        if (pList.isEmpty()) {
                            HTML_TEXT = "<tr>\n"
                                    + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                    + "</tr>";
                        } else {
                            for (PerEmpVacationTrans p : pList) {
                                String vacNote = p.getVacNote();
                                HTML_TEXT += "<tr>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPerVacationCode().getVacationName() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPeriod() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getPostDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacStartDate() + "</td>\n"
                                        + "                    <td style=\"font-weight: bold;\">" + p.getVacEndDate() + "</td>\n";
                                if (vacNote == null) {
                                    HTML_TEXT += "                    <td></td>\n";
                                } else {
                                    HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getVacNote() + "</td>\n";
                                }
                                HTML_TEXT += "                </tr>";

                            }
                        }
                    } else {
                        HTML_TEXT = "<tr>\n"
                                + "    <td colspan=\"8\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                                + "</tr>";
                    }
                    response.getWriter().write(HTML_TEXT);
                    break;

            }

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
