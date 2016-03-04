
/* 购物车部分 */

function addCart(productId) {
	//判断剩余数目是否>0
	$.get("checkProductIfExists.do",{"productId":productId},function(data){
		if (data == "无货") {
			showMsg("<font color=yellow>抱歉，此商品目前缺货~</font>");
		} else {
			$.get("addCart.do",{"productId":productId},function(data){
				if(data == "加入购物车失败！") {
					showMsg(data);
				} else {
					showMsg(data);
				}
			});
		}
	});	
}

function deleteCartItem(productId) {
	$.get("deleteCartItem.do",{"productId":productId},function(data){
		showMsg(data);
		initCart();
	});
}

function clearCart() {
	$.get("clearCart.do",null,function(data){
		if(data.length>0) {
			showMsg(data);
			initCart();
		}
	});
}

function saveAmountChange(productId) {
	var newAmount = event.target.value;
//	showMsg(isNaN(newAmount));
	if(isNaN(newAmount) == true){
		showMsg("必须是数字哦！！");
	} else {
		$.get("saveAmountChange.do",{"productId":productId,"newAmount":newAmount},function(data){
			if(data == "修改成功") {
				showMsg(data);
				initCart();
			}
		});
	}	
}


// 初始化购物车
function initCart() {
//	alert("11111");
	$.getJSON("showCart.do",function(data){
		if(data.length>0) {
			$("#cartTable").html("<tr align='center' valign='middle'><td height='27' class='tableBorder_B1'>编号</td><td class='tableBorder_B1'>商品名称</td><td class='tableBorder_B1'>市场价</td><td class='tableBorder_B1'>商城价</td><td class='tableBorder_B1'>折扣</td><td class='tableBorder_B1'>数量</td><td class='tableBorder_B1'>退回</td></tr>");
			var nomalTotalize = 0;
			var memberTotalize = 0;
			for(var i = 0;i<data.length;i++){
				var id = data[i].id;
				var productName = data[i].productName;
				var nomalPrice = data[i].nomalPrice;
				var memberPrice = data[i].memberPrice;
				var amount = data[i].amount;
				var nomalItemTotalMoney = data[i].nomalItemTotalMoney;
				var memberItemTotalMoney = data[i].memberItemTotalMoney;
			
				nomalTotalize += nomalItemTotalMoney;
				memberTotalize += memberItemTotalMoney;
				$("#cartTable").append("<tr align='center' valign='middle'><td height='27'>"+(i+1)+"</td><td ><a href=\"showProductDetail.do?id="+id+"\">"+productName+"</a></td><td style='text-decoration:line-through;'>￥"+nomalPrice+"</td><td style='color:#FF0000'>￥"+memberPrice+"</td><td>"+Math.ceil((memberPrice/nomalPrice)*100)+"%</td><td ><input size='4' maxlength='4' type='text' class='txt_grey' value="+amount+" onchange='saveAmountChange("+id+")'></td><td><img id='deleteCartItemButton' onclick='deleteCartItem("+id+")' src='images/del.gif' width='16' height='16'></td></tr>");
			}
			$("#cartTable").append("<tr align='center' valign='middle'><td colspan=2 align='right'>总计</td><td style='text-decoration:line-through;'>￥"+nomalTotalize+"</td><td style='color:#FF0000'>￥"+memberTotalize+"</td><td colspan=3><input type='button' class='button' value='更新数量'></td></tr>");
		} else {
			$("#bottomTable").empty();
			$("#cartTable").html("购物车中没有商品~~");
		}
	});
}

//初始化checkout，设置checked属性
function initCart_checkout() {
	$("input[name=paymethod]").get(0).checked = true;
	$("input[name=recievemethod]").get(0).checked = true;
	$("input[name=timedemand]").get(0).checked = true;
}


/*订单提交部分*/
//修改收货地址
function modifyAddress() {
	var modifyAddressButtonValue = $("#modifyAddressButton").val();
	var addressItem = $(".addressItem");
	
	if (modifyAddressButtonValue == "修改") {
		$("#modifyAddressButton").val("保存");
		for ( var i = 0; i < addressItem.length; i++) {
			var item = addressItem.eq(i);
			var itemValue = item.html();
			item.html("<input class='addressNewItem' type='text' value='" + itemValue + "'>");
		}
	} else {
		$("#modifyAddressButton").val("修改");
		for ( var i = 0; i < addressItem.length; i++) {
			var item = addressItem.eq(i);
			var itemNewValue = item.children().val();
			item.html(itemNewValue);
		}
	}
}

//提交购物车生成订单
function submitCart() {
	var re = /^[0-9]+$/;
	if($("#modifyAddressButton").val() == "保存") {
		showMsg("<font color=yellow>你修改的送货地址还没保存，不能提交哦！</font>");
	} else {
		var addressItem = $(".addressItem");
		var recievename = addressItem.eq(0).html();
		var address = addressItem.eq(1).html();
		var postcode = addressItem.eq(2).html();
		var phone = addressItem.eq(3).html();
		var paymethod = $(":radio[name*='paymethod']:checked").val();
		var recievemethod = $(":radio[name*='recievemethod']:checked").val();
		var timedemand = $(":radio[name*='timedemand']:checked").val();
		var remark = $("#bz").val();
	
		$.get("submitCart.do",{"recievename":recievename,"address":address,"postcode":postcode,"phone":phone,"paymethod":paymethod,"recievemethod":recievemethod,"timedemand":timedemand,"remark":remark},function(data){
			showMsg("正在为您提交订单......");
			if(data == "订单提交成功") {
				showMsg(data);
				clearCart();
				window.setTimeout(function(){window.location = "order.jsp"},1000);
			}else{
				showMsg(data);
			}
		});
	}
}


