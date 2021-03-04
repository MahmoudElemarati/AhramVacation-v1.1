/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmp;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtlRuf;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtlRuf_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtl_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmp_DAO;
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
public class _0_0_0_4_5_2_Employees_Rewards_Query_Ajax_2_getSearchResult_AjaxServlet extends HttpServlet {

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

            String HTML_TEXT = new _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_getSearchResult_AjaxClass().
                    getSearchResult(SearchType, LocCodeCombo,
                            LocCode, LocationCode,
                            bandCode, bandType,
                            openMm, openYyyy, queryType, rejects,
                            locationColStatus,
                            rewardDateTimeColStatus, dateTimeReview,
                            empRewardDateTimeColStatus, dateTimeEmpReview,true);

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
