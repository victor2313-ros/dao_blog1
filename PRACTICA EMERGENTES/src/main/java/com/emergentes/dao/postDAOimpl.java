
package com.emergentes.dao;
import com.emergentes.modelo.post;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class postDAOimpl extends ConexionDB implements postDAO {

    @Override
    public void insert(post post) throws Exception {
      String sql = "insert into posts (fecha,titulo,contenido)values(?,?,?)";
      this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, post.getFecha());
        ps.setString(2, post.getTitulo());
        ps.setString(3, post.getContenido());
        ps.executeUpdate();
    }

    @Override
    public void update(post post) throws Exception {
           String sql = "update posts set fecha=?,titulo=?, contenido=? where id=?";
      this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
         ps.setString(1, post.getFecha());
         ps.setString(2, post.getTitulo());
         ps.setString(3, post.getContenido());
         ps.setInt(4, post.getId());
         ps.executeUpdate();
    
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from posts where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }



    @Override
    public List<post> getAll() throws Exception {
       List<post> lista=null;
        String sql= "select * from posts";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista =new ArrayList<post>();
        while(rs.next()){
            post pos =new post();
            pos.setId(rs.getInt("id"));
            pos.setFecha(rs.getString("fecha"));
            pos.setTitulo(rs.getString("titulo"));
            pos.setContenido(rs.getString("contenido"));
            lista.add(pos);
        }
        return lista;
    }
        @Override
    public post getById(int id) throws Exception {
        post pos=new post();
        try{
        String sql= "select * from posts where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            pos.setId(rs.getInt("id"));
            pos.setFecha(rs.getString("fecha"));
            pos.setTitulo(rs.getString("titulo"));
            pos.setContenido(rs.getString("contenido"));
        }}catch(SQLException e){
                throw e;
                }finally{
                        this.desconectar();
                        }
        return pos;
    }
    
}
