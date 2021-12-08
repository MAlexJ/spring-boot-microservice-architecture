package com.malex.webapp.mapper;

import com.malex.webapp.model.Book;
import com.malex.webapp.model.dto.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookToDtoMapper {

    Book addBookRequestToBook(BookRequest bookRequest);
}
