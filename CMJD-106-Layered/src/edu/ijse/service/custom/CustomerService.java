/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.custom;

import edu.ijse.dto.CustomerDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface CustomerService extends SuperService {
    
    String save(CustomerDto customerDto)throws Exception;
    String update(CustomerDto customerDto)throws Exception;
    String delete(CustomerDto customerDto)throws Exception;
    CustomerDto get(String custId)throws Exception;
    ArrayList<CustomerDto>getAll()throws Exception;
}
