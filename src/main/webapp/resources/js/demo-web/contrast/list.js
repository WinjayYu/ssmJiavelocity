var firstInit = true;
$(function() {

	initSearchTime();
	initTable();
});

var currentPage;
var pageSize;
function initTable() {
	// 先销毁表格
	$("#tablelist").bootstrapTable("destroy");
	console.info(webRoot);
	// 初始化表格,动态从服务器加载数据
	$("#tablelist")
			.bootstrapTable(
					{
						url : webRoot + "/contrast/list-search",
						dataType : "json",
						method : "post",
						contentType : "application/x-www-form-urlencoded",
						cache : false,
						pagination : true,
						sidePagination : 'server',
						pageNumber : 1,
						pageSize : 50,
						pageList : [ 50, 100, 200 ],
						/*
						 * queryParamsType的默认值为 'limit' ,在默认情况下
						 * 传给服务端的参数为：offset,limit,sort 设置为 ''
						 * 在这种情况下传给服务器的参数为：pageSize,pageNumber
						 */
						queryParamsType : "",
						queryParams : function queryParams(params) {
							return $("#searcherForm").serialize()
									+ "&pageSize=" + params.pageSize
									+ "&pageNum=" + params.pageNumber;
						}

					});

	// 列表加载完成
	$("#tablelist").on('load-success.bs.table', function(data) {
		firstInit = false;
	});

}

function initSelecter() {
	if (condition.type == null || condition.type == undefined) {
		return;
	} else {
		$("[name='row.paymentSystem'] [value='" + condition.type + "']").attr(
				"selected", "selected");
	}

}

function dateFormatter(value, row, index) {
	var newValue = new Date(value).format("yyyy-MM-dd hh:mm:ss");
	return '<div style="min-width:64px">' + newValue + '</div>';
}

function settingFormatter(value, row, index) {
	var htmlText = '&nbsp;&nbsp;&nbsp;&nbsp;<a data-id="'
			+ 1
			+ '" data-setting-type="modify" class="btn btn-primary btn-xs" type="button"><i class="fa fa-paste"></i> <span class="bold">修改</span> </a>';
	return value;
}

// 初始化查询时间
function initSearchTime() {
	var start = {
		elem : "#billDate",
		format : "YYYY-MM-DD",
		max : "2099-06-16",
		istime : true,
		istoday : true,
		choose : function(a) {
		}
	};

	laydate(start);

}
