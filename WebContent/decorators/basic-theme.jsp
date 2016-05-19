<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<title><sitemesh:write property='title' /></title>
		
		<link href="resources/bootstrap/dist/css/bootstrap.min.css">
		<link href="resources/toastr/dist/toastr.min.css" rel="stylesheet">
		<link href="resources/themes/sbadmin/css/animate.css" rel="stylesheet">
		<link href="resources/themes/sbadmin/css/bootstrap.css" rel="stylesheet">
		<link href="resources/themes/sbadmin/css/style.css" rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/bootgrid/dist/jquery.bootgrid.min.css" rel="stylesheet">
		<link href="resources/sweetalert/dist/sweetalert.css" rel="stylesheet">
		<link href="resources/bootselect/dist/css/select2.min.css" rel="stylesheet">
		<link href="resources/bootdatepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet">
		<link href="resources/css/base.css" rel="stylesheet">
		
		<script src="resources/js/jquery/jquery-2.2.3.min.js"></script>
		<script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="resources/js/plugin/jquery.getParam.js"></script>
		<script src="resources/js/util/util.forward.js"></script>
		<script src="resources/themes/sbadmin/js/jquery.metisMenu.js"></script>
		<script src="resources/themes/sbadmin/js/jquery.slimscroll.min.js"></script>
		<script src="resources/themes/sbadmin/js/inspinia.js"></script>
		<script src="resources/themes/sbadmin/js/pace.min.js"></script>
		<script src="resources/bootgrid/dist/jquery.bootgrid.js"></script>
		<script src="resources/sweetalert/dist/sweetalert.min.js"></script>
		<script src="resources/bootdatepicker/dist/js/bootstrap-datepicker.min.js"></script>
		<script src="resources/bootselect/dist/js/select2.min.js"></script>
		<script src="resources/bootselect/dist/js/i18n/zh-CN.js"></script>
		<script src="resources/bootdatepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
		<script src="resources/toastr/dist/toastr.min.js"></script>
		<script src="resources/bootjasny/js/jasny-bootstrap.min.js"></script>
		
		<%@ include file="../common/basic-script.inc"%>
		
		<sitemesh:write property='head' />

	</head>

	<body class="pace-done">
		<div id="wrapper">
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav metismenu" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element">
								<span> 
									<img alt="image" class="img-circle" src="resources/themes/sbadmin/img/timg.jpg" style="width: 60px;" >
								</span> 
								<a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
									<span class="clear"> 
										<span class="block m-t-xs"> <strong class="font-bold"></strong>管理员</span> 
										<span class="text-muted text-xs block">Administrator <b class="caret"></b></span>
									</span>
								</a>
								<ul class="dropdown-menu animated fadeInRight m-t-xs">
									<li>
										<a href="javascript:void(0);"><i class="fa fa-fw fa-cog"></i>账号设置</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="javascript:void(0);"><i class="fa fa-fw fa-sign"></i>Logout</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="active">
							<a href="javascript:void(0);">
								<i class="fa fa-fw fa-users"></i> <span class="nav-label">会员管理</span> <span class="fa arrow"></span>
							</a>
							<ul class="nav nav-second-level collapse in">
								<li class="active">
	                                <a href="member/account.html">会员账号信息</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">会员账户</a>
	                            </li>
							</ul>
						</li>
						<li>
	                    	<a href="javascript:void(0);">
	                         	<i class="fa fa-fw fa-cubes"></i> <span class="nav-label">产品管理</span> <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level collapse">
	                           <li>
	                               <a href="javascript:void(0);">类别管理</a>
	                           </li>
	                           <li>
	                               <a href="javascript:void(0);">产品信息</a>
	                           </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);"><i class="fa fa-fw fa-list-ul"></i> <span class="nav-label">订单管理</span></a>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);">
	                        	<i class="fa fa-fw fa-dollar"></i> <span class="nav-label">财务管理</span> <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level collapse">
	                            <li>
	                                <a href="javascript:void(0);">支入</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">支出</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">流水账</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);">
	                        	<i class="fa fa-fw fa-user"></i> <span class="nav-label">员工管理</span> <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level collapse">
	                            <li>
	                                <a href="javascript:void(0);">岗位</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">员工信息</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">排班</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">预约管理</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">休假信息</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0);">
	                        	<i class="fa fa-fw fa-line-chart"></i> <span class="nav-label">促销管理</span> <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level collapse">
	                            <li>
	                                <a href="javascript:void(0);">促销规则</a>
	                            </li>
	                            <li>
	                                <a href="javascript:void(0);">优惠券</a>
	                            </li>
	                        </ul>
	                    </li>
					</ul>
				</div>
			</nav>
	
			<div id="page-wrapper" class="gray-bg">
				<div class="row border-bottom">
					<nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
						<div class="navbar-header">
							<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="javascript:void(0);"><i class="fa fa-bars"></i></a>
						</div>
						<ul class="nav navbar-top-links navbar-right">
							<li><span class="m-r-sm text-muted welcome-message">欢迎登陆后台管理系统.</span></li>
							<li>
								<a class="dropdown-toggle count-info">
                        			<i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                    			</a>
							</li>
							<li>
								<a href="javascript:void(0)">
									<i class="fa fa-sign-out"></i> Log out
								</a>
							</li>
						</ul>
					</nav>
				</div>
				
				<div>
					<sitemesh:write property='body' />
				</div>
	
				<div class="footer">
					<div class="pull-right">
						
					</div>
					<div>
						<strong>Copyright</strong> 上海象爻网络科技有限公司 © 2015-2016
					</div>
				</div>
			</div>
		</div>	
		<div class="theme-config">
		    <div class="theme-config-box">
		        <div class="spin-icon">
		            <i class="fa fa-cogs fa-spin"></i>
		        </div>
		        <div class="skin-setttings">
		            <div class="title">外观配置</div>
		            <div class="setings-item">
		                    <span>
		                        	折叠菜单
		                    </span>
		
		                <div class="switch">
		                    <div class="onoffswitch">
		                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
		                        <label class="onoffswitch-label" for="collapsemenu">
		                            <span class="onoffswitch-inner"></span>
		                            <span class="onoffswitch-switch"></span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		            <div class="setings-item">
		                    <span>
		                        	固定菜单
		                    </span>
		
		                <div class="switch">
		                    <div class="onoffswitch">
		                        <input type="checkbox" name="fixedsidebar" class="onoffswitch-checkbox" id="fixedsidebar">
		                        <label class="onoffswitch-label" for="fixedsidebar">
		                            <span class="onoffswitch-inner"></span>
		                            <span class="onoffswitch-switch"></span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		            <div class="setings-item">
		                    <span>
		                        	导航栏固定在顶部
		                    </span>
		
		                <div class="switch">
		                    <div class="onoffswitch">
		                        <input type="checkbox" name="fixednavbar2" class="onoffswitch-checkbox" id="fixednavbar2">
		                        <label class="onoffswitch-label" for="fixednavbar2">
		                            <span class="onoffswitch-inner"></span>
		                            <span class="onoffswitch-switch"></span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		            <div class="setings-item">
		                    <span>
		                        	盒状布局
		                    </span>
		
		                <div class="switch">
		                    <div class="onoffswitch">
		                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
		                        <label class="onoffswitch-label" for="boxedlayout">
		                            <span class="onoffswitch-inner"></span>
		                            <span class="onoffswitch-switch"></span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		            <div class="setings-item">
		                    <span>
		                        	固定底部
		                    </span>
		
		                <div class="switch">
		                    <div class="onoffswitch">
		                        <input type="checkbox" name="fixedfooter" class="onoffswitch-checkbox" id="fixedfooter">
		                        <label class="onoffswitch-label" for="fixedfooter">
		                            <span class="onoffswitch-inner"></span>
		                            <span class="onoffswitch-switch"></span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		
		            <div class="title">主题</div>
		            <div class="setings-item default-skin">
	                    <span class="skin-name ">
	                         <a href="javascript:void(0);" class="s-skin-0">
	                             	默认
	                         </a>
	                    </span>
		            </div>
		            <div class="setings-item blue-skin">
	                    <span class="skin-name ">
	                        <a href="javascript:void(0);" class="s-skin-1">
	                            	蓝色
	                        </a>
	                    </span>
		            </div>
		            <div class="setings-item yellow-skin">
	                    <span class="skin-name ">
	                        <a href="javascript:void(0);" class="s-skin-3">
	                            	黄色
	                        </a>
	                    </span>
		            </div>
		            <div class="setings-item ultra-skin">
	                    <span class="skin-name ">
	                        <a href="javascript:void(0);" class="s-skin-2">
	                            	绿色
	                        </a>
	                    </span>
		            </div>
		        </div>
		    </div>
		</div>
