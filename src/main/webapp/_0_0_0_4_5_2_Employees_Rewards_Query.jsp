<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubElemSpecAuth_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubElemSpecAuth"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerLocationCodes_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerLocationCodes"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PayBandCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayBandCode"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PayBandCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure"%>
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
            List<PerEmploymentMasters> pList = new PerEmploymentMasters_DAO().getEmployeesByEmployeeID("" + employee_session.getEmployeeId());
            employee_session = pList.get(0);
            String employee_name = employee_session.getEmpAname();
%>
<%
    String LocationName = "";
    String LocationCode = "";
    String BackGround = "";
    try {
        LocationName = employee_session.getPerLocationCodes().getBudLocation().getLocationName();
        LocationCode = employee_session.getPerLocationCodes().getBudLocation().getLocationCode();
    } catch (Exception ex) {
        LocationName = "لا يوجد جهة مسكن بها الموظف";
        LocationCode = "";
        BackGround = "background-color: #ffbdbd;";
    }

%>
<%    String LocName = "";
    String LocCode = "";
    BackGround = "";
    try {
        LocName = employee_session.getPerLocationCodes().getLocName();
        LocCode = employee_session.getPerLocationCodes().getId().getLocCode();
    } catch (Exception ex) {
        LocName = "لا يوجد فرع مسكن به الموظف";
        LocCode = "";
        BackGround = "background-color: #ffbdbd;";
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>إستعلام عن المكافآت</title>
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

        <!-- iCheck -->
        <link href="webDesign/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- Switchery -->
        <link href="webDesign/vendors/switchery/dist/switchery.min.css" rel="stylesheet">

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
            .button_styleSuccess{

                position: fixed;
                bottom: 20px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: #26B99A;
                color: #ffffff !important;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;

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

            hr {
                margin-top: 20px;
                margin-bottom: 20px;
                border: 0;
                border-top: 1px solid #ababab;
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
                                <h3 style="font-weight: bold;">إستعلام عن المكافآت</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>


                        <!--card Start -->
                        <!-- for Edit -->

                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">

                                <%
                                    boolean SearchTypeAvailable = false;
                                    List<AppSubElemSpecAuth> asesaList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuthInSubTab(employee_session.getEmployeeId(), "_0_0_0_4_5_2_Employees_Rewards_Query_AccessServlet");
                                    for (AppSubElemSpecAuth a : asesaList) {
                                        if (a.getAppSubElem().getElementName().equals("Search Type ComboBox")) {
                                            SearchTypeAvailable = true;
                                            break;
                                        }
                                    }
                                    if (SearchTypeAvailable) {
                                %>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label class="control-label" style="font-size: 20px;"> نوع الإستعلام</label>
                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الإستعلام"  id="SearchType" onchange="searchTypeSelect();setLocCode(<%=LocCode%>);" maxlength="45" name="SearchType" class="form-control" required="">
                                        <option value="" style="font-size: 15px;font-weight: bold;">اختر نوع الإستعلام ..</option>
                                        <option style="font-size: 15px;font-weight: bold;" value="1">عام</option>
                                        <option style="font-size: 15px;font-weight: bold;" value="2">خاص</option>
                                    </select>
                                </div>
                                <%
                                    }
                                %>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="LocCodeComboDiv" style="display: none;">
                                    <label class="control-label" style="font-size: 20px;"> اسم الموقع</label>
                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="اسم الموقع" onchange="setLocCode(<%=LocCode%>);getBandCode();" id="LocCodeCombo" maxlength="45" name="LocCodeCombo" class="form-control" required="">
                                        <option value="" style="font-size: 15px;font-weight: bold;">اختر اسم الموقع ..</option>
                                        <%
                                            List<PerLocationCodes> PerLocationCodesList = new PerLocationCodes_DAO().getAllPerLocationCodesBylocationCode(LocationCode);
                                            for (PerLocationCodes p : PerLocationCodesList) {
                                        %>
                                        <option value="<%=p.getId().getLocCode()%>"><%=p.getLocName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label class="control-label" style="font-size: 20px;"> إسم المكافأة</label>
                                    <select style="font-size: 15px;font-weight: bold;" onchange="getExecMM();" type="text" placeholder="إسم المكافأة" id="bandCode" maxlength="6" name="methodType" class="form-control" required="">
                                        <option value="">اختر المكافأة ....</option>

                                    </select>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label class="control-label" style="font-size: 20px;"> الشهر</label>
                                    <select style="font-size: 15px;font-weight: bold;" onchange="rewardStatus();" type="text" placeholder="الشهر" id="month" maxlength="6" name="month" class="form-control" required="">                                            

                                    </select>
                                </div>
                                <%
                                    boolean ReffusedTypeAvailable = false;
                                    for (AppSubElemSpecAuth a : asesaList) {
                                        if (a.getAppSubElem().getElementName().equals("Refused ComboBox")) {
                                            ReffusedTypeAvailable = true;
                                            break;
                                        }
                                    }
                                    boolean QueryTypeAvailableStatus = false;
                                    for (AppSubElemSpecAuth a : asesaList) {
                                        if (a.getAppSubElem().getElementName().equals("Query Type ComboBox")) {
                                            QueryTypeAvailableStatus = true;
                                            break;
                                        }
                                    }
                                    // get Employee Auth on these filters  . . . . . . . . . . . . . . .

                                %>                                 
                                <div id="QueryTypeDiv">

                                </div>
                                <div id="ReffusedTypeDiv">

                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="checkbox">
                                            <label  style="font-size: 15px;font-weight: bold;" >
                                                <input type="checkbox" class="flat" id="locationColStatus"> إظهار الموقع
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr></div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="checkbox">
                                            <label  style="font-size: 15px;font-weight: bold;" onclick="checkDateTimeReviewDiv();">
                                                <input type="checkbox" class="flat" id="rewardDateTimeColStatus" onclick="checkDateTimeReviewDiv();"> إظهار توقيت المكافأة
                                            </label>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="dateTimeReviewDiv" style="display: none;">
                                        <label class="control-label" style="font-size: 20px;">نوع توقيت المكافأة</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع توقيت المكافأة" id="dateTimeReview" maxlength="6" name="dateTimeReview" class="form-control" required="">                                            
                                            <option value="DateOnly">التاريخ فقط</option>
                                            <option value="DateTime">التاريخ والتوقيت</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr></div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="checkbox"  style="font-size: 15px;font-weight: bold;" >
                                            <label style="font-size: 15px;font-weight: bold;" onclick="checkdateTimeEmpReviewDiv();">
                                                <input type="checkbox" class="flat" id="empRewardDateTimeColStatus" onclick="checkdateTimeEmpReviewDiv();"> إظهار توقيت إدخال الموظف
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="dateTimeEmpReviewDiv" style="display: none;">
                                        <label class="control-label" style="font-size: 20px;">نوع توقيت إدخال الموظف</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع توقيت إدخال الموظف" id="dateTimeEmpReview" maxlength="6" name="dateTimeEmpReview" class="form-control" required="">                                            
                                            <option value="DateOnly">التاريخ فقط</option>
                                            <option value="DateTime">التاريخ والتوقيت</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" id="SearchBTN">                                            

                                </div>                                
                            </div>
                        </div>
                        <style>
                            .my-custom-scrollbar {
                                position: relative;
                                height: 550px;
                                overflow: auto;
                            }
                            .table-wrapper-scroll-y {
                                display: block;
                            }
                        </style>
                        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">                                
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div id="PrintID">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center;">
                                            <br>
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="statusDiv" style="font-size: 25px;">
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="PayDeserveEmpFileDtl"><br>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>                    






                    <!-- /page content -->
                </div>

            </div>
            <div id="PrintBtnDiv">
                                                   
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

        <!-- iCheck -->
        <script src="webDesign/vendors/iCheck/icheck.min.js"></script>
        <!-- Switchery -->
        <script src="webDesign/vendors/switchery/dist/switchery.min.js"></script>

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script>

        <script src="_0_0_0_4_5_2_Employees_Rewards_Query.js"></script>
        <script src="AuthJSm.js"></script>
        <%
            if (LocationCode.equals("")) {
        %>
        <script>StickyAlarm("info", "dark", "تحذير", "انت لست مسجل بجهة ...");</script>
        <%
        } else {
        %>
        <script>setLocationCode(<%=LocationCode%>);</script>
        <%
            }
        %>


        <%
            if (LocCode.equals("")) {
        %>
        <script>StickyAlarm("info", "dark", "تحذير", "أنت لست مسجل بفرع ...");</script>
        <%
        } else {
        %>
        <script>setLocCode(<%=LocCode%>);</script>
        <%
            }
        %>

        <script>
            getQueryTypeAvailable(<%=QueryTypeAvailableStatus%>);
            getReffusedTypeAvailable(<%=ReffusedTypeAvailable%>);
        </script>
    </body>
</html>
<%                        } else {
            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
    }
    HibernateSessionCon.session.clear();
%>