<%-- 
    Document   : cabecalho
    Created on : 19/06/2015, 14:15:44
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script language="javascript">
            $('.dropdown-toggle').dropdown();
            $('.dropdown-menu').find('form').hover(function (e) {
                e.stopPropagation();
            });
        </script>
        <style>

            .dropdown:hover .dropdown-menu {
                display: block;
            }

            dropdown-menu {
                position: absolute;
                top: 90%!important;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="index.jsp">Home</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login<strong class="caret"></strong></a>
                        <div class="dropdown-menu">
                            <form style="margin: 0px" >
                                <fieldset style="padding:10px">
                                    <input class="form-group" style="margin-top: 8px" type="text" placeholder="Username" />
                                    <input class="form-group" style="margin-top: 8px" type="password" placeholder="Passsword" />
                                    <input class="btn btn-default" name="#" type="submit" value="Log In" />
                                </fieldset>
                            </form>
                        </div>
                    </li>
                    <li> 
                        <a href="menu_admin.jsp">Minha Conta</a> 
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Search here"/>
                    </div> <button type="submit" class="btn btn-default">Search</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">Deslogar</a>
                    </li>						
                </ul>
            </div>
        </nav>       
    </body>
</html>