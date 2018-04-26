/* recListView.vm自定义页面js */ 
$("#missionHallBtn").on("click", function(){
	$("#missionHallModel").modal("show");
});
$("#outerLinkBtn").on("click", function(){
	$("#outerLinkModel").modal("show");
});
$("#topicBtn").on("click", function(){
	$("#specialTopicModel").modal("show");
});
$("#mAddSubmit").on("click", function(){
	$("#mImgUrl").val($("#missionHallCover").attr("src"));
	$("#mSorting").val($("#mSort").val());
	if($("#mImgUrl").val() == "" || $("#mSorting").val() == ""){
		showToastr("请完善信息！");
	}else{
		if(!isNumber($("#mSorting").val())){
			showToastr("排序只能输入正整数！")
		}else{
			ajaxForm( webRoot + "/topic/recommend/saveRecommend","POST",$("#hiddenMissionHallForm").serialize(),function (ret, stats) {
				if (stats == "success") {
					if(ret.code === 200) {
						initTable();
						$("#missionHallModel").modal("hide");
					}else{
						showToastr(ret.error);
					}
				}
			});
		}
	}
});
$("#oAddSubmit").on("click", function(){
	$("#oImgUrl").val($("#outerLinkCover").attr("src"));
	$("#oSorting").val($("#oSort").val());
	$("#oUrl").val($("#oUrlText").val());
	if($("#oImgUrl").val() == "" || $("#oSorting").val() == "" || $("#oUrl").val() == ""){
		showToastr("请完善信息！");
	}else{
		if(!isNumber($("#oSorting").val())){
			showToastr("排序只能输入正整数！")
		}else{
			ajaxForm( webRoot + "/topic/recommend/saveRecommend","POST",$("#hiddenOuterLinkForm").serialize(),function (ret, stats) {
				if (stats == "success") {
					if(ret.code === 200) {
						initTable();
						$("#outerLinkModel").modal("hide");
					}else{
						showToastr(ret.error);
					}
				}
			});
		}
	}
});
$("#sAddSubmit").on("click", function(){
	$("#sTopicId").val($("#recommendTopic").val());
	$("#sSorting").val($("#sSort").val());
	if($("#sTopicId").val() == "" || $("#sSorting").val() == ""){
		showToastr("请完善信息！");
	}else{
		if(!isNumber($("#sSorting").val())){
			showToastr("排序只能输入正整数！")
		}else{
			ajaxForm( webRoot + "/topic/recommend/saveRecommend","POST",$("#hiddenSpecialTopicForm").serialize(),function (ret, stats) {
				if (stats == "success") {
					if(ret.code === 200) {
						initTable();
						$("#specialTopicModel").modal("hide");
					}else{
						showToastr(ret.error);
					}
				}
			});
		}
	}
});

function isNumber(num) {
	var r = /^\+?[1-9][0-9]*$/;//正整数
    return r.test(num);
}

$(function(){
	initTable();
	var imgurl = webRoot + "/resources/demopic/default-cover.jpg";
	$("#missionHallModel").on("hide.bs.modal",function(){
		$("#missionHallCover").attr("src",imgurl);
		$('.mission-clear').val("");
	});
	$("#outerLinkModel").on("hide.bs.modal",function(){
		$("#outerLinkCover").attr("src",imgurl);
		$('.outer-clear').val("");
	});
	$("#specialTopicModel").on("hide.bs.modal",function(){
		$('#recommendTopic').selectpicker('deselectAll');
		$('.topic-clear').val("");
	});
});

var selecturl = webRoot + "/topic/recommend/listSearch";
//$('.searcherButton').click(function(){
//	initTable();
//});
//
//$('.clearSearchButton').click(function(){
//   	$('#searcherForm')[0].reset();  
//   	initTable();
//});

function initTable(){
	$("#table").bootstrapTable('destroy');
    $("#table").bootstrapTable({
    	url: selecturl,
    	dataType: "json",
        method: "post",
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        pagination:true,
        pageSize:50,
        pageList:[50,100,200],
        sidePagination:'server',
        queryParams: function queryParams(params) {
            return $("#searcherForm").serialize() + "&pager.pageSize=" + params.limit + "&pager.pageNum=" + (params.offset/params.limit + 1);
        }
    });
}

