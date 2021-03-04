/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.BudLocation;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheet;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetImageDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionSheetImageDtlId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionTypeCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDesicionSideCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpDecisionSheet;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpDecisionSheetId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.BudLocation_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionSheetImageDtl_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionSheet_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionTypeCode_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDesicionSideCode_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_1_0_3_JasonFiles._0_0_0_4_0_0_PerDecisionSheet_1_JasonFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_4_0_0_document_scan_Ajax_2_AddToPerDecisionSheet_AjaxServlet extends HttpServlet {

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
            String locationCode = "0";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile perDecisionSheet_1_JasonFile = mapper.readValue(json, _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.class);

            String decisionNo = perDecisionSheet_1_JasonFile.getDecisionNo();
            String decisionTypeCode = perDecisionSheet_1_JasonFile.getDecisionTypeCode();
            String desicionSideCode = perDecisionSheet_1_JasonFile.getDesicionSideCode();
            String decisionSubject = perDecisionSheet_1_JasonFile.getDecisionSubject();
            String decisionSummary = perDecisionSheet_1_JasonFile.getDecisionSummary();
            List<String> perEmpDecisionSheets = perDecisionSheet_1_JasonFile.getPerEmpDecisionSheets();
            List<String> perDecisionSheetImageDtl = perDecisionSheet_1_JasonFile.getPerDecisionSheetImageDtl();//request.getParameterValues("src");

            /**
             * التأكد من أن رقم القرار غير موجود من قبل
             */
            List<PerDecisionSheet> pdsList = new PerDecisionSheet_DAO().getPerDecisionSheetByDecisionNo(decisionNo);
            if (pdsList.size() > 0) {
                throw new Exception("1258");
            }

            long decisionId = new PerDecisionSheet_DAO().getMaxPerDecisionSheet(locationCode);

            List<PerDecisionTypeCode> pdtcList = new PerDecisionTypeCode_DAO().getallPerDecisionTypeCodeById(decisionTypeCode);
            if (pdtcList.isEmpty()) {
                throw new Exception();
            }
            PerDecisionTypeCode pdtc = pdtcList.get(0);

            List<PerDesicionSideCode> pdscList = new PerDesicionSideCode_DAO().getallPerDesicionSideCodeById(desicionSideCode);
            if (pdscList.isEmpty()) {
                throw new Exception();
            }
            PerDesicionSideCode pdsc = pdscList.get(0);

            List<BudLocation> blList = new BudLocation_DAO().getِAllBudLocationByID(locationCode);
            if (blList.isEmpty()) {
                throw new Exception();
            }
            BudLocation bl = blList.get(0);

            Date currentDate = new DateOp().getSysDate();
            PerDecisionSheetId id = new PerDecisionSheetId(bl.getLocationCode(), "" + decisionId);
            PerDecisionSheet pds = new PerDecisionSheet(id, bl, pdtc, pdsc, decisionNo, currentDate);
            pds.setDecisionSubject(decisionSubject);
            pds.setDecisionSummary(decisionSummary);
            PerDecisionSheet_DAO pdscDao = new PerDecisionSheet_DAO();

            //System.out.println(" ---- Data ----");
            //System.out.println("           >>>> decisionId       : " + decisionId);
            //System.out.println("           >>>> decisionNo       : " + decisionNo);
            //System.out.println("           >>>> decisionTypeCode : " + decisionTypeCode);
            //System.out.println("           >>>> desicionSideCode : " + desicionSideCode);
            //System.out.println("           >>>> decisionSubject  : " + decisionSubject);
            //System.out.println("           >>>> decisionSummary  : " + decisionSummary);
            //System.out.println("           >>>> decisionSummary  : " + decisionSummary);
            //System.out.println("           >>>> Employees Size   : " + perEmpDecisionSheets.size());
            for (String p : perEmpDecisionSheets) {
                //System.out.println("                                    - : " + p);
            }
            //System.out.println("           >>>> Photo Size       : " + perDecisionSheetImageDtl.size());

            HibernateSessionCon.beginTrans();

            /**
             * يضيف القرار نفسه
             */
            pdscDao.save(pds);
            /**
             * تسكين الموظفين على القرار
             */
            for (String p : perEmpDecisionSheets) {
                List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNo(p);
                if (pList.isEmpty()) {
                    throw new Exception();
                }
                PerEmploymentMasters pem = pList.get(0);

                PerEmpDecisionSheetId pedsId = new PerEmpDecisionSheetId(locationCode, "" + decisionId, pem.getEmployeeId());

                PerEmpDecisionSheet peds = new PerEmpDecisionSheet(pedsId, pds, pem);
                pdscDao.insert(peds);
            }
            /**
             * تسكين الصور على القرار
             */
            for (int i = 0; i < perDecisionSheetImageDtl.size(); i += 2) {
                String p = perDecisionSheetImageDtl.get(i) + ";" + perDecisionSheetImageDtl.get(i + 1);
                long imageSp = new PerDecisionSheetImageDtl_DAO().getMaxPerDecisionSheetImageDtl("" + decisionId, locationCode);
                PerDecisionSheetImageDtlId pedsId = new PerDecisionSheetImageDtlId("" + decisionId, locationCode, imageSp);
                PerDecisionSheetImageDtl peds = new PerDecisionSheetImageDtl(pedsId, pds, p);
                pdscDao.insert(peds);
            }

            HibernateSessionCon.CommitTrans();
            HibernateSessionCon.session.clear();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            String message = e.getMessage();
            if (message.equals("1258")) {
                response.getWriter().write("رقم القرار مسجل من قبل");
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
