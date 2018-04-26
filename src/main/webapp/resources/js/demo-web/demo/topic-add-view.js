/* topicAddView.vm自定义页面js */
var start = {
    elem: "#beginTime",
    format: "YYYY-MM-DD hh:mm:ss",
    // min: laydate.now(),
    max: "2099-06-16 23:59:59",
    istime: true,
    istoday: true,
    // choose: function(a) {
    //     end.min = a;
    //     end.start = a
    // }
};
var end = {
    elem: "#overTime",
    format: "YYYY-MM-DD hh:mm:ss",
    // min: laydate.now(),
    max: "2099-06-16 23:59:59",
    istime: true,
    istoday: true,
    // choose: function(a) {
    //     start.max = a
    // }
};
laydate(start);
laydate(end);


function showModel(id){
	$("#goodsBox").val(id);
	$("#chooseGoodsModel").modal("show");
}

//改变发布状态
function changeStatus(id){
	if(id == "status1" || id == "status2"){
		$("#startTimeDiv").hide("slow");
	}else{
		$("#startTimeDiv").show("slow");
	}
}
//改变下线时间
function changeDownTime(id){
	if(id == "forever"){
		$("#endTimeDiv").hide("slow");
	}else{
		$("#endTimeDiv").show("slow");
	}
}

/* 获取草稿模板 */
function getElementDraft(){
	var copy = $(".form-body").clone().appendTo(document.body);
	var elementDraft = copy.html();
	copy.remove();
	return elementDraft;
}

//判断时间合理性
function validateTime(start, end){
	start = start.replace(/-/g,"/");
	end = end.replace(/-/g,"/");
	var startDate = new Date(start);
	var endDate = new Date(end);
	var diff = endDate.getTime() - startDate.getTime();
	if(diff > 0){
		return true;
	}else{
		return false;
	}
}

//判断定时时间是否在当前时间n分钟内
function isBigerThanCurrentTime(strDate, times){
	strDate = strDate.replace(/-/g,"/");
	var ti = new Date(strDate);
	var now = new Date();
	var diff = ti.getTime() - now.getTime();
	if(diff > times){
		return true;
	}else{
		return false;
	}
}

//计算时间差
function getTotalTime(startDate,endDate) {  
	startDate = startDate.replace(/-/g,"/");
	endDate = endDate.replace(/-/g,"/");
	var start = new Date(startDate);
	var end = new Date(endDate);
    var diff=end.getTime() - start.getTime();//时间差的毫秒数  
    //计算出相差天数  
    var days=Math.floor(diff/(24*3600*1000));  
    //计算出小时数  
    var leave1=diff%(24*3600*1000);    //计算天数后剩余的毫秒数  
    var hours=Math.floor(leave1/(3600*1000));  
    //计算相差分钟数  
    var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数  
    var minutes=Math.floor(leave2/(60*1000));  
       
    //计算相差秒数  
    var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数  
    var seconds=Math.round(leave3/1000);  
      
    var returnStr = seconds + "秒";  
    if(minutes>0) {  
        returnStr = minutes + "分" + returnStr;  
    }  
    if(hours>0) {  
        returnStr = hours + "小时" + returnStr;  
    }  
    if(days>0) {  
        returnStr = days + "天" + returnStr;  
    }  
    return returnStr;  
}  
//获取当前时间字符串
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
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

