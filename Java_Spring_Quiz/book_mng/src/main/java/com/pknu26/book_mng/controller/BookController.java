package com.pknu26.book_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pknu26.book_mng.entity.Book;
import com.pknu26.book_mng.service.BookService;
import com.pknu26.book_mng.validation.BookForm;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = this.bookService.getBookList();

        model.addAttribute("bookList", bookList);
        return "book_list";
    }

    @GetMapping("/detail/{bookId}")
    public String showDetail(Model model, @PathVariable("bookId") Long bookId){
        Book book = this.bookService.getBookOne(bookId);

        model.addAttribute("book", book);
        return "book_detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    model.addAttribute("bookForm", new BookForm());
    return "book_create";
}

    @PostMapping("/create")
    public String createBook(@Valid BookForm bookForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "book_create";
        }

        this.bookService.setBookOne(bookForm.getTitle(), bookForm.getAuthor(), bookForm.getPublisher(), 
                                    bookForm.getIsbn(), bookForm.getCategory(), bookForm.getPrice(), 
                                    bookForm.getStock(), bookForm.getDescription());
        return "redirect:/book/list";
    }
    
    
}
