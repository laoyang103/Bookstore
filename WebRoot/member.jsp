<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty notices && empty isNull }">
     <jsp:forward page="getNotices.do?url=member.jsp"></jsp:forward>
</c:if>

<c:if test="${empty categories}">
	<jsp:forward page="getParentCategories.do?url=member.jsp"></jsp:forward>
</c:if>
<c:if test="${empty products}">
   <jsp:forward page="getProductsBySum.do?url=member.jsp"></jsp:forward>
</c:if>
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- system系统 -->
<link href="CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="JS/menutree.js"></script>
<script type="text/javascript" src="JS/jquery.js"></script>
<!-- 地区 -->
<script src="JS/jquery.provincesCity.js" type="text/javascript"></script>
<script src="JS/provincesdata.js" type="text/javascript"></script>
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
<!-- inputnotes -->
<script type="text/javascript" src="inputnotes/jquery.inputnotes-0.6.js"></script>
<script type="text/javascript" src="inputnotes/prettify.js"></script>
<script type="text/javascript" src="inputnotes/loadinputnotes.js"></script>
<link rel="stylesheet" type="text/css" href="inputnotes/prettify.css" />

<!-- team -->
<script type="text/javascript" src="JS/global.js"></script>
<script type="text/javascript" src="JS/liao.js"></script>
<script type="text/javascript" src="JS/empory.js"></script>

<script>
	//调用插件
	$(function(){
		$("#test").ProvinceCity();
	});
  </script>
</head>
<body>
<table width="790"  border="0" cellspacing="0" cellpadding="0" align="center">
 <tr>
 <td class="tableBorder">
<!--导航条-->
<table width="790" height="115"  border="0" align="center" cellpadding="0" 

cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td bgcolor="#CCCCCC" height="6px"></td>
      </tr>
    </table>
      <table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="25%"><img src="images/shop_02.gif" width="275" 

height="109"></td>
          <td width="75%"><table width="100%" height="109"  border="0" 

cellpadding="0" cellspacing="0">
            <tr>
              <td height="52" align="right" valign="top"><table width="100%" 

height="31"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="281">&nbsp;</td>
                  <td width="7" valign="top"><img src="images/T_contact.gif" 

width="42" height="28"></td>
                  <td width="72"><a href="mailto:fendou@fendoujiaoyu.com">联系我们

</a></td>
                  <td width="10" valign="top"><img src="images/T_favorite.gif" 

width="42" height="28"></td>
                  <td width="68"><a href="javascript:window.external.AddFavorite

('www.fendoujiaoyu.com','奋斗教育')">收藏本站</a></td>
                  <td width="10" valign="top"><img src="images/T_home.gif" width="42" 

height="28"></td>
                  <td width="70"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.fendoujiaoyu.com')">设为首页

</a></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="57" valign="top" background="images/shop_07.gif"><table 

width="100%" height="53"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="9%"><a href="index.jsp">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="15%"><a href="NewGoods.jsp">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="14%"><a href="sale.jsp">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="14%">
                  <c:if test="${not empty user}">
                  	<a href="member.jsp">
                  </c:if>
                  <c:if test="${empty user}">
                  	<a href="javascript:showMsg('<font color=yellow>您还没登录!

</font>');">
                  </c:if>
                  会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="10%"><a href="cart.jsp">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="15%"><c:if test="${not empty user}">
                  	<a href="order.jsp">
                  </c:if>
                  <c:if test="${empty user}">
                  	<a href="javascript:showMsg('<font color=yellow>您还没登录!

</font>');">
                  </c:if>
                  查看订单<br>
                    Order</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" 

height="57"></td>
                  <td width="11%"><a href="SellSort.jsp">销售排行<br>
                    SellSort</a></td>
                  <td width="2%">&nbsp;</td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
<!--导航条结束-->
<table width="790" height="236"  border="0" align="center" cellpadding="0" 

cellspacing="0">
  <tr>
    <td width="182" height="182" valign="top">
	
	<!--左侧框架-->
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="83" align="center"><img src="images/shop_11.gif" width="182" 

height="83"></td>
      </tr>
      <tr>
        <td height="98" align="center" background="images/shop_17.gif">	
         
         <form name="login" method="post" action="">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
            
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" background="Images/index_09.gif">
			<c:if test="${empty user}">
			  <table width="100%"  border="0" cellpadding="0" 

cellspacing="0">
                <tr>
                  <td width="94%" height="24">会员名
                    <input title="请输入用户名" name="username" type="text" 

class="txt_grey" id="username" size="16"></td>
                  <td width="6%">&nbsp;</td>
                </tr>
                <tr>
                  <td height="24">密&nbsp; 码 <input name="pwd" type="password" 

class="txt_grey" id="password" size="16" onKeydown="if(event.keyCode==13) userLogin

();"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td height="31">
                    <input type="button" class="button" value="注册" 

onClick="window.location.href='register.jsp'">
                    &nbsp;
                    <input type="button" class="button" value="登录" 

onclick="userLogin()">&nbsp;
                  </td>
                  <td id="msg">&nbsp;</td>
                </tr>
              </table>
              </c:if>
			<c:if test="${not empty user}">
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="94%" height="31" align="center" class="word_white">

[<font color="red">${user.username}</font>]您好!<br>
                      您现在可以购物了!</td>
                    <td width="6%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center"><input type="button" 

class="button" value="修改资料" onClick="window.location.href='member.jsp';"></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center">
                     <input type="button" class="button" value="退出登录" 