function initPage(){
	//第一步：专题基本信息回写
	$("#hiddenId").val(specialTopic.id);
	$("#topicName").val(specialTopic.name);
	$("#topicType").val(specialTopic.type);
	$("#topicCover").attr("src",specialTopic.imgurl);
	$("input:radio[value='"+specialTopic.readingDisplay+"']").attr('checked','true');
	$("input:radio[value='"+specialTopic.status+"']").attr('checked','true');
	$("#shareImg").attr("src",specialTopic.shareImgUrl);
	$("#topImgUrlSpan").text(specialTopic.topImgUrl);
	if($("#status3").attr("checked")){
		$("#startTimeDiv").show();
		$("#beginTime").val(specialTopic.formatStartTime);
	}else{
		$("#startTimeDiv").hide();
	}
	if(specialTopic.endTime != null){
		$("#certainTime").attr("checked",true);
		$("#endTimeDiv").show();
		$("#overTime").val(specialTopic.formatEndTime);
	}else{
		$("#forever").attr("checked",true);
		$("#endTimeDiv").hide();
	}
	if(specialTopic.recommendTopics != null){
		var topics = new Array();
		topics = specialTopic.recommendTopics.split(",");
		$("#recommendTopics").selectpicker();
		$("#recommendTopics").selectpicker('val', topics);
		$("#recommendTopics").selectpicker('refresh');
	}
	//保存扩展字段内的内容，避免编辑时丢失
	$("#hiddenExtendInfo").val(specialTopic.extendInfo);
	//第二步：模板区域内容回写
	$(".form-body").html(specialTopic.elementDraft);
//	$(".form-body").append(specialTopic.elementDraft);
	var index = new Array();
	var contents = new Array();
	index = specialTopic.contentIndex.split(",");
	contents = specialTopic.topicContent.split(",@beauty@,");
	var num = 0;
	$("#contentDiv .info").each(function(){
		if(index[num] == "model-title-2" || index[num] == "model-text" || index[num] == "model-image" || index[num] == "model-goodsLink"){
			$(this).val(contents[num]);
		}
		if(index[num] == "model-image-span"){
			$(this).text(contents[num]);
		}
		if(index[num] == "model-goodsWaterfall"){
			var ids = new Array();
			ids = contents[num].split(",@waterfall@,");
			$(this).find(".model-goodsWaterfall-1").val(ids[0]);
			if(ids.length == 2){
				$(this).find(".model-goodsWaterfall-2").val(ids[1]);
			}
		}
		num += 1;
	});
	//第三步：更新模板区域内图片上传框id、单个商品id、商品瀑布id
	//图片上传框id
	var arrIds = new Array();
	$("#contentDiv .picfile").each(function(){
		arrIds.push($(this).attr("id"));
	});
	arrIds.sort();
	var imgId = arrIds[arrIds.length-1];
	if(imgId){
		imgId = imgId.split("-").slice(0, -1).join("-") + "-" + (parseInt(imgId.split("-").slice(-1)[0]) + 2);
        $(".contentModel .picfile").attr("id", imgId);
        $(".contentModel .picfileLabel").attr("for", imgId);
	}
	//单个商品id
	var singleGoodsIds = new Array();
	$("#contentDiv .single-goods").each(function(){
		singleGoodsIds.push($(this).attr("id"));
	});
	singleGoodsIds.sort();
	var singleGoodsId = singleGoodsIds[singleGoodsIds.length-1];
	if(singleGoodsId){
		singleGoodsId = singleGoodsId.split("-").slice(0, -1).join("-") + "-" + (parseInt(singleGoodsId.split("-").slice(-1)[0]) + 2);
		$(".contentModel .single-goods").attr("id", singleGoodsId);
	}
	//商品瀑布id
	var doubleGoodsIds = new Array();
	$("#contentDiv .double-goods").each(function(){
		doubleGoodsIds.push($(this).attr("id"));
	});
	doubleGoodsIds.sort();
	var doubleGoodsId = doubleGoodsIds[doubleGoodsIds.length-1];
	if(doubleGoodsId){
		doubleGoodsId = doubleGoodsId.split("-").slice(0, -1).join("-") + "-" + (parseInt(doubleGoodsId.split("-").slice(-1)[0]) + 2);
		var doubleGoodsId2 = doubleGoodsId.split("-").slice(0, -1).join("-") + "-" + (parseInt(doubleGoodsId.split("-").slice(-1)[0]) + 1);
        $(".contentModel .double-goods").attr("id", doubleGoodsId);
        $(".contentModel .model-goodsWaterfall-2").attr("id", doubleGoodsId2);
	}
	
}

