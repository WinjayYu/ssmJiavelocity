$(function() {

	var webRoot = "$webRoot";
	initSelecter();
	//调用函数，初始化表格 
	initAliTable();
});

function initSelecter() {

}

var firstInit = true;
var pageNum;
var pageSize;
function initAliTable() {
	var table = "";
	if($("#paySystem").val() == 1){
		var table = "aliTable";
	}else if($("#paySystem").val() == 2){
		var table = "wechatTable";
	}else if($("#paySystem").val() == 3){
		var table = "netTable";
	}
	//先销毁表格  
	destoryAllTable(table);
	//初始化表格,动态从服务器加载数据  
	$("#" + table).bootstrapTable({
		url : webRoot + "/contrast/listsearch",
		dataType : "json",
		method : "post",
		contentType : "application/x-www-form-urlencoded",
		striped : true, //表格显示条纹
		showColumns : false, //显示隐藏列
		cache : false,
		pagination : true,//启动分页
		sidePagination : 'server',//表示服务端请求
		pageNumber:1,//初始化加载第一页，默认第一页
        pageSize:50,
        pageList:[50,100,200],
		paginationPreText : "上一页",
		paginationNextText : "下一页",
		/* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
        	设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
		queryParamsType : "",
		queryParams : function queryParams(params) {
			return $("#searcherForm").serialize() + "&pageSize=" + params.pageSize + "&pageNum=" + params.pageNumber;
		}
	});
	firstInit = false;
}


//初始化查询时间
function initSearchTime() {
	var start = {
		elem : "#startDate",
		format : "YYYY-MM-DD hh:mm:ss",
		max : "2099-06-16 23:59:59",
		istime : true,
		istoday : false,
		choose : function(a) {
		}
	};
	laydate(start);
}

function dateFormatter(value, row, index) {
	var newValue = new Date(value).format("yyyy-MM-dd hh:mm:ss");
	return '<div style="min-width:64px">' + newValue + '</div>';
}

/**
 * 因为这个对账单详情页面有三个table，
 * 所以在渲染表格的时候需要先销毁三个表格，并设置三个表格为隐藏，并设置渲染的表格为显示
 * (￣ー￣)好low啊
 * 遍历 高了一个层次
 * @param table
 */
function destoryAllTable(table){
	$("table").each(function(){
		$(this).bootstrapTable("destroy");
		$(this).css("visibility","hidden");
	});
//	$("#aliTable").bootstrapTable("destroy");
//	$("#aliTable").css("visibility","hidden");
//	$("#netTable").bootstrapTable("destroy");
//	$("#netTable").css("visibility","hidden");
//	$("#wechatTable").bootstrapTable("destroy");
//	$("#wechatTable").css("visibility","hidden");
	$("#" + table).css("visibility","visible");
}


//查询
$(document).on("click", "form .search-btn", function () {
	initAliTable();
});

//清空
$(document).on("click", "form .clean-btn", function () {
    window.location.href = webRoot + "/contrast/paymentdata";
    
});
