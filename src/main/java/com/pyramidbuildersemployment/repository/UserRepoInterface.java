package com.pyramidbuildersemployment.repository;


import com.pyramidbuildersemployment.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoInterface extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
