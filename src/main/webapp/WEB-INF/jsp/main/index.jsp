<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>${sysName}</title>

		<!-- basic styles -->
		<link rel="stylesheet" href="static/ace/css/bootstrap.min.css"  />
		<link rel="stylesheet" href="static/ace/css/font-awesome.min.css" />

		<!--[if IE 7]>
		<link rel="stylesheet" href="static/ace/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<link rel="stylesheet" href="static/ace/css/ace.min.css" />
		<link rel="stylesheet" href="static/ace/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="static/ace/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		<link rel="stylesheet" href="static/ace/css/ace-ie.min.css" />
		<![endif]-->
		
		<link rel="stylesheet" href="static/app/css/index.css" />
		
		<!-- front styles -->
		<link rel="stylesheet" href="static/app/css/front.css" />
		
		<!-- basic script -->
		<script src="static/ace/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="static/ace/js/html5shiv.js"></script>
		<script src="static/ace/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<!-- 01 顶部状态栏 -->
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
			<!-- 10 系统名称显示区域 -->
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-plane icon-large" ></i>
							&nbsp;${sysName}
						</small>
					</a>
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="static/ace/avatars/user.jpg" alt="Jason's Photo" />
								<span id="user_info" class="user-info">
									<span class="text-center">Welcome</span> 
									<small>${sessionScope.SESSION_USER.username}</small> 
								</span>
								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li><a onclick="" href="#"><i class="icon-cog"></i>系统设置</a></li>
								<li><a onclick="" href="#"><i class="icon-user"></i>修改资料</a></li>
								<li class="divider"></li>
								<li><a onclick="" href="#"><i class="icon-off"></i>退出系统</a></li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<!-- 02 侧边快捷菜单 -->
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<!-- 02 侧边菜单 -->
					<ul class="nav nav-list">
						<!-- 默认动态面板菜单 -->
						<li class="active" id="menu0">
							<a href="index.do">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 动态看板 </span>
							</a>
						</li>

						<c:forEach items="${allMenuList}" var="menu">
							<c:if test="${menu.hasMenu}">
								<li id="${menu.menuId}">
						  			<a style="cursor:pointer;" class="dropdown-toggle" >
										<i class="${menu.menuIcon == null ? 'icon-desktop' : menu.menuIcon}"></i>
										<span>${menu.menuName}</span>
										<b class="arrow icon-angle-down"></b>
						  			</a>
						  			<ul class="submenu">
										<c:forEach items="${menu.subMenuList}" var="sub">
											<c:if test="${sub.hasMenu}">
												<c:choose>
													<c:when test="${not empty sub.menuUrl}">
														<li id="${sub.menuId}">
														<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('${sub.menuId}','${menu.menuId}','${sub.menuName}','${sub.menuUrl}')">
														<i class="icon-double-angle-right"></i>${sub.menuName}</a></li>
													</c:when>
													<c:otherwise>
														<li><a href="javascript:void(0);"><i class="icon-double-angle-right"></i>${sub.menuName}</a></li>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
					  				</ul>
								</li>
							</c:if>
						</c:forEach>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<!-- 03 内容区域 -->
				<div class="main-content" class="clearfix">
					<!-- 31 上方提示 -->
					<!-- <div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Other Pages</a>
							</li>
							<li class="active">Blank Page</li>
						</ul>

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div>
					</div> -->
					
					<!-- 32 加载界面 -->
					<div id="loading" style="display:none; width:100%; position:fixed; z-index:99999999;">
						<div class="loadingArea" id="loadingArea"></div>
						<div style="padding-left: 70%;padding-top: 1px;">
							<div style="float: left;margin-top: 3px;"><img src="static/ace/images/loading.gif" /> </div>
							<div style="margin-top: -5px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
						</div>
					</div>
		
					<!-- 33 iframeTAB切换 -->
					<div>
						<iframe name="mainFrame" id="mainFrame" frameborder="0" src="tab.do" style="margin:0 auto;width:100%;height:100%;"></iframe>
					</div>
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->



		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='static/ace/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 	window.jQuery || document.write("<script src='static/ace/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='static/ace/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="static/ace/js/bootstrap.min.js"></script>
		<script src="static/ace/js/typeahead-bs2.min.js"></script>

		<!-- ace scripts -->
		<script src="static/ace/js/ace-elements.min.js"></script>
		<script src="static/ace/js/ace.min.js"></script>

		<!-- 引入自己写的js -->
		
		<script type="text/javascript" src="static/app/js/index.js"></script>

</body>
</html>






