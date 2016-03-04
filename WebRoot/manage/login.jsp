<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.user.grade==0}">
	<jsp:forward page="../manage/PlacardManage.jsp"></jsp:forward>
</c:if>
<html>
<head>
<title>后台管理!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- system系统 -->
<link href="../CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="../JS/menutree.js"></script>
<script type="text/javascript" src="../JS/jquery.js"></script>
<!-- message弹框提示 -->
<link rel="stylesheet" type="text/css" href="../JS/themes/message_solid.css" />
<script type="text/javascript" src="../JS/message.js"></script>
<script type="text/javascript" src="../JS/showmsg.js"></script>
<!-- gh-buttons按钮的样式 -->
<link rel="stylesheet" type="text/css" href="../CSS/gh-buttons.css" />

<!-- team -->
<script type="text/javascript" src="../JS/global.js"></script>
<script type="text/javascript" src="../JS/liao.js"></script>
<script type="text/javascript" src="../JS/empory.js"></script>


</head>
<body>
      <table width="350" height="210"  border="0" align="center" cellpadding="0" cellspacing="0" background="../images/login_M.jpg" class="tableBorder">
        <tr>
          <td height="136" id="msg" align="center"><br></td>
        </tr>	  
              
        <tr>
          <td height="87" align="center" valign="top">
          <form name="form1" method="post" action="">
          <table width="62%" height="87"  border="0" cellpadding="0" cellspacing="0">              
			<tr>
              <td width="95%" align="center">&nbsp;用户名：
              <input name="manager" type="text" id="username" size="20"></td><td valign="top"><br></td>
              </tr>
            <tr>
              <td align="center">&nbsp;密&nbsp;&nbsp;码：
              <input name="PWD" type="password" id="password" size="20" onKeydown="if(event.keyCode==13) backUserLogin();"></td><td valign="top"><br></td>
              </tr>

            <tr>
              <td align="center"><input class="button" type="button" value="提交" onClick="backUserLogin()">
              
              <input class="button" type="button" value="返回" ></td><td valign="top"><br></td>
              </tr>           
          </table>
          </form>
          </td>
        </tr>
</table>
</body>
</html>
