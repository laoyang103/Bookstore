
var inputUsernameIsOk = 0;//初始化为不可以
var inputPasswordIsOk = 0;//初始化为不可以
var inputCaptchaIsOk = 0;//初始化为不可以

var inputNoticeIsOk = 0;//初始化为不可以

function checkUsername(){
	var username = $("#regUsernameInputBox").val();
	//$.get("servlet的url",{参数名1:值1,***},回调函数(回调数据))
	$.get("checkUsername.do",{username:username},function(data){
		$("#checkResult").html(data);
		if(data == "<font color='green'>用户名不存在，可以注册</font>") {
			inputUsernameIsOk = 1;
		} else {
			inputUsernameIsOk = 0;//改为不可以
		}
	});
}

function checkPassword(){
	var password1=$("#password1").val();
	var password2=$("#password2").val();
	if(password1 == password2) {
		$("#result").html("<font color=green>两次密码一致</font>");
		inputPasswordIsOk = 1;
	} else {
		$("#result").html("<font color=red>两次密码不一致！</font>");
		inputPasswordIsOk = 0;//改为不可以
	}
}



function checkCaptcha() {
	var inputCaptcha = $("#captchaInputBox").val();
	$.get("checkCaptcha.do",{"inputCaptcha":inputCaptcha},function(data){
		$("#captchaResult").html(data);
		if(data == "<font color=green>验证码正确!</font>") {
			inputCaptchaIsOk = 1;
		} else {
			inputCaptchaIsOk = 0;//改为不可以
		}
	});
}


function saveData(){
	var username = $("#regUsernameInputBox").val();
	var password = $("#password1").val();
	var realname = $("#realname1").val();
	var address = $("#address1").val();
	var location = $("#province").val()+$("#city").val()+$("#area").val();
    var postcode = $("#postcode1").val();
    var telephone = $("#telephone1").val();
    
    if(inputUsernameIsOk==1&& inputPasswordIsOk==1 && inputCaptchaIsOk==1 && $("#realname1").hasInputNotes() == false && $("#address1").hasInputNotes() == false && $("#postcode1").hasInputNotes() == false && $("#telephone1").hasInputNotes() == false)
    {
    	$.get("addUser.do",{username:username,password:password,realname:realname,
    		address:address,location:location,postcode:postcode,telephone:telephone},
        	function(data){ 
        		showMsg(data);
        		window.setTimeout(function(){window.location.href = "index.jsp"},2000);

        	});
    }else{
    	showMsg("输入信息有误！");
    }
    
}

function userLogin(){
	var username = $("#username").val();
	var password = $("#password").val();
	$.get("login.do",{username:username,password:password},function(data){ 
		showMsg(data);
		if(data == "登录成功！") {
			window.setTimeout(function(){window.location.reload()},2000);
		}
	});
}
function logout(){
	$.get("logout.do",null,function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.href = "index.jsp"},1000);
	});
}

function alterpassword(){
	if($("#password1").hasInputNotes() == false && inputPasswordIsOk == 1){
		var username = $("#usernameInputBox").text();
		var password = $("#password1").val();
		$.get("alterPassword.do",{username:username,password:password},
    	function(data){ 
    		showMsg(data);
    		window.setTimeout(function(){window.location.href = "index.jsp"},1500);
		});
	} else {
		showMsg("<font color=yellow>输入有误,不能更改!</font>");
	}
}

function alterData(){
	if($("#realname1").hasInputNotes() == false && $("#postcode1").hasInputNotes() == false && $("#telephone1").hasInputNotes() == false) {
		var username = $("#usernameInputBox").text();
		var realname = $("#realname1").val();
		var address = $("#address1").val();
		var location = $("#province").val()+$("#city").val()+$("#area").val();
		var postcode = $("#postcode1").val();
		var telephone = $("#telephone1").val();
		$.get("alterUser.do",{username:username,realname:realname,address:address,location:location,
			postcode:postcode,telephone:telephone},
    		function(data){ 
				showMsg(data);
				window.setTimeout(function(){window.location.reload()},1500);
		});
	} else {
		showMsg("输入有误！");
	}
}

function backUserLogin(){
//alert("111");
	var username = $("#username").val();
	var password = $("#password").val();
	$.get("../backLogin.do",{username:username,password:password},function(data){ 
		showMsg(data);
		if(data == "登录成功！") {
			window.setTimeout(function(){window.location.href = "../manage/GoodsManage.jsp"},2000);
		}
	});
}

function mycheck(){
	checkNotice();
	
	if(inputNoticeIsOk == 1) {
		var title = $("#title").val();
		var content= $("#content").val();
		var pdate = $("#pdate").val();
		var edate = $("#edate").val();
		$.get("../addNotice.do",{title:title,content:content,pdate:pdate,edate:edate},function(data){
			showMsg(data);
			window.setTimeout(function(){window.location.href = "PlacardManage.jsp"},1500);
		});
		
	} else {
		showMsg("输入信息有误！");
	}
}

function alterNotice(){
	checkNotice();
	
	if(inputNoticeIsOk == 1) {
		var id = $("#id1").val();
		var title = $("#title").val();
		var content= $("#content").val();
		var pdate = $("#pdate").val();
		var edate = $("#edate").val();
		
		$.get("./alterNotice.do",{id:id,title:title,content:content,pdate:pdate,edate:edate},function(data){
			showMsg(data);
			window.setTimeout(function(){window.location.href = "./manage/PlacardManage.jsp"},1500);
		});
		
	} else {
		showMsg("输入信息有误！");
	}
	
}


//检查Notice
function checkNotice() {
	if($("#title").hasInputNotes() == false && $("#content").hasInputNotes() == false) {
		inputNoticeIsOk = 1;
	} else {
		inputNoticeIsOk = 0;
	}
}



//添加收藏
function addFavorite(productid) {
	$.get("addFavorite.do",{"productid":productid},function(data){
		showMsg("<font color=yellow>"+data+"</font>");
	});
}
//查找用户
function searchUser(){
	var id = $("#mid").val();
	var username = $("#mname").val();
	$.get("../searchUser.do",{id:id,username:username},null);	
}


//提交评论
function submitComment(content,productid) {
	$.get("submitComment.do",{"content":content,"productid":productid},function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.reload(true)},1500);
	});
}