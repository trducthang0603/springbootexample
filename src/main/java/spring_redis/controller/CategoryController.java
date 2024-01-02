package spring_redis.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_redis.entity.Category;
import spring_redis.exception.HttpBadRequestException;
import spring_redis.repository.CategoryIdByNameRepository;
import spring_redis.repository.CategoryRepository;
import spring_redis.repository.RedisAtomicLong;
import spring_redis.request.AddCategoryRequest;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final RedisAtomicLong idGentor;
    private final CategoryRepository categoryRepository;
    private final CategoryIdByNameRepository categoryIdByNameRepository;

    @PostMapping("/add")
    public Category addCategory(@RequestBody AddCategoryRequest request) {
        Long existedCategoryId = categoryIdByNameRepository
            .findById(request.getCategoryName())
            .orElse(null);
        if (existedCategoryId != null) {
            throw new HttpBadRequestException(
                "category named: " + request.getCategoryName() + " existed"
            );
        }
        Category category = new Category(
            idGentor.incrementAndGet("category"),
            request.getCategoryName()
        );
        categoryRepository.save(category);
        categoryIdByNameRepository.put(category.getName(), category.getId());
        return category;
    }

}