/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_3_JasonFiles;

import java.util.List;

/**
 *
 * @author Support
 */
public class _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile {

    private String decisionNo;
    private String decisionTypeCode;
    private String desicionSideCode;
    private String decisionSubject;
    private String decisionSummary;
    private List<String> perEmpDecisionSheets;
    private List<String> perDecisionSheetImageDtl;

    public _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile(){
        
    }
    public _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile(String decisionNo, String decisionTypeCode, String desicionSideCode, String decisionSubject, String decisionSummary, List<String> perEmpDecisionSheets, List<String> perDecisionSheetImageDtl) {
        this.decisionNo = decisionNo;
        this.decisionTypeCode = decisionTypeCode;
        this.desicionSideCode = desicionSideCode;
        this.decisionSubject = decisionSubject;
        this.decisionSummary = decisionSummary;
        this.perEmpDecisionSheets = perEmpDecisionSheets;
        this.perDecisionSheetImageDtl = perDecisionSheetImageDtl;
    }

    public String getDecisionNo() {
        return decisionNo;
    }

    public void setDecisionNo(String decisionNo) {
        this.decisionNo = decisionNo;
    }

    public String getDecisionTypeCode() {
        return decisionTypeCode;
    }

    public void setDecisionTypeCode(String decisionTypeCode) {
        this.decisionTypeCode = decisionTypeCode;
    }

    public String getDesicionSideCode() {
        return desicionSideCode;
    }

    public void setDesicionSideCode(String desicionSideCode) {
        this.desicionSideCode = desicionSideCode;
    }

    public String getDecisionSubject() {
        return decisionSubject;
    }

    public void setDecisionSubject(String decisionSubject) {
        this.decisionSubject = decisionSubject;
    }

    public String getDecisionSummary() {
        return decisionSummary;
    }

    public void setDecisionSummary(String decisionSummary) {
        this.decisionSummary = decisionSummary;
    }

    public List<String> getPerEmpDecisionSheets() {
        return perEmpDecisionSheets;
    }

    public void setPerEmpDecisionSheets(List<String> perEmpDecisionSheets) {
        this.perEmpDecisionSheets = perEmpDecisionSheets;
    }

    public List<String> getPerDecisionSheetImageDtl() {
        return perDecisionSheetImageDtl;
    }

    public void setPerDecisionSheetImageDtl(List<String> perDecisionSheetImageDtl) {
        this.perDecisionSheetImageDtl = perDecisionSheetImageDtl;
    }
    
}
