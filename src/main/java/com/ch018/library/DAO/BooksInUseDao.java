/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.DAO;

import com.ch018.library.entity.Book;
import com.ch018.library.entity.BooksInUse;
import com.ch018.library.entity.Person;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Edd Arazian
 */
public interface BooksInUseDao {
    
    void save(BooksInUse booksInUse);
    void delete(BooksInUse booksInUse);
    void update(BooksInUse booksInUse);
    List<BooksInUse> getAll();
    List<BooksInUse> getBooksInUseByPerson(Person person);
    List<BooksInUse> getBooksInUseByBook(Book book);
    List<BooksInUse> getBooksInUseByIssueDate(Date issue);
    List<BooksInUse> getBooksInUseByReturnDate(Date issue);
    
}
