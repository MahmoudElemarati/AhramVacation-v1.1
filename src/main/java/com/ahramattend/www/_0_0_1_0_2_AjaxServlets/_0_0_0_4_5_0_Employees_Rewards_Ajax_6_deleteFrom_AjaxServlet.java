/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtl_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeMaster_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_0_Employees_Rewards_Ajax_6_deleteFrom_AjaxServlet extends HttpServlet {

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

            String accessSpID = request.getParameter("accessSpID");
            String accessSpID_Arr[] = accessSpID.split("-");
            String AccessSp = accessSpID_Arr[0];
            String LocCode = accessSpID_Arr[1];
            String LocationCode = accessSpID_Arr[2];
            String BandCode = accessSpID_Arr[3];
            String BandType = accessSpID_Arr[4];
            String OpenMm = accessSpID_Arr[5];
            String OpenYyyy = accessSpID_Arr[6];

            List<PayDeserveEmpFileDtl> pList = new PayDeserveEmpFileDtl_DAO().getPayEmployeeMasterByRewardId(AccessSp, OpenMm, OpenYyyy, BandCode, BandType, LocationCode, LocCode);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PayDeserveEmpFileDtl pdrfd = pList.get(0);
            HibernateSessionCon.beginTrans();
            new PayDeserveEmpFileDtl_DAO().delete(pdrfd);
            HibernateSessionCon.CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
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
