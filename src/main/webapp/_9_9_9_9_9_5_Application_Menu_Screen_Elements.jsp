<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppSubTab"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppSubTab_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppTabs"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppTabs_DAO"%>
<%@page import="com.ahramattend.www._0_0_0_2_0_DB_Entities.AppName"%>
<%@page import="com.ahramattend.www._0_0_0_3_0_DB_DAOs.AppName_DAO"%>
<%@page import="javax.security.auth.login.AppConfigurationEntry"%>
<%@page import="com.ahramattend.www._0_0_0_0_1_MainMenu.MainPageAdminCode"%>
<%@page import="com.ahramattend.www._0_0_2_0_3_Enities_For_Developers.Admin_session"%>
<%@page import="com.ahramattend.www._0_0_0_0_1_MainMenu.IconsDropBox"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HibernateSessionCon.OpenCon();
    HibernateSessionCon.session.clear();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            Admin_session admin_session = (Admin_session) request.getSession().getAttribute("admin_session");

            String employee_name = admin_session.getName();

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

        <title>شاشة التحكم الرئيسية</title>
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

        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">

        <style>
            /*Menu Color*/
            /*.systemColor{
                background-color: #3086d2;
            }*/
            /*opened Tab right  Color*/
            /*.nav.side-menu>li.active, 
            .nav.side-menu>li.current-page{
                border-right: 5px solid #bb1aaf;
            }  */      
            /*opened Tab Color*/
            /*.nav.side-menu>li.active>a {
                text-shadow: rgba(0,0,0,.25) 0 -1px 0;
                background: linear-gradient(#3ea1ff,#1e2cca),#131e33;
                box-shadow: rgba(0,0,0,.25) 0 1px 0, inset rgba(255,255,255,.16) 0 1px 0;
            }*/
            /*Text Tab color*/
            /*.nav.child_menu>li>a, 
            .nav.side-menu>li>a {
                color: #ff0000;
            }*/
            /*Text Tab color*/
            /*.nav li li.current-page a, 
            .nav.child_menu li li a.active, 
            .nav.child_menu li li a:hover {
                color: #ff0000;
            }*/
            /*Hover On Text Sub Tab*/
            /*.nav li li.current-page a, .nav.child_menu li li a.active, .nav.child_menu li li a:hover {
                color: #ff0000;
            }
            .nav-md ul.nav.child_menu li:before {
                background: #ff0000;
            }
            .nav-md ul.nav.child_menu li:after {
                border-left: 1px solid #ff0000;
            }*/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
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
            .left_col {
                background: black;
            }
            .nav_title {
                width: 230px;
                float: left;
                background: black;
                border-radius: 0;
                height: 57px;
            }
            .bg-black{
                background: black !important;
                border: 1px solid black !important;
                color: #fff;
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

    </script><!--oncontextmenu="return false"-->

    <body class="nav-md" onload="TodayName();" style="color: #000000;" >
        <div class="container body">
            <div class="main_container">
                <div class="systemColor col-md-3 left_col menu_fixed ">
                    <div class="systemColor left_col scroll-view">
                        <div class="systemColor navbar nav_title" style="border: 0;padding-top: 10px;">
                            <a href="_0_0_0_0_0_2_WelcomePage_AccessServlet" class="site_title">
                                <div style="width: 50%; margin-left: 0px;">
                                </div>
                            </a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix" style="padding-top: 10px;">
                            <div class="profile_pic" style="padding-top: 8px;">
                                <img src="webDesign/production/images/vendCircleWhite.png" alt="..." class="img-circle profile_img" style="background: #000;">
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
                            String M = new MainPageAdminCode().AdminMethod();
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
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color: black;font-size: 20px;">
                                        <%=employee_name%>
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <%
                                        String M2 = new MainPageAdminCode().getAdimMenu();
                                    %>
                                    <%=M2%>
                                </li>
                                <li role="presentation" class="dropdown" >
                                    <a href="javascript:;" class=""  aria-expanded="false">

                                        <span class="badge bg-black fa fa-clock-o" id="clock" style="font-size: 20px;"></span>                                        
                                        <span class="badge bg-black fa fa-calendar" id="dateD" style="font-size: 20px;"></span>                                         
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
                <div class="right_col" role="main" >
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">Screens Elements</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>


                        <!--card Start -->
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;">Add Screen Elements</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->                            

                                <div class="x_content" style="display: none;">                                    
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: left;">
                                        <button type="button" class="fa fa-refresh btn btn-success" id="SaveApplicationTabIndex"   onclick="getScreenElements();" style="font-size: large;font-weight: bold;border: 2px solid white;box-shadow: 7px 8px 11px black;"></button>                                               
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <table id="" class="table table-striped table-bordered table-hover" style="text-align: center;">
                                            <thead style="background-color: black;color: white;">                                                
                                                <tr>
                                                    <th style="text-align: center;font-size: large;">Application Name</th>
                                                    <th style="text-align: center;font-size: large;">Tab Name</th>
                                                    <th style="text-align: center;font-size: large;">Sub Tab Name</th>
                                                    <th style="text-align: center;font-size: large;">Screen Element Count</th>
                                                    <th style="text-align: center;font-size: large;">Screen Element Detail</th>
                                                </tr>
                                            </thead>


                                            <tbody id="SubTabNameBasic_Data2">
                                                <tr>
                                                    <td colspan="5"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="modal fade elementsModel" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog modal-lg" style="border: 2px solid #00d0ff;box-shadow: 0px 0px 20px 0px #00d0ff">
                                            <div class="modal-content">

                                                <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                                    </button>
                                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">Sub Tab Elements Details</h4>
                                                </div>

                                                <div class="modal-body" style="direction: rtl;">
                                                    <div class="row" >
                                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                                                <label class="control-label">Application Name</label>
                                                                <select style="font-size: 15px;font-weight: bold;" disabled="" type="text" placeholder="النظام" id="applicationId" maxlength="45" name="applicationId" class="form-control" required="">                                                                                                            
                                                                    <%
                                                                        List<AppName> pList = new AppName_DAO().getAll_ApplicationName();

                                                                        for (AppName p : pList) {
                                                                    %>
                                                                    <option value="<%=p.getApplicationId()%>"><%=p.getApplicationName()%></option>
                                                                    <%

                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                                                <label class="control-label">Tab Name</label>
                                                                <select style="font-size: 15px;font-weight: bold;" disabled="" type="text" placeholder="النظام" id="tabId" maxlength="45" name="tabId" class="form-control" required="">                                                                                                            
                                                                    <%
                                                                        List<AppTabs> AppTabs = new AppTabs_DAO().get_AllApplicationTabs();

                                                                        for (AppTabs p : AppTabs) {
                                                                    %>
                                                                    <option value="<%=p.getId().getApplicationId()%>-<%=p.getId().getTabId()%>"><%=p.getTabName()%></option>
                                                                    <%

                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                                                <label class="control-label">Sub Tab Name</label>
                                                                <select style="font-size: 15px;font-weight: bold;" disabled="" type="text" placeholder="النظام" id="subTabId" maxlength="45" name="subTabId" class="form-control" required="">                                                                                                            
                                                                    <%
                                                                        List<AppSubTab> ASTList = new AppSubTab_DAO().getAllApplicationSubTabs();

                                                                        for (AppSubTab p : ASTList) {
                                                                    %>
                                                                    <option value="<%=p.getId().getApplicationId()%>-<%=p.getId().getTabId()%>-<%=p.getId().getSubTabId()%>"><%=p.getSubTabName()%></option>
                                                                    <%

                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                                                <label class="control-label" style="font-size: 15px;">Element Name</label>
                                                                <input type="text" class="form-control" name="" id="element_name"  value="" required="">
                                                            </div>
                                                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                                                <label class="control-label">Element Type</label>
                                                                <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="النظام" id="elementType" maxlength="45" name="" class="form-control" required="">                                                                                                            
                                                                    <option value="Button">Button</option>
                                                                    <option value="Field">Field</option>
                                                                    <option value="Combo Box">Combo Box</option>
                                                                    <option value="Table">Table</option>
                                                                    <option value="Block">Block</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                                <br>
                                                                <button type="button" class="fa fa-save btn btn-primary" onclick="Save();" style="font-size: 20px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;"> Save</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                            <br>
                                                            <table id="attendWrkTypeDtlTable" class="table table-striped table-bordered table-hover">
                                                                <thead style="background-color: #68b6ff;">
                                                                    <tr>
                                                                        <th style="text-align: center;font-size: 15px;width: 10%">Element Code</th>
                                                                        <th style="text-align: center;font-size: 15px;">Element Name</th>
                                                                        <th style="text-align: center;font-size: 15px;">Element Type</th>
                                                                        <th style="text-align: center;font-size: 15px;width: 10%">Element Type</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="ElementDtl" style="text-align: center;font-size: 20px;">

                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                        </div>
                                    </div>

                                    <div class="modal fade AlertModal" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">

                                                <div id="Header1" class="modal-header" style="background-color: #d9534f;color: white;">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                                    </button>
                                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;"></h4>
                                                </div>

                                                <div class="modal-body" >
                                                    <div id="BodyId1" style="font-size: 30px;">
                                                        Are You Sure About This Deletion ?...
                                                    </div>
                                                </div>

                                                <div id="Footer1" class="modal-footer" style="background-color: #d9534f; direction: rtl;">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="deleteElement();" style="font-weight: bold;border-color: black;width: 15%;" id="ModalButton1">Delete</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">Close</button>
                                                </div>


                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /for Edit -->

                            </div>
                        </div>


                    </div> 
                </div>
                <!--/ page content -->
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

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- jQuery custom content scroller -->
        <script src="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>

        <script src="_9_9_9_9_9_5_Application_Menu_Screen_Elements.js"></script>



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