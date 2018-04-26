function swalConfirm(title, text, callFun) {
    
    if(callFun == null || callFun == undefined) {
        callFun = function () {};
    }
//    var isConfirming = false;
    swal({
        title: title,
        text: text,
        showCancelButton: true,
        confirmButtonColor: "#1ab394",
        confirmButtonText: "确认",
        cancelButtonText: "取消",
    }, function(isConfirm) {
        if(isConfirm ) {
//            if(!isConfirming) {
                callFun();
//                isConfirming = false;
//            }
        }
    })
}

/**
 * 
 * @param title swal标题
 * @param text 内容
 * @param url ajax url
 * @param type 
 * @param data
 * @param callFun
 */
function swalConfirmAjax(title, text, url, type, data, callFun) {
    
    if(callFun == null || callFun == undefined) {
        callFun = function () {};
    }
    var isConfirming = false;
    swal({
        title: title,
        text: text,
        showCancelButton: true,
        confirmButtonColor: "#1ab394",
        confirmButtonText: "确认",
        cancelButtonText: "取消",
        closeOnConfirm: false,
    }, function(isConfirm) {
        if(isConfirm && !isConfirming) {
            isConfirming = true;
            $.ajax({
                url : url,
                type : type,
                data : data,
                contentType:"application/json",
                datatype:"json",
                success : function(ret, stats) {
                    callFun(ret,stats);
                },
                error : function(ret) {
                    swal("error", ret.error, "error");
                }
            });
        }
    })
}

function addCoverLoading() {
    
    var htmlText = '<div id="cover-loading" style="position:fixed; top: 0px; right:0px; bottom:0px;filter: alpha(opacity=60); background-color: #777;z-index: 1002; left: 0px;opacity:0.5; -moz-opacity:0.5;">' +
                        '<div class="sk-spinner sk-spinner-three-bounce" style="margin-top: 25%">' + 
                            '<div class="sk-bounce1"></div>' + 
                            '<div class="sk-bounce2"></div>' + 
                            '<div class="sk-bounce3"></div>' + 
                        '</div>' + 
                    '</div>';
    $("body").css("overflow","hidden");
    $("body").prepend(htmlText);
}

function removeCoverLoading() {
    $("body").css("overflow","scroll");
    $("#cover-loading").remove();
}


function swalConfirmAjaxLoading(title, text, url, type, data, callFun) {
    
    if(callFun == null || callFun == undefined) {
        callFun = function () {};
    }
//    var isConfirming = false;
    swal({
        title: title,
        text: text,
        showCancelButton: true,
        confirmButtonColor: "#1ab394",
        confirmButtonText: "确认",
        cancelButtonText: "取消",
        closeOnConfirm: true,
    }, function(isConfirm) {
        if(isConfirm) {
            addCoverLoading();
//            isConfirming = true;
            $.ajax({
                url : url,
                type : type,
                data : data,
                contentType:"application/json",
                datatype:"json",
                success : function(ret, stats) {
                    callFun(ret,stats);
                    removeCoverLoading();
                },
                error : function(ret) {
                    swal("error", ret.error, "error");
                    removeCoverLoading();
                }
            });
        }
    })
}