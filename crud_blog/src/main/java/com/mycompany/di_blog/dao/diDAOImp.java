package com.mycompany.di_blog.dao;

import com.mycompany.crud_blog.modelo.di;
import com.mycompany.di_blog.utiles.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class diDAOImp extends ConexionDB implements diDAO {
 
    
    @Override
    public void insert(di blog) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO posts VALUES(?,?,?,?);");
            ps.setInt(1, blog.getId());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setDate(4, Date.valueOf(blog.getFecha()));
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(diDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void update(di blog) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE posts SET titulo=?, contenido=?, fecha=? WHERE id=?");

            ps.setString(1, blog.getTitulo());
            ps.setString(2, blog.getContenido());
            ps.setDate(3, Date.valueOf(blog.getFecha()));
            ps.setInt(4, blog.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(diDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) {
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM posts WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(diDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
    }

    @Override
    public List<di> getAll() {
        List blogs = null;
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                di b1 = new di();

                b1.setId(rs.getInt("id"));
                b1.setTitulo(rs.getString("titulo"));
                b1.setContenido(rs.getString("contenido"));
                b1.setFecha(rs.getDate("fecha").toLocalDate());

                blogs.add(b1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(diDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
        return blogs;
    }

    @Override
    public di getById(int id) {
        di b1 = new di();
        try {
            this.Conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts WHERE id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                b1.setId(rs.getInt("id"));
                b1.setTitulo(rs.getString("titulo"));
                b1.setContenido(rs.getString("contenido"));
                b1.setFecha(rs.getDate("fecha").toLocalDate());

            }

        } catch (SQLException ex) {
            Logger.getLogger(diDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Desconectar();
        }
        return b1;
    }

}