/*订单操作部分*/
//初始化订单列表
function initOrder(page,singlePageCount) {
	$("#orderTable").html("你还没有订单~~");
	$.getJSON("showOrders.do",{"page":page,"singlePageCount":singlePageCount},function(data){
		
		if(data.length>0) {
			$("#orderTable").html(
			"<tr align='center' >"+
            	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
            	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
            	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
            	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
            	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
           "</tr>");
			
			
			for(var i = 0;i<data.length;i++){
				var orderid = data[i].orderid;
				var pdate = data[i].pdate;
				var recievename = data[i].recievename;
				var items = data[i].items;
				var status = data[i].status;
					if(status == 1){
						status = "<font color=red>新订单</font><input  type='button' class='btn_grey' value='取消此订单' onclick='deleteOrder(\""+orderid+"\")'>";
					}else{
						status = "已配送";
					}
				
				$("#orderTable").append(
						"<tr align='center' >"+
							"<td class='tableBorder_B_dashed'><a href='showOrderDetail.do?orderid="+orderid+"&flag=normal'>"+orderid+"</a></td>"+
							"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
							"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
							"<td class='tableBorder_B_dashed'>"+
								items+
							"</td>"+
							"<td class='tableBorder_B_dashed'>"+status+"</td>"+
						"</tr>");
			}
			
		}
		
		if($("#orderTable").html() == "") {
			$("#orderTable").html("你还没有订单");
		}
		
	});
}


//删除订单
function deleteOrder(orderid) {
	$.get("deleteOrder.do",{"orderid":orderid},function(data){
		if(data == "订单删除成功"){
			showMsg(data);
			initOrder(1,5);
		}else{
			showMsg(data);
		}
	});
}


/*管理员部分*/

//初始化订单管理页面
function initOrderManage(status,page,singlePageCount) {
	$("#orderTable").html("Loading......");
	
	//显示所有类型
	if(status == 0) {
	$.getJSON("../showAllOrders.do",{"page":page,"singlePageCount":singlePageCount},function(data){
		
		if(data.length>0) {
			$("#orderTable").html(
			"<tr align='center' >"+
            	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
            	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
            	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
            	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
            	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
           "</tr>");
			
			
			for(var i = 0;i<data.length;i++){
				var orderid = data[i].orderid;
				var pdate = data[i].pdate;
				var recievename = data[i].recievename;
				var items = data[i].items;
				var status = data[i].status;
					if(status == 1){
						status = "<font color=red>新订单</font>";
					}else{
						status = "已配送";
					}
				
				$("#orderTable").append(
						"<tr align='center' >"+
							"<td class='tableBorder_B_dashed'><a href='../showOrderDetail.do?orderid="+orderid+"&flag=admin'>"+orderid+"</a></td>"+
							"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
							"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
							"<td class='tableBorder_B_dashed'>"+
								items+
							"</td>"+
							"<td class='tableBorder_B_dashed'>"+status+"</td>"+
						"</tr>");
			}
			
		}

		if($("#orderTable").html() == "") {
			$("#orderTable").html("你还没有订单");
		}
		
	});
	
	} else {
		//显示搜索的订单
		$.getJSON("../searchOrder.do",{"status":status,"page":page,"singlePageCount":singlePageCount},function(data){
			
			if(data.length>0) {
				$("#orderTable").html(
				"<tr align='center' >"+
	            	"<td width='15%' height='30' class='tableBorder_B_dashed'>订单号</td>"+
	            	"<td width='25%' class='tableBorder_B_dashed'>订单时间</td>"+
	            	"<td width='15%' class='tableBorder_B_dashed'>收货人</td>"+
	            	" <td width='35%' class='tableBorder_B_dashed'>订单商品</td>"+
	            	"<td width='10%' class='tableBorder_B_dashed'>订单状态</td>"+
	           "</tr>");
				
				
				for(var i = 0;i<data.length;i++){
					var orderid = data[i].orderid;
					var pdate = data[i].pdate;
					var recievename = data[i].recievename;
					var items = data[i].items;
					var status = data[i].status;
						if(status == 1){
							status = "<font color=red>新订单</font>";
						}else{
							status = "已配送";
						}
					
					$("#orderTable").append(
							"<tr align='center' >"+
								"<td class='tableBorder_B_dashed'><a href='../showOrderDetail.do?orderid="+orderid+"&flag=admin'>"+orderid+"</a></td>"+
								"<td class='tableBorder_B_dashed'>"+pdate+"</td>"+
								"<td class='tableBorder_B_dashed'>"+recievename+"</td>"+
								"<td class='tableBorder_B_dashed'>"+
									items+
								"</td>"+
								"<td class='tableBorder_B_dashed'>"+status+"</td>"+
							"</tr>");
				}
				
			}

			if($("#orderTable").html() == "") {
				$("#orderTable").html("你还没有订单");
			}
			
		});
	}
}

//关闭订单
function closeOrder(orderid) {
	$.get("deleteOrder.do",{"orderid":orderid},function(data){
		showMsg(data);
		if(data == "订单删除成功"){
			window.setTimeout(function(){window.location = "manage/OrderManage.jsp"},1000);
		}
	});
}

//发货
function sendoutOrder(orderid) {

	$.get("sendoutOrder.do",{"orderid":orderid},function(data){
		showMsg(data);
		if(data == "发货成功"){
			window.setTimeout(function(){window.location = "manage/OrderManage.jsp"},1000);
		}
	});
}