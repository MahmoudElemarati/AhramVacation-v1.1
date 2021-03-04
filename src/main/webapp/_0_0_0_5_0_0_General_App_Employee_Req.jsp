<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppReqTypeJ111_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppReqTypeJ111"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppName_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppName"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
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

            //String employee_name = employee_session.getEmpAname()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getOrgName()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getEmpBigBoss();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>طلبات عامة</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/calendar.png">


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
            /*   لعمل ليست ايتم بدون كومبو استايل */ 
            .selectList[multiple],
            .selectList[size] {
                height: 122px;
            }
            /*  لعمل فيلد بحث في الكومبو  */ 
            .SELECT_Combo {
                font-weight: bold;
                font-size: 15px; 
            }
            /* خاص بتغير الفونت لاي فيلد بضاف اليه هذا الكلاس  */ 
            .font-style{
                font-weight: bold;
                font-size: 15px;
            }

            .table-font-style{
                font-weight: bold;
                font-size: 15px;
                text-align: center;
            }
            /* خاص بعمل اسبان بجانب الفيلد وعمل دوران للزوايا */
            .searchCustom{
                background-color: #26b99a;
                /*border: black solid 2px;*/
                color: white;
            }
            /* خاص بالكومبو السيرش بيقلب اليستة ناحية اليمين */
            .select2-dropdown--below{
                color:#73879C;
                font-size:15px;
                font-weight: bold;
                line-height:1.471;
                text-align: right;
                color: black;
            }
            .select2-selection__rendered {
                text-align: right;
                color: black;
                font-size:15px;
                font-weight: bold;
                direction: rtl;
            }

            .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th{
                padding: 0px;
                line-height: 1.42857143;
                vertical-align: top;
                border-top: 1px solid #ddd;
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
                                <h3 style="font-weight: bold;"> طلبات عامة</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start --> 

                        <!-- for Edit -->                            

                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                    <label class="control-label font-style"> اسم البرنامج</label>
                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="اسم البرنامج" onchange="getAppReqType();" id="applicationId" maxlength="45" name="applicationId" class="form-control" required="">
                                        <option value="" style="font-size: 15px;font-weight: bold;">اختر اسم البرنامج ..</option>
                                        <%
                                            List<AppName> AppList = new AppName_DAO().getAll_ApplicationName();
                                            for (AppName App : AppList) {
                                        %>
                                        <option class="font-style" value="<%=App.getApplicationId()%>"><%=App.getApplicationName()%></option>
                                        <%
                                            }
                                        %>

                                    </select>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                    <label class="control-label font-style"> نوع الطلب</label>
                                    <select type="text" placeholder="نوع الطلب" onchange="" id="appReqType" maxlength="45" name="appReqType" class="form-control font-style" required="">
                                    </select>
                                </div>                                

                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                    <label class="control-label font-style"> ملاحظات عامة على الطلب</label>
                                    <input type="text" placeholder="ملاحظات" maxlength="100" data-placement="bottom" id="mainRmrk" name="mainRmrk" class="form-control font-style" required="">
                                </div> 
                            </div> 
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="direction: ltr;">
                                <div class="row">
                                    <div class="checkbox pull-right">
                                        <label class="" style="font-size: 15px;font-weight: bold;">طلب للغير .......</label>
                                        <input type="checkbox" id="checkSearch" value="" onclick="requestForOthers();"  style="transform: scale(2)" class="font-style" name="a">
                                    </div>
                                </div>                                
                                <div class="row" id="checkElemant" style="display: none;direction: rtl;">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                            <label class="control-label font-style">اسم الموظف</label>
                                            <div class="input-group" style="border: grey solid 2px;">
                                                <input name="EmployeeName" id="EmployeeName" onkeyup="getEmployeeData();" class="form-control font-style" autocomplete="off" tabindex="-1" required="">
                                                <span class="input-group-addon searchCustom" onclick="addEmployeeToTable();"><a href="#"<i style="font-size: 20px;color: white;" class="fa fa-arrow-circle-left"></i></a></span> 
                                            </div>
                                            <select name="EmployeeId" id="EmployeeId" onchange="copyName();" class="selectList form-control font-style" multiple="multiple" tabindex="-1" required="">
                                            </select>
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="display: none;">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                                <label class="control-label font-style"> الإدارة</label>                                                
                                                <input type="text" readonly="" placeholder="الإدارة" maxlength="100" data-placement="bottom" id="org" name="org" class="form-control font-style" required="">
                                            </div>

                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <label class="control-label font-style"> ملاحظات خاصة بالموظف</label>
                                                <input type="text" placeholder="ملاحظات" maxlength="100" data-placement="bottom" id="empRmrk" name="empRmrk" class="form-control font-style" required="">
                                            </div>                                            
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" style="text-align: center;"><br>                                            
                                                <button type="button" data-placement="top" onclick="addEmployeeToTable();" class="btn btn-sm btn-success fa fa" style="font-weight: bold;font-size: 20px;width:90%;" data-toggle="modal" data-target="#x">إضافة الموظف للطلب <i class="fa fa-arrow-circle-left"></i></button>
                                            </div>
                                        </div>
                                        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                            <style>
                                                #dashTableSearch {
                                                    background-image: url('webDesign/production/images/search-512.png');
                                                    background-position: 6px 6px;
                                                    background-repeat: no-repeat;
                                                    background-size: 10%;
                                                    background-attachment: fixed;
                                                }                                    
                                            </style>                                
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="dashTableSearchDiv" style="display: none;">
                                                    <input type="text" name="dashTableSearch" id="dashTableSearch" style="width: 100%;" onkeyup="dashTableSearch();" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 scroll table-responsive" style="width: 100%;">
                                                <br>
                                                <table id="dashTable" class="table table-striped table-bordered table-hover table-font-style">
                                                    <thead style="background-color: #26b99a;color: white;">
                                                        <tr>
                                                            <th style="text-align: center;font-size: 15px;width: 15%">رقم التأمين</th>
                                                            <th style="text-align: center;font-size: 15px;width: 35%">إسم الموظف</th>
                                                            <th style="text-align: center;font-size: 15px;width: 45%">الإدارة</th>
                                                            <th style="text-align: center;font-size: 15px;width: 5%"></th>
                                                        </tr>
                                                    </thead>

                                                    <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                                    <tbody id="empData">
                                                        <tr>
                                                            <td colspan="4" style="text-align: center;">لم يوجد موظفين مسجلين</td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center;"><br>                                            
                                <button type="button" data-placement="top" onclick="sendRequest('<%=employee_session.getEmployeeNo()%>');" class="button_style btn btn-sm btn-primary fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;width:90%;" data-toggle="modal" data-target="#x"> تسجيل الطلب</button>
                            </div> 
                        </div>  






                    </div>


                    <!-- /for Edit -->


                    <!-- for Edit -->

                    <!-- /for Edit -->
                    <!--card Start -->


                    <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                            <table id="" class="table table-striped table-bordered table-hover">
                                <thead style="background-color: #337ab7;color: white;">
                                    <tr>
                                        <th style="text-align: center;font-size: 15px;width: 15%">اسم البرنامج</th>
                                        <th style="text-align: center;font-size: 15px;width: 15%">نوع الطلب</th>
                                        <th style="text-align: center;font-size: 15px;width: 15%">تاريخ الطلب</th>
                                        <th style="text-align: center;font-size: 15px;width: 20%">ملاحظات</th>
                                        <th style="text-align: center;font-size: 15px;width: 15%">حالة الطلب</th>
                                        <th style="text-align: center;font-size: 15px;width: 15%">تاريخ آخر حالة للطلب</th>
                                        <th style="text-align: center;font-size: 15px;width: 5%"></th>
                                    </tr>
                                </thead>

                                <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                <tbody id="all_requests">
                                    <tr>
                                        <td colspan="8" style="text-align: center;"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>






                <!-- /page content -->









            </div>
        </div>

        <div class="modal fade ElDetail" tabindex="-1" role="dialog" aria-hidden="true" >
            <div class="modal-dialog modal-lg" style="border-style: solid;border-color: yellow;">
                <div class="modal-content">

                    <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تفاصيل الطلب</h4>
                    </div>
                    <div class="modal-body" style="direction: rtl;">
                        <div class="row table-responsive">
                            <table id="" class="table table-striped table-bordered table-hover">
                                <thead style="background-color: #337ab7;color: white;">
                                    <tr>
                                        <th style="text-align: center;font-size: 15px;width: 10%">تأمين الموظف</th>
                                        <th style="text-align: center;font-size: 15px;width: 20%">إسم الموظف</th>
                                        <th style="text-align: center;font-size: 15px;width: 25%">تاريخ الإرسال</th>
                                        <th style="text-align: center;font-size: 15px;width: 25%">ملاحظات</th>
                                        <th style="text-align: center;font-size: 15px;width: 15%">حالة الطلب</th>
                                    </tr>
                                </thead>

                                <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                <tbody id="request_detail">
                                    <tr>
                                        <td colspan="5" style="text-align: center;"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-footer" style="background-color: #131e33;">
                    </div>

                </div>
            </div>
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

<script src="webDesign/vendors/search_select/select2.js"></script>
<!-- Custom Theme Scripts -->
<script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
<script src="_0_0_0_5_0_0_General_App_Employee_Req.js"></script>
<script type="text/javascript">
                                    getAllRequests('<%=employee_session.getEmployeeNo()%>');
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
%>