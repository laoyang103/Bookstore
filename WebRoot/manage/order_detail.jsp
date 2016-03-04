<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>后台管理</title>
<!-- system系统 -->
<link href="CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="JS/menutree.js"></script>
<script type="text/javascript" src="JS/jquery.js"></script>
<!-- message弹框提示 -->
<link rel="stylesheet" type="text/css" href="JS/themes/message_solid.css" />
<script type="text/javascript" src="JS/message.js"></script>
<script type="text/javascript" src="JS/showmsg.js"></script>
<!-- gh-buttons按钮的样式 -->
<link rel="stylesheet" type="text/css" href="CSS/gh-buttons.css" />
<!-- poshytip输入框提示 -->
<script type="text/javascript" src="poshytip/jquery.poshytip.min.js"></script>
<script type="text/javascript" src="poshytip/onload.js"></script>
<link rel="stylesheet" type="text/css" href="poshytip/tip-twitter/tip-twitter.css" />

<!-- team -->
<script type="text/javascript" src="JS/global.js"></script>
<script type="text/javascript" src="JS/liao.js"></script>
<script type="text/javascript" src="JS/empory.js"></script>
</head>
<body>
<div id="msg"></div>
	<table width="777" height="192" border="0" align="center"
		cellpadding="0" cellspacing="0" class="tableBorder">
		<tr>
			<td>
				<!-- LOGO -->
				<table width="777" height="115" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top"><table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td bgcolor="#CCCCCC" height="6px"></td>
								</tr>
							</table>
							<table width="100%" height="123" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td valign="top" background="./images/manage_01.gif"><table
											width="100%" height="118" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="98" colspan="2">&nbsp;</td>
											</tr>
											<tr>
												<td width="25%">&nbsp;</td>
												<td width="75%" class="word_green" id="bgclock"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table> <!-- LOGO结束-->
				<table width="777" height="288" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td width="182" valign="top"><table width="100%" height="431"
								border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" background="./images/manage_02.gif">
										<!-- 操作菜单 -->
										<table width="100%" height="350" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="18%" height="61">&nbsp;</td>
												<td width="82%">&nbsp;</td>
											</tr>
											<tr>
												<td height="46">&nbsp;</td>
												<td><a href="manage/GoodsManage.jsp" class="word_white">商品管理<br>
														Goods Manage</a>
												</td>
											</tr>
											<tr>
												<td height="47">&nbsp;</td>
												<td><a href="manage/MemberManage.jsp" class="word_white">会员管理<br>
														Member Manage</a>
												</td>
											</tr>
											<tr>
												<td height="48">&nbsp;</td>
												<td><a href="manage/OrderManage.jsp" class="word_white">订单管理<br>
														Order Manage</a>
												</td>
											</tr>
											<tr>
												<td height="50">&nbsp;</td>
												<td><a href="manage/PlacardManage.jsp" class="word_white">公告管理<br>
														Placard Manage</a>
												</td>
											</tr>
											<tr>
												<td height="50">&nbsp;</td>
												<td><a href="manage/ParameterManage.jsp" class="word_white">参数管理<br>
														Parameter Manage </a>
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><a href="./backLogout.do" class="word_white">退出后台<br>
														Exit Background </a>
												</td>
											</tr>
										</table> <!-- 操作菜单结束 --></td>
								</tr>
							</table>
						</td>
						<td align="center" valign="top"><table width="100%"
								height="120" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top"
										background="./images/manage_center_orderdetail.gif"><table
											width="100%" height="36" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="98%" align="right">&nbsp;</td>
												<td width="2%">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table width="95%" height="192" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td valign="top">
										<table width="100%" height="272" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td width="97%" height="220" align="center" valign="top">
													<table width="90%" height="131" border="0" cellpadding="0"
														cellspacing="0" class="tableBorder_LTR_dashed">
														<tr>
															<td width="16%" style="padding:5px;" align="center">订单时间：</td>
															<td>${salesOrder.pdate}</td>
														</tr>
														<tr>
															<td width="16%" style="padding:5px;" align="center">订
																单 号：</td>
															<td>${salesOrder.id}</td>
														</tr>
														<tr>
															<td width="16%" style="padding:5px;" align="center">订单总计：</td>
															<td>￥${salesOrder.totalmoney}</td>
														</tr>
														<tr>
															<td colspan="2"><hr align="center" width="92%"
																	size="1">
															</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center">付款方式：</td>
															<td>- <c:if test="${salesOrder.paymethod == 1}">
                          	邮政付款
                          </c:if> <c:if test="${salesOrder.paymethod == 2}">
                          	网银付款
                          </c:if> <c:if test="${salesOrder.paymethod == 3}">
                          	货到付款
                          </c:if></td>
														</tr>
														<tr>
															<td colspan="2"><hr align="center" width="92%"
																	size="1">
															</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center">配送地址：</td>
															<td>- 地址：${salesOrder.address}</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center"></td>
															<td>- 收件人：${salesOrder.recievename}</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center"></td>
															<td>- 邮编：${salesOrder.postcode}</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center"></td>
															<td>- 电话：${salesOrder.phone}</td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center">收货方式：</td>
															<td>- <c:if test="${salesOrder.recievemethod == 1}">
                          	邮政付款
                          </c:if> <c:if test="${salesOrder.recievemethod == 2}">
                          	网银付款
                          </c:if> <c:if test="${salesOrder.recievemethod == 3}">
                          	货到付款
                          </c:if></td>
														</tr>
														<tr>
															<td style="padding:5px;" align="center">备注：</td>
															<td>- ${salesOrder.remark}<br>
															</td>
														</tr>

													</table>
													<table width="90%" border="0" cellpadding="0"
														cellspacing="0" bordercolor="#FFFFFF"
														bordercolorlight="#FFFFFF" bordercolordark="#CCCCCC"
														class="tableBorder_dashed">
														<tr align="center" bgcolor="#eeeeee">
															<td width="50%" height="24">商品名称</td>
															<td width="20%">数量</td>
															<td width="30%">单价</td>
														</tr>
														<c:forEach items="${salesOrder.salesItems}"
															var="salesItem">
															<tr align="center">
																<td height="24">${salesItem.productName}</td>
																<td>${salesItem.pcount }</td>
																<td>￥${salesItem.unitPrice }</td>
															</tr>
														</c:forEach>
														<tr align="center">
															<td colspan="2" align="right">总计：</td>
															<td align="center">￥${salesOrder.totalmoney}</td>
														</tr>
													</table>
													<table width="100%" height="49" border="0" cellpadding="0"
														cellspacing="0">
														<tr>
															<td align="center">
																<input type="submit" class="btn_grey" value="返回订单列表" onClick="history.back(-1)">
															</td>
															<c:if test="${salesOrder.status == 1 }">
															<td align="center">
																<input type="submit" class="btn_grey" value="立即发货" onClick="sendoutOrder('${salesOrder.id}')">
															</td>
															</c:if>
															<td align="center">
																<input type="submit" class="btn_grey" value="关闭订单" onClick="closeOrder('${salesOrder.id}')">
															</td>
														</tr>
													</table>
												</td>
												<td width="3%" valign="top">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table>
							<table width="100%" height="46" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td background="./images/manage_06.gif">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="777" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="54" align="center">
							<!--版权信息  -->
							<table width="100%" height="78" border="0" align="center"
								cellpadding="-2" cellspacing="-2">
								<tr>
									<td height="13" colspan="5"></td>
								</tr>
								<tr>
									<td width="124" height="13">&nbsp;</td>
									<td height="13" colspan="3" align="center">奋斗子商城客户服务热线：0791-3881060，3881061
										传真：0791-3881063</td>
									<td width="141">&nbsp;</td>
								</tr>
								<tr>
									<td height="15" colspan="2">&nbsp;</td>
									<td width="464" valign="bottom" align="center">CopyRight
										&copy; 2009 www.fendoujiaoyu.com 奋斗教育</td>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
									<td align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</td>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr bgcolor="#cccccc">
									<td height="8" colspan="2"></td>
									<td height="8" align="center"></td>
									<td height="8" colspan="2"></td>
								</tr>
							</table> <!--版权信息结束  --></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>

