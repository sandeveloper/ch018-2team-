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
import com.ch018.library.service.GenreService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author Yurik Mikhaletskiy
 *
 */

@Controller
@RequestMapping(value = "/books")
public class BooksController {
	

    @Autowired
    BookService bServ;
    @Autowired
    GenreService gServ;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String booksList(Model model) {
		          model.addAttribute("genres", gServ.getAll());
                          return "addBook";
	}
        
        @RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String booksList(@ModelAttribute() Book book, @RequestParam("genreId") Integer gid) {
		          book.setGenre(gServ.getById(gid));
                          try{
                          bServ.save(book);
                          }catch(Exception e){
                              System.out.println(e);
                          }
                          return "redirect:/books/addBook";
	}
}
