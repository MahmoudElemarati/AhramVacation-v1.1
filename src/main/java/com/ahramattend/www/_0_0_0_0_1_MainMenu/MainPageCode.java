package com.ahramattend.www._0_0_0_0_1_MainMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ahramattend.www._0_0_0_0_1_MainMenu.DevelopmenUserNametPassword;
import static com.ahramattend.www._0_0_0_0_1_MainMenu.arabicMenu.getArabicMenu;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eng_MahmoudAhmed
 */
public class MainPageCode {
    dbMenu d = new dbMenu();
    /**
     * class that used to get the HTML code of main tabs.
     *
     * @return HTML code of the main tabs of each system page.
     */
    public String sidebar_menu() {
        String HTML_Code = "";
        FileReader html_file;
        try {
            html_file = new FileReader("web/sidebar_menu.html");
            BufferedReader in = new BufferedReader(html_file);
            String str;
            while ((str = in.readLine()) != null) {
                HTML_Code += str + "\n";
            }
        } catch (IOException ex) {
            ex.getMessage();
        }

        return HTML_Code;
    }

    /**
     * class that used to get the HTML code of main tabs.
     *
     * @return HTML code of the main tabs of each system page.
     */
    public String testMethod(PerEmploymentMasters employee_session) {
        String Menu = "";
        String MenuType = "DB";
        String Language = "ar";
        switch (MenuType) {
            case "DB":
                Menu = d.getDBMenu(employee_session);
                break;
            case "HTML":
                if (Language.equals("ar")) {
                    Menu = getArabicMenu(employee_session);
                } else if (Language.equals("en")) {
                    //Menu = getEnglishMenu();
                }
                break;
        }

        return Menu;
    }

    public String testMethod1(PerEmploymentMasters employee_session) {
        DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(employee_session.getEmpAname());

        String employeeId = employee_session.getEmployeeId();
        ////System.out.println(employeeId);
        List<PerOrganizationStructure> PerOrganizationStructureBossList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employeeId);
//_9_9_9_9_9_9_Application_Super_Control_AccessServlet
        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (p.isStatus() /*|| AdminAccess*/) {
            Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-calendar\"></i>التحكم في النظام<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                     <ul class=\"nav child_menu\">\n";

            // البيانات الأساسية
            Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_9_Application_Super_Control_AccessServlet\" style=\"font-weight: bold;\">شاشة التحم الرئيسية</a></li>\n";

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n";
        } //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else {

            Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-calendar\"></i>طلبات الأجازة<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                     <ul class=\"nav child_menu\">\n";

