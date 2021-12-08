package com.malex.webapp.service;

import com.malex.webapp.exception.BookNotFoundException;
import com.malex.webapp.mapper.BookToEntityMapper;
import com.malex.webapp.model.Book;
import com.malex.webapp.model.entity.BookEntity;
import com.malex.webapp.repository.BookRepository;
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
        BookEntity bookEntity = repository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found by id: " + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> bookEntities = repository.findAll();
        return StreamSupport.stream(bookEntities.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        repository.save(bookEntity);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findAllByAuthorContaining(author)
                .stream()
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }
}
