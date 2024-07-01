/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dto;

/**
 *
 * @author ASUS
 */
public class OrderDetailDto {
    private String orderId;
    private String ItemCode;
    private int qty;
    private int discount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String orderId, String ItemCode, int qty, int discount) {
        this.orderId = orderId;
        this.ItemCode = ItemCode;
        this.qty = qty;
        this.discount = discount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "orderId=" + orderId + ", ItemCode=" + ItemCode + ", qty=" + qty + ", discount=" + discount + '}';
    }
      
}
