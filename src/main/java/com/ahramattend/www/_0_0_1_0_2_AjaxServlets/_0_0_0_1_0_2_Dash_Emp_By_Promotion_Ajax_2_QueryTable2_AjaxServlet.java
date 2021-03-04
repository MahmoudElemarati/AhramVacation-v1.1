/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpPromotion;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpPromotionNew;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpPromotion_DAO;
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
public class _0_0_0_1_0_2_Dash_Emp_By_Promotion_Ajax_2_QueryTable2_AjaxServlet extends HttpServlet {

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
            String jobLaw = request.getParameter("jobLaw");
            String PromotionType = request.getParameter("PromotionType");
            String PostDate = request.getParameter("PostDate");
            //System.out.println(">>>>>> jobLaw = " + jobLaw);
            //System.out.println(">>>>>> PromotionType = " + PromotionType);
            //System.out.println(">>>>>> PostDate = " + PostDate);

            Writer writer = response.getWriter();
            request.getSession().setAttribute("_0_0_0_1_0_2_Loading2", 10);
            //System.out.println(">>>  Starting");
            String HTML_Body = "";
            List<PerEmpPromotionNew> pList = new PerEmpPromotion_DAO().getAllPerEmpPromotion(jobLaw, PromotionType, PostDate);
            if (pList.isEmpty()) {
                HTML_Body = "<tr>\n"
                        + "     <td colspan=\"18\" style=\"text-align: center;font-size: 15px;\">لا توجد بيانات</td>\n"
                        + "  </tr>";
                writer.write(HTML_Body);
            } else {
                int size = pList.size();
                int i = 0;
                for (PerEmpPromotionNew p : pList) {

                    HTML_Body = "";
                    String EmployeeNo, EmpAname, PromotionDate;
                    try {
                        EmployeeNo = "" + p.getPerEmploymentMasters().getEmployeeNo();
                    } catch (Exception ex) {
                        EmployeeNo = "";
                    }
                    try {
                        EmpAname = "" + p.getPerEmploymentMasters().getEmpAname();
                    } catch (Exception ex) {
                        EmpAname = "";
                    }
                    try {
                        PromotionDate = "" + p.getPerPromotionTransNew().getPromotionDate();
                    } catch (Exception ex) {
                        PromotionDate = "";
                    }

                    String GroupTypeName, GroupTypeNameNew;
                    try {
                        GroupTypeName = "" + p.getPerGroupTypeCodeByGroupTypeCode().getGroupTypeName();
                    } catch (Exception ex) {
                        GroupTypeName = "";
                    }
                    try {
                        GroupTypeNameNew = "" + p.getPerGroupTypeCodeByGroupTypeCodeNew().getGroupTypeName();
                    } catch (Exception ex) {
                        GroupTypeNameNew = "";
                    }
                    String FiscalDegreeName, FiscalDegreeNameNew;
                    try {
                        FiscalDegreeName = "" + p.getPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew().getFiscalDegreeNameNew();
                    } catch (Exception ex) {
                        FiscalDegreeName = "";
                    }
                    try {
                        FiscalDegreeNameNew = "" + p.getPerFiscalDegreeCodeNewByFiscalDegreeCodeNewNew().getFiscalDegreeNameNew();
                    } catch (Exception ex) {
                        FiscalDegreeNameNew = "";
                    }
                    String DegreeDate, DegreeDateNew;
                    try {
                        DegreeDate = "" + p.getDegreeDate();
                    } catch (Exception ex) {
                        DegreeDate = "";
                    }
                    try {
                        DegreeDateNew = "" + p.getDegreeDateNew();
                    } catch (Exception ex) {
                        DegreeDateNew = "";
                    }
                    String DegreePriorityDate;
                    try {
                        DegreePriorityDate = "" + p.getDegreePriorityDate();
                    } catch (Exception ex) {
                        DegreePriorityDate = "";
                    }
                    String EmpJobFlag, EmpJobFlagNew, FlagResulte, FlagResulteNew;
                    try {
                        EmpJobFlag = "" + p.getEmpJobFlag();
                    } catch (Exception ex) {
                        EmpJobFlag = "";
                    }
                    if (EmpJobFlag.equals("1")) {
                        FlagResulte = "نعم";
                    } else {
                        FlagResulte = "لا";
                    }

                    try {
                        EmpJobFlagNew = "" + p.getEmpJobFlagNew();
                    } catch (Exception ex) {
                        EmpJobFlagNew = "";
                    }
                    if (EmpJobFlagNew.equals("1")) {
                        FlagResulteNew = "نعم";
                    } else {
                        FlagResulteNew = "لا";
                    }
                    String JobName, JobNameNew;
                    try {
                        JobName = "" + p.getPerJobCodeByJobCode().getJobName();
                    } catch (Exception ex) {
                        JobName = "";
                    }
                    try {
                        JobNameNew = "" + p.getPerJobCodeByJobCodeNew().getJobName();
                    } catch (Exception ex) {
                        JobNameNew = "";
                    }
                    String JobDate, JobDateNew;
                    try {
                        JobDate = "" + p.getJobDate();
                    } catch (Exception ex) {
                        JobDate = "";
                    }
                    try {
                        JobDateNew = "" + p.getJobDateNew();
                    } catch (Exception ex) {
                        JobDateNew = "";
                    }
                    String Sal, SalAfter;
                    try {
                        Sal = "" + p.getSal();
                    } catch (Exception ex) {
                        Sal = "";
                    }
                    try {
                        SalAfter = "" + p.getSalAfter();
                    } catch (Exception ex) {
                        SalAfter = "";
                    }
                    HTML_Body += "<tr>"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + EmployeeNo + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + EmpAname + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + PromotionDate + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + GroupTypeName + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + GroupTypeNameNew + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + FiscalDegreeName + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + FiscalDegreeNameNew + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + DegreeDate + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + DegreeDateNew + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + DegreePriorityDate + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\"></td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + FlagResulte + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + FlagResulteNew + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + JobName + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + JobNameNew + "</td>"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + JobDate + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;background-color: #cccccc;\">" + JobDateNew + "</td>"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + Sal + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + p.getElawaVal() + "</td>\n"
                            + "     <td style=\"text-align: center;font-size: 15px;\">" + SalAfter + "</td>\n"
                            + "</tr>";
                    writer.write(HTML_Body);
                    int message = (int) ((i * 100.0) / size);
                    if (message > 10) {
                        request.getSession().setAttribute("_0_0_0_1_0_2_Loading2", message);
                    }

                    i++;
                }
            }
            ////////////////////////////////// End Body //////////////////////////////////////////

            request.getSession().removeAttribute("_0_0_0_1_0_2_Loading2");

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
