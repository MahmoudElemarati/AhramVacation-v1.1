/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ222;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ444;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppEmployeeReqJ444Id;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppReqTypeJ111;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_1_Jason_Entities.AppEmployeeReq_Jason;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppEmployeeReqJ222_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppEmployeeReqJ444_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppReqTypeJ111_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_5_0_0_General_App_Employee_Req_Ajax_3_sendRequest_AjaxServlet extends HttpServlet {

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
            // logic Business
            //List<PhotoInsertDataJasonFileClass> articles = new LinkedList<PhotoInsertDataJasonFileClass>();

            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article            
            AppEmployeeReq_Jason[] appEmployeeReq_Jason_arr = mapper.readValue(json, AppEmployeeReq_Jason[].class);

            HibernateSessionCon.beginTrans();

            // Deal With AppEmployeeReqJ222 (Master)
            AppEmployeeReqJ222 appEmployeeReqJ222 = new AppEmployeeReqJ222();
            for (AppEmployeeReq_Jason a : appEmployeeReq_Jason_arr) {
                if (a.getEmployee_type().equals("From")) {
                    // Sender Data
                    List<PerEmploymentMasters> pemList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNoAll(a.getEmployee_no());
                    if (pemList.isEmpty()) {
                        throw new Exception();
                    }
                    PerEmploymentMasters pem = pemList.get(0);
                    // 
                    List<AppReqTypeJ111> artList = new AppReqTypeJ111_DAO<>().getAppReqTypeByAppReqSeq(a.getAppReqType());
                    if (artList.isEmpty()) {
                        throw new Exception();
                    }
                    AppReqTypeJ111 art = artList.get(0);
                    long reqSp = new AppEmployeeReqJ222_DAO<>().getMaxAppEmployeeReq();
                    appEmployeeReqJ222 = new AppEmployeeReqJ222(reqSp, art, a.getEmployee_no());
                    appEmployeeReqJ222.setDoneDate(new DateOp().getSysDate());
                    appEmployeeReqJ222.setDoneDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    appEmployeeReqJ222.setRmrk(a.getMainRmrk());
                    appEmployeeReqJ222.setReqDate(new DateOp().getSysDate());
                    appEmployeeReqJ222.setReqDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    appEmployeeReqJ222.setChkView("1");
                    appEmployeeReqJ222.setPerEmploymentMasters(pem);
                    new AppEmployeeReqJ222_DAO().insert(appEmployeeReqJ222);
                }
            }

            //Deal With AppEmployeeReqJ444 (Detail)
            for (AppEmployeeReq_Jason a : appEmployeeReq_Jason_arr) {
                if (a.getEmployee_type().equals("To")) {
                    // Sender Data
                    List<PerEmploymentMasters> pemList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNoAll(a.getEmployee_no());
                    if (pemList.isEmpty()) {
                        throw new Exception();
                    }
                    PerEmploymentMasters pem = pemList.get(0);

                    AppEmployeeReqJ444Id id = new AppEmployeeReqJ444Id(appEmployeeReqJ222.getReqSp(), pem.getEmployeeId());
                    AppEmployeeReqJ444 appEmployeeReqJ444 = new AppEmployeeReqJ444(id, pem, appEmployeeReqJ222, a.getEmployee_no());
                    //appEmployeeReqJ444.setRmrk(a.getEmployee_rmrk());
                    new AppEmployeeReqJ444_DAO<>().insert(appEmployeeReqJ444);
                }
            }
            HibernateSessionCon.CommitTrans();
            // success
            response.getWriter().write("[ {\"Success\":\"Success\"} ]");
        } catch (Exception e) {
            HibernateSessionCon.RollBack();
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
