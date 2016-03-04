$(function() {
//	alert("1111111");
	//设置每页显示的数量
	var singlePageCount = 5;
	//显示第一页内容
	initOrder(1, singlePageCount);
	//配置翻页工具
	$.get("getUserOrdersCount.do", function(data) {
		$('.pagination').jqPagination({
			current_page : 1,
			max_page : Math.ceil(data / singlePageCount),
			paged : function(page) {
				initOrder(page, singlePageCount);
			}
		});
	});
});

//更新页面内容
//function showData(page, singlePageCount) {
//	$.getJSON("showOrders.do?", {
//		page : page,
//		singlePageCount : singlePageCount
//	}, function(data) {
//		if (data.length > 0) {
//			$("#dataTable").empty();
//			for ( var i = 0; i < data.length; i++) {
//				$("#dataTable").append(
//						data[i].id + " : " + data[i].name + "<br>");
//			}
//		}
//	});
//}
