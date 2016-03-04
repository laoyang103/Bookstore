//弹窗提示信息
function showMsg(data){
	dhtmlx.message({
		text: "<font size=4>"+data+"</font><br><br>",
		expire:2000
	});
}