validate = {};
validate.name = function (name) {
    var ret = {};
    if(name == ""){
        ret.isSuccess = false;
        ret.msg = "不能为空";
        return ret;
    }
    
    if(name.length > 30){
        ret.isSuccess = false;
        ret.msg = "不多于30个字";
        return ret;
    }
    
    ret.isSuccess = true;
    return ret;
}

validate.integer = function (integer) {
    var ret = {};
    var re = /^[0-9]+$/;
    ret.isSuccess = re.test(integer);
    if(ret.isSuccess) {
        return ret;
    } else {
        ret.msg = "大于0的整数";
        return ret;
    }
}

validate.float = function (float) {
    var ret = {};
    var re = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/;
    ret.isSuccess = re.test(float);
    if(ret.isSuccess) {
        return ret;
    } else {
        ret.msg = "";
        return ret;
    }
}

validate.spec = function (spec) {
    var ret = {};
    
    if(spec == ""){
        ret.isSuccess = false;
        ret.msg = "不能为空";
        return ret;
    }
    
    if(spec.length > 16){
        ret.isSuccess = false;
        ret.msg = "不多于16个字";
        return ret;
    }
    ret.isSuccess = true;
    return ret;
}

validate.mobile = function (mobile) {
    var ret = {};
    var re = /^1[34578]\d{9}$/;
    ret.isSuccess = re.test(mobile);
    if(ret.isSuccess) {
        return ret;
    } else {
        ret.msg = "格式错误";
        return ret;
    }
}

validate.costCredit = function (credit) {
    var ret = {};
    var re = /^[0-9]+0$/;
    ret.isSuccess = re.test(credit);
    if(ret.isSuccess) {
        return ret;
    } else {
        ret.msg = "大于0且为10的倍数";
        return ret;
    }
}