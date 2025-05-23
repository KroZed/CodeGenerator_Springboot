var HOST = '';//http://localhost:8080
var API_PREFIX = "/api/";

function U() {
    var url = arguments[0] || [];
    var param = arguments[1] || {};
    var url_arr = url.split('/');

    if (!$.isArray(url_arr) || url_arr.length < 2 || url_arr.length > 3) {
        return '';
    }

    if (url_arr.length == 2)
        url_arr.unshift(_GROUP_);

    var pre_arr = ['g', 'm', 'a'];

    var arr = [];
    for (d in pre_arr)
        arr.push(pre_arr[d] + '=' + url_arr[d]);

    for (d in param)
        arr.push(d + '=' + param[d]);

    return _APP_+'?'+arr.join('&');
}
//===================以下是自己的。
function jqBindCombo(comboId, data, includeEmptyOption) {
    var $combo = $("#" + comboId);
    $combo.empty();
    $combo.text("");
    if (includeEmptyOption) {
        $combo.append("<option value=''>全部</option>");
    }
    for (i = 0; i < data.length; i++) {
        $combo.append("<option value='" + data[i].Id + "'>" + data[i].Name + "</option>");
    }
}
//用法：jqCasscadeCombo("ProvinceId", "CityId", "/DataApi/GetCities", function () { jqCasscadeCombo("CityId", "DistrictId", "/DataApi/GetDistricts"); });
function jqCasscadeCombo(parentComboId, childrenComboId, apiUrl, callback, includeEmptyOption) {
    $("#" + parentComboId).change(function () {
        var pid = $("#" + parentComboId).val();
        $.post(apiUrl, { parentId: pid }, function (result) {
            if (result.Successful) {
                jqBindCombo(childrenComboId, result.Data, includeEmptyOption);
                $("#" + childrenComboId).trigger("change"); //if(result.Data.length==0) 
            } else {
                showErrMsg(result.Message);
            }
        }, "json");
    });
    if (typeof callback === "function") callback();
}
function jqThreeLevelCasscadeCombo(firstComboId, secondComboId, thirdComboId, getSecondComboDataUrl, getThirdComboDataUrl) {
    $("#" + firstComboId).change(function () {
        $("#" + secondComboId).empty();
        $("#" + thirdComboId).empty();
        var pid = $("#" + firstComboId).val();
        $.post(getSecondComboDataUrl, { parentId: pid }, function (result) {
            if (result.Successful) {
                jqBindCombo(secondComboId, result.Data);
                $("#" + secondComboId).trigger("change");
            } else {
                showErrMsg(result.Message);
            }
        }, "json");
    });
    $("#" + secondComboId).change(function () {
        $("#" + thirdComboId).empty();
        var cid = $("#" + secondComboId).val();
        $.post(getThirdComboDataUrl, { parentId: cid }, function (result) {
            if (result.Successful) {
                jqBindCombo(thirdComboId, result.Data);
            } else {
                showErrMsg(result.Message);
            }
        }, "json");
    });
}
//================================以下消防平台
function ajaxCall(url, method, data, doneCallback, failCallback) {
    $.ajax(url,{
        type:method,
        data:data,
        dataType:"json",
        beforeSend: function(xhr){
            var arr, reg = new RegExp("(^| )GDDX_TOKEN=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg)){
                var token = arr[2];
                xhr.setRequestHeader('GDDX_TOKEN', token);
            }
        }
    }).done(function(data,status,xhr) {
        if(data.code==0) {
            doneCallback(data.data);
        }else{
            alert(data.message);
        }
    }).fail(function(xhr,status,errorThrown){
        if(failCallback && failCallback!=null && failCallback != undefined) {
            failCallback(xhr,status,errorThrown);
        }else{
            alert("发生错误！" + status);
        }
    });
}
function getRequestParameter(name) {
    var url = location.search; //获取url中含"?"符后的字串
    //var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            if(strs[i].split("=")[0]==name) return strs[i].split("=")[1];
            //theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }

    return null;
}
var renderUrl = function (h, src, title, newWindow) {
    if (!src) return "";
    if(newWindow) {
        return [h("a", { attrs: { href: src, target:'_blank' } },title)];
    } else {
        return [h("a", { attrs: { href: src  } },title)];
    }
}
var renderImage = function (h, src) {
    if (!src) return "";
    return [h("img", { attrs: { src: src }, style: { width: '40px', height: '40px',margin:'10px' } })];
}
var renderBoolean = function (h, v) {
    return v ? '是' : '否';
}
var renderCurrency = function (h, v) {
    if (!v) return "";
    return common.formatCurrency(v);
}
var renderPercentage = function (h, v) {
    if (!v) return "";
    return common.formatPercentage(v);
}
var renderNumberWithThousands = function (h, v) {
    if(v==0) return "0";
    if (!v) return "";
    return common.formatNumberWithThousands(v);
}
var renderDate = function (h, v) {
    if (!v) return "";
    /*
    v = v.replace("/Date(", "").replace(")/", "");
    if (v.indexOf("+") > 0) {
        v = v.substring(0, jsondate.indexOf("+"));
    }
    else if (v.indexOf("-") > 0) {
        v = v.substring(0, v.indexOf("-"));
    }
    */
    //var date = new Date(parseInt(v, 10));
    var date = new Date(v);
    return common.formatDateTime(date, "yyyy-MM-dd");
}
var renderDateTime = function (h, v) {
    if (!v) return "";
    /*
    v = v.replace("/Date(", "").replace(")/", "");
    if (v.indexOf("+") > 0) {
        v = v.substring(0, jsondate.indexOf("+"));
    }
    else if (v.indexOf("-") > 0) {
        v = v.substring(0, v.indexOf("-"));
    }
    */
    var date = new Date(v);

    return common.formatDateTime(date, "yyyy-MM-dd  hh:mm:ss");
}
var integerValidator = function (rule, value, cb) {
    var integerReg = /^[1-9]\d*$/;
    if(!integerReg.test(value) && value != null && value != ""){
        cb(new Error("请输入整数"));
    } else {
        cb();
    }
}
var doubleValidator = function (rule, value, cb) {
    var integerReg = /^(([1-9]\d*)|0)(\.\d*)?$/;
    if(!integerReg.test(value) && value != null && value != ""){
        cb(new Error("请输入整数"));
    } else {
        cb();
    }
}

