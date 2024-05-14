
package com.mycompany.di_blog.controlador;

import com.mycompany.di_blog.dao.diDAOImp;
import com.mycompany.crud_blog.modelo.di;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.di_blog.dao.diDAO;

public class servdi extends HttpServlet {

    private diDAO blogDAO;

    public void init() {
        blogDAO = new diDAOImp();
    }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String op = request.getParameter("op");
    String idStr = request.getParameter("id");
    if (idStr != null) {
        int id = Integer.parseInt(idStr);
        List<di> listaBlogs = blogDAO.getAll();
        di blog;

        switch (op) {
            case "create":
                blog = new di();
                request.setAttribute("actualBlog", blog);
                request.getRequestDispatcher("editar.jsp").forward(request, response);

                break;
            case "update":
                int index = getId(id, listaBlogs);
                if (index != -1) {
                    blog = listaBlogs.get(index);
                    request.setAttribute("lastId", id);
                    request.setAttribute("actualBlog", blog);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
                break;
            case "delete":
                if (getId(id, listaBlogs) != -1) {
                    blogDAO.delete(id);
                    response.sendRedirect("index.jsp");
                }
                break;
        }
    }
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        int id = Integer.parseInt(request.getParameter("id"));
        List listaBlogs = blogDAO.getAll();
        
        di blog = new di();
        blog.setId(id);
        blog.setTitulo(titulo);
        blog.setContenido(contenido);
        blog.setFecha(fecha);

        if(getId(id, listaBlogs) != -1){
            blogDAO.update(blog);
        }else{
            blogDAO.insert(blog);
        }
        

        
    }

    public int getId(int id, List<di> lista) {
        int pos = 0;
        for (di blog : lista) {
            if (blog.getId() == id) {
                return pos;
            }
            pos++;
        }
        return -1;
    }
    

}
