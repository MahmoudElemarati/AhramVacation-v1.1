/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeMaster_DAO;
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
public class _0_0_0_4_5_0_Employees_Rewards_Ajax_1_getEmployeeData_AjaxServlet extends HttpServlet {

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

            String typeSearch = request.getParameter("typeSearch");
            String employeeId = request.getParameter("employeeId");

            String HTML_TEXT = "";
            List<PerEmploymentMasters> ppList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(employeeId);
            if (typeSearch.equals("1")) {// استعلام عن موظف بالاسم فقط

                if (ppList.isEmpty()) {
                    throw new Exception("لا توجد بيانات موظف");
                }
                /*List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNoAndLoc(employeeId, LocCode, LocationCode);
                if (pList.isEmpty()) {
                    throw new Exception("هذا الموظف غير مسكن بالفرع");
                }*/
                PerEmploymentMasters p = ppList.get(0);
                HTML_TEXT = p.getEmpAname();
            } else if (typeSearch.equals("3")) {//تفاصيل المودل للموظف
                PerEmploymentMasters p = ppList.get(0);
                HTML_TEXT += "<tr>\n"
                        + "           <td>" + p.getEmployeeNo() + "</td>\n"
                        + "           <td>" + p.getEmpAname() + "</td>\n";
                try {
                    HTML_TEXT += "    <td>" + p.getPerLocationCodes().getLocName() + "</td>\n";
                } catch (Exception ex) {
                    HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا يوجد موقع</td>\n";
                }
                try {
                    HTML_TEXT += "    <td>" + p.getPerOrganizationStructureByOrgId().getOrgName() + "</td>\n";
                } catch (Exception ex) {
                    HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا توجد إدارة</td>\n";
                }
                HTML_TEXT += "</tr>";
            } else if (typeSearch.equals("2")) {// جدول المكافآت 
                String LocCode = request.getParameter("LocCode");
                String LocationCode = request.getParameter("LocationCode");
                if (ppList.isEmpty()) {
                    throw new Exception("لا توجد بيانات موظف");
                }
                PerEmploymentMasters pp = ppList.get(0);
                String Color = "";
                if (LocCode.equals(pp.getPerLocationCodes().getId().getLocCode()) && LocationCode.equals(pp.getPerLocationCodes().getId().getLocationCode())) {
                    /**
                     * Do Nothing
                     */
                    Color = "";
                } else {
                    LocCode = pp.getPerLocationCodes().getId().getLocCode();
                    LocationCode = pp.getPerLocationCodes().getId().getLocationCode();
                    Color = "background-color: #ffbdbd;";
                }
                String rewardValue = request.getParameter("rewardValue");
                List<PayEmployeeMaster> pList = new PayEmployeeMaster_DAO().getPayEmployeeMasterByNoAndLoc(employeeId, LocCode, LocationCode);
                if (pList.isEmpty()) {
                    throw new Exception();
                }
                PayEmployeeMaster p = pList.get(0);
                String DrlBtn = (!Color.equals("")) ? "<button type=\"button\" onclick=\"getEmpDetail('" + p.getEmployeeNo() + "')\" data-toggle=\"modal\" data-target=\".EmpDataDtl\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>" : "";

                HTML_TEXT = "<tr class='E_" + p.getEmployeeNo() + "' style='" + Color + "'>\n";
                HTML_TEXT += "         <td>" + DrlBtn + "</td>\n"
                        + "           <td><input style=\"text-align: center;" + Color + "\" name=\"empIds\" type=\"text\" class=\"form-control-custom empIdsClass\" value=\"" + p.getEmployeeNo() + "\" readonly=\"\"></td>\n"
                        + "           <td>" + p.getEmpAname() + "</td>\n"
                        + "           <td>" + p.getPerEmploymentMasters().getNationalNo() + "</td>\n";
                /*try {
                    HTML_TEXT += "    <td>" + p.getPerEmploymentMasters().getPerOrganizationStructureByOrgId().getOrgName() + "</td>\n";
                } catch (Exception ex) {
                    HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا توجد إدارة</td>\n";
                }
                try {
                    HTML_TEXT += "    <td>" + p.getPerEmploymentMasters().getPerFiscalDegreeCode().getFiscalDegreeName() + "</td>\n";
                } catch (Exception ex) {
                    HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا توجد درجة مالية</td>\n";
                }*/
                HTML_TEXT += "       <td><input style=\"text-align: center;" + Color + "\" name=\"rewardValues\" type=\"text\" class=\"form-control-custom\" value=\"" + rewardValue + "\" readonly=\"\"></td>\n";
                /*try {
                    HTML_TEXT += "    <td>" + p.getPayFinancialGroupType().getGroupName() + "</td>\n";
                } catch (Exception ex) {
                    HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا توجد مجموعة مالية</td>\n";
                }*/
                HTML_TEXT += "       <td><button type=\"button\" onclick=\"Delete('*','" + p.getEmployeeNo() + "')\" class=\"fa fa-trash btn btn-danger\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button></td>\n"
                        + "</tr>";
            } 

            response.getWriter().write(HTML_TEXT);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
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
