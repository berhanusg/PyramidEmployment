package com.pyramidbuildersemployment.service;


import com.pyramidbuildersemployment.models.Address;

import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.repository.AddressRepoInterface;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private  AddressRepoInterface addressRepointerface;

        public AddressServiceImpl(AddressRepoInterface addresinterface) {
            this.addressRepointerface= addresinterface;
        }

        public List<Address> getAllAddress() {
            return (List<Address>) addressRepointerface.findAll();
        }

        public Address getAddressById(long id) throws ChangeSetPersister.NotFoundException {
            return addressRepointerface.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        }

    @Override
    public Address saveAll(Address address) {
        return null;
    }

    public Address saveAddress(Address address) {
            return addressRepointerface.save(address);
        }

        public Address updateAddress(Address address) {
            return addressRepointerface.save(address);
        }

        public void deleteAddress(long id) {
            addressRepointerface.deleteById(id);
        }

    public Address registerAddress(Address address) {
        return addressRepointerface.save(address);
    }
    }





