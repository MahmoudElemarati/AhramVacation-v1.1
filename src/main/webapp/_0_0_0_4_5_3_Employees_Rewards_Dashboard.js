/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var status = 'f';
setInterval(init, 500);
function init() {
    LOC_ONLY_Search_Btn();
    //queryLoad();
}
function LOC_ONLY_Search_Btn() {
    if (BandTableArr.length > 0) {
        document.getElementById("searchResultByLoc").disabled = true;
    } else {
        document.getElementById("searchResultByLoc").disabled = false;
    }
}
var QueryTypeAvailable = false;
var ReffusedTypeAvailable = false;
var PartAvailable = false;
var DetailTypeAvailable = false;
function getQueryTypeAvailable(status) {
    QueryTypeAvailable = status;
}
function getReffusedTypeAvailable(status) {
    ReffusedTypeAvailable = status;
}
function getPartAvailable(status) {
    PartAvailable = status;
}
function getDetailTypeAvailable(status) {
    DetailTypeAvailable = status;
}
var LocCode_Global = "";
var LocName_Global = "";
var LocationCode_Global = "";
function setLocationCode(LocationCode) {
    LocationCode_Global = LocationCode;
}
function setLocCode(LocCode, LocName) {
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
        addHtmlLocTable(LocCode, LocName, 'NoDelete');
    }

}


function searchTypeSelect() {
    var SearchType = document.getElementById("SearchType").value;
    document.getElementById("LocCodeCombo").value = "";
    if (SearchType === "1") {
        document.getElementById("LocCodeComboDiv").style.display = "block";
    } else if (SearchType === "2") {
        document.getElementById("LocCodeComboDiv").style.display = "none";
    } else {
        document.getElementById("LocCodeComboDiv").style.display = "none";
    }
}


function showSearchBTN() {
    document.getElementById("SearchBTN").innerHTML = "<button type=\"button\" data-placement=\"top\" onclick=\"searchResult();\" class=\"button_style btn btn-sm btn-primary button_position fa fa-search\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;\" data-toggle=\"modal\" data-target=\"#x\"> إستعلام</button>\n"
            + "                                <br>";
}

function SearchTypeCombo() {
    if (ReffusedTypeAvailable) {
        showReffusedTypeDiv();
    }
    if (PartAvailable) {
        showPartsDiv();
    }
    if (DetailTypeAvailable) {
        showDetailTypeDiv();
    }
}

var LocTableArr = [];
function addAllLocToTable() {
    clearHtmlLocTable();
    $("#LocCodeCombo option").each(function ()
    {
        // Add $(this).val() to your list
        var value = $(this).val();
        var name = $(this).text();
        if (!(value === "" || value === null || value === "All")) {
            addHtmlLocTable(value, name, "yesDelete");
        }
    });
}
function addLocToTable() {
    var LocCodeCombo = document.getElementById("LocCodeCombo");
    var LocCodeComboValue = LocCodeCombo.value;
    if (LocCodeComboValue === "" || LocCodeComboValue === null) {
        Warning("اختر موقع");
    } else {
        var index = LocTableArr.indexOf(LocCodeComboValue);
        if (index === -1) {
            var LocCodeComboName = LocCodeCombo.options[LocCodeCombo.selectedIndex].text;
            if (!(LocCodeComboValue === "" || LocCodeComboValue === null || LocCodeComboValue === "All")) {
                addHtmlLocTable(LocCodeComboValue, LocCodeComboName, "yesDelete");
            }
            LocCodeCombo.value = "";
        } else {
            Warning("هذا الموقع مختار من قبل");
        }
    }
}
function addHtmlLocTable(LocCodeComboValue, LocCodeComboName, DeleteOption) {
    var Html_table_row = "";
    if (LocTableArr.length === 0 && DeleteOption !== "NoDelete") {
        Html_table_row += "<tr>"
                + "<td colspan=\"2\" style=\"text-align: center;\"><button onclick=\"clearHtmlLocTable();\" class=\"btn btn-sm btn-default custom_delete_btn\" type=\"button\" data-placement=\"top\" data-toggle=\"tooltip\" data-original-title=\"Trash\"><i class=\"fa fa-trash-o\"> الغاء كل المواقع</i></button></td>"
                + "</tr>";
    }
    Html_table_row += "<tr>"
            + " <td class='BandDashId'>" + LocCodeComboValue + "</td>"
            + " <td>" + LocCodeComboName + "</td>";
    if (DeleteOption !== 'NoDelete') {
        Html_table_row += " <td><button onclick=\"deleteLocTableRow('" + LocCodeComboValue + "');\" class=\"btn btn-sm btn-default custom_delete_btn\" type=\"button\" data-placement=\"top\" data-toggle=\"tooltip\" data-original-title=\"Trash\"><i class=\"fa fa-trash-o\"></i></button></td>";
    }
    Html_table_row += "</tr>";
    document.getElementById("locationsTable").innerHTML += Html_table_row;
    LocTableArr.push(LocCodeComboValue);
}
function clearHtmlLocTable() {
    LocTableArr = [];
    document.getElementById("locationsTable").innerHTML = "";
}
function deleteLocTableRow(LocId) {

    var index = LocTableArr.indexOf(LocId);
    if (index > -1) {
        LocTableArr.splice(index, 1);
        document.getElementById('locationsTable').deleteRow(index + 1);
    }
    if (LocTableArr.length === 0) {
        clearHtmlLocTable();
    }
}


