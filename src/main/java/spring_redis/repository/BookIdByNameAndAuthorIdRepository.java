package spring_redis.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import spring_redis.entity.BookNameAndAuthorId;

import java.io.IOException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class BookIdByNameAndAuthorIdRepository {
    private final static String MAP_NAME = "SpringBootRedis.BookIdByNameAndAuthorId";
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;

    public Optional<Long> findById(BookNameAndAuthorId id) {
        try{
            String idString = objectMapper.writeValueAsString(id);
            return Optional.ofNullable((Long) redisTemplate.opsForHash().get(MAP_NAME,idString));
        }
        catch (
                IOException e
        ){
            throw new IllegalStateException();
        }
    }
    public void put(BookNameAndAuthorId id, Long bookId) {
        try {
            String idString = objectMapper.writeValueAsString(id);
            redisTemplate.opsForHash()
                    .put(MAP_NAME, idString, bookId);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
