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
		<title></title>

		<!-- basic styles -->
		<link rel="stylesheet" href="static/ace/css/bootstrap.min.css" />
		<link rel="stylesheet" href="static/ace/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="static/ace/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- ace styles -->
		<link rel="stylesheet" href="static/ace/css/ace.min.css" />
		<link rel="stylesheet" href="static/ace/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="static/ace/css/ace-skins.min.css" />
		
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="static/ace/css/ace-ie.min.css" />
		<![endif]-->
		
		<!-- front styles -->
		<link rel="stylesheet" href="static/app/css/front.css" />

		<!-- ace settings handler -->
		<script src="static/ace/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="static/ace/js/html5shiv.js"></script>
		<script src="static/ace/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				<div class="page-content">
					<div class="page-header">
						<h1>
							动态看板
							<small>
								<i class="icon-double-angle-right"></i>
								图表查看
							</small>
						</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							
							<div id="main" style="height:400px"></div>

							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-container-inner -->

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
		
		<!-- echarts scripts -->
		<script src="static/echarts/echarts.min.js"></script>
		<script type="text/javascript">
		// 清除加载状态
		$(top.clearLoading());
        
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
			
        // 指定图表的配置项和数据
        var option = {
		    title : {
		        text: '某地区蒸发量和降水量',
		        subtext: '纯属虚构'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['蒸发量','降水量']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'蒸发量',
		            type:'bar',
		            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        },
		        {
		            name:'降水量',
		            type:'bar',
		            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
		            markPoint : {
		                data : [
		                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
		                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name : '平均值'}
		                ]
		            }
		        }
		    ]
		};
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
    </script>
	
</body>
</html>