/* 保存专题详情 */
$("#confirm").on("click",function(){
	$("#hiddenForm")[0].reset();
	$("#hiddenName").val($("#topicName").val());
	$("#hiddenType").val($("#topicType").val());
	$("#hiddenImgUrl").val($("#topicCover").attr("src"));
	$("#hiddenStatus").val($('input[name="topicStatus"]:checked').val());
	$("#hiddenReadingDisplay").val($('input[name="readingDisplay"]:checked').val());
	$("#hiddenRecommendTopics").val($("#recommendTopics").val());
	if($("#hiddenStatus").val() == "20"){//定时发布
    	$("#hiddenBeginTime").val($("#beginTime").val());
	}
	if($("#hiddenStatus").val() == "30"){//立即发布
		$("#hiddenBeginTime").val(getNowFormatDate());
	}
	if($('input[name="downTime"]:checked').attr("id") == "certainTime"){
    	$("#hiddenOverTime").val($("#overTime").val());
	}else{
		$("#hiddenOverTime").val("");
	}
	/*前端不再保存模型草稿，草稿统一由后端维护*///backup
	$("#hiddenElementDraft").val(getElementDraft());
	$("#hiddenContentIndex").val(getContent("index"));
	$("#hiddenTopicContent").val(getContent("content"));
	$("#hiddenTopImgUrl").val($("#topImgUrlSpan").text());
	$("#hiddenShareImgUrl").val($("#shareImg").attr("src"));
	if(check()){
		var statusStr = "";
		var uponTime = "";
		var downTime = "";
		var totalTime = "";
		var concatText = "";
		var topicName = "<span style='color:#1E90FF;'>"+$("#hiddenName").val()+"</span>";
		if($("#hiddenStatus").val() == "10"){
			statusStr = "放入草稿箱";
		}
		if($("#hiddenStatus").val() == "20" || $("#hiddenStatus").val() == "30"){
			if($("#hiddenStatus").val() == "20"){
    			statusStr = "定时发布";
			}else{
    			statusStr = "立即发布";
			}
			uponTime = "上线时间："+$("#hiddenBeginTime").val();
			if($("#hiddenOverTime").val() != false){
				downTime = "下线时间："+$("#hiddenOverTime").val();
				totalTime = "该专题共计在线："+getTotalTime($("#hiddenBeginTime").val(),$("#hiddenOverTime").val());
	    		concatText = "<p>"+topicName+"</p><p>"+uponTime+"</p><p>"+downTime+"</p><br/><p>"+totalTime+"</p>";
			}else{
				totalTime = "该专题不过期";
	    		concatText = "<p>"+topicName+"</p><p>"+uponTime+"</p><p>"+downTime+"</p><br/><p>"+totalTime+"</p>";
			}
		}
		swal({ title: "您确定将该专题<span style='color:red;'>"+statusStr+"</span>吗？",
            text: concatText,
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
	    		$("#hiddenForm").submit();
            }else {
                swal("已取消！", "您取消了操作！", "error");
            }
	    });
	}
	
});

/* 获取详情元素内容、顺序 */
function getContent(type){
	var index = new Array();
	var content = new Array();
	$("#contentDiv .info").each(function(){
		if($(this).hasClass("model-title-2")){
			index.push("model-title-2");
			content.push($(this).val());
			content.push("@beauty@");//分隔符
		}
		if($(this).hasClass("model-text")){
			index.push("model-text");
			content.push($(this).val());
			content.push("@beauty@");//分隔符
		}
		if($(this).hasClass("model-image-span")){
			index.push("model-image-span");
			content.push($(this).text());
			content.push("@beauty@");//分隔符
		}
		if($(this).hasClass("model-image")){
			index.push("model-image");
			content.push($(this).val());
			content.push("@beauty@");//分隔符
		}
		if($(this).hasClass("model-goodsLink")){
			index.push("model-goodsLink");
			content.push($(this).val());
			content.push("@beauty@");//分隔符
		}
		if($(this).hasClass("model-goodsWaterfall")){
			index.push("model-goodsWaterfall");
			content.push($(this).find(".model-goodsWaterfall-1").val());
			content.push("@waterfall@");//商品瀑布分隔符
			content.push($(this).find(".model-goodsWaterfall-2").val());
			content.push("@beauty@");//分隔符
		}
	});
	if(type == "index"){
		return index;
	} else {
		return content + ",";
	}
}


