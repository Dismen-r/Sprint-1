package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;
import com.capg.springboot.repository.IAddressRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IAddressServiceTest {

	@Autowired
	private IAddressService iaddressservice;

	@MockBean
	private IAddressRepository iaddressrepository;
	
	// Method : DeleteTest 
	// Description : it will check the service layer is successfully deleting the object or not.
	 
	@Test
	public void deleteAddressTest() 
	{
		Address delete = new Address();

		delete.setBuildingName("Mahesh");
		delete.setAddressId("1");
		delete.setCity("Trichy");
		delete.setCountry("India");
		delete.setState("Tamilnadu");
		delete.setPincode("666666");
		
		iaddressservice.removeAddress(delete);		
		verify(iaddressrepository,times(1)).delete(delete);
		
	}

//*********************************************************************************************************************	
	// Method : GetAddressTest 
	// Description : it will check the service layer is successfully getting the object or not.
	@Test
	public void getaddressTest() throws AddressNotFoundException {
		Address add = new Address();

		add.setBuildingName("Mahesh");
		add.setAddressId("1");
		add.setCity("Trichy");
		add.setCountry("India");
		add.setState("Tamilnadu");
		add.setPincode("666666");

		Address add1 = new Address();

		add.setBuildingName("Mahesh");
		add.setAddressId("1");
		add.setCity("Trichy");
		add.setCountry("India");
		add.setState("Tamilnadu");
		add.setPincode("666666");
		

		when(iaddressrepository.findAll()).thenReturn(Stream.of(add, add1).collect(Collectors.toList()));
		assertEquals(2, iaddressservice.viewAllAddress().size());
	}

//*********************************************************************************************************************	
	
	// Method : saveAddressTest 
	// Description : it will check the service layer is successfully saving the object or not.
	
	@Test
	public void saveAddressTest() {
		Address save = new Address();

		save.setBuildingName("Mahesh");
		save.setAddressId("1");
		save.setCity("Trichy");
		save.setCountry("");
		save.setState("Tamilnadu");
		save.setPincode("666666");

		when(iaddressrepository.save(save)).thenReturn(save);
		assertEquals(save, iaddressservice.addAddress(save));
	}


}
