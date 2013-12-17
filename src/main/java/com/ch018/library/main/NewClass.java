/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.main;

import com.ch018.library.DAO.BookDAOImpl;
import com.ch018.library.dao.PersonDaoImpl;
import com.ch018.library.entity.Book;
import com.ch018.library.entity.BooksInUse;
import com.ch018.library.entity.Person;
import com.ch018.library.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;


/**
 *
 * @author admin
 */
public class NewClass {
    
    public static void main(String[] args) {
        
      
        Session session = null;
        
        Person person = new Person("gmail.com");
         
        Book book = new Book();
        book.setTitle("Java");
        
        Book book2 = new Book();
        book2.setTitle("Ruby");
        
        person.getBooksInUse().add(book);
        person.getBooksInUse().add(book2);
        
        BooksInUse bis = new BooksInUse();
        bis.setPerson(person);
        bis.setBook(book);
        bis.setIssueDate(new Date());
        
        
        BooksInUse bis1 = new BooksInUse();
        bis1.setPerson(person);
        bis1.setBook(book2);
        bis1.setIssueDate(new Date());
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(book);
            session.save(book2);
            
            session.save(person);
            
            
            session.save(bis);
            session.save(bis1);
            //session.getTransaction().commit();
            
            
            //session.beginTransaction();
            
            session.delete(bis1);
            
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
        }

        }

               
        
        
        
        
    }
    