/* pc预览 */
function viewContent(){
	var content = "";
	/*var topicName = $("#topicName").val();
	if(topicName != ""){
		content = content + "<p style='font-size:20px;font-weight:bold;color:#333333;'>"+topicName+"</p>"
	}*/
	var topImgUrl = $("#topImgUrlSpan").text();
	if(topImgUrl != ""){
        content = content + "<p style='text-align:center;'><img src='"+topImgUrl+"' style='width:95%;height:auto;' /></p>";
	}
	$("#contentDiv .info").each(function(){
		if($(this).hasClass("model-title-2")){
			content = content + "<p style='font-size:15px;font-weight:bold;color:#333333;'>"+ $(this).val() + "</p>";
		}
		if($(this).hasClass("model-text")){
			content = content + "<p style='font-size:13px;color:#333333;'>"+ $(this).val() + "</p>";
		}
		if($(this).hasClass("model-image-span") && $(this).text() != ""){
			content = content + "<p style='text-align:center;'><img src='"+$(this).text()+"' style='width:95%;height:200px;' /></p>";
		}
		if($(this).hasClass("model-image") && $(this).val() != ""){
			content = content + "<p style='text-align:center;'><img src='"+$(this).val()+"' style='width:95%;height:200px;' /></p>";
		}
		if($(this).hasClass("model-goodsLink")){
			if($(this).val() != ""){
    			content = content + "<p style='text-align:center;'><img src='" + webRoot + "/resources/demopic/gotobuy.jpg' style='width:95%;height:70px;' /></p>";
			}
		}
		if($(this).hasClass("model-goodsWaterfall")){//$(this).find(".model-goodsWaterfall-1").val()
			content = content + "<p style='text-align:center;'>";
			if($(this).find(".model-goodsWaterfall-1").val() != ""){
				content = content + "<img src='" + webRoot + "/resources/demopic/goods-one.png' style='float:left;width:48%;height:210px;' />";
				if($(this).find(".model-goodsWaterfall-2").val() != ""){
					content = content + "<img src='" + webRoot + "/resources/demopic/goods-two.png' style='float:right;width:48%;height:210px;' />";
				}
			}
			content = content + "</p>";
			//间隔条
			content = content + "<p style='text-align:center;'><img src='" + webRoot + "/resources/demopic/white-bar.png' style='width:95%;' /></p>";
		}
	});
	if($('input[name="readingDisplay"]:checked').val() == "1"){
    	content = content + "<br><p style='text-align:center;'><img src='" + webRoot + "/resources/demopic/view.png' style='width:95%;height:20px;' /></p>";
	}
	if($("#recommendTopics").val() != null){
    	content = content + "<p style='text-align:center;'><img src='" + webRoot + "/resources/demopic/moretopic.png' style='width:95%;height:188px;' /></p>";
	}
	$("#viewContentDiv").html(content);
}

