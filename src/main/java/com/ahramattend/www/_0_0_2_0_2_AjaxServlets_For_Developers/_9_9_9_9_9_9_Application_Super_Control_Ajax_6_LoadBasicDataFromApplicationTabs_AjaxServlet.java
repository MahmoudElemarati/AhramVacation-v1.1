/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_2_0_2_AjaxServlets_For_Developers;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppName;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppTabs;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppName_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppTabs_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class _9_9_9_9_9_9_Application_Super_Control_Ajax_6_LoadBasicDataFromApplicationTabs_AjaxServlet extends HttpServlet {

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

            String HTML_TEXT = "";// vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد

            List<AppName> pList = new AppName_DAO().getAll_ApplicationName();
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"3\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (AppName p : pList) {
                    HTML_TEXT += "<thead style=\"background-color: #337ab7;color: white;\">\n"
                            + "      <tr>\n"
                            + "          <th colspan=\"3\" style=\"text-align: center;font-size: large;\">" + p.getApplicationName() + "</th>\n"
                            + "      </tr>\n"
                            + "      <tr>\n"
                            + "          <th style=\"text-align: center;font-size: large;\">كود القائمة</th>\n"
                            + "          <th style=\"text-align: center;font-size: large;\">إسم القائمة</th>\n"
                            + "          <th style=\"text-align: center;font-size: large;\">الأيقونة</th>\n"
                            + "      </tr>\n"
                            + "  </thead>";
                    List<AppTabs> AppTabsList = new AppTabs_DAO().get_ApplicationTabsByApplicationId("" + p.getApplicationId());
                    if (AppTabsList.isEmpty()) {
                        HTML_TEXT += "<tbody><tr>\n"
                                + "      <td colspan=\"3\" style=\"text-align: center;font-size: large;\">لا توجد قوائم بهذا النظام</td>\n"
                                + "  </tr></tbody>";
                    } else {
                        HTML_TEXT += "<tbody>";
                        for (AppTabs a : AppTabsList) {
                            String TabFafaIcon = (a.getTabFafaIcon() == null) ? "" : a.getTabFafaIcon();

                            HTML_TEXT += "<tr>\n"
                                    + "      <td style=\"text-align: center;font-size: large;\">" + a.getId().getApplicationId() + "-" + a.getId().getTabId() + "</td>\n"
                                    + "      <td style=\"text-align: center;font-size: large;\">" + a.getTabName() + "</td>\n"
                                    + "      <td style=\"text-align: center;font-size: large;\" class='" + TabFafaIcon + "' > " + TabFafaIcon + " </td>\n"
                                    + "      <td style=\"font-weight: bold;\">"
                                    + " <button class=\"btn btn-success form-group fa fa-edit\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".UpdateAppTabs\" onclick=\"updateAppTabs(" + a.getId().getApplicationId() + "," + a.getId().getTabId() + ",'" + a.getTabName() + "','" + TabFafaIcon + "');\"  type=\"button\"></button>"
                                    + " <button class=\"btn btn-danger form-group fa fa-trash\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".DeleteAppTabs\" onclick=\"deleteAppTabs(" + a.getId().getApplicationId() + "," + a.getId().getTabId() + ");\" type=\"button\"></button>"
                                    + "      </td>\n";
                        }
                        HTML_TEXT += "</tbody>";
                    }

                }
            }

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
