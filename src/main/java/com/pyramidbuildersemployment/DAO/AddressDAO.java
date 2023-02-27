package com.pyramidbuildersemployment.DAO;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.repository.AddressRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
/*
In this implementation, we are using the EntityManager to interact with the database instead of using the AddressRepository.
 The EntityManager allows us to perform CRUD (Create, Read, Update, Delete) operations on the Address entity.
  The @Repository annotation indicates that this class is a Spring bean and should be used for database operations.
   The @Transactional annotation specifies that all methods in this class should be executed within a transaction. This ensures
that if an error occurs during the database operation, the entire transaction will be rolled back and no data will be persisted.

 */
@Repository
@Transactional
public class AddressDAO {

        @Autowired
        private AddressRepoInterface addressRepo;

        public Address findById(long id) {
            return addressRepo.findById(id).orElse(null);
        }

        public List<Address> findAll() {
            return (List<Address>) addressRepo.findAll();
        }

        public Address save(Address address) {
            return addressRepo.save(address);
        }

        public Address update(Address address) {
            return addressRepo.save(address);
        }

        public void delete(Address address) {
            addressRepo.delete(address);
        }
    }


