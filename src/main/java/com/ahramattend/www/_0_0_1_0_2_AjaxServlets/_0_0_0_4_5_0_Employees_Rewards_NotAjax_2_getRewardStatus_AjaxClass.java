/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

import com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayDeserveEmpFile;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PayExecutionDate;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayDeserveEmpFile_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayExecutionDate_DAO;
import java.util.List;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_0_Employees_Rewards_NotAjax_2_getRewardStatus_AjaxClass {
    public String getStatus(String LocCode, String LocationCode, String bandCode, String bandType, String month, String openMm, String openYyyy) throws Exception {
        String HTML_TEXT = "";
        DateOp dOp = new DateOp();
        List<PayExecutionDate> pList = new PayExecutionDate_DAO().getAllExecutionDateBy(month, bandCode, bandType, LocationCode, LocCode);
        if (pList.isEmpty()) {
            HTML_TEXT = "غير متاح";
        } else {
            List<PayDeserveEmpFile> pdefList = new PayDeserveEmpFile_DAO().getPayDeserveEmpFileByIDString(openMm, openYyyy, bandCode, bandType, LocationCode, LocCode);
            if (pdefList.isEmpty()) {
                HTML_TEXT = "جديد";
            } else {
                PayDeserveEmpFile pdef = pdefList.get(0);
                DateOp dateOp = new DateOp();
                if (pdef.getChkStatus() == 0) {
                    String cureentDateStr = dateOp.Date2String(dateOp.String2Date(pdef.getCurrTime(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
                    String cureentTimeStr = dateOp.Date2String(dateOp.String2Date(pdef.getCurrTime(), "yyyy-MM-dd HH:mm:ss"), "hh:mm:ss a");

                    HTML_TEXT = "مسجل بتاريخ : " + cureentDateStr + " وبتوقيت : " + cureentTimeStr;

                } else if (pdef.getChkStatus() == 1) {
                    HTML_TEXT = "مغلق بتارخ : " + pdef.getSendDate();
                } else if (pdef.getChkStatus() == 2) {
                    HTML_TEXT = "جاري التنفيذ";
                } else if (pdef.getChkStatus() == 3) {
                    HTML_TEXT = "تم التنفيذ";
                }
            }
        }
        return HTML_TEXT;
    }
}
