$(function() {
    $("#file_upload").uploadify({
    	'buttonText' : '请选择图片',
    	'formData'      : {'name' : ''},
        'swf'      : '../uploadify/uploadify.swf',
        'uploader' : '../upload.do',
        'onUploadStart' : function(file) {
            $("#file_upload").uploadify("settings", 'formData', {'name' : $("#productname").val()});
        },
        'onUploadSuccess' : function(file, data, response) {
        	showMsg('商品图片成功上传！');
        }
    });
});