/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.main;

import com.ch018.library.DAO.BookDAO;
import com.ch018.library.DAO.BookDAOImpl;
import com.ch018.library.DAO.BooksInUseDao;
import com.ch018.library.DAO.BooksInUseDaoImpl;
import com.ch018.library.DAO.GenreDao;
import com.ch018.library.DAO.GenreDaoImpl;
import com.ch018.library.dao.PersonDaoImpl;
import com.ch018.library.entity.Book;
import com.ch018.library.entity.BooksInUse;
import com.ch018.library.entity.Genre;
import com.ch018.library.entity.Person;
import com.ch018.library.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.applet.Main;


/**
 *
 * @author admin
 */
public class NewClass {
    
    //@Autowired
     
    
    public static void main(String[] args) {
        
        
        
        NewClass m = new NewClass();
        m.foo();
      
    }
    
    public void foo() {
        BookDAO bdao = new BookDAOImpl();
        GenreDao gdao = new GenreDaoImpl();
        BooksInUseDao biudao = new BooksInUseDaoImpl();
        Session session = null;
        
        Person person = new Person("gmail.com");
        
        Genre genre = new Genre("BrainFuck");
        Genre genre1 = new Genre("Ordinary");
        Genre genre2 = new Genre("New Wave");
        
        Book book = new Book();
        book.setTitle("Java");
        book.setGenre(genre1);
        
        Book book2 = new Book();
        book2.setTitle("Ruby");
        book2.setGenre(genre2);
        
        Book book3 = new Book();
        book3.setTitle("Scala");
        book3.setGenre(genre);
        
        Book book4 = new Book();
        book4.setTitle("C++");
        book4.setGenre(genre1);
        
        
        person.getBooksInUse().add(book);
        person.getBooksInUse().add(book2);
        
        BooksInUse bis = new BooksInUse();
        bis.setPerson(person);
        bis.setBook(book);
        bis.setReturnDate(new Date());
        
        
        BooksInUse bis1 = new BooksInUse();
        bis1.setPerson(person);
        bis1.setBook(book2);
        bis1.setReturnDate(new Date());
        
        try{
            System.out.println("THERE");
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(genre);
            session.save(genre1);
            session.save(genre2);
            
            session.save(book);
            session.save(book2);
            session.save(book3);
            session.save(book4);
            
            session.save(person);
            
            
            session.save(bis);
            session.save(bis1);
            //session.getTransaction().commit();
            
            
            //session.beginTransaction();
            
            session.delete(bis1);
            
            session.getTransaction().commit();
            
            /*BooksInUse bis3 = new BooksInUse();
            bis3.setPerson(person);
            bis3.setBook(book4);*/
            Person p2 = new Person();
            
            
            System.out.println(biudao.getBooksInUseByPerson(p2));
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }

        }
    }

               
        
        
        
        
    
    

