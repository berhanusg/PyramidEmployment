package com.pyramidbuildersemployment.service;


import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.repository.AddressRepoImplement;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

        private final AddressRepoImplement addressRepository;

        public AddressServiceImpl(AddressRepoImplement addressRepository) {
            this.addressRepository = addressRepository;
        }

        public List<Address> getAllAddress() {
            return (List<Address>) addressRepository.findAll();
        }

        public Address getAddressById(long id) throws ChangeSetPersister.NotFoundException {
            return addressRepository.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        }

    @Override
    public Address saveAll(Address address) {
        return null;
    }

    public Address saveAddress(Address address) {
            return addressRepository.save(address);
        }

        public Address updateAddress(Address address) {
            return addressRepository.save(address);
        }

        public void deleteAddress(long id) {
            addressRepository.deleteById(id);
        }
    }





