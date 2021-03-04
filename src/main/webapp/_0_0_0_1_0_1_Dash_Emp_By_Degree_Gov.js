/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var status = 't';


setInterval(queryLoad, 100);
function QueryEmpByDegree(cadreDegreeCode, generalCode, locationCode) {
    var URL = "_0_0_0_1_0_1_Dash_Emp_By_Degree_Gov_Ajax_1_QueryEmpByDegree_AjaxServlet?";
    URL += "cadreDegreeCode=" + cadreDegreeCode;
    URL += "&generalCode=" + generalCode;
    URL += "&locationCode=" + locationCode;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("myTable").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                document.getElementById("printedDiv").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"1\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";

                status = 'f';
            } else {
                document.getElementById("myTable").innerHTML = message;
                document.getElementById("printedDiv").innerHTML = message;
                console.log(message);
                status = 'f';
                reloadDataTable();
                frame(100);
            }
        }
    };
}

function getLoad() {
    //alert(status);

    var URL = "_0_0_0_1_0_1_Dash_Emp_By_Degree_Gov_Ajax_1_getLoad_AjaxServlet?";

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

function queryLoad() {
    console.log(status);
    if (status === 't') {
        getLoad();
    } else {

    }
}

function reloadDataTable() {
    $('#myTable').DataTable()
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


