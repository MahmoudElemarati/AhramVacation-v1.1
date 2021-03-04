/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_1_MainMenu.PayReqChkView;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeReq;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeReq_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_8_1_PayEmployeeReq_Ajax_2_LoadReqTable_AjaxServlet extends HttpServlet {

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
            //System.out.println(PageSource);
            String HTML_TEXT = "";

            if (PageSource.equals("0")) { // vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد
                PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");
                List<PayEmployeeReq> pList = new PayEmployeeReq_DAO().getAll_PayEmployeeReqByEmp(employee_session.getEmployeeId());
                int i = 0;
                if (!pList.isEmpty()) {
                    for (PayEmployeeReq p : pList) {
                        String rmrk = p.getRmrk();
                        HTML_TEXT += "<tr>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getReqDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getReqDateTime() + "</td>\n";
                        if (rmrk == null) {
                            HTML_TEXT += "                    <td></td>\n";
                        } else {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getRmrk() + "</td>\n";
                        }

                        ///////////////////// لعرض حالة الطلب...
                        String ChkView[] = new PayReqChkView().getchkViewName(Integer.parseInt(p.getChkView()));
                        String chkView = p.getChkView();
                        HTML_TEXT += "   <td style=\"color: " + ChkView[1] + " ;font-weight: bold;font-size: 15px\"><img src=\"" + ChkView[2] + "\" height=30 width=30>" + ChkView[0] + " </td>\n";

                        ///////////////////// لعرض زرار الحذف في حالة عدم استقبال شئون العاملين للطب...
                        if (chkView.equals("0")) {
                            HTML_TEXT += " <td><button class=\"btn btn-danger form-group fa fa-trash\" style=\"box-shadow: -1px 2px 5px 1px black;\" onclick=\"DeleteFrom_PayEmployeeReq(" + p.getReqSp() + ");\" type=\"button\"></button></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;color: grey;\">__/__/____</td>\n";
                        } else if (chkView.equals("1")) {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;text-align: center;\"><img src=\"webDesign/production/images/cogs.gif\" height=40 width=40></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;color: grey;\">__/__/____</td>\n";
                        } else if (chkView.equals("2")) {
                            HTML_TEXT += " <td><button class=\"btn btn-success form-group fa fa-search\" style=\"box-shadow: -1px 2px 5px 1px black;\" onclick=\"getMofradat(" + p.getReqSp() + ");\" type=\"button\"></button></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getDoneDateTime() + "</td>\n";
                        }

                        HTML_TEXT += "                </tr>";
                        i++;

                    }
                }
                List<PayEmployeeReq> ppList = new PayEmployeeReq_DAO().getLastActiveReqDone(employee_session.getEmployeeId());
                if (!ppList.isEmpty()) {
                    for (PayEmployeeReq p : ppList) {
                        String rmrk = p.getRmrk();
                        HTML_TEXT += "<tr>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getReqDate() + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + p.getReqDateTime() + "</td>\n";
                        if (rmrk == null) {
                            HTML_TEXT += "                    <td></td>\n";
                        } else {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getRmrk() + "</td>\n";
                        }

                        ///////////////////// لعرض حالة الطلب...
                        String ChkView[] = new PayReqChkView().getchkViewName(Integer.parseInt(p.getChkView()));
                        String chkView = p.getChkView();
                        HTML_TEXT += "   <td style=\"color: " + ChkView[1] + " ;font-weight: bold;font-size: 15px\"><img src=\"" + ChkView[2] + "\" height=30 width=30>" + ChkView[0] + " </td>\n";

                        ///////////////////// لعرض زرار الحذف في حالة عدم استقبال شئون العاملين للطب...
                        if (chkView.equals("0")) {
                            HTML_TEXT += " <td><button class=\"btn btn-danger form-group fa fa-trash\" style=\"box-shadow: -1px 2px 5px 1px black;\" onclick=\"DeleteFrom_PayEmployeeReq(" + p.getReqSp() + ");\" type=\"button\"></button></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;color: grey;\">__/__/____</td>\n";
                        } else if (chkView.equals("1")) {
                            HTML_TEXT += "                    <td style=\"font-weight: bold;text-align: center;\"><img src=\"webDesign/production/images/cogs.gif\" height=40 width=40></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;color: grey;\">__/__/____</td>\n";
                        } else if (chkView.equals("2")) {
                            HTML_TEXT += " <td><button class=\"btn btn-success form-group fa fa-search\" style=\"box-shadow: -1px 2px 5px 1px black;\" onclick=\"getMofradat(" + p.getReqSp() + ");\" type=\"button\"></button></td>\n";
                            HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getDoneDateTime() + "</td>\n";
                        }

                        HTML_TEXT += "                </tr>";
                        i++;

                    }
                }
                if (i == 0) {
                    HTML_TEXT = "<tr>\n"
                            + "    <td colspan=\"6\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                            + "</tr>";
                }

            } else {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"5\">لا توجد بيانات</td>\n"
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
