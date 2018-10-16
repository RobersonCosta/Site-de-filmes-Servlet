<%-- 
    Document   : index
    Created on : 19/06/2015, 14:15:13
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="estilos.css"  media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>       
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <div class="container">
            <div align="center">
                <h4>Cadastre as funções do cinema aqui</h4>
            </div>
            <br>
            <table width="80%" align="center"><tr>
                    <td align="center"> <div class="row clearfix">
                           <a href="Servlet?controller=filme&method=manipulador_filme" type="button" class="btn btn-block btn-primary" >Cadastrar filme</a></button>
                        </div></td>
                    <td align="center"><div class="row clearfix">
                            <a href="Servlet?controller=locacao&method=manipulador_locacao" type="button" class="btn btn-block btn-primary" >Cadastrar locação</a></button>
                        </div></td>
                    <td align="center">
                        <div class="row clearfix">
                            <a  href="Servlet?controller=sessao&method=manipulador_sessao" type="button" class="btn btn-block btn-primary" >Cadastrar sessão</a></button>
                        </div></td></tr>
        </div>
    </body>
</html>
