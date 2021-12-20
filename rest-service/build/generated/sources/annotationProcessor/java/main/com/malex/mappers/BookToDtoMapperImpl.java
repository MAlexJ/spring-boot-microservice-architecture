package com.malex.mappers;

import com.malex.models.Book;
import com.malex.models.dto.BookRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T00:27:24+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BookToDtoMapperImpl implements BookToDtoMapper {

    @Override
    public Book addBookRequestToBook(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookRequest.getAuthor() );
        book.setTitle( bookRequest.getTitle() );
        book.setPrice( bookRequest.getPrice() );

        return book;
    }
}
