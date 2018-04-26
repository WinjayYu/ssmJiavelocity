// /**
(function (factory) {
    // UMD start
    // https://github.com/umdjs/umd/blob/master/jqueryPluginCommonjs.js
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as an anonymous module.
        define(['jquery'], factory);
    } else if (typeof module === 'object' && module.exports) {
        // Node/CommonJS
        module.exports = function( root, jQuery ) {
            if ( jQuery === undefined ) {
                // require('jQuery') returns a factory that requires window to
                // build a jQuery instance, we normalize how we use modules
                // that require this pattern but the window provided is a noop
                // if it's defined (how jquery works)
                if ( typeof window !== 'undefined' ) {
                    jQuery = require('jquery');
                }
                else {
                    jQuery = require('jquery')(root);
                }
            }
            factory(jQuery);
            return jQuery;
        };
    } else {
        // Browser globals
        factory(jQuery);
    }
}(function ($) {
    //IE8 indexOf polyfill
    var indexOf = [].indexOf || function(item) {
            for (var i = 0, l = this.length; i < l; i++) {
                if (i in this && this[i] === item) {
                    return i;
                }
            }
            return -1;
        };

    var globalErrorMap = {};     // Map map = new HashMap();
    globalErrorMap[104] = "渠道编号为空";
    globalErrorMap[165] = "获取阿里云密钥失败";
    globalErrorMap[168] = "系统繁忙";
    globalErrorMap[205] = "阿里云上传失败";
    globalErrorMap[207] = "图片不存在";
    globalErrorMap[208] = "图片大小超过规定";
    globalErrorMap[209] = "图片长或宽超过规定";
    globalErrorMap[225] = "系统繁忙";
    globalErrorMap[101] = "返回结果为空";
    globalErrorMap[500] = "H5标题不能为空";
    globalErrorMap[499] = "请填写页面元素";
    globalErrorMap[181] = "订单正在处理";
    globalErrorMap[174] = "Excel文件解析失败";
    globalErrorMap[144] = "任务已过期";


    $["getGlobalErrorMap"] = function() {
       return globalErrorMap;
    };

    $["noPrivilege"] = function(tokenName) {
       window.location="/acl/apply/noPrivilege?tokenName="+tokenName;
    };

    $["stackTrace"] = function(result) {
        var form=$('<form id="" style="display: none" method="post" action="/acl/apply/exception"></form>');
        // var input1=$('<input  name="url"/>')
        // input1.val(result.data.url);
        // var input2=$('<input name="exception"/>');
        // var exception=result.data.exception;
        // input2.val(exception);
        // form.append(input1).append(input2);
        $("body").append(form);
        form.submit();
        // window.location="/acl/apply/exception";
    };
}));