onClick="logout()"></td>
                    <td id="msg">&nbsp;</td>
                  </tr>
                </table>
		  </c:if>
				</td>
            </tr>
          </table>
		  </form></td>
      </tr>
    </table>
      <table width="100%" height="155"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/shop_22.gif" width="182" height="58"></td>
        </tr>
        <tr>
          <td height="97" align="center" valign="top" class="tableBorder_l">
          <table width="88%"  border="0" cellspacing="0" cellpadding="0">
           
           
           <c:forEach items="${notices}" var="notice">
			<tr>
              <td height="24" class="tableBorder_T_dashed"><a href="getNotice.do?id=

${notice.id}">${notice.title}</a></td>
            </tr>
			</c:forEach>
          </table></td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb"><table width="88%"  

border="0" cellspacing="0" cellpadding="0">
            
            <c:forEach items="${products }" var="product">
            <tr>
              <td height="20" class="tableBorder_B_dashed"><a 

href="showProductDetail.do?id=${product.id }">${product.name }</a></td>
            </tr>
            </c:forEach>

          </table>
            </td>
        </tr>
      </table>
	
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" 

background="images/shop_12.gif">
        <table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
            <td align="right" class="word_green">
			<marquee direction="left" scrollamount="1" scrolldelay="1" 

onMouseOver="this.stop();" onMouseOut="this.start();">
			<c:if test="${empty user}">
			购买商品请先登录 <a href="register.jsp" class="word_green">[

新用户注册]</a>
			</c:if>
			<c:if test="${not empty user}">
			${user.username}欢迎您~
			</c:if>
			</marquee></td>
          </tr>
        </table></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif" valign="top">
			<!--搜索框-->
			<form name="search" action="searchProducts.do">
			<table width="100%" height="23"  border="0" cellpadding="0" 

cellspacing="0">
			<tr>
			  <td colspan="2" height="7"></td>
			  </tr>
			<tr>
			  <td width="85%">请输入查询条件：
				<select name="pid" class="textarea">
				  <option value="0" selected>全部分类</option>
				  <c:forEach items="${categories}" var="category">
				  <option value="${category.id }">${category.name }

</option>
				</c:forEach> 
				</select>
				<input name="name" title="请输入想要找的商品" 

type="text" class="txt_grey" size="20">                  </td>
			  <td width="15%"><input type="submit" class="btn_grey" 

value="搜索"></td>
			</tr>
			</table>
			</form>
			<!--搜索框结束-->
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td height="80" background="images/center_member.jpg">&nbsp;</td>
              </tr>
        <tr>
          <td height="189" align="center" >
		  
		  
		  <c:if test="${empty sessionScope.user}">
		  <p>请先登录！</p>
		  </c:if>
		  <c:if test="${not empty sessionScope.user}">
		  <form id="modifypwd" name="modifypwd">
		  <table width="80%" border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" >
		   <tr>              
              <td height="28" class="font2">修改密码</td>
              <td height="28" align="right"><input class="button" type="button" value="保存对密码的修改" onclick="alterpassword()"></td>
            </tr>
            <tr>              
              <td width="18%" height="30" align="center">用 户 名：</td>
              <td id="usernameInputBox" width="82%" class="word_grey">${sessionScope.user.username}</td>
            </tr> 
            <tr>
              <td height="28" align="center">修改密码：</td>
              <td height="28"><input id="password1" class="inputnotes" name="oldpwd" type="password"  size="20" maxlength="13">
                <span class="word_orange">*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">确认密码：</td>
              <td height="28"><input id="password2"  class="inputnotes" name="newpwd" type="password" size="20" maxlength="20" onkeyup="checkPassword()">
                <span class="word_orange">*</span><span id="result"></span> </td>
                <td id="msg"></td>
            </tr>              
           </table>
           </form>
           <form id="modifyuser" method="post" name="modifyuser">
		   <table width="80%"  border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" > 
            <tr>              
              <td height="28" class="font2">修改地址簿</td>
              <td height="28" align="right"><input class="button" id="alter" type="button" value="保存对地址的修改" onclick="alterData()"></td>
            </tr>
            <tr>
              <td height="28" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
              <td height="28"><input title="请输入新的姓名" id="realname1" name="truename" type="text" maxlength="10" value="${sessionScope.user.realname}">
                <span class="word_orange">*</span></td>
            </tr> 
            <tr>
              <td height="28" align=""> 地&nbsp;&nbsp;&nbsp;&nbsp;区：<br>(原)<font color="green">${sessionScope.user.area}</font></td>
              
              <td id="test"></td>
            </tr>  
            
            <tr>
              <td height="28" align="center">详细地址：</td>
              <td class="word_grey"><input title="请输入具体的学校,社区等信息" id="address1" name="address" type="text"size="50" value="${sessionScope.user.address}">  <span class="word_orange">*</span></td>
            </tr>               
                       
            <tr>
              <td height="28" align="center">邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
              <td class="word_grey"><input title="请输入邮编" id="postcode1"  class="inputnotes" name="postcode" type="text" size="20" value="${sessionScope.user.postcode}">
                       <span class="word_orange">*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">联系电话：</td>
              <td><input title="请输入电话号码" id="telephone1"  class="inputnotes" name="telephone" type="text" value="${sessionScope.user.phone}"> <span class="word_orange">*</span></td>
            </tr>             
          </table>
		  </form>
		  <table width="80%" border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" >
		   <tr>              
              <td height="28" class="font2">查看收藏夹</td>
              <td height="28" align="right"><input class="button" type="button" value="查看" onClick="window.location.href='getFavorite.do'"></td>
            </tr>
          </table>
          
		  </td>
          </tr>
          <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
          </tr>
      </table></td>
  </tr>
</table>
</c:if>


<table width="790"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
    <!--版权信息-->
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
	
	<!--版权信息结束-->
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>