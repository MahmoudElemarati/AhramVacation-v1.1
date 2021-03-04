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
public class _0_0_0_4_5_3_Employees_Rewards_01_Jason {

    private String dateFrom;
    private String dateTo;
    private String locationCode;
    private String rejects;
    private String parts;
    private String detailType;
    private List<String> locCode;
    private List<String> bandCode;

    public _0_0_0_4_5_3_Employees_Rewards_01_Jason() {

    }

    public _0_0_0_4_5_3_Employees_Rewards_01_Jason(String dateFrom, String dateTo, String locationCode, List<String> locCode, List<String> bandCode, String rejects, String parts, String detailType) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.locationCode = locationCode;
        this.locCode = locCode;
        this.bandCode = bandCode;
        this.rejects = rejects;
        this.parts = parts;
        this.detailType = detailType;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public List<String> getLocCode() {
        return locCode;
    }

    public void setLocCode(List<String> locCode) {
        this.locCode = locCode;
    }

    public List<String> getBandCode() {
        return bandCode;
    }

    public void setBandCode(List<String> bandCode) {
        this.bandCode = bandCode;
    }

    public String getRejects() {
        return rejects;
    }

    public void setRejects(String rejects) {
        this.rejects = rejects;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

}
