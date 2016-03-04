function loadOrderManage(status) {
	// 设置每页显示的数量
	var singlePageCount = 5;
	// 显示第一页内容
	initOrderManage(status,1, singlePageCount);
	
	//加载所有类型的订单
	if(status == 0) {
	// 配置翻页工具
	$.get("../getAllOrdersCount.do", function(data) {
		$('.pagination').jqPagination({
			current_page : 1,
			max_page : Math.ceil(data / singlePageCount),
			paged : function(page) {
				initOrderManage(status,page, singlePageCount);
			}
		});
	});
	} else {
		// 配置翻页工具
		$.get("../getSearchOrderCount.do", function(data) {
			$('.pagination').jqPagination({
				current_page : 1,
				max_page : Math.ceil(data / singlePageCount),
				paged : function(page) {
					initOrderManage(status,page, singlePageCount);
				}
			});
		});
	}
}
