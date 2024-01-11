package cleancode.v1.repo;

import cleancode.v1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //Boolean containsByField(String email, String email1);
}
