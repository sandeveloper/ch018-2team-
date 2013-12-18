/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.DAO;

import com.ch018.library.entity.Genre;
import com.ch018.library.util.HibernateUtil;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Edd Arazian
 */
public class GenreDaoImpl implements GenreDao {

    static Logger log = LogManager.getLogger(GenreDaoImpl.class);
    
    @Override
    public void save(Genre genre) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
    }

    @Override
    public void update(Genre genre) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(genre);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
    }

    @Override
    public void update(int id, Genre genre) {
        Session session = null;
        Genre tmp = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            tmp = (Genre) session.get(Genre.class, id);
            tmp.setDescription(genre.getDescription());
            session.update(tmp);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
    }

    @Override
    public void delete(Genre genre) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }  
    }

    @Override
    public List<Genre> getAll() {
        Session session = null;
        List<Genre> genres = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            genres = session.createCriteria(Genre.class).list();
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
        return genres;
    }

    @Override
    public Genre getById(int id) {
        Session session = null;
        Genre genre = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            genre = (Genre) session.get(Genre.class, id);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
        return genre;
    }

    @Override
    public Genre getByDescription(String description) {
    
        Session session = null;
        Genre genre = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            genre = (Genre) session.createQuery("from Genre where description = :d").
                    setString("d", description).list().get(0);
            session.getTransaction().commit();
        }catch(Exception e){
            log.error(e);
        }finally{
            try{
                session.close();
            }catch(Exception e){
                log.error(e);
            }
        }
        return genre;
    }
    
    
    
}
