/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.service;

import com.ch018.library.DAO.GenreDao;
import com.ch018.library.entity.Genre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edd ARazian
 */
@Service
public class GenreServiceImpl implements GenreService {
    
    @Autowired
    GenreDao gDao;

    @Override
    public void save(Genre genre) {
        gDao.save(genre);
    }

    @Override
    public void update(Genre genre) {
        gDao.update(genre);
    }

    @Override
    public void update(int id, Genre genre) {
        gDao.update(id, genre);
    }

    @Override
    public void delete(Genre genre) {
        gDao.delete(genre);
    }

    @Override
    public List<Genre> getAll() {
        return gDao.getAll();
    }

    @Override
    public Genre getById(int id) {
        return gDao.getById(id);
    }

    @Override
    public Genre getByDescription(String description) {
        return gDao.getByDescription(description);
    }
    
    
    
}
