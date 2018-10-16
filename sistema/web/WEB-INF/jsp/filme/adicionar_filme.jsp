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
                    <h4>Cadastro de Filme</h4>
                </div>
                <div class="row clearfix">
                    <form role="form" action="Servlet?controller=filme&method=adicionar" method="post">
                        <div class="form-group">
                            <label>Título</label><input type="text" name="titulo" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Gênero:</label>
                            <select class="form-control"  name="genero">
                            <c:forEach items="${vetGeneros}" var="genero">                            
                                <option>${genero.nome}</option>                            
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Tipo: </label>
                        <select class="form-control" name="tipo" >
                            <c:forEach items="${vetTipos}" var="tipo">         
                                <option >${tipo.importancia}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="dimensao">3D</label>
                        <label><input type="radio" name="dimensao">2D</label>
                    </div>
                    <div class="form-group">
                        <label>Sinopse</label><input type="text" class="form-control" name="sinopse"/>
                    </div>
                    <div class="form-group">
                        <label>Elenco</label><input type="text" class="form-control" name="elenco"/>
                    </div>
                    <div class="form-group">
                        <label>Direção</label><input type="text" class="form-control" name="direcao"/>
                    </div>
                    <div class="form-group">
                        <label>Faixa etária </label>
                        <select class="form-control"  name="faixa_etaria">
                            <option >Livre</option>
                            <option>10</option>
                            <option>12</option>
                            <option>14</option>
                            <option>16</option>
                            <option>18</option>
                        </select>
                    </div>                        
                    <div class="form-group">
                        <label>Duração</label><input type="text" class="form-control" name="duracao"/>
                    </div>
                    <div class="form-group">
                        <label>Link</label><input type="text" class="form-control" name="link"/>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
