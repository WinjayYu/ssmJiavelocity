/* 自定义页面js */ 
$(function(){
	initTable();
});

var selecturl = "../demo/LotteryPrize/listSearch";
$('.searcherButton').click(function(){
	initTable();
});

$('.clearSearchButton').click(function(){
   	$('#searcherForm')[0].reset();  
   	initTable();
});

//添加
$("#addLotteryPrizeBtn").on("click", function () {
    $("#addLotteryPrizeModal").modal();
});

$("#do-add").on("click", function () {
    try {
        var entitys = getCreateData();
        if(entitys == null) {
            return ;
        }
    } catch (e) {
        return ;
    }

    $.ajax({
        url : "/demo/LotteryPrize/add",
        type : "POST",
        data : JSON.stringify(entitys),
        contentType:"application/json",
        dataType:"json",
        success : function(ret, stats) {
            swal({title:"添加成功！",
                //text:createSuccessHtml(ret.data),
                html:true,
                type:"success",
                showCancelButton: false,
                showConfirmButton:true
            }, function() {

                window.location.href =  "../demo/LotteryPrize";
            });


        },
        error : function(ret) {
            swal("error", ret.error, "error");
        }
    });
});

function getCreateData() {
    var entitys = {};
        return entitys;
}


/**
* 判断字符串是否为空，包括各种空白字符
* @param str
* @returns {boolean}
*/
function isEmpty(str) {
    return str === undefined || str.replace(/(^\s*)|(\s*$)/g, "").length == 0;
}

function initTable(){
    $("#table").bootstrapTable('destroy');
    $("#table").bootstrapTable({
        url: selecturl,
        dataType: "json",
        method: "post",
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        striped: true,  //表格显示条纹
        pagination:true,
        pageSize:10,
        pageList:[10,20,50,100],
        sidePagination:'server',
        queryParams: function queryParams(params) {
            return $("#searcherForm").serialize() + "&size=" + params.limit + "&page=" + (params.offset/params.limit + 1);
        }
    });
}