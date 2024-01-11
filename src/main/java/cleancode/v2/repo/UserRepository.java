package cleancode.v2.repo;

import cleancode.v2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //Boolean containsByField(String email, String email1);
}
