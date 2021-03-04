/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerUsers;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerUsers_DAO;
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
public class _0_0_0_0_0_3_userProfile_1_ChangePassword_AjaxServlet extends HttpServlet {

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
            String emp_id = request.getParameter("emp_id");
            String userPwd = request.getParameter("userPwd");
            String newPassword = request.getParameter("newPassword");

            List<PerUsers> mList = new PerUsers_DAO().getUserAndPwById(emp_id, userPwd);
            if (mList.isEmpty()) {
                throw new Exception("كلمة المرور غير صحيحة");
            } else {
                PerUsers m = mList.get(0);

                m.setUserPwd(newPassword);

                HibernateSessionCon.beginTrans();
                new PerUsers_DAO().update(m);
                HibernateSessionCon.CommitTrans();

                response.getWriter().write("Success");

            }
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            String Message = e.getMessage();
            if (Message.equals("كلمة المرور غير صحيحة")) {
                Message = "كلمة المرور غير صحيحة";
            } else {
                Message = "حدث خطأ";
            }
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
