$(function() {
    $("#file_upload").uploadify({
    	'buttonText' : '请选择图片',
    	'formData'      : {'name' : ''},
        'swf'      : 'uploadify/uploadify.swf',
        'uploader' : 'upload.do',
        'onUploadStart' : function(file) {
            $("#file_upload").uploadify("settings", 'formData', {'name' : $("#inputFileName").val()});
        },
        'onUploadSuccess' : function(file, data, response) {
            showMsg('商品' + $("#bookID2").val() + '的图片成功上传！');
        }
    });
});