var ivewFilters = {
    formatCurrency: function (value) {
        if (!value) return "";
        return common.formatCurrency(value);
    },
    formatPercentage: function (value) {
        if (!value) return "";
        return common.formatPercentage(value);
    },
    formatNumberWithThousands: function (num) {
        if (!num) return "";
        return common.formatNumberWithThousands(num);
    },
    formatDate: function (jsondate) {
        if (!jsondate) return "";
        jsondate = jsondate.replace("/Date(", "").replace(")/", "");
        if (jsondate.indexOf("+") > 0) {
            jsondate = jsondate.substring(0, jsondate.indexOf("+"));
        }
        else if (jsondate.indexOf("-") > 0) {
            jsondate = jsondate.substring(0, jsondate.indexOf("-"));
        }

        var date = new Date(parseInt(jsondate, 10));
        return common.formatDateTime(date, "yyyy-MM-dd");
    },
    formatDateTime: function (jsondate) {
        if (!jsondate) return "";
        jsondate = jsondate.replace("/Date(", "").replace(")/", "");
        if (jsondate.indexOf("+") > 0) {
            jsondate = jsondate.substring(0, jsondate.indexOf("+"));
        }
        else if (jsondate.indexOf("-") > 0) {
            jsondate = jsondate.substring(0, jsondate.indexOf("-"));
        }

        var date = new Date(parseInt(jsondate, 10));
        return common.formatDateTime(date, "yyyy-MM-dd hh:mm:ss");
    },
    formatBoolean: function (value) {
        return value ? "是" : "否";
    }
};