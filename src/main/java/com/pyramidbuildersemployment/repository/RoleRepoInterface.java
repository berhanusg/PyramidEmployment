package com.pyramidbuildersemployment.repository;


import com.pyramidbuildersemployment.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepoInterface extends CrudRepository<Role, Long > {
    Role findByName(Role.RoleName roleName);

}
