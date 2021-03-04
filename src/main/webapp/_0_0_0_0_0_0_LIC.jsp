<%-- 
    Document   : _0_0_0_0_0_0_LIC
    Created on : Jul 8, 2020, 1:05:37 PM
    Author     : Support
--%>

<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.Encryption"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.FileOp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        FileOp file = new FileOp("C:\\LIC\\LIC.txt");
        String EnchDate = file.ReadFileInWebApp();//2021-01-01
        String currentDate = new DateOp().getCustomSysDate("yyyy-MM-dd");
        String LastDate = new Encryption().decrypt_LIC(EnchDate).get(1);
        long diff = new DateOp().differentsBetweenTwoDates(LastDate, currentDate, "yyyy-MM-dd");
        if (diff >= 4) {
            //response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        //response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
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
        <meta name="viewport" content= "width=device-width, user-scalable=no">
        <title>شاشة تجديد الرخصة</title>
        <style>
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                /* reset the text-align */
                text-align:left;
                /* inline-block space fix */
                margin-right:-4px;
            }
            .box {
                height:150px;
                border:1px solid #ddd;
            }
        </style>
        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- Animate.css -->
        <link href="webDesign/vendors/animate.css/animate.min.css" rel="stylesheet">
        <!-- Datatables -->
        <link href="webDesign/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="webDesign/build/css/validator_custom.css" type="text/css" />

        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">
    </head>
    <style>
        .cardclass{
            background-color: #851934;
            box-shadow: -3px 12px 12px 5px #888888;
            font-size: 160%;
        }
        .button_style{
            border: none;
            /*background: #337ab7;*/
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
        .input_field{ 
            -webkit-appearance: none; 
            margin: 0; 
        }
    </style>
    <body class="login" >
        <div>           
            <div class="login_wrapper" style="min-width: 80%">
                <section class="login_content" style="text-align: center;text-shadow: 0 0px 0 #fff;"><!--class="login_content" -->
                    <div style="direction: rtl;" novalidate class="mode2">
                        <h1>License Key</h1>
                        <fieldset>
                            <div class="item multi required" >
                                <div class='input'>
                                    <div class="row-centered" >

                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi0" id="multi0" autocomplete="off" maxlength='3' id='multi_first' style="width: 9.3%;">
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi1" id="multi1" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi2" id="multi2" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi3" id="multi3" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi4" id="multi4" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi5" id="multi5" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi6" id="multi6" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi7" id="multi7" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi8" id="multi8" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi9" id="multi9" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input type="text" onkeyup="check();" class="form-control box col-centered" name="multi10" id="multi10" autocomplete="off" maxlength='3' style="width: 9.3%;" >
                                        <input data-validate-length-range="30" data-validate-pattern="numeric" id="serial" type="hidden" required='required' />
                                        <div class="fa fa-paste" style="font-size: xxx-large;cursor: pointer;" onclick="pasteFunction();"></div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" id="ActivateBTN" style="display: none;">
                            <button class="button_style  btn-success form-control" style="width: 40%;"  onclick="Activate();">Activate</button>                               
                        </div>
                        <script>
                            function pasteFunction() {
                                var total_length = 0;
                                var fullKey = prompt("Please Enter License Code ...", "");
                                var key = fullKey.split("-");
                                for (var i = 0; i < 11; i++) {
                                    document.getElementById("multi" + i).value = key[i];
                                    total_length += key[i].length;
                                }
                                if (total_length === 33) {
                                    document.getElementById("ActivateBTN").style.display = "block";
                                } else {
                                    document.getElementById("ActivateBTN").style.display = "none";
                                }
                            }
                            function check() {
                                var total_length = 0;
                                for (var i = 0; i < 11; i++) {
                                    var multi = document.getElementById("multi" + i).value;
                                    total_length += multi.length;
                                }
                                if (total_length === 33) {
                                    document.getElementById("ActivateBTN").style.display = "block";
                                } else {
                                    document.getElementById("ActivateBTN").style.display = "none";
                                }
                            }
                            function Activate() {
                                var key = "";
                                for (var i = 0; i < 11; i++) {
                                    var multi = document.getElementById("multi" + i).value;
                                    if (i === 10) {
                                        key += multi;
                                    } else {
                                        key += multi + "-";
                                    }

                                }
                                var URL = "_0_0_0_0_0_0_LIC_Ajax_1_LoadTable_AjaxServlet?keyLIC=" + key;

                                var xhttp = new XMLHttpRequest();
                                xhttp.open("POST", URL, true);

                                xhttp.send();

                                xhttp.onreadystatechange = function () {
                                    if (xhttp.readyState === 4 && xhttp.status === 200) {
                                        var message = xhttp.responseText;
                                        if (message === "Error") {
                                            Error("Invalid License");
                                        } else {
                                            Success("Successful Activation .. This License Ends in " + message);
                                            clear();
                                            readOnlyForFields();
                                            setTimeout(redirect, 1000);
                                        }
                                    }
                                };
                            }
                            function clear() {
                                document.getElementById("ActivateBTN").style.display = "none";
                                for (var i = 0; i < 11; i++) {
                                    document.getElementById("multi" + i).value = "";
                                }
                            }
                            function readOnlyForFields() {
                                for (var i = 0; i < 11; i++) {
                                    document.getElementById("multi" + i).readOnly = true;
                                }
                            }
                            function redirect() {
                                window.location = '_0_0_0_0_0_1_login_AccessServlet';
                            }
                        </script>

                        <div class="clearfix"></div>                            
                    </div>
                </section>



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
        <script src="webDesign/build/js/multifield.js"></script>
        <script src="webDesign/build/js/validator_custom.js"></script>
        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
        <script>
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
        </script>
    </body>

</html>

