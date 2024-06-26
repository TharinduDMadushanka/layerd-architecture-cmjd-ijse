/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dto.CustomerDto;
import edu.ijse.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CustomerServiceImpl implements CustomerService{

    @Override
    public String save(CustomerDto customerDto) throws Exception {
        return null;
    }

    @Override
    public String update(CustomerDto customerDto) throws Exception {
        return null; 
    }
    
    @Override
    public String delete(String custIdString) throws Exception {
       return null; 
    }
    @Override
    public CustomerDto get(String custId) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        return null;
    }

}
