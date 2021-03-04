/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_0_1_MainMenu;

import com.ahramattend.www._0_0_0_0_2_AhramLib.Encryption;
import com.ahramattend.www._0_0_0_0_2_AhramLib.FileOp;
import com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppName;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTabSpecAuth;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.AppTabs;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppName_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTabSpecAuth_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTab_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppTabs_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO;
import java.util.List;

/**
 *
 * @author Moham
 */
public class dbMenu {

    public synchronized String getDBMenu(PerEmploymentMasters employee_session) {
        DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(employee_session.getEmpAname());

        String employeeId = employee_session.getEmployeeId();
        ////System.out.println(employeeId);
        List<PerOrganizationStructure> PerOrganizationStructureBossList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employeeId);

        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";
        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<AppName> pList = new AppName_DAO().getAll_ApplicationName();
            for (AppName applicationName : pList) {
                Sidebar_Menu += Nezam(applicationName, employeeId);
                //break;
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sidebar_Menu += "   </ul></div>\n"
                + "</div>";
        return Sidebar_Menu;
    }

    public String Nezam(AppName applicationName, String employeeId) {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\" id='A_" + applicationName.getApplicationId() + "'><i class=\"fa fa-codepen\"></i>" + applicationName.getApplicationName() + "<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";
        List<AppTabs> pList = new AppTabs_DAO().get_ApplicationTabsByApplicationId("" + applicationName.getApplicationId());
        for (AppTabs applicationTabs : pList) {
            Sidebar_Menu += Tabs(applicationTabs, employeeId);
            //break;
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    public String Tabs(AppTabs applicationTabs, String employeeId) {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\" id='T_" + applicationTabs.getId().getApplicationId() + "-" + applicationTabs.getId().getTabId() + "'><i class=\"" + applicationTabs.getTabFafaIcon() + "\"></i>" + applicationTabs.getTabName() + "<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";
        List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationId("" + applicationTabs.getId().getApplicationId(), "" + applicationTabs.getId().getTabId());
        for (AppSubTab applicationSubTab : pList) {
            String AvailableToUserControl = applicationSubTab.getAvailableToUserControl();
            String App = "" + applicationSubTab.getId().getApplicationId();
            String Tab = "" + applicationSubTab.getId().getTabId();
            String SubTab = "" + applicationSubTab.getId().getSubTabId();
            String status = new dbMenu().checkScreen(AvailableToUserControl, App, Tab, SubTab, employeeId);

            // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
            if (status.equals("1")) {
                Sidebar_Menu += "                    <li><a href=\"" + applicationSubTab.getSubTabAccessservlet() + "\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else if (status.equals("2")) {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('تم التلاعب برخصة شاشات النظام بقواعد البيانات .. برجاء الإتصال بالدعم الفني','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else if (status.equals("3")) {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('ليس لك صلاحية على تلك الشاشة','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('هذه النسخة تجريبية .. هذه الصفحة غير متاحة','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            }
            // break;
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    public String checkScreen(String AvailableToUserControl, String App, String Tab, String SubTab, String employeeId) {

        List<Character> chars = new Encryption().decrypt_AvailableToUserControl(AvailableToUserControl);

        boolean General = false;
        boolean LIC_File_Exist = false;
        boolean DB_Manipulation = false;
        boolean User_Access = false;
        boolean Screen_Active = false;
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
        String Status = "0";
        String AppCode = "" + chars.get(0);
        String TabCode = "" + chars.get(1);
        String SubTabCode = "" + chars.get(2);
        String statusCode = "" + chars.get(3);
        if (App.equals(AppCode) && Tab.equals(TabCode) && SubTab.equals(SubTabCode) && "1".equals(statusCode)) {
            Screen_Active = true;
        } else {
            Screen_Active = false;
        }
        String FileName = "S_" + App + Tab + SubTab;
        try {
            FileOp file = new FileOp("C:\\LIC\\b532t91\\" + FileName + ".txt");
            String line = file.ReadFileInWebApp();//2021-01-01
            if (!AvailableToUserControl.equals(line.split("\r\n")[0])) {
                DB_Manipulation = true;
            } else {
                List<AppSubTab> ApplicationSubTabList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationIdWithAuthType1(App, Tab, SubTab);
                List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(employeeId, App, Tab, SubTab);
                if (!ApplicationSubTabList.isEmpty()) {
                    General = true;
                }
                if (!screenAuthList.isEmpty()) {
                    User_Access = true;
                }

            }
            LIC_File_Exist = true;
        } catch (Exception e) {
            LIC_File_Exist = false;
        }
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
        
        if (!LIC_File_Exist || !Screen_Active) {
            Status = "0";
        } else if (DB_Manipulation) {
            Status = "2";
        } else if (General || User_Access) {
            Status = "1";
        } else {
            Status = "3";
        }
        /*//System.out.println(" -------------- APP_TAB_SUBTAB    = " + App+"-"+Tab+"-"+SubTab);
        //System.out.println(" -------------- LIC_File_Exist    = " + LIC_File_Exist);
        //System.out.println(" -------------- DB_Manipulation   = " + DB_Manipulation);
        //System.out.println(" --------------     General       = " + General);
        //System.out.println(" --------------   User_Access     = " + User_Access);
        //System.out.println(" --------------      Status       = " + Status);*/
        return Status;
    }
}
