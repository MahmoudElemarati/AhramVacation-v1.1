/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*إضافة الصورة في بلوك الصور المرفوعة من الجهاز*/
function addPhotoToImages() {
    var uploadedImage = document.getElementById("base64textarea").value;
    if (uploadedImage === "" || uploadedImage === null) {
        Warning("تحذير", "لا يوجد صورة لنقلها");
    } else {
        document.getElementById("imagesUpload").innerHTML += "<img class='scanned' src='data:image/jpeg;base64," + uploadedImage + "'>";
        //document.getElementById("UploadedImages").innerHTML += "<img class='scanned' src='k'>";
        //imagesScanned.push(uploadedImage);
        document.getElementById("image").src = "webDesign/Resources/images/Upload.png";
        document.getElementById("base64textarea").value = "";
    }
}

/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/* كود رفع الصورة من السكانر */
var scanner;
function scanToJpg() {
    scanner.scan(displayImagesOnPage,
            {
                "output_settings": [
                    {
                        "type": "return-base64",
                        "format": "jpg"
                    }
                ]
            }
    );
}

/** Processes the scan result */
function displayImagesOnPage(successful, mesg, response) {
    if (!successful) { // On error
        console.error('Failed: ' + mesg);
        return;
    }

    if (successful && mesg !== null && mesg.toLowerCase().indexOf('user cancel') >= 0) { // User cancelled.
        console.info('User cancelled');
        return;
    }

    var scannedImages = scanner.getScannedImages(response, true, false); // returns an array of ScannedImage
    for (var i = 0; (scannedImages instanceof Array) && i < scannedImages.length; i++) {
        var scannedImage = scannedImages[i];
        processScannedImage(scannedImage);
    }
}

/** Images scanned so far. */
//var imagesScanned = [];

/** Processes a ScannedImage */
function processScannedImage(scannedImage) {
    //imagesScanned.push(scannedImage);
    var elementImg = scanner.createDomElementFromModel({
        'name': 'img',
        'attributes': {
            'class': 'scanned',
            'src': scannedImage.src
        }
    });
    //document.getElementById('scanntextarea').value=scannedImage.src.replace(/(\r\n|\n|\r)/gm, "");
    //imagesScanned.push(scannedImage.src.replace(/(\r\n|\n|\r)/gm, ""));
    document.getElementById('images').appendChild(elementImg);
}
///*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/* كود رفع الصورة من الجهاز */

function photoPropertyAlert() {
    var addLine = "\r\n";
    var alrt = "من فضلك تأكد من مواصفات الملف:" + addLine;
    alrt += "- الامتدادات المتاحة jpg,,jpeg,,png" + addLine;
    alrt += "- مساحة الملف لا تزيد عن 1 ميجا بايت" + addLine;
    //Warning("- الامتدادات المتاحة jpg,,jpeg,,png");
    //Warning("- مساحة الملف لا تزيد عن 1 ميجا بايت");
    Custom_Warning(alrt, '500px');
}


function showImage() {
    var filePicker = document.getElementById("filePicker").value;
    var getExt = filePicker.lastIndexOf(".") + 1;
    var extFile = filePicker.substr(getExt, filePicker.length).toLowerCase();
    var k = 1048576;

    if (this.files && this.files[0] && (extFile === "jpg" || extFile === "jpeg" || extFile === "png") && (this.files[0].size < 1.1 * k)) {
        var obj = new FileReader();
        obj.onload = function (data) {
            var image = document.getElementById("image");
            image.src = data.target.result;
            image.style.display = "block";
        };
        obj.readAsDataURL(this.files[0]);
    } else {
        photoPropertyAlert();
        document.getElementById("filePicker").value = "";
        document.getElementById("image").src = "webDesign/Resources/images/Upload.png";
        document.getElementById("base64textarea").value = "";
    }
}

var handleFileSelect = function (evt) {
    var files = evt.target.files;
    var file = files[0];

    if (files && file) {
        var reader = new FileReader();

        reader.onload = function (readerEvt) {
            var binaryString = readerEvt.target.result;
            document.getElementById("base64textarea").value = btoa(binaryString);
        };

        reader.readAsBinaryString(file);
    }
};

if (window.File && window.FileReader && window.FileList && window.Blob) {
    document.getElementById('filePicker').addEventListener('change', handleFileSelect, false);
} else {
    alert('الملف غير مدعم');
}


///*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/* تفريغ مكان الصور المرفوعة من السكانر او الجاهز */

function resetFunc() {
    document.getElementById("images").innerHTML = "";//مكان السكانر
    document.getElementById("imagesUpload").innerHTML = "";//مكان صور الجهاز
    document.getElementById('base64textarea').value = "";//الوسيط بين الجهاز للبيز أربعة وستون
    document.getElementById('image').src = "webDesign/Resources/images/Upload.png";// مكان الصورة المرفوعة يطهر به صورة السهم
    document.getElementById('filePicker').value = "";

    /////// Table
    document.getElementById("EmpData").innerHTML = "";
    document.getElementById("decisionNo").value = "";
    document.getElementById("decisionTypeCode").value = "";
    document.getElementById("desicionSideCode").value = "";
    document.getElementById("decisionSubject").value = "";
    document.getElementById("decisionSummary").value = "";
    //imagesScanned = [];
}

