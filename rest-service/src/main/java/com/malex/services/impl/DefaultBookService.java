package com.malex.services.impl;

import com.malex.exceptions.BookNotFoundException;
import com.malex.mappers.BookToEntityMapper;
import com.malex.models.Book;
import com.malex.models.entities.BookEntity;
import com.malex.repositories.BookRepository;
import com.malex.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository repository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found by id: " + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> bookEntities = repository.findAll();
        return StreamSupport.stream(bookEntities.spliterator(), false).map(mapper::bookEntityToBook).collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        repository.save(bookEntity);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findAllByAuthorContaining(author).stream().map(mapper::bookEntityToBook).collect(Collectors.toList());
    }
}
