/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuth;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuthId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTabSpecAuth_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTab_DAO;
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
public class _0_0_0_4_5_1_Employees_Auth_Ajax_3_GiveEmpAuth_AjaxServlet extends HttpServlet {

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
            PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");

            String employeeId = request.getParameter("employeeId");
            String subTabId[] = request.getParameterValues("sub_tab_id");
            String AuthChecked[] = request.getParameterValues("AuthChecked");
            //String primaryAuthPass[] = request.getParameterValues("primaryAuthPass");
            if (subTabId.length == 0 || AuthChecked.length == 0 /*|| primaryAuthPass.length == 0*/) {
                throw new Exception();
            }
            List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(employeeId);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PerEmploymentMasters pem = pList.get(0);

            HibernateSessionCon.beginTrans();

            for (int i = 0; i < AuthChecked.length; i++) {
                if (AuthChecked[i].equals("false")) {
                    /**
                     * delete UnAuthurized Screens
                     */
                    String ID[] = subTabId[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(pem.getEmployeeId(), applicationId_St, tabId_Str, subTabId_Str);
                    if (screenAuthList.isEmpty()) {
                        continue;
                    }
                    AppSubTabSpecAuth astsa = screenAuthList.get(0);
                    new AppSubTab_DAO().delete(astsa);

                }
            }
            HibernateSessionCon.CommitTrans();
            HibernateSessionCon.beginTrans();
            for (int i = 0; i < subTabId.length; i++) {
                if (AuthChecked[i].equals("true")) {

                    String ID[] = subTabId[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    AppSubTabSpecAuthId Id = new AppSubTabSpecAuthId(Integer.parseInt(subTabId_Str), pem.getEmployeeId(), Short.parseShort(applicationId_St), Integer.parseInt(tabId_Str));

                    List<AppSubTab> astList = new AppSubTab_DAO().get_ApplicationSubTabsById(applicationId_St, tabId_Str, subTabId_Str);
                    if (astList.isEmpty()) {
                        throw new Exception();
                    }
                    AppSubTab ast = astList.get(0);
                    AppSubTabSpecAuth astsa = new AppSubTabSpecAuth(Id, ast, pem, Byte.parseByte("1"/*primaryAuthPass[i]*/));
                    /**
                     * Who Do that
                     */
                    List<PerEmploymentMasters> pList2 = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(employee_session.getEmployeeNo());
                    if (pList2.isEmpty()) {
                        throw new Exception();
                    }
                    PerEmploymentMasters pem2 = pList2.get(0);

                    astsa.setPerEmploymentMastersByEmployeeIdAction(pem2);
                    astsa.setActionDate(new DateOp().getSysDate());
                    astsa.setActionDateDetails(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    new AppSubTab_DAO().update(astsa);
                }
            }

            HibernateSessionCon.CommitTrans();

            response.getWriter().write("Success");
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
