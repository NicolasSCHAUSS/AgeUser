package web.atrio.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import web.atrio.thymeleaf.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
    
}
