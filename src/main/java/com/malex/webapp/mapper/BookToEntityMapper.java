package com.malex.webapp.mapper;

import com.malex.webapp.model.Book;
import com.malex.webapp.model.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);

    Book bookEntityToBook(BookEntity bookEntity);
}