/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var QueryTypeAvailable = false;
var ReffusedTypeAvailable = false;
function getQueryTypeAvailable(status) {
    QueryTypeAvailable = status;
}
function getReffusedTypeAvailable(status) {
    ReffusedTypeAvailable = status;
}
var LocCode_Global = "";
var LocationCode_Global = "";
function setLocationCode(LocationCode) {
    LocationCode_Global = LocationCode;
}
function setLocCode(LocCode) {
    var SearchType;
    try {
        SearchType = document.getElementById("SearchType").value;
    } catch (err) {
        SearchType = "2";
    }
    var LocCodeCombo = document.getElementById("LocCodeCombo").value;
    if (SearchType === "1" && (LocCodeCombo !== "" || LocCodeCombo !== null)) {
        LocCode_Global = LocCodeCombo;
    } else if (SearchType === "2") {
        LocCode_Global = LocCode;
        getBandCode();
    }

}


function searchTypeSelect() {
    var SearchType = document.getElementById("SearchType").value;
    document.getElementById("LocCodeCombo").value = "";
    document.getElementById("month").innerHTML = "";
    if (SearchType === "1") {
        document.getElementById("LocCodeComboDiv").style.display = "block";
    } else if (SearchType === "2") {
        document.getElementById("LocCodeComboDiv").style.display = "none";
    } else {
        document.getElementById("LocCodeComboDiv").style.display = "none";
    }
}

function getBandCode() {
    document.getElementById("bandCode").innerHTML = "";
    document.getElementById("month").innerHTML = "";
    var URL = "_0_0_0_4_5_2_Employees_Rewards_Query_Ajax_1_getBandCodeByLocation_AjaxServlet?";

    URL += "LocCode=" + LocCode_Global;
    URL += "&LocationCode=" + LocationCode_Global;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("حدث خطأ");
            } else {
                document.getElementById("bandCode").innerHTML = "<option value=\"\">اختر المكافأة ....</option>" + message;
            }
        }
    };
}

function getExecMM() {
    var bandCode = document.getElementById("bandCode").value;
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
                } else {
                    document.getElementById("month").innerHTML = "<option value=''> اختر الشهر ....</option>" + message;
                    rewardStatus();
                }
            }
        };
    } else {
        document.getElementById("month").innerHTML = "";
    }
}

function searchResult() {
    var SearchType;
    try {
        SearchType = document.getElementById("SearchType").value;
    } catch (err) {
        SearchType = "2";
    }
    var LocCodeCombo = document.getElementById("LocCodeCombo").value;
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;

    var queryType = "";
    var rejects = "";
    var donCareQueryType = true;
    var donCareRejects = true;
    try {
        queryType = document.getElementById("queryType").value;
        donCareQueryType = false;
    } catch (err) {
        queryType = "BeforeSend";
        donCareQueryType = true;
    }
    try {
        rejects = document.getElementById("rejects").value;
        donCareRejects = false;
    } catch (err) {
        rejects = "NoRejects";
        donCareRejects = true;
    }

    if (SearchType === "" || SearchType === null) {
        Warning("من فضلك اختر نوع الاستعلام");
    } else if ((LocCodeCombo === "" || LocCodeCombo === null) && SearchType === "1") {
        Warning("من فضلك اختر الموقع");
    } else if (bandCode === "" || bandCode === null) {
        Warning("من فضلك اختر نوع المكافأة");
    } else if (month === "" || month === null) {
        Warning("من فضلك اختر الشهر");
    } else if (donCareQueryType === false && (queryType === "" || queryType === null)) {
        Warning("من فضلك اختر نوع البحث");
    } else if (donCareRejects === false && (rejects === "" || rejects === null)) {
        Warning("من فضلك اختر المرفوضات");
    } else {
        var URL = "_0_0_0_4_5_2_Employees_Rewards_Query_Ajax_2_getSearchResult_AjaxServlet?";
        URL += "&SearchType=" + SearchType;
        URL += "&LocCode=" + LocCode_Global;
        URL += "&LocationCode=" + LocationCode_Global;
        URL += "&LocCodeCombo=" + LocCodeCombo;
        URL += "&bandCode=" + bandCode;
        URL += "&month=" + month;
        URL += "&queryType=" + queryType;
        URL += "&rejects=" + rejects;

        var locationColStatus = document.getElementById("locationColStatus").checked;
        URL += "&locationColStatus=" + locationColStatus;

        var rewardDateTimeColStatus = document.getElementById("rewardDateTimeColStatus").checked;
        URL += "&rewardDateTimeColStatus=" + rewardDateTimeColStatus;
        if (rewardDateTimeColStatus) {
            var dateTimeReview = document.getElementById("dateTimeReview").value;
            URL += "&dateTimeReview=" + dateTimeReview;
        } else {
            URL += "&dateTimeReview=DateOnly";
        }

        var empRewardDateTimeColStatus = document.getElementById("empRewardDateTimeColStatus").checked;
        URL += "&empRewardDateTimeColStatus=" + empRewardDateTimeColStatus;
        if (empRewardDateTimeColStatus) {
            var dateTimeEmpReview = document.getElementById("dateTimeEmpReview").value;
            URL += "&dateTimeEmpReview=" + dateTimeEmpReview;
        } else {
            URL += "&dateTimeEmpReview=DateOnly";
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("PrintBtnDiv").innerHTML = "";
                } else {
                    if (rejects === "NoRejects" || rejects === "OnlyRejects") {
                        showReviewBTN();
                    } else if (rejects === "AddRejects") {
                        showReviewBTN_NotActive();
                    }

                    document.getElementById("PayDeserveEmpFileDtl").innerHTML = message;
                    //"<button type=\"button\" data-placement=\"top\" onclick=\"Save();\" id=\"SaveBtn\" class=\" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-save\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;display: block;\"> حفظ</button>"

                    //rewardStatus();
                }
            }
        };
    }
}

