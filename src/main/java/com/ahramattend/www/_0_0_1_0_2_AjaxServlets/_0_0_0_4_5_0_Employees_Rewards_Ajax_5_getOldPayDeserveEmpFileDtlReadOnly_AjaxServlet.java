/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeMaster_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_0_Employees_Rewards_Ajax_5_getOldPayDeserveEmpFileDtlReadOnly_AjaxServlet extends HttpServlet {

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

            String AjaxType = request.getParameter("AjaxType");
            String LocCode = request.getParameter("LocCode");
            String LocationCode = request.getParameter("LocationCode");
            String bandCode = request.getParameter("bandCode");
            String bandCode_Arr[] = bandCode.split("-");
            bandCode = bandCode_Arr[0];
            String bandType = bandCode_Arr[1];
            String month = request.getParameter("month");
            month = "01-" + month;
            DateOp dOp = new DateOp();
            String openMm = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "MM");
            String openYyyy = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "yyyy");

            String HTML_TEXT = "";

            int totalReward = 0;

            int out = 0;
            int in = 0;
            List<PayEmployeeMaster> pList = new PayEmployeeMaster_DAO().getPayEmployeeMasterByReward(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
            if (pList.isEmpty()) {
                response.getWriter().write("No Emp Dtl");
            } else {
                for (PayEmployeeMaster p : pList) {
                    String Color = "";
                    if (LocCode.equals(p.getPerEmploymentMasters().getPerLocationCodes().getId().getLocCode()) && LocationCode.equals(p.getPerEmploymentMasters().getPerLocationCodes().getId().getLocationCode())) {
                        /**
                         * Do Nothing
                         */
                        Color = "";
                        in++;
                    } else {
                        Color = "background-color: #ffbdbd;";
                        out++;
                    }
                    String DrlBtn = (!Color.equals("")) ? "<button type=\"button\" onclick=\"getEmpDetail('" + p.getEmployeeNo() + "')\" data-toggle=\"modal\" data-target=\".EmpDataDtl\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>" : "";

                    HTML_TEXT += "<tr class='E_" + p.getEmployeeNo() + "' style='" + Color + "'>\n";
                    HTML_TEXT += "         <td>" + DrlBtn + "</td>\n"
                            + "           <td style=\"text-align: center;" + Color + "\">" + p.getEmployeeNo() + "</td>\n"
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
                    Set<PayDeserveEmpFileDtl> pdefdList = p.getPayDeserveEmpFileDtlsForEmployeeId();

                    String val = "";
                    String accessSp = "";
                    for (PayDeserveEmpFileDtl f : pdefdList) {
                        val = "" + f.getVal();
                        totalReward = Integer.parseInt(val) + totalReward;
                        accessSp = "" + f.getId().getAccessSp()
                                + "-" + f.getId().getLocCode()
                                + "-" + f.getId().getLocationCode()
                                + "-" + f.getId().getBandCode()
                                + "-" + f.getId().getBandType()
                                + "-" + f.getId().getOpenMm()
                                + "-" + f.getId().getOpenYyyy();
                    }
                    HTML_TEXT += "       <td style=\"text-align: center;" + Color + "\">" + val + "</td>\n";
                    /*try {
                HTML_TEXT += "    <td>" + p.getPayFinancialGroupType().getGroupName() + "</td>\n";
            } catch (Exception ex) {
                HTML_TEXT += "    <td style='background-color: #ffbdbd;'>لا توجد مجموعة مالية</td>\n";
            }*/
                    HTML_TEXT += "       <td></td>\n"
                            + "</tr>";
                }

                if (AjaxType.equals("1")) {
                    response.getWriter().write(HTML_TEXT);
                } else {
                    int total = pList.size();
                    HTML_TEXT = total + "-" + in + "-" + out + "-" + totalReward;
                    response.getWriter().write(HTML_TEXT);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("");
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
