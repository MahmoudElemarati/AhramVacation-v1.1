/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFacultyCode;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerQualClass;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFacultyCode_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerQualClass_DAO;
import com.ahramattend.www._0_0_1_0_3_JasonFiles._0_0_0_1_bars_DashBoard_class1;
import com.ahramattend.www._0_0_1_0_3_JasonFiles._0_0_0_1_bars_DashBoard_class2;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_Ajax_0_getdataAnalysis_AjaxServlet extends HttpServlet {

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
            String SearchType = request.getParameter("SearchType");//1 - use OrgId // 2 - use FiscalDegreeCode

            switch (SearchType) {
                case "1":
                    plotByOrg(request, response);
                    break;
                case "2":
                    plotByFaculty(request, response);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    private void plotByOrg(HttpServletRequest request, HttpServletResponse response) {
        try {
            String generalCode = request.getParameter("generalCode");
            String locationCode = request.getParameter("locationCode");
            String sexFlag = request.getParameter("sexFlag");
            String QualClassCode = request.getParameter("QualClassCode");

            String generalCode1 = "";
            switch (generalCode) {
                case "1":
                    generalCode1 = "";
                    break;
                case "2":
                    generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode!=20 and ";
                    break;
                case "3":
                    generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode=20 and ";
                    break;
                default:
                    break;
            }

            List<_0_0_0_1_bars_DashBoard_class1> mainData = new LinkedList<_0_0_0_1_bars_DashBoard_class1>();
            _0_0_0_1_bars_DashBoard_class1 s = new _0_0_0_1_bars_DashBoard_class1();

            request.getSession().setAttribute("_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_Loading_1", "0");

            List<String> parts = new LinkedList<String>();
            List<PerFacultyCode> PerFacultyCodeList = new PerFacultyCode_DAO().getAllPerFacultyCode();
            for (PerFacultyCode p : PerFacultyCodeList) {
                parts.add(p.getFacultyName());
            }
            s.setParts(parts);

            //***** Get All Genders
            List<_0_0_0_1_bars_DashBoard_class2> GenderList = new LinkedList<_0_0_0_1_bars_DashBoard_class2>();
            List<String> gList = new ArrayList<String>();
            if (sexFlag.equals("male")) {
                gList.add("1");
            } else if (sexFlag.equals("female")) {
                gList.add("2");
            } else {
                gList.add("1");
                gList.add("2");
            }

            int i = 0;
            int size = gList.size() * parts.size();
            for (String gender : gList) {
                _0_0_0_1_bars_DashBoard_class2 Gender = new _0_0_0_1_bars_DashBoard_class2();

                String gender_name = (gender.equals("1")) ? "ذكر" : "أنثى";

                Gender.setData_name(gender_name);

                List<String> values = new LinkedList<String>();
                for (PerFacultyCode p : PerFacultyCodeList) {
                    HibernateSessionCon.session.clear();
                    long val = new PerEmploymentMasters_DAO<>().getGenderCountPerFacultyAndQualClass(gender, p.getFacultyCode(), QualClassCode, locationCode, generalCode1);
                    values.add("" + val);

                    i++;
                    String message = "" + (int) ((i * 100.0) / size);
                    request.getSession().setAttribute("_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_Loading_1", message);
                }
                Gender.setValues(values);
                GenderList.add(Gender);
            }
            s.setData_list(GenderList);
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 4. Set response type to JSON
            response.setContentType("application/json");
            mainData.add(s);

            String json = mapper.writeValueAsString(mainData);
            //System.out.println(json);
            // 6. Send List<Article> as JSON to client
            mapper.writeValue(response.getOutputStream(), mainData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void plotByFaculty(HttpServletRequest request, HttpServletResponse response) {

        try {
            String generalCode = request.getParameter("generalCode");
            String locationCode = request.getParameter("locationCode");
            String sexFlag = request.getParameter("sexFlag");
            String FacultyCode = request.getParameter("FacultyCode");

            String generalCode1 = "";
            switch (generalCode) {
                case "1":
                    generalCode1 = "";
                    break;
                case "2":
                    generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode!=20 and ";
                    break;
                case "3":
                    generalCode1 = "p.perGeneralCodeByGeneralCode.generalCode=20 and ";
                    break;
                default:
                    break;
            }

            List<_0_0_0_1_bars_DashBoard_class1> mainData = new LinkedList<_0_0_0_1_bars_DashBoard_class1>();
            _0_0_0_1_bars_DashBoard_class1 s = new _0_0_0_1_bars_DashBoard_class1();

            request.getSession().setAttribute("_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_Loading_1", "0");

            List<String> parts = new LinkedList<String>();
            List<PerQualClass> PerQualClassList = new  PerQualClass_DAO().getAllPerQualClasses();
            for (PerQualClass p : PerQualClassList) {
                parts.add(p.getQualClassName());
            }
            s.setParts(parts);

            //***** Get All Genders
            List<_0_0_0_1_bars_DashBoard_class2> GenderList = new LinkedList<_0_0_0_1_bars_DashBoard_class2>();
            List<String> gList = new ArrayList<String>();
            if (sexFlag.equals("male")) {
                gList.add("1");
            } else if (sexFlag.equals("female")) {
                gList.add("2");
            } else {
                gList.add("1");
                gList.add("2");
            }

            int i = 0;
            int size = gList.size() * parts.size();
            for (String gender : gList) {
                _0_0_0_1_bars_DashBoard_class2 Gender = new _0_0_0_1_bars_DashBoard_class2();

                String gender_name = (gender.equals("1")) ? "ذكر" : "أنثى";

                Gender.setData_name(gender_name);

                List<String> values = new LinkedList<String>();
                for (PerQualClass p : PerQualClassList) {
                    HibernateSessionCon.session.clear();
                    long val = new PerEmploymentMasters_DAO<>().getGenderCountPerFacultyAndQualClass(gender, FacultyCode, p.getQualClassCode(), locationCode, generalCode1);
                    values.add("" + val);

                    i++;
                    String message = "" + (int) ((i * 100.0) / size);
                    request.getSession().setAttribute("_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_Loading_1", message);
                }
                Gender.setValues(values);
                GenderList.add(Gender);
            }
            s.setData_list(GenderList);
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 4. Set response type to JSON
            response.setContentType("application/json");
            mainData.add(s);

            String json = mapper.writeValueAsString(mainData);
            //System.out.println(json);
            // 6. Send List<Article> as JSON to client
            mapper.writeValue(response.getOutputStream(), mainData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
