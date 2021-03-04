<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Gentelella Alela! | </title>

        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- Animate.css -->
        <link href="webDesign/vendors/animate.css/animate.min.css" rel="stylesheet">
        <link rel="stylesheet" href="webDesign/build/css/validator_custom.css" type="text/css" />
        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">
    </head>

    <body class="login">
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">
                        <form>
                            <h1>Login Form</h1>
                            <div class="item multi required" >
                                <div class='input'>
                                    <input type="text" class="form-control" name="multi0" autocomplete="off" maxlength='3' id='multi_first' style="width: 9%;">
                                    <input type="text" class="form-control" name="multi1" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi2" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi3" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi4" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi5" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi6" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi7" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi8" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input type="text" class="form-control" name="multi9" autocomplete="off" maxlength='3' style="width: 9%;" >
                                    <input data-validate-length-range="30" data-validate-pattern="numeric" id="serial" type="hidden" required='required' />
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
                                <button class="button_style btn btn-success form-control" href="index.html" style="width: 40%" id='send' type='submit'>Activate</button>                               
                            </div> 
                        </form>
                    </section>
                </div>


            </div>
        </div>
        <!-- jQuery -->
        <script src="webDesign/vendors/jquery/dist/jquery.min.js"></script>
        <script src="webDesign/build/js/multifield.js"></script>
        <script src="webDesign/build/js/validator_custom.js"></script>
    </body>
</html>
