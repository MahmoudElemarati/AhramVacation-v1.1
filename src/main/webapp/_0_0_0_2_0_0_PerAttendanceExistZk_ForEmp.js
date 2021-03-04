/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Load_PerAttendanceExistZk_ForEmp() {
    var SearchstartDate = document.getElementById("SearchstartDate").value;
    var SearchEndDate = document.getElementById("SearchEndDate").value;
    var URL = "_0_0_0_2_0_0_PerAttendanceExistZk_Ajax_1_LoadTable_AjaxServlet?SearchstartDate=" + SearchstartDate + "&SearchEndDate=" + SearchEndDate;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("PerAttendanceExistZk_ForEmp_Table").innerHTML = ""
                        + "<tr>"
                        + "   <td colspan='4'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("PerAttendanceExistZk_ForEmp_Table").innerHTML = message;
            }
        }
    };
}



