/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_2_1_Jason_Entities;

/**
 *
 * @author Mohamed
 */
public class AppEmployeeReq_Jason {

    private String employee_no;
    private String employee_type;// From (Sender) - To
    private String employee_name;
    private String employee_rmrk;
    private String applicationId;
    private String applicationName;
    private String appReqType;
    private String appReqTypeName;
    private String mainRmrk;
    private String reqDateTime;
    private String chkView;
    private String chkRev;
    private String doneDateTime;
    private String sendDate;
    private String reqSp;
    private String employee_org;
    
    public AppEmployeeReq_Jason() {

    }

    public AppEmployeeReq_Jason(String employee_no, String employee_type, String employee_name, String employee_rmrk, String applicationId, String applicationName, String appReqType, String appReqTypeName, String mainRmrk, String reqDateTime, String chkView, String chkRev, String doneDateTime, String sendDate, String reqSp, String employee_org) {
        this.employee_no = employee_no;
        this.employee_type = employee_type;
        this.employee_name = employee_name;
        this.employee_rmrk = employee_rmrk;
        this.applicationId = applicationId;
        this.applicationName = applicationName;
        this.appReqType = appReqType;
        this.appReqTypeName = appReqTypeName;
        this.mainRmrk = mainRmrk;
        this.reqDateTime = reqDateTime;
        this.chkView = chkView;
        this.chkRev = chkRev;
        this.doneDateTime = doneDateTime;
        this.sendDate = sendDate;
        this.reqSp = reqSp;
        this.employee_org = employee_org;
    }

    public String getEmployee_org() {
        return employee_org;
    }

    public void setEmployee_org(String employee_org) {
        this.employee_org = employee_org;
    }

    
    public String getChkRev() {
        return chkRev;
    }

    public void setChkRev(String chkRev) {
        this.chkRev = chkRev;
    } 
    

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_rmrk() {
        return employee_rmrk;
    }

    public void setEmployee_rmrk(String employee_rmrk) {
        this.employee_rmrk = employee_rmrk;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getAppReqType() {
        return appReqType;
    }

    public void setAppReqType(String appReqType) {
        this.appReqType = appReqType;
    }

    public String getMainRmrk() {
        return mainRmrk;
    }

    public void setMainRmrk(String mainRmrk) {
        this.mainRmrk = mainRmrk;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAppReqTypeName() {
        return appReqTypeName;
    }

    public void setAppReqTypeName(String appReqTypeName) {
        this.appReqTypeName = appReqTypeName;
    }

    public String getReqDateTime() {
        return reqDateTime;
    }

    public void setReqDateTime(String reqDateTime) {
        this.reqDateTime = reqDateTime;
    }

    public String getChkView() {
        return chkView;
    }

    public void setChkView(String chkView) {
        this.chkView = chkView;
    }

    public String getDoneDateTime() {
        return doneDateTime;
    }

    public void setDoneDateTime(String doneDateTime) {
        this.doneDateTime = doneDateTime;
    }

    public String getReqSp() {
        return reqSp;
    }

    public void setReqSp(String reqSp) {
        this.reqSp = reqSp;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

}
