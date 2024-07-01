/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.CustomerDao;
import edu.ijse.dto.CustomerDto;
import edu.ijse.entity.CustomerEntity;
import edu.ijse.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CustomerServiceImpl implements CustomerService{
    
    private CustomerDao CustomerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String save(CustomerDto customerDto) throws Exception {
        CustomerEntity entity = getCustomerEntity(customerDto);
        return CustomerDao.create(entity)? "Success" : "Fail";
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
    public CustomerDto getCustomer(String custId) throws Exception {
        CustomerEntity entity = CustomerDao.get(custId);
        if(entity != null){
            CustomerDto dto = new CustomerDto(entity.getId(),
                    entity.getTitle(),
                    entity.getName(),
                    entity.getDob(),
                    entity.getSalary(),
                    entity.getAddress(),
                    entity.getCity(),
                    entity.getProvince(),
                    entity.getPostal());
            return dto;
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        return null;
    }

    private CustomerEntity getCustomerEntity(CustomerDto customerDto){
        return new CustomerEntity(
        customerDto.getId(),
        customerDto.getTitle(),
        customerDto.getName(),
        customerDto.getDob(),
        customerDto.getSalary(),
        customerDto.getAddress(),
        customerDto.getCity(),
        customerDto.getProvince(),
        customerDto.getPostal());
    }
    
    private CustomerDto customerDto(CustomerEntity entity){
        return new CustomerDto(
        entity.getId(),
        entity.getTitle(),
        entity.getName(),
        entity.getDob(),
        entity.getSalary(),
        entity.getAddress(),
        entity.getCity(),
        entity.getProvince(),
        entity.getPostal());
    }
}
