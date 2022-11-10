package com.pyramidbuildersemployment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyramidbuildersemployment.models.Address;

@Service
@Transactional
public class AddressRepoImplement implements AddressRepoInterface {
     
    private AddressRepoImplement addressRepo;
    @Autowired
    public AddressRepoImplement(AddressRepoImplement addressRepo) {
        this.addressRepo = addressRepo;

    }

    @Override
    public <S extends Address> S save(S entity) {
        
        return entity;
    }

     

    @Override
    public <S extends Address> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Address> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Address> findAll() {
       
        List<Address> address = (List<Address>) addressRepo.findAll();
         
        return address;
    }

    @Override
    public Iterable<Address> findAllById(Iterable<Long> id) {
        List<Address> address = (List<Address>) addressRepo.findAllById(id);
        return address; 
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Address entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Address> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }
    
}