/**
 * 操作列：编辑（可扩展）
 */
function settingFormatter(value, row, index) {
	var type = row.type;
	var delFlag = $("#delFlag").val();
	var btn="";
	var del = '<a class="del btn btn-danger btn-xs" href="javascript:void(0)" title="删除"><i class="fa fa-times-circle"></i>&nbsp;删除</a> ';
	var recovery = '<a class="recovery btn btn-primary btn-xs" href="javascript:void(0)" title="恢复"><i class="fa fa-reply"></i>&nbsp;恢复</a> ';
	var moreinfo = '<a class="moreinfo btn btn-primary btn-xs" href="javascript:void(0)" title="更多信息"><i class="fa fa-info-circle"></i>&nbsp;更多信息</a> ';
	if(delFlag == "0"){
		if(type == "1"){//任务大厅
			btn = btn + del;
		}else{
			btn = btn + moreinfo + del;
		}
	}else{
		if(type == "1"){//任务大厅
			btn = btn + recovery;
		}else{
			btn = btn + moreinfo + recovery;
		}
	}
	return ['<div class="pull-left">',btn,'</div>'].join('');
}

/**
 * bootstrap table 按钮事件
 */
window.operateEvents = {
		'click .del': function (e, value, row, index) {
			swal({ title: "您确定将该推荐<span style='color:red;'>删除</span>吗？",
				text:"<span style='color:#1E90FF;'>ID："+row.id+"</span>",
                type: "warning",
                html: true,
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确认 ",
                cancelButtonText: "取消",
                closeOnConfirm: true,
                closeOnCancel: false
            },
            function(isConfirm) {
                if (isConfirm) {
                	ajaxForm(webRoot + "/topic/recommend/del","POST",{id:row.id},function (ret, stats) {
                        if (stats == "success") {
                            if(ret.code === 200) {
                                initTable();
                            }else{
                            	showToastr(ret.error);
                            }
                        }
                    });
                }else {
                    swal("已取消！", "您取消了操作！", "error");
	            }
		    });
		},
		'click .recovery': function (e, value, row, index) {
			swal({ title: "您确定将该推荐<span style='color:red;'>恢复</span>吗？",
				text:"<span style='color:#1E90FF;'>ID："+row.id+"</span>",
                type: "warning",
                html: true,
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确认 ",
                cancelButtonText: "取消",
                closeOnConfirm: true,
                closeOnCancel: false
            },
            function(isConfirm) {
                if (isConfirm) {
                	ajaxForm(webRoot + "/topic/recommend/recovery","POST",{id:row.id},function (ret, stats) {
                        if (stats == "success") {
                            if(ret.code === 200) {
                                initTable();
                            }else{
                            	showToastr(ret.error);
                            }
                        }
                    });
                }else {
                    swal("已取消！", "您取消了操作！", "error");
	            }
		    });
		},
		'click .moreinfo': function (e, value, row, index) {
			var type = row.type;
			var content = "<span style='color:#836FFF;'>";
			if(type == "2"){
				content = content + "URL链接："+row.url;
			}
			if(type == "3"){
				content = content + "专题ID：" + row.topicId + "<br>" +
				"专题名称：" + row.topicName;
			}
			content = content + "</span>";
			swal({
				title:"更多信息",
                text: content,
                html: true
            })
		}
		
}

function settingImgUrl(value, row, index) {
	var img = '<img src="'+row.imgUrl+'" class="sysimg"/>';
	return ['<div class="pull-left">',img,'</div>'].join('');
}
//更新status、delFlag
function changeTab(delFlag){
	$('#searcherForm')[0].reset();  
	$("#delFlag").val(delFlag);
   	initTable();
   	if(delFlag == "0"){
   		$("#btnBar").show("slow");
   	}else{
   		$("#btnBar").hide("slow");
   	}
}

//消息提示框
function showToastr(content) {
    var toast = {};
    toast.showToastr = 'Y';
    toast.toastrType = 'error';
    toast.toastrTitle = '';
    toast.toastrContent = content;
    showToast(toast);
}

