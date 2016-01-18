<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

    <head>
        <title>Main Page</title>

        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" type="text/css" href="css/bootstrap-social.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />
    </head>

    <body>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" ></script>
        
        <#include "header.ftl">

        <div class="container">
            <h2>Main Page</h2>

            <p>
            <form method="POST" action="/update">
                <input type="text" name="data" value="${currentData}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button>Update your data</button>
            </form>
            </p>

            <!--
            <p>
            <form method="POST" th:action="@{/updateStatus}">
                <input type="text" name="status" />
                <input type="hidden" name="_csrf" th:value="${_csrf.token}" />
                <button>Update your social status</button>
            </form>
            </p>
            -->

            <p>
                <form method="POST" action="/logout">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button>Logout</button>
                </form>
            </p>

            

        </div><!-- /.container -->
    </body>
</html>