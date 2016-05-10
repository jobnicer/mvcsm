<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8" />
	<script type="text/javascript" src="static/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="static/tab/js/framework.js"></script>
	<script type="text/javascript" src="static/tab/js/tab.js" ></script>
	<link rel="stylesheet" type="text/css" href="static/tab/css/import_basic.css" />
	<link rel="stylesheet" type="text/css" id="skin" prePath="static/tab/" /><!--默认相对于根目录路径为../，可添加prePath属性自定义相对路径，如prePath="<%=request.getContextPath()%>"-->
</head>
	
<body>
<div id="tab_menu" style="height:30px;"></div>
<div style="width:100%;">
	<div id="page" style="width:100%;height:100%;"></div>
</div>		
</body>
<script type="text/javascript">

function tabAddHandler(mid,mtitle,murl){
	tab.add({
	id :mid,
	title :mtitle,
	url :murl,
	isClosed :true
	});
	tab.update({
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});
	tab.activate(mid);
}

var tab;	
$(function() {
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'tab1_index1',
		title :"动态看板",
		url :"<%=basePath%>dashBoard/dashBoard.do",
		isClosed :false
	});
});

function cmainFrameT(){
	var hmainT = document.getElementById("page");
	var bheightT = document.documentElement.clientHeight;
	hmainT .style.width = '100%';
	hmainT .style.height = (bheightT  - 51) + 'px';
}

cmainFrameT();

window.onresize=function(){  
	cmainFrameT();
};

</script>
</html>

