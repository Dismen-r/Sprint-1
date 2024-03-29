package com.capg.springboot.service;

import java.util.List;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;


public interface IAddressService {

   
   public Address addAddress(Address add);
   public Address removeAddress(Address add);
   public Address updateAddress(Address add);
   public Address viewAddressBy(String add) throws AddressNotFoundException;
   public List<Address> viewAllAddress() throws AddressNotFoundException;


}
