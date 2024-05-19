<%@ page import="com.emergentes.modelo.post"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%
    List<post> post = (List<post>) request.getAttribute("post");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BLOG DE TECNOLOGÍA</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            text-align: center;
        }
        form {
            margin-bottom: 20px;
            display: flex;
            justify-content: flex-end; /* Mueve el formulario hacia la derecha */
        }
        .post-container {
            width: 50%;
            padding: 20px;
            margin-bottom: 20px;
            position: relative; /* Añade posición relativa para los enlaces dentro de las publicaciones */
        }
        .post-container h3 {
            margin-bottom: 10px;
        }
        .post-container p {
            margin-bottom: 15px;
        }
        .post-actions {
            position: absolute; /* Posición absoluta para los enlaces */
            right: 10px; /* Ajusta la distancia desde la derecha */
        }
        .post-actions a {
            margin: 0 5px; /* Agrega margen a los enlaces para separarlos */
        }
        form button {
            margin-left: 500px; /* Agrega margen izquierdo al botón */
        }
    </style>
</head>
<body>
    <h1>BLOG DE TECNOLOGÍA</h1>
    <span>Autor: Victor Rosa</span>
    <br>
    <form action="postController" method="GET">
        <button type="submit" name="action" value="add">Nuevo</button>
    </form>

    <c:forEach var="pos" items="${post}">
        <div class="post-container">
            <h3>${pos.titulo}</h3>
            <span>Fecha: ${pos.fecha}</span>
            <p>${pos.contenido}</p>
            <div class="post-actions"> <!-- Div para los enlaces de acciones -->
                <a href="postController?action=edit&id=${pos.id}">Editar</a>
                <a href="postController?action=delete&id=${pos.id}">Eliminar</a>
            </div>
        </div>
    </c:forEach>
</body>
</html>
