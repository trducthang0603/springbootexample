package spring_redis.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RedisAtomicLong {
    private final static String MAP_NAME = "atomic_long";
    private final RedisTemplate<String, Object> template;

    public long incrementAndGet(String key) {
        return template.opsForHash()
                .increment(MAP_NAME, key, 1L);
    }
}
