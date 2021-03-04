/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var status = 'f';

setInterval(queryLoad, 500);

var theme;
function setTheme(color_1, color_2) {
    theme = {
        color: [
            '#'+color_1, '#'+color_2, '#BDC3C7', '#3498DB',
            '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7'
        ],

        title: {
            itemGap: 8,
            textStyle: {
                fontWeight: 'normal',
                color: '#408829'
            }
        },

        dataRange: {
            color: ['#1f610a', '#97b58d']
        },

        toolbox: {
            color: ['#408829', '#408829', '#408829', '#408829']
        },

        tooltip: {
            backgroundColor: 'rgba(0,0,0,0.5)',
            axisPointer: {
                type: 'line',
                lineStyle: {
                    color: '#408829',
                    type: 'dashed'
                },
                crossStyle: {
                    color: '#408829'
                },
                shadowStyle: {
                    color: 'rgba(200,200,200,0.3)'
                }
            }
        },

        dataZoom: {
            dataBackgroundColor: '#eee',
            fillerColor: 'rgba(64,136,41,0.2)',
            handleColor: '#408829'
        },
        grid: {
            borderWidth: 0
        },

        categoryAxis: {
            axisLine: {
                lineStyle: {
                    color: '#408829'
                }
            },
            splitLine: {
                lineStyle: {
                    color: ['#eee']
                }
            }
        },

        valueAxis: {
            axisLine: {
                lineStyle: {
                    color: '#408829'
                }
            },
            splitArea: {
                show: true,
                areaStyle: {
                    color: ['rgba(250,250,250,0.1)', 'rgba(200,200,200,0.1)']
                }
            },
            splitLine: {
                lineStyle: {
                    color: ['#eee']
                }
            }
        },
        timeline: {
            lineStyle: {
                color: '#408829'
            },
            controlStyle: {
                normal: {color: '#408829'},
                emphasis: {color: '#408829'}
            }
        },

        k: {
            itemStyle: {
                normal: {
                    color: '#68a54a',
                    color0: '#a9cba2',
                    lineStyle: {
                        width: 1,
                        color: '#408829',
                        color0: '#86b379'
                    }
                }
            }
        },
        map: {
            itemStyle: {
                normal: {
                    areaStyle: {
                        color: '#ddd'
                    },
                    label: {
                        textStyle: {
                            color: '#c12e34'
                        }
                    }
                },
                emphasis: {
                    areaStyle: {
                        color: '#99d2dd'
                    },
                    label: {
                        textStyle: {
                            color: '#c12e34'
                        }
                    }
                }
            }
        },
        force: {
            itemStyle: {
                normal: {
                    linkStyle: {
                        strokeColor: '#408829'
                    }
                }
            }
        },
        chord: {
            padding: 4,
            itemStyle: {
                normal: {
                    lineStyle: {
                        width: 1,
                        color: 'rgba(128, 128, 128, 0.5)'
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: 'rgba(128, 128, 128, 0.5)'
                        }
                    }
                },
                emphasis: {
                    lineStyle: {
                        width: 1,
                        color: 'rgba(128, 128, 128, 0.5)'
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: 'rgba(128, 128, 128, 0.5)'
                        }
                    }
                }
            }
        },
        gauge: {
            startAngle: 225,
            endAngle: -45,
            axisLine: {
                show: true,
                lineStyle: {
                    color: [[0.2, '#86b379'], [0.8, '#68a54a'], [1, '#408829']],
                    width: 8
                }
            },
            axisTick: {
                splitNumber: 10,
                length: 12,
                lineStyle: {
                    color: 'auto'
                }
            },
            axisLabel: {
                textStyle: {
                    color: 'auto'
                }
            },
            splitLine: {
                length: 18,
                lineStyle: {
                    color: 'auto'
                }
            },
            pointer: {
                length: '90%',
                color: 'auto'
            },
            title: {
                textStyle: {
                    color: '#333'
                }
            },
            detail: {
                textStyle: {
                    color: 'auto'
                }
            }
        },
        textStyle: {
            fontFamily: 'Arial, Verdana, sans-serif'
        }
    };
}


