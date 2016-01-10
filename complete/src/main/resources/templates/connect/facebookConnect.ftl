<html>
	<head>
		<title>Hello Facebook</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
		
		<link rel='stylesheet' href='/assets/bootstrap/3.1.0/css/bootstrap.min.css'>
		<script type="text/javascript" src="/assets/jquery/2.2.0/jquery.js"></script>
	</head>
	<body>
		<h3>Connect to Facebook</h3>
		
		<form action="/connect/facebook" method="POST">				
			<input type="hidden" name="scope" value="publish_actions,public_profile,user_posts,user_videos,user_photos,email,user_likes" />
			<div class="formInfo">
				<p>You aren't connected to Facebook yet. Click the button to connect this application with your Facebook account.</p>
			</div>
			<p><button type="submit">Connect to Facebook</button></p>
		</form>		
			
	</body>
</html>