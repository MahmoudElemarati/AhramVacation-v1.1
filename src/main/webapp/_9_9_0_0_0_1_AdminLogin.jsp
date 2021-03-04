<%-- 
    Document   : _0_0_0_0_0_1_loginscreen
    Created on : Dec 26, 2019, 8:16:17 PM
    Author     : Mohamed
--%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.Encryption"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.FileOp"%>
<%@page import="com.ahramattend.www._0_0_0_0_2_AhramLib.DateOp"%>
<%@page import="com.ahramattend.www._0_0_0_1_0_MainDAOs.HibernateSessionCon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    HibernateSessionCon.OpenCon();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            request.getSession().invalidate();
%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>تسجيل الدخول</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/login.png">


        <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
        <link rel="stylesheet" href="LoginDesign/css/style.css">
        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

    </head>

    <body style="background-color: black;font-family: 'Play', sans-serif;" >

        <div class="wrapper fadeInDown">

            <div id="formContent" >
                <!-- Tabs Titles -->
                <h2 class="active"></h2>

                <!-- Icon -->
                <div class="fadeIn first">
                    <img src="webDesign/production/images/vend.png" id="icon" alt="User Icon" style="width: 50%;"/>
                </div>

                <!-- Login Form -->
                <input type="text" id="username" class="fadeIn third" name="username" autocomplete=""  placeholder="اسم المستخدم">
                <input type="password" id="password" class="fadeIn third" name="Password"  placeholder="كلمة المرور">
                <input type="submit" style="font-weight: bold;box-shadow: 6px 5px 20px black;" onclick="login();" class="fadeIn fourth" value="تسجيل دخول" >


                <!-- Remind Passowrd -->


                <!--<div>
                    <a href="http://10.2.141.191:7778/forms90/f90servlet?config=nwanew" target="_blank"><i class="fa fa-search-plus"></i></a>
                </div>-->



                <div id="formFooter"><br>
                    Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> | <a class="underlineHover">AMAC</a> AHRAM 
                    <br>
                    <a class="underlineHover" href="_0_0_0_0_0_1_login_AccessServlet">التوجه إلى النظام</a>
                </div>                


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
        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <script type="text/javascript">

                    window.addEventListener('keypress', function (e) {
                        if (e.keyCode === 13) {
                            login();
                        }
                    }, false);


                    function login() {
                        var username = document.getElementById("username").value;
                        var password = document.getElementById("password").value;

                        if (username === "" || username === null) {
                            Warning("برجاء إدخال  اسم المستخدم");
                            document.getElementById('username').style.borderColor = "red";
                        } else if (password === "" || password === null) {
                            Warning("برجاء إدخال  كلمة المرور");
                            document.getElementById('password').style.borderColor = "red";
                            document.getElementById('username').style.borderColor = "#737373";
                        } else {
                            var URL = "LoginDevelopAjaxServlet?username=" + username + "&password=" + password;

                            var xhttp = new XMLHttpRequest();
                            xhttp.open("POST", URL, true);

                            xhttp.send();

                            xhttp.onreadystatechange = function () {
                                if (xhttp.readyState === 4 && xhttp.status === 200) {
                                    var message = xhttp.responseText;
                                    //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
                                    if (message !== "Success") {
                                        // Error Action to Current Page.
                                        Warning(message);
                                    } else {
                                        Success("كلمة المرور صحيحة");
                                        window.location = 'LoginDevelopControlServlet?username=' + username + "&password=" + password;
                                    }
                                }
                            };
                        }
                    }


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
<%                        } else {

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
