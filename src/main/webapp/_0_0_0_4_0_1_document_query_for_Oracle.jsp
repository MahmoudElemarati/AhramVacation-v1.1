<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDesicionSideCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDesicionSideCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerDecisionTypeCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerDecisionTypeCode"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerEmploymentMasters_DAO"%>
<%@page import="java.util.List"%>
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
            //PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");
            //String employee_name = employee_session.getEmpAname();
            String decisionNoSearch = (String) request.getSession().getAttribute("decisionNoSearch");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>البيانات الشخصية</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/home.png">


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

        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

        <!-- bootstrap-wysiwyg -->
        <link href="webDesign/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
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
                background: #851934;
                -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                transition: all 0.3s ease 0s;
            }
            .button_position{
                margin-top: 32px;
                width: 100%;

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


                <!-- top navigation -->
                <div class="top_nav" style="width: 100%;margin-left: 0px;">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                
                            </div>

                            <ul class="nav navbar-nav navbar-right" >
                                <li class="" >

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










                <!-- page content https://howtodoinjava.com/hibernate/hibernate-example-of-insertselect-blob-from-database/-->

                <div class="" role="main">
                    <div class="">
                        <div class="page-title">

                        </div>


                        <div class="clearfix"></div>
                        <div class="row">
                            <!--<div class="title_right" style="direction: rtl;">
                                <h3> البيانات الشخصية</h3>
                            </div>-->
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                <div class="x_panel" style="box-shadow: -1px 2px 5px 1px grey;background-color: #1a3348;background-image: url('webDesign/production/images/template.jpg');">

                                    <div class="x_content" style="font-size: large;font-weight: bold;">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="title_right" style="direction: rtl;color:white;">
                                                <h3 style="font-weight: bold;font-size: xx-large;">القرار</h3>
                                            </div>
                                        </div>
                                        <input type="hidden" class="form-control" name="" id="decisionNoSearch"  value="<%=decisionNoSearch%>" required="">

                                        <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12" style="background-color: #f5f7fa;border-style: groove;">
                                            <div class="form-group" style="font-size: large;background-color: #f5f7fa;" id="rightDiv">

                                            </div>
                                        </div>

                                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">                                                                                        
                                            <div class="x_content" id="leftDiv">

                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>

                    <!-- /page content -->


                </div>

            </div>


            <!-- footer content -->
            <footer style="width: 100%;margin-left: 0px;">
                <div class="pull-right">
                    Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">AMAC-AHRAM</a> All rights reserved.
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->


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
            <!-- PNotify -->
            <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
            <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>

            <!-- morris.js -->
            <script src="webDesign/vendors/raphael/raphael.min.js"></script>
            <script src="webDesign/vendors/morris.js/morris.min.js"></script>
            <!-- bootstrap-progressbar -->
            <script src="webDesign/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
            <!-- bootstrap-daterangepicker -->
            <script src="webDesign/vendors/moment/min/moment.min.js"></script>
            <script src="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

            <script src="_0_0_0_4_0_1_document_query.js"></script>
            <!-- Custom Theme Scripts -->
            <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
            <script>QuerySheet();</script>

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