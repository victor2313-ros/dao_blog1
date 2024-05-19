
package com.emergentes.controlador;

import com.emergentes.dao.postDAOimpl;
import com.emergentes.modelo.post;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.postDAO;

@WebServlet(urlPatterns = {"/postController"})
public class postController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            postDAO dao = (postDAO) new postDAOimpl();
            post pos = new post();
            int id;
            
            String action =(request.getParameter("action")!=null)? request.getParameter("action"):"view";
            switch (action){
                case "add" :
                    request.setAttribute("post", pos);
                    request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    try {
                        pos = dao.getById(id);
                        request.setAttribute("post",pos);
                        request.getRequestDispatcher("frmpost.jsp").forward(request, response); 
                    } catch (Exception ex) {
                        System.out.println("Error al obtener el registro del estudiante: " + ex.getMessage());
                    }
                    break;
                case "delete" :
                    id = Integer.parseInt(request.getParameter("id"));
                    try{
                        dao.delete(id);
                    } catch (Exception ex) {
                        Logger.getLogger(postController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response.sendRedirect("postController");
                    break;
                    
                case "view" :
                    List<post> lista = dao.getAll();
                    request.setAttribute(("post"), lista);
                    request.getRequestDispatcher("post.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(postController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha =request.getParameter("fecha");
        String titulo= request.getParameter("titulo");
        String contenido= request.getParameter("contenido");
        post pos = new post();
             pos.setId(id);
             pos.setFecha(fecha);
             pos.setTitulo(titulo);
             pos.setContenido(contenido);
            postDAO dao=new postDAOimpl();
            
            if (id==0){
                try{
                    dao.insert(pos);
                } catch (Exception ex) {
                Logger.getLogger(postController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                try{
                    dao.update(pos);
                } catch (Exception ex) {
                Logger.getLogger(postController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            response.sendRedirect("postController?action=view");
    }
}