function createTable(data, sexFlag) {
    var header = "";
    if (sexFlag === "male") {
        header = "<th style='text-align: center;font-size: 15px;'>الكوادر</th>"
                + "<th style='text-align: center;font-size: 15px;'>الذكور</th>"
                + "<th style='text-align: center;font-size: 15px;'>الإجمالي</th>";
    } else if (sexFlag === "female") {
        header = "<th style='text-align: center;font-size: 15px;'>الكوادر</th>"
                + "<th style='text-align: center;font-size: 15px;'>الإناث</th>"
                + "<th style='text-align: center;font-size: 15px;'>الإجمالي</th>";
    } else if (sexFlag === "*") {
        header = "<th style='text-align: center;font-size: 15px;'>الكوادر</th>"
                + "<th style='text-align: center;font-size: 15px;'>الذكور</th>"
                + "<th style='text-align: center;font-size: 15px;'>الإناث</th>"
                + "<th style='text-align: center;font-size: 15px;'>الإجمالي</th>";
    }
    document.getElementById("headerDiv").innerHTML = header;
/////////////////////////////////////////////////////////////
    /*
     * body
     */
    var body = "";
    
    
    
    document.getElementById("bodyDiv").innerHTML = body;
    $.each(data, function (index, mainData) {
        //part.push(article.x_part_name);
        //var part = [];
        //var names = [];

        var row = "";
        var male_count = 0;
        var female_count = 0;
        $.each(mainData.parts, function (i, part1) {
            //item = tag + " - " + item;
            //Success(part1);
            //part.push(part1);
            row = "<tr>";
            var total = 0;
            row = row + "<td>" + part1 + "</td>";
            $.each(mainData.data_list, function (j, data_list1) {
                //var vals = [];
                //Success(items_profit1.data_names);
                //names.push(gender1.gender_name);
                $.each(data_list1.values, function (k, values1) {
                    if (i === k) {
                        row = row + "<td> " + values1 + "</td>";
                        total = +total + +values1;
                        if(data_list1.data_name === "ذكر"){
                            male_count = +male_count + +values1;
                        }else{
                            female_count = +female_count + +values1;
                        }
                    }
                    //Success(values1);
                    //vals.push(values1);
                });

            });
            row = row + "<td>" + total + "</td>";
            row = row + "</tr>";
            body = body + row;
            document.getElementById("male_count").innerHTML = male_count;
            document.getElementById("female_count").innerHTML = female_count;            
        });

        document.getElementById("bodyDiv").innerHTML = body;        
        reloadDataTable();
    });
    // body end
    ///////////


}
function refresh(chartType, plotType, generalCode, locationCode, sexFlag, color_1, color_2, loadtable) {
    status = 't';
    setTheme(color_1, color_2);
    
    $.ajax({
        url: "_0_0_0_1_0_4_Dash_EmpCount_Kader_Ajax_0_getdataAnalysis_AjaxServlet?"
                + "generalCode=" + generalCode
                + "&locationCode=" + locationCode
                + "&sexFlag=" + sexFlag,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',

        success: function (data) {
            if (loadtable==='true') {
                createTable(data, sexFlag);
            }
            if (typeof (echarts) === 'undefined') {
                return;
            }
            console.log('init_echarts');



            //echart Bar

            // Get Parts of Charts
            var part = [];
            var names = [];
            var series = [];
            var series2 = [];
            $.each(data, function (index, mainData) {
                //part.push(article.x_part_name);

                $.each(mainData.parts, function (i, part1) {
                    //item = tag + " - " + item;
                    //Success(part1);
                    part.push(part1);
                });

                $.each(mainData.data_list, function (j, data_list1) {

                    //Success(items_profit1.data_names);
                    names.push(data_list1.data_name);

                    var vals = [];
                    $.each(data_list1.values, function (k, values1) {

                        //Success(values1);
                        vals.push(values1);
                    });
                    series.push({
                        name: data_list1.data_name,
                        type: chartType, // bar , line
                        data: vals,
                        markPoint: {
                            data: [{
                                    type: 'max',
                                    name: 'أعلى عدد'
                                }, {
                                    type: 'min',
                                    name: 'أقل عدد'
                                }]
                        },
                        markLine: {
                            data: [{
                                    type: 'average',
                                    name: 'المتوسط'
                                }]
                        }
                    });
                    series2.push({
                        name: data_list1.data_name,
                        type: chartType,
                        data: vals//[18203, 23489, 29034, 104970, 131744, 630230]
                    });

                });

            });
            ////////////
            if (plotType === "V") {
                document.getElementById("EmpCount_DashBoard").style.height = "500px";
                if ($('#EmpCount_DashBoard').length) {

                    var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

                    echartBar.setOption({
                        title: {
                            text: '',
                            subtext: ''
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: names//['sales', 'purchases']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    title: {
                                        line: 'Line',
                                        bar: 'Bar',
                                        stack: 'Stack',
                                        tiled: 'Tiled'
                                    },
                                    type: ['line', 'bar', 'stack', 'tiled']
                                },
                                restore: {
                                    show: true,
                                    title: "Restore"
                                },
                                saveAsImage: {
                                    show: true,
                                    title: "Save Image"
                                }
                            }
                        },
                        calculable: false,
                        xAxis: [{
                                type: 'category',
                                data: part//['1?', '2?', '3?', '4?', '5?', '6?', '7?', '8?', '9?', '10?', '11?', '12?']
                            }],
                        yAxis: [{
                                type: 'value'
                            }],
                        series: series
                    });

                }
            } else if (plotType === "H") {
                document.getElementById("EmpCount_DashBoard").style.height = "2000px";
                if ($('#EmpCount_DashBoard').length) {

                    var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

                    echartBar.setOption({
                        title: {
                            text: '',
                            subtext: ''
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            x: 100,
                            data: names//['2015', '2016']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    title: {
                                        line: 'Line',
                                        bar: 'Bar',
                                        stack: 'Stack',
                                        tiled: 'Tiled'
                                    },
                                    type: ['line', 'bar', 'stack', 'tiled']
                                },
                                restore: {
                                    show: true,
                                    title: "Restore"
                                },
                                saveAsImage: {
                                    show: true,
                                    title: "Save Image"
                                }
                            }
                        },
                        calculable: true,
                        xAxis: [{
                                type: 'value',
                                boundaryGap: [0, 0.01]
                            }],
                        yAxis: [{
                                type: 'category',
                                minBarLength: 2,
                                data: part//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun']
                            }],
                        series: series2
                    });

                }
            }
            status = 'f';
            frame(100);


        },
        error: function (data, status, er) {
            alert("error: " + data + " status: " + status + " er:" + er);
        }
    });
}


/*$(document).ready(function () {
 
 init_echarts();
 
 });*/
////////////////////Loading

function getLoad() {
    //alert(status);
    var URL = "_0_0_0_1_0_4_Dash_EmpCount_Kader_Ajax_1_getLoad_1_AjaxServlet?";

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
function reloadDataTable() {

    $('#table_resetData').DataTable()
            .rows().invalidate('data')
            .draw(true);
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