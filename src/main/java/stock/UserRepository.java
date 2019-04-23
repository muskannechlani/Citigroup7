package stock;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

   

    List<User> findAll();

   

    User save(User user);
}