var BandTableArr = [];
function addAllBandToTable() {
    clearHtmlBandTable();
    $("#bandCode option").each(function ()
    {
        // Add $(this).val() to your list
        var value = $(this).val();
        var name = $(this).text();
        if (!(value === "" || value === null || value === "All")) {
            addHtmlBandTable(value, name, "yesDelete");
        }
    });
}
function addBandToTable() {
    var bandCode = document.getElementById("bandCode");
    var bandCodeValue = bandCode.value;
    if (bandCodeValue === "" || bandCodeValue === null) {
        Warning("اختر المكافأة");
    } else {
        var index = BandTableArr.indexOf(bandCodeValue);
        if (index === -1) {
            var bandCodeName = bandCode.options[bandCode.selectedIndex].text;
            if (!(bandCodeValue === "" || bandCodeValue === null || bandCodeValue === "All")) {
                addHtmlBandTable(bandCodeValue, bandCodeName);
            }
            bandCode.value = "";
        } else {
            Warning("هذه المكافأة مختاره من قبل");
        }
    }
}
function addHtmlBandTable(bandCodeValue, bandCodeName) {
    var Html_table_row = "";
    if (BandTableArr.length === 0) {
        Html_table_row += "<tr>"
                + "<td colspan=\"2\" style=\"text-align: center;\"><button onclick=\"clearHtmlBandTable();\" class=\"btn btn-sm btn-default custom_delete_btn\" type=\"button\" data-placement=\"top\" data-toggle=\"tooltip\" data-original-title=\"Trash\"><i class=\"fa fa-trash-o\"> الغاء كل المكافآت</i></button></td>"
                + "</tr>";
    }
    Html_table_row += "<tr>"
            + " <td class='BandDashId'>" + bandCodeValue + "</td>"
            + " <td>" + bandCodeName + "</td>"
            + " <td><button onclick=\"deleteBandTableRow('" + bandCodeValue + "');\" class=\"btn btn-sm btn-default custom_delete_btn\" type=\"button\" data-placement=\"top\" data-toggle=\"tooltip\" data-original-title=\"Trash\"><i class=\"fa fa-trash-o\"></i></button></td>"
            + "</tr>";
    document.getElementById("BandsTable").innerHTML += Html_table_row;
    BandTableArr.push(bandCodeValue);
}
function clearHtmlBandTable() {
    BandTableArr = [];
    document.getElementById("BandsTable").innerHTML = "";
}

