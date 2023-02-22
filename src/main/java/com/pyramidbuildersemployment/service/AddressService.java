package com.pyramidbuildersemployment.service;

import java.util.List;

import com.pyramidbuildersemployment.models.Address;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface AddressService {

     List<Address> getAllAddress();


     Address getAddressById(long id) throws ChangeSetPersister.NotFoundException;

     Address saveAll(Address address);

    Address updateAddress(Address address);


     void deleteAddress(long id);
}
