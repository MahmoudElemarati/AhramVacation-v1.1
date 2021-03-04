/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var insert_Update_delete = true;
var LocCode_Global = "";
var LocationCode_Global = "";
function setLocCode(LocCode) {
    LocCode_Global = LocCode;
}
function setLocationCode(LocationCode) {
    LocationCode_Global = LocationCode;
}

window.addEventListener('keypress', function (e) {

    if (e.keyCode === 13) {
        var searchEmpId = document.querySelector("#searchEmpId");
        var rewardValue = document.querySelector("#rewardValue");

        var rewardValue_val = document.getElementById("rewardValue").value;
        var bandCode = document.getElementById("bandCode").value;
        var month = document.getElementById("month").value;
        if (bandCode === "" || bandCode === null) {
            Warning("برحاء إختيار المكافأة");
        } else if (month === "" || month === null) {
            Warning("برحاء إختيار الشهر");
        } else if (rewardValue === document.activeElement && (rewardValue_val === "" || rewardValue_val === null)) {
            Warning("برحاء ادخال القيمة");
        } else if (searchEmpId === document.activeElement || rewardValue === document.activeElement) {
            if (insert_Update_delete) {
                addEmpToTable();
            } else {
                Warning("حالة البيان مغلقة وغير قابلة للتعديل");
            }

        }
    }
}, false);
function getEmployeeNoOut(employeeNo) {
    document.getElementById("searchEmpId").value = employeeNo;
    getEmpDataAjaxDelay();
}
function getEmployeeNoOut2(employeeNo) {
    document.getElementById("searchEmpId").value = employeeNo;
    getEmpDataAjaxDelay();
    $('.LoadEmpModal').modal('toggle');
    $('.DeptSearchModal').modal('toggle');
}
function addEmpToTable() {
    var employeeId = document.getElementById("searchEmpId").value;
    var rewardValue = document.getElementById("rewardValue").value;
    var flag = 0;

    if (employeeId === "" || employeeId === null) {
        Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpId").focus();
        document.getElementById("searchEmpData").innerHTML = "";
    } else if (rewardValue === "" || rewardValue === null) {
        document.getElementById("rewardValue").focus();
        //Warning("برحاء ادخال القيمة");
    } else if (!(isInt(+rewardValue) || isFloat(+rewardValue))) {
        Warning("برحاء ادخال القيمة كرقم");
        document.getElementById("rewardValue").value = "";
        document.getElementById("rewardValue").focus();
    } else {
        var empIds;
        try {
            empIds = document.getElementsByClassName("empIdsClass");//فالجدول اللي هييجي من الأجاكس
            for (var i = 0; i < empIds.length; ) {
                if (empIds[i].value === employeeId) {
                    flag = 1;
                    break;
                }
                i = i + 1;
            }
        } catch (err) {
        }
        if (rewardValue === "" || rewardValue === null) {
            document.getElementById("rewardValue").focus();
            flag = 1;
            Warning("برحاء ادخال القيمة");
        }

        var searchEmpData = document.getElementById("searchEmpData").innerHTML;
        if (searchEmpData === "لا توجد بيانات موظف"/* || searchEmpData === "هذا الموظف غير مسكن بالفرع"*/) {
            Warning(searchEmpData);
            flag = 2;
        }

        if (flag === 0) {
            var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_1_getEmployeeData_AjaxServlet?";
            URL += "employeeId=" + employeeId;
            URL += "&typeSearch=2";
            URL += "&LocCode=" + LocCode_Global;
            URL += "&LocationCode=" + LocationCode_Global;
            URL += "&rewardValue=" + rewardValue;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        Error("حدث خطأ");
                        //document.getElementById("searchEmpData").innerHTML = "لا توجد بيانات موظف";
                    } else {
                        document.getElementById("EmpData").innerHTML += message;
                        document.getElementById("searchEmpData").innerHTML = "";
                        document.getElementById("searchEmpId").value = "";
                        document.getElementById("rewardValue").value = "";
                        document.getElementById("searchEmpId").focus();
                        Save();
                    }
                }
            };
        } else if (!(flag === 2)) {
            document.getElementById("searchEmpId").value = "";
            document.getElementById("rewardValue").value = "";
            document.getElementById("searchEmpId").focus();
            Warning("الموظف مسجل بالقرار من قبل");
        }
    }

}
function getEmpDataAjaxDelay() {
    setTimeout(getEmpDataAjax, 500);
}
function getEmpDetail(employeeId) {
    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("EmpDataDtlTable").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_1_getEmployeeData_AjaxServlet?";

        URL += "employeeId=" + employeeId + "&typeSearch=3";

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("EmpDataDtlTable").innerHTML = "";
                } else {
                    document.getElementById("EmpDataDtlTable").innerHTML = message;
                }
            }
        };
    }
}
function getEmpDataAjax() {
    var employeeId = document.getElementById("searchEmpId").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_1_getEmployeeData_AjaxServlet?";

        URL += "employeeId=" + employeeId + "&typeSearch=1";
        URL += "&LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "لا توجد بيانات موظف" || message === "هذا الموظف غير مسكن بالفرع") {
                    document.getElementById("searchEmpData").innerHTML = message;
                } else {
                    document.getElementById("searchEmpData").innerHTML = message;
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
        URL += "&LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;

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
function getEmployeeInThisLoc(Location_code, Loc_code) {
    var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_9_getEmployeesData_AjaxServlet?";
    URL += "LocCode=" + Loc_code;
    URL += "&LocationCode=" + Location_code;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("حدث خطأ");
                document.getElementById("EmpDataFromDeptSearchResult").innerHTML = "";
            } else {
                document.getElementById("EmpDataFromDeptSearchResult").innerHTML = message;
            }
        }
    };
}
function resetNoOfEmps() {
    document.getElementById("NoOfEmpIn").innerHTML = "0";
    document.getElementById("NoOfEmpOut").innerHTML = "0";
    document.getElementById("NoOfEmpOut").style.backgroundColor = "";
    document.getElementById("NoOfEmp").innerHTML = "0";
    document.getElementById("tatalReward").innerHTML = "0";
}
function getExecMM() {
    resetNoOfEmps();
    var bandCode = document.getElementById("bandCode").value;
    //var month = document.getElementById("month").value;
    //LocCode_Global
    //LocationCode_Global
    if (!(bandCode === "" || bandCode === null)) {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_3_getExecMm_AjaxServlet?";

        URL += "LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&bandCode=" + bandCode;

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
                    document.getElementById("month").innerHTML = message;
                    rewardStatus();
                }
            }
        };
    } else {
        document.getElementById("month").innerHTML = "";
        document.getElementById("EmpData").innerHTML = "";
        document.getElementById("searchEmpData").innerHTML = "";
        document.getElementById("searchEmpId").value = "";
        document.getElementById("rewardValue").value = "";
    }
}
//setInterval(rewardStatus, 10000);
function rewardStatus() {
    //resetNoOfEmps();
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;
    if (!(month === "" || month === null || bandCode === "" || bandCode === null)) {
        //LocCode_Global
        //LocationCode_Global
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_2_getRewardStatus_AjaxServlet?";

        URL += "LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&bandCode=" + bandCode;
        URL += "&month=" + month;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    defaultStatus("غير معروف");
                } else if (message === "جديد") {
                    insert_Update_delete = true;
                    greenStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"saveBtn\" type=\"button\" class=\"fa fa-save btn btn-primary\" onclick=\"Save();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> حفظ</button>";
                    document.getElementById("EmpData").innerHTML = "";
                    document.getElementById("searchEmpData").innerHTML = "";
                    document.getElementById("searchEmpId").value = "";
                    document.getElementById("rewardValue").value = "";
                    
                    document.getElementById("NoOfEmpIn").innerHTML = "0";
                    document.getElementById("NoOfEmpOut").innerHTML = "0";
                    document.getElementById("NoOfEmpOut").style.backgroundColor = "";
                    document.getElementById("NoOfEmp").innerHTML = "0";
                    document.getElementById("tatalReward").innerHTML = "0";
                    //document.getElementById("searchEmpId").focus();
                    sendBtnStatus("0");
                } else if (message.startsWith("مسجل")) {
                    insert_Update_delete = true;
                    orangeStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"updateBtn\" type=\"button\" class=\"fa fa-edit btn btn-primary\" onclick=\"Update();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> حفظ</button>";
                    getOldPayDeserveEmpFileDtl("1", "1");
                } else if (message.startsWith("مغلق")) {
                    insert_Update_delete = false;
                    redStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"updateBtn\" disabled=\"\" type=\"button\" class=\"fa fa-warning btn btn-primary\" onclick=\"Update();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> لا يوجد ما يتم حفظه</button>";
                    getOldPayDeserveEmpFileDtlReadOnly("1", "0");

                } else if (message.startsWith("جاري التنفيذ")) {
                    insert_Update_delete = false;
                    redStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"updateBtn\" disabled=\"\" type=\"button\" class=\"fa fa-warning btn btn-primary\" onclick=\"Update();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> لا يوجد ما يتم حفظه</button>";
                    getOldPayDeserveEmpFileDtlReadOnly("1", "0");

                } else if (message.startsWith("تم التنفيذ")) {
                    insert_Update_delete = false;
                    redStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"updateBtn\" disabled=\"\" type=\"button\" class=\"fa fa-warning btn btn-primary\" onclick=\"Update();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> لا يوجد ما يتم حفظه</button>";
                    getOldPayDeserveEmpFileDtlReadOnly("1", "0");

                } else if (message === "غير متاح") {
                    insert_Update_delete = false;
                    redStatus(message);
                    //document.getElementById("Btn").innerHTML = "<button id=\"updateBtn\" disabled=\"\" type=\"button\" class=\"fa fa-warning btn btn-primary\" onclick=\"Update();\" style=\"font-size: 30px;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;width: 100%;\"> لا يوجد ما يتم حفظه</button>";
                    sendBtnStatus("0");
                }
            }
        };
    } else {
        resetNoOfEmps();
    }
}
function getOldPayDeserveEmpFileDtl(AjaxType, sendBtnStatusVal) {
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;
    if (!(month === "" || month === null || bandCode === "" || bandCode === null)) {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_5_getOldPayDeserveEmpFileDtl_AjaxServlet?";

        URL += "LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&bandCode=" + bandCode;
        URL += "&month=" + month;
        URL += "&AjaxType=" + AjaxType;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    //document.getElementById("searchEmpData").innerHTML = "لا توجد بيانات موظف";
                } else if (message === "No Emp Dtl") {
                    Warning("لا يوجد موظفين مسجلين");
                    sendBtnStatus("0");
                    resetNoOfEmps();
                    document.getElementById("EmpData").innerHTML = "";
                } else {
                    if (AjaxType === "1") {
                        document.getElementById("EmpData").innerHTML = message;
                        //document.getElementById("searchEmpData").innerHTML = "";
                        //document.getElementById("searchEmpId").value = "";
                        //document.getElementById("rewardValue").value = "";
                        //document.getElementById("searchEmpId").focus();
                        setTimeout(getOldPayDeserveEmpFileDtl("2", ""), 500);
                    } else if (AjaxType === "2") {
                        var arr = message.split("-");
                        document.getElementById("NoOfEmp").innerHTML = arr[0];
                        document.getElementById("NoOfEmpIn").innerHTML = arr[1];
                        document.getElementById("NoOfEmpOut").innerHTML = arr[2];
                        document.getElementById("tatalReward").innerHTML = arr[3];
                        if (arr[2] > 0) {
                            document.getElementById("NoOfEmpOut").style.backgroundColor = "#ffbdbd";
                        } else {
                            document.getElementById("NoOfEmpOut").style.backgroundColor = "";
                        }
                    }
                    sendBtnStatus(sendBtnStatusVal);

                }
            }
        };
    }
}

