<%@page import="com.emergentes.modelo.post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%
        post pos = (post) request.getAttribute("post");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nueva Entrada</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
        }
        .texta, textarea {
            width: 300px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Nueva Entrada</h1>
        <form action="postController" method="post">
            <input type="hidden" name="id" value="<%= pos != null ? pos.getId() : "" %>">
            <table>
                <tr>
                    <td>Fecha:</td>
                    <td><input type="date" name="fecha" value="<%= pos != null ? pos.getFecha() : "" %>" class="texta"/></td>
                </tr>
                <tr>
                    <td>Título:</td>
                    <td><input class="texta" type="text" name="titulo" value="<%= pos != null ? pos.getTitulo() : "" %>"/></td>
                </tr>
                <tr>
                    <td>Contenido:</td>
                    <td><textarea name="contenido" rows="4" cols="50" class="texta"><%= pos != null ? pos.getContenido() : "" %></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
