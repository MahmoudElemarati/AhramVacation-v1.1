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
public class PayReqChkView  {
    public String [] getchkViewName(int ChkView){
        //0 new Request
        //1 Approved
        //2 Ignored       
        List<String> chkViewList= new ArrayList<String>();
        List<String> colors= new ArrayList<String>();
        List<String> Images= new ArrayList<String>();
        chkViewList.add(" تم إرسال الطلب");colors.add("red");Images.add("webDesign/production/images/mail.png");
        chkViewList.add(" جاري التنفيذ");colors.add("#ff9209");Images.add("webDesign/production/images/Spin-0.9s-200px.gif");
        chkViewList.add(" تم التنفيذ");colors.add("green");Images.add("webDesign/production/images/correctmark.png");
        if(ChkView>2 && ChkView<0){
            ChkView=0;
        }
        String data[]={chkViewList.get(ChkView),colors.get(ChkView),Images.get(ChkView)};
        return data;        
    }
}