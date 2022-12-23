package  com.pyramidbuildersemployment.controller;

import java.util.List;

import com.pyramidbuildersemployment.service.AddressServiceRepoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pyramidbuildersemployment.models.Address;


@RestController
@RequestMapping("/Address")

class AddressController {

	@Autowired
	private AddressServiceRepoImplement addressServiceRepoImplement;
   
	public AddressController(AddressServiceRepoImplement addressServiceRepoimplement) {
		this.addressServiceRepoImplement = addressServiceRepoimplement;
	}
    
    @GetMapping("/all") // change this whatever you want the path to be
	public ResponseEntity<List<Address>>getAllAddresses() {
		List<Address> address = addressServiceRepoImplement.findAllAddresses();
			return  new ResponseEntity<>(address, HttpStatus.OK);
		}

    
	@GetMapping(path = "/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") long id) throws Throwable {
		Address address = addressServiceRepoImplement.findAddressBYId(id);
		return new ResponseEntity<>(address, HttpStatus.OK);

//		if(address == null) {
//			return ResponseEntity.notFound().build();
//		} else {
//			// send a 200 status code with the user object as the response body
//			return ResponseEntity.ok(address);
//		}

	}

    @PostMapping()
	public ResponseEntity<Address> registerAddress(@RequestBody Address address) {

	    address = addressServiceRepoImplement.addAddress(address);
		   return ResponseEntity.status(HttpStatus.CREATED).body(address);

	}

    @PutMapping(path = "/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable long id) {
		if (address.getId() == id) {
			address = addressServiceRepoImplement.updateAddress(address);
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
		addressServiceRepoImplement.deleteAddress(id);

		return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
	}


    
}

