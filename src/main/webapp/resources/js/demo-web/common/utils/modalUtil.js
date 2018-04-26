
function loadModal(title,width,url,data,callFun) {
    
    var init = initModal(title,width);
    var modalBodyId = init[0];
    var modalId = init[1];
    
    $("#"+modalBodyId).load(url,data,function(response,status,xhr){
        if(status == "error"){
            console.log(xhr.responseText);
        } else {
        	if(callFun == null || callFun == undefined){
        		callFun = function () {};
        	}
        	callFun();
        }
    });
    
    $('#'+modalId).modal({backdrop: 'static'},'show');
}

function closeModal() {
    $(".modal-close-btn").click();
}

function initModal(title,width) {
    var modalId = "modal_" + ($(document).find("div.model").length * 1 + 1 * 1);
    var modalBodyId = "modal_body_" + ($(document).find(".modal .modal-body").length * 1 + 1 * 1);
    $("#"+modalId).detach();
    var modalHtml = 
        '<div class="modal fade" id="' + modalId + '" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">' +
            '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                    '<div class="modal-header">' +
                        '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                        '<h4 class="modal-title" id="myModalLabel">' + title + '</h4>' +
                    '</div>' +
                    '<div id="' + modalBodyId + '" class="modal-body"></div>' +
                    '<div class="modal-footer">' +
                        '<a class="btn btn-primary modal-primary-btn save" >确认</a>' +
                        '<a class="btn btn-default modal-close-btn" data-dismiss="modal" >关闭</a>' +
                    '</div>' +
                '</div>' +
            '</div>' +
        '</div>';
    $(document.body).append(modalHtml);
    return [modalBodyId,modalId];
}