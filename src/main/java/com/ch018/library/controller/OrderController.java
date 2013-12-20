/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch018.library.controller;

import com.ch018.library.entity.Book;
import com.ch018.library.entity.BooksInUse;
import com.ch018.library.entity.Person;
import com.ch018.library.service.BookInUseService;
import com.ch018.library.service.BookService;
import com.ch018.library.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class OrderController {
    
    @Autowired
    BookService bService;
    @Autowired
    PersonService pService;
    @Autowired
    BookInUseService useService;
    
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(@RequestParam("bookid") Integer bId, @RequestParam("personid") Integer pId, Model model){
        Book book = bService.getBookById(bId);
        Person person = pService.getById(pId);
        List<BooksInUse> bis = useService.getBooksInUseByBook(book);
        model.addAttribute("book", book);
        model.addAttribute("person", person);
        model.addAttribute("biulist", bis);
        return "bookorder";
        
        
    }
    
}
