package com.ch018.library.controller;

import com.ch018.library.DAO.BookDAO;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ch018.library.entity.Book;
import com.ch018.library.service.BookService;
import java.util.List;
/**
 * 
 * @author Yurik Mikhaletskiy
 *
 */

@Controller
public class BooksController {
	

    @Autowired
    BookDAO bDao;
	
	@RequestMapping(value = "/books")
	public ModelAndView booksList() {
		
		List<Book> books = bDao.getAll();
		
		return new ModelAndView("books", "books", books);
	}
}
