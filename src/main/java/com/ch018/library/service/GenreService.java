/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.service;

import com.ch018.library.entity.Genre;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edd Arazian
 */
@Service
public interface GenreService {
    
    void save(Genre genre);
    void update(Genre genre);
    void update(int id, Genre genre);
    void delete(Genre genre);
    List<Genre> getAll();
    Genre getById(int id);
    Genre getByDescription(String description); 
    
}
