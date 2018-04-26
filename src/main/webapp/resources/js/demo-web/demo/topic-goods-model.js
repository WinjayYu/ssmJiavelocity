$(function(){
	initTable();
	
	$("#chooseGoodsModel").on("hide.bs.modal",function(){
		$('#searcherForm')[0].reset();
		initTable();
	});
});

var selecturl = "../topic/goodsSearch";
$('.searcherButton').click(function(){
	initTable();
});

$('.clearSearchButton').click(function(){
   	$('#searcherForm')[0].reset();  
   	initTable();
});

function initTable(){
	//清除商品信息
	$("#goodsValue").val("");
	
	$("#goods-table").bootstrapTable('destroy');
    $("#goods-table").bootstrapTable({
    	url: selecturl,
    	dataType: "json",
        method: "post",
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        pagination:true,
        pageSize: 5,
        pageList: [5],
        sidePagination:'server',
        queryParams: function queryParams(params) {
        	//清除商品信息
        	$("#goodsValue").val("");
            return $("#searcherForm").serialize() + "&pager.pageSize=" + params.limit + "&pager.pageNum=" + (params.offset/params.limit + 1);
        }
    });
}

function goodsImageFormatter(value,row,index) {
    var htmlText = '<img class="goods-image sysimg" src=" ' + value + ' " />';
    return htmlText;
}

function goodsSelectFormatter(value,row,index) {
    var htmlText = '<a class="btn btn-primary btn-xs support-each-add" id="goods-add-' + row.id + '" onclick="selectGoods(this.id,this.text,'+ row.id +',\'' + row.name + '\');"><i class="fa fa-check-square-o"></i>选择商品</a>' +
    '<a class="btn btn-warning btn-xs support-each-remove" id="goods-remove-' + row.id + '" onclick="selectGoods(this.id,this.text,'+ row.id +',\'' + row.name + '\');" style="display:none;"><i class="fa fa-times"></i>取消选择</a>';
    return htmlText;
}

function selectGoods(id, type , goodsId, goodsName){
	if(type == "选择商品"){
		$(".support-each-remove").each(function(){
			$(this).parent().parent().removeClass("selected-tr");
			$(this).hide();
		});
		$(".support-each-add").each(function(){
			$(this).show();
		});
		$("#"+id).parent().parent().addClass("selected-tr");
		$("#"+id).hide();
		$("#goods-remove-"+goodsId).show();
		//写入商品信息
		$("#goodsValue").val(goodsId + "-" + goodsName);
	}
	if(type == "取消选择"){
		$("#"+id).parent().parent().removeClass("selected-tr");
		$("#"+id).hide();
		$("#goods-add-"+goodsId).show();
		//清除商品信息
		$("#goodsValue").val("");
	}
}

$(".modal .modal-primary-btn").on("click", function () {
    var goodsValue = $("#goodsValue").val();
    if(goodsValue == false){
    	showToastr("请选择一个商品！");
    } else {
    	var goodsBox = $("#goodsBox").val();
    	$("#"+goodsBox).val(goodsValue);
    	$("#chooseGoodsModel").modal("hide");
    }
});

//清空商品
$(".modal .modal-clear-btn").on("click", function(){
	var goodsBox = $("#goodsBox").val();
	$("#"+goodsBox).val("");
	$("#chooseGoodsModel").modal("hide");
});

//解决回车键刷新页面问题
document.onkeydown = function () {
    if (window.event && window.event.keyCode == 13) {
        window.event.returnValue = false;
        initTable();
    }
}
