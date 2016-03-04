var ifInputProductInfoIsOk = 0;//初始化为有误

//加载大小类级联select【商品修改】
function loadSuperCategorySelect4Modify() {
	$.getJSON("getCategoriesByPid.do",{"pid":0},function(data){
//		alert(data.length);
		for(var i=0;i<data.length;i++){
			$("#supertype").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
	//初始化小类
	$.getJSON("getCategoriesByPid.do",{"pid":1},function(data){
		$("#typeID").empty();
		for(var i=0;i<data.length;i++){
			$("#typeID").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
}



//通过大类select拿子类select【商品修改】
function loadSubCategorySelect4Modify(pid) {
	$.getJSON("getCategoriesByPid.do",{"pid":pid},function(data){
		$("#typeID").empty();
		for(var i=0;i<data.length;i++){
			$("#typeID").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
}

//保存对商品的更改【商品修改】
function saveGoodsModify4Modify() {
	checkInputProductInfo();
	if(ifInputProductInfoIsOk == 1) {
		var productid = $("#productid").val();
		var categoryid = $("#typeID").val();
		var productname = $("#productname").val();
		var normalprice = $("#normalprice").val();
		var memberprice = $("#memberprice").val();
		var ifspecial = $(":radio:checked").val();
		var desr = $("#desr").val();
//		showMsg(productname);
		$.get("alterProduct.do",{productid:productid,categoryid:categoryid,productname:productname,normalprice:normalprice,memberprice:memberprice,ifspecial:ifspecial,desr:desr},function(data){
			showMsg(data);
			window.setTimeout(function(){window.location.href = "manage/GoodsManage.jsp"},1000);
		});
		
	} else {
		showMsg("输入的信息有误！");
	}
	
}

/*
/*
/*
/**/

//加载大小类级联select【新增商品】
function loadSuperCategorySelect() {
	$.getJSON("../getCategoriesByPid.do",{"pid":0},function(data){
//		alert(data.length);
		for(var i=0;i<data.length;i++){
			$("#supertype").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
	//初始化小类
	$.getJSON("../getCategoriesByPid.do",{"pid":1},function(data){
		$("#typeID").empty();
		for(var i=0;i<data.length;i++){
			$("#typeID").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
}

//通过大类select拿子类select【新增商品】
function loadSubCategorySelect(pid) {
	$.getJSON("../getCategoriesByPid.do",{"pid":pid},function(data){
		$("#typeID").empty();
		for(var i=0;i<data.length;i++){
			$("#typeID").append(
				"<option value="+data[i].id+">"+data[i].name+"</option>	"
			);
		}
	});
}


//保存对商品的更改【新增商品】
function saveGood() {
	checkInputProductInfo();
	if(ifInputProductInfoIsOk == 1) {
		var productid = $("#productid").val();
		var categoryid = $("#typeID").val();
		var productname = $("#productname").val();
		var normalprice = $("#normalprice").val();
		var memberprice = $("#memberprice").val();
		var ifspecial = $(":radio:checked").val();
		var img = $("#productname").val();//就改为商品名相同
		var desr = $("#desr").val();
//		showMsg(img);
		$.get("../addProduct.do",{productid:productid,categoryid:categoryid,productname:productname,normalprice:normalprice,memberprice:memberprice,ifspecial:ifspecial,img:img,desr:desr},function(data){
			showMsg(data);
			window.setTimeout(function(){window.location.href = "GoodsManage.jsp"},1000);
		});
		
	} else {
		showMsg("输入的信息有误！");
	}
}


function checkInputProductInfo(){
	if($("#normalprice").hasInputNotes() == false && $("#memberprice").hasInputNotes() == false && $("#goodsName").hasInputNotes() == false) {
		ifInputProductInfoIsOk = 1;//OK
	} else {
		ifInputProductInfoIsOk = 0;//No OK
	}
}

/*
/*
/*商品操作
/**/


//补货
function addProductAmount(productid) {
	
	$.get("../addProductAmount.do",{productid:productid},function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.reload()},1000);
	});
}

//搜索结果页的补货
function addProductAmount4SearchResult(productid) {
	
	$.get("./addProductAmount.do",{productid:productid},function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.reload()},1000);
	});
}

//删货
function deleteProduct(productid) {
	$.get("../deleteProduct.do",{productid:productid},function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.reload()},1000);
	});
}

//搜索结果页的删货
function deleteProduct4SearchResult(productid) {
	$.get("./deleteProduct.do",{productid:productid},function(data){
		showMsg(data);
		window.setTimeout(function(){window.location.reload()},1000);
	});
}


//添加商品分类
function addCategory(pid){
	var name = $("#typename").val();
	var desr = $("#desr").val();
	$.get("../addCategory.do",{"pid":pid,"name":name,"desr":desr},function(data){
		showMsg(data);
		if(pid == 0){
			window.setTimeout(function(){window.location = "ParameterManage.jsp"},1000);
		} else {
			window.setTimeout(function(){window.location = "../showSubCategorys.do?pid="+pid},1000);
		}
	});
}

//修改分类
function modifyCategory(id,url) {
//	alert(url);
	var name = $("#typename").val();
	var desr = $("#desr").val();
	$.get("../modifyCategory.do",{"id":id,"name":name,"desr":desr},function(data){
		showMsg(data);
		if(url == "ParameterManage.jsp") {
			window.setTimeout(function(){window.location = url},1000);
		} else {
			window.setTimeout(function(){window.location = "../"+url},1000);
		}
	});
}

//删除
function deleteCategory(id,url) {
//	alert("111");
	var path = "deleteCategory.do";
	if(url == "ParameterManage.jsp"){
		path = "../deleteCategory.do";
	}
	$.get(path,{"id":id},function(data){
			showMsg(data);
			window.setTimeout(function(){window.location = url},1000);
	});
}