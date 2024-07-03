/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao;

import edu.ijse.dao.custom.impl.CustomerDaoImpl;
import edu.ijse.dao.custom.impl.ItemDaoImpl;
import edu.ijse.dao.custom.impl.OrderDaoImpl;
import edu.ijse.dao.custom.impl.OrderDetailDaoImpl;

/**
 *
 * @author ASUS
 */
public class DaoFactory {
     private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){ //Ensures there is only one instance of DaoFactory throughout the application
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type){ //Returns a specific DAO instance (SuperDao) based on the provided DaoTypes enum.
        switch (type) {// Uses a switch statement to determine which DAO implementation to instantiate and return.
            case ITEM:
                return new ItemDaoImpl();
                
            case CUSTOMER:
                return new CustomerDaoImpl();  
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();    
            default:
                return null;
        }
    }

    public enum DaoTypes{ // The getDao method acts as a factory method that returns an instance of a DAO based on the DaoTypes enum parameter.
        ITEM, CUSTOMER, ORDER, ORDER_DETAIL;
    }
}
