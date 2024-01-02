package spring_redis.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryIdByNameRepository {
    private final static String MAP_NAME = "SpringBootRedis.CategoryIdByName";
    private final RedisTemplate redisTemplate;

    public void put(String categoryName, Long id){
        redisTemplate.opsForHash()
                .put(MAP_NAME, categoryName,id);
    }
    public Optional<Long> findById(String categoryName){
        return Optional.ofNullable((Long) redisTemplate.opsForHash().get(MAP_NAME,categoryName));
    }
}
