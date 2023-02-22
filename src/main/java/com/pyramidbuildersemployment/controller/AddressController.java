package  com.pyramidbuildersemployment.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyramidbuildersemployment.service.AddressService;
 import com.pyramidbuildersemployment.models.Address;
 
 

 

@RestController
@CrossOrigin
@RequestMapping("/Address")

class AddressController {
    
    private AddressService addressService;
   
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
    
    @GetMapping() // change this whatever you want the path to be
	public List<Address> getAllAddress() {
		return addressService.getAllAddress();
	}

    
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
		Address address = addressService.getAddressById(id);

		if (address != null) {
			// send a 200 status code with the user object as the response body
			return ResponseEntity.ok(address);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

    @PostMapping()
	public ResponseEntity<Address> registerAddress(@RequestBody Address address) {

	    address = addressService.saveAll(address);
		   return ResponseEntity.status(HttpStatus.CREATED).body(address);

	}

    @PutMapping(path = "/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable long id) {
		// System.out.println("test");
		// return new ResponseEntity<Customer>(customerService.updateCustomer(customer),
		// HttpStatus.OK);

		if (address.getAddressById() == id) {
			address = addressService.updateAddress(address);
			if (address != null) {
				return ResponseEntity.ok(address);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}
    @DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable long id) {

		// delete address from DB
		addressService.deleteAddress(id);

		return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
	}


    
}

