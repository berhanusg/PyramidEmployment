package com.pyramidbuildersemployment.repository;


import com.pyramidbuildersemployment.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoInterface extends CrudRepository<User, Long> {

   // @Query()
    //User findByEmail(String email);


    @Query("select u from User u where u.email= :email")
    public User findByEmail(@Param("email") String email);
}
