package spring_redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_redis.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