function rewardStatus() {
    document.getElementById("PayDeserveEmpFileDtl").innerHTML = "";
    document.getElementById("PrintBtnDiv").innerHTML = "";

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
                    document.getElementById("SearchBTN").innerHTML = "";
                } else if (message === "جديد") {
                    greenStatus("غير مسجل");
                    document.getElementById("QueryTypeDiv").innerHTML = "";
                    document.getElementById("SearchBTN").innerHTML = "";
                } else if (message.startsWith("مسجل")) {
                    orangeStatus(message);
                    document.getElementById("QueryTypeDiv").innerHTML = "";
                    showSearchBTN();
                } else if (message.startsWith("مغلق")) {
                    redStatus(message + " و تم إرسالها للمراجعة");
                    showSearchBTN();
                } else if (message.startsWith("جاري التنفيذ")) {
                    primaryStatus(message);
                    document.getElementById("QueryTypeDiv").innerHTML = "";
                    document.getElementById("SearchBTN").innerHTML = "";
                } else if (message.startsWith("تم التنفيذ")) {
                    successStatus(message);
                    SearchTypeCombo();
                    showSearchBTN();
                } else if (message === "غير متاح") {
                    redStatus(message);
                    document.getElementById("QueryTypeDiv").innerHTML = "";
                    document.getElementById("SearchBTN").innerHTML = "";
                }
            }
        };
    } else {
        //defaultStatus("غير معروف");
        document.getElementById("statusDiv").innerHTML = "";
    }
}

function showSearchBTN() {
    document.getElementById("SearchBTN").innerHTML = "<button type=\"button\" data-placement=\"top\" onclick=\"searchResult();\" class=\"button_style btn btn-sm btn-primary button_position fa fa-search\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;\" data-toggle=\"modal\" data-target=\"#x\"> إستعلام</button>\n"
            + "                                <br>";
}

function showReviewBTN() {
    document.getElementById("PrintBtnDiv").innerHTML = "<button type=\"button\" data-placement=\"top\" onclick=\"ReviewPrint();\" id=\"PrintBtn\" class=\" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-eye\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;\"></button> ";
}

function showReviewBTN_NotActive(){
    document.getElementById("PrintBtnDiv").innerHTML = "<button type=\"button\" data-placement=\"top\" disabled='' id=\"PrintBtn\" class=\" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-eye\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;\"></button> ";
}

function SearchTypeCombo() {
    if (QueryTypeAvailable) {
        showQueryTypeDiv();
    }
    if (ReffusedTypeAvailable) {
        showReffusedTypeDiv();
    }
}

setInterval(checkStatus, 200);
function checkStatus() {
    checkDateTimeReviewDiv();
    checkdateTimeEmpReviewDiv();
}

function checkDateTimeReviewDiv() {
    var rewardDateTimeColStatus = document.getElementById("rewardDateTimeColStatus").checked;
    if (rewardDateTimeColStatus) {
        document.getElementById("dateTimeReviewDiv").style.display = "block";
    } else {
        document.getElementById("dateTimeReviewDiv").style.display = "none";
    }
}

function checkdateTimeEmpReviewDiv() {
    var empRewardDateTimeColStatus = document.getElementById("empRewardDateTimeColStatus").checked;
    if (empRewardDateTimeColStatus) {
        document.getElementById("dateTimeEmpReviewDiv").style.display = "block";
    } else {
        document.getElementById("dateTimeEmpReviewDiv").style.display = "none";
    }
}

