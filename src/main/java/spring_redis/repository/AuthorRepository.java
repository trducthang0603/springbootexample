package spring_redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_redis.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
