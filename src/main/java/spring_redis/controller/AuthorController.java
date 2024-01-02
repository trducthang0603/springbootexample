package spring_redis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_redis.entity.Author;
import spring_redis.repository.AuthorRepository;
import spring_redis.repository.RedisAtomicLong;
import spring_redis.request.AddAuthorRequest;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final RedisAtomicLong idGentor;
    private final AuthorRepository authorRepository;

    @PostMapping("/add")
    public Author addAuthor(@RequestBody AddAuthorRequest request) {
        Author author = new Author(
            idGentor.incrementAndGet("author"),
            request.getAuthorName()
        );
        authorRepository.save(author);
        return author;
    }

}