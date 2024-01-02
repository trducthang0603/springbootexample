package spring_redis.converter;


import org.springframework.stereotype.Component;
import spring_redis.entity.Author;
import spring_redis.entity.Book;
import spring_redis.entity.Category;
import spring_redis.response.BookResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EntityToResponseConverter {
    public BookResponse toBookResponse(
        Book book,
        Author author,
        Category category
    ) {
        return new BookResponse(
            book.getId(),
            category,
            author,
            book.getName(),
            book.getPrice(),
            DateConverter.toDate(book.getReleaseTime())
        );
    }

    public List<BookResponse> toBooksResponse(
        List<Book> books,
        Map<Long, Author> authors,
        Map<Long, Category> categories
    ) {
        return books.stream().map(it ->
            toBookResponse(
                it,
                authors.get(it.getAuthorId()),
                categories.get(it.getCategoryId())
            )
        ).collect(Collectors.toList());
    }
}