            // البيانات الأساسية
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_1_PerEmpVacationReqJava_AccessServlet\" style=\"font-weight: bold;\">طلب أجازة</a></li>\n";
            }
            if (!PerOrganizationStructureBossList.isEmpty()) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_3_PerEmpVacationReqJava_ManagerApproved_AccessServlet\" style=\"font-weight: bold;\">اعتماد الاجازات</a></li>\n";
            }
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_0_0_PerAttendanceExistZk_ForEmp_AccessServlet\" style=\"font-weight: bold;\"> حركات الحضور والانصراف الخاصة</a></li>\n";
            }
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_0_1_PerAttendanceExistZk_For_All_AccessServlet\" style=\"font-weight: bold;\">حركات الحضور والانصراف</a></li>\n";
            }

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n";

            Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i>الاستعلام عن الاجازات<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_1_PerEmpVacationTrans_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن الاجازات</a></li>\n";
            }
            if (!PerOrganizationStructureBossList.isEmpty()) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_2_PerEmpVacationTrans_QueryForBoss_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن اجازات موظفين اخرين</a></li>\n";
            }

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n"
                    + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-file-text-o\"></i>مستندات الموظف<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            // المعاملات
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_6_1_PerEmpFileDoc_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن مستندات الموظف</a></li>\n";
            }

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n"
                    + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-edit\"></i>استعلامات شئون العاملين<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            // المعاملات
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_7_1_PerEmploymentMasters_QueryReport_AccessServlet\" style=\"font-weight: bold;\">بيان حالة الموظف</a></li>\n";
            }
            if (true) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_8_1_PayEmployeeReq_AccessServlet\" style=\"font-weight: bold;\">طلب مفردات مرتب</a></li>\n";
            }

            if (employeeId.equals("2307")) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_9_1_ResetPasword_AccessServlet\" style=\"font-weight: bold;\">إعادة تعيين كلمة المرور</a></li>\n";
            }
            /*if (true ) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_8_2_PayEmployeeReq_HRApproved_AccessServlet\" style=\"font-weight: bold;\">اعتماد طلبات مفردات المرتب</a></li>\n";
        }*/
            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n"
                    + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-bar-chart\"></i>احصائيات<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            // المعاملات
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_1_0_0_Dash_Board_Main_AccessServlet\" style=\"font-weight: bold;\">احصائيات شئون العاملين</a></li>\n";
            }
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_1_5_0_Dash_Board_Sarf_Main_AccessServlet\" style=\"font-weight: bold;\">احصائيات الأجور</a></li>\n";
            }

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n";

            Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i>مدخلات شئون العاملين<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_3_0_0_PerSectionCode_AddSection_AccessServlet\" style=\"font-weight: bold;\">الأقسام</a></li>\n";
            }

            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_3_0_1_PerDeptCode_AddDept_AccessServlet\" style=\"font-weight: bold;\">الوحدات</a></li>\n";
            }
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_0_document_scan_AccessServlet\" style=\"font-weight: bold;\">تصوير قرارات</a></li>\n";
            }
            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_1_document_query_AccessServlet\" style=\"font-weight: bold;\">إستعلام عن القرارات</a></li>\n";
            }

            Sidebar_Menu += "                </ul>\n"
                    + "            </li>\n";

            Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i>اللوائح التنظيمية<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                    + "                <ul class=\"nav child_menu\">\n";

            if (true /*|| AdminAccess*/) {
                Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_2_Attendance_ByLaw_AccessServlet\" style=\"font-weight: bold;\">لائحة نظام الحضور والانصراف</a></li>\n";
            }

            Sidebar_Menu += "        </ul>"
                    + "</li>\n";

        }
        Sidebar_Menu += "    </div>\n"
                + "</div>";

        return Sidebar_Menu;
    }

    public String getUserMenu() {
        return "<ul class=\"dropdown-menu dropdown-usermenu pull-right\" style=\"font-size: 16px;\">\n"
                + "                                        <li><a href=\"_0_0_0_0_0_2_WelcomePage_AccessServlet\"><i class=\"fa fa-home pull-right\" style=\"font-size: 25px;\"></i>الرئيسية</a></li>\n"
                + "                                        <li><a href=\"_0_0_0_0_0_3_userProfile_AccessServlet\"><i class=\"fa fa-user pull-right\" style=\"font-size: 25px;\"></i>البيانات الشخصية</a></li>\n"
                + "                                        <li id='logout'><a  href=\"LogOutControlServlet\"><i class=\"fa fa-sign-out pull-right\" style=\"font-size: 25px;\"></i>خروج</a></li>\n"
                + "                                    </ul>";
    }

    private String test(PerEmploymentMasters employee_session) {
        DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(employee_session.getEmpAname());

        String employeeId = employee_session.getEmployeeId();
        String CheckAllow = "";
        List<PerOrganizationStructure> PerOrganizationStructureBossList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employeeId);

        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n"
                + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-calendar\"></i>طلبات الأجازة<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                <ul class=\"nav child_menu\">\n";

        // البيانات الأساسية
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_1_PerEmpVacationReqJava_AccessServlet\" style=\"font-weight: bold;\">طلب أجازة</a></li>\n";
        }
        if (!PerOrganizationStructureBossList.isEmpty()) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_3_PerEmpVacationReqJava_ManagerApproved_AccessServlet\" style=\"font-weight: bold;\">اعتماد الاجازات</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n"
                + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i>الاستعلام عن الاجازات<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_1_PerEmpVacationTrans_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن الاجازات</a></li>\n";
        }
        if (!PerOrganizationStructureBossList.isEmpty()) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_2_PerEmpVacationTrans_QueryForBoss_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن اجازات موظفين اخرين</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n"
                + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-file-text-o\"></i>مستندات الموظف<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                <ul class=\"nav child_menu\">\n";

        // المعاملات
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_6_1_PerEmpFileDoc_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن مستندات الموظف</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n"
                + "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-edit\"></i>استعلامات شئون العاملين<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                <ul class=\"nav child_menu\">\n";

        // المعاملات
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_7_1_PerEmploymentMasters_QueryReport_AccessServlet\" style=\"font-weight: bold;\">بيان حالة الموظف</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_8_1_PayEmployeeReq_AccessServlet\" style=\"font-weight: bold;\">طلب مفردات مرتب</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_8_2_PayEmployeeReq_HRApproved_AccessServlet\" style=\"font-weight: bold;\">اعتماد طلبات مفردات المرتب</a></li>\n";
        }
        if (true) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_9_1_ResetPasword_AccessServlet\" style=\"font-weight: bold;\">إعادة تعيين كلمة المرور</a></li>\n";
        }

        Sidebar_Menu += "        </ul></li>\n";

        Sidebar_Menu += "    </div>\n"
                + "</div>";

        return Sidebar_Menu;
    }

}
