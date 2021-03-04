/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateInterval;
import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmp;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtlRuf;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmp_DAO;
import com.ahramattend.www._0_0_1_0_3_JasonFiles._0_0_0_4_5_3_Employees_Rewards_01_Jason;
import com.ahramattend.www._0_0_1_0_3_JasonFiles._0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class _0_0_0_4_5_3_Employees_Rewards_Dashboard_Ajax_2_GetBandsOf_AjaxServlet extends HttpServlet {

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
            request.getSession().setAttribute("_0_0_0_4_5_3_Employees_Rewards_Dashboard_Loading_1", "0");//مننساش نغير هنا

            /// 1-  المكان اللي هيتشال فيه ملف الجيسون
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _0_0_0_4_5_3_Employees_Rewards_01_Jason Employees_Rewards_01_Jason = mapper.readValue(json, _0_0_0_4_5_3_Employees_Rewards_01_Jason.class);

            String date_from = Employees_Rewards_01_Jason.getDateFrom();
            String date_to = Employees_Rewards_01_Jason.getDateTo();
            String rejects = Employees_Rewards_01_Jason.getRejects();
            String Parts = Employees_Rewards_01_Jason.getParts();
            String detailType = Employees_Rewards_01_Jason.getDetailType();
            String locationCode = Employees_Rewards_01_Jason.getLocationCode();
            List<String> LocCodes = Employees_Rewards_01_Jason.getLocCode();
            List<String> BandCodes = Employees_Rewards_01_Jason.getBandCode();

            /// 2- تقسيم لبفترة من وإلى لشهور منفصلة
            List<DateInterval> SeperatedDateIntervals = new DateOp().getDateIntervals(date_from, date_to);

            /// ملف يحتوي علة داتا الصف الواحد كاامل
            /// المكافأة - تاريخها -  .......
            List<_0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason> dataTable = new ArrayList<_0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason>();
            int bar_i = 0;
            int size = LocCodes.size() * SeperatedDateIntervals.size() * BandCodes.size();
            for (String LocCode : LocCodes) { // بعدي على كل المواقع

                for (DateInterval dates : SeperatedDateIntervals) { // بدي على كل الشهور المختارة للموقع الواحد
                    for (String BandCodeSearch : BandCodes) {
                        String bandCode = BandCodeSearch.split("-")[0];
                        String bandType = BandCodeSearch.split("-")[1];

                        List<Object> pList = new PayDeserveEmp_DAO().getPayDeserveEmpByDateByLocCodeAndBandCode(dates.getStartDate(), LocCode, locationCode, bandCode, bandType);
                        if (!pList.isEmpty()) {
                            for (int j = 0; j < pList.size(); j++) {
                                Object[] p = (Object[]) pList.get(j);
                                String locCode = (String) p[0];
                                String LocationCode = (String) p[1];
                                String BandCode = (String) "" + p[2];
                                String BandType = (String) "" + p[3];
                                String OpenMm = (String) "" + p[4];
                                String OpenYyyy = (String) "" + p[5];
                                // Master Table
                                // بجيب الجدول الماستر بتاع المكافأة بناءا على الكود
                                List<PayDeserveEmpFile> PdefList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDStringWithChkStatus3(OpenMm, OpenYyyy, BandCode, BandType, LocationCode, locCode);
                                String bandName = "";
                                String locName = "";
                                String bandExecutionMonth = "";
                                String bandRegisterDate = "";
                                /**
                                 * متغيرات لحساب مجاميع الأفراد ومجاميع المكافآت
                                 * والمرفوضات
                                 */
                                double rewardTotal_InLoc = 0.0;
                                double rewardTotal_OutLoc = 0.0;

                                int empTotal_InLoc = 0;
                                int empTotal_OutLoc = 0;

                                double rewardTotalReffused = 0.0;
                                double rewardTotalReffused_InLoc = 0.0;
                                double rewardTotalReffused_OutLoc = 0.0;

                                int empTotal_Ref = 0;
                                int empTotal_Ref_InLoc = 0;
                                int empTotal_Ref_OutLoc = 0;
                                if (!PdefList.isEmpty()) {
                                    PayDeserveEmpFile pdef = PdefList.get(0);
                                    String pdef_locCode = pdef.getPayLocationBandFile().getPerLocationCodes().getId().getLocCode();
                                    String pdef_locationCode = pdef.getPayLocationBandFile().getPerLocationCodes().getId().getLocationCode();
                                    // Data 
                                    bandName = pdef.getPayLocationBandFile().getPayBandCode().getBandName();
                                    locName = pdef.getPayLocationBandFile().getPerLocationCodes().getLocName();
                                    bandExecutionMonth = dates.getStartDate();
                                    bandRegisterDate = new DateOp().Date2String(pdef.getCurrDate(), "yyyy-MM-dd");

                                    List<PayDeserveEmp> pdeList = new PayDeserveEmp_DAO().getPayDeserveEmpByID(OpenMm, OpenYyyy, BandCode, BandType, LocationCode, locCode);

                                    // المعنيين بالمكافأة
                                    for (PayDeserveEmp pde : pdeList) {
                                        if (pde.getPerLocationCodes().getId().getLocCode().equals(pdef_locCode) && pde.getPerLocationCodes().getId().getLocationCode().equals(pdef_locationCode)) {
                                            empTotal_InLoc++;
                                            rewardTotal_InLoc += Double.parseDouble("" + pde.getVal());
                                        } else {
                                            empTotal_OutLoc++;
                                            rewardTotal_OutLoc += Double.parseDouble("" + pde.getVal());
                                        }
                                    }
                                    //المرفوضين من المكافأة

                                    for (PayDeserveEmpFileDtlRuf ruf : pdef.getPayDeserveEmpFileDtlRufs()) {
                                        if (ruf.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getId().getLocCode().equals(pdef_locCode)
                                                && ruf.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getId().getLocationCode().equals(pdef_locationCode)) {
                                            empTotal_Ref_InLoc++;
                                            rewardTotalReffused_InLoc += Double.parseDouble("" + ruf.getVal());
                                        } else {
                                            empTotal_Ref_OutLoc++;
                                            rewardTotalReffused_OutLoc += Double.parseDouble("" + ruf.getVal());
                                        }
                                    }

                                }
                                _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason dataRow = new _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason(rewardTotalReffused, rewardTotalReffused_InLoc, rewardTotalReffused_OutLoc, rewardTotal_InLoc, rewardTotal_OutLoc, empTotal_InLoc, empTotal_OutLoc, empTotal_Ref, empTotal_Ref_InLoc, empTotal_Ref_OutLoc, bandName, locName, bandExecutionMonth, bandRegisterDate);

                                dataTable.add(dataRow);
                            }
                        }
                        bar_i++;
                        String message = "" + (int) ((bar_i * 100.0) / size);
                        request.getSession().setAttribute("_0_0_0_4_5_3_Employees_Rewards_Dashboard_Loading_1", message);
                    }
                }

            }

            String HTML_Text = "";
            HTML_Text += createTableHeader(rejects, Parts, detailType);
            HTML_Text += "<tbody>";

            int EmpTotal = 0;
            double RewardTotal = 0.0;

            int EmpTotal_InLoc = 0;
            double RewardTotal_InLoc = 0.0;

            int EmpTotal_OutLoc = 0;
            double RewardTotal_OutLoc = 0.0;

            int EmpTotal_Ref = 0;
            double RewardTotalReffused = 0.0;

            int EmpTotal_Ref_InLoc = 0;
            double RewardTotalReffused_InLoc = 0;

            int EmpTotal_Ref_OutLoc = 0;
            double RewardTotalReffused_OutLoc = 0.0;

            String LocName = "";
            List<_0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason> tempTotalsLists = new ArrayList<>();
            for (int iteration = 0; iteration < dataTable.size(); iteration++) {
                _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason date = dataTable.get(iteration);
                int span = 5;
                span += (!rejects.equals("NoRejects")) ? 6 : 0;
                span += (Parts.equals("AllowPart")) ? 4 : 0;
                if (detailType.equals("AllowDetails")) {
                    if (!date.getLocName().equals(LocName)) {
                        HTML_Text += "<tr>";
                        HTML_Text += "   <td style='background-color: yellow !important;'>" + date.getLocName() + "</td>";
                        HTML_Text += "   <td colspan='" + span + "'></td>";
                        HTML_Text += "</tr>";
                    }
                    HTML_Text += "<tr>";
                    HTML_Text += "   <td></td>";
                    HTML_Text += "   <td>" + date.getBandName() + "</td>";
                    HTML_Text += "   <td>" + date.getBandExecutionMonth() + "</td>";

                    HTML_Text += "   <td>" + date.getEmpTotal_Reward() + "</td>";
                    HTML_Text += "   <td>" + date.getRewardTotal() + "</td>";

                    if (Parts.equals("AllowPart")) {
                        HTML_Text += "   <td>" + date.getEmpTotal_InLoc() + "</td>";
                        HTML_Text += "   <td>" + date.getRewardTotal_InLoc() + "</td>";

                        HTML_Text += "   <td>" + date.getEmpTotal_OutLoc() + "</td>";
                        HTML_Text += "   <td>" + date.getRewardTotal_OutLoc() + "</td>";
                    }
                    if (!rejects.equals("NoRejects")) {
                        HTML_Text += "   <td>" + date.getEmpTotal_Ref() + "</td>";
                        HTML_Text += "   <td>" + date.getRewardTotalReffused() + "</td>";

                        HTML_Text += "   <td>" + date.getEmpTotal_Ref_InLoc() + "</td>";
                        HTML_Text += "   <td>" + date.getRewardTotalReffused_InLoc() + "</td>";

                        HTML_Text += "   <td>" + date.getEmpTotal_Ref_OutLoc() + "</td>";
                        HTML_Text += "   <td>" + date.getRewardTotalReffused_OutLoc() + "</td>";

                    }
                    HTML_Text += "   <td>" + date.getBandRegisterDate() + "</td>";
                    HTML_Text += "</tr>";
                }
                LocName = date.getLocName();

                /////// Calculate Totals
                EmpTotal += date.getEmpTotal_Reward();
                RewardTotal += date.getRewardTotal();

                if (Parts.equals("AllowPart")) {
                    EmpTotal_InLoc += date.getEmpTotal_InLoc();
                    RewardTotal_InLoc += date.getRewardTotal_InLoc();

                    EmpTotal_OutLoc += date.getEmpTotal_OutLoc();
                    RewardTotal_OutLoc += date.getRewardTotal_OutLoc();
                }
                if (!rejects.equals("NoRejects")) {
                    EmpTotal_Ref += date.getEmpTotal_Ref();
                    RewardTotalReffused += date.getRewardTotalReffused();

                    EmpTotal_Ref_InLoc += date.getEmpTotal_Ref_InLoc();
                    RewardTotalReffused_InLoc += date.getRewardTotalReffused_InLoc();

                    EmpTotal_Ref_OutLoc += date.getEmpTotal_Ref_OutLoc();
                    RewardTotalReffused_OutLoc += date.getRewardTotalReffused_OutLoc();

                }
                ////////////////////
                String LocNameChecker = "";
                if (iteration == dataTable.size() - 1) {
                    LocNameChecker = "";
                } else {
                    _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason dateChecker = dataTable.get(iteration + 1);
                    LocNameChecker = dateChecker.getLocName();
                }

                if (!LocName.equals(LocNameChecker)) {
                    HTML_Text += getTotalRow(rejects, Parts, EmpTotal, RewardTotal, EmpTotal_InLoc, RewardTotal_InLoc,
                            EmpTotal_OutLoc, RewardTotal_OutLoc, EmpTotal_Ref, RewardTotalReffused, EmpTotal_Ref_InLoc,
                            RewardTotalReffused_InLoc, EmpTotal_Ref_OutLoc, RewardTotalReffused_OutLoc, LocName);
                    _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason tempTotals
                            = new _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason(RewardTotalReffused, RewardTotalReffused_InLoc,
                                    RewardTotalReffused_OutLoc, RewardTotal_InLoc, RewardTotal_OutLoc,
                                    EmpTotal_InLoc, EmpTotal_OutLoc, EmpTotal_Ref, EmpTotal_Ref_InLoc,
                                    EmpTotal_Ref_OutLoc, "", "", "", rejects);
                    tempTotalsLists.add(tempTotals);
                }
            }
            HTML_Text += getFullTotalRow(rejects, Parts, tempTotalsLists);

            HibernateSessionCon.session.clear();
            response.getWriter().write(HTML_Text);
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionCon.RollBack();
            String message = e.getMessage();

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

    private String createTableHeader(String rejects, String Parts, String detailType) {

        String HTML_Text = "";
        HTML_Text += "<thead style=\"background-color: #68b6ff;text-align: center;\"><tr>";
        HTML_Text += "   <th colspan='3'></th>";
        HTML_Text += "   <th colspan='2'>إجمالي المكافأة</th>";
        if (Parts.equals("AllowPart")) {
            HTML_Text += "   <th colspan='4'>تفاصيل المكافأة</th>";
        }
        if (!rejects.equals("NoRejects")) {
            HTML_Text += "   <th colspan='6'>تفاصيل المرفوضات</th>";
        }
        HTML_Text += "</tr></thead>";

        HTML_Text += "<thead style=\"background-color: #68b6ff;text-align: center;\"><tr>";
        if (detailType.equals("AllowDetails")) {
            HTML_Text += "   <th>إسم الموقع</th>";
            HTML_Text += "   <th>إسم المكافأة</th>";
            HTML_Text += "   <th>الشهر</th>";
        } else {
            HTML_Text += "   <th colspan='3'>إسم الموقع</th>";
        }

        HTML_Text += "   <th>إجمالي عدد الموظفين</th>";
        HTML_Text += "   <th>إجمالي المكافأة</th>";

        if (Parts.equals("AllowPart")) {
            HTML_Text += "   <th>إجمالي الموظفين بالموقع</th>";
            HTML_Text += "   <th>إجمالي المكافأة بالموقع</th>";

            HTML_Text += "   <th>إجمالي الموظفين خارج الموقع</th>";
            HTML_Text += "   <th>إجمالي المكافأة خارج الموقع</th>";

        }

        if (!rejects.equals("NoRejects")) {
            HTML_Text += "   <th>إجمالي الموظفين المرفوضين</th>";
            HTML_Text += "   <th>إجمالي المكافأة المرفوضة</th>";

            HTML_Text += "   <th>إجمالي الموظفين المرفوضين بالموقع</th>";
            HTML_Text += "   <th>إجمالي المكافأة المرفوضة بالموقع</th>";

            HTML_Text += "   <th>إجمالي الموظفين المرفوضين خارج الموقع</th>";
            HTML_Text += "   <th>إجمالي المكافأة المرفوضة خارج الموقع</th>";
        }
        HTML_Text += "   <th>تاريخ تسجيل المكافأة</th>";
        HTML_Text += "</tr></thead>";
        return HTML_Text;
    }

    private String getTotalRow(String rejects, String Parts,
            int EmpTotal, double RewardTotal,
            int EmpTotal_InLoc, double RewardTotal_InLoc,
            int EmpTotal_OutLoc, double RewardTotal_OutLoc,
            int EmpTotal_Ref, double RewardTotalReffused,
            int EmpTotal_Ref_InLoc, double RewardTotalReffused_InLoc,
            int EmpTotal_Ref_OutLoc, double RewardTotalReffused_OutLoc, String LocName) {
        String HTML_Text = "";
        String Style = "style='background-color:black !important;color:white !important;'";
        HTML_Text += "<tr >";
        HTML_Text += "   <td colspan='3' " + Style + ">الإجماليات (" + LocName + ")</td>";

        HTML_Text += "   <td " + Style + ">" + EmpTotal + "</td>";
        HTML_Text += "   <td " + Style + ">" + RewardTotal + "</td>";

        if (Parts.equals("AllowPart")) {
            HTML_Text += "   <td " + Style + ">" + EmpTotal_InLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotal_InLoc + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_OutLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotal_OutLoc + "</td>";

        }
        if (!rejects.equals("NoRejects")) {
            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref_InLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused_InLoc + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref_OutLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused_OutLoc + "</td>";

        }
        HTML_Text += "   <td " + Style + "></td>";
        HTML_Text += "</tr>";
        return HTML_Text;
    }

    private String getFullTotalRow(String rejects, String Parts, List<_0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason> tempTotalsLists) {
        int EmpTotal = 0;
        double RewardTotal = 0.0;

        int EmpTotal_InLoc = 0;
        double RewardTotal_InLoc = 0.0;

        int EmpTotal_OutLoc = 0;
        double RewardTotal_OutLoc = 0.0;

        int EmpTotal_Ref = 0;
        double RewardTotalReffused = 0.0;

        int EmpTotal_Ref_InLoc = 0;
        double RewardTotalReffused_InLoc = 0;

        int EmpTotal_Ref_OutLoc = 0;
        double RewardTotalReffused_OutLoc = 0.0;
        for (_0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason tempTotalsList : tempTotalsLists) {
            EmpTotal += tempTotalsList.getEmpTotal_Reward();
            RewardTotal += tempTotalsList.getRewardTotal();

            EmpTotal_InLoc += tempTotalsList.getEmpTotal_InLoc();
            RewardTotal_InLoc += tempTotalsList.getRewardTotal_InLoc();

            EmpTotal_OutLoc += tempTotalsList.getEmpTotal_OutLoc();
            RewardTotal_OutLoc += tempTotalsList.getRewardTotal_OutLoc();

            EmpTotal_Ref += tempTotalsList.getEmpTotal_Ref();
            RewardTotalReffused += tempTotalsList.getRewardTotalReffused();

            EmpTotal_Ref_InLoc += tempTotalsList.getEmpTotal_Ref_InLoc();
            RewardTotalReffused_InLoc += tempTotalsList.getRewardTotalReffused_InLoc();

            EmpTotal_Ref_OutLoc += tempTotalsList.getEmpTotal_Ref_OutLoc();
            RewardTotalReffused_OutLoc += tempTotalsList.getRewardTotalReffused_OutLoc();
        }
        String HTML_Text = "";
        String Style = "style='background-color:green !important;color:white !important;'";
        HTML_Text += "<tr >";
        HTML_Text += "   <td colspan='3' " + Style + ">إجمالي عام</td>";

        HTML_Text += "   <td " + Style + ">" + EmpTotal + "</td>";
        HTML_Text += "   <td " + Style + ">" + RewardTotal + "</td>";

        if (Parts.equals("AllowPart")) {
            HTML_Text += "   <td " + Style + ">" + EmpTotal_InLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotal_InLoc + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_OutLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotal_OutLoc + "</td>";
        }
        if (!rejects.equals("NoRejects")) {
            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref_InLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused_InLoc + "</td>";

            HTML_Text += "   <td " + Style + ">" + EmpTotal_Ref_OutLoc + "</td>";
            HTML_Text += "   <td " + Style + ">" + RewardTotalReffused_OutLoc + "</td>";

        }
        HTML_Text += "   <td " + Style + "></td>";
        HTML_Text += "</tr>";
        return HTML_Text;
    }
}
