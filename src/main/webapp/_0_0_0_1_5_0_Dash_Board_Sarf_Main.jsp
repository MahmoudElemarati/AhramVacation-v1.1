<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerQualClass"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerQualClass_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFacultyCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFacultyCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerHumanBalYear_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerHumanBalYear"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerPromotionTrans_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionTrans"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionTrans"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerPromotionRule_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerPromotionRule"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerJobLaw_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerJobLaw"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.BudLocation_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.BudLocation"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerCadreDegreeCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerCadreDegreeCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFiscalDegreeCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFiscalDegreeCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerLocationCodes_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerLocationCodes"%>
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

        <title>احصائية</title>
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

        <!-- Bootstrap Colorpicker -->
        <link href="webDesign/vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

        <!-- iCheck -->
        <link href="webDesign/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

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
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="title_right"><h3 style="font-weight: bold;float: right;"> احصائيات شئون العاملين</h3></div>

                        <!-- ///////////////////////////////////////////////////////////
                     ///////////////////////// Dash1  /////////////////////////////// 
                     //////////////////////////////////////////////////////////////-->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">احصائية عن عدد الموظفين بالدرجات</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content" style="box-shadow: -1px 2px 5px 1px #929292;">

                                <!-- ///////////////////////////////////////////////////////////
                      ///////////////////////// Dash1  /////////////////////////////// 
                      //////////////////////////////////////////////////////////////-->
                                <div id="Dash_1">
                                    <br><br>
                                    <div class="x_title">
                                        <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;"> احصائية عرض الموظفين ذكور واناث بالدرجات</h2>                                       
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="row">

                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label" style="font-size: 20px;">نوع الرسم</label>
                                            <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الرسم" id="plotType1" maxlength="45" name="plotType1" class="form-control" required="">
                                                <option value="V" style="font-size: 15px;font-weight: bold;">رأسي</option>
                                                <option value="H" style="font-size: 15px;font-weight: bold;">أفقي</option>                                            
                                            </select>
                                        </div>                                    

                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label" style="font-size: 20px;">نوع الإحصائية</label>
                                            <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الإحصائية" onchange="" id="dashType1" maxlength="45" name="dashType1" class="form-control" required="">
                                                <option value="emp" style="font-size: 15px;font-weight: bold;">إحصائية لموظف</option>
                                                <option value="org" style="font-size: 15px;font-weight: bold;">إحصائية لإدارة</option>
                                                <option value="comp" style="font-size: 15px;font-weight: bold;">إحصائية مؤسسة</option>
                                            </select>
                                        </div>

                                    </div>
                                    <script>


                                    </script>

                                    <div class="row" id="EmpDiv" style="display: block;">
                                        <br>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label" style="font-size: 20px;">رقم التأمين</label>
                                            <input style="font-size: 15px;font-weight: bold;" type="number" onkeyup="getEmpData();"  id="empNo" name="empNo" placeholder="رقم التأمين" maxlength="100" data-placement="bottom" class="form-control">
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <label class="control-label" style="font-size: 20px;">بيانات الموظف</label>
                                            <table id="" class="table table-striped table-bordered">
                                                <thead style="background-color: #68b6ff;">
                                                    <tr>
                                                        <th style="text-align: center;font-size: 15px;width: 10%">رقم التأمين</th>
                                                        <th style="text-align: center;font-size: 15px;width: 10%">إسم الموظف</th>
                                                        <th style="text-align: center;font-size: 15px;width: 20%">الإدارة التابع لها</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="emp_data_table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>



                                    <div class="row" id="OrgDiv" style="display: none;">
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" >
                                            <label class="control-label" style="font-size: 20px;">اختر الإدارة</label>
                                            <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="اختر الإدارة" onchange="" id="orgID" maxlength="45" name="orgID" class="form-control" required="">
                                                <option value="" style="font-size: 15px;font-weight: bold;">اختر الإدارة</option>
                                                <%
                                                    List<PerOrganizationStructure> pList = new PerOrganizationStructure_DAO().getAllOrganizations();
                                                    for (PerOrganizationStructure p : pList) {
                                                %>
                                                <option style="font-size: 15px;font-weight: bold;" value="<%=p.getOrgId()%>"><%=p.getOrgName()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                        <label class="control-label" style="font-size: 20px;">الفترة الزمنية</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="الفترة الزمنية" onchange="IntervalTimeTypeFunction();" id="IntervalTimeType" maxlength="45" name="IntervalTimeType" class="form-control" required="">
                                            <option value="year" style="font-size: 15px;font-weight: bold;">عام خاص</option>
                                            <option value="month" style="font-size: 15px;font-weight: bold;">شهر خاص لعام خاص</option>
                                            <option value="custom" style="font-size: 15px;font-weight: bold;">فترة خاصة</option>
                                        </select>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                        <label class="control-label" style="font-size: 20px;">نوع التقسيم:</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع التقسيم:" onchange="" id="x_part_type" name="x_part_type" class="form-control" required="">
                                            <option value="daily" style="font-size: 15px;font-weight: bold;">يومي</option>
                                            <option value="monthly" style="font-size: 15px;font-weight: bold;">شهري</option>
                                        </select>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12" id="YearDiv" style="display: block;">
                                        <label class="control-label" style="font-size: 20px;">اختر السنة</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder=":مؤشر المعاملة" onchange="" id="year_choice" maxlength="45" name="" class="form-control" required="">
                                            <option value="2018" style="font-size: 15px;font-weight: bold;">2018</option> <!-- all -->
                                            <option value="2019" style="font-size: 15px;font-weight: bold;">2019</option> <!-- !=20 -->
                                            <option value="2020" style="font-size: 15px;font-weight: bold;">2020</option> <!-- =20 -->
                                        </select>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12" id="MonthDiv" style="display: none;">
                                        <label class="control-label" style="font-size: 20px;">اختر الشهر</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder=":مؤشر المعاملة" onchange="" id="month_choice" maxlength="45" name="" class="form-control" required="">
                                            <option value="يناير" style="font-size: 15px;font-weight: bold;">يناير</option> <!-- all -->
                                        </select>
                                    </div>

                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12" id="CustomIntervalDiv" style="display: none;">
                                        <label class="control-label" style="font-size: 20px;">اختر الفترة</label>
                                        <div id="reportrange_FullDashBoard_1" class="pull-right form-control" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                            <span id="date_range">December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                                        </div>
                                    </div>


                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                        <button type="button" data-placement="top" onclick="BuildDash1();" class="button_style btn btn-sm btn-primary button_position fa fa-cogs" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> تكوين الاحصائية</button>
                                    </div>
                                </div>

                            </div>
                        </div>



                        <!-- /page content -->


                    </div>
                </div>

                <script>
                    function getTafaseal(text) {
                        document.getElementById("SababElRafd").innerHTML = text;
                    }
                </script>
                <div class="modal fade ElMarfodat" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">سبب الرفض</h4>
                            </div>
                            <div class="modal-body" >
                                <div id="SababElRafd" style="direction: rtl;font-size: 30px;">

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

        <!-- Bootstrap Colorpicker -->
        <script src="webDesign/vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>


        <!-- iCheck -->
        <script src="webDesign/vendors/iCheck/icheck.min.js"></script>


        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
        <script type="text/javascript">
                    function Success(Body) {
                        new PNotify({
                            title: "تمت",
                            delay: 2000,
                            text: Body,
                            type: 'success',
                            position: 'top left',
                            styling: 'bootstrap3'
                        });
                    }
                    function Error(Body) {
                        new PNotify({
                            title: "خطأ",
                            delay: 5000,
                            text: Body,
                            type: 'error',
                            styling: 'bootstrap3'
                        });
                    }
                    function Warning(Body) {
                        new PNotify({
                            title: "تحذير",
                            delay: 2000,
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
                        minDate: "<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>",
                        format: 'YYYY-MM-DD'
                    });
        </script>
        <script src="_0_0_0_1_5_0_Dash_Board_Sarf_Main.js"></script>
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