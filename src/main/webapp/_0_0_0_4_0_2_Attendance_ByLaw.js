/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
init();
function init() {
    QueryPerAttendWrkTypeCode();
}
function QueryPerAttendWrkTypeCode() {

    var URL = "_0_0_0_4_0_2_Attendance_ByLaw_Ajax_1_PerAttendWrkTypeCode_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
            if (message === "Error") {
                // Error Action to Current Page.
                document.getElementById("attendWrkTypeCode").innerHTML = "<tr><td colspan='6'>لا يوجد أنواع لأنظمة عمل</td></tr>";
            } else {
                document.getElementById("attendWrkTypeCode").innerHTML = message;
                reloadDataTable("attendWrkTypeCodeTable");
            }
        }
    };
}

function QueryPerAttendWrkTypeDtl(wrkTypeCode, workTypeName) {
    document.getElementById("DtlTitle").innerHTML = workTypeName;
    var URL = "_0_0_0_4_0_2_Attendance_ByLaw_Ajax_2_QueryPerAttendWrkTypeDtl_AjaxServlet?wrkTypeCode=" + wrkTypeCode;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
            if (message === "Error") {
                // Error Action to Current Page.
                document.getElementById("attendWrkTypeDtl").innerHTML = "<tr><td colspan='9'>لا يوجد تفاصيل لهذا النظام</td></tr>";
            } else {
                document.getElementById("attendWrkTypeDtl").innerHTML = message;
                //reloadDataTable("attendWrkTypeDtlTable");
            }
        }
    };
}
function QueryPerEmploymentMastersByattendTypeDtl(wrkTypeCode, wrkTypeSeq) {

    var URL = "_0_0_0_4_0_2_Attendance_ByLaw_Ajax_3_QueryPerEmploymentMastersByattendTypeDtl_AjaxServlet?wrkTypeCode=" + wrkTypeCode + "&wrkTypeSeq=" + wrkTypeSeq;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
            if (message === "Error") {
                // Error Action to Current Page.
                document.getElementById("perEmpMasterByWrkDtl").innerHTML = "<tr><td colspan='3'>لا يوجد موظفين معنيين بالنظام</td></tr>";
            } else {
                document.getElementById("perEmpMasterByWrkDtl").innerHTML = message;
                //reloadDataTable("perEmpMasterByWrkDtlTable");
            }
        }
    };
}



function reloadDataTable(table_id) {
    $('#' + table_id).DataTable()
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
        styling: 'bootstrap3'
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