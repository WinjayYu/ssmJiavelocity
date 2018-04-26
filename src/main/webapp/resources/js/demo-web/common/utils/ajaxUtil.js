
function ajax(url,type,data,callFun) {
    if(!callFun){
        callFun = function() {};
    }
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
            alert(ret.error);
        }
    });
}

function ajaxForm(url,type,data,callFun) {
	if(!callFun){
		callFun = function() {};
	}
	$.ajax({
		url : url,
		type : type,
		data : data,
		datatype:"json",
		success : function(ret, stats) {
			callFun(ret,stats);
		},
		error : function(ret) {
			alert(ret.error);
		}
	});
}
