/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpVacationReqJava;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerVacationCode;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpVacationReqJava_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerVacationCode_DAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_4_1_PerEmpVacationReqJava_Ajax_2_AddVacationRequest_AjaxServlet extends HttpServlet {

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
        PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");

        try {
            String period = request.getParameter("period");
            String vacStartDate = request.getParameter("vacStartDate");
            String vacEndDate = request.getParameter("vacEndDate");
            String vacationBalance = request.getParameter("vacationBalance");
            String vacNote = request.getParameter("vacNote");
            String vacStatus = "0";
            Date editDate = new DateOp().getSysDate();

            String employeeId = employee_session.getEmployeeId();
            //System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +employeeId);
            /////////
            //Date Validation
            Date currentDate = new DateOp().getSysDate();
            Date vacStartDate_dtr = new DateOp().String2Date(vacStartDate, "yyyy-MM-dd");
            long number = new DateOp().differentsBetweenTwoDates(vacStartDate_dtr, currentDate);
            if (number < 0) {
                throw new Exception("لا يمكن طلب أجازة بعد تاريخ تنفيذها");
            }
            if (CheckDateInterval(employeeId, vacStartDate, vacEndDate)) {
                throw new Exception("الأيام المطلوبة محجوزة في طلب اجازة اخر");
            }

            List<PerEmploymentMasters> PerEmploymentMastersList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(employeeId);
            PerEmploymentMasters perEmploymentMastersByEmployeeId = PerEmploymentMastersList.get(0);

            String vacationCode = request.getParameter("vacationCode");
            List<PerVacationCode> PerVacationCodeList = new PerVacationCode_DAO().getPerVacationCodeID(vacationCode);
            PerVacationCode perVacationCode = PerVacationCodeList.get(0);

            int vacTransSp = new PerEmpVacationReqJava_DAO().getMaxPerEmpVacationReqJava();
            BigDecimal period2 = BigDecimal.valueOf(Long.parseLong(period));
            PerEmpVacationReqJava m = new PerEmpVacationReqJava(vacTransSp, perVacationCode, perEmploymentMastersByEmployeeId,  period2, currentDate);

            //BossId
            String BossId = perEmploymentMastersByEmployeeId.getPerOrganizationStructureByOrgId().getEmpDirectBoss();
            if (employeeId.equals(BossId)) {
                BossId = perEmploymentMastersByEmployeeId.getPerOrganizationStructureByOrgId().getEmpBigBoss();
            }
            List<PerEmploymentMasters> PerEmploymentMastersBossList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(BossId);
            if(PerEmploymentMastersBossList.isEmpty()){
                throw new Exception("ليس لك مدير .. برجاء مراجعة شئون العاملين");
            }
            PerEmploymentMasters PerEmploymentMastersByEmployeeIdBoss = PerEmploymentMastersBossList.get(0);
            m.setPerEmploymentMastersByEmployeeIdBoss(PerEmploymentMastersByEmployeeIdBoss);

            //m.setVacEditDate(new DateOp().getSysDate());
            m.setVacStartDate(new DateOp().String2Date(vacStartDate, "yyyy-MM-dd"));
            m.setVacEndDate(new DateOp().String2Date(vacEndDate, "yyyy-MM-dd"));
            if (vacNote.equals("") || vacNote == null) {

            } else {
                m.setVacNote(vacNote);
            }
            m.setVacStatus(vacStatus);
            BigDecimal vacationBalance2 = BigDecimal.valueOf(Long.parseLong(vacationBalance));
            m.setBalBeforeVac(vacationBalance2);

            ////System.out.println(">> EmpID = " + perEmploymentMastersByEmployeeId.getEmployeeId());
            HibernateSessionCon.beginTrans();
            new PerEmpVacationReqJava_DAO().insert(m);
            HibernateSessionCon.CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            String Message = e.getMessage();
            if (Message.equals("لا يمكن طلب أجازة بعد تاريخ تنفيذها")) {
                Message = "لا يمكن طلب أجازة بعد تاريخ تنفيذها";
            }else if (Message.equals("الأيام المطلوبة محجوزة في طلب اجازة اخر")) {
                Message = "الأيام المطلوبة محجوزة في طلب اجازة اخر";
            }else if(Message.equals("ليس لك مدير .. برجاء مراجعة شئون العاملين")){
                Message = "ليس لك مدير .. برجاء مراجعة شئون العاملين";
            }else {
                Message = "حدث خطأ";
            }
            response.getWriter().write(Message);
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

    private boolean CheckDateInterval(String employeeId, String vacStartDate, String vacEndDate) {
        boolean checkStatus = false;
        List<PerEmpVacationReqJava> pList = new PerEmpVacationReqJava_DAO().getPerEmpVacationReqCheckDate(vacStartDate, employeeId);
        List<PerEmpVacationReqJava> pList2 = new PerEmpVacationReqJava_DAO().getPerEmpVacationReqCheckDate(vacEndDate, employeeId);
        List<PerEmpVacationReqJava> pList3 = new PerEmpVacationReqJava_DAO().getPerEmpVacationReqCheckDate2("p.vacStartDate", vacStartDate, vacEndDate, employeeId);
        List<PerEmpVacationReqJava> pList4 = new PerEmpVacationReqJava_DAO().getPerEmpVacationReqCheckDate2("p.vacEndDate", vacStartDate, vacEndDate, employeeId);
        if (!pList.isEmpty() || !pList2.isEmpty() || !pList3.isEmpty() || !pList4.isEmpty()) {
            checkStatus = true;
        }
        return checkStatus;
    }

}
