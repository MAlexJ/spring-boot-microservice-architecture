package com.malex.mappers;

import com.malex.models.Book;
import com.malex.models.entities.BookEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T00:27:23+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BookToEntityMapperImpl implements BookToEntityMapper {

    @Override
    public BookEntity bookToBookEntity(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( book.getId() );
        bookEntity.setAuthor( book.getAuthor() );
        bookEntity.setTitle( book.getTitle() );
        bookEntity.setPrice( book.getPrice() );

        return bookEntity;
    }

    @Override
    public Book bookEntityToBook(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookEntity.getId() );
        book.setAuthor( bookEntity.getAuthor() );
        book.setTitle( bookEntity.getTitle() );
        book.setPrice( bookEntity.getPrice() );

        return book;
    }
}
