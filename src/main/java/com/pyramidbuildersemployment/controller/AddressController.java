package  com.pyramidbuildersemployment.controller;

import java.util.List;

import com.pyramidbuildersemployment.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pyramidbuildersemployment.service.AddressService;
 import com.pyramidbuildersemployment.models.Address;
 
 

 

@Controller
@CrossOrigin

class AddressController {
    /*
 NOTE   The AddressController can get to the database indirectly through the AddressService
     interface that it depends on. The AddressService interface defines methods that
     provide access to the database via a AddressRepoInterface instance.
     The AddressServiceImpl class implements the AddressService interface and provides
     the actual implementation for those methods by using the
    AddressRepoInterface instance that it is injected with. The AddressController interacts
     with the AddressService methods to get, create, update or delete Address objects.
  IN Summary  the AddressController interacts with the AddressService interface which, in turn,
    interacts with the underlying database via the AddressRepoInterface instance.

     */
    private AddressService addressService;
   
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

    @GetMapping("/addresses") // change this whatever you want the path to be
	public List<Address> getAllAddress() {
		return addressService.getAllAddress();
	}

    
	@GetMapping(path = "/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
		Address address = addressService.getAddressById(id);

		if (address != null) {
			// send a 200 status code with the user object as the response body
			return ResponseEntity.ok(address);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
//
//    @GetMapping("/address/register")
//	public String registerAddress(Model model) {
//		model.addAttribute("address", new AddressDTO());
//	    //address = addressService.saveAll(address); WRONG
//		   return "address";
//
//	}
@GetMapping("/address/register")
public String registerAddress(@ModelAttribute("address") AddressDTO address, Model model) {
	model.addAttribute("addressList", addressService.getAllAddress());
	return "address";
}


//	@PostMapping("/address-process")
//	public String processAddressRegistartion(@ModelAttribute ("address") AddressDTO addressDTO, Model model)
//	{
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		Address address = modelMapper.map(addressDTO, Address.class);
//		addressService.registerAddress(address);
//		return "index";
//	}
	@PostMapping("/address-process")
	public String saveAddress(@ModelAttribute("address") AddressDTO addressDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Address address = modelMapper.map(addressDTO, Address.class);
		addressService.registerAddress(address);
		return "redirect:/address/register";
	}




//	@PutMapping(path = "address/{id}")
//	public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDto, @PathVariable long id) {
//		Address address = new Address();
//		if (address.getAddressById() == id) {
//			address = addressService.updateAddress(address);
//			if (address != null) {
//				AddressDTO updatedAddressDto = new AddressDTO( );
//				return ResponseEntity.ok(updatedAddressDto);
//			} else {
//				return ResponseEntity.badRequest().build();
//			}
//		} else {
//			return ResponseEntity.status(HttpStatus.CONFLICT).build();
//		}
//	}

	@PutMapping(path = "address/{id}")
	public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDto, @PathVariable long id) {
		Address address = new Address();
		if (address.getAddressById() == id) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			modelMapper.map(addressDto, address);
			address = addressService.updateAddress(address);
			if (address != null) {
				AddressDTO updatedAddressDto = modelMapper.map(address, AddressDTO.class);
				return ResponseEntity.ok(updatedAddressDto);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@DeleteMapping(path = "address/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable long id) {

		// delete address from DB
		addressService.deleteAddress(id);

		return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
	}


    
}

