/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init_daterangepicker() {

    if (typeof ($.fn.daterangepicker) === 'undefined') {
        return;
    }
    console.log('init_daterangepicker');

    var cb = function (start, end, label) {
        console.log(start.toISOString(), end.toISOString(), label);
        $('#reportrange_FullDashBoard_1 span').html(start.format('YYYY-MM-DD') + ' | ' + end.format('YYYY-MM-DD'));
    };

    var optionSet1 = {
        startDate: moment().subtract(29, 'days'),
        endDate: moment(),
        minDate: '01/01/2018',
        maxDate: new Date(),
        showDropdowns: true,
        showWeekNumbers: true,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: true,
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
        format: 'YYYY-MM-DD',
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

    $('#reportrange_FullDashBoard_1 span').html(moment().subtract(29, 'days').format('YYYY-MM-DD') + ' | ' + moment().format('YYYY-MM-DD'));
    $('#reportrange_FullDashBoard_1').daterangepicker(optionSet1, cb);
    $('#reportrange_FullDashBoard_1').on('show.daterangepicker', function () {
        console.log("show event fired");
    });
    $('#reportrange_FullDashBoard_1').on('hide.daterangepicker', function () {
        console.log("hide event fired");
    });
    $('#reportrange_FullDashBoard_1').on('apply.daterangepicker', function (ev, picker) {
        console.log("apply event fired, start/end dates are " + picker.startDate.format('YYYY-MM-DD') + " to " + picker.endDate.format('YYYY-MM-DD'));
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

setInterval(refresh, 300);
function refresh() {
    dashTypeFunction();
}
function dashTypeFunction() {
    var dashType1 = document.getElementById("dashType1").value;
    var EmpDiv = document.getElementById("EmpDiv");
    var OrgDiv = document.getElementById("OrgDiv");
    if (dashType1 === "emp") {
        EmpDiv.style.display = "block";
        OrgDiv.style.display = "none";
    } else if (dashType1 === "org") {
        EmpDiv.style.display = "none";
        OrgDiv.style.display = "block";
    } else {
        EmpDiv.style.display = "none";
        OrgDiv.style.display = "none";
    }
}

var empFoundStatus = false;
function getEmpData() {
    var empNo = document.getElementById("empNo").value;
    var xhttp = new XMLHttpRequest();

    var URL = "_0_0_0_1_5_0_Dash_Board_Sarf_Main_Ajax_1_getEmpData_AjaxServlet?empNo=" + empNo;

    xhttp.open("POST", URL, true);
    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
            var notfoundHTML = "<tr>\n"
                    + "    <td style='text-align: center;font-size: 15px;width: 10%' colspan=\"3\">لا توجد بيانات</td>\n"
                    + "</tr>";
            if (message === "Error") {
                // Error Action to Current Page.
                document.getElementById("emp_data_table").innerHTML = notfoundHTML;
            } else {
                if (message === notfoundHTML) {
                    empFoundStatus = false;
                } else {
                    empFoundStatus = true;
                }
                document.getElementById("emp_data_table").innerHTML = message;
            }
        }
    };
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

function BuildDash1() {
    //alert(empFoundStatus);
    var dashType1 = document.getElementById("dashType1").value;
    var empNo = document.getElementById("empNo").value;
    var orgID = document.getElementById("orgID").value;
    var IntervalTimeType = document.getElementById("IntervalTimeType").value;
    var x_part_type = document.getElementById("x_part_type").value;
    var year_choice = document.getElementById("year_choice").value;
    var month_choice = document.getElementById("month_choice").value;
    var date_range = document.getElementById("date_range").value;
    if (dashType1 !== "" || dashType1 !== null) {
        if (dashType1 === "emp") {
            if (empNo === "" || empNo === null) {
                Warning("برجاء كتابة رقم تأمين الموظف");
            }
        } else if (dashType1 === "org") {
            if (orgID === "" || orgID === null) {
                Warning("برجاء اختيار الإدارة");
            }
        } else {
            Warning("برجاء اختيار نوع الإحصائية");
        }
       
//-------------------------------------------------------
    } else if (IntervalTimeType !== "" || IntervalTimeType !== null) {
        if (IntervalTimeType === "year") {
            if (year_choice === "" || year_choice === null) {
                Warning("برجاء اختيار السنة");
            }
        } else if (IntervalTimeType === "month") {
            if (year_choice === "" || year_choice === null) {
                Warning("برجاء اختيار السنة");
            } else if (month_choice === "" || month_choice === null) {
                Warning("برجاء اختيار الشهر");
            }
        } else if (IntervalTimeType === "custom") {
            if (date_range === "" || date_range === null) {
                Warning("برجاء اختيار الفترة");
            }
        } else {
            Warning("برجاء اختيار الفترة الزمنية");
        }
//--------------------------------------------------------------
    } else if (x_part_type === "" || x_part_type === null) {
        Warning("برجاء اختيار نوع التقسيم");
    } else {
        alert(empNo);
        //var URL2 = "_0_0_0_1_0_1_Dash_Emp_By_Degree_Gov_AccessServlet?cadreDegreeCode=" + cadreDegreeCode + "&generalCode=" + generalCode + "&locationCode=" + locationCode + "&Key=Open";
        //window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
    }
}
