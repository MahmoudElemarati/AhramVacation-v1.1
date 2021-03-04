/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_0_AccessServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_1_0_2_AjaxServlets._0_0_0_4_5_0_Employees_Rewards_NotAjax_2_getRewardStatus_AjaxClass;
import com.ahramattend.www._0_0_1_0_2_AjaxServlets._0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_getSearchResult_AjaxClass;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_2_Employees_Rewards_Query_print_AccessServlet extends HttpServlet {

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
        HibernateSessionCon.OpenCon();
        String HTML_TEXT = "";
        try {
            String SearchType = request.getParameter("SearchType");
            String LocCodeCombo = request.getParameter("LocCodeCombo");
            String LocCode = request.getParameter("LocCode");
            String LocationCode = request.getParameter("LocationCode");
            String bandCode = request.getParameter("bandCode");
            String bandCode_Arr[] = bandCode.split("-");
            bandCode = bandCode_Arr[0];
            String bandType = bandCode_Arr[1];
            String month = request.getParameter("month");
            month = "01-" + month;
            DateOp dOp = new DateOp();
            String openMm = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "MM");
            String openYyyy = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "yyyy");
            String queryType = request.getParameter("queryType");
            String rejects = request.getParameter("rejects");

            // Colums Options
            String locationColStatus = request.getParameter("locationColStatus");

            String rewardDateTimeColStatus = request.getParameter("rewardDateTimeColStatus");
            String dateTimeReview = request.getParameter("dateTimeReview");//DateOnly || DateTime

            String empRewardDateTimeColStatus = request.getParameter("empRewardDateTimeColStatus");
            String dateTimeEmpReview = request.getParameter("dateTimeEmpReview");//DateOnly || DateTime

            

            
            //البيانات العليا
            HTML_TEXT = new _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_getSearchResult_AjaxClass().getTopDescriptionOfDeserveEmpFile(SearchType, queryType, rejects, LocCodeCombo, LocCode, LocationCode, bandCode, bandType, openMm, openYyyy);
            
            
            // الحالة
//            String rewardStatus = new _0_0_0_4_5_0_Employees_Rewards_NotAjax_2_getRewardStatus_AjaxClass().
//                    getStatus(LocCode, LocationCode, bandCode,
//                            bandType, month, openMm, openYyyy);
//            HTML_TEXT += "<div class=\"row\" style=\"text-align: center;\">\n"
//                    + "     <br>\n"
//                    + "     <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\" style=\"font-size: 25px;\">\n";
//
//            if (rewardStatus.equals("Error")) {
//                HTML_TEXT += defaultStatus("غير معروف");
//            } else if (rewardStatus.equals("جديد")) {
//                HTML_TEXT += greenStatus("غير مسجل");
//            } else if (rewardStatus.startsWith("مسجل")) {
//                HTML_TEXT += orangeStatus(rewardStatus);
//            } else if (rewardStatus.startsWith("مغلق")) {
//                HTML_TEXT += redStatus(rewardStatus + " و تم إرسالها للمراجعة");
//            } else if (rewardStatus.startsWith("جاري التنفيذ")) {
//                HTML_TEXT += primaryStatus(rewardStatus);
//            } else if (rewardStatus.startsWith("تم التنفيذ")) {
//                HTML_TEXT += successStatus(rewardStatus);
//            } else if (rewardStatus.equals("غير متاح")) {
//                HTML_TEXT += redStatus(rewardStatus);
//            }
//            HTML_TEXT += "     </div>\n"
//                    + " </div>";

            HTML_TEXT += "<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">";
            HTML_TEXT += new _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_getSearchResult_AjaxClass().
                    getSearchResult(SearchType, LocCodeCombo,
                            LocCode, LocationCode,
                            bandCode, bandType,
                            openMm, openYyyy, queryType, rejects,
                            locationColStatus,
                            rewardDateTimeColStatus, dateTimeReview,
                            empRewardDateTimeColStatus, dateTimeEmpReview,true);
            HTML_TEXT += "     </div>\n";
            response.getWriter().write(HTML_TEXT);

        } catch (Exception e) {
            e.printStackTrace();
            //response.getWriter().write("Error");
            HTML_TEXT = "";
        }

        HibernateSessionCon.closeConn();
        request.getSession().setAttribute("PrintedDiv", HTML_TEXT);
        //request.getRequestDispatcher("/_0_0_0_4_5_2_Employees_Rewards_Query_print.jsp").forward(request, response);
        response.sendRedirect("_0_0_0_4_5_2_Employees_Rewards_Query_print.jsp");
        //request.getSession().removeAttribute("PrintedDiv");
    }

    private String redStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: red !important;\"></strong><strong style=\"color: red !important;font-size: 25px;\">" + word + "</strong>";
        return status;
    }

    private String primaryStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #78c1ff !important;\"></strong><strong style=\"color: #78c1ff !important;font-size: 25px;\">" + word + "</strong>";
        return status;
    }

    private String greenStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #26b99a !important;\"></strong><strong style=\"color: #26b99a !important;font-size: 25px;\">" + word + "</strong>";
        return status;
    }

    private String successStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #14bd00 !important;\"></strong><strong style=\"color: #14bd00 !important;font-size: 25px;\">" + word + "</strong>";
        return status;
    }

    private String defaultStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;\"></strong><strong style=\"font-size: 25px\">" + word + "</strong>";
        return status;
    }

    private String orangeStatus(String word) {
        String status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: orange !important;\"></strong><strong style=\"color: orange !important;font-size: 25px;\">" + word + "</strong>";
        return status;
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
