<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PaySarfCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PaySarfCode"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PaySarfCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayBankCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayBankCode"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayBankCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayFinancialGroupType_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayFinancialGroupType"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayEmployeeReqDtl"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayEmployeeReqDtl_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpHistory_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerGradePercentage"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerGradePercentage_DAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerCityCode"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpHistory"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpQualification"%>
<%@page import="java.util.Set"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerJobLaw_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerJobLaw"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmpFileDoc"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpFileDoc_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFileDocType_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileDocType"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileDocType"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFileType_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFileType"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerVacationCode"%>
<%@page import="java.util.List"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerVacationCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters"%>
<%@page import="com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon"%>
<%@page import="com.ahramattend.www._0_0_0_0_1_MainMenu.MainPageCode"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HibernateSessionCon.OpenCon();
    HibernateSessionCon.session.clear();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {

            PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");
            String employee_name = employee_session.getEmpAname();

            String ReqSp = (String) request.getSession().getAttribute("ReqSp");
            List<PayEmployeeReqDtl> pList = new PayEmployeeReqDtl_DAO().getPayEmployeeReqDtlID(ReqSp);

            List< PerEmploymentMasters> EmpList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(employee_session.getEmployeeId());

            if (EmpList.isEmpty()) {
            } else {
                PerEmploymentMasters emp = EmpList.get(0);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>مفردات مرتب الموظف</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/search.png">
        <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>

        <!-- Datatables -->
        <link href="webDesign/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- bootstrap-datetimepicker -->
        <link href="webDesign/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

        <!-- bootstrap-wysiwyg -->
        <link href="webDesign/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">
        <style>
            .cardclass{
                background-color: #851934;
                box-shadow: -3px 12px 12px 5px #888888;
                font-size: 160%;
            }
            .button_style{
                border: none;
                background: #337ab7;
                color: #ffffff !important;
                font-weight: 100;
                padding: 10px;
                text-transform: uppercase;
                border-radius: 6px;
                display: inline-block;
                transition: all 0.3s ease 0s;
            }
            .button_style:hover {
                color: #ffffff !important;
                font-weight: 700 !important;
                letter-spacing: 3px;
                background: #131e33;
                -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                transition: all 0.3s ease 0s;
            }
            .button_position{
                margin-top: 32px;
                width: 100%;

            }
            input:focus {
                background-color: #c4f5fa;
            }
            select:focus {
                background-color: #c4f5fa;
            }
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }
        </style>

    </head>

    <script>
        setInterval(drawTime, 1000);


        function drawTime() {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var day = now.getDate();
            var hour = now.getHours();
            var minute = now.getMinutes();
            var second = now.getSeconds();
            var AM = "AM";
            document.getElementById("clock").innerHTML = " " + hour + " : " + minute + " : " + second;
            document.getElementById("dateD").innerHTML = " " + year + " - " + month + " - " + day;
            document.getElementById("clock2").innerHTML = " " + hour + " : " + minute + " : " + second;
            document.getElementById("dateD2").innerHTML = " " + year + " - " + month + " - " + day;
        }
        function TodayName() {
            var d = new Date();
            var weekday = new Array(7);
            weekday[0] = "الأحد";
            weekday[1] = "الإثنين";
            weekday[2] = "الثلاثاء";
            weekday[3] = "الأربعاء";
            weekday[4] = "الخميس";
            weekday[5] = "الجمعة";
            weekday[6] = "السبت";

            var n = weekday[d.getDay()];
            document.getElementById("dayId").innerHTML = n;
        }

    </script>
    <body class="nav-md" onload="TodayName();" style="color: #000000;" >
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col menu_fixed">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;padding-top: 10px;">
                            <a href="_0_0_0_0_0_2_WelcomePage_AccessServlet" class="site_title">
                                <div style="width: 50%; margin-left: 0px;">
                                    <img src="webDesign/production/images/ahramTitle5.png" alt="..." height="50" style="margin-top: 0px;margin-left: 15%;border-radius: 15%;padding: 0px;width: 140%;">
                                </div>
                            </a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix" style="padding-top: 10px;">
                            <div class="profile_pic" style="padding-top: 8px;">
                                <img src="webDesign/Resources/images/user.png" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span style="font-size: 20px;padding-left: 20px;font-weight: bold;">اسم المستخدم</span>
                                <h2 style="font-size: 20px;font-weight: bold;"><%=employee_name%></h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- side bar menu -->
                        <%
                            String M = "";
                        %>
                        <%=M%>
                        <!-- /side bar menu -->


                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="" >
                                    <a href="javascript:;" id="user_menu" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color: black;font-size: 20px;">
                                        <%=employee_name%>
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <%
                                        String M2 = "";
                                    %>
                                    <%=M2%>
                                </li>
                                <li role="presentation" class="dropdown" >
                                    <a href="javascript:;" class=""  aria-expanded="false">

                                        <span class="badge bg-green fa fa-clock-o" id="clock" style="font-size: 20px;"></span>                                        
                                        <span class="badge bg-green fa fa-calendar" id="dateD" style="font-size: 20px;"></span>                                         
                                        <span class="" id="dayId" style="color: black;font-size: 20px;"></span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->





                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->




                <!-- page content -->

                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">عرض مفردات مرتب</h3>
                            </div>

                            <div style="direction: ltr;">
                                <button class="btn btn-success form-group fa fa-print" href="#" data-toggle="modal" id="UpdateButton" data-target="" style="background-color: #CC6600; border-color: #CC6600; width: 40%;margin-top: 0px;font-size: 20px;box-shadow: -1px 2px 5px 1px black;" onclick="printDiv();" type="button"> طباعة</button>
                            </div>


                        </div>
                        <div class="clearfix"></div>

                        <%
                            if (pList.isEmpty()) {
                            } else {
                                PayEmployeeReqDtl m = pList.get(0);
                        %>


                        <!--card Start -->
                        <div id="FullPrint">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;direction: rtl;" >
                                <!-- for Edit -->
                                <div class="table-responsive">
                                    <table id="" class="table">
                                        <tbody>
                                            <tr>
                                                <td style="text-align: right;width:10%;"><img src="webDesign/production/images/AhramSmall.png" alt="" border=1 height=100 width=200></td>
                                                <td style="text-align: center;font-size: 30px;width:30%;font-weight: bolder;"> <br><h style="font-size: 20px;">الإدارة العامة للاسـتحقاقات</h></td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align: right;font-size: 20px;font-weight:bold;width:8%;">التاريخ:</td>
                                        <td style="text-align: right;direction: ltr;font-size: 20px;width:15%;" id="dateD2"></td>

                                        <td style="text-align: right;font-size: 20px;font-weight:bold;width:8%;">الساعة:</td>
                                        <td style="text-align: right;direction: ltr;font-size: 20px;width:15%;" id="clock2"></td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr> 
                                                <td style="text-align: center;font-size: 30px;width:100%;font-weight: bolder;color: #327ab7;">عرض مفردات المرتب</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table id="" border="0" class="table">
                                        <tbody>
                                            <%
                                                String ArabMonth = "", execDate1 = "";
                                                try {
                                                    execDate1 = new DateOp().Date2String(m.getPayEmployeeReq().getExecDate(), "yyyy");
                                                } catch (Exception ex) {
                                                    execDate1 = " ...";
                                                }
                                                try {
                                                    ArabMonth = new DateOp().getMonthNameArabic(Integer.parseInt(new DateOp().Date2String(m.getPayEmployeeReq().getExecDate(), "MM")));
                                                } catch (Exception ex) {
                                                    ArabMonth = " ...";
                                                }

                                                String execDate = ArabMonth + " - " + execDate1;

                                            %>
                                            <tr> 
                                                <td style="text-align: center;font-size: 20px;width:100%;font-weight: bold;">بيانات مفردات المرتب عن شهر: <%=execDate%></td>
                                            </tr>
                                            <tr> 
                                                <td style="text-align: right;font-size: 20px;width:100%;font-weight: bold;">البيانات الاساسية للموظف</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr>
                                                <%
                                                    String StatusCode = "" + m.getStatusCode();
                                                    if (StatusCode == "" || StatusCode == null) {
                                                    } else {
                                                        List<PayFinancialGroupType> bList = new PayFinancialGroupType_DAO().getPayFinancialGroupTypeById(StatusCode);
                                                        PayFinancialGroupType s = bList.get(0);
                                                        String GroupName;
                                                        try {
                                                            GroupName = "" + s.getGroupName();
                                                        } catch (Exception ex) {
                                                            GroupName = "لا يوجد مجموعة مالية";
                                                        }
                                                        String DayNo;
                                                        try {
                                                            DayNo = "" + m.getDayNo();
                                                        } catch (Exception ex) {
                                                            DayNo = "لا يوجد مجموعة مالية";
                                                        }
                                                %>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;"> المجموعة المالية :</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=GroupName%></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">عدد الأيام الفعلية: </td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=DayNo%></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;"></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:22%;"></td>
                                                <%
                                                    }
                                                %>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table id="" class="table">
                                        <tbody>
                                            <tr>
                                                <%
                                                    String EmployeeNo;
                                                    try {
                                                        EmployeeNo = "" + employee_session.getEmployeeNo();
                                                    } catch (Exception ex) {
                                                        EmployeeNo = "لا يوجد رقم موظف";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">رقم الموظف:</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=EmployeeNo%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">اسم الموظف:</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;"><%=employee_name%></td>                                                

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;color: #327ab7;"></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:22%;"></td>
                                            </tr>
                                            <tr>
                                                <%
                                                    String Saraf, OrgName;
                                                    try {
                                                        OrgName = "" + emp.getPerOrganizationStructureByOrgId().getOrgName();
                                                    } catch (Exception ex) {
                                                        OrgName = "لا يوجد إسم إدارة";
                                                    }
                                                    String sarfCode = "" + m.getSarfCode();

                                                    if (sarfCode.equals("null")) {
                                                        Saraf = "لا يوجد صراف";
                                                    } else {
                                                        List<PaySarfCode> sarafList = new PaySarfCode_DAO().getPaySarfCodeById(sarfCode);
                                                        PaySarfCode sa = sarafList.get(0);
                                                        try {
                                                            Saraf = "" + sa.getSarfName();
                                                        } catch (Exception ex) {
                                                            Saraf = "لا يوجد صراف";
                                                        }
                                                    }


                                                %>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">الإدارة:</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=OrgName%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">الصراف :</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=Saraf%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;"></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:22%;"></td>                                                

                                            </tr>
                                            <tr>
                                                <%
                                                    String bank;
                                                    String bankCode = "" + m.getBankCode();

                                                    if (bankCode.equals("null")) {
                                                        bank = "لا يوجد بنك";
                                                    } else {
                                                        List<PayBankCode> bankList = new PayBankCode_DAO().getPayBankCodeById(bankCode);
                                                        PayBankCode ba = bankList.get(0);
                                                        bank = ba.getBankName();
                                                    }

                                                    String Branch = "...";
                                                %>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">البنك: </td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=bank%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">الفرع :</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=Branch%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;"></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:22%;"></td>
                                            </tr>
                                            <tr>
                                                <%
                                                    String job, degree;
                                                    try {
                                                        job = "" + emp.getPerJobCodeByJobCode().getJobName();
                                                    } catch (Exception ex) {
                                                        job = "لا يوجد وظيفة";
                                                    }
                                                    try {
                                                        try {
                                                            degree = "" + emp.getPerFiscalDegreeCodeNew().getFiscalDegreeNameNew();
                                                        } catch (Exception c) {
                                                            degree = "" + emp.getPerFiscalDegreeCode().getFiscalDegreeName();
                                                        }
                                                    } catch (Exception ex) {
                                                        degree = "لا يوجد درجة وظيفية";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">الوظيفة:</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=job%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:15%;color: #327ab7;">الدرجة:</td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:30%;"><%=degree%></td>

                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:10%;"></td>
                                                <td style="text-align: right;font-size: 20px;font-weight:bold;width:22%;"></td>

                                            </tr>
                                        </tbody>
                                    </table>


                                </div>

                                <div class="row table-responsive">
                                    <table id="" border="0" class="table">
                                        <tbody>                                    
                                            <tr> 
                                                <td style="text-align: center;font-size: 20px;width: 35%;">
                                                    <table id="DesVal" border="1" class="table">
                                                        <thead style="background-color: #327ab7;color: white;border-style: solid;border-color: black;">
                                                            <tr> 
                                                                <td colspan="2" style="text-align: center;font-size: 20px;width:100%;border-style: solid;border-color: black;">الإســتحقاقات</td>
                                                            </tr>
                                                            <tr> 
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;">المبلغ</td>
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;">البيان</td>
                                                            </tr>
                                                        </thead>
                                                        <tbody> 
                                                            <%
                                                                double TotalMost7kat = 0;
                                                                List<PayEmployeeReqDtl> eList = new PayEmployeeReqDtl_DAO().getPayEmployeeReqDtlByEst7qaqat(ReqSp);
                                                                for (PayEmployeeReqDtl e : eList) {
                                                                    TotalMost7kat += Double.parseDouble(e.getVal().toString());
                                                                    try {
                                                                        if (e.getId().getBandType() == 31 && e.getInsClass() == 1) {
                                                            %>
                                                            <tr> 
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getVal()%></td>
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getPayBandCode().getBandName()%></td>
                                                            </tr>
                                                            <%
                                                            } else if (e.getId().getBandType() == 1 || e.getId().getBandType() == 5) {
                                                            %>
                                                            <tr> 
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getVal()%></td>
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getPayBandCode().getBandName()%></td>
                                                            </tr>
                                                            <%

                                                                        }
                                                                    } catch (Exception ex) {

                                                                    }
                                                                }
                                                            %>

                                                        </tbody>
                                                    </table>
                                                </td>
                                                <td style="text-align: center;font-size: 20px;width: 35%;">
                                                    <table id="" border="1" class="table">
                                                        <thead style="background-color: #327ab7;color: white;border-style: solid;border-color: black;">
                                                            <tr> 
                                                                <td colspan="2" style="text-align: center;font-size: 20px;width:100%;border-style: solid;border-color: black;">الإســتقطاعات</td>
                                                            </tr>
                                                            <tr> 
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;">المبلغ</td>
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;">البيان</td>
                                                            </tr>
                                                        </thead>
                                                        <tbody>                                    
                                                            <%
                                                                double TotalEstkta3at = 0;
                                                                List<PayEmployeeReqDtl> eeList = new PayEmployeeReqDtl_DAO().getPayEmployeeReqDtlByEstqta3at(ReqSp);
                                                                for (PayEmployeeReqDtl e : eeList) {
                                                                    TotalEstkta3at += Double.parseDouble(e.getVal().toString());
                                                            %>
                                                            <tr> 
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getVal()%></td>
                                                                <td style="text-align: center;font-size: 20px;width:50%; "><%=e.getPayBandCode().getBandName()%></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                <td style="text-align: center;font-size: 20px;width: 30%;">
                                                    <table border="1" class="table">
                                                        <thead style="background-color: #327ab7;color: white;border-style: solid;border-color: black;">
                                                            <tr> 
                                                                <td colspan="3" style="text-align: center;font-size: 20px;width:100%;border-style: solid;border-color: black;">_</td>
                                                            </tr>
                                                            <tr> 
                                                                <td  style="text-align: center;font-size: 20px;width:33%;border-style: solid;border-color: black;">القسط</td>
                                                                <td  style="text-align: center;font-size: 20px;width:33%;border-style: solid;border-color: black;">الرصيد</td>
                                                                <td  style="text-align: center;font-size: 20px;width:33%;border-style: solid;border-color: black;">البيان</td>
                                                            </tr>
                                                        </thead>
                                                        <tbody>  
                                                            <%
                                                                List<PayEmployeeReqDtl> wwList = new PayEmployeeReqDtl_DAO().getPayEmployeeReqDtlByRaseed(ReqSp);
                                                                for (PayEmployeeReqDtl e : wwList) {
                                                                    String val, creditBalance, bandName;
                                                                    try {
                                                                        val = "" + e.getVal();
                                                                    } catch (Exception ex) {
                                                                        val = " - ";
                                                                    }
                                                                    try {
                                                                        creditBalance = "" + e.getCreditBalance();
                                                                    } catch (Exception ex) {
                                                                        creditBalance = " - ";
                                                                    }
                                                                    try {
                                                                        bandName = "" + e.getPayBandCode().getBandName();
                                                                    } catch (Exception ex) {
                                                                        bandName = " - ";
                                                                    }
                                                            %>
                                                            <tr> 
                                                                <td style="text-align: center;font-size: 20px;width:33%; "><%=val%></td>
                                                                <td style="text-align: center;font-size: 20px;width:33%; "><%=creditBalance%></td>
                                                                <td style="text-align: center;font-size: 20px;width:33%; "><%=bandName%></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="row table-responsive">
                                    <table id="" border="0" class="table">
                                        <tbody>                                    
                                            <tr> 
                                                <td style="text-align: center;font-size: 20px;width: 35%;">
                                                    <table id="" border="1" class="table">
                                                        <tbody>
                                                            <tr>
                                                                <%
                                                                    String est7kak, estkta3, safy, tafkit;
                                                                    try {
                                                                        est7kak = "" + m.getVal30();
                                                                    } catch (Exception ex) {
                                                                        est7kak = "";
                                                                    }
                                                                    try {
                                                                        estkta3 = "" + m.getVal65();
                                                                    } catch (Exception ex) {
                                                                        estkta3 = "";
                                                                    }
                                                                    try {
                                                                        safy = "" + m.getVal70();
                                                                    } catch (Exception ex) {
                                                                        safy = "";
                                                                    }
                                                                    try {
                                                                        tafkit = "" + m.getTafkit();
                                                                    } catch (Exception ex) {
                                                                        tafkit = "";
                                                                    }
                                                                %>
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;"><%=est7kak%></td>
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;background-color: #327ab7;color: white;">جملة المستحق</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                <td style="text-align: center;font-size: 20px;width: 35%;">
                                                    <table id="" border="1" class="table">
                                                        <tbody>
                                                            <tr> 
                                                                <td id="TotalDedVal" style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;"><%=estkta3%></td>
                                                                <td  style="text-align: center;font-size: 20px;width:50%;border-style: solid;border-color: black;background-color: #327ab7;color: white;">جملة المستقطع</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                <td style="text-align: center;font-size: 20px;width: 35%;">
                                                    <table id="" border="0" class="table">
                                                        <tbody>
                                                            <tr> 
                                                                <td></td>    
                                                                <td></td>   
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <table id="" border="1" class="table">
                                        <tbody>                                    
                                            <tr> 
                                                <td  style="text-align: center;font-size: 20px;width:20%;border-style: solid;border-color: black;background-color: #327ab7;color: white;">الصافي المقتضي صرفه</td>
                                                <td  style="text-align: center;font-size: 20px;width:20%;border-style: solid;border-color: black;"><%=safy%></td>
                                                <td  style="text-align: center;font-size: 20px;width:60%;border-style: solid;border-color: black;"><%=tafkit%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /for Edit -->

                    <%                        }
                    %>


                </div>





                <!-- /page content -->


                <!-- footer content -->
                <footer>
                    <div class="pull-right">
                        Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">AMAC-AHRAM</a> All rights reserved.
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="webDesign/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="webDesign/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="webDesign/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="webDesign/vendors/nprogress/nprogress.js"></script>
        <!-- jQuery custom content scroller -->
        <script src="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>


        <!-- Datatables -->
        <script src="webDesign/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="webDesign/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="webDesign/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="webDesign/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="webDesign/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="webDesign/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="webDesign/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="webDesign/vendors/jszip/dist/jszip.min.js"></script>
        <script src="webDesign/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="webDesign/vendors/pdfmake/build/vfs_fonts.js"></script>
        <!-- bootstrap-wysiwyg -->
        <script src="webDesign/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
        <script src="webDesign/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
        <script src="webDesign/vendors/google-code-prettify/src/prettify.js"></script>

        <!-- bootstrap-daterangepicker -->
        <script src="webDesign/vendors/moment/min/moment.min.js"></script>
        <script src="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

        <!-- bootstrap-datetimepicker -->
        <script src="webDesign/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
        <script type="text/javascript">
                                    function Success(Body) {
                                        new PNotify({
                                            title: "تمت",
                                            text: Body,
                                            type: 'success',
                                            styling: 'bootstrap3'
                                        });
                                    }
                                    function Error(Body) {
                                        new PNotify({
                                            title: "خطأ",
                                            text: Body,
                                            type: 'error',
                                            styling: 'bootstrap3'
                                        });
                                    }
                                    function Warning(Body) {
                                        new PNotify({
                                            title: "تحذير",
                                            text: Body,
                                            styling: 'bootstrap3'
                                        });
                                    }
                                    function isIntegerNumber(elem) {
                                        if (new RegExp(/^\d*\$/).test(elem)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                    $('#myDatepicker4').datetimepicker({
                                        ignoreReadonly: true,
                                        allowInputToggle: true,
                                        format: 'DD/MM/YYYY'
                                    });
                                    $('#myDatepicker5').datetimepicker({
                                        ignoreReadonly: true,
                                        allowInputToggle: true,
                                        format: 'DD/MM/YYYY'
                                    });
        </script>
        <script>
            function printDiv() {

                var OlddivID = document.body.innerHTML;
                //Get the HTML of div

                var divID = document.getElementById("FullPrint").innerHTML;

                //Reset the page's HTML with div's HTML only
                document.body.innerHTML = "<html ><head><title></title></head><body>" + divID + "</body>";
                //Print Page
                window.print();
                //location.reload();
                //window.close();
                document.body.innerHTML = OlddivID;

            }
        </script>
    </body>
</html>
<%                      }
        } else {
            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
    }
    request.getSession().removeAttribute("ReqSp");
    request.getSession().removeAttribute("OpenHTMLFile");

    HibernateSessionCon.session.clear();
    HibernateSessionCon.closeConn();
%>