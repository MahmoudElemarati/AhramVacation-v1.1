/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_2_0_2_AjaxServlets_For_Developers;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElem;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElemSpecAuth;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElemSpecAuthId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuth;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuthId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubElemSpecAuth_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubElem_DAO;
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
public class _9_9_9_9_9_4_Employee_ScreenElements_Auth_Distribution_Ajax_2_GiveEmpAuth_AjaxServlet extends HttpServlet {

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

            String employeeId = request.getParameter("employeeId");
            String sub_tab_element_id[] = request.getParameterValues("sub_tab_element_id");
            String AuthChecked[] = request.getParameterValues("AuthChecked");
            String primaryAuthPass[] = request.getParameterValues("primaryAuthPass");
            if (sub_tab_element_id.length == 0 || AuthChecked.length == 0 || primaryAuthPass.length == 0) {
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
                    String ID[] = sub_tab_element_id[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    String subTabElementId_Str = ID[3];
                    List<AppSubElemSpecAuth> elementAuthList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuth(pem.getEmployeeId(), applicationId_St, tabId_Str, subTabId_Str, subTabElementId_Str);
                    if (elementAuthList.isEmpty()) {
                        continue;
                    }
                    AppSubElemSpecAuth astsa = elementAuthList.get(0);
                    new AppSubElemSpecAuth_DAO().delete(astsa);

                }
            }
            HibernateSessionCon.CommitTrans();
            HibernateSessionCon.beginTrans();
            for (int i = 0; i < sub_tab_element_id.length; i++) {
                if (AuthChecked[i].equals("true")) {

                    String ID[] = sub_tab_element_id[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    String subTabElementId_Str = ID[3];
                    AppSubElemSpecAuthId Id = new AppSubElemSpecAuthId(Short.parseShort(applicationId_St), Integer.parseInt(tabId_Str), Integer.parseInt(subTabId_Str), Integer.parseInt(subTabElementId_Str), pem.getEmployeeId());

                    List<AppSubElem> astList = new AppSubElem_DAO().getAll_ApplicationNameElementById(applicationId_St, tabId_Str, subTabId_Str, subTabElementId_Str);
                    if (astList.isEmpty()) {
                        throw new Exception();
                    }
                    AppSubElem ast = astList.get(0);
                    AppSubElemSpecAuth astsa = new AppSubElemSpecAuth(Id, ast, pem);
                    if (primaryAuthPass[i].equals("undefined")) {
                        astsa.setPrimaryAuthPass(Byte.parseByte("1"));
                    }else{
                         astsa.setPrimaryAuthPass(Byte.parseByte(primaryAuthPass[i]));
                    }

                    astsa.setActionDate(new DateOp().getSysDate());
                    astsa.setActionDateDetails(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    new AppSubElem_DAO().update(astsa);
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
