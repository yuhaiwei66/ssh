
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>regist.html</title>
    <meta http-equiv="content-type"    content="text/html;charset=UTF-8">
    <script type="text/javascript">
        function changeImg(img){
            img.src="ValiImage?time="+new Date().getTime();

        }
    </script>
</head>

<body>
<form action="#" method="POST">
    用户名：<input type="text" name="username"/> <br>
    密码： <input type="password" name="password"/><br>
    验证码：<input type="text" name="valistr"/><br>
    <img alt="验证码" src="/ValiImage" style="cursor:pointer" onclick="changeImg(this)" ><br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>