
function getAppReqType() {
    var applicationId = document.getElementById("applicationId").value;
    if (!(applicationId === "" || applicationId === null)) {
        var URL = "_0_0_0_5_0_0_General_App_Employee_Req_Ajax_1_getAppReqType_AjaxServlet?";
        URL += "applicationId=" + applicationId;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    defaultStatus("غير معروف");
                } else {
                    document.getElementById("appReqType").innerHTML = message;
                }
            }
        };
    } else {
        document.getElementById("appReqType").innerHTML = "";
    }
}

function requestForOthers() {
    var checkSearch = document.getElementById("checkSearch").checked;
    var checkElemant = document.getElementById('checkElemant');
    if (checkSearch) {
        checkElemant.style.display = "block";
    } else {
        checkElemant.style.display = "none";
    }
}
function addRequestToTable() {

}
function copyName() {
    var EmpName_element = document.getElementById("EmployeeId");
    var EmpName = EmpName_element.options[EmpName_element.selectedIndex].text.split('...');
    document.getElementById("EmployeeName").value = EmpName[0];
    document.getElementById("org").value = EmpName[1];
}
function getEmployeeData() {
    var EmployeeName = document.getElementById("EmployeeName").value;
    var EmployeeNameArr = EmployeeName.split(" ");
    if (EmployeeName === "" || EmployeeName === null) {
//Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("EmployeeId").innerHTML = "";
    } else if (EmployeeNameArr.length < 3) {
        document.getElementById("EmployeeId").innerHTML = "";
    } else {
        var URL = "_0_0_0_5_0_0_General_App_Employee_Req_Ajax_2_getEmployeeData_AjaxServlet?";
        URL += "EmployeeName=" + EmployeeName;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("EmployeeId").innerHTML = "";
                } else {
                    document.getElementById("EmployeeId").innerHTML = message;
                }
            }
        };
    }
}

var empTableArr = [];

function addEmployeeToTable() {
    var EmpName_element = document.getElementById("EmployeeId");
    var EmpId = EmpName_element.value;
    var EmpName = EmpName_element.options[EmpName_element.selectedIndex].text.split('...');
    var empRmrk = document.getElementById("empRmrk").value;

    if (EmpId === "" || EmpId === null) {
        Warning("اختر موظف");
    } else {
        //check Employee Number
        var employee_check = true;
        for (var i = 0; i < empTableArr.length; i++) {
            //console.log("arr : " + empTableArr[i].employee_no + " - " + EmpId);
            if (empTableArr[i].employee_no === EmpId) {
                employee_check = false;
                Warning("هذا الموظف مسجل من قبل");
                break;
            }
        }

        if (employee_check) {
            var employeeDataClass = new Object();
            employeeDataClass.employee_no = EmpId;
            employeeDataClass.employee_type = "To";
            employeeDataClass.employee_name = EmpName[0];
            employeeDataClass.employee_org = EmpName[1];
            employeeDataClass.employee_rmrk = empRmrk;
            empTableArr.push(employeeDataClass);
            createTable();
        }

    }

}
function createTable() {
    var table_content = document.getElementById("empData");
    table_content.innerHTML = "";
    var html = "";
    for (var i = 0; i < empTableArr.length; i++) {
        html += "<tr>"
                + "<td>" + empTableArr[i].employee_no + "</td>"
                + "<td>" + empTableArr[i].employee_name + "</td>"
                + "<td>" + empTableArr[i].employee_org + "</td>"
                + "<td>"
                + "     <button type=\"button\" onclick=\"DeleteRow('" + empTableArr[i].employee_id + "')\" class=\"fa fa-trash btn btn-danger\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                + "</td>"
                + "</tr>";
    }
    table_content.innerHTML = html;
}

function DeleteRow(employee_id) {
    for (var i = 0; i < empTableArr.length; i++) {
        if (empTableArr[i].employee_id === employee_id) {
            empTableArr.splice(i);
        }
    }
    createTable();
}

var readyToSave = true;
function sendRequest(employee_no_from_Session) {
    //empTableArr
    var checkSearch = document.getElementById("checkSearch").checked;
    var applicationId = document.getElementById("applicationId").value;
    var appReqType = document.getElementById("appReqType").value;
    var mainRmrk = document.getElementById("mainRmrk").value;
    if (applicationId === "" || applicationId === null) {
        Warning("اختر اسم البرنامج");
    } else if (appReqType === "" || appReqType === null) {
        Warning("اختر نوع الطلب");
    } else {


        if (readyToSave) {
            var employeeDataClass = new Object();
            employeeDataClass.employee_no = employee_no_from_Session;
            employeeDataClass.employee_type = "From";
            employeeDataClass.employee_name = "";
            employeeDataClass.employee_rmrk = "";
            employeeDataClass.appReqType = appReqType;
            employeeDataClass.mainRmrk = mainRmrk;
            empTableArr.push(employeeDataClass);

            if (checkSearch) {
                for (var i = 0; i < empTableArr.length; i++) {
                    empTableArr[i].applicationId = applicationId;
                    empTableArr[i].appReqType = appReqType;
                    empTableArr[i].mainRmrk = mainRmrk;
                }
            }
            readyToSave = false;
        }

        console.log(JSON.stringify(empTableArr));
        $.ajax({
            url: "_0_0_0_5_0_0_General_App_Employee_Req_Ajax_3_sendRequest_AjaxServlet?",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(empTableArr),
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                //a_0_0_5_2_students = JSON.parse(data.toString());
                Success("تم إرسال الطلب");
                resetPageContent();
                getAllRequests(employee_no_from_Session);
            },
            error: function (xhr, status) {
                Error("حدث خطأ");
                readyToSave = false;
            }
        });
    }

}

