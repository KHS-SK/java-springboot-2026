package com.pknu26.book_mng.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.book_mng.entity.Book;
import com.pknu26.book_mng.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBookList(){
        return this.bookRepository.findAll();
    }

    public Book getBookOne(Long bookId){
        Optional<Book> opBook = this.bookRepository.findById(bookId);

        if(opBook.isPresent()){
            return opBook.get();
        } else {
            throw new RuntimeException("Data not found");
        }
    }

    public boolean setBookOne(String title, String author, String publisher, String isbn, String category, Integer price, Integer stock, String description) {
        Book book = new Book();

        try {
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setIsbn(isbn);
            book.setCategory(category);
            book.setPrice(price);
            book.setStock(stock);
            book.setDescription(description);
            book.setCreatedAt(LocalDateTime.now());
            
            this.bookRepository.save(book);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
