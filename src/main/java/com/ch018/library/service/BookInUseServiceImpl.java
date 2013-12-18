/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.service;

import com.ch018.library.DAO.BooksInUseDao;
import com.ch018.library.entity.Book;
import com.ch018.library.entity.BooksInUse;
import com.ch018.library.entity.Person;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edd Arazian
 */
@Service
public class BookInUseServiceImpl implements BookInUseService {

    @Autowired
    BooksInUseDao useDao;
    
    @Override
    public void save(BooksInUse booksInUse) {
        useDao.save(booksInUse);
    }

    @Override
    public void delete(BooksInUse booksInUse) {
        useDao.delete(booksInUse);
    }

    @Override
    public void update(BooksInUse booksInUse) {
        useDao.update(booksInUse);
    }

    @Override
    public List<BooksInUse> getAll() {
        return useDao.getAll();
    }

    @Override
    public List<BooksInUse> getBooksInUseByPerson(Person person) {
        return useDao.getBooksInUseByPerson(person);
    }

    @Override
    public List<BooksInUse> getBooksInUseByBook(Book book) {
        return useDao.getBooksInUseByBook(book);
    }

    @Override
    public List<BooksInUse> getBooksInUseByIssueDate(Date issue) {
        return useDao.getBooksInUseByIssueDate(issue);
    }

    @Override
    public List<BooksInUse> getBooksInUseByReturnDate(Date returnDate) {
        return useDao.getBooksInUseByReturnDate(returnDate);
    }
    
    
    
}
