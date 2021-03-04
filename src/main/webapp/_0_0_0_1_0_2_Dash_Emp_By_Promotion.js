/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var status = 't';


function Query(jobLaw, PromotionType, PostDate) {
    if (jobLaw === '1') {
        QueryTable1(jobLaw, PromotionType, PostDate);
        setInterval(queryLoad1, 100);
    } else if (jobLaw === '2') {
        QueryTable2(jobLaw, PromotionType, PostDate);
        setInterval(queryLoad2, 100);
    }
}
function QueryTable1(jobLaw, PromotionType, PostDate) {
    var URL = "_0_0_0_1_0_2_Dash_Emp_By_Promotion_Ajax_1_QueryTable1_AjaxServlet?";
    URL += "jobLaw=" + jobLaw;
    URL += "&PromotionType=" + PromotionType;
    URL += "&PostDate=" + PostDate;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("myTable1").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                document.getElementById("myTable1printedDiv").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";

                status = 'f';
            } else {
                document.getElementById("myTable1").innerHTML = message;
                document.getElementById("myTable1printedDiv").innerHTML = message;
                console.log(message);
                status = 'f';
                reloadDataTable();
                frame(100);
                document.getElementById("btn_Print").style.display = 'block';
            }
        }
    };
}

function QueryTable2(jobLaw, PromotionType, PostDate) {
    var URL = "_0_0_0_1_0_2_Dash_Emp_By_Promotion_Ajax_2_QueryTable2_AjaxServlet?";
    URL += "jobLaw=" + jobLaw;
    URL += "&PromotionType=" + PromotionType;
    URL += "&PostDate=" + PostDate;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("myTable2").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                document.getElementById("myTable2printedDiv").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";

                status = 'f';
            } else {
                document.getElementById("myTable2").innerHTML = message;
                document.getElementById("myTable2printedDiv").innerHTML = message;
                console.log(message);
                status = 'f';
                reloadDataTable();
                frame(100);
                document.getElementById("btn_Print").style.display = 'block';
            }
        }
    };
}

function getLoad1() {
    //alert(status);

    var URL = "_0_0_0_1_0_2_Dash_Emp_By_Promotion_Ajax_3_getLoad1_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {

            } else {
                console.log(message);
                frame(message);
            }
        }
    };
}

function getLoad2() {
    //alert(status);

    var URL = "_0_0_0_1_0_2_Dash_Emp_By_Promotion_Ajax_4_getLoad2_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {

            } else {
                console.log(message);
                frame(message);
            }
        }
    };
}

function queryLoad1() {
    console.log(status);
    if (status === 't') {
        getLoad1();
    } else {

    }
}
function queryLoad2() {
    console.log(status);
    if (status === 't') {
        getLoad2();
    } else {

    }
}

function reloadDataTable() {
    $('#table_resetData').DataTable()
            .rows().invalidate('data')
            .draw(true);
}
var old = 0;
var New = 0;
function frame(width) {
    New = width;
    var elem = document.getElementById("load");
    if (width > 100) {
        elem.style.width = 100 + "%";
        elem.innerHTML = 100 + "%";
        clearInterval(id);
    } else {
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
    }
    old = width;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

function isIntegerNumber(inputtxt) {
    var numbers = /^[0-9]+$/;
    if (inputtxt.value.match(numbers)) {
        return true;
    } else {
        return false;
    }
}


