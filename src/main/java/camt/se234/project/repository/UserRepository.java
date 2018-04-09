package camt.se234.project.repository;

import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
