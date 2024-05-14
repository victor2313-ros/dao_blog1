

<%@page import="com.mycompany.crud_blog.modelo.di"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("seminarios") == null) {
        ArrayList<di> blogs = new ArrayList<>();
        session.setAttribute("blogs", blogs);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blog de Tecnologia</h1>
        <p>Victor Hugo Rosa Mamani</p>
        <a href="servdi?op=create">Nueva entrada</a>
        <ul>
            <c:forEach var="blog" items="${sessionScope.blogs}" >
                <li>blog.getTitulo()</li>
                <li>blog.getFecha()<
                <li>blog.getContenido()</li> 
                <ul>
                    <li><a href="servdi?op=update">Actualizar</a></li>
                    <li><a href="servdi?op=delete">Eliminar</a></li>                    
                </ul>
            </c:forEach>

        </ul>

    </body>
</html>