function getOldPayDeserveEmpFileDtlReadOnly(AjaxType, sendBtnStatusVal) {
    insert_Update_delete = false;
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;
    if (!(month === "" || month === null || bandCode === "" || bandCode === null)) {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_5_getOldPayDeserveEmpFileDtlReadOnly_AjaxServlet?";

        URL += "LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&bandCode=" + bandCode;
        URL += "&month=" + month;
        URL += "&AjaxType=" + AjaxType;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    //document.getElementById("searchEmpData").innerHTML = "لا توجد بيانات موظف";
                } else if (message === "No Emp Dtl") {
                    Warning("لا يوجد موظفين مسجلين");
                    sendBtnStatus("0");
                    resetNoOfEmps();
                    document.getElementById("EmpData").innerHTML = "";
                } else {
                    if (AjaxType === "1") {
                        document.getElementById("EmpData").innerHTML = message;
                        document.getElementById("searchEmpData").innerHTML = "";
                        document.getElementById("searchEmpId").value = "";
                        document.getElementById("rewardValue").value = "";
                        document.getElementById("searchEmpId").focus();
                        setTimeout(getOldPayDeserveEmpFileDtlReadOnly("2", "0"), 500);
                    } else if (AjaxType === "2") {
                        var arr = message.split("-");
                        document.getElementById("NoOfEmp").innerHTML = arr[0];
                        document.getElementById("NoOfEmpIn").innerHTML = arr[1];
                        document.getElementById("NoOfEmpOut").innerHTML = arr[2];
                        document.getElementById("tatalReward").innerHTML = arr[3];
                        if (arr[2] > 0) {
                            document.getElementById("NoOfEmpOut").style.backgroundColor = "#ffbdbd";
                        } else {
                            document.getElementById("NoOfEmpOut").style.backgroundColor = "";
                        }
                    }
                    sendBtnStatus(sendBtnStatusVal);
                }
            }
        };
    }
}
function Save() {
    var Status = true;
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;
    //LocCode_Global
    //LocationCode_Global
    var url = "";
    var empIds = document.getElementsByName("empIds");
    for (var i = 0; i < empIds.length; ) {
        if (empIds[i].value === "" || empIds[i].value === null) {
            Status = false;
            break;
        } else {
            url += "empIds=" + empIds[i].value + "&";
            i = i + 1;
        }
    }
    var rewardValues = document.getElementsByName("rewardValues");
    for (var i = 0; i < rewardValues.length; ) {
        if (rewardValues[i].value === "" || rewardValues[i].value === null) {
            Status = false;
            break;
        } else {
            if (i < rewardValues.length - 1) {
                url += "rewardValues=" + rewardValues[i].value + "&";
            } else {
                url += "rewardValues=" + rewardValues[i].value;
            }
            i = i + 1;
        }
    }

    if (Status === true) {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_4_saveTo_AjaxServlet?";

        URL += "LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&bandCode=" + bandCode;
        URL += "&month=" + month;
        URL += "&" + url;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {

                    Error("حدث خطأ");
                } else if (message === "حالة البيان مغلقة وغير قابلة للتعديل") {
                    Warning(message);
                    getOldPayDeserveEmpFileDtlReadOnly("1", "");
                } else if (message === "الموظف مسجل بالقرار من قبل") {
                    Warning(message);
                    setTimeout(rewardStatus(), 500);
                } else {
                    Success("تمت الحفظ بنجاح");
                    setTimeout(rewardStatus(), 500);
                }
            }
        };
    } else {
        Warning("برجاء التأكد من أنا كل الجدول ممتلئ بشكل صحيح");
    }

}
/*function Update() {
 var Status = true;
 var bandCode = document.getElementById("bandCode").value;
 var month = document.getElementById("month").value;
 //LocCode_Global
 //LocationCode_Global
 var url = "";
 var empIds = document.getElementsByName("empIds");
 for (var i = 0; i < empIds.length; ) {
 if (empIds[i].value === "" || empIds[i].value === null) {
 Status = false;
 break;
 } else {
 url += "empIds=" + empIds[i].value + "&";
 i = i + 1;
 }
 }
 var rewardValues = document.getElementsByName("rewardValues");
 for (var i = 0; i < rewardValues.length; ) {
 if (rewardValues[i].value === "" || rewardValues[i].value === null) {
 Status = false;
 break;
 } else {
 if (i < rewardValues.length - 1) {
 url += "rewardValues=" + rewardValues[i].value + "&";
 } else {
 url += "rewardValues=" + rewardValues[i].value;
 }
 i = i + 1;
 }
 }
 
 if (Status === true) {
 var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_4_saveTo_AjaxServlet?";
 
 URL += "LocCode=" + LocCode_Global;
 URL += "&LocationCode=" + LocationCode_Global;
 URL += "&bandCode=" + bandCode;
 URL += "&month=" + month;
 URL += "&" + url;
 
 var xhttp = new XMLHttpRequest();
 xhttp.open("POST", URL, true);
 
 xhttp.send();
 
 xhttp.onreadystatechange = function () {
 if (xhttp.readyState === 4 && xhttp.status === 200) {
 var message = xhttp.responseText;
 if (message === "Error") {
 Error("حدث خطأ");
 } else {
 Success("تمت الحفظ بنجاح");
 resetPage();
 }
 }
 };
 } else {
 Warning("برجاء التأكد من أنا كل الجدول ممتلئ بشكل صحيح");
 }
 }*/
