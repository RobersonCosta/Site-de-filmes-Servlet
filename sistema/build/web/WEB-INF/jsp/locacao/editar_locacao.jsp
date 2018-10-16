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
            <div align="center">
                <h4>Cadastro de Locação</h4><br>
            </div>
            <div class="row clearfix">
                <form role="form" action="Servlet?controller=locacao&method=editar" method="post">             
                    <table width="80%" align="center"><tr>
                            
                            <td><label>Sala</label> </td>           
                            <td ><input name="sala" type="text"  class="form-control" />   </td>  
                            <td align="center"><label>Hora     </label></td>
                            <td><input  name="hora" type="time"  class="form-control" />   </td>    
                            <td align="center"><label>Data     </label></td>
                            <td><input name="data" type="date"  class="form-control" />   </td>

                        </tr>
                    </table>                        
                    <input type="hidden" name="id_locacao" value="$id_locacao">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
