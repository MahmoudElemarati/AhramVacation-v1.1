/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_0_1_MainMenu;

import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters;
import com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure;
import com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO;
import java.util.List;

/**
 *
 * @author Moham
 */
public class arabicMenu {

    public static String getArabicMenu(PerEmploymentMasters employee_session) {
        DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(employee_session.getEmpAname());

        String employeeId = employee_session.getEmployeeId();
        ////System.out.println(employeeId);
        List<PerOrganizationStructure> PerOrganizationStructureBossList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employeeId);

        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Sidebar_Menu += Nezam5edmatElmoazafen();
        Sidebar_Menu += NezamSh20nEl3amelean();
        Sidebar_Menu += NezamEl27sa2yat();
        Sidebar_Menu += NezamEllw27();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
        Sidebar_Menu += "   </ul></div>\n"
                + "</div>";

        return Sidebar_Menu;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //نظام خدمة الموظفين///////////////////////////////////////////////////////////////////
    public static String Nezam5edmatElmoazafen() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>نظام خدمة الموظفين<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += TalabatEl2gaza();
        Sidebar_Menu += Est3lam_3n_El2agazat();
        Sidebar_Menu += MostanadatElmoazaf();
        Sidebar_Menu += al7dorAndElensraf();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //طلبات أجازة ///////////////////////////////////////////////////////////////////
    public static String TalabatEl2gaza() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-calendar\"></i>طلبات أجازة<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_1_PerEmpVacationReqJava_AccessServlet\" style=\"font-weight: bold;\">طلب أجازة</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_4_3_PerEmpVacationReqJava_ManagerApproved_AccessServlet\" style=\"font-weight: bold;\">اعتماد الاجازات</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //إستعلام عن الأجازات ///////////////////////////////////////////////////////////////////
    public static String Est3lam_3n_El2agazat() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i>إستعلام عن الأجازات<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_1_PerEmpVacationTrans_Query_AccessServlet\" style=\"font-weight: bold;\">الإستعلام عن الأجازات الخاصة</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_5_2_PerEmpVacationTrans_QueryForBoss_AccessServlet\" style=\"font-weight: bold;\">إستعلامات عن أجازات موظفين للمدير</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //مستندات الموظف ///////////////////////////////////////////////////////////////////
    public static String MostanadatElmoazaf() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-file-text-o\"></i>مستندات الموظف<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_6_1_PerEmpFileDoc_Query_AccessServlet\" style=\"font-weight: bold;\">الإستعلام عن ملف الموظف</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_7_1_PerEmploymentMasters_QueryReport_AccessServlet\" style=\"font-weight: bold;\">بيان حالة الموظف</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_0_8_1_PayEmployeeReq_AccessServlet\" style=\"font-weight: bold;\">طلب مفردات مرتب</a></li>\n";
        }
        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //الحضور والإنصراف ///////////////////////////////////////////////////////////////////
    public static String al7dorAndElensraf() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-clock-o\"></i>الحضور والإنصراف<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_0_0_PerAttendanceExistZk_ForEmp_AccessServlet\" style=\"font-weight: bold;\"> حركات الحضور والانصراف الخاصة</a></li>\n";
        }
        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //نظام شئون العاملين///////////////////////////////////////////////////////////////////
    public static String NezamSh20nEl3amelean() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>نظام خدمة الموظفين<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += ElbayanatEl2sasya();
        Sidebar_Menu += BayanatElkrarat();
        Sidebar_Menu += Al7dorAndElensraf();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //البيانات الأساسية ///////////////////////////////////////////////////////////////////
    public static String ElbayanatEl2sasya() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-database\"></i>البيانات الأساسية<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_3_0_0_PerSectionCode_AddSection_AccessServlet\" style=\"font-weight: bold;\">الأقسام</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_3_0_1_PerDeptCode_AddDept_AccessServlet\" style=\"font-weight: bold;\">الوحدات</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //بيانات القرارات ///////////////////////////////////////////////////////////////////
    public static String BayanatElkrarat() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-bullhorn\"></i>بيانات القرارات<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_0_document_scan_AccessServlet\" style=\"font-weight: bold;\">تصوير قرارات</a></li>\n";
        }
        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_1_document_query_AccessServlet\" style=\"font-weight: bold;\">إستعلام عن القرارات</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //الحضور والإنصراف ///////////////////////////////////////////////////////////////////
    public static String Al7dorAndElensraf() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-clock-o\"></i>الحضور والإنصراف<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_0_1_PerAttendanceExistZk_For_All_AccessServlet\" style=\"font-weight: bold;\">حركات الحضور والإنصراف للموظفين</a></li>\n";
        }
        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //نظام الإحصائيات///////////////////////////////////////////////////////////////////
    public static String NezamEl27sa2yat() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>نظام الإحصائيات<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += A7sa2yatSh20nEl3amlean();
        Sidebar_Menu += A7sa2yatElMalyat();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //إحصائيات شئون العاملين ///////////////////////////////////////////////////////////////////
    public static String A7sa2yatSh20nEl3amlean() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-bar-chart\"></i>إحصائيات شئون العاملين<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_1_0_0_Dash_Board_Main_AccessServlet\" style=\"font-weight: bold;\">برنامح الإحصائيات</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    //إحصائيات الماليات///////////////////////////////////////////////////////////////////
    public static String A7sa2yatElMalyat() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-bar-chart\"></i>إحصائيات الماليات<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_1_5_0_Dash_Board_Sarf_Main_AccessServlet\" style=\"font-weight: bold;\">إحصائيات الأجور</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //نظام اللوائح///////////////////////////////////////////////////////////////////
    public static String NezamEllw27() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>نظام اللوائح<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += allwa27Altanzmia();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }
    //اللوائح التنظيمية ///////////////////////////////////////////////////////////////////
    public static String allwa27Altanzmia() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-book\"></i>اللوائح التنظيمية<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        if (true /*|| AdminAccess*/) {
            Sidebar_Menu += "                    <li><a href=\"_0_0_0_4_0_2_Attendance_ByLaw_AccessServlet\" style=\"font-weight: bold;\">لائحة نظام الحضور والإنصراف</a></li>\n";
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }
}
