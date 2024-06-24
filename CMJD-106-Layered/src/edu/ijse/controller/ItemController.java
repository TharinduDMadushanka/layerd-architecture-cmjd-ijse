/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.controller;

import edu.ijse.dto.ItemDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.custom.ItemService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ItemController {
    
    private ItemService itemService = (ItemService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
    public String save(ItemDto itemDto)throws Exception{
        return itemService.save(itemDto);
    }
    
    public String update(ItemDto itemDto)throws Exception{
        return itemService.update(itemDto);
    }
    
    public String delete(String itemCode)throws Exception{
        return itemService.delete(itemCode);
    }
    
    public ArrayList<ItemDto> gelAll()throws Exception{
        return itemService.getAll();
    }
    
    public ItemDto get(String itemCode)throws Exception{
        return itemService.get(itemCode);
    }
}
