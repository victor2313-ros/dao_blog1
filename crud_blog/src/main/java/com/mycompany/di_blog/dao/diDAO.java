
package com.mycompany.di_blog.dao;

import com.mycompany.crud_blog.modelo.di;
import java.util.List;

public interface diDAO {
    
    public void insert(di blog);
    public void update(di blog);
    public void delete(int id);
    public List<di> getAll();
    public di getById(int id);
    
            
}
