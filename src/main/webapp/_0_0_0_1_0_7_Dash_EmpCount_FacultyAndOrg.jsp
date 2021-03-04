<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>


<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerQualClass"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerQualClass_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFacultyCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFacultyCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_0_1_MainMenu.MainPageCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerFiscalDegreeCode_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerFiscalDegreeCode"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure"%>
<%@page import="java.util.List"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerEmploymentMasters"%>
<%@page import="com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HibernateSessionCon.OpenCon();
    HibernateSessionCon.session.clear();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            PerEmploymentMasters employee_session = (PerEmploymentMasters) request.getSession().getAttribute("employee_session");

            String employee_name = employee_session.getEmpAname();

            String plotType = (String) request.getSession().getAttribute("plotType");
            String generalCode = (String) request.getSession().getAttribute("generalCode");
            String locationCode = (String) request.getSession().getAttribute("locationCode");
            String sexFlag = (String) request.getSession().getAttribute("sexFlag");
            String SearchType = (String) request.getSession().getAttribute("SearchType");//1 - use OrgId // 2 - use FacultyCode
            String QualClassCode = (String) request.getSession().getAttribute("QualClassCode");
            String FacultyCode = (String) request.getSession().getAttribute("FacultyCode");

            String color_1 = (String) request.getSession().getAttribute("color_1");
            String color_2 = (String) request.getSession().getAttribute("color_2");
            
            String Title_Name = "";
            String Total_Title_Name = "";
            if (SearchType.equals("1")) {
                List<PerQualClass> PerQualClassList = new PerQualClass_DAO().getPerQualClassByID(QualClassCode);
                Title_Name = Title_Name + "بدرجة علمية " + PerQualClassList.get(0).getQualClassName();
                Total_Title_Name = "بكافة المؤهلات";
            } else if (SearchType.equals("2")) {
                List<PerFacultyCode> PerFacultyCodeList = new PerFacultyCode_DAO().getPerFacultyCodeByID(FacultyCode);
                Title_Name = Title_Name + "بمؤهل " + PerFacultyCodeList.get(0).getFacultyName();
                Total_Title_Name = "بكافة الدرجات العلمية";
            }

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

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

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
                                <h3>إحصائيات كاملة</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="background-color: #131e33;">
                                <div class="x_panel">
                                    <!-- for Edit -->
                                    <div class="x_title" style="display: block;">                                        
                                        <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">احصائية عن عدد الموظفين <%=Title_Name%></h2>
                                        <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                            </li>
                                        </ul>

                                        <div class="clearfix"></div>
                                    </div>
                                    <style>
                                        #load {
                                            width: 0%;
                                            height: 30px;
                                            background-color: #4CAF50;
                                            text-align: center; 
                                            line-height: 30px;
                                            color: white;
                                        }
                                    </style>
                                    <div class="x_content">  

                                        <div class="row">
                                            <div id="myProgress">
                                                <br>
                                                <div id="load">0%</div>
                                                <br>
                                            </div>
                                            <div class="row">
                                                <table id="table_resetData" class="table table-striped table-bordered table-hover">
                                                    <thead style="background-color: #337ab7;color: white;width: 100%;">
                                                        <tr id="headerDiv">
                                                        </tr>
                                                    </thead>
                                                    <tbody id = "bodyDiv">
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="row">
                                                <div class="title_right">
                                                    <h3 style="font-size: 20px;">مجموع الذكور <%=Total_Title_Name%> : <span id="male_count">0</span></h3>
                                                </div>
                                                <div class="title_left">
                                                    <h3 style="font-size: 20px;">مجموع الإناث <%=Total_Title_Name%> : <span id="female_count">0</span></h3>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-1 col-md-1 col-sm-12 col-xs-12 form-group">                                            
                                                    <button type="button" data-original-title="إعادة تكوين الرسم البياني" onclick="refresh('bar', '<%=plotType%>', '<%=generalCode%>', '<%=locationCode%>', '<%=sexFlag%>', '<%=SearchType%>', '<%=QualClassCode%>', '<%=FacultyCode%>','<%=color_1%>', '<%=color_2%>', 'flase');" class="btn btn-app" style="border-style: solid;border-color: #169f85;font-size: 15px;"><i class="fa fa-repeat" style="color: #169f85;"></i>إعادة تكوين الرسم</button>
                                                </div>
                                            </div>                                            
                                            <div class='table-responsive'>

                                                <div id="EmpCount_DashBoard" style="height:500px;"></div>
                                            </div>

                                        </div>

                                    </div>
                                    <!-- /for Edit -->
                                </div>
                            </div>
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

    <!-- Chart.js -->
    <script src="webDesign/vendors/Chart.js/dist/Chart.min.js"></script>

    <!-- jQuery Sparklines -->
    <script src="webDesign/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>

    <!-- Flot -->
    <script src="webDesign/vendors/Flot/jquery.flot.js"></script>
    <script src="webDesign/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="webDesign/vendors/Flot/jquery.flot.time.js"></script>
    <script src="webDesign/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="webDesign/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="webDesign/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="webDesign/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="webDesign/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="webDesign/vendors/DateJS/build/date.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="webDesign/vendors/moment/min/moment.min.js"></script>
    <script src="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- ECharts -->
    <script src="webDesign/vendors/echarts/dist/echarts.min.js"></script>
    <script src="webDesign/vendors/echarts/map/js/world.js"></script>

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



    <!-- Custom Theme Scripts -->
    <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>

    <script src="_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg.js"></script>
    <script>refresh('bar', '<%=plotType%>', '<%=generalCode%>', '<%=locationCode%>', '<%=sexFlag%>', '<%=SearchType%>', '<%=QualClassCode%>', '<%=FacultyCode%>', '<%=color_1%>', '<%=color_2%>', 'true');</script>
    <%
        request.getSession().removeAttribute("OpenHTMLFile");

        request.getSession().removeAttribute("plotType");
        request.getSession().removeAttribute("generalCode");
        request.getSession().removeAttribute("locationCode");
        request.getSession().removeAttribute("sexFlag");
        request.getSession().removeAttribute("SearchType");
        request.getSession().removeAttribute("QualClassCode");
        request.getSession().removeAttribute("FacultyCode");
        request.getSession().removeAttribute("color_1");
        request.getSession().removeAttribute("color_2");
    %>
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