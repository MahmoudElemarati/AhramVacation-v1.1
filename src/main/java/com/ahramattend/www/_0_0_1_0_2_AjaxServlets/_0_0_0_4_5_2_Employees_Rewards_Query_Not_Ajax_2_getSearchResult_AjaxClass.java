/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmp;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtl;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFileDtlRuf;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtlRuf_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFileDtl_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmp_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_getSearchResult_AjaxClass {

    private double TotalBefore = 0.0;
    private double TotalAfter = 0.0;
    private int EmpOut = 0;

    public String getTopDescriptionOfDeserveEmpFile(String SearchType, String queryType, String rejects, String LocCodeCombo, String LocCode, String LocationCode, String bandCode, String bandType, String openMm, String openYyyy) {
        String HTML_TEXT = "";

        List<PayDeserveEmpFile> PayDeserveEmpFileList = null;
        switch (SearchType) {
            case "1":
                PayDeserveEmpFileList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCodeCombo);
                break;
            case "2":
                PayDeserveEmpFileList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
                break;
            default:
                break;
        }
        String title = "width: 20%;";
        String value = "width: 10%;";
        for (PayDeserveEmpFile p : PayDeserveEmpFileList) {
            HTML_TEXT = "<div class=\"row\">\n"
                    + "     <table id=\"\" class=\"table\">\n"
                    + "         <tbody style=\"\">\n"
                    + "             <tr>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">إسم الجهة :</td>\n"
                    + "                 <td style=\"" + value + " text-align: right;\">" + p.getPayLocationBandFile().getPerLocationCodes().getBudLocation().getLocationName() + "</td>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">إسم الموقع المسجل للمكافأة :</td>\n"
                    + "                 <td colspan='2' style=\"" + value + " text-align: right;\">" + p.getPayLocationBandFile().getPerLocationCodes().getLocName() + "</td>\n"
                    + "             </tr>\n"
                    + "             <tr>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">المكافأة :</td>\n"
                    + "                 <td style=\"" + value + " text-align: right;\">" + p.getPayLocationBandFile().getPayBandCode().getBandName() + "</td>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">عن شهر :</td>\n"
                    + "                 <td colspan='2' style=\"" + value + " text-align: right;\">" + p.getPayExecutionOpen().getId().getOpenMm() + "-" + p.getPayExecutionOpen().getId().getOpenYyyy() + "</td>\n"
                    + "             </tr>\n";

            _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass empCountsDashBoard = getDash(p, SearchType, queryType, rejects);
            HTML_TEXT += "          <tr>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">إجمالي عدد الموظفين المسجلين :</td>\n"
                    + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getEmpTotal_Reward() + "</td>\n"
                    + "                 <td style=\"" + title + " text-align: left;\">إجمالي عدد الموظفين بالموقع :</td>\n"
                    + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getEmpTotal_InLoc() + "</td>\n";
            if (empCountsDashBoard.getEmpTotal_OutLoc() != 0) {
                HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\">إجمالي عدد الموظفين خارج الموقع :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getEmpTotal_OutLoc() + "</td>\n";
            } else {
                HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\"></td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\"></td>\n";
            }
            HTML_TEXT += "             </tr>\n";

            if (queryType.equals("AfterSend") || queryType.equals("All")) {
                HTML_TEXT += "          <tr>\n"
                        + "                 <td style=\"" + title + " text-align: left;\">إجمالي المكافأة بعد التنفيذ :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotalAfter() + "</td>\n"
                        + "                 <td style=\"" + title + " text-align: left;\">الإجمالي المكافأة للموظفين بالموقع :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotal_InLoc_After() + "</td>\n";
                if (empCountsDashBoard.getRewardTotal_OutLoc_After() != 0) {
                    HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\">الإجمالي للموظفين خارج الموقع :</td>\n"
                            + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotal_OutLoc_After() + "</td>\n";
                } else {
                    HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\"></td>\n"
                            + "                 <td style=\"" + value + " text-align: right;\"></td>\n";
                }
                HTML_TEXT += "             </tr>\n";
            }
            /**
             * القيم قبل
             */
            if (queryType.equals("BeforeSend") || queryType.equals("All")) {
                HTML_TEXT += "          <tr>\n"
                        + "                 <td style=\"" + title + " text-align: left;\">إجمالي المكافأة المسجلة من الموقع :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotalBefore() + "</td>\n"
                        + "                 <td style=\"" + title + " text-align: left;\">إجمالي المكافأة للموظفين بالموقع :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotal_InLoc_Before() + "</td>\n";

                if (empCountsDashBoard.getRewardTotal_OutLoc_Before() != 0) {
                    HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\">إجمالي المكافأة للموظفين خارج الموقع :</td>\n"
                            + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotal_OutLoc_Before() + "</td>\n";
                } else {
                    HTML_TEXT += "                 <td style=\"" + title + " text-align: left;\"></td>\n"
                            + "                 <td style=\"" + value + " text-align: right;\"></td>\n";
                }
                HTML_TEXT += "             </tr>\n";
            }

            /**
             * الرفض
             */
            HTML_TEXT += "          <tr>\n";
            if (rejects.equals("AddRejects") || rejects.equals("OnlyRejects")) {
                HTML_TEXT += "               <td style=\"" + title + " text-align: left;\">إجمالي عدد الموظفين المرفوضين :</td>\n"
                        + "                 <td style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getEmpTotal_Ref() + "</td>\n"
                        + "                 <td style=\"" + title + " text-align: left;\">إجمالي المكافأة للمرفوضين :</td>\n"
                        + "                 <td colspan='2' style=\"" + value + " text-align: right;\">" + empCountsDashBoard.getRewardTotalReffused() + "</td>\n";
            }

            HTML_TEXT += "             </tr>\n"
                    + "         </tbody>\n"
                    + "     </table>\n"
                    + " </div>";
        }

        return HTML_TEXT;
    }

    public String getSearchResult(String SearchType, String LocCodeCombo, String LocCode, String LocationCode, String bandCode, String bandType, String openMm, String openYyyy, String queryType, String rejects, String locationColStatus, String rewardDateTimeColStatus, String dateTimeReview, String empRewardDateTimeColStatus, String dateTimeEmpReview, boolean calculateTableTotal) throws Exception {
        String HTML_TEXT = "";
        ///// Check is this Reward is Exist By Login Session Location or Chosen Location
        List<PayDeserveEmpFile> PayDeserveEmpFileList = null;
        switch (SearchType) {
            case "1":
                PayDeserveEmpFileList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCodeCombo);
                break;
            case "2":
                PayDeserveEmpFileList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
                break;
            default:
                break;
        }
        if (PayDeserveEmpFileList.isEmpty()) {
            HTML_TEXT = "<tr style=\"text-align: center;font-size: 25px;font-weight: bold;color: red;\">"
                    + "      <td>لا توجد مكافأة لهذا البند في هذا الموقع لهذا الشهر</td>"
                    + "  </tr>";
        } else {
            PayDeserveEmpFile pdef = PayDeserveEmpFileList.get(0);
            ///// Query Result DAO Method if have Reward BeforeSend,AfterSend or Both
            List<PayDeserveEmpFileDtl> PayDeserveEmpFileDtlList = null;
            switch (queryType) {
                case "BeforeSend":
                    PayDeserveEmpFileDtlList = new PayDeserveEmpFileDtl_DAO().getPayEmployeeMasterWithoutLocationsPrameter(openMm, openYyyy, bandCode, bandType);
                    break;
                case "AfterSend":
                    PayDeserveEmpFileDtlList = new PayDeserveEmpFileDtl_DAO().getPayEmployeeMasterWithoutLocationsPrameter(openMm, openYyyy, bandCode, bandType);
                    break;
                case "All":
                    PayDeserveEmpFileDtlList = new PayDeserveEmpFileDtl_DAO().getPayEmployeeMasterWithoutLocationsPrameter(openMm, openYyyy, bandCode, bandType);
                    break;
                default:
                    break;
            }
            if (pdef.getChkStatus() < 2 /*!PayDeserveEmpFileDtlList.isEmpty()*/) {
                // Emp In
                TotalBefore = 0.0;
                TotalAfter = 0.0;
                EmpOut = 0;
                HTML_TEXT += "<h1 style=''>مكافأة الموظفين داخل الموقع</h1>";
                HTML_TEXT  += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "In");
                for (PayDeserveEmpFileDtl pdefd : PayDeserveEmpFileDtlList) {
                    ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                    HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                            pdefd.getEmployeeNo(), pdefd.getPayEmployeeMasterByEmployeeId().getEmployeeId(),
                            pdefd.getPayEmployeeMasterByEmployeeId().getEmpAname(),
                            pdefd.getPayEmployeeMasterByEmployeeId().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                            pdefd.getPayDeserveEmpFile().getCurrTime(), pdefd.getCurrTime(),
                            "" + pdefd.getVal(), "", "dontCompare", queryType,
                            locationColStatus,
                            rewardDateTimeColStatus, dateTimeReview,
                            empRewardDateTimeColStatus, dateTimeEmpReview, "In");
                }
                if (calculateTableTotal) {
                    HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                }
                HTML_TEXT += GeneratedTabelBot();

                //Emp Out
                TotalBefore = 0.0;
                TotalAfter = 0.0;
                if (EmpOut > 0) {
                    HTML_TEXT += "<h1 style=''>مكافأة الموظفين خارج الموقع</h1>";
                    HTML_TEXT  += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "Out");
                    for (PayDeserveEmpFileDtl pdefd : PayDeserveEmpFileDtlList) {
                        ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                        HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                                pdefd.getEmployeeNo(), pdefd.getPayEmployeeMasterByEmployeeId().getEmployeeId(),
                                pdefd.getPayEmployeeMasterByEmployeeId().getEmpAname(),
                                pdefd.getPayEmployeeMasterByEmployeeId().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                                pdefd.getPayDeserveEmpFile().getCurrTime(), pdefd.getCurrTime(),
                                "" + pdefd.getVal(), "", "dontCompare", queryType,
                                locationColStatus,
                                rewardDateTimeColStatus, dateTimeReview,
                                empRewardDateTimeColStatus, dateTimeEmpReview, "Out");
                    }
                    if (calculateTableTotal) {
                        HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                    }
                    HTML_TEXT += GeneratedTabelBot();
                }
            } else {
                //// جدول البيانات بعد السحب
                if (!rejects.equals("OnlyRejects")) {
                    // Emp In
                    TotalBefore = 0.0;
                    TotalAfter = 0.0;
                    EmpOut = 0;
                    List<PayDeserveEmp> pdeList = new PayDeserveEmp_DAO().getPayDeserveEmpByID(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
                    HTML_TEXT += "<h1 style=''>مكافأة الموظفين داخل الموقع</h1>";
                    HTML_TEXT  += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "In");
                    for (PayDeserveEmp pde : pdeList) {
                        ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row

                        HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                                pde.getEmployeeNo(), pde.getPayEmployeeMaster().getEmployeeId(),
                                pde.getPayEmployeeMaster().getEmpAname(),
                                pde.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                                pdef.getCurrTime(),
                                "00-00-0000 00:00:00",
                                "" + pde.getValFile(),
                                "" + pde.getVal(),
                                "Compare", queryType,
                                locationColStatus,
                                rewardDateTimeColStatus, dateTimeReview,
                                empRewardDateTimeColStatus, dateTimeEmpReview, "In");
                    }
                    if (calculateTableTotal) {
                        HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                    }
                    HTML_TEXT += GeneratedTabelBot();

                    // Emp Out
                    TotalBefore = 0.0;
                    TotalAfter = 0.0;
                    if (EmpOut > 0) {
                        HTML_TEXT += "<h1 style=''>مكافأة الموظفين خارج الموقع</h1>";
                        HTML_TEXT  += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "Out");
                        for (PayDeserveEmp pde : pdeList) {
                            ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row

                            HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                                    pde.getEmployeeNo(), pde.getPayEmployeeMaster().getEmployeeId(),
                                    pde.getPayEmployeeMaster().getEmpAname(),
                                    pde.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                                    pdef.getCurrTime(),
                                    "00-00-0000 00:00:00",
                                    "" + pde.getValFile(),
                                    "" + pde.getVal(),
                                    "Compare", queryType,
                                    locationColStatus,
                                    rewardDateTimeColStatus, dateTimeReview,
                                    empRewardDateTimeColStatus, dateTimeEmpReview, "Out");
                        }
                        if (calculateTableTotal) {
                            HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                        }
                        HTML_TEXT += GeneratedTabelBot();
                    }
                }
                //// جدول البيانات بعد السحب لما تم رفضه
                if (rejects.equals("AddRejects") || rejects.equals("OnlyRejects")) {

                    List<PayDeserveEmpFileDtlRuf> pdefdrList = new PayDeserveEmpFileDtlRuf_DAO().getPayDeserveEmpFileDtlRufByID(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
                    if (!pdefdrList.isEmpty()) {
                        //Emp In
                        TotalBefore = 0.0;
                        TotalAfter = 0.0;
                        EmpOut = 0;
                        
                        HTML_TEXT += "<h1 style=''>جدول الموظفين المرفوضين من الموقع</h1>";
                        HTML_TEXT += "<h1 style=''>المرفوضين من داخل الموقع</h1>";
                        HTML_TEXT += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "In");
                       
                        for (PayDeserveEmpFileDtlRuf pdefdr : pdefdrList) {
                            ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                            
                            HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                                    pdefdr.getEmployeeNo(), pdefdr.getPayEmployeeMaster().getEmployeeId(),
                                    pdefdr.getPayEmployeeMaster().getEmpAname(),
                                    pdefdr.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                                    pdef.getCurrTime(),
                                    pdefdr.getCurrTime(),
                                    "" + pdefdr.getVal(),
                                    "",
                                    "dontCompare", queryType,
                                    locationColStatus,
                                    rewardDateTimeColStatus, dateTimeReview,
                                    empRewardDateTimeColStatus, dateTimeEmpReview, "In");
                        }
                        if (calculateTableTotal) {
                            HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                        }
                        HTML_TEXT += GeneratedTabelBot();

                        // Emp Out
                        TotalBefore = 0.0;
                        TotalAfter = 0.0;
                        if (EmpOut > 0) {
                            HTML_TEXT += "<h1 style=''>المرفوضين من خارج الموقع</h1>";
                            HTML_TEXT += GeneratedTabelHead(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus, "Out");                            
                            for (PayDeserveEmpFileDtlRuf pdefdr : pdefdrList) {
                                ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row

                                HTML_TEXT += GeneratedTabelRow(LocCode, LocationCode,
                                        pdefdr.getEmployeeNo(), pdefdr.getPayEmployeeMaster().getEmployeeId(),
                                        pdefdr.getPayEmployeeMaster().getEmpAname(),
                                        pdefdr.getPayEmployeeMaster().getPerEmploymentMasters().getPerLocationCodes().getLocName(),
                                        pdef.getCurrTime(),
                                        pdefdr.getCurrTime(),
                                        "" + pdefdr.getVal(),
                                        "",
                                        "dontCompare", queryType,
                                        locationColStatus,
                                        rewardDateTimeColStatus, dateTimeReview,
                                        empRewardDateTimeColStatus, dateTimeEmpReview, "Out");
                            }
                            if (calculateTableTotal) {
                                HTML_TEXT += GeneratedTotalRow(queryType, locationColStatus, rewardDateTimeColStatus, empRewardDateTimeColStatus);
                            }
                            HTML_TEXT += GeneratedTabelBot();
                        }
                    }
                }
            }
        }
        return HTML_TEXT;
    }

    private String GeneratedTabelHead(String queryType,
            String locationColStatus,
            String rewardDateTimeColStatus,
            String empRewardDateTimeColStatus, String empInOut) {
        /**
         * String rewardDateTimeColStatus // // true || false
         *
         * String dateTimeReview //DateOnly || DateTime
         *
         * String empRewardDateTimeColStatus // true || false
         *
         * String dateTimeEmpReview //DateOnly || DateTime
         *
         */
        String Color = "background-color: black !important;color: white !important";
        String HTML_TEXT = "<div class=\"table-responsive table-wrapper-scroll-y my-custom-scrollbar\" >"
                + "<table  class=\"table table-striped table-bordered table-hover\">"
                + "<thead style=\"background-color: #337ab7 !important;color: white !important;font-size: 20px;font-weight: bold;\">"
                + "   <tr>"
                + "       <th style=\"text-align: center;width: 10%; "+Color+"\">رقم الموظف</th>"
                + "       <th style=\"text-align: center;width: 20%; "+Color+"\">اسم الموظف</th>";

        switch (queryType) {
            case "BeforeSend":
                HTML_TEXT += "       <th style=\"text-align: center;width: 10%; "+Color+"\">القيمة المسجلة</th>";
                break;
            case "AfterSend":
                HTML_TEXT += "       <th style=\"text-align: center;width: 10%; "+Color+"\">القيمة المنفذة</th>";
                break;
            case "All":
                HTML_TEXT += "       <th style=\"text-align: center;width: 10%; "+Color+"\">القيمة المسجلة</th>"
                        + "       <th style=\"text-align: center;width: 10%; "+Color+"\">القيمة المنفذة</th>";
                break;
            default:
                break;
        }

        if (locationColStatus.equals("true") && empInOut.equals("Out")) {
            HTML_TEXT += "       <th style=\"text-align: center;width: 20%; "+Color+"\">الموقع</th>";
        }

        if (rewardDateTimeColStatus.equals("true")) {
            HTML_TEXT += "       <th style=\"text-align: center;width: 15%; "+Color+"\">تاريخ المكافأة</th>";
        }

        if (empRewardDateTimeColStatus.equals("true")) {
            HTML_TEXT += "       <th style=\"text-align: center;width: 15%;"+Color+"\">تاريخ تسجيل الموظف</th>";
        }
        ///// Query Result Table Head if Columns have Reward BeforeSend,AfterSend or Both

        HTML_TEXT += "    </tr>"
                + "    </thead>"
                + "    <tbody style=\"text-align: center;font-size: 15px;font-weight: bold;\">";
        return HTML_TEXT;
    }

    private String GeneratedTabelRow(String LocCode, String LocationCode,
            String EmployeeNo,
            String EmployeeId,
            String EmpAname,
            String LocName,
            String RewardCurrDate,
            String CurrDateEmpReg,
            String OldVal,
            String NewVal,
            String CompareStatus,
            String queryType,
            String locationColStatus,
            String rewardDateTimeColStatus, String dateTimeReview,
            String empRewardDateTimeColStatus, String dateTimeEmpReview, String empInOut) throws Exception {

        DateOp dateOp = new DateOp();
        List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(EmployeeId);
        String CompareLocCode = pList.get(0).getPerLocationCodes().getId().getLocCode();
        String CompareLocationCode = pList.get(0).getPerLocationCodes().getId().getLocationCode();
        String Color;
        if (LocCode.equals(CompareLocCode) && LocationCode.equals(CompareLocationCode)) {
            Color = "";
        } else {
            Color = "background-color: #ffbdbd !important; ";
            EmpOut++;
        }
        String HTML_TEXT = "";
        if ((empInOut.equals("Out") && !Color.isEmpty()) || (empInOut.equals("In") && Color.isEmpty())) {
            HTML_TEXT += ""
                    + "   <tr style='" + Color + "'>"
                    + "      <td>" + EmployeeNo + "</td>"
                    + "      <td>" + EmpAname + "</td>";

            TotalBefore = TotalBefore + Double.parseDouble(OldVal);
            if (!NewVal.equals("")) {
                TotalAfter = TotalAfter + Double.parseDouble(NewVal);
            }
            switch (queryType) {
                case "BeforeSend":
                    HTML_TEXT += "       <td>" + OldVal + "</td>";
                    break;
                case "AfterSend":
                    HTML_TEXT += "       <td>" + NewVal + "</td>";
                    break;
                case "All":
                    String RewardComapreColor = "";
                    double valBefore = Double.parseDouble(OldVal);
                    if (CompareStatus.equals("Compare")) {
                        double valAfter = Double.parseDouble(NewVal);
                        if (valBefore != valAfter && CompareStatus.equals("Compare")) {
                            RewardComapreColor = "background-color: #f19700 !important; ";
                        } else {
                            RewardComapreColor = "";
                        }
                    } else {

                    }

                    HTML_TEXT += "       <td Style='" + RewardComapreColor + "'>" + OldVal + "</td>"
                            + "       <td Style='" + RewardComapreColor + "'>" + NewVal + "</td>";
                    break;
                default:
                    break;
            }
            if (locationColStatus.equals("true") && empInOut.equals("Out")) {
                HTML_TEXT += "   <td>" + LocName + "</td>";
            }
            if (rewardDateTimeColStatus.equals("true")) {
                RewardCurrDate = dateTimeReview.equals("DateTime") ? RewardCurrDate : dateOp.Date2String(dateOp.String2Date(RewardCurrDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
                HTML_TEXT += "      <td>" + RewardCurrDate + "</td>";
            }
            if (empRewardDateTimeColStatus.equals("true")) {
                try {
                    CurrDateEmpReg = dateTimeEmpReview.equals("DateTime") ? CurrDateEmpReg : dateOp.Date2String(dateOp.String2Date(CurrDateEmpReg, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
                } catch (Exception ex) {
                }

                HTML_TEXT += "      <td>" + CurrDateEmpReg + "</td>";
            }
            ///// Query Result Table Body if Rows have Reward BeforeSend,AfterSend or Both

            HTML_TEXT += "    </tr>";
        }
        return HTML_TEXT;
    }

    private String GeneratedTotalRow(String queryType, String locationColStatus, String rewardDateTimeColStatus, String empRewardDateTimeColStatus) {

        int colspan = 2;
        String Color = "style='background-color: #85d6cd !important; '";
        String HTML_TEXT = ""
                + "   <tr >"
                + "      <td colspan='" + colspan + "' "+Color+">الإجمالي</td>";
        switch (queryType) {
            case "BeforeSend":
                HTML_TEXT += "      <td "+Color+">" + TotalBefore + "</td>";
                break;
            case "AfterSend":
                HTML_TEXT += "      <td "+Color+">" + ((TotalAfter == 0) ? "-" : TotalAfter) + "</td>";
                break;
            case "All":
                HTML_TEXT += "      <td "+Color+">" + TotalBefore + "</td>";
                HTML_TEXT += "      <td "+Color+">" + ((TotalAfter == 0) ? "-" : TotalAfter) + "</td>";
                break;
            default:
                break;
        }
        ///// Query Result Table Body if Rows have Reward BeforeSend,AfterSend or Both
        HTML_TEXT += "    </tr>";

        return HTML_TEXT;
    }

    private String GeneratedTabelBot() {
        String HTML_TEXT = "</tbody></table></div>";
        return HTML_TEXT;
    }

    private _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass getDash(PayDeserveEmpFile p, String SearchType, String queryType, String rejects) {
        // 
        String LocCode = p.getPayLocationBandFile().getPerLocationCodes().getId().getLocCode();
        String LocationCode = p.getPayLocationBandFile().getPerLocationCodes().getId().getLocationCode();
        double RewardTotalReffused = 0.0;
        int EmpTotal_Ref = 0;

        double RewardTotal_InLoc_Before = 0.0;
        double RewardTotal_OutLoc_Before = 0.0;

        double RewardTotal_InLoc_After = 0.0;
        double RewardTotal_OutLoc_After = 0.0;

        int EmpTotal_InLoc = 0;
        int EmpTotal_OutLoc = 0;
        /**
         * index - 0 - = إجمالي المكافأة index - 1 - = إجمالي الموظفين index - 2
         * - = إجمالي الموظفين بالموقع index - 3 - = إجمالي الموظفين بالخارج
         * index - 4 - = إجمالي الموظفين المعتمد لهم المكافأة index - 5 - =
         * إجمالي الموظفين المرفوضين
         */

        if (p.getChkStatus() < 2 /*!PayDeserveEmpFileDtlList.isEmpty()*/) {
            for (PayDeserveEmpFileDtl pdefd : p.getPayDeserveEmpFileDtls()) {
                ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(pdefd.getPayEmployeeMasterByEmployeeId().getEmployeeId());
                String CompareLocCode = pList.get(0).getPerLocationCodes().getId().getLocCode();
                String CompareLocationCode = pList.get(0).getPerLocationCodes().getId().getLocationCode();
                if (LocCode.equals(CompareLocCode) && LocationCode.equals(CompareLocationCode)) {
                    RewardTotal_InLoc_Before += Double.parseDouble("" + pdefd.getVal());
                    EmpTotal_InLoc++;
                } else {
                    RewardTotal_OutLoc_Before += Double.parseDouble("" + pdefd.getVal());
                    EmpTotal_OutLoc++;
                }

                RewardTotal_InLoc_After = 0.0;
                RewardTotal_OutLoc_After = 0.0;
            }
        } else {
            //// جدول البيانات بعد السحب
            List<PayDeserveEmp> pdeList = new PayDeserveEmp_DAO().getPayDeserveEmpByID("" + p.getId().getOpenMm(), "" + p.getId().getOpenYyyy(), "" + p.getId().getBandCode(), "" + p.getId().getBandType(), p.getId().getLocationCode(), p.getId().getLocCode());
            for (PayDeserveEmp pde : pdeList) {
                ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(pde.getPayEmployeeMaster().getEmployeeId());
                String CompareLocCode = pList.get(0).getPerLocationCodes().getId().getLocCode();
                String CompareLocationCode = pList.get(0).getPerLocationCodes().getId().getLocationCode();
                if (LocCode.equals(CompareLocCode) && LocationCode.equals(CompareLocationCode)) {
                    RewardTotal_InLoc_Before += Double.parseDouble("" + pde.getValFile());
                    RewardTotal_InLoc_After += Double.parseDouble("" + pde.getVal());;
                    EmpTotal_InLoc++;
                } else {
                    RewardTotal_OutLoc_Before += Double.parseDouble("" + pde.getValFile());
                    RewardTotal_OutLoc_After += Double.parseDouble("" + pde.getVal());
                    EmpTotal_OutLoc++;
                }

            }

            List<PayDeserveEmpFileDtlRuf> pdefdrList = new PayDeserveEmpFileDtlRuf_DAO().getPayDeserveEmpFileDtlRufByID("" + p.getId().getOpenMm(), "" + p.getId().getOpenYyyy(), "" + p.getId().getBandCode(), "" + p.getId().getBandType(), p.getId().getLocationCode(), p.getId().getLocCode());
            if (!pdefdrList.isEmpty()) {
                for (PayDeserveEmpFileDtlRuf pdefdr : pdefdrList) {
                    ///// Ask if The Employee At The Same Location Which Giving The Reward or No To Change The Color Of Row
                    RewardTotalReffused += Double.parseDouble("" + pdefdr.getVal());
                    EmpTotal_Ref++;
                }

            }
        }
        _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass empCountsDashBoard = new _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass(RewardTotalReffused, RewardTotal_InLoc_Before, RewardTotal_OutLoc_Before, RewardTotal_InLoc_After, RewardTotal_OutLoc_After, EmpTotal_InLoc, EmpTotal_OutLoc, EmpTotal_Ref);

        return empCountsDashBoard;
    }
}
