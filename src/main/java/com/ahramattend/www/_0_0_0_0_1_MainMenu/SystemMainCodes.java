/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_0_1_MainMenu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class SystemMainCodes {
    public String [] getVacStatusName(int vacStatus){
        //0 new Request
        //1 Approved
        //2 Ignored       
        List<String> vacStatusList= new ArrayList<String>();
        List<String> colors= new ArrayList<String>();
        List<String> Images= new ArrayList<String>();
        vacStatusList.add(" لم تعتمد بعد");colors.add("#ff9209");Images.add("webDesign/production/images/cogs.gif");
        vacStatusList.add(" تمت الموافقة");colors.add("green");Images.add("webDesign/production/images/correctmark.png");
        vacStatusList.add(" مرفوضة");colors.add("red");Images.add("webDesign/production/images/wrongmark.png");
        if(vacStatus>2 && vacStatus<0){
            vacStatus=0;
        }
        String data[]={vacStatusList.get(vacStatus),colors.get(vacStatus),Images.get(vacStatus)};
        return data;        
    }
    
    public String [] getReqStatusName(int vacStatus){
        //0 new Request
        //1 Approved
        //2 Ignored       
        List<String> ReqStatusList= new ArrayList<String>();
        List<String> colors= new ArrayList<String>();
        List<String> Images= new ArrayList<String>();
        ReqStatusList.add(" لم يتم الرد");colors.add("orange");Images.add("webDesign/production/images/mail1.png");
        ReqStatusList.add(" تم استقبال الطلب");colors.add("blue");Images.add("webDesign/production/images/cogs.gif");
        ReqStatusList.add(" تمت المراجعة");colors.add("green");Images.add("webDesign/production/images/correctmark.png");
       
        String data[]={ReqStatusList.get(vacStatus),colors.get(vacStatus),Images.get(vacStatus)};
        return data;        
    }
}