function Delete(accessSpID, rowId) {
    var Confirm = confirm("هل أنت متأكد من إتمام عملية الحذف تلك");
    if (Confirm === true) {
        if (accessSpID === "*") {
            deleteTableRow(rowId);
            Success("تمت عملية الحذف");
            setTimeout(getOldPayDeserveEmpFileDtl("2", "1"), 500);
        } else {
            var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_6_deleteFrom_AjaxServlet?";
            URL += "accessSpID=" + accessSpID;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        Error("حدث خطأ");
                    } else {
                        deleteTableRow(rowId);
                        Success("تمت عملية الحذف");
                        setTimeout(getOldPayDeserveEmpFileDtl("2", "1"), 500);
                    }
                }
            };
        }
    }
}
function deleteTableRow(rowId) {
    var empRows = document.getElementsByClassName("E_" + rowId);
    for (var i = 0; i < empRows.length; ) {
        empRows[i].innerHTML = "";
        i++;
    }

}
var Status = false;
function setSendButtonAuth(auth) {
    if (auth === "1") {
        Status = true;
    }
}
function sendBtnStatus(status) {
    if (Status) {
        if (status === "1") {
            /**
             * check if there is details
             */
            var detail_Existance = false;
            try {
                var empIds = document.getElementsByClassName("empIdsClass");//فالجدول اللي هييجي من الأجاكس

                if (empIds.length > 0) {
                    detail_Existance = true;
                } else {
                    detail_Existance = false;
                }
            } catch (err) {
                detail_Existance = false;
            }
            if (detail_Existance === true) {
                document.getElementById("SendBTNDiv").innerHTML = "<button type=\"button\" class=\"fa fa-send btn btn-default\" onclick=\"SendReward();\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: 7px 8px 11px black;\"> إرسال</button>";
            } else {
                document.getElementById("SendBTNDiv").innerHTML = "";
            }
        } else if (status === "0") {
            document.getElementById("SendBTNDiv").innerHTML = "";
        }
    }
}
function SendReward() {
    var Confirm = confirm("هل أنت متأكد من إتمام عملية الإرسال تلك؟");
    if (Confirm === true) {
        var bandCode = document.getElementById("bandCode").value;
        var month = document.getElementById("month").value;
        /*var LocCode = Loc;
         var LocationCode = LocationCode;*/

        if (Status === true) {
            var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_8_sendTo_AjaxServlet?";

            URL += "LocCode=" + LocCode_Global;
            URL += "&LocationCode=" + LocationCode_Global;
            URL += "&bandCode=" + bandCode;
            URL += "&month=" + month;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        Error("حدث خطأ");
                    } else {
                        Success(message);
                        setTimeout(rewardStatus(), 500);
                    }
                }
            };
        } else {
            Warning("ليس لديك صلاحية الإرسال");
        }
    }
}

function resetPage() {
    defaultStatus("غير معروف");
    document.getElementById("bandCode").value = "";
    document.getElementById("month").innerHTML = "";
    document.getElementById("EmpData").innerHTML = "";
    //document.getElementById("Btn").innerHTML = "";
}
function redStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: red;\"></strong><strong style=\"color: red;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}
function greenStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #26b99a;\"></strong><strong style=\"color: #26b99a;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}
defaultStatus("غير معروف");
function defaultStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;\"></strong><strong>" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}
function orangeStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: orange;\"></strong><strong style=\"color: orange;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
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