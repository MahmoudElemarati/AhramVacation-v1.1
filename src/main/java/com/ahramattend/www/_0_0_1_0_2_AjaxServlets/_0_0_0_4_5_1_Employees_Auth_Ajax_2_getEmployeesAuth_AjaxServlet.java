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
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayExecutionDate;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTabSpecAuth_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTab_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayExecutionDate_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_1_Employees_Auth_Ajax_2_getEmployeesAuth_AjaxServlet extends HttpServlet {

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
            String HTML_TEXT = "";
            String FullAuthControl = "0";
            PerEmploymentMasters employee_session_user = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");

            String employee_no = request.getParameter("employee_no");
            List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(employee_no);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PerEmploymentMasters employee_session_auth = pList.get(0);
            String employee_id_auth = employee_session_auth.getEmployeeId();//the one who want to give him auth
            String employee_id_user = employee_session_user.getEmployeeId();// the Giver

            if (employee_id_auth.equals(employee_id_user)) {
                FullAuthControl = "3";
            }

            List<AppSubTab> astList = new AppSubTab_DAO().getAllApplicationSubTabsAvailableToGive(employee_id_user);
            if (astList.isEmpty()) {
                HTML_TEXT = "<tr><td colspan='4'>لا توجد شاشات متاحة لك لإعطاء الصلاحية لموظفين آخرين</td></tr>";
            } else {
                for (AppSubTab ast : astList) {
                    List<String> status = getSubTabStatus(employee_id_auth, "" + ast.getId().getApplicationId(), "" + ast.getId().getTabId(), "" + ast.getId().getSubTabId());
                    String checked = status.get(0);
                    String primaryAuthPass2 = status.get(1);
                    if (FullAuthControl.equals("1")) {
                        HTML_TEXT += "<tr>"
                                + "     <td class='sub_tab_id2'>" + ast.getId().getApplicationId() + "-" + ast.getId().getTabId() + "-" + ast.getId().getSubTabId() + "</td>"
                                + "     <td>" + ast.getSubTabName() + "</td>";
                        HTML_TEXT += "  <td>"
                                + "          <div class=\"\">\n"
                                + "             <label>\n"
                                + "               <input type=\"checkbox\" name='cheackBox2' class=\"js-switch\" " + checked + " />\n"
                                + "             </label>\n"
                                + "           </div>"
                                + "     </td>\n"
                                + "     <td>"
                                + "         <select style=\"font-size: 15px;font-weight: bold;\"  name=\"primaryAuthPass2\" class=\"form-control\" >"
                                + "             <option value='1' " + (primaryAuthPass2.equals("1") ? "selected" : "") + ">private user Access</option>"
                                + "             <option value='2' " + (primaryAuthPass2.equals("2") ? "selected" : "") + ">public user Access</option>"
                                + "         </select>"
                                + "     </td>\n";
                        HTML_TEXT += "</tr>";
                    } else if (FullAuthControl.equals("0")) {
                        HTML_TEXT += "<tr>"
                                + "     <td class='sub_tab_id2'>" + ast.getId().getApplicationId() + "-" + ast.getId().getTabId() + "-" + ast.getId().getSubTabId() + "</td>"
                                + "     <td>" + ast.getSubTabName() + "</td>";
                        HTML_TEXT += "  <td>"
                                + "          <div class=\"\">\n"
                                + "             <label>\n"
                                + "               <input type=\"checkbox\" name='cheackBox2' class=\"js-switch\" " + checked + " />\n"
                                + "             </label>\n"
                                + "           </div>"
                                + "     </td>\n";
                        HTML_TEXT += "  <td>ليس بالإمكان إعطاء صلاحية للغير</td>"
                                + "  </tr>";
                    } else if (FullAuthControl.equals("3")) {
                        HTML_TEXT += "<tr>"
                                + "     <td class='sub_tab_id2'>" + ast.getId().getApplicationId() + "-" + ast.getId().getTabId() + "-" + ast.getId().getSubTabId() + "</td>"
                                + "     <td>" + ast.getSubTabName() + "</td>";
                        HTML_TEXT += "  <td> ✓ </td>\n";
                        HTML_TEXT += "  <td>"+(primaryAuthPass2.equals("2") ? "بالإمكان إعطاء صلاحية للغير" : "ليس بالإمكان إعطاء صلاحية للغير")+"</td>"
                                + "  </tr>";
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

    private List<String> getSubTabStatus(String employeeId, String ApplicationId, String TabId, String SubTabId) {
        List<String> status = new ArrayList<>();
        List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(employeeId, ApplicationId, TabId, SubTabId);

        String checked = "";
        String primaryAuthPass2;
        if (screenAuthList.isEmpty()) {
            checked = "";
            primaryAuthPass2 = "1";
        } else {
            checked = "checked";
            AppSubTabSpecAuth astsa = screenAuthList.get(0);
            primaryAuthPass2 = "" + astsa.getPrimaryAuthPass();
        }
        status.add(checked);
        status.add(primaryAuthPass2);
        return status;
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
