/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var status = 'f';
setInterval(init, 500);
function init() {
    queryLoad();
}

var FullDate = "";
function getDashVariables(date_from, date_to, LocationCode_Global, LocTableArr, rejects, parts, detailType) {
    
    status = 't';
    FullDate = date_from + " | " + date_to;
    //alert(date_from);

    var _0_0_0_4_5_3_Employees_Rewards_01_Jason = new Object();
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.dateFrom = date_from;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.dateTo = date_to;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.locationCode = LocationCode_Global;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.locCode = LocTableArr;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.rejects = rejects;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.parts = parts;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.detailType = detailType;
    //consol(_0_0_0_4_5_3_Employees_Rewards_01_Jason.LocCodes,false);
    $.ajax({
        url: "_0_0_0_4_5_3_Employees_Rewards_Dashboard_Ajax_1_GetBandsOf_AjaxServlet?",
        type: "POST",
        //dataType: "json",
        data: JSON.stringify(_0_0_0_4_5_3_Employees_Rewards_01_Jason),
        success: function (data) {
            if (data === "Success") {
                //Success("جاري تحميل الإحصائية");
            } else if (data === "Error") {
                Error("حدث خطأ");
                document.getElementById("PrintBtn").disabled = true;
            } else {
                //Success("جاري تحميل الإحصائية");
                document.getElementById("searchResultByLoc_Table").innerHTML = data;
                status = 'f';
                frame(100);
                setTableDesviption();
                document.getElementById("PrintBtn").disabled = false;
            }
        },
        error: function (xhr, status) {
            console.log(status); // Output as parseError
            console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            if (xhr.responseText === "Error") {
                Error("حدث خطأ");
                document.getElementById("PrintBtn").disabled = true;
            } else {
                Warning(xhr.responseText);
                document.getElementById("PrintBtn").disabled = true;
            }
        }
    });
}


function getDashVariablesBand(date_from, date_to, LocationCode_Global, LocTableArr, BandTableArr, rejects, parts, detailType) {
    status = 't';
    FullDate = date_from + " | " + date_to;

    document.getElementById("PrintBtn").disabled = true;

    var _0_0_0_4_5_3_Employees_Rewards_01_Jason = new Object();
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.dateFrom = date_from;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.dateTo = date_to;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.locationCode = LocationCode_Global;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.locCode = LocTableArr;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.bandCode = BandTableArr;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.rejects = rejects;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.parts = parts;
    _0_0_0_4_5_3_Employees_Rewards_01_Jason.detailType = detailType;
    //consol(_0_0_0_4_5_3_Employees_Rewards_01_Jason.LocCodes,false);
    $.ajax({
        url: "_0_0_0_4_5_3_Employees_Rewards_Dashboard_Ajax_2_GetBandsOf_AjaxServlet?",
        type: "POST",
        //dataType: "json",
        data: JSON.stringify(_0_0_0_4_5_3_Employees_Rewards_01_Jason),
        success: function (data) {
            if (data === "Success") {
                //Success("جاري تحميل الإحصائية");
            } else if (data === "Error") {
                Error("حدث خطأ");
                document.getElementById("PrintBtn").disabled = true;
            } else {
                //Success("جاري تحميل الإحصائية");
                document.getElementById("searchResultByLoc_Table").innerHTML = data;
                status = 'f';
                frame(100);
                setTableDesviption();
                document.getElementById("PrintBtn").disabled = false;
            }
        },
        error: function (xhr, status) {
            console.log(status); // Output as parseError
            console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            if (xhr.responseText === "Error") {
                Error("حدث خطأ");
                document.getElementById("PrintBtn").disabled = true;
            } else {
                Warning(xhr.responseText);
                document.getElementById("PrintBtn").disabled = true;
            }
        }

    });

}

function setTableDesviption() {
    var date_range = FullDate;
    document.getElementById("TableDetails").innerHTML = "فترة الإستعلام " + date_range;
}
function clearTableResult() {
    document.getElementById("searchResultByLoc_Table").innerHTML = "";
    frame(0);
}

function consol(data, clear) {
    if (clear) {
        document.getElementById("consol").value = data;
    } else {
        document.getElementById("consol").value += data + "\n";
    }

}



//////  Load Bar
function getLoad() {
    //alert(status);
    var URL = "_0_0_0_4_5_3_Employees_Rewards_Dashboard_Ajax_3_getLoad_1_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                //document.getElementById("load").innerHTML = "";

            } else {                
                //document.getElementById("load").innerHTML = message;
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
var old = 0;
var New = 0;
function frame(width) {
    New = width;
    var elem = document.getElementById("load");
    if (width > 100) {
        clearInterval(id);
    } else {
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
    }
    old = width;
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
function StickyAlarm(type, addclass, title, body) {
    new PNotify({
        title: title,
        text: body,
        type: type,
        hide: false,
        styling: 'bootstrap3',
        addclass: addclass
    });
}