<html>
<head>
<title>Hello Facebook</title>

	<link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/2.2.0/jquery.min.js"></script>

</head>
<body>
<div class="alert alert-success" role="alert">Demo</div>

<#if userProfile??>
   Email: ${userProfile.email} 
<#else>
	<a href="/fblogin?ssid=${sessionId}" class="btn btn-info" role="button">Login</a> 
</#if>



</body>
</html>