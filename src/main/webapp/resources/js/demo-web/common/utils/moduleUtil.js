$(document).on("mouseover", ".module-frame", function () {
    $(this).find(".module-close").show();
});

$(document).on("mouseout", ".module-frame", function () {
    $(this).find(".module-close").hide();
});
$(document).on("click", ".module-close a", function () {
    $(this).closest(".module-frame").remove();
    $("#banners-file").val("");
    $("#deatils-file").val("");
    return false;   
});

$('.banners').on("mousedown",".module-close a",function () {
    return false;
})

$('.details').on("mousedown",".module-close a",function () {
    return false;
})

moduleBlock = {};
moduleBlock.image = function (src) {
    var html = 
        '<div data-module-type="image" class="module-frame animated fadeInRight">' +
            '<div class="module-close">' +
                '<a style="display:block;width: 35px;height: 100%;float: right;">' +
                    '<i class="iconfont icon-remove" style="padding-left:10px"></i>' +
                '</a>' +
            '</div>' +
            '<img class="module-image" src=" ' + src + ' " />' +
        '</div>';
    return html;
}

moduleBlock.description = function (value) {
    if(value == null || value == undefined) {
        value = "";
    }
    var html = 
        '<div data-module-type="description" class="module-frame animated fadeInRight">' + 
            '<div class="module-close">' + 
                '<a style="display:block;width: 35px;height: 100%;float: right;">' + 
                    '<i class="iconfont icon-remove" style="padding-left:10px"></i>' + 
                '</a>' + 
            '</div>' + 
            '<textarea class="form-control module-description" aria-required="true">' + value + '</textarea>' + 
        '</div>'
    return html;
}

moduleBlock.getModuleValue = function (node) {
    var $node = node;
    var value = {};
    value.value= {};
    if(!(node instanceof jQuery))
        $node = $(node);
    var moduleType = $node.data("module-type");
    value.valueType = moduleType;
    
    if(moduleType === "image")
        value.value.imgUrl = $node.find("img").attr("src");
    else if(moduleType === "description") 
        value.value.description = $node.find("textarea").val();
    
    return value;
}