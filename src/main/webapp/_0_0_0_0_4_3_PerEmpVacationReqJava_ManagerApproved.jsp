<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.PerOrganizationStructure_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.PerOrganizationStructure"%>
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
            List<PerOrganizationStructure> pList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employee_session.getEmployeeId());
            if (pList.isEmpty()) {
                response.sendRedirect("_0_0_0_0_0_0_Not_Approved_AccessServlet");
            } else {


%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>اعتماد اجازات الموظفين</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/approve.png">
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
                                <h3 style="font-weight: bold;">طلبات اجازات الموظفين</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>



                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead style="background-color: #68b6ff;">
                                        <tr>
                                            <th style="text-align: center;font-size: 15px;width: 10%;">النوع</th>
                                            <th style="text-align: center;font-size: 15px;width: 20%;">اسم الموظف</th>
                                            <th style="text-align: center;font-size: 15px;width: 5%;">المدة</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;">تاريخ تحرير الاجازة</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;">تاريخ بدأ الاجازة</th>
                                            <th style="text-align: center;font-size: 15px;width: 15%;">تاريخ انتهاء الاجازة</th>
                                            <th style="text-align: center;font-size: 15px;width: 20%;">ملاحظات</th>
                                            <th style="text-align: center;background-color: white;"><img src="webDesign/production/images/correctmark.png" alt="" border=1 height=30 width=30></th>
                                            <th style="text-align: center;background-color: white;"><img src="webDesign/production/images/wrongmark.png" alt="" border=1 height=30 width=30></th>
                                        </tr>
                                    </thead>


                                    <tbody id="PerEmpVacationReqJava_Data">
                                        <tr>
                                            <td colspan="9"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <script>

                            var Table1Load = false;
                            function Load_EmployeeVacationsForApproval() {
                                var PageSource = "1";
                                var employeeId = <%=employee_session.getEmployeeId()%>
                                var URL = "_0_0_0_0_4_1_PerEmpVacationReqJava_Ajax_3_LoadTable_AjaxServlet?PageSource=" + PageSource + "&employeeId=" + employeeId;

                                var xhttp = new XMLHttpRequest();
                                xhttp.open("POST", URL, true);

                                xhttp.send();

                                xhttp.onreadystatechange = function () {
                                    if (xhttp.readyState === 4 && xhttp.status === 200) {
                                        var message = xhttp.responseText;
                                        if (message === "Error") {
                                            document.getElementById("PerEmpVacationReqJava_Data").innerHTML = ""
                                                    + "<tr>"
                                                    + "   <td colspan='9'>لا توجد بيانات</td>"
                                                    + "</tr>";
                                            Table1Load = false;
                                        } else {
                                            document.getElementById("PerEmpVacationReqJava_Data").innerHTML = message;
                                            Table1Load = true;
                                        }
                                    }
                                };
                            }
                            setInterval(intitilization2, 3000);
                            function intitilization2() {
                                if (Table1Load === false) {
                                    intitilization();
                                }
                            }
                            setInterval(intitilization3, 5000);
                            function intitilization3() {
                                Table1Load = false;
                            }
                            function intitilization() {
                                Load_EmployeeVacationsForApproval();
                            }

                        </script>


                    </div>

                </div>
            </div>


            <div class="modal fade AlertModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;"></h4>
                        </div>

                        <div class="modal-body" >
                            <div id="BodyId1" style="direction: rtl;font-size: 30px;">

                            </div>
                        </div>

                        <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="UpdateVacStatus();" style="font-weight: bold;border-color: black;width: 15%;" id="ModalButton1"></button>
                            <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                        </div>


                    </div>
                </div>
            </div>

            <script>
                function RedModal() {
                    document.getElementById("Header1").style.backgroundColor = "#d9534f";
                    document.getElementById("Footer1").style.backgroundColor = "#d9534f";
                }
                function GreenModal() {
                    document.getElementById("Header1").style.backgroundColor = "#169f85";
                    document.getElementById("Footer1").style.backgroundColor = "#169f85";
                }
                function setModalBody(body) {
                    document.getElementById("BodyId1").innerHTML = body;
                }
                function setButton(text) {
                    document.getElementById("ModalButton1").innerHTML = text;
                }
                function setTitle(text) {
                    document.getElementById("myModalLabel21").innerHTML = text;
                }

                var VacTransSpGlobal;
                var VacStatusGlobal;
                function StatusVacReq(VacTransSp, VacStatus) {
                    VacTransSpGlobal = VacTransSp;
                    VacStatusGlobal = VacStatus;
                    if (VacStatus === 1) {
                        GreenModal();
                        var body = "<h1 style='text-align:center;'>هل أنت متأكد من الموافقة على الطلب؟</h1>";
                        setModalBody(body);
                        setButton("تأكيد الإعتماد");
                        setTitle("تأكيد الإعتماد");
                    } else if (VacStatus === 2) {
                        RedModal();
                        var body = "<div class='row'>"
                                + "<h1 style='text-align:center;'>هل أنت متأكد من رفض الطلب؟</h1>"
                                + "<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group\">"
                                + "<label class=\"control-label\" style=\"font-size: 20px;\"> سبب الرفض</label>"
                                + "<input style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\" سبب الرفض\" data-placement=\"bottom\" id=\"VacBossNote\" name=\"VacBossNote\" class=\"form-control\" required=\"\">"
                                + "</div>"
                                + "</div>";
                        setModalBody(body);
                        setButton("تأكيد الرفض");
                        setTitle("تأكيد الرفض");
                    }

                }

                function UpdateVacStatus() {
                    var URL = "_0_0_0_0_4_3_PerEmpVacationReqJava_ManagerApproved_Ajax_1_UpdateVacStatusReq_AjaxServlet?VacStatus=" + VacStatusGlobal + "&VacTransSp=" + VacTransSpGlobal;
                    var VacBossNote = "";
                    if (VacStatusGlobal === 2) {
                        VacBossNote = document.getElementById("VacBossNote").value;
                        URL += "&VacBossNote=" + VacBossNote;
                    }
                    var xhttp = new XMLHttpRequest();
                    xhttp.open("POST", URL, true);

                    xhttp.send();

                    xhttp.onreadystatechange = function () {
                        if (xhttp.readyState === 4 && xhttp.status === 200) {
                            var message = xhttp.responseText;
                            if (message === "Success") {
                                if (VacStatusGlobal === 2) {
                                    Success("تمت عملية الرفض بنجاح");
                                } else if (VacStatusGlobal === 1) {
                                    Success("تمت قبول الطلب بنجاح");
                                }
                                Table1Load = false;
                            } else {
                                Error("فشلت العملية برجاء إعادة المحاولة مرة أخرى");
                            }
                        }
                    };

                }

            </script>

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
</body>
</html>
<%  }
        } else {
            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
    }
    HibernateSessionCon.session.clear();
%>