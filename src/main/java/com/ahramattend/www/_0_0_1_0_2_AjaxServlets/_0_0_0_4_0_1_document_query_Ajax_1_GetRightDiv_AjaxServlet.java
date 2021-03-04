/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheet;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpDecisionSheet;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionSheet_DAO;
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
public class _0_0_0_4_0_1_document_query_Ajax_1_GetRightDiv_AjaxServlet extends HttpServlet {

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
            String decisionNoSearch = request.getParameter("decisionNoSearch");
            List<PerDecisionSheet> pList = new PerDecisionSheet_DAO().getPerDecisionSheetByDecisionNo(decisionNoSearch);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PerDecisionSheet p = pList.get(0);
            String HTML_TEXT = "<div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
                    + "                                                    <label class=\"control-label\" style=\"font-size: 15px;\">رقم القرار</label>\n"
                    + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"decisionNo\"  value=\"" + p.getDecisionNo() + "\" required=\"\" readonly=\"\">\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
                    + "                                                    <label class=\"control-label\" style=\"font-size: 20px;\"> نوع القرار</label>                                                    \n"
                    + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"decisionTypeCode\"  value=\"" + p.getPerDecisionTypeCode().getDecisionTypeName() + "\" required=\"\" readonly=\"\">\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
                    + "                                                    <label class=\"control-label\" style=\"font-size: 20px;\"> الجهة المصدرة للقرار</label>                                                    \n"
                    + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"desicionSideCode\"  value=\"" + p.getPerDesicionSideCode().getDesicionSideName() + "\" required=\"\" readonly=\"\">\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"row\">\n"
                    + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n"
                    + "                                                        <label class=\"control-label\" style=\"font-size: 20px;\">موضوع القرار</label>\n"
                    + "                                                        <textarea type=\"text\" class=\"form-control\" name=\"\" id=\"decisionSubject\"  value=\"" + p.getDecisionSubject() + "\" required=\"\" style=\"resize: none;height: 150px;\" readonly=\"\"></textarea>\n"
                    + "                                                    </div>\n"
                    + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n"
                    + "                                                        <label class=\"control-label\" style=\"font-size: 20px;\">ملخص القرار</label>\n"
                    + "                                                        <textarea type=\"text\" class=\"form-control\" name=\"\" id=\"decisionSummary\"  value=\"" + p.getDecisionSummary() + "\" required=\"\" style=\"resize: none;height: 150px;\" readonly=\"\"></textarea>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"row\">\n"
                    + "                                                    <br>\n"
                    + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive\">\n"
                    + "                                                        <table id=\"myTable\" class=\"table table-striped table-bordered table-hover\">\n"
                    + "                                                            <thead style=\"background-color: #337ab7;color: white;\">\n"
                    + "                                                                <tr>\n"
                    + "                                                                    <th style=\"text-align: center;font-size: 15px;width: 20%\">رقم التأمين</th>\n"
                    + "                                                                    <th style=\"text-align: center;font-size: 15px;width: 70%\">بيانات الموظف</th>\n"
                    + "                                                                </tr>\n"
                    + "                                                            </thead>\n"
                    + "                                                            <tbody>\n";
            for (PerEmpDecisionSheet peds : p.getPerEmpDecisionSheets()) {
                HTML_TEXT += "  <tr>\n"
                        + "         <td>" + peds.getPerEmploymentMasters().getEmployeeNo() + "</td>\n"
                        + "         <td>" + peds.getPerEmploymentMasters().getEmpAname() + "</td>\n"
                        + "     </tr>\n";
            }

            HTML_TEXT += "                                                            </tbody>\n"
                    + "                                                        </table>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>";

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