///*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/*/////////////////////////////////////////////////////////////////////////////////*/
/* الحفظ */
function Save() {
    var decisionNo = document.getElementById("decisionNo").value;
    var decisionTypeCode = document.getElementById("decisionTypeCode").value;
    var desicionSideCode = document.getElementById("desicionSideCode").value;
    var decisionSubject = document.getElementById("decisionSubject").value;
    var decisionSummary = document.getElementById("decisionSummary").value;

    //var imageInputType = document.getElementById('imageInputType').value;
    //var base64textarea = document.getElementById('base64textarea').value;
    //var images = document.getElementById('images').src;

    var flag = true;

    if (decisionNo === "" || decisionNo === null) {
        Warning("برجاء إدخال رقم القرار");
        flag = false;
    } else if (decisionTypeCode === "" || decisionTypeCode === null) {
        Warning("برجاء إدخال نوع القرار");
        flag = false;
    } else if (desicionSideCode === "" || desicionSideCode === null) {
        Warning("برجاء إدخال جهة إصدار القرار");
        flag = false;
    } else if (decisionSubject === "" || decisionSubject === null) {
        //Warning("*");
        //flag = false;
    } else if (decisionSummary === "" || decisionSummary === null) {
        //Warning("**");
        //flag = false;
    }

    var empIds;
    var empArrayStr = "";
    try {
        empIds = document.getElementsByName("empIds");
        if (empIds.length === 0) {
            Warning("لا يوجد موظفين لتسجيلهم مع القرار");
            flag = false;
        } else {
            for (var i = 0; i < empIds.length; ) {

                if (i === (empIds.length - 1)) {
                    empArrayStr += empIds[i].value;
                } else {
                    empArrayStr += empIds[i].value + ";";
                }
                i = i + 1;
            }
        }
    } catch (err) {
        Warning("لا يوجد موظفين لتسجيلهم مع القرار");
        flag = false;
    }

    if (flag === true) {
        var scanned = document.getElementsByClassName("scanned");

        var imagesArrayStr = "";
        if (scanned.length > 0) {
            try {
                //scanned = document.getElementsByClassName("scanned");
                for (var i = 0; i < scanned.length; ) {

                    if (i === (scanned.length - 1)) {
                        imagesArrayStr += scanned[i].src;
                    } else {
                        imagesArrayStr += scanned[i].src + ";";
                    }
                    i = i + 1;
                }
            } catch (err) {

            }
        } else {

        }
        var Confirm = true;
        if (scanned.length === 0) {
            Confirm = confirm("لا توجد صور للقرار .. هل انت متأكد من إتمام عملية الحفظ تلك? .. \n Ok  : إتمام عملية الحفظ || cancel : إلغاء");
        }
        if (Confirm === true) {
            var _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile = new Object();
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.decisionNo = decisionNo;
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.decisionTypeCode = decisionTypeCode;
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.desicionSideCode = desicionSideCode;
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.decisionSubject = decisionSubject;
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.decisionSummary = decisionSummary;
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.perEmpDecisionSheets = empArrayStr.split(";");
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.perDecisionSheetImageDtl = imagesArrayStr.split(";");
            $.ajax({
                url: "_0_0_0_4_0_0_document_scan_Ajax_2_AddToPerDecisionSheet_AjaxServlet?",
                type: 'POST',
                //dataType: 'json',
                data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
                //contentType: 'application/json',
                // mimeType: 'application/json',
                success: function (data) {
                    if (data === "Success") {
                        Success("تمت عملية الحفظ بنجاح");
                        resetFunc();
                    } else if (data === "Error") {
                        Error("حدث خطأ");
                    } else {
                        Warning(data);
                    }
                },
                error: function (xhr, status) {
                    console.log(status); // Output as parseError
                    console.log(xhr.responseText); // My sResponse string ! But Why Here ?
                    if (xhr.responseText === "Error") {
                        Error("حدث خطأ");
                    } else {
                        Warning(xhr.responseText);
                    }
                }
            });

        }
    }

}

function getEmpDataAjax() {
    var employeeId = document.getElementById("searchEmpId").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_0_0_document_scan_Ajax_1_getEmployeeData_AjaxServlet?";
        URL += "employeeId=" + employeeId + "&typeSearch=1";

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("searchEmpData").innerHTML = "لا توجد بيانات موظف";
                } else {
                    document.getElementById("searchEmpData").innerHTML = message;
                }
            }
        };
    }
}
window.addEventListener('keypress', function (e) {
    if (e.keyCode === 13) {
        var searchEmpId = document.querySelector("#searchEmpId");
        var searchEmpId_val = document.getElementById("searchEmpId").value;
        var searchEmpData = document.getElementById("searchEmpData").innerHTML;
        if (searchEmpData === "لا توجد بيانات موظف") {
            Warning(searchEmpData);
        } else if (searchEmpId_val === "" || searchEmpId_val === null) {
            Warning("برحاء ادخال تأمين الموظف");
        } else if (searchEmpId === document.activeElement) {
            addEmpToTable();
        }
    }
}, false);

function addEmpToTable() {
    var employeeId = document.getElementById("searchEmpId").value;
    var flag = 0;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var empIds;
        try {
            empIds = document.getElementsByName("empIds");
            for (var i = 0; i < empIds.length; ) {
                if (empIds[i].value === employeeId) {
                    flag = 1;
                    break;
                }
                i = i + 1;
            }
        } catch (err) {
        }
        if (flag === 0) {
            var URL = "_0_0_0_4_0_0_document_scan_Ajax_1_getEmployeeData_AjaxServlet?";
            URL += "employeeId=" + employeeId + "&typeSearch=2";

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
                    }
                }
            };
        } else {
            Warning("الموظف مسجل بالقرار من قبل");
        }
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
        styling: 'bootstrap3',
        width: '200px'
    });
}
function Custom_Warning(Body, w) {
    new PNotify({
        title: "تحذير",
        text: Body,
        styling: 'bootstrap3',
        width: w
    });
}



