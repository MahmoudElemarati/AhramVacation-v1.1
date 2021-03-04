/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtlId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileId;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeMaster;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayExecutionOpen;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayLocationBandFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtl_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeMaster_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayExecutionOpen_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayLocationBandFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
public class _0_0_0_4_5_0_Employees_Rewards_Ajax_4_saveTo_AjaxServlet extends HttpServlet {

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

            String empIds[] = request.getParameterValues("empIds");
            String rewardValues[] = request.getParameterValues("rewardValues");
            String LocCode = request.getParameter("LocCode");
            String LocationCode = request.getParameter("LocationCode");
            /**
             * Check Emp Existance
             */
            boolean empExist = true;
            try {
                int l = empIds.length;
            } catch (Exception ex) {
                empExist = false;
            }
            /**
             * Check Emp In Location
             */
            /*boolean empErrorHacking = false;
            String EmployeesErrorStr = "الموظفين صاحب رقم التأمين (";
            if (empExist) {
                for (String empId : empIds) {
                    List<PerEmploymentMasters> empList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeNoAndLoc(empId, LocCode, LocationCode);
                    if (empList.isEmpty()) {
                        EmployeesErrorStr += " " + empId + " ";
                        empErrorHacking = true;
                        break;
                    }
                }
                EmployeesErrorStr += ") غير مسجل بالموقع";
            }
            if (empErrorHacking) {
                throw new Exception(EmployeesErrorStr);
            }*/

            /**
             * buisnes Logic
             */
            String bandCode = request.getParameter("bandCode");
            String bandCode_Arr[] = bandCode.split("-");
            bandCode = bandCode_Arr[0];
            String bandType = bandCode_Arr[1];

            String month = request.getParameter("month");

            month = "01-" + month;
            DateOp dOp = new DateOp();
            String openMm = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "MM");
            String openYyyy = dOp.Date2String(dOp.String2Date(month, "dd-MM-yyyy"), "yyyy");

            /**
             * Check If Reward Master Exist Or Not
             */
            PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");

            //boolean EmployeeExistBefor = false;
            List<String> HistoricalEmp = new ArrayList<>();
            PayDeserveEmpFile pdef;
            List<PayDeserveEmpFile> pdefList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
            if (pdefList.isEmpty()) {
                pdef = PrepareMasterTable(openMm, openYyyy, LocCode, bandType, LocationCode, bandCode, employee_session);
            } else {
                pdef = pdefList.get(0);
                /**
                 * get Reward Dtl Employees
                 */
                for (PayDeserveEmpFileDtl payDeserveEmpFileDtl : pdef.getPayDeserveEmpFileDtls()) {
                    HistoricalEmp.add(payDeserveEmpFileDtl.getEmployeeNo());
                }
                ///////////////////////////////////////////
            }
            /**
             * is user Exist Before Now Here
             */
            for (String empId : empIds) {
                if (HistoricalEmp.contains(empId)) {
                    throw new Exception("الموظف مسجل بالقرار من قبل");
                }
            }

            if (pdef.getChkStatus() == 0) {
                HibernateSessionCon.beginTrans();

                if (empExist) {
                    new PayDeserveEmpFile_DAO().save(pdef);
                    for (int i = 0; i < empIds.length; i++) {
                        /**
                         * المستفيدين من المكافآت
                         */

                        //List<PayEmployeeMaster> pList = new PayEmployeeMaster_DAO().getPayEmployeeMasterByNoAndLoc(empIds[i], LocCode, LocationCode);
                        List<PayEmployeeMaster> pList = new PayEmployeeMaster_DAO().getPayEmployeeMasterByNo(empIds[i]);
                        if (pList.isEmpty()) {
                            throw new Exception();
                        }

                        PayEmployeeMaster p = pList.get(0);

                        int accessSp = new PayDeserveEmpFileDtl_DAO().getMaxID(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
                        PayDeserveEmpFileDtlId pdefdid = new PayDeserveEmpFileDtlId(Short.parseShort(openYyyy), Byte.parseByte(openMm), Byte.parseByte(bandType), LocationCode, LocCode, Short.parseShort(bandCode), accessSp);
                        PayDeserveEmpFileDtl pdefd = new PayDeserveEmpFileDtl(pdefdid, p, pdef, p.getEmployeeNo());

                        /**
                         * منفذ العملية
                         */
                        List<PerEmploymentMasters> empUserList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID("" + employee_session.getEmployeeId());
                        if (empUserList.isEmpty()) {
                            throw new Exception();
                        }
                        employee_session = empUserList.get(0);
                        pdefd.setPayEmployeeMasterByEmployeeIdUser(employee_session.getPayEmployeeMaster());

                        pdefd.setCurrDate(new DateOp().getSysDate());
                        pdefd.setCurrTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                        double val = Double.parseDouble(rewardValues[i]);
                        pdefd.setVal(BigDecimal.valueOf(val));
                        new PayDeserveEmpFile_DAO().insert(pdefd);
                    }
                } else {
                    new PayDeserveEmpFile_DAO().insert(pdef);
                }

                HibernateSessionCon.CommitTrans();
            } else {
                throw new Exception("حالة البيان مغلقة وغير قابلة للتعديل");
            }
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            if (e.getMessage().equals("حالة البيان مغلقة وغير قابلة للتعديل")) {
                response.getWriter().write(e.getMessage());
            } else if (e.getMessage().endsWith("الموظف مسجل بالقرار من قبل")) {
                response.getWriter().write(e.getMessage());
            } else if (e.getMessage().endsWith(" غير مسجل بالموقع")) {
                response.getWriter().write(e.getMessage());
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

    private PayDeserveEmpFile PrepareMasterTable(String openMm, String openYyyy, String LocCode, String bandType, String LocationCode, String bandCode, PerEmploymentMasters employee_session) throws Exception {

        PayDeserveEmpFileId id = new PayDeserveEmpFileId(Byte.parseByte(openMm), Short.parseShort(openYyyy), LocCode, Byte.parseByte(bandType), LocationCode, Short.parseShort(bandCode));
        /**
         * PayExecutionOpen
         */
        List<PayExecutionOpen> peoList = new PayExecutionOpen_DAO().getExecutionOpenByID(openMm, openYyyy);
        if (peoList.isEmpty()) {
            throw new Exception();
        }
        PayExecutionOpen peo = peoList.get(0);
        /**
         * PayLocationBandFile
         */
        List<PayLocationBandFile> plbfList = new PayLocationBandFile_DAO().getPayLocationBandFileByID(bandCode, bandType, LocationCode, LocCode);
        if (plbfList.isEmpty()) {
            throw new Exception();
        }
        PayLocationBandFile plbf = plbfList.get(0);
        PayDeserveEmpFile pdef = new PayDeserveEmpFile(id, peo, plbf);
        pdef.setChkStatus(Byte.parseByte("0"));
        pdef.setCurrDate(new DateOp().getSysDate());
        pdef.setCurrTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

        /**
         * منفذ المكافأة
         */
        List<PerEmploymentMasters> empUserList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID("" + employee_session.getEmployeeId());
        if (empUserList.isEmpty()) {
            throw new Exception();
        }
        employee_session = empUserList.get(0);
        pdef.setPayEmployeeMasterByEmployeeId(employee_session.getPayEmployeeMaster());
        return pdef;
    }

}
