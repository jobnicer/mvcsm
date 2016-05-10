var locat = (window.location+'').split('/'); 
$(function(){if('main'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});


//菜单状态切换 menu0默认为动态看板菜单
var fmid = "menu0";
var mid = "menu0";
function siMenu(id,fid,menuName,menuUrl){
	if(id != mid){
		$("#"+mid).removeClass();
		mid = id;
	}
	if(fid != fmid){
		$("#"+fmid).removeClass();
		fmid = fid;
	}
	$("#"+fid).attr("class","active open");
	$("#"+id).attr("class","active");
	top.mainFrame.tabAddHandler(id,menuName,menuUrl);
	if(menuUrl != "druid/index.html"){
		loading();
	}
}

//修改个人资料
/*function editUser(){
	 loading();
	 var diag = new top.Dialog()
	 diag.Drag=true;
	 diag.Title ="个人资料";
	 diag.URL = locat+'/user/goEditU.do?USER_ID='+USER_ID+'&fx=head';
	 diag.Width = 225;
	 diag.Height = 389;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
}*/


//清除加载进度
function clearLoading(){
	$("#loading").hide();
}

//显示加载进度
function loading(){
	$("#loading").show();
}

function cmainFrame(){
	var hmain = document.getElementById("mainFrame");
	var bheight = document.documentElement.clientHeight;
	hmain .style.width = '100%';
	hmain .style.height = (bheight  - 51) + 'px';
	var loadingPoint = document.getElementById("loadingArea");
	loadingPoint .style.height = (bheight  - 41) + 'px';
	
}

window.onresize=function(){  
	cmainFrame();
};

cmainFrame();

loading();