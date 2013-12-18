package com.ch018.library.DAO;

import java.util.List;



import com.ch018.library.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface BookDAO {
	void save(Book book);
        void delete(Book book);
        void update(Book book);
	List<Book> getAll();
	Book getBookById(int id);
	List<Book> getBooksByTitle(String title);
	List<Book> getBooksByAuthors(String authors);
	List<Book> getBooksByYear(int year);
}
