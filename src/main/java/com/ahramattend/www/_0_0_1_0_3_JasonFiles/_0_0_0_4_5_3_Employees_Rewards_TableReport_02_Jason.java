/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_3_JasonFiles;

import com.ahramattend.www._0_0_1_0_2_AjaxServlets._0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason {

    private String bandName = "";
    private String locName = "";
    private String bandExecutionMonth = "";
    private String bandRegisterDate = "";

    private double rewardTotalReffused = 0.0;
    private double rewardTotalReffused_InLoc = 0.0;
    private double rewardTotalReffused_OutLoc = 0.0;

    private int empTotal_Ref = 0;
    private int empTotal_Ref_InLoc = 0;
    private int empTotal_Ref_OutLoc = 0;

    private double rewardTotal = 0.0;
    private double rewardTotal_InLoc = 0.0;
    private double rewardTotal_OutLoc = 0.0;

    private int empTotal_Reward = 0;
    private int empTotal_InLoc = 0;
    private int empTotal_OutLoc = 0;

    public _0_0_0_4_5_3_Employees_Rewards_TableReport_02_Jason(
            double rewardTotalReffused, double rewardTotalReffused_InLoc, double rewardTotalReffused_OutLoc,
            double rewardTotal_InLoc, double rewardTotal_OutLoc,
            int empTotal_InLoc, int empTotal_OutLoc,
            int empTotal_Ref, int empTotal_Ref_InLoc, int empTotal_Ref_OutLoc,
            String bandName, String locName, String bandExecutionMonth, String bandRegisterDate) {

        this.rewardTotal_InLoc = rewardTotal_InLoc;
        this.rewardTotal_OutLoc = rewardTotal_OutLoc;
        this.rewardTotal = rewardTotal_InLoc + rewardTotal_OutLoc;

        this.empTotal_InLoc = empTotal_InLoc;
        this.empTotal_OutLoc = empTotal_OutLoc;
        this.empTotal_Reward = empTotal_InLoc + empTotal_OutLoc;

        this.rewardTotalReffused_InLoc = rewardTotalReffused_InLoc;
        this.rewardTotalReffused_OutLoc = rewardTotalReffused_OutLoc;
        this.rewardTotalReffused = rewardTotalReffused_InLoc + rewardTotalReffused_OutLoc;

        this.empTotal_Ref_InLoc = empTotal_Ref_InLoc;
        this.empTotal_Ref_OutLoc = empTotal_Ref_OutLoc;
        this.empTotal_Ref = empTotal_Ref_InLoc + empTotal_Ref_OutLoc;

        this.bandName = bandName;
        this.locName = locName;
        this.bandExecutionMonth = bandExecutionMonth;
        this.bandRegisterDate = bandRegisterDate;
    }

    public double getRewardTotal() {
        return rewardTotal;
    }

    public double getRewardTotalReffused() {
        return rewardTotalReffused;
    }

    public void setRewardTotalReffused(double rewardTotalReffused) {
        this.rewardTotalReffused = rewardTotalReffused;
    }

    public int getEmpTotal_Reward() {
        return empTotal_Reward;
    }

    public int getEmpTotal_InLoc() {
        return empTotal_InLoc;
    }

    public void setEmpTotal_InLoc(int empTotal_InLoc) {
        this.empTotal_InLoc = empTotal_InLoc;
    }

    public int getEmpTotal_OutLoc() {
        return empTotal_OutLoc;
    }

    public void setEmpTotal_OutLoc(int empTotal_OutLoc) {
        this.empTotal_OutLoc = empTotal_OutLoc;
    }

    public int getEmpTotal_Ref() {
        return empTotal_Ref;
    }

    public void setEmpTotal_Ref(int EmpTotal_Ref) {
        this.empTotal_Ref = empTotal_Ref;
    }

    public double getRewardTotal_InLoc() {
        return rewardTotal_InLoc;
    }

    public void setRewardTotal_InLoc(double rewardTotal_InLoc) {
        this.rewardTotal_InLoc = rewardTotal_InLoc;
    }

    public double getRewardTotal_OutLoc() {
        return rewardTotal_OutLoc;
    }

    public void setRewardTotal_OutLoc(double rewardTotal_OutLoc) {
        this.rewardTotal_OutLoc = rewardTotal_OutLoc;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getBandExecutionMonth() {
        return bandExecutionMonth;
    }

    public void setBandExecutionMonth(String bandExecutionMonth) {
        this.bandExecutionMonth = bandExecutionMonth;
    }

    public String getBandRegisterDate() {
        return bandRegisterDate;
    }

    public void setBandRegisterDate(String bandRegisterDate) {
        this.bandRegisterDate = bandRegisterDate;
    }

    public double getRewardTotalReffused_InLoc() {
        return rewardTotalReffused_InLoc;
    }

    public void setRewardTotalReffused_InLoc(double rewardTotalReffused_InLoc) {
        this.rewardTotalReffused_InLoc = rewardTotalReffused_InLoc;
    }

    public double getRewardTotalReffused_OutLoc() {
        return rewardTotalReffused_OutLoc;
    }

    public void setRewardTotalReffused_OutLoc(double rewardTotalReffused_OutLoc) {
        this.rewardTotalReffused_OutLoc = rewardTotalReffused_OutLoc;
    }

    public int getEmpTotal_Ref_InLoc() {
        return empTotal_Ref_InLoc;
    }

    public void setEmpTotal_Ref_InLoc(int empTotal_Ref_InLoc) {
        this.empTotal_Ref_InLoc = empTotal_Ref_InLoc;
    }

    public int getEmpTotal_Ref_OutLoc() {
        return empTotal_Ref_OutLoc;
    }

    public void setEmpTotal_Ref_OutLoc(int empTotal_Ref_OutLoc) {
        this.empTotal_Ref_OutLoc = empTotal_Ref_OutLoc;
    }

}
