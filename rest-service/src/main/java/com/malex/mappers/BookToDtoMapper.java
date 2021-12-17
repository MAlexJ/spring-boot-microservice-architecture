package com.malex.mappers;

import com.malex.models.Book;
import com.malex.models.dto.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookToDtoMapper {

    Book addBookRequestToBook(BookRequest bookRequest);
}
