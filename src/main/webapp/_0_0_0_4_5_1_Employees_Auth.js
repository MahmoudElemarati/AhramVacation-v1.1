/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getEmployeeNoOut(employeeNo) {
    document.getElementById("searchEmpId").value = employeeNo;
    getEmpDataAjaxDelay();
}


function getEmpDataAjaxDelay() {
    setTimeout(getEmpDataAjax, 500);
}
function getEmpDataAjax() {
    var employeeId = document.getElementById("searchEmpId").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_1_getEmployeeData_AjaxServlet?";

        URL += "employeeId=" + employeeId + "&typeSearch=1";

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "لا توجد بيانات موظف" || message === "هذا الموظف غير مسكن بالفرع") {
                    document.getElementById("searchEmpData").innerHTML = message;
                    document.getElementById("EmpAuthData").innerHTML = "";
                } else {
                    document.getElementById("searchEmpData").innerHTML = message;
                    getAvailableScreens();
                }
            }
        };
    }
}
function ResetModal() {
    document.getElementById("searchEmpName").value = "";
    document.getElementById("EmpDataSearchResult").innerHTML = "";
}

function getEmpDataByNameSearchDelay() {
    setTimeout(getEmpDataByNameSearch, 500);
}
function getEmpDataByNameSearch() {
    var searchEmpName = document.getElementById("searchEmpName").value;
    var searchEmpNameArr = searchEmpName.split(" ");
    if (searchEmpName === "" || searchEmpName === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("EmpDataSearchResult").innerHTML = "";
    } else if (searchEmpNameArr.length < 3) {
        document.getElementById("EmpDataSearchResult").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_7_getEmployeesData_AjaxServlet?";

        URL += "searchEmpName=" + searchEmpName;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("EmpDataSearchResult").innerHTML = "";
                } else {
                    document.getElementById("EmpDataSearchResult").innerHTML = message;
                }
            }
        };
    }
}
function getAvailableScreens() {
    var employee_no = document.getElementById("searchEmpId").value;
    var searchEmpData = document.getElementById("searchEmpData").innerHTML;
    if (!(searchEmpData === "" || searchEmpData === "لا توجد بيانات موظف")) {
        if (employee_no === "" || employee_no === null) {
            //Warning("برحاء ادخال تأمين الموظف");
            document.getElementById("EmpAuthData").innerHTML = "";
        } else {
            var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_2_getEmployeesAuth_AjaxServlet?";

            URL += "employee_no=" + employee_no;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        Error("حدث خطأ");
                        document.getElementById("EmpAuthData").innerHTML = "";
                    } else {
                        document.getElementById("EmpAuthData").innerHTML = message;
                        switchCheck();
                        ShowBTN();
                    }
                }
            };
        }
    }
}
function ShowBTN() {
    var sub_tab_id = document.getElementsByClassName("sub_tab_id2");
    if (sub_tab_id.length > 0) {
        document.getElementById("saveAuthBtn2").disabled = false;
    } else {
        document.getElementById("saveAuthBtn2").disabled = true;
    }
}
function SaveAuth2() {
    var searchEmpId = document.getElementById("searchEmpId").value;
    var searchEmpData = document.getElementById("searchEmpData").innerHTML;
    if (searchEmpId === "" || searchEmpId === null) {
        Warning("برجاء إدخال رقم الموظف");
    } else if (searchEmpData === "" || searchEmpData === "لا توجد بيانات موظف") {
        Warning("رقم الموظف غير موجود");
    } else {
        var url = "";
        var sub_tab_id = document.getElementsByClassName("sub_tab_id2");
        for (var i = 0; i < sub_tab_id.length; ) {
            url += "sub_tab_id=" + sub_tab_id[i].innerHTML + "&";
            i = i + 1;
        }
        var AuthChecked = document.getElementsByName("cheackBox2");
        for (var i = 0; i < AuthChecked.length; ) {
            url += "AuthChecked=" + AuthChecked[i].checked + "&";
            i = i + 1;
        }
        var primaryAuthPass = document.getElementsByName("primaryAuthPass2");
        for (var i = 0; i < primaryAuthPass.length; ) {
            if (i < primaryAuthPass.length - 1) {
                url += "primaryAuthPass=" + primaryAuthPass[i].value + "&";
            } else {
                url += "primaryAuthPass=" + primaryAuthPass[i].value;
            }
            i = i + 1;
        }
        var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_3_GiveEmpAuth_AjaxServlet?";
        URL += url;
        URL += "&employeeId=" + searchEmpId;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else {
                    Success("تم إعطاء الصلاحية بنجاح");
                    getAvailableScreens();
                }
            }
        };
    }
}
switchCheck();
function switchCheck() {
    $(document).ready(function () {
        if ($(".js-switch")[0]) {
            var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
            elems.forEach(function (html) {
                var switchery = new Switchery(html, {
                    color: '#26B99A'
                    , secondaryColor: '#dc0000'
                });
            });
        }
    });
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