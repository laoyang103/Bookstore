<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty product }">
	<jsp:forward page="GoodsManage.jsp"></jsp:forward>
</c:if>
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- system系统 -->
<link href="CSS/style.css" rel="stylesheet">
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

<!-- 上传 -->
<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css">
<script type="text/javascript" src="uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="uploadify/onload4modify.js"></script>

<!-- 验证 -->
<script type="text/javascript" src="inputnotes/jquery.inputnotes-0.6.js"></script>
<script type="text/javascript" src="inputnotes/prettify.js"></script>
<link rel="stylesheet" type="text/css" href="inputnotes/prettify.css" />
<script type="text/javascript" src="inputnotes/load4product.js"></script>

<!-- team -->
<script type="text/javascript" src="JS/empory.js"></script>
</head>
<body onload="loadSuperCategorySelect4Modify()">
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<!-- LOGO -->
	<table width="777" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td bgcolor="#CCCCCC" height="6px"></td>
	      </tr>
	    </table>
	      <table width="100%" height="123"  border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td valign="top" background="./images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
	            <tr>
	              <td height="98" colspan="2">&nbsp;</td>
	            </tr>
	            <tr>
	              <td width="25%">&nbsp;</td>
	              <td width="75%" class="word_green" id="bgclock"></td>
	            </tr>
	          </table></td>
	        </tr>
	      </table></td>
	  </tr>
	</table>
<!-- LOGO结束-->
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="./images/manage_02.gif">
         <!-- 操作菜单 -->
           <table width="100%" height="350"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="18%" height="61">&nbsp;</td>
            <td width="82%">&nbsp;</td>
          </tr>
          <tr>
            <td height="46">&nbsp;</td>
            <td><a href="manage/GoodsManage.jsp" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="manage/MemberManage.jsp" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="manage/OrderManage.jsp" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="manage/PlacardManage.jsp" class="word_white">公告管理<br>
              Placard Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="manage/ParameterManage.jsp" class="word_white">参数管理<br>
              Parameter Manage </a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="./backLogout.do" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="./images/manage_center_goodsmodi.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right"></td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
   			  			  <form action="goods_add_deal.jsp" method="post" name="form1">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td height="30">所属大类：</td>
                    <td width="31%">
					  <select name="supertype" id="supertype" onChange="loadSubCategorySelect4Modify(this.value)">					  
					  			
                      </select></td>
                    <td width="13%"> 所属小类：</td>
                    <td width="42%">
                      <select name="typeID" class="textarea" id="typeID">					  
					   		
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td width="14%" height="30">商品名称：</td>
                    <td colspan="3">
                      <input title="请输入商品名称" value="${product.name }" id="productname" type="text" class="Sytle_text" size="50">&nbsp;&nbsp;                    </td>
                    </tr>
                  <tr>
                    <td height="30">市场价格：</td>
                    <td>
                          <input title="请输入市场价格" id="normalprice" value="${product.normalprice }" size="15"  name="normalprice" type="text">(元)
                    </td>
                    <td>商城价格：</td>
                    <td>
                          <input title="请输入商城价格" value="${product.memberprice }" name="memberprice" type="text" id="memberprice">(元)
                    </td>
                  </tr>
                  <tr>                    
                    <td height="30">折 扣 率：</td>
                    <td>${rebate }%</td>
                    <td>是否特价：</td>
                    <td>
                    <c:if test="${product.ifspecial == 1 }">
                    	<input name="sale" type="radio" class="noborder" value="1" checked>是<input name="sale" type="radio" class="noborder" value="0">否
                    </c:if>
                    <c:if test="${product.ifspecial == 0 }">
                    	<input name="sale" type="radio" class="noborder" value="1">是<input name="sale" type="radio" class="noborder" value="0" checked>否
                    </c:if>
                    </td>
                  </tr> 
                  <tr>
                    <td height="30">商品图片：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                       <!-- <input type="file" name="pricute" size=50> -->
    <input id="inputFileName" type="hidden" name="name" value="${product.img }">
	<input type="file" name="file_upload" id="file_upload" />
                    </td>
                  </tr>
                  <tr>
                    <td height="103">商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea title="请输入对商品的详细介绍" id="desr" name="introduce" cols="60" rows="5" class="textarea" id="introduce">${product.descr }</textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                    <input type="hidden" id="productid" name="productid" value="${product.id }">
                        <input name="Button" type="button" class="button" value="保存" onClick="saveGoodsModify4Modify()">
&nbsp;                        
<input name="Submit2" type="reset" class="button" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="button" value="返回" onClick="JScript:history.back(-1)">
                    </td>
                  </tr>
                </table>
			  </form>
          </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="./images/manage_06.gif">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="777"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>    
    <td height="54" align="center">
    <!--版权信息  -->
      <table width="100%" height="78"  border="0" align="center" cellpadding="-2" cellspacing="-2">
      <tr>
        <td height="13" colspan="5"></td>
        </tr>
      <tr>
        <td width="124" height="13">&nbsp;</td>
        <td height="13" colspan="3" align="center">奋斗子商城客户服务热线：0791-3881060，3881061 传真：0791-3881063</td>
        <td width="141">&nbsp;</td>
      </tr>
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        <td width="464" valign="bottom" align="center"> CopyRight &copy; 2009 www.fendoujiaoyu.com 奋斗教育</td>
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
    </table>
      <!--版权信息结束  --> 
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

 