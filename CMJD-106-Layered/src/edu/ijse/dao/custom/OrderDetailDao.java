/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.dao.custom;

import edu.ijse.dao.CrudDao;
import edu.ijse.entity.OrderDetailEntity;

/**
 *
 * @author ASUS
 */
public interface OrderDetailDao extends CrudDao<OrderDetailEntity, Object>{ // object type --> because order detail has two primary keys as string type we have to pass both of them
       
}
