package spring_redis.converter;


import org.springframework.stereotype.Component;
import spring_redis.entity.Book;
import spring_redis.request.AddBookRequest;

@Component
public class RequestToEntityConverter {
    public Book toBookEntity(AddBookRequest request, Long bookId) {
        return new Book(
            bookId,
            request.getCategoryId(),
            request.getAuthorId(),
            request.getBookName(),
            request.getPrice(),
            DateConverter.toLocalDate(request.getReleaseDate()),
            DateConverter.toLocalDateTime(request.getReleaseTime())
        );
    }
}