/* 表单校验 */
function check(){
	if($("#hiddenStatus").val() == "10"){//保存草稿
		if($("#hiddenName").val() == false){
			showToastr("保存草稿时，至少要输入专题名称！");
			return false;
		}
        var infoNum = 0;
        $("#contentDiv .info").each(function(){
            if($(this).hasClass("model-goodsLink") && $(this).val() == false){
                infoNum += 1;
                return false;//调出循环
            }
            if($(this).hasClass("model-goodsWaterfall") && $(this).find(".model-goodsWaterfall-1").val() == false){
                infoNum += 1;
                return false;//调出循环
            }
        });
        if(infoNum > 0){
            showToastr("草稿不允许插入空的商品模型，请移除！");
            return false;
        }
	}else{
		var arr = $("#hiddenImgUrl").val().split("/");
		var picName = arr[arr.length-1];
		var arr1 = $("#hiddenShareImgUrl").val().split("/");
		var picName1 = arr1[arr1.length-1];
		if($("#hiddenName").val() == false || picName == "default-cover.jpg" || picName1 == "default-share.jpg"){
			showToastr("存在未输入的专题基本信息！");
			return false;
		}
		if($("#hiddenStatus").val() == "20"){
			if($("#hiddenBeginTime").val() == false){
				showToastr("请选择上线时间！");
    			return false;
			}else{
				if(!isBigerThanCurrentTime($("#hiddenBeginTime").val(), 300000)){
					showToastr("无法发布5分钟内的定时上线专题！");
					return false;
				}
			}
		}
		if($('input[name="downTime"]:checked').attr("id") == "certainTime"){
			if($("#hiddenOverTime").val() == false){
				showToastr("请选择下线时间！");
    			return false;
			}else{
				if(!isBigerThanCurrentTime($("#hiddenOverTime").val(), 600000)){
					showToastr("无法发布10分钟内的定时下线专题！");
					return false;
				}
				
			}
		}
		if($('input[name="downTime"]:checked').attr("id") == "certainTime" 
				&& !validateTime($("#hiddenBeginTime").val(), $("#hiddenOverTime").val())){
			showToastr("下线时间必须大于上线时间！");
			return false;
		}
		if($("#hiddenTopImgUrl").val() == false){
            showToastr("请选择专题顶图！");
            return false;
		}
		if($("#hiddenTopicContent").val() == false){
			showToastr("不存在专题模板信息，不能发布专题！");
			return false;
		}
		var infoNum = 0;
		$("#contentDiv .info").each(function(){
			if(($(this).hasClass("model-title-2") || $(this).hasClass("model-text") || 
					$(this).hasClass("model-image") || $(this).hasClass("model-goodsLink")) && $(this).val() == false){
				infoNum += 1;
    			return false;//调出循环
			}
			if($(this).hasClass("model-image-span") && $(this).text() == false){
				infoNum += 1;
    			return false;//调出循环
			}
			if($(this).hasClass("model-goodsWaterfall") && $(this).find(".model-goodsWaterfall-1").val() == false){
				infoNum += 1;
				return false;//调出循环
			}
		});
		if(infoNum > 0){
			showToastr("存在未输入的模板信息，请输入或者移除！");
			return false;
		}
		//立即发布、定时发布模板内容必须包含商品
		var goodsNum = 0;
		$("#contentDiv .info").each(function(){
			if($(this).hasClass("model-goodsLink") || $(this).hasClass("model-goodsWaterfall")){
				goodsNum += 1;
				return false;
			}
		});
		if(goodsNum == 0){
			showToastr("立即发布、定时发布专题时，模板内容必须包含商品！");
			return false;
		}
		
	}
	return true;
}

var setup_draggable = function () {
    $(".draggable").draggable({
        appendTo: "body",
        helper: "clone"
    });
    $(".droppable").droppable({
        accept: ".draggable",
        helper: "clone",
        hoverClass: "droppable-active",
        drop: function (event, ui) {
            var $orig = $(ui.draggable)
            if (!$(ui.draggable).hasClass("dropped")) {
                var $el = $orig
                    .clone()
                    .addClass("dropped")
                    .css({
                        "position": "static",
                        "left": null,
                        "right": null
                    })
                    .appendTo(this);
                // update id
                var id = $orig.find(":input").attr("id");
                if (id) {
                    id = id.split("-").slice(0, -1).join("-") + "-" + (parseInt(id.split("-").slice(-1)[0]) + 2);
                    var id2 = id.split("-").slice(0, -1).join("-") + "-" + (parseInt(id.split("-").slice(-1)[0]) + 1);
                    $orig.find(":input").attr("id", id);
                    $orig.find(".model-goodsWaterfall-2").attr("id", id2);//2号商品id
                    $orig.find("label").attr("for", id);
                }
                // tools
                $('<p class="tools col-sm-12 col-sm-offset-3">\
                <a class="remove-link">移除</a></p>').appendTo($el);
            } else {
                if ($(this)[0] != $orig.parent()[0]) {
                    var $el = $orig
                        .clone()
                        .css({
                            "position": "static",
                            "left": null,
                            "right": null
                        })
                        .appendTo(this);
                    $orig.remove();
                }
            }
        }
    }).sortable();
}
