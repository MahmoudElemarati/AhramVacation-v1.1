/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_1_0_3_JasonFiles;

import java.util.List;

/**
 *
 * @author MSaeed
 */
public class _0_0_0_1_bars_DashBoard_class1 {
    private List<String> parts;

    private List<_0_0_0_1_bars_DashBoard_class2> data_list;

    public _0_0_0_1_bars_DashBoard_class1() {
    }
    public _0_0_0_1_bars_DashBoard_class1(List<String> parts, List<_0_0_0_1_bars_DashBoard_class2> data) {
        this.parts = parts;
        this.data_list = data;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public List<_0_0_0_1_bars_DashBoard_class2> getData_list() {
        return data_list;
    }

    public void setData_list(List<_0_0_0_1_bars_DashBoard_class2> data_list) {
        this.data_list = data_list;
    }

}
