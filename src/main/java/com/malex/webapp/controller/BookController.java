package com.malex.webapp.controller;

import com.malex.webapp.mapper.BookToDtoMapper;
import com.malex.webapp.model.Book;
import com.malex.webapp.model.dto.BookRequest;
import com.malex.webapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;
    private final BookToDtoMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return service.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if (Objects.nonNull(author)) {
            return service.findByAuthor(author);
        }
        return service.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        Book book = mapper.addBookRequestToBook(request);
        service.addBook(book);
    }

}
