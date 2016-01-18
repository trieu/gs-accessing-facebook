<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <title>Login page</title>

        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" type="text/css" href="css/bootstrap-social.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />

        <style type="text/css">
            <!--
            .ml { width: 110px; color: white; text-decoration: none }
            .ml:hover, a:focus { color: white; text-decoration: none }
            -->
        </style>

    </head>

    <body>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" ></script>
        
        <#include "header.ftl">

        <div class="container">
            <h2>Login page</h2>

            <p>Sign in with:</p>

            <table style="border-collapse: separate; border-spacing: 2px">
                <tr>                    
                    <td><a href="/auth/facebook" class="ml btn btn-block btn-social btn-sm btn-facebook"><i class="fa fa-facebook"></i>Facebook</a></td>
                </tr>
               
            </table>

        </div><!-- /.container -->
    </body>
</html>