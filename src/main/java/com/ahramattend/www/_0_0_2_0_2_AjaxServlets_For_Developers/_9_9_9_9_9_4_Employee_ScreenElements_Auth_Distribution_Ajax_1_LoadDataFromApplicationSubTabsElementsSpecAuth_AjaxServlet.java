/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_2_0_2_AjaxServlets_For_Developers;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElem;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElemSpecAuth;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuth;
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
public class _9_9_9_9_9_4_Employee_ScreenElements_Auth_Distribution_Ajax_1_LoadDataFromApplicationSubTabsElementsSpecAuth_AjaxServlet extends HttpServlet {

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

            String applicationIdS = request.getParameter("applicationIdS");
            String applicationTabIdS = request.getParameter("applicationTabIdS");
            String applicationSubTabIdS_2 = request.getParameter("applicationSubTabIdS_2");
            String searchEmpId = request.getParameter("searchEmpId");
            String HTML_TEXT = "";// vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد

            List<PerEmploymentMasters> pemList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(searchEmpId);
            if (pemList.isEmpty()) {
                throw new Exception();
            }
            PerEmploymentMasters pem = pemList.get(0);

            List<AppSubElem> pList = new AppSubElem_DAO().getAll_ApplicationNameElementBySubTab(applicationIdS, applicationTabIdS, applicationSubTabIdS_2);
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"4\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (AppSubElem p : pList) {
                    List<AppSubElemSpecAuth> screenAuthList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuth(pem.getEmployeeId(), "" + p.getId().getApplicationId(), "" + p.getId().getTabId(), "" + p.getId().getSubTabId(), "" + p.getId().getElementId());
                    String checked;
                    int PrimaryAuthPass;

                    if (screenAuthList.isEmpty()) {
                        checked = "";
                        PrimaryAuthPass = 1;
                    } else {
                        checked = "checked";
                        AppSubElemSpecAuth astsa = screenAuthList.get(0);
                        PrimaryAuthPass = astsa.getPrimaryAuthPass();
                    }

                    boolean SubTabAvailablility = false;
                    boolean PrimaryAuthPassAvailablility = false;
                    List<AppSubTabSpecAuth> astsaList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(pem.getEmployeeId(), "" + p.getId().getApplicationId(), "" + p.getId().getTabId(), "" + p.getId().getSubTabId());
                    SubTabAvailablility = !(astsaList.isEmpty());

                    if (!astsaList.isEmpty()) {
                        AppSubTabSpecAuth astsa = astsaList.get(0);
                        PrimaryAuthPassAvailablility = (astsa.getPrimaryAuthPass() != 1);
                    }

                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\" class='sub_tab_element_id'>" + p.getId().getApplicationId() + "-" + p.getId().getTabId() + "-" + p.getId().getSubTabId() + "-" + p.getId().getElementId() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getElementName() + "</td>\n";

                    if (SubTabAvailablility) {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;\">"
                                + "                         <div class=\"\">\n"
                                + "                            <label>\n"
                                + "                              <input type=\"checkbox\" name='cheackBox1' class=\"js-switch\" " + checked + " />\n"
                                + "                            </label>\n"
                                + "                          </div>"
                                + "                     </td>\n";
                    } else {
                        HTML_TEXT += "                    <td><strong style='color: red;' class='fa fa-ban' name='cheackBox1'> No Access</strong></td>\n";
                    }

                    if (SubTabAvailablility && PrimaryAuthPassAvailablility) {
                        HTML_TEXT += "                     <td>"
                                + "                         <select style=\"font-size: 15px;font-weight: bold;\"  name=\"primaryAuthPass\" class=\"form-control\" >"
                                + "                             <option value='1' " + (PrimaryAuthPass == 1 ? "selected" : "") + ">private user Access</option>"
                                + "                             <option value='2' " + (PrimaryAuthPass == 2 ? "selected" : "") + ">public user Access</option>"
                                + "                         </select>"
                                + "                     </td>";
                    } else {
                        HTML_TEXT += "                    <td><strong style='color: red;' class='fa fa-ban'  name=\"primaryAuthPass\"> No Access</strong></td>";
                    }
                    HTML_TEXT += "</tr>\n";
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