<script>
    // Config box

    // Enable/disable fixed top navbar
    $('#fixednavbar').click(function (){
        if ($('#fixednavbar').is(':checked')){
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport){
                localStorage.setItem("boxedlayout",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixednavbar",'on');
            }
        } else{
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $("body").removeClass('fixed-nav-basic');
            $('#fixednavbar2').prop('checked', false);

            if (localStorageSupport){
                localStorage.setItem("fixednavbar",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixednavbar2",'off');
            }
        }
    });

    // Enable/disable fixed top navbar
    $('#fixednavbar2').click(function (){
        if ($('#fixednavbar2').is(':checked')){
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav').addClass('fixed-nav-basic');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport){
                localStorage.setItem("boxedlayout",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixednavbar2",'on');
            }
        } else {
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav').removeClass('fixed-nav-basic');
            $('#fixednavbar').prop('checked', false);

            if (localStorageSupport){
                localStorage.setItem("fixednavbar2",'off');
            }
            if (localStorageSupport){
                localStorage.setItem("fixednavbar",'off');
            }
        }
    });

    // Enable/disable fixed sidebar
    $('#fixedsidebar').click(function (){
        if ($('#fixedsidebar').is(':checked')){
            $("body").addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9
            });

            if (localStorageSupport){
                localStorage.setItem("fixedsidebar",'on');
            }
        } else{
            $('.sidebar-collapse').slimscroll({destroy: true});
            $('.sidebar-collapse').attr('style', '');
            $("body").removeClass('fixed-sidebar');

            if (localStorageSupport){
                localStorage.setItem("fixedsidebar",'off');
            }
        }
    });

    // Enable/disable collapse menu
    $('#collapsemenu').click(function (){
        if ($('#collapsemenu').is(':checked')){
            $("body").addClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport){
                localStorage.setItem("collapse_menu",'on');
            }

        } else{
            $("body").removeClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport){
                localStorage.setItem("collapse_menu",'off');
            }
        }
    });

    // Enable/disable boxed layout
    $('#boxedlayout').click(function (){
        if ($('#boxedlayout').is(':checked')){
            $("body").addClass('boxed-layout');
            $('#fixednavbar').prop('checked', false);
            $('#fixednavbar2').prop('checked', false);
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $("body").removeClass('fixed-nav-basic');
            $(".footer").removeClass('fixed');
            $('#fixedfooter').prop('checked', false);

            if (localStorageSupport){
                localStorage.setItem("fixednavbar",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixednavbar2",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixedfooter",'off');
            }


            if (localStorageSupport){
                localStorage.setItem("boxedlayout",'on');
            }
        } else{
            $("body").removeClass('boxed-layout');

            if (localStorageSupport){
                localStorage.setItem("boxedlayout",'off');
            }
        }
    });

    // Enable/disable fixed footer
    $('#fixedfooter').click(function (){
        if ($('#fixedfooter').is(':checked')){
            $('#boxedlayout').prop('checked', false);
            $("body").removeClass('boxed-layout');
            $(".footer").addClass('fixed');

            if (localStorageSupport){
                localStorage.setItem("boxedlayout",'off');
            }

            if (localStorageSupport){
                localStorage.setItem("fixedfooter",'on');
            }
        } else{
            $(".footer").removeClass('fixed');

            if (localStorageSupport){
                localStorage.setItem("fixedfooter",'off');
            }
        }
    });

    // SKIN Select
    $('.spin-icon').click(function (){
        $(".theme-config-box").toggleClass("show");
    });

    // Default skin
    $('.s-skin-0').click(function (){
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        if (localStorageSupport){
            localStorage.setItem("s-skin-0",'on');
            localStorage.setItem("s-skin-1",'off');
            localStorage.setItem("s-skin-2",'off');
            localStorage.setItem("s-skin-3",'off');
        }
    });

    // Blue skin
    $('.s-skin-1').click(function (){
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-1");
        if (localStorageSupport){
            localStorage.setItem("s-skin-1",'on');
            localStorage.setItem("s-skin-0",'off');
            localStorage.setItem("s-skin-2",'off');
            localStorage.setItem("s-skin-3",'off');
        }
    });

    // Inspinia ultra skin
    $('.s-skin-2').click(function (){
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-2");
        if (localStorageSupport){
            localStorage.setItem("s-skin-2",'on');
            localStorage.setItem("s-skin-0",'off');
            localStorage.setItem("s-skin-1",'off');
            localStorage.setItem("s-skin-3",'off');
        }
    });

    // Yellow skin
    $('.s-skin-3').click(function (){
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").addClass("skin-3");
        if (localStorageSupport){
            localStorage.setItem("s-skin-3",'on');
            localStorage.setItem("s-skin-0",'off');
            localStorage.setItem("s-skin-1",'off');
            localStorage.setItem("s-skin-2",'off');
        }
    });

    if (localStorageSupport){
        var collapse = localStorage.getItem("collapse_menu");
        var fixedsidebar = localStorage.getItem("fixedsidebar");
        var fixednavbar = localStorage.getItem("fixednavbar");
        var fixednavbar2 = localStorage.getItem("fixednavbar2");
        var boxedlayout = localStorage.getItem("boxedlayout");
        var fixedfooter = localStorage.getItem("fixedfooter");
        
        var skin0 = localStorage.getItem("s-skin-0");
        var skin1 = localStorage.getItem("s-skin-1");
        var skin2 = localStorage.getItem("s-skin-2");
        var skin3 = localStorage.getItem("s-skin-3");

        if (collapse == 'on'){
            $('#collapsemenu').prop('checked','checked')
        }
        if (fixedsidebar == 'on'){
            $('#fixedsidebar').prop('checked','checked')
        }
        if (fixednavbar == 'on'){
            $('#fixednavbar').prop('checked','checked')
        }
        if (fixednavbar2 == 'on'){
            $('#fixednavbar2').prop('checked','checked')
        }
        if (boxedlayout == 'on'){
            $('#boxedlayout').prop('checked','checked')
        }
        if (fixedfooter == 'on') {
            $('#fixedfooter').prop('checked','checked')
        }
        
        if (skin0 == 'on') {
        	 $("body").removeClass("skin-1");
             $("body").removeClass("skin-2");
             $("body").removeClass("skin-3");
        }
        if (skin1 == 'on') {
        	 $("body").removeClass("skin-2");
             $("body").removeClass("skin-3");
             $("body").addClass("skin-1");
        }
        if (skin2 == 'on') {
        	 $("body").removeClass("skin-1");
             $("body").removeClass("skin-3");
             $("body").addClass("skin-2");
        }
        if (skin3 == 'on') {
       	 	$("body").removeClass("skin-1");
       	 	$("body").removeClass("skin-2");
            $("body").addClass("skin-3");
       }
    }
</script>
	</body>
</html>