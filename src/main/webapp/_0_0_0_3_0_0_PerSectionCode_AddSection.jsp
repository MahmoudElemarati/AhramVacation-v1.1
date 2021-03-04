<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.BudLocation_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.BudLocation"%>
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

        <title>ادخال الاقسام</title>
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
                                <h3 style="font-weight: bold;"> ادخال اقسام</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="row">

                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                    <label class="control-label" style="font-size: 20px;"> اسم الجهة</label>
                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الاجازة" onchange="" id="LocationCode" maxlength="45" name="LocationCode" class="form-control" required="">
                                        <%
                                            List<BudLocation> pList = new BudLocation_DAO().getِAllBudLocationByID("0");
                                            for (BudLocation p : pList) {
                                        %>
                                        <option style="font-size: 15px;font-weight: bold;" value="<%=p.getLocationCode()%>"><%=p.getLocationName()%></option>
                                        <%
                                            }
                                        %>

                                    </select>
                                </div>

                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                    <label class="control-label" style="font-size: 20px;"> اسم المستشفى</label>
                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الاجازة" onchange="" id="LocCode" maxlength="45" name="LocCode" class="form-control" required="">
                                        <%
                                            List<PerLocationCodes> LList = new PerLocationCodes_DAO().getAllPerLocationCodes();
                                            for (PerLocationCodes p : LList) {
                                        %>
                                        <option style="font-size: 15px;font-weight: bold;" value="<%=p.getId().getLocCode()%>"><%=p.getLocName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>                                

                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 form-group" id="">
                                    <label class="control-label" style="font-size: 20px;"> اسم القسم</label>
                                    <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="اسم القسم" maxlength="100" data-placement="bottom" id="SecName" name="SecName" class="form-control" required="" value="">
                                </div>


                                <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 form-group">
                                    <label class="control-label" style="font-size: 20px;"> الدور (اختياري)</label>
                                    <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="الدور" maxlength="100" data-placement="bottom" id="SecFloor" name="vacationBalance" class="form-control" required="" value="">
                                </div>


                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                    <button type="button" data-placement="top" onclick="Add();" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> تسجيل الطلب</button>
                                </div>

                            </div>

                            <script>

                                function clearAt() {
                                    document.getElementById("SecName").value="";
                                    document.getElementById("SecFloor").value="";
                                    document.getElementById("SecName").style.borderColor = "#737373";
                                }

                                function Add() {
                                    var LocationCode = document.getElementById("LocationCode").value;
                                    var LocCode = document.getElementById("LocCode").value;
                                    var SecName = document.getElementById("SecName").value;
                                    var SecFloor = document.getElementById("SecFloor").value;


                                    if (SecName === "" || SecName === null) {
                                        Warning("برجاء إدخال اسم القسم");
                                        document.getElementById('SecName').style.borderColor = "red";

                                    } else {
                                        document.getElementById('SecName').style.borderColor = "#737373";

                                        var URL = "_0_0_0_3_0_0_PerSectionCode_Ajax_1_insertIntoPerSectionCode_AjaxServlet?LocationCode=" + LocationCode + "&LocCode=" + LocCode + "&SecName=" + SecName + "&SecFloor=" + SecFloor;

                                        var xhttp = new XMLHttpRequest();
                                        xhttp.open("POST", URL, true);

                                        xhttp.send();

                                        xhttp.onreadystatechange = function () {
                                            if (xhttp.readyState === 4 && xhttp.status === 200) {
                                                var message = xhttp.responseText;
                                                if (message === "Success") {
                                                    Table1Load = false;
                                                    Success("تمت العملية بنجاح");
                                                    intitilization();
                                                    clearAt();
                                                } else {
                                                    Error(message);
                                                }
                                            }
                                        };
                                    }
                                }

                                var Table1Load = false;
                                function Load_PerSectionCode_Table() {
                                    var URL = "_0_0_0_3_0_0_PerSectionCode_Ajax_2_Load_PerSectionCode_Table_AjaxServlet";

                                    var xhttp = new XMLHttpRequest();
                                    xhttp.open("POST", URL, true);

                                    xhttp.send();

                                    xhttp.onreadystatechange = function () {
                                        if (xhttp.readyState === 4 && xhttp.status === 200) {
                                            var message = xhttp.responseText;
                                            if (message === "Error") {
                                                document.getElementById("PerSectionCode_Data").innerHTML = ""
                                                        + "<tr>"
                                                        + "   <td colspan=\"11\"><img src=\"webDesign/img/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=70 width=70></td>                                                                       \n"
                                                        + "</tr>";
                                                Table1Load = false;
                                            } else {
                                                document.getElementById("PerSectionCode_Data").innerHTML = message;
                                                Table1Load = true;
                                            }
                                        }
                                    };
                                }
                                setInterval(intitilization2, 5000);
                                function intitilization2() {
                                    if (Table1Load === false) {
                                        intitilization();
                                    }
                                }
                                function intitilization() {
                                    Load_PerSectionCode_Table();
                                }

                            </script>

                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->





                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                <table id="" class="table table-striped table-bordered table-hover">
                                    <thead style="background-color: #337ab7;color: white;">
                                        <tr>
                                            <th style="text-align: center;font-size: 15px;width: 15%;font-size: 20px;">اسم الجهة</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;font-size: 20px;">اسم المستشفى</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;font-size: 20px;">اسم القسم</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;font-size: 20px;">الدور</th>
                                        </tr>
                                    </thead>

                                    <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                    <tbody id="PerSectionCode_Data">
                                        <tr>
                                            <td colspan="8"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>




                    <script>
                        function DeleteFrom_PerSectionCode(SecCode) {
                            var Confirm = confirm("هل أنت متأكد من إتمام عملية الحذف تلك");
                            if (Confirm === true) {
                                var URL = "_0_0_0_3_0_0_PerSectionCode_Ajax_3_DeleteFrom_PerSectionCode_AjaxServlet?SecCode=" + SecCode;

                                var xhttp = new XMLHttpRequest();
                                xhttp.open("POST", URL, true);

                                xhttp.send();

                                xhttp.onreadystatechange = function () {
                                    if (xhttp.readyState === 4 && xhttp.status === 200) {
                                        var message = xhttp.responseText;
                                        if (message === "Success") {
                                            // Error Action to Current Page.
                                            Success("تمت عملية الحذف بنجاح");
                                            Table1Load = false;
                                            intitilization();
                                        } else {
                                            Error("لا يمكن الحذف لارتباط البيان بعمليات أخرى ...");
                                        }
                                    }
                                };

                            }
                        }
                        

                    </script>

                    <!-- /page content -->

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