function deleteBandTableRow(BandId) {
    var index = BandTableArr.indexOf(BandId);
    if (index > -1) {
        BandTableArr.splice(index, 1);
        document.getElementById('BandsTable').deleteRow(index + 1);
    }
    if (BandTableArr.length === 0) {
        clearHtmlBandTable();
    }
}

function showReffusedTypeDiv() {
    document.getElementById("ReffusedTypeDiv").innerHTML = "<div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n" +
            "                                    <label class=\"control-label\" style=\"font-size: 15px;\"> المرفوضات</label>\n" +
            "                                    <select style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\"نوع الإستعلام\"  id=\"rejects\" maxlength=\"45\" name=\"rejects\" class=\"form-control\" required=\"\">\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"AddRejects\">ضم المرفوضات</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"NoRejects\" selected >بدون المرفوضات</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"OnlyRejects\" >المرفوضات فقط</option>\n" +
            "                                    </select>\n" +
            "                                </div>";
}

function showPartsDiv() {
    document.getElementById("PartDiv").innerHTML = "<div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n" +
            "                                    <label class=\"control-label\" style=\"font-size: 15px;\"> تفاصيل المكافأة</label>\n" +
            "                                    <select style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\"تفاصيل المكافأة\"  id=\"parts\" maxlength=\"45\" name=\"rejects\" class=\"form-control\" required=\"\">\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"AllowPart\">إظهار تفاصيل المكافأة</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"NoAllowPart\" selected >إخفاء التفاصيل</option>\n" +
            "                                    </select>\n" +
            "                                </div>";
}
function showDetailTypeDiv() {
    document.getElementById("DetailTypeDiv").innerHTML = "<div class=\"col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n" +
            "                                    <label class=\"control-label\" style=\"font-size: 20px;\"> تفاصيل المكافآت</label>\n" +
            "                                    <select style=\"font-size: 15px;font-weight: bold;\" type=\"text\" placeholder=\"نوع الإستعلام\"  id=\"detailType\" maxlength=\"45\" name=\"rejects\" class=\"form-control\" required=\"\">\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"AllowDetails\">إظهار تفاصيل المكافآت بكل إدارة</option>\n" +
            "                                        <option style=\"font-size: 15px;font-weight: bold;\" value=\"NoDetails\" selected >عدم إظهار تفاصيل المكافآت بكل إدارة</option>\n" +
            "                                    </select>\n" +
            "                                </div>";
}

/////////////////////////////////////////////////////////////////////////////////////

//Loc Array name >> LocTableArr
/*function searchResultByLoc() {
 document.getElementById("PrintBtn").disabled = true;
 clearTableResult();
 var date_range = document.getElementById("date_range").innerHTML;
 var date_range_arr = date_range.split(" | ");
 var date_from = date_range_arr[0];
 var date_to = date_range_arr[1];
 if (LocTableArr.length === 0) {
 Warning("برجاء اختيار موقع على الأقل");
 } else {
 
 status = 't';
 var parts;
 try {
 parts = document.getElementById("parts").value;
 } catch (err) {
 parts = "NoAllowParts";
 }
 var rejects;
 try {
 rejects = document.getElementById("rejects").value;
 } catch (err) {
 rejects = "NoRejects";
 }
 
 var detailType;
 try {
 detailType = document.getElementById("detailType").value;
 } catch (err) {
 detailType = "NoDetails";
 }
 
 
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
 }*/

//band Array name >> BandTableArr
/*function searchResultByBand() {
 document.getElementById("PrintBtn").disabled = true;
 clearTableResult();
 var date_range = document.getElementById("date_range").innerHTML;
 var date_range_arr = date_range.split(" | ");
 var date_from = date_range_arr[0];
 var date_to = date_range_arr[1];
 if (LocTableArr.length === 0) {
 Warning("برجاء اختيار موقع على الأقل");
 } else if (BandTableArr.length === 0) {
 Warning("برجاء اختيار مكافأة على الأقل");
 } else {
 
 status = 't';
 var parts;
 try {
 parts = document.getElementById("parts").value;
 } catch (err) {
 parts = "NoAllowParts";
 }
 var rejects;
 try {
 rejects = document.getElementById("rejects").value;
 } catch (err) {
 rejects = "NoRejects";
 }
 
 var detailType;
 try {
 detailType = document.getElementById("detailType").value;
 } catch (err) {
 detailType = "NoDetails";
 }
 
 
 
 
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
 }*/
