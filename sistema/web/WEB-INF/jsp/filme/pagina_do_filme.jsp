<%-- 
    Document   : index
    Created on : 19/06/2015, 14:15:13
    Author     : Aluno
--%>

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
                <div class="row clearfix">
                    <div class="col-md-12 column"><table class="table">				
                            <tbody>

                            <tr>
                                <td rowspan=6>CAPA</td>
                                <td><h5><b>${sessao.filme.titulo}</b></h5>
                                </td>
                            </tr><tr>
                                <td><h6>Duração: ${sessao.filme.duracao}</h6><b></b>
                                </td> 
                            </tr>
                            <tr>
                                <td><h6>Recomendação: ${sessao.filme.faixa_etaria}</h6><b></b>
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

                            </tbody>
                    </table>
                    <br>
                    <h4><b>Sala: ${sessao.locacao.sala}/Hora: ${sessao.locacao.hora}/Dia: ${sessao.locacao.data}</b></h4>
                </div>
            </div>
        </div>
        <div align="center">
            <br>
            <object width="610" height="415"
                    data="${sessao.filme.link}">
            </object>
        </div>        
        <div class="container">
            <div class="row clearfix">
                <br>
                <h5><b>Sinopse: </b></h5>
                <p> ${sessao.filme.sinopse}</p>
                <br>
                <h5><b>Elenco: ${sessao.filme.elenco}</b></h5>
                <p></p>
                <br>
                <h5><b>Direção: ${sessao.filme.direcao}</b></h5>
                <p></p>
            </div>
        </div>

</body>
</html>
