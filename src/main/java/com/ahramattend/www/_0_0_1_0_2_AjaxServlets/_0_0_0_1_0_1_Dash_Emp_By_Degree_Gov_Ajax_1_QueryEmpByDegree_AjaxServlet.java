/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFiscalDegreeCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerLocationCodes;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFiscalDegreeCode_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerLocationCodes_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_1_0_1_Dash_Emp_By_Degree_Gov_Ajax_1_QueryEmpByDegree_AjaxServlet extends HttpServlet {

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
            String cadreDegreeCode = request.getParameter("cadreDegreeCode");
            String generalCode = request.getParameter("generalCode");
            String locationCode = request.getParameter("locationCode");
            //System.out.println(">>>>>> cadreDegreeCode = " + cadreDegreeCode);
            //System.out.println(">>>>>> generalCode = " + generalCode);
            //System.out.println(">>>>>> locationCode = " + locationCode);

            Writer writer = response.getWriter();
            request.getSession().setAttribute("_0_0_0_1_0_1_Loading", 10);
            //System.out.println(">>>  Starting");

            String generalCode1 = "";
            if (generalCode.equals("1")) {
                generalCode1 = "";
            } else if (generalCode.equals("2")) {
                generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode!=20 and ";
            } else if (generalCode.equals("3")) {
                generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode=20 and ";
            }

            ////////////////////////////////// Header //////////////////////////////////////////
            String HTML_Header = "<thead style=\"background-color: #337ab7;color: white;width: 100%;\">"
                    + "    <tr>\n"
                    + "         <th style=\"text-align: center;font-size: 15px;\"></th>";
            List<PerFiscalDegreeCode> FList = new PerFiscalDegreeCode_DAO().getAllPerFiscalDegreeCode(cadreDegreeCode);
            for (PerFiscalDegreeCode p : FList) {
                HTML_Header += "<th style=\"text-align: center;font-size: 15px;\">" + p.getFiscalDegreeName() + "<br>(ذكر)</th>\n"
                        + "     <th style=\"text-align: center;font-size: 15px;\">" + p.getFiscalDegreeName() + "<br>(انثى)</th>";
            }
            HTML_Header += "    <th style=\"text-align: center;font-size: 15px;border-style: solid;border-color: black;\">اجمالي<br>الذكور </th>\n"
                    + "         <th style=\"text-align: center;font-size: 15px;border-style: solid;border-color: black;\">اجمالي<br> الاناث</th>\n"
                    + "    </tr>\n"
                    + "</thead>";
            writer.write(HTML_Header);
            ////////////////////////////////// End Header //////////////////////////////////////////

            ////////////////////////////////// Body //////////////////////////////////////////
            String HTML_Body = "<tbody>\n"
                    + "           <tr>\n"
                    + "               <td style=\"text-align: center;font-size: 15px;width: 10%;background: grey;font-weight: bold;\">*الاجمالي العام</td>";
            int FullMaleCountByDegree = 0;
            int FullFemaleCountByDegree = 0;
            for (PerFiscalDegreeCode p : FList) {
                List<PerEmploymentMasters> emList = new PerEmploymentMasters_DAO().getEmployeesByMaleEmployeeByFiscalDegree(p.getFiscalDegreeCode(), locationCode, generalCode1, cadreDegreeCode);
                FullMaleCountByDegree = emList.size();
                List<PerEmploymentMasters> efList = new PerEmploymentMasters_DAO().getEmployeesByFemaleEmployeeByFiscalDegree(p.getFiscalDegreeCode(), locationCode, generalCode1, cadreDegreeCode);
                FullFemaleCountByDegree = efList.size();
                HTML_Body += "        <td style=\"text-align: center;font-size: 15px;width: 10%;background: grey;font-weight: bold;\">" + FullMaleCountByDegree + "</td>\n"
                        + "           <td style=\"text-align: center;font-size: 15px;width: 10%;background: grey;font-weight: bold;\">" + FullFemaleCountByDegree + "</td> ";
            }
            HTML_Body += "            <td style=\"text-align: center;font-size: 15px;width: 10%;background: grey;font-weight: bold;border-style: solid;border-color: black;\"></td>\n"
                    + "               <td style=\"text-align: center;font-size: 15px;width: 10%;background: grey;font-weight: bold;border-style: solid;border-color: black;\"></td>\n"
                    + "             </tr>";
            writer.write(HTML_Body);

            int MaleCount = 0;
            int FemaleCount = 0;
            List<PerLocationCodes> LList = new PerLocationCodes_DAO().getAllPerLocationCodesBylocationCode(locationCode);
            int size = LList.size();
            int i = 0;
            for (PerLocationCodes l : LList) {

                String locCode = l.getId().getLocCode();
                HTML_Body = "      <tr>\n"
                        + "           <td style=\"text-align: center;font-size: 15px;width: 15%;\">" + l.getLocName() + "</td>";
                int FullMaleCountByLoc = 0;
                int FullFemaleCountByLoc = 0;
                for (PerFiscalDegreeCode p : FList) {
                    String FiscalDegreeCode = p.getFiscalDegreeCode();
                    List<PerEmploymentMasters> eList = new PerEmploymentMasters_DAO().getEmployeesByMaleEmployeeByLocationCode(locCode, FiscalDegreeCode, locationCode, generalCode1, cadreDegreeCode);
                    MaleCount = eList.size();
                    FullMaleCountByLoc += MaleCount;
                    HTML_Body += "   <td style=\"text-align: center;font-size: 15px;\">" + MaleCount + "</td>";
                    List<PerEmploymentMasters> efList = new PerEmploymentMasters_DAO().getEmployeesByFemaleEmployeeByLocationCode(locCode, FiscalDegreeCode, locationCode, generalCode1, cadreDegreeCode);
                    FemaleCount = efList.size();
                    FullFemaleCountByLoc += FemaleCount;
                    HTML_Body += "   <td style=\"text-align: center;font-size: 15px;\">" + FemaleCount + "</td>";
                }
                HTML_Body += "       <td style=\"text-align: center;font-size: 15px;background: grey;font-weight: bold;border-style: solid;border-color: black;\">" + FullMaleCountByLoc + "</td>\n"
                        + "          <td style=\"text-align: center;font-size: 15px;background: grey;font-weight: bold;border-style: solid;border-color: black;\">" + FullFemaleCountByLoc + "</td>\n"
                        + "        </tr>";
                writer.write(HTML_Body);
                //String message = "جاري تحميل البيانات " + i + "من " + size + "";
                int message = (int) ((i * 100.0) / size);
                if (message > 10) {
                    request.getSession().setAttribute("_0_0_0_1_0_1_Loading", message);
                }

                i++;
            }
            HTML_Body = "</tbody>";
            writer.write(HTML_Body);
            ////////////////////////////////// End Body //////////////////////////////////////////

            request.getSession().removeAttribute("_0_0_0_1_0_1_Loading");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
            //request.getSession().removeAttribute("Loading");
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
