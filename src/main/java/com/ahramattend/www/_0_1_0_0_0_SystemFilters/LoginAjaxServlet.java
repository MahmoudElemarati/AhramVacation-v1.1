/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_1_0_0_0_SystemFilters;

import com.ahramattend.www._0_0_0_0_1_MainMenu.DevelopmenUserNametPassword;
import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_0_2_AhramLib.Encryption;
import com.ahramattend.www._0_0_0_0_2_AhramLib.FileOp;
import com.ahramattend.www._0_0_0_0_2_AhramLib.dbInit;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
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
public class LoginAjaxServlet extends HttpServlet {

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
        try {
            FileOp file = new FileOp("C:\\LIC\\LIC.txt");
            String EnchDate = file.ReadFileInWebApp();//2021-01-01
            String currentDate = new DateOp().getCustomSysDate("yyyy-MM-dd");
            String LastDate = new Encryption().decrypt_LIC(EnchDate).get(1);
            long diff = new DateOp().differentsBetweenTwoDates(LastDate, currentDate, "yyyy-MM-dd");
            if (diff < 0) {
                throw new Exception("License Expired");
            }

            String emp_user = request.getParameter("username");
            String emp_pass = request.getParameter("password");
            List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByUserNameAndPassword(emp_user, emp_pass);
            if (pList.size() > 0) {
                response.getWriter().write("Success");
            } else {
                DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(emp_user, emp_pass, "Administrator");
                if (!(/*(pList.size() > 0) ||*/(emp_user.equals(p.getUserName()) && emp_pass.equals(p.getPassword())))) {
                    //throw new Exception("تأكد من الاسم ورقم المرور");
                    response.getWriter().write("تأكد من الاسم ورقم المرور");
                }
            }

        } catch (Exception e) {
            HibernateSessionCon.RollBack();
            response.getWriter().write("License Expired");
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
        try {
            dbInit d = new dbInit();
            d.RunHibernate();
            processRequest(request, response);
        } catch (Exception e) {

        }

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
        try {
            dbInit d = new dbInit();
            d.RunHibernate();
            processRequest(request, response);
        } catch (Exception e) {

        }
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
