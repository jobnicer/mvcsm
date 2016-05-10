<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>  
<head>  
<script type="text/javascript" src="static/jquery/jquery-1.11.3.min.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<title>ajax Login</title>  
<script type="text/javascript">  
    function ajaxTest(){  
        $.ajax({  
        data:{
        	"username" : $("#username").val(),
        	"password" : $("#password").val(),
        },
        type:"POST",  
        dataType: 'json',  
        url:"main/login.do",  
        error:function(data){  
            alert("error");  
        },  
        success:function(data){ 
        	if(data.pageModel.success==true) {
        		alert("success");
        	}
        	//$("#result").html(data.pageModel.message) ;
        	//alert(data.model.msg); 
        }  
        });  
    }  
</script>  
</head>  
<body>  
        姓名<input type="text" name="username" id="username"/> </br>
        密码<input type="password" name="password" id="password"/> 
    <input type="submit" value="登录" onclick="ajaxTest();"/>  
    <div id="result"></div>  
</body>  
</html> 