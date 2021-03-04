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
import com.ahramattend.www._0_0_0_2_1_Jason_Entities.AppEmployeeReq_Jason;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppEmployeeReqJ222_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppEmployeeReqJ444_DAO;
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
public class _0_0_0_5_0_0_General_App_Employee_Req_Ajax_5_getDetails_AjaxServlet extends HttpServlet {

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
            AppEmployeeReq_Jason appEmployeeReq_Jason = mapper.readValue(json, AppEmployeeReq_Jason.class);
            String reqSp = appEmployeeReq_Jason.getReqSp();

            List<AppEmployeeReqJ444> aerdList = new AppEmployeeReqJ444_DAO().getAppEmployeeReqJ444ByReqSp(reqSp);

            AppEmployeeReq_Jason[] appEmployeeReq_Jason_arr = new AppEmployeeReq_Jason[aerdList.size()];

            int i = 0;
            for (AppEmployeeReqJ444 aerd : aerdList) {
                AppEmployeeReq_Jason appEmployeeReq_Jason2 = new AppEmployeeReq_Jason();
                appEmployeeReq_Jason2.setEmployee_no(aerd.getEmployeeNo());
                appEmployeeReq_Jason2.setEmployee_name(aerd.getPerEmploymentMasters().getEmpAname());
                if (aerd.getSendDate() != null) {
                    appEmployeeReq_Jason2.setSendDate(new DateOp().Date2String(aerd.getSendDate(), "yyyy-MM-dd"));
                }
                appEmployeeReq_Jason2.setEmployee_rmrk(aerd.getRmrkFrom());
                appEmployeeReq_Jason2.setChkView(aerd.getAppEmployeeReqJ222().getChkView());
                appEmployeeReq_Jason2.setChkRev(aerd.getChkRev());
                appEmployeeReq_Jason2.setAppReqType("" + aerd.getAppEmployeeReqJ222().getAppReqTypeJ111().getAppReqSeq());
                appEmployeeReq_Jason2.setReqSp("" + aerd.getAppEmployeeReqJ222().getReqSp());

                appEmployeeReq_Jason_arr[i] = appEmployeeReq_Jason2;
                i++;
            }
            json = mapper.writeValueAsString(appEmployeeReq_Jason_arr);
            // success
            response.getWriter().write(json);

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
