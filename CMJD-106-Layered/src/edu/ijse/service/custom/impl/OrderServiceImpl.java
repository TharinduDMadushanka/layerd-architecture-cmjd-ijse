/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.ItemDao;
import edu.ijse.dao.custom.OrderDao;
import edu.ijse.dao.custom.OrderDetailDao;
import edu.ijse.db.DBConnection;
import edu.ijse.dto.OrderDetailDto;
import edu.ijse.dto.OrderDto;
import edu.ijse.entity.ItemEntity;
import edu.ijse.entity.OrderDetailEntity;
import edu.ijse.entity.OrderEntity;
import edu.ijse.service.custom.OrderService;
import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class OrderServiceImpl implements OrderService{
    
    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao= (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {

            // Start transaction
            connection.setAutoCommit(false);
            // Save order
            OrderEntity orderEntity = new OrderEntity(orderDto.getOrederId(), orderDto.getCustId(), orderDto.getDate());
            if(orderDao.create(orderEntity)){
                boolean isOrderDetailSaved = true;

                // Save order details
                for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity(orderDto.getOrederId(),
                            orderDetailDto.getItemCode(),
                            orderDetailDto.getQty(),
                            orderDetailDto.getDiscount());
                    if(!orderDetailDao.create(orderDetailEntity)){
                        isOrderDetailSaved = false;
                    }
                }

                if(isOrderDetailSaved){

                    boolean isItemUpdated = true;
                     // Update item quantities
                    for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemCode());
                        if(itemEntity != null){
                            itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                            if(!itemDao.update(itemEntity)){
                                isItemUpdated = false;
                            }
                        }
                    }
                    if(isItemUpdated){
                        connection.commit(); // Commit transaction
                        return "Success";
                    } else{
                        connection.rollback(); // Rollback transaction
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback(); // Rollback transaction
                    return "Order Detail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            connection.rollback(); // Rollback transaction in case of exception
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);// Restore auto-commit
        }
    }

}