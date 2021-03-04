/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_2_0_2_AjaxServlets_For_Developers;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElem;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElemId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubElem_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTab_DAO;
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
public class _9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_3_SaveElementsBySubTab_AjaxServlet extends HttpServlet {

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

            String applicationId = request.getParameter("applicationId");
            String tabId = request.getParameter("tabId");
            String subTabId = request.getParameter("subTabId");
            String element_name = request.getParameter("element_name");
            String elementType = request.getParameter("elementType");
            /**
             * Check If element Name Exist In This Sub Tab Before
             */
            List<AppSubElem> aseList = new AppSubElem_DAO().getApplicationNameElementByNameInSubTab(applicationId, tabId, subTabId, element_name);
            if (!aseList.isEmpty()) {
                throw new Exception("Element Name Exist Before");
            }
            //////////////////////////////////////////////////////
            int elementId = new AppSubElem_DAO().getMaxID(applicationId, tabId, subTabId);
            AppSubElemId id = new AppSubElemId(Short.parseShort(applicationId), Integer.parseInt(tabId), Integer.parseInt(subTabId), elementId);

            List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsById(applicationId, tabId, subTabId);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            AppSubTab ast = pList.get(0);

            AppSubElem ase = new AppSubElem(id, ast, element_name);
            ase.setElementType(elementType);

            HibernateSessionCon.beginTrans();
            new AppSubElem_DAO().insert(ase);
            HibernateSessionCon.CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("Element Name Exist Before")) {
                response.getWriter().write("Element Name Exist Before");
            } else {
                response.getWriter().write("Error");
            }

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
