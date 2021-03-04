/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function isInt(n) {
    return Number(n) === n && n % 1 === 0;
}

function isFloat(n) {
    return Number(n) === n && n % 1 !== 0;
}
function isIntegerNumber(elem) {
    alert(elem);
    if (new RegExp(/^\d*\$/).test(elem)) {
        alert("true");
        return true;
    } else {
        alert("false");
        return false;
    }
}
function Custom_Warning(Body, w) {
    new PNotify({
        title: "تحذير",
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        width: w
    });
}