/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function QuerySheet() {
    var decisionNoSearch = document.getElementById("decisionNoSearch").value;

    if (decisionNoSearch === "" || decisionNoSearch === null) {
        Warning("برجاء كتابة رقم القرار");
    } else {
        var URL = "_0_0_0_4_0_1_document_query_Ajax_1_GetRightDiv_AjaxServlet?decisionNoSearch=" + decisionNoSearch;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
                if (message === "Error") {
                    // Error Action to Current Page.
                    LoadDefaultScreen();
                    Warning("لا يوجد قرار بهذا الرقم");
                } else {
                    document.getElementById("rightDiv").innerHTML = message;
                    
                    QuerySheet2();
                }
            }
        };
    }
}
function QuerySheet2() {
    var decisionNoSearch = document.getElementById("decisionNoSearch").value;

    if (decisionNoSearch === "" || decisionNoSearch === null) {

    } else {
        var URL = "_0_0_0_4_0_1_document_query_Ajax_2_GetLeftDiv_AjaxServlet?decisionNoSearch=" + decisionNoSearch;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
                if (message === "Error") {
                    // Error Action to Current Page.
                    LoadDefaultScreen();
                } else {
                    document.getElementById("leftDiv").innerHTML = message;
                    setTimeout(reloadDataTable,500);
                }
            }
        };
    }
}


function reloadDataTable() {
    $('#myTable').DataTable()
            .rows().invalidate('data')
            .draw(true);
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
        styling: 'bootstrap3',
        width: '200px'
    });
}
function Custom_Warning(Body, w) {
    new PNotify({
        title: "تحذير",
        text: Body,
        styling: 'bootstrap3',
        width: w
    });
}

var defaultRightDiv = "<div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
        + "                                                    <label class=\"control-label\" style=\"font-size: 15px;\">رقم القرار</label>\n"
        + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"decisionNo\"  value=\"\" required=\"\" readonly=\"\">\n"
        + "                                                </div>\n"
        + "                                                <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
        + "                                                    <label class=\"control-label\" style=\"font-size: 20px;\"> نوع القرار</label>                                                    \n"
        + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"decisionTypeCode\"  value=\"\" required=\"\" readonly=\"\">\n"
        + "                                                </div>\n"
        + "                                                <div class=\"col-lg-4 col-md-4 col-sm-12 col-xs-12\">\n"
        + "                                                    <label class=\"control-label\" style=\"font-size: 20px;\"> الجهة المصدرة للقرار</label>                                                    \n"
        + "                                                    <input type=\"text\" class=\"form-control\" name=\"\" id=\"desicionSideCode\"  value=\"\" required=\"\" readonly=\"\">\n"
        + "                                                </div>\n"
        + "                                                <div class=\"row\">\n"
        + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n"
        + "                                                        <label class=\"control-label\" style=\"font-size: 20px;\">موضوع القرار</label>\n"
        + "                                                        <textarea type=\"text\" class=\"form-control\" name=\"\" id=\"decisionSubject\"  value=\"\" required=\"\" style=\"resize: none;height: 150px;\" readonly=\"\"></textarea>\n"
        + "                                                    </div>\n"
        + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n"
        + "                                                        <label class=\"control-label\" style=\"font-size: 20px;\">ملخص القرار</label>\n"
        + "                                                        <textarea type=\"text\" class=\"form-control\" name=\"\" id=\"decisionSummary\"  value=\"\" required=\"\" style=\"resize: none;height: 150px;\" readonly=\"\"></textarea>\n"
        + "                                                    </div>\n"
        + "                                                </div>\n"
        + "                                                <div class=\"row\">\n"
        + "                                                    <br>\n"
        + "                                                    <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive\">\n"
        + "                                                        <table id=\"myTable\" class=\"table table-striped table-bordered table-hover\">\n"
        + "                                                            <thead style=\"background-color: #337ab7;color: white;\">\n"
        + "                                                                <tr>\n"
        + "                                                                    <th style=\"text-align: center;font-size: 15px;width: 20%\">رقم التأمين</th>\n"
        + "                                                                    <th style=\"text-align: center;font-size: 15px;width: 70%\">بيانات الموظف</th>\n"
        + "                                                                </tr>\n"
        + "                                                            </thead>\n"
        + "                                                            <tfoot id=\"EmpData\">\n"
        + "                                                                <tr>\n"
        + "                                                                    <td></td>\n"
        + "                                                                    <td></td>\n"
        + "                                                                </tr>\n"
        + "                                                            </tfoot>\n"
        + "                                                        </table>\n"
        + "                                                    </div>\n"
        + "                                                </div>";

var defaultLeftDiv = "";
function LoadDefaultScreen() {
    document.getElementById("rightDiv").innerHTML = defaultRightDiv;
    document.getElementById("leftDiv").innerHTML = defaultLeftDiv;
}
LoadDefaultScreen();