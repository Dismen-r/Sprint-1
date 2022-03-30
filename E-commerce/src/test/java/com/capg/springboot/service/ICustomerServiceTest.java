package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.Exceptions.CustomerNotFoundException;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.repository.ICustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICustomerServiceTest {

	@InjectMocks
	private ICustomerServiceImpl icustomerserviceimpl;
	
	@Mock
	private ICustomerRepository icustomerrespository;
	
	@Test
	public void addCustomerTest() throws CustomerNotFoundException{
		System.out.println("hello");
		
		  Customer cust = new Customer();
		  
		  cust.setCustomerId("100"); cust.setEmail("mahesh@gmail");			
		  cust.setFirstName("Mahesh");
		  
		  Mockito.doReturn(cust).when(icustomerrespository).findByCustomerId(Mockito.any());
		  
		  assertEquals(cust.getCustomerId(),icustomerserviceimpl.findByCustomerId(cust).getCustomerId());
		  
		 
	}
	
	
}