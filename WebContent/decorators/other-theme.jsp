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
   	 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<title><sitemesh:write property='title' /></title>
		
		<link href="resources/bootstrap/dist/css/bootstrap.min.css">
		<link href="resources/themes/sbadmin/css/animate.css" rel="stylesheet">
		<link href="resources/themes/sbadmin/css/bootstrap.css" rel="stylesheet">
		<link href="resources/themes/sbadmin/css/style.css" rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/bootgrid/dist/jquery.bootgrid.min.css" rel="stylesheet">
		<link href="resources/bootdialog/dist/css/bootstrap-dialog.min.css" rel="stylesheet">
		<link href="resources/bootdatepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet">
		<link href="resources/css/base.css" rel="stylesheet">
		
		<script src="resources/js/jquery/jquery-2.2.3.min.js"></script>
		<script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="resources/themes/sbadmin/js/jquery.metisMenu.js"></script>
		<script src="resources/themes/sbadmin/js/jquery.slimscroll.min.js"></script>
		<script src="resources/bootgrid/dist/jquery.bootgrid.min.js"></script>
		<script src="resources/bootdialog/dist/js/bootstrap-dialog.min.js"></script>
		<script src="resources/bootdatepicker/dist/js/bootstrap-datepicker.min.js"></script>
		<script src="resources/bootdatepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
		<script src="resources/bootjasny/js/jasny-bootstrap.min.js"></script>
		
		<%@ include file="../common/basic-script.inc"%>
		
		<sitemesh:write property='head' />
	</head>

	<body class="gray-bg"> 
		<sitemesh:write property='body' />
	</body>
</html>