/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function SearchTypeDivs() {
    var searchType = document.getElementById("searchType").value;
    if (searchType === "emp") {
        document.getElementById("employeeIdDiv").style.display = "block";
        document.getElementById("OrgCodeDiv").style.display = "none";
    } else if (searchType === "org") {
        document.getElementById("employeeIdDiv").style.display = "none";
        document.getElementById("OrgCodeDiv").style.display = "block";
    } else {
        document.getElementById("employeeIdDiv").style.display = "none";
        document.getElementById("OrgCodeDiv").style.display = "none";
    }

}

function Load_PerAttendanceExistZk_ForAll() {
    var searchType = document.getElementById("searchType").value;
    var employeeId = document.getElementById("employeeId").value;
    var OrgCode = document.getElementById("OrgCode").value;
    var SearchstartDate = document.getElementById("SearchstartDate").value;
    var SearchEndDate = document.getElementById("SearchEndDate").value;

    if (searchType === "" || searchType === null) {
        Warning("برحاء اختيار نوع البحث");
    } else {
        if ((employeeId === "" || employeeId === null)&&searchType==="emp") {
            Warning("برحاء ادخال تأمين الموظف");
        } else if ((OrgCode === "" || OrgCode === null)&&searchType==="org") {
            Warning("برحاء اختيار الإدارة");
        } else if (SearchstartDate === "" || SearchstartDate === null) {
            Warning("برحاء اختيار بداية تاريخ البحث");
        } else if (SearchEndDate === "" || SearchEndDate === null) {
            Warning("برحاء اختيار نهاية تاريخ البحث");
        } else {
            var URL = "_0_0_0_2_0_1_PerAttendanceExistZk_Ajax_1_LoadTable_AjaxServlet?searchType=" + searchType;
            URL += "&employeeId=" + employeeId;
            URL += "&OrgCode=" + OrgCode;
            URL += "&SearchstartDate=" + SearchstartDate;
            URL += "&SearchEndDate=" + SearchEndDate;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        document.getElementById("PerAttendanceExistZk_ForAll_Table").innerHTML = ""
                                + "<tr>"
                                + "   <td colspan='7'>لا توجد بيانات</td>"
                                + "</tr>";
                    } else {
                        document.getElementById("PerAttendanceExistZk_ForAll_Table").innerHTML = message;
                    }
                }
            };
        }
    }
}



