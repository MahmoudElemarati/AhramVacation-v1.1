/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_2_AjaxServlets;

/**
 *
 * @author Support
 */
public class _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass {

    private double RewardTotalReffused = 0.0;

    private double RewardTotalBefore = 0.0;
    private double RewardTotal_InLoc_Before = 0.0;
    private double RewardTotal_OutLoc_Before = 0.0;

    private double RewardTotalAfter = 0.0;
    private double RewardTotal_InLoc_After = 0.0;
    private double RewardTotal_OutLoc_After = 0.0;

    private int EmpTotal_Reward = 0;
    private int EmpTotal_InLoc = 0;
    private int EmpTotal_OutLoc = 0;

    private int EmpTotal_Ref = 0;

    public _0_0_0_4_5_2_Employees_Rewards_Query_Not_Ajax_2_dashboard_AjaxClass(
            double RewardTotalReffused,
            double RewardTotal_InLoc_Before, double RewardTotal_OutLoc_Before,
            double RewardTotal_InLoc_After, double RewardTotal_OutLoc_After,
            int EmpTotal_InLoc, int EmpTotal_OutLoc,
            int EmpTotal_Ref) {

        this.RewardTotal_InLoc_Before = RewardTotal_InLoc_Before;
        this.RewardTotal_OutLoc_Before = RewardTotal_OutLoc_Before;
        this.RewardTotalBefore = RewardTotal_InLoc_Before + RewardTotal_OutLoc_Before;

        this.RewardTotal_InLoc_After = RewardTotal_InLoc_After;
        this.RewardTotal_OutLoc_After = RewardTotal_OutLoc_After;
        this.RewardTotalAfter = RewardTotal_InLoc_After + RewardTotal_OutLoc_After;

        this.EmpTotal_InLoc = EmpTotal_InLoc;
        this.EmpTotal_OutLoc = EmpTotal_OutLoc;
        this.EmpTotal_Reward = EmpTotal_InLoc + EmpTotal_OutLoc;

        this.EmpTotal_Ref = EmpTotal_Ref;
        this.RewardTotalReffused = RewardTotalReffused;
    }

    public double getRewardTotalBefore() {
        return RewardTotalBefore;
    }

    public double getRewardTotalAfter() {
        return RewardTotalAfter;
    }

    public double getRewardTotalReffused() {
        return RewardTotalReffused;
    }

    public void setRewardTotalReffused(double RewardTotalReffused) {
        this.RewardTotalReffused = RewardTotalReffused;
    }

    public int getEmpTotal_Reward() {
        return EmpTotal_Reward;
    }

    public int getEmpTotal_InLoc() {
        return EmpTotal_InLoc;
    }

    public void setEmpTotal_InLoc(int EmpTotal_InLoc) {
        this.EmpTotal_InLoc = EmpTotal_InLoc;
    }

    public int getEmpTotal_OutLoc() {
        return EmpTotal_OutLoc;
    }

    public void setEmpTotal_OutLoc(int EmpTotal_OutLoc) {
        this.EmpTotal_OutLoc = EmpTotal_OutLoc;
    }

    public int getEmpTotal_Ref() {
        return EmpTotal_Ref;
    }

    public void setEmpTotal_Ref(int EmpTotal_Ref) {
        this.EmpTotal_Ref = EmpTotal_Ref;
    }

    public double getRewardTotal_InLoc_Before() {
        return RewardTotal_InLoc_Before;
    }

    public void setRewardTotal_InLoc_Before(double RewardTotal_InLoc_Before) {
        this.RewardTotal_InLoc_Before = RewardTotal_InLoc_Before;
    }

    public double getRewardTotal_OutLoc_Before() {
        return RewardTotal_OutLoc_Before;
    }

    public void setRewardTotal_OutLoc_Before(double RewardTotal_OutLoc_Before) {
        this.RewardTotal_OutLoc_Before = RewardTotal_OutLoc_Before;
    }

    public double getRewardTotal_InLoc_After() {
        return RewardTotal_InLoc_After;
    }

    public void setRewardTotal_InLoc_After(double RewardTotal_InLoc_After) {
        this.RewardTotal_InLoc_After = RewardTotal_InLoc_After;
    }

    public double getRewardTotal_OutLoc_After() {
        return RewardTotal_OutLoc_After;
    }

    public void setRewardTotal_OutLoc_After(double RewardTotal_OutLoc_After) {
        this.RewardTotal_OutLoc_After = RewardTotal_OutLoc_After;
    }

}
