/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.controller;

import edu.ijse.dto.CustomerDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CustomerController {
    private CustomerService customerService= (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    
    public String save(CustomerDto customerDto)throws Exception{
        return customerService.save(customerDto);
    }
    
    public String update(CustomerDto customerDto)throws Exception{
        return customerService.update(customerDto);
    }
    
    public String delete(String custId)throws Exception{
        return customerService.delete(custId);
    }
    
    public ArrayList<CustomerDto>getAll()throws Exception{
        return customerService.getAll();
    }
    
    public CustomerDto get(String custId)throws Exception{
        return customerService.get(custId);
    }
}
