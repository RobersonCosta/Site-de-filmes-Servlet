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
        <link rel="stylesheet" type="text/css" href="estilos.css"  media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>       
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
            <div class="container">
                <div align="center">
                    <h4>Cadastro de Sessão</h4>
                </div>
                <div class="row clearfix">
                    <form role="form" action="Servlet?controller=sessao&method=adicionar" method="post">
                        <div class="form-group">
                            <label>Filmes cadastrados: </label>
                            <select class="form-control" name="filme">
                            <c:forEach items="${vetFilmes}" var="filme">                            
                                <option>${filme.titulo}</option>                            
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Locações cadastradas: </label>
                        <select class="form-control" name="locacao">
                            <c:forEach items="${vetLocacoes}" var="locacao">                            
                                <option><input>Sala: ${locacao.sala} hora: ${locacao.hora} data: ${locacao.data} ID${locacao.id}</option>                            
                            </c:forEach>
                        </select>
                    </div>                    
                    <div class="form-group">
                        <label>Valor</label><input name="valor"type="text" class="form-control" />
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="dublagem" value="true">DUB</label>
                        <label><input type="radio" name="dublagem" value="false">LEG</label>
                    </div>                    
                    <input type="hidden" name="id_sessao" value="$id_sessao">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
