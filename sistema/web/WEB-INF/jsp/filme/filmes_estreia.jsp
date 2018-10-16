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
        <script language="javascript">
            function irParaOFilme(id){
                window.location="Servlet?controller=filme&method=pagina_do_filme&id_sessao="+id;
            }
        </script>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table width="100%">
                            <tr>
                                <td><a href="#" class="btn btn-block btn-primary" type="button">Em cartaz</a></td>
                                <td><a href="#" class="btn btn-block btn-primary" type="button">Estreias</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <br>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table">				
                            <tbody>
                            <c:forEach items="${vetSessoes}" var="sessao">  
                                <tr>
                                    <td rowspan=7 onClick="irParaOFilme($sessao.id);">CAPA</td>
                                    <td><h5><b>${sessao.filme.titulo}</b></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td><h6>Recomendação: ${sessao.filme.faixa_etaria}</h6><b></b>
                                    </td> 
                                </tr><tr>
                                    <td><h6>Duração: ${sessao.filme.duracao}</h6><b></b>
                                    </td> 
                                </tr>
                                <tr>
                                    <td><h6>Gênero: ${sessao.filme.genero.nome}</h6><b></b>
                                    </td>
                                </tr>
                                <tr>
                                    <td><h6>Valor: ${sessao.valor}</h6><b></b>
                                    </td>
                                </tr>
                                <c:choose>
                                    <c:when test="${sessao.dublagem==true}">
                                        <tr>
                                            <td><h6>Formato: Dublado</h6><b></b>
                                            </td>
                                        </tr>
                                    </c:when><c:otherwise>
                                        <tr>
                                            <td><h6>Formato: Legendado</h6><b></b>
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                <tr>
                                    <td><h6>${sessao.filme.dimensao}</h6>
                                    </td>
                                </tr>	
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>