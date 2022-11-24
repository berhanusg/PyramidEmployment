package com.pyramidbuildersemployment.repository.service;

import java.util.List;

import com.pyramidbuildersemployment.repository.AddressRepoInterface;
import com.pyramidbuildersemployment.repository.exception.addressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyramidbuildersemployment.models.Address;

@Service
@Transactional
public class AddressServiceRepoImplement {
     
    private final AddressRepoInterface addressRepo;
    @Autowired
    public AddressServiceRepoImplement(AddressRepoInterface addressRepo) {
        this.addressRepo= addressRepo;
    }

    public Address addAddress (Address address){
        return addressRepo.save(address);
    }

    public List<Address> findAllAddresses(){

        return addressRepo.findAll();
    }
    public Address updateAddress(Address address){

        return addressRepo.save(address);
    }

    public void deleteAddress(Long id){

        addressRepo.deleteAddressById(id);
    }

    public Address findAddressBYId(Long id ) throws Throwable {

        return addressRepo.findAddressById(id)
                .orElseThrow(()->new addressNotFoundException("address by id" + id + " was not found"));
    }
}