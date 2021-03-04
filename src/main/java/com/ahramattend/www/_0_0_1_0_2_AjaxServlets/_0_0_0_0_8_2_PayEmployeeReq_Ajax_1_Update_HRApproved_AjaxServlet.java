/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeReq;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeReq_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpVacationReqJava_DAO;
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
public class _0_0_0_0_8_2_PayEmployeeReq_Ajax_1_Update_HRApproved_AjaxServlet extends HttpServlet {

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
            String ChkView = request.getParameter("chkView");
            String ReqSp = request.getParameter("reqSp");
            List<PayEmployeeReq> pList = new PayEmployeeReq_DAO().getPayEmployeeReqID(ReqSp);
            PayEmployeeReq payEmployeeReq = pList.get(0);

            if (ChkView.equals(0)) {
                payEmployeeReq.setChkView("1");
            } else if (ChkView.equals(1)) {
                payEmployeeReq.setChkView("2");
            }

            HibernateSessionCon.beginTrans();
            new PayEmployeeReq_DAO().update(payEmployeeReq);
            HibernateSessionCon.CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            String Message = e.getMessage();
            response.getWriter().write(Message);
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