function setTableDesviption() {
    var date_range = document.getElementById("date_range").innerHTML;
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


function init_daterangepicker() {

    if (typeof ($.fn.daterangepicker) === 'undefined') {
        return;
    }
    console.log('init_daterangepicker');
    var cb = function (start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
        $('#reportrange_FullDashBoard_1 span').html(start.format('YYYY-MM') + ' | ' + end.format('YYYY-MM'));
    };
    var optionSet1 = {
        startDate: moment().subtract(29, 'days'),
        endDate: moment(),
        minDate: '01/01/2018',
        maxDate: new Date(),
        alwaysShowCalendars: true,
        showDropdowns: true,
        showWeekNumbers: false,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: false,
        ranges: {
            'اليوم': [moment(), moment()],
            'الأمس': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'آخر سبعة أيام': [moment().subtract(6, 'days'), moment()],
            'آخر ثلاثون يوما': [moment().subtract(29, 'days'), moment()],
            'الشهر الحالي': [moment().startOf('month'), moment().endOf('month')],
            'آخر شهر': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        opens: 'left',
        buttonClasses: ['btn btn-default'],
        applyClass: 'btn-small btn-primary',
        cancelClass: 'btn-small',
        format: 'YYYY-MM',
        separator: ' to ',
        locale: {
            applyLabel: 'Submit',
            cancelLabel: 'Clear',
            fromLabel: 'From',
            toLabel: 'To',
            customRangeLabel: 'خاص',
            daysOfWeek: ['أحد', 'إثنين', 'ثلاثاء', 'أربعاء', 'خميس', 'جمعة', 'سبت'],
            monthNames: ['يناير', 'فبراير', 'مارس', 'أبريل', 'مايو', 'يونيو', 'يوليو', 'اغسطس', 'سيبتمبر', 'أكتوبر', 'نوفمبر', 'ديسمبر'],
            firstDay: 1
        }
    };
    $('#reportrange_FullDashBoard_1 span').html(moment().subtract(29, 'days').format('YYYY-MM') + ' | ' + moment().format('YYYY-MM'));
    $('#reportrange_FullDashBoard_1').daterangepicker(optionSet1, cb);
    $('#reportrange_FullDashBoard_1').on('show.daterangepicker', function () {
        console.log("show event fired");
    });
    $('#reportrange_FullDashBoard_1').on('hide.daterangepicker', function () {
        console.log("hide event fired");
    });
    $('#reportrange_FullDashBoard_1').on('apply.daterangepicker', function (ev, picker) {
        console.log("apply event fired, start/end dates are " + picker.startDate.format('YYYY-MM') + " to " + picker.endDate.format('YYYY-MM'));
    });
    $('#reportrange_FullDashBoard_1').on('cancel.daterangepicker', function (ev, picker) {
        console.log("cancel event fired");
    });
    $('#options1').click(function () {
        $('#reportrange_FullDashBoard_1').data('daterangepicker').setOptions(optionSet1, cb);
    });
    $('#options2').click(function () {
        $('#reportrange_FullDashBoard_1').data('daterangepicker').setOptions(optionSet2, cb);
    });
    $('#destroy').click(function () {
        $('#reportrange_FullDashBoard_1').data('daterangepicker').remove();
    });
}

var x_part_type_Arr = [];
x_part_type_Arr.push("<option value='daily' style='font-size: 15px;font-weight: bold;'>يومي</option>");
x_part_type_Arr.push("<option value='monthly' style='font-size: 15px;font-weight: bold;'>شهري</option>");
x_part_type_Arr.push("<option value='yearly' style='font-size: 15px;font-weight: bold;'>سنوي</option>");
function IntervalTimeTypeFunction() {

    var IntervalTimeType = document.getElementById("IntervalTimeType").value;
    var x_part_type = document.getElementById("x_part_type");
    var YearDiv = document.getElementById("YearDiv");
    var MonthDiv = document.getElementById("MonthDiv");
    var CustomIntervalDiv = document.getElementById("CustomIntervalDiv");
    if (IntervalTimeType === "year") {
        x_part_type.innerHTML = x_part_type_Arr[0];
        x_part_type.innerHTML += x_part_type_Arr[1];
        YearDiv.style.display = "block";
        MonthDiv.style.display = "none";
        CustomIntervalDiv.style.display = "none";
    } else if (IntervalTimeType === "month") {
        x_part_type.innerHTML = x_part_type_Arr[0];
        YearDiv.style.display = "block";
        MonthDiv.style.display = "block";
        CustomIntervalDiv.style.display = "none";
    } else if (IntervalTimeType === "custom") {
        x_part_type.innerHTML = x_part_type_Arr[0];
        x_part_type.innerHTML += x_part_type_Arr[1];
        x_part_type.innerHTML += x_part_type_Arr[2];
        YearDiv.style.display = "none";
        MonthDiv.style.display = "none";
        CustomIntervalDiv.style.display = "block";
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

function searchResultByLoc() {
    document.getElementById("PrintBtn").disabled = true;
    clearTableResult();
    var date_range = document.getElementById("date_range").innerHTML;
    var date_range_arr = date_range.split(" | ");
    var date_from = date_range_arr[0];
    var date_to = date_range_arr[1];
    if (LocTableArr.length === 0) {
        Warning("برجاء اختيار موقع على الأقل");
    } else {

        status = 't';
        var parts;
        try {
            parts = document.getElementById("parts").value;
        } catch (err) {
            parts = "NoAllowParts";
        }
        var rejects;
        try {
            rejects = document.getElementById("rejects").value;
        } catch (err) {
            rejects = "NoRejects";
        }

        var detailType;
        try {
            detailType = document.getElementById("detailType").value;
        } catch (err) {
            detailType = "NoDetails";
        }
        var URL2 = "_0_0_0_4_5_3_Employees_Rewards_Dashboard_Build_AccessServlet?"
                + "date_from=" + date_from
                + "&date_to=" + date_to
                + "&LocationCode_Global=" + LocationCode_Global
                + "&LocTableArr=" + LocTableArr
                + "&useBandAttribute=false"
                + "&rejects=" + rejects
                + "&parts=" + parts
                + "&detailType=" + detailType
                + "&Key=Open";
        console.log(URL2);
        window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
    }
}

function searchResultByBand() {
    document.getElementById("PrintBtn").disabled = true;
    clearTableResult();
    var date_range = document.getElementById("date_range").innerHTML;
    var date_range_arr = date_range.split(" | ");
    var date_from = date_range_arr[0];
    var date_to = date_range_arr[1];
    if (LocTableArr.length === 0) {
        Warning("برجاء اختيار موقع على الأقل");
    } else if (BandTableArr.length === 0) {
        Warning("برجاء اختيار مكافأة على الأقل");
    } else {

        status = 't';
        var parts;
        try {
            parts = document.getElementById("parts").value;
        } catch (err) {
            parts = "NoAllowParts";
        }
        var rejects;
        try {
            rejects = document.getElementById("rejects").value;
        } catch (err) {
            rejects = "NoRejects";
        }

        var detailType;
        try {
            detailType = document.getElementById("detailType").value;
        } catch (err) {
            detailType = "NoDetails";
        }

        var URL2 = "_0_0_0_4_5_3_Employees_Rewards_Dashboard_Build_AccessServlet?"
                + "date_from=" + date_from
                + "&date_to=" + date_to
                + "&LocationCode_Global=" + LocationCode_Global
                + "&LocTableArr=" + LocTableArr
                + "&BandTableArr=" + BandTableArr
                + "&useBandAttribute=true"
                + "&rejects=" + rejects
                + "&parts=" + parts
                + "&detailType=" + detailType
                + "&Key=Open";
        console.log(URL2);
        window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
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