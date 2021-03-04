<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmpQualification_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFiscalDegreeCode"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
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
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>مستندات الموظف</title>
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
                                <span style="font-size: 20px;padding-left: 15px;font-weight: bold;">اسم المستخدم</span>
                                <h2 style="font-size: 15px;font-weight: bold;"><%=employee_name%></h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- side bar menu -->
                        <%
                            String M = new MainPageCode().testMethod(employee_session);
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
                                        String M2 = new MainPageCode().getUserMenu();
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
                                <h3 style="font-weight: bold;">بيان حالة الموظف</h3>
                            </div>

                            <div style="direction: ltr;">
                                <button class="btn btn-success form-group fa fa-print" href="#" data-toggle="modal" id="UpdateButton" data-target="" style="background-color: #CC6600; border-color: #CC6600; width: 40%;margin-top: 0px;font-size: 20px;box-shadow: -1px 2px 5px 1px black;" onclick="printDiv();" type="button"> طباعة</button>
                            </div>


                        </div>
                        <div class="clearfix"></div>

                        <%
                            List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID(employee_session.getEmployeeId());

                            if (pList.isEmpty()) {
                            } else {
                                PerEmploymentMasters m = pList.get(0);
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
                                                <td style="text-align: center;font-size: 30px;width:30%;font-weight: bolder;"> <br><h style="font-size: 20px;">إدارة شئون العاملين</h></td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align: right;font-size: 20px;font-weight:bold;width:8%;">التاريخ:</td>
                                        <td style="text-align: right;direction: ltr;font-size: 15px;width:15%;" id="dateD2"></td>

                                        <td style="text-align: right;font-size: 20px;font-weight:bold;width:8%;">الساعة:</td>
                                        <td style="text-align: right;direction: ltr;font-size: 15px;width:15%;" id="clock2"></td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr> 
                                                <td style="text-align: center;font-size: 30px;width:100%;font-weight: bolder;color: #327ab7;">بيــان حــالة الـموظـف</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table id="" border="0" class="table">
                                        <tbody>
                                            <tr> 
                                                <td style="text-align: center;font-size: 20px;width:100%;font-style: italic;">البيانات الاساسية الحالية</td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr> 
                                                <%
                                                    String WorkStartDate;
                                                    try {
                                                        if (m.getWorkStartDate() != null) {
                                                            WorkStartDate = "" + m.getWorkStartDate();
                                                        } else {
                                                            WorkStartDate = "لا يوجد تاريخ استلام العمل";
                                                        }
                                                    } catch (Exception ex) {
                                                        WorkStartDate = "لا يوجد تاريخ استلام العمل";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">اسم الموظف:</td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=employee_name%></td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:12%;"></td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:20%;"></td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">تاريخ استلام العمل:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=WorkStartDate%></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table id="" class="table">
                                        <tbody>
                                            <tr>
                                                <%
                                                    String NationalNo, GeneralName, EmployeeNo;
                                                    try {
                                                        if (m.getEmployeeNo() != null) {
                                                            EmployeeNo = "" + m.getEmployeeNo();
                                                        } else {
                                                            EmployeeNo = "لا يوجد رقم موظف";
                                                        }
                                                    } catch (Exception ex) {
                                                        EmployeeNo = "لا يوجد رقم موظف";
                                                    }

                                                    try {
                                                        if (m.getPerGeneralCodeByGeneralCode().getGeneralName() != null) {
                                                            GeneralName = "" + m.getPerGeneralCodeByGeneralCode().getGeneralName();
                                                        } else {
                                                            GeneralName = "لا يوجد مؤشر معاملة";
                                                        }

                                                    } catch (Exception ex) {
                                                        GeneralName = "لا يوجد مؤشر معاملة";
                                                    }
                                                    try {
                                                        if (m.getNationalNo() != null) {
                                                            NationalNo = "" + m.getNationalNo();
                                                        } else {
                                                            NationalNo = "لا يوجد رقم قومي";
                                                        }

                                                    } catch (Exception ex) {
                                                        NationalNo = "لا يوجد رقم قومي";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">رقم الموظف:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=EmployeeNo%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">مؤشر المعاملة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=GeneralName%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الرقم القومي:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=NationalNo%></td>
                                            </tr>
                                            <tr>
                                                <%
                                                    String MaritalName, ReligonName, NationalName;
                                                    try {
                                                        if (m.getPerNationalCode().getNationalName() != null) {
                                                            NationalName = "" + m.getPerNationalCode().getNationalName();
                                                        } else {
                                                            NationalName = "لا يوجد جنسية";
                                                        }
                                                    } catch (Exception ex) {
                                                        NationalName = "لا يوجد جنسية";
                                                    }

                                                    try {
                                                        if (m.getPerReligonCode().getReligonName() != null) {
                                                            ReligonName = "" + m.getPerReligonCode().getReligonName();
                                                        } else {
                                                            ReligonName = "لا يوجد ديانة";
                                                        }

                                                    } catch (Exception ex) {
                                                        ReligonName = "لا يوجد ديانة";
                                                    }

                                                    try {
                                                        if (m.getPerMaritalCode().getMaritalName() != null) {
                                                            MaritalName = "" + m.getPerMaritalCode().getMaritalName();
                                                        } else {
                                                            MaritalName = "لا يوجد حالة إجتماعية";
                                                        }
                                                    } catch (Exception ex) {
                                                        MaritalName = "لا يوجد حالة إجتماعية";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الجنسية:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=NationalName%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الديانة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=ReligonName%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الحالة الاجتماعية:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=MaritalName%></td>
                                            </tr>
                                            <tr>
                                                <%
                                                    String AGovName1, BirthDate;
                                                    try {
                                                        if (m.getBirthDate() != null) {
                                                            BirthDate = "" + m.getBirthDate();
                                                        } else {
                                                            BirthDate = "لا يوجد تاريخ ميلاد";
                                                        }
                                                    } catch (Exception ex) {
                                                        BirthDate = "لا يوجد تاريخ ميلاد";
                                                    }

                                                    try {
                                                        if (m.getPerCityCode().getPerGovernorateCode().getAGovName() != null) {
                                                            AGovName1 = "" + m.getPerCityCode().getPerGovernorateCode().getAGovName();
                                                        } else {
                                                            AGovName1 = "لا يوجد محل ميلاد";
                                                        }
                                                    } catch (Exception ex) {
                                                        AGovName1 = "لا يوجد محل ميلاد";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">تاريخ الميلاد:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=BirthDate%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">محل الميلاد:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=AGovName1%></td>
                                                <%
                                                    String ACityName, AGovName;
                                                    try {
                                                        if (m.getPerCityCode().getACityName() != null) {
                                                            ACityName = "" + m.getPerCityCode().getACityName();
                                                        } else {
                                                            ACityName = "لا يوجد عنوان";
                                                        }

                                                    } catch (Exception ex) {
                                                        ACityName = "لا يوجد عنوان";
                                                    }
                                                    try {
                                                        if (m.getPerCityCode().getPerGovernorateCode().getAGovName() != null) {
                                                            AGovName = "" + m.getPerCityCode().getPerGovernorateCode().getAGovName();
                                                        } else {
                                                            AGovName = "لا يوجد عنوان";
                                                        }

                                                    } catch (Exception ex) {
                                                        AGovName = "لا يوجد عنوان";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">القسم/المركز/المدينة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=ACityName%>-<%=AGovName%></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr> 
                                                <%
                                                    String LocAddress;
                                                    try {
                                                        if (m.getPerLocationCodes().getLocAddress() != null) {
                                                            LocAddress = "" + m.getPerLocationCodes().getLocAddress();
                                                        } else {
                                                            LocAddress = "لا يوجد عنوان";
                                                        }
                                                    } catch (Exception ex) {
                                                        LocAddress = "لا يوجد عنوان";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">العنوان:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:90%;"><%=LocAddress%></td>

                                            </tr>
                                        </tbody>
                                    </table>

                                    <table id="" class="table">
                                        <tbody>
                                            <tr>
                                                <%
                                                    String EmploymentSourceDesc;
                                                    try {
                                                        if (m.getPerEmploymentParameter().getEmploymentSourceDesc() != null) {
                                                            EmploymentSourceDesc = "" + m.getPerEmploymentParameter().getEmploymentSourceDesc();
                                                        } else {
                                                            EmploymentSourceDesc = "لا يوجد نوع التعيين";
                                                        }

                                                    } catch (Exception ex) {
                                                        EmploymentSourceDesc = "لا يوجد نوع التعيين";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">نوع التعيين:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=EmploymentSourceDesc%></td>
                                                <%
                                                    String ContractDate;
                                                    try {
                                                        if (m.getContractDate() != null) {
                                                            ContractDate = "" + m.getContractDate();
                                                        } else {
                                                            ContractDate = "لا يوجد تاريخ التعيين";
                                                        }
                                                    } catch (Exception ex) {
                                                        ContractDate = "لا يوجد تاريخ التعيين";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">تاريخ التعيين:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=ContractDate%></td>
                                                <%
                                                    String StartContractDate;
                                                    try {
                                                        if (m.getStartContractDate() != null) {
                                                            StartContractDate = "" + m.getStartContractDate();
                                                        } else {
                                                            StartContractDate = "لا يوجد تاريخ بداية التعيين بالحكومة";
                                                        }
                                                    } catch (Exception ex) {
                                                        StartContractDate = "لا يوجد تاريخ بداية التعيين بالحكومة";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">ت. بداية التعيين بالحكومة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=StartContractDate%></td>

                                            </tr>
                                            <tr>
                                                <%
                                                    String JobDate;
                                                    try {
                                                        if (m.getJobDate() != null) {
                                                            JobDate = "" + m.getJobDate();
                                                        } else {
                                                            JobDate = "لا يوجد تاريخ شغل بالوظيفة";
                                                        }
                                                    } catch (Exception ex) {

                                                        JobDate = "لا يوجد تاريخ شغل بالوظيفة";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">ت. شغل الوظيفة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=JobDate%></td>
                                                <%
                                                    String StartContractDate1;
                                                    try {
                                                        if (m.getStartContractDate() != null) {
                                                            StartContractDate1 = "" + m.getStartContractDate();
                                                        } else {
                                                            StartContractDate1 = "لا يوجد تاريخ تعيين بالحكومة";
                                                        }
                                                    } catch (Exception ex) {
                                                        StartContractDate1 = "لا يوجد تاريخ تعيين بالحكومة";
                                                    }

                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">ت. التعيين بالحكومة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=StartContractDate1%></td>

                                                <%
                                                    int sexFlag = m.getSexFlag();
                                                    if (sexFlag == 1) {
                                                        String MilitaryName;
                                                        try {
                                                            if (m.getPerMilitaryCode().getMilitaryName() != null) {
                                                                MilitaryName = m.getPerMilitaryCode().getMilitaryName();
                                                            } else {
                                                                MilitaryName = "لا يوجد موقف من التجنيد";
                                                            }
                                                        } catch (Exception ex) {
                                                            MilitaryName = "لا يوجد موقف من التجنيد";
                                                        }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">موقف التجنيد:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=MilitaryName%></td>
                                                <%
                                                } else if (sexFlag == 2) {
                                                    String MilitaryName;
                                                    try {
                                                        if (m.getPerMilitaryCode().getMilitaryName() != null) {
                                                            MilitaryName = m.getPerMilitaryCode().getMilitaryName();
                                                        } else {
                                                            MilitaryName = "لا يوجد خدمة عامة";
                                                        }
                                                    } catch (Exception ex) {
                                                        MilitaryName = "لا يوجد خدمة عامة";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الخدمة العامة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=MilitaryName%></td>
                                                <%
                                                    }
                                                %>
                                            </tr>
                                            <tr>
                                                <%
                                                    String lawSeq = "-";
                                                    try {
                                                        if (m.getPerJobLaw().getLawSeq() == null) {
                                                            lawSeq = "";
                                                        } else {
                                                            lawSeq = m.getPerJobLaw().getLawSeq();
                                                        }
                                                    } catch (Exception ez) {
                                                        lawSeq = "";
                                                    }
                                                    try {
                                                        if (m.getPerJobLaw().getLawSeq() == null) {
                                                            lawSeq = "";
                                                        } else {
                                                            lawSeq = m.getPerJobLaw().getLawSeq();
                                                            List<PerJobLaw> JList = JList = new PerJobLaw_DAO().getPerJobLawById(lawSeq);
                                                            if (JList.isEmpty() || JList == null) {
                                                            } else {
                                                                PerJobLaw L = JList.get(0);
                                                                if (L.getLawType() == 1) {
                                                                    String FiscalDegreeName;
                                                                    try {
                                                                        PerFiscalDegreeCode pfdc = m.getPerFiscalDegreeCode();
                                                                        if (m.getPerFiscalDegreeCode().getFiscalDegreeName() != null) {
                                                                            FiscalDegreeName = m.getPerFiscalDegreeCode().getFiscalDegreeName();
                                                                        } else {
                                                                            FiscalDegreeName = "لا يوجد درجة مالية";
                                                                        }

                                                                    } catch (Exception ex) {
                                                                        FiscalDegreeName = "لا يوجد درجة مالية";
                                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الدرجة المالية:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=FiscalDegreeName%></td>
                                                <%
                                                } else if (L.getLawType() == 2) {
                                                    String FiscalDegreeNameNew;
                                                    try {
                                                        PerFiscalDegreeCode pfdc = m.getPerFiscalDegreeCode();
                                                        if (m.getPerFiscalDegreeCode().getFiscalDegreeName() != null) {
                                                            FiscalDegreeNameNew = m.getPerFiscalDegreeCodeNew().getFiscalDegreeNameNew();
                                                        } else {
                                                            FiscalDegreeNameNew = "لا يوجد درجة مالية";
                                                        }

                                                    } catch (Exception ex) {
                                                        FiscalDegreeNameNew = "لا يوجد درجة مالية";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الدرجة المالية:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=FiscalDegreeNameNew%></td>
                                                <%//}
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception ez) {
                                                        lawSeq = "";
                                                    }

                                                    String DegreeDate, DegreePriorityDate;
                                                    try {
                                                        if (m.getDegreeDate() == null) {
                                                            DegreeDate = "";
                                                        } else {
                                                            DegreeDate = "" + m.getDegreeDate();
                                                        }
                                                    } catch (Exception ex) {
                                                        DegreeDate = "";
                                                    }

                                                    try {
                                                        if (m.getDegreePriorityDate() == null) {
                                                            DegreePriorityDate = "";
                                                        } else {
                                                            DegreePriorityDate = "" + m.getDegreePriorityDate();
                                                        }
                                                    } catch (Exception ex) {
                                                        DegreePriorityDate = "";
                                                    }


                                                %>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">تاريخ شغل الدرجة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=DegreeDate%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">تاريخ الاقدمية بالدرجة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=DegreePriorityDate%></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <table  id="" class="table">
                                        <tbody>
                                            <tr> 
                                                <%
                                                    String JobName, GroupTypeName;
                                                    try {
                                                        if (m.getPerJobCodeByJobCode().getJobName() != null) {
                                                            JobName = m.getPerJobCodeByJobCode().getJobName();
                                                        } else {
                                                            JobName = "لا توجد وظيفة";
                                                        }

                                                    } catch (Exception ex) {
                                                        JobName = "لا توجد وظيفة";
                                                    }
                                                    try {
                                                        if (m.getPerGroupTypeCode().getGroupTypeName() != null) {
                                                            GroupTypeName = m.getPerGroupTypeCode().getGroupTypeName();
                                                        } else {
                                                            GroupTypeName = "لا توجد وظيفة";
                                                        }

                                                    } catch (Exception ex) {
                                                        GroupTypeName = "لا توجد وظيفة";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الوظيفة:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=JobName%></td>

                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">المجموعة النوعية:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=GroupTypeName%></td>

                                                <%
                                                    int orgFlage = m.getOrgFlag();
                                                    if (orgFlage == 1) {
                                                        String OrgunitName, OrgName, LocName;
                                                        try {
                                                            if (m.getPerOrgunitCodeByOrgunitCode().getOrgunitName() != null) {
                                                                OrgunitName = m.getPerOrgunitCodeByOrgunitCode().getOrgunitName();
                                                            } else {
                                                                OrgunitName = "لا يوجد مستوى";
                                                            }

                                                        } catch (Exception ex) {
                                                            OrgunitName = "لا يوجد مستوى";
                                                        }
                                                        try {
                                                            if (m.getPerOrganizationStructureByOrgId().getOrgName() != null) {
                                                                OrgName = m.getPerOrganizationStructureByOrgId().getOrgName();
                                                            } else {
                                                                OrgName = "لا يوجد مستوى";
                                                            }

                                                        } catch (Exception ex) {
                                                            OrgName = "لا يوجد مستوى";
                                                        }
                                                        try {
                                                            if (m.getPerLocationCodes().getLocName() != null) {
                                                                LocName = m.getPerLocationCodes().getLocName();
                                                            } else {
                                                                LocName = "لا يوجد مستوى";
                                                            }

                                                        } catch (Exception ex) {
                                                            LocName = "لا يوجد مستوى";
                                                        }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">الإدارة :</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=OrgunitName%>-<%=OrgName%>-<%=LocName%></td>
                                                <%
                                                } else if (orgFlage == 3) {
                                                    String ACountryName, ExternalSideName, LocName;
                                                    try {
                                                        if (m.getPerCityCode().getPerGovernorateCode().getPerCountryCode().getACountryName() != null) {
                                                            ACountryName = m.getPerCityCode().getPerGovernorateCode().getPerCountryCode().getACountryName();

                                                        } else {
                                                            ACountryName = "لا يوجد مستوى";
                                                        }
                                                    } catch (Exception ex) {
                                                        ACountryName = "لا يوجد مستوى";
                                                    }
                                                    try {
                                                        if (m.getPerExternalSideCodeByPeremPerescFk().getExternalSideName() != null) {
                                                            ExternalSideName = m.getPerExternalSideCodeByPeremPerescFk().getExternalSideName();
                                                        } else {
                                                            ExternalSideName = "لا يوجد مستوى";
                                                        }

                                                    } catch (Exception ex) {
                                                        ExternalSideName = "لا يوجد مستوى";
                                                    }
                                                    try {
                                                        if (m.getPerLocationCodes().getLocName() != null) {
                                                            LocName = m.getPerLocationCodes().getLocName();
                                                        } else {
                                                            LocName = "لا يوجد مستوى";
                                                        }

                                                    } catch (Exception ex) {
                                                        LocName = "لا يوجد مستوى";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">المستوى:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=ACountryName%>-<%=ExternalSideName%>-<%=LocName%></td>
                                                <%
                                                } else if (orgFlage == 2) {
                                                    String LastUpdateTransaction, LocName;
                                                    try {
                                                        if (m.getBudProjectSubByPeremBudProjSFk().getLastUpdateTransaction() != null) {
                                                            LastUpdateTransaction = m.getBudProjectSubByPeremBudProjSFk().getLastUpdateTransaction();
                                                        } else {
                                                            LastUpdateTransaction = "لا يوجد مستوى";
                                                        }

                                                    } catch (Exception ex) {
                                                        LastUpdateTransaction = "لا يوجد مستوى";
                                                    }
                                                    try {
                                                        if (m.getPerLocationCodes().getLocName() != null) {
                                                            LocName = m.getPerLocationCodes().getLocName();
                                                        } else {
                                                            LocName = "لا يوجد مستوى";
                                                        }

                                                    } catch (Exception ex) {
                                                        LocName = "لا يوجد مستوى";
                                                    }
                                                %>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:10%;color: #327ab7;">المستوى:</td>
                                                <td style="text-align: right;font-size: 15px;font-weight:bold;width:22%;"><%=LastUpdateTransaction%>-<%=LocName%></td>
                                                <%//}
                                                    }
                                                %>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>


                                <table id="" border="0" class="table">
                                    <tbody>                                    
                                        <tr> 
                                            <td style="text-align: center;font-size: 20px;width:100%;font-style: italic;">=================</td>
                                        </tr>
                                        <tr> 
                                            <td style="text-align: center;font-size: 20px;width:100%;font-style: italic;">بيانات المؤهل</td>
                                        </tr>
                                    </tbody>
                                </table>

                                <div class="row table-responsive">
                                    <table id="" class="table table-striped table-bordered table-hover">
                                        <thead style="background-color: #327ab7;color: white;">
                                            <tr>
                                                <th style="text-align: center;font-size: 15px;width: 15%">سنة المؤهل</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">الجامعة</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">الكلية</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">التقدير</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">التخصص</th>
                                                <th style="text-align: center;font-size: 15px;width: 25%">المؤهل</th>
                                            </tr>
                                        </thead>

                                        <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->
                                        <%
                                            List<PerEmpQualification> perEmpQualificationsList = new PerEmpQualification_DAO().get_Employees_PerEmpQualification(m.getEmployeeId());
                                            if (perEmpQualificationsList.isEmpty()) {
                                        %>
                                        <tbody>
                                            <tr>
                                                <td colspan="6"  style="text-align: center;">لا توجد مؤهلات</td>                                                
                                            </tr>
                                        </tbody>
                                        <%
                                        } else {
                                        %>
                                        <tbody>
                                            <%
                                                for (PerEmpQualification e : perEmpQualificationsList) {
                                                    String UniversityName, qualYear, FacultyName, SpecialistName, QualName, GradeStr = "";
                                                    qualYear = "" + e.getQualYear();
                                                    /*UniversityName = e.getPerUniversityCode().getUniversityName();
                                                    FacultyName = e.getPerFacultyCode().getFacultyName();
                                                    SpecialistName = e.getPerSpecialistCode().getSpecialistName();
                                                    QualName = e.getPerQualCode().getQualName();
                                                    double Grade = Double.parseDouble(e.getEmpPercent().toString());
                                                    List<PerGradePercentage> PerGradePercentageList = new PerGradePercentage_DAO().getAllPerGradePercentage();
                                                    for (PerGradePercentage x : PerGradePercentageList) {
                                                        double From = Double.parseDouble(x.getPercentageFrom().toString());
                                                        double To = Double.parseDouble(x.getPercentageTo().toString());

                                                        if (Grade >= From && Grade <= To) {
                                                            GradeStr = x.getGradeName();
                                                        }
                                                    }*/

                                                    try {
                                                        if (e.getQualYear() != null) {
                                                            qualYear = "" + e.getQualYear();
                                                        } else {
                                                            qualYear = "لا يوجد تاريخ للشهادة";
                                                        }

                                                    } catch (Exception ex) {
                                                        qualYear = "لا يوجد تاريخ للشهادة";
                                                    }
                                                    try {
                                                        if (e.getPerUniversityCode().getUniversityName() != null) {
                                                            UniversityName = e.getPerUniversityCode().getUniversityName();
                                                        } else {
                                                            UniversityName = "لا يوجد بيان مسجل";
                                                        }

                                                    } catch (Exception ex) {
                                                        UniversityName = "لا يوجد بيان مسجل";
                                                    }
                                                    try {
                                                        if (e.getPerFacultyCode().getFacultyName() != null) {
                                                            FacultyName = e.getPerFacultyCode().getFacultyName();
                                                        } else {
                                                            FacultyName = "لا يوجد بيان مسجل";
                                                        }

                                                    } catch (Exception ex) {
                                                        FacultyName = "لا يوجد بيان مسجل";
                                                    }
                                                    try {
                                                        if (e.getPerSpecialistCode().getSpecialistName() != null) {
                                                            SpecialistName = e.getPerSpecialistCode().getSpecialistName();
                                                        } else {
                                                            SpecialistName = "لا توجد درجة مالية";
                                                        }

                                                    } catch (Exception ex) {
                                                        SpecialistName = "لا توجد درجة مالية";
                                                    }
                                                    try {
                                                        if (e.getPerQualCode().getQualName() != null) {
                                                            QualName = e.getPerQualCode().getQualName();
                                                        } else {
                                                            QualName = "لا توجد درجة مالية";
                                                        }

                                                    } catch (Exception ex) {
                                                        QualName = "لا توجد درجة مالية";
                                                    }
                                                    double Grade;
                                                    try {
                                                        Grade = Double.parseDouble(e.getEmpPercent().toString());
                                                        List<PerGradePercentage> PerGradePercentageList = new PerGradePercentage_DAO().getAllPerGradePercentage();
                                                        for (PerGradePercentage x : PerGradePercentageList) {
                                                            double From = Double.parseDouble(x.getPercentageFrom().toString());
                                                            double To = Double.parseDouble(x.getPercentageTo().toString());

                                                            if (Grade >= From && Grade <= To) {
                                                                GradeStr = x.getGradeName();
                                                            }
                                                        }
                                                    } catch (Exception ex) {
                                                        GradeStr = "لا توجد تقدير";
                                                    }
                                            %>
                                            <tr>
                                                <td style="font-weight: bold;"><%=qualYear%></td>
                                                <td style="font-weight: bold;"><%=UniversityName%></td>
                                                <td style="font-weight: bold;"><%=FacultyName%></td>
                                                <td style="font-weight: bold;"><%=GradeStr%></td>
                                                <td style="font-weight: bold;"><%=SpecialistName%></td>
                                                <td style="font-weight: bold;"><%=QualName%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                        <%
                                            }
                                        %>

                                    </table>
                                </div>


                                <table id="" border="0" class="table">
                                    <tbody>
                                        <tr> 
                                            <td style="text-align: center;font-size: 20px;width:100%;font-style: italic;">=================</td>
                                        </tr>
                                        <tr> 
                                        <tr> 
                                            <td style="text-align: center;font-size: 20px;width:100%;font-style: italic;">التدرج الوظيفي</td>
                                        </tr>
                                    </tbody>
                                </table>

                                <div class="row table-responsive">
                                    <table id="" class="table table-striped table-bordered table-hover">
                                        <thead style="background-color: #327ab7;color: white;">
                                            <tr>
                                                <th style="text-align: center;font-size: 15px;width: 14%">تاريخ الحركة</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">الوظيفة</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">الدرجة المالية</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">المجموعة النوعية</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">مؤشر المعاملة</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">رقم القرار</th>
                                                <th style="text-align: center;font-size: 15px;width: 14%">تاريخ القرار</th>
                                            </tr>
                                        </thead>

                                        <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->
                                        <%
                                            List<PerEmpHistory> PerEmpHistoryList = new PerEmpHistory_DAO().get_Employees_EmpHistory("" + employee_session.getEmployeeId());
                                            if (PerEmpHistoryList.isEmpty()) {
                                        %>
                                        <tbody>
                                            <tr>
                                                <td colspan="7"  style="text-align: center;">لا يوجد تدرج وظيفي</td>                                                
                                            </tr>
                                        </tbody>
                                        <%
                                        } else {
                                        %>
                                        <tbody>
                                            <%
                                                for (PerEmpHistory e : PerEmpHistoryList) {
                                            %>
                                            <tr>
                                                <%
                                                    String GroupTypeCode, TransDate, JobName1, FiscalDegreeName, GroupTypeName1, GeneralName1, DecisionNo, DecisionDate;
                                                    try {
                                                        if (e.getPerGroupTypeCode().getGroupTypeCode() == null) {
                                                            GroupTypeCode = "";
                                                        } else {
                                                            GroupTypeCode = e.getPerGroupTypeCode().getGroupTypeCode() + "";
                                                        }
                                                    } catch (Exception ex) {
                                                        GroupTypeCode = "";
                                                    }
                                                    try {
                                                        if (e.getTransDate() == null) {
                                                            TransDate = "لا يوحد تاريخ للحركة";
                                                        } else {
                                                            TransDate = e.getTransDate() + "";
                                                        }
                                                    } catch (Exception ex) {
                                                        TransDate = "لا يوحد تاريخ للحركة";
                                                    }

                                                    try {
                                                        if (GroupTypeCode.equals("32")) {

                                                            JobName1 = e.getPerJobCodeByJobCodeTransfer().getJobName();
                                                        } else {
                                                            JobName1 = e.getPerJobCodeByJobCode().getJobName();
                                                        }
                                                    } catch (Exception ex) {
                                                        JobName1 = "لا توجد وظيفة";
                                                    }
                                                    try {
                                                        if (e.getPerFiscalDegreeCode().getFiscalDegreeName() != null) {
                                                            FiscalDegreeName = e.getPerFiscalDegreeCode().getFiscalDegreeName();
                                                        } else {
                                                            FiscalDegreeName = "لا توجد درجة مالية";
                                                        }

                                                    } catch (Exception ex) {
                                                        FiscalDegreeName = "لا توجد درجة مالية";
                                                    }
                                                    try {
                                                        if (e.getPerGroupTypeCode().getGroupTypeName() != null) {
                                                            GroupTypeName1 = e.getPerGroupTypeCode().getGroupTypeName();
                                                        } else {
                                                            GroupTypeName1 = "لا توجد مجموعة نوعية";
                                                        }

                                                    } catch (Exception ex) {
                                                        GroupTypeName1 = "لا توجد مجموعة نوعية";
                                                    }
                                                    try {
                                                        if (e.getPerGeneralCode().getGeneralName() != null) {
                                                            GeneralName1 = e.getPerGeneralCode().getGeneralName();
                                                        } else {
                                                            GeneralName1 = "لا يوجد مؤشر معاملة";
                                                        }

                                                    } catch (Exception ex) {
                                                        GeneralName1 = "لا يوجد مؤشر معاملة";
                                                    }

                                                    try {
                                                        if (e.getDecisionNo() == null) {

                                                            DecisionNo = "لا يوجد رقم قرار";
                                                        } else {
                                                            DecisionNo = e.getDecisionNo();
                                                        }
                                                    } catch (Exception ex) {
                                                        DecisionNo = "لا يوجد رقم قرار";
                                                    }

                                                    try {
                                                        if (e.getDecisionDate() == null) {
                                                            DecisionDate = "لا يوحد تاريخ للقرار";
                                                        } else {
                                                            DecisionDate = e.getDecisionDate() + "";
                                                        }
                                                    } catch (Exception ex) {
                                                        DecisionDate = "لا يوحد تاريخ للقرار";
                                                    }

                                                %>
                                                <td style="font-weight: bold;"><%=TransDate%></td>                                                
                                                <td style="font-weight: bold;"><%=JobName1%></td>
                                                <td style="font-weight: bold;"><%=FiscalDegreeName%></td>
                                                <td style="font-weight: bold;"><%=GroupTypeName1%></td>
                                                <td style="font-weight: bold;"><%=GeneralName1%></td>
                                                <td style="font-weight: bold;"><%=DecisionNo%></td>
                                                <td style="font-weight: bold;"><%=DecisionDate%></td>

                                            </tr>
                                        </tbody>
                                        <%
                                                }
                                            }
                                        %>
                                    </table>
                                </div>

                                <table id="sig" border="0" class="table">

                                </table>




                            </div>
                        </div>
                    </div>
                    <!-- /for Edit -->

                    <%
                        }
                    %>


                </div>
            </div>






            <!-- /page content -->









        </div>

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

        document.getElementById("sig").innerHTML = "<tbody>\n" +
                "                                        <tr> \n" +
                "                                            <td colspan=\"5\" style=\"text-align: center;font-size: 20px;width:100%;font-style: italic;\">=================</td>\n" +
                "                                        </tr>\n" +
                "                                        <tr> \n" +
                "                                        <tr> \n" +
                "                                            <td colspan=\"5\" style=\"text-align: center;font-size: 20px;width:100%;font-style: italic;\">الأختام</td>\n" +
                "                                        </tr>\n" +
                "                                        <tr> \n" +
                "                                            <td style=\"text-align: center;\"><img src=\"webDesign/build/images/sig2.png\" width=\"\" style=\"width: 100%;\"/></td>\n" +
                "                                            <td style=\"text-align: center;\"><img src=\"webDesign/build/images/sig2.png\" width=\"\" style=\"width: 100%;\"/></td>\n" +
                "                                            <td style=\"text-align: center;\"><img src=\"webDesign/build/images/sig2.png\" width=\"\" style=\"width: 100%;\"/></td>\n" +
                "                                            <td style=\"text-align: center;\"><img src=\"webDesign/build/images/sig2.png\" width=\"\" style=\"width: 100%;\"/></td>\n" +
                "                                            <td style=\"text-align: center;width: 20%;\"><img src=\"webDesign/build/images/ketm.png\" width=\"\" style=\"width: 50%;\"/></td>\n" +
                "                                        </tr>\n" +
                "                                    </tbody>";
//Get the HTML of div

        setTimeout(pri, 500);

    }
    function pri() {
        var divID = document.getElementById("FullPrint").innerHTML;

//Reset the page's HTML with div's HTML only
        document.body.innerHTML = "<html ><head><title></title></head><body>" + divID + "</body>";
//Print Page
        window.print();
        location.reload();
    }
</script>
</body>
</html>
<%                        } else {
            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
    }

    HibernateSessionCon.session.clear();
    HibernateSessionCon.closeConn();
%>