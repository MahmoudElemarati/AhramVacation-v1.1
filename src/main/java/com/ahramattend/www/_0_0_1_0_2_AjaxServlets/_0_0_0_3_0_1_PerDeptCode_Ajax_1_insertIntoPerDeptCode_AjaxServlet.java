/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.BudLocation;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDeptCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDeptCodeId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerLocationCodes;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerSectionCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerSectionCodeId;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.BudLocation_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDeptCode_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerLocationCodes_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerSectionCode_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_3_0_1_PerDeptCode_Ajax_1_insertIntoPerDeptCode_AjaxServlet extends HttpServlet {

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
            String LocationCode = request.getParameter("LocationCode");
            String LocCode = request.getParameter("LocCode");
            String SecCode = request.getParameter("SecCode");
            String DeptName = request.getParameter("DeptName");
            String DeptFloor = request.getParameter("DeptFloor");

            
            List<BudLocation> BudLocationList = new BudLocation_DAO().getِAllBudLocationByID(LocationCode);
            BudLocation budLocation = BudLocationList.get(0);
            
            List<PerLocationCodes> PerLocationCodesList = new PerLocationCodes_DAO().getAllPerLocationCodesByLocCode(LocCode);
            PerLocationCodes perLocationCodes = PerLocationCodesList.get(0);
            
            List<PerSectionCode> PerSectionCodeList = new PerSectionCode_DAO().getPerSectionCodeById(SecCode);
            PerSectionCode perSectionCode = PerSectionCodeList.get(0);

            
            short DeptCode = new PerDeptCode_DAO().getMaxPerDeptCode();
            PerDeptCodeId id= new PerDeptCodeId(budLocation.getLocationCode(), perLocationCodes.getId().getLocCode(), perSectionCode.getId().getSecCode(), DeptCode);
            PerDeptCode m = new PerDeptCode(id, perSectionCode);
            
            m.setDeptName(DeptName);
            m.setDeptFloor(DeptFloor);
            
            HibernateSessionCon.beginTrans();
            new PerSectionCode_DAO().insert(m);
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
