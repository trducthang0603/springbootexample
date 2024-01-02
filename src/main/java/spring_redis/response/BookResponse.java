package spring_redis.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import spring_redis.entity.Author;
import spring_redis.entity.Category;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
public class BookResponse {
    private Long bookId;
    private Category category;
    private Author author;
    private String bookName;
    private BigDecimal price;
    private Date releaseTime;
}