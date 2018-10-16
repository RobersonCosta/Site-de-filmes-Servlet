<%-- 
    Document   : index
    Created on : 19/06/2015, 14:15:13
    Author     : Aluno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <label label-default>Locações cadastradas</label>
                <a href="Servlet?controller=locacao&method=adicionar_locacao"class="btn btn-default">Adicionar novo valor</a><br><br>
                <table class="table table-hover">
                    <tr>
                        <td><h5><b>Sala</b></h5></td><td><h5><b>Hora</b></h5></td><td><h5><b>Data</b></h5></td>
                    </tr>
                    <c:forEach items="${vetLocacoes}" var="locacao">  
                        <tr>                            
                            <td>${locacao.sala}</td><td>${locacao.hora}</td><td>${locacao.data}</td>                   
                            <td align="right"><a href="Servlet?controller=locacao&method=editar_locacao&id=${locacao.id}"class="btn btn-default">Editar</a>
                                <a href="Servlet?controller=locacao&method=deletar&id=${locacao.id}"class="btn btn-default">Deletar</a></td>
                        </tr>
                    </c:forEach>
                </table>             
            </div>
        </div>

    </body>
</html>
