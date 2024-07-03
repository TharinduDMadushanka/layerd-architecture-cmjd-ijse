/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service;

import edu.ijse.service.custom.CustomerService;
import edu.ijse.service.custom.impl.CustomerServiceImpl;
import edu.ijse.service.custom.impl.ItemServiceImpl;
import edu.ijse.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author ASUS
 */
public class ServiceFactory {
    
    private static ServiceFactory serviceFactory; //Private static variable serviceFactory holds the single instance.
    
    private ServiceFactory(){} //Private constructor to prevent instantiation from outside.
    
    public static ServiceFactory getInstance(){ //Public static method getInstance returns the single instance, creating it if necessary.
        if(serviceFactory == null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    
    /*
    The getService method takes a ServiceType enum as a parameter and returns an instance of the corresponding service
    */
    
    public SuperService getService(ServiceType serviceType){
    
        switch (serviceType) {//Uses a switch statement to determine which service to create.
            case ITEM:
                return new ItemServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            default:
                return null;
        }
        
    }
    
    /*
    Defines the types of services (ITEM, CUSTOMER, ORDER) that can be created by the factory.
    */
    
    public enum ServiceType{    
        ITEM,
        CUSTOMER,
        ORDER
    }
}