function getAllRequests(employee_no_from_Session) {
    var employeeDataClass = new Object();
    employeeDataClass.employee_no = employee_no_from_Session;
    $.ajax({
        url: "_0_0_0_5_0_0_General_App_Employee_Req_Ajax_4_getAllRequests_AjaxServlet?",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(employeeDataClass),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                var chkView = "";
                if (data[i].chkView === '1') {
                    chkView = "<img src=\"webDesign/production/images/mail1.png\" height=30 width=30> تم إرسال الطلب</td>\n";
                } else if (data[i].chkView === '2') {
                    chkView = "<img src=\"webDesign/production/images/cogs.gif\" height=30 width=30> تم استقبال الطلب</td>\n";
                } else if (data[i].chkView === '3') {
                    chkView = "<img src=\"webDesign/production/images/correctmark.png\" height=30 width=30> تمت المراجعة</td>\n";
                }
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].applicationName + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].appReqTypeName + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].reqDateTime + "</td>"
                        + "<td class=\"table-font-style\">" + checkNull(data[i].mainRmrk, "") + "</td>"
                        + "<td class=\"table-font-style\">" + chkView + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].doneDateTime + "</td>"
                        + "<td>"
                        + "     <button type=\"button\" onclick=\"getDetails('" + data[i].reqSp + "')\" data-toggle=\"modal\" data-target=\".ElDetail\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "</tr>";
            }
            if (i === 0) {
                document.getElementById("all_requests").innerHTML =
                        "<tr>"
                        + "    <td colspan='7'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("all_requests").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
function getDetails(reqSp) {
    var employeeDataClass = new Object();
    employeeDataClass.reqSp = reqSp;
    $.ajax({
        url: "_0_0_0_5_0_0_General_App_Employee_Req_Ajax_5_getDetails_AjaxServlet?",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(employeeDataClass),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                var chkRev = "";
                var btn = "";
                if (data[i].chkRev === null) {
                    chkRev = "<img src=\"webDesign/production/images/waiting.png\" height=30 width=30> لم يتم الرد</td>\n";
                    btn = "";
                } else if (data[i].chkRev !== null && data[i].chkView !== "3") {
                    chkRev = "<img src=\"webDesign/production/images/correctmark.png\" height=30 width=30> تمت المراجعة</td>\n";
                    btn = "";
                } else if (data[i].chkRev !== null && data[i].chkView === "3") {
                    chkRev = "<img src=\"webDesign/production/images/correctmark.png\" height=30 width=30> تمت المراجعة</td>\n";
                    btn = "<button type=\"button\" onclick=\"getResult('" + data[i].employee_no + "','" + data[i].appReqType + "','" + data[i].reqSp + "')\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>";
                }
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].employee_no + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].employee_name + "</td>"
                        + "<td class=\"table-font-style\">" + checkNull(data[i].sendDate, "") + "</td>"
                        + "<td class=\"table-font-style\">" + checkNull(data[i].employee_rmrk, "") + "</td>"
                        + "<td class=\"table-font-style\">" + chkRev + "</td>"
                        + "<td class=\"table-font-style\">" + btn + "</td>"
                        + "</tr>";
            }
            if (i === 0) {
                document.getElementById("request_detail").innerHTML =
                        "<tr>"
                        + "    <td colspan='6'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("request_detail").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function resetPageContent() {
    empTableArr = [];
    document.getElementById("empData").innerHTML = "<tr>\n"
            + "       <td colspan=\"4\" style=\"text-align: center;\">لم يوجد موظفين مسجلين</td>\n"
            + "  </tr>";
    document.getElementById("empRmrk").value = "";
    document.getElementById("org").value = "";
    document.getElementById("EmployeeName").value = "";
    document.getElementById("EmployeeId").value = "";
    document.getElementById("EmployeeId").innerHTML = "";
    document.getElementById("mainRmrk").value = "";
    document.getElementById("appReqType").innerHTML = "";
    document.getElementById("appReqType").value = "";
    document.getElementById("applicationId").value = "";
    readyToSave = true;

}

function getResult(employeeNo, appReqType, reqSp) {
    var checkSearch = document.getElementById("checkSearch").checked;
    var checkStatus = "";
    if (checkSearch) {
        checkStatus = "others";     
    } else {
        checkStatus = "self"; 
    }
    if (appReqType === "1") {
        var URL2 = "_0_0_0_5_0_1_PerEmploymentMasters_QueryReport_AccessServlet?hxdtfdfdfgdfgdfgdsfhgsdfghdfghdfghjhgthsfgsghsadfgshfghdfghdjdsasdgdfdfg=r&Key=Open&employeeNo=" + employeeNo;
    } else if (appReqType === "2") {
        var URL2 = "_0_0_0_5_0_1_PayEmployeeReq_print_AccessServlet?hxdtfdfdfgdfgdfgdsfhgsdfghdfghdfghjhgthsfgsghsadfgshfghdfghdjdsasdgdfdfg=r&Key=Open&employeeNo=" + employeeNo+"&reqSp=" + reqSp+"&checkStatus=" + checkStatus;
    }
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
}
$(function () {
    $(".SELECT_Combo").select2();
});

function checkNull(val, message) {
    if (val === null) {
        return message;
    } else {
        return val;
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