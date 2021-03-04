/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
setInterval(Radio, 300);
function Radio() {
    var i = 1;
    for (i = 1; i <= 7; i++) {
        if (document.getElementById("Dash" + i).checked) {
            document.getElementById("Dash_" + i).style.display = "block";
        }else{
            document.getElementById("Dash_" + i).style.display = "none";
        }
    }
}
function BuildDash1() {
    var cadreDegreeCode = document.getElementById("caderCode").value;
    var generalCode = document.getElementById("generalCode").value;
    var locationCode = document.getElementById("locationCode").value;
    if (cadreDegreeCode === "" || cadreDegreeCode === null) {
        Warning("برجاء اختيار نوع الكادر");
    } else if (generalCode === "" || generalCode === null) {
        Warning("برجاء اختيار مؤشر المعاملة");
    } else if (locationCode === "" || locationCode === null) {
        Warning("برجاء اختيار الجهة");
    } else {
        var URL2 = "_0_0_0_1_0_1_Dash_Emp_By_Degree_Gov_AccessServlet?cadreDegreeCode=" + cadreDegreeCode + "&generalCode=" + generalCode + "&locationCode=" + locationCode + "&Key=Open";
        window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
    }
}

function BuildDash2() {
    var jobLaw = document.getElementById("jobLaw").value;
    var PromotionType = document.getElementById("PromotionType").value;
    var PostDate = document.getElementById("PostDate").value;
    if (jobLaw === "" || jobLaw === null) {
        Warning("برجاء اختيار قانون العمل");
    } else if (PromotionType === "" || PromotionType === null) {
        Warning("برجاء اختيار نوع الترقية");
    } else if (PostDate === "" || PostDate === null) {
        Warning("برجاء اختيار سنة الترقية");
    } else {
        var URL2 = "_0_0_0_1_0_2_Dash_Emp_By_Promotion_AccessServlet?jobLaw=" + jobLaw + "&PromotionType=" + PromotionType + "&PostDate=" + PostDate + "&Key=Open";
        window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
    }
}
function BuildDash3() {
    var plotType = document.getElementById("plotType").value;
    var generalCode = document.getElementById("generalCode1").value;
    var locationCode = document.getElementById("locationCode").value;
    var sexFlag = document.getElementById("sexFlag").value;

    var color_15 = document.getElementById("color_13").value.split("#");
    var color_25 = document.getElementById("color_23").value.split("#");
    var URL2 = "_0_0_0_1_0_3_Dash_EmpCount_AccessServlet?"
            + "plotType=" + plotType
            + "&generalCode=" + generalCode
            + "&locationCode=" + locationCode
            + "&sexFlag=" + sexFlag
            + "&color_1=" + color_15[1]
            + "&color_2=" + color_25[1]
            + "&Key=Open";
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');

}


function BuildDash4() {
    var plotType = document.getElementById("plotType4").value;
    var generalCode = document.getElementById("generalCode4").value;
    var locationCode = document.getElementById("locationCode4").value;
    var sexFlag = document.getElementById("sexFlag4").value;

    var color_15 = document.getElementById("color_14").value.split("#");
    var color_25 = document.getElementById("color_24").value.split("#");

    var URL2 = "_0_0_0_1_0_4_Dash_EmpCount_Kader_AccessServlet?"
            + "plotType=" + plotType
            + "&generalCode=" + generalCode
            + "&locationCode=" + locationCode
            + "&sexFlag=" + sexFlag
            + "&color_1=" + color_15[1]
            + "&color_2=" + color_25[1]
            + "&Key=Open";

    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');

}

function BuildDash5() {
    var plotType = document.getElementById("plotType5").value;
    var generalCode = document.getElementById("generalCode5").value;
    var locationCode = document.getElementById("locationCode5").value;
    var sexFlag = document.getElementById("sexFlag5").value;

    var SearchType = document.getElementById("SearchType5").value;
    var OrgId = document.getElementById("OrgId5").value;
    var FiscalDegreeCode = document.getElementById("FiscalDegreeCode5").value;

    var color_15 = document.getElementById("color_15").value.split("#");
    var color_25 = document.getElementById("color_25").value.split("#");

    var URL2 = "_0_0_0_1_0_5_Dash_EmpCount_KaderAndOrg_AccessServlet?"
            + "plotType=" + plotType
            + "&generalCode=" + generalCode
            + "&locationCode=" + locationCode
            + "&sexFlag=" + sexFlag
            + "&SearchType=" + SearchType
            + "&OrgId=" + OrgId
            + "&FiscalDegreeCode=" + FiscalDegreeCode
            + "&color_1=" + color_15[1]
            + "&color_2=" + color_25[1]
            + "&Key=Open";
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');

}
function SearchTypeCombo5() {
    var SearchType = document.getElementById("SearchType5").value;
    if (SearchType === "1") {
        document.getElementById("OrgDiv").style.display = "block";
        document.getElementById("FiscalDiv").style.display = "none";
    } else if (SearchType === "2") {
        document.getElementById("OrgDiv").style.display = "none";
        document.getElementById("FiscalDiv").style.display = "block";
    }
}

function BuildDash6() {
    /* var plotType = document.getElementById("plotType6").value;
     var locationCode = document.getElementById("locationCode6").value;
     var year = document.getElementById("year6").value;
     
     var color_15 = document.getElementById("color_15").value.split("#");
     var color_25 = document.getElementById("color_25").value.split("#");
     
     var URL2 = "_0_0_0_1_0_6_Dash_EmpCount_PER_HUMAN_BAL_ORG_AccessServlet?"
     + "plotType=" + plotType
     + "&locationCode=" + locationCode
     + "&year=" + year
     + "&color_1=" + color_15[1]
     + "&color_2=" + color_25[1]
     + "&Key=Open";
     window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
     */
}


function BuildDash7() {
    var plotType = document.getElementById("plotType7").value;
    var generalCode = document.getElementById("generalCode7").value;
    var locationCode = document.getElementById("locationCode7").value;
    var sexFlag = document.getElementById("sexFlag7").value;

    var SearchType = document.getElementById("SearchType7").value;
    var QualClassCode = document.getElementById("QualClassCode7").value;
    var FacultyCode = document.getElementById("FacultyCode7").value;

    var color_15 = document.getElementById("color_17").value.split("#");
    var color_25 = document.getElementById("color_27").value.split("#");

    var URL2 = "_0_0_0_1_0_7_Dash_EmpCount_FacultyAndOrg_AccessServlet?"
            + "plotType=" + plotType
            + "&generalCode=" + generalCode
            + "&locationCode=" + locationCode
            + "&sexFlag=" + sexFlag
            + "&SearchType=" + SearchType
            + "&QualClassCode=" + QualClassCode
            + "&FacultyCode=" + FacultyCode
            + "&color_1=" + color_15[1]
            + "&color_2=" + color_25[1]
            + "&Key=Open";
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');

}
function SearchTypeCombo7() {
    var SearchType = document.getElementById("SearchType7").value;
    if (SearchType === "1") {
        document.getElementById("QualClassCodeDiv7").style.display = "block";
        document.getElementById("QualDiv7").style.display = "none";
    } else if (SearchType === "2") {
        document.getElementById("QualClassCodeDiv7").style.display = "none";
        document.getElementById("QualDiv7").style.display = "block";
    }
}