function showQueryTypeDiv() {
    document.getElementById("QueryTypeDiv").innerHTML = "<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n" +
            "                                    <label class=\"control-label\" style=\"font-size: 20px;\"> نوع البحث</label>\n" +
            "                                    <select style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\"نوع الإستعلام\"  id=\"queryType\" maxlength=\"45\" name=\"queryType\" class=\"form-control\" required=\"\">\n" +
            "                                        <option value=\"\" style=\"font-size: 15px;font-weight: bold;\">اختر نوع البحث ..</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" selected=\"\" value=\"All\">الكل</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"BeforeSend\">قبل الإرسال</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"AfterSend\">بعد الإرسال</option>\n" +
            "                                    </select>\n" +
            "                                </div>\n";
}

function showReffusedTypeDiv() {
    document.getElementById("ReffusedTypeDiv").innerHTML = "<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n" +
            "                                    <label class=\"control-label\" style=\"font-size: 20px;\"> المرفوضات</label>\n" +
            "                                    <select style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\"نوع الإستعلام\"  id=\"rejects\" maxlength=\"45\" name=\"rejects\" class=\"form-control\" required=\"\">\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"AddRejects\">ضم المرفوضات</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"NoRejects\" selected >بدون المرفوضات</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"OnlyRejects\" >المرفوضات فقط</option>\n" +
            "                                    </select>\n" +
            "                                </div>";
}
function ReviewPrint() {
    var SearchType;
    try {
        SearchType = document.getElementById("SearchType").value;
    } catch (err) {
        SearchType = "2";
    }
    var LocCodeCombo = document.getElementById("LocCodeCombo").value;
    var bandCode = document.getElementById("bandCode").value;
    var month = document.getElementById("month").value;

    var queryType = "";
    var rejects = "";
    try {
        queryType = document.getElementById("queryType").value;
    } catch (err) {
        queryType = "BeforeSend";
    }
    try {
        rejects = document.getElementById("rejects").value;
    } catch (err) {
        rejects = "NoRejects";
    }
    var URL = "_0_0_0_4_5_2_Employees_Rewards_Query_print_AccessServlet?";
    URL += "&SearchType=" + SearchType;
    URL += "&LocCode=" + LocCode_Global;
    URL += "&LocationCode=" + LocationCode_Global;
    URL += "&LocCodeCombo=" + LocCodeCombo;
    URL += "&bandCode=" + bandCode;
    URL += "&month=" + month;
    URL += "&queryType=" + queryType;
    URL += "&rejects=" + rejects;

    var locationColStatus = document.getElementById("locationColStatus").checked;
    URL += "&locationColStatus=" + locationColStatus;

    var rewardDateTimeColStatus = document.getElementById("rewardDateTimeColStatus").checked;
    URL += "&rewardDateTimeColStatus=" + rewardDateTimeColStatus;
    if (rewardDateTimeColStatus) {
        var dateTimeReview = document.getElementById("dateTimeReview").value;
        URL += "&dateTimeReview=" + dateTimeReview;
    } else {
        URL += "&dateTimeReview=DateOnly";
    }

    var empRewardDateTimeColStatus = document.getElementById("empRewardDateTimeColStatus").checked;
    URL += "&empRewardDateTimeColStatus=" + empRewardDateTimeColStatus;
    if (empRewardDateTimeColStatus) {
        var dateTimeEmpReview = document.getElementById("dateTimeEmpReview").value;
        URL += "&dateTimeEmpReview=" + dateTimeEmpReview;
    } else {
        URL += "&dateTimeEmpReview=DateOnly";
    }
    var win = window.open(URL, "Title", "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=1200,height=500, top=100, left=100");
    win.document.body.innerHTML = "HTML";
}

function redStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: red;\"></strong><strong style=\"color: red;font-size: 25px;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}

function primaryStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #78c1ff;\"></strong><strong style=\"color: #78c1ff;font-size: 25px;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}

function greenStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #26b99a;\"></strong><strong style=\"color: #26b99a;font-size: 25px;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}

function successStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: #14bd00;\"></strong><strong style=\"color: #14bd00;font-size: 25px;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}

function defaultStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;\"></strong><strong style=\"font-size: 25px;\">" + word + "</strong>";
    document.getElementById("statusDiv").innerHTML = status;
}

function orangeStatus(word) {
    var status = "الحالة :<strong class=\"fa fa-lightbulb-o\" style=\"font-size: 40px;color: orange;\"></strong><strong style=\"color: orange;font-size: 25px;\">" + word + "</strong>";
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