package spring_redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_redis.entity.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book,Long> {
}
