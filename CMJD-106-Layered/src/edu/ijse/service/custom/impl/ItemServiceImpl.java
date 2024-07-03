package edu.ijse.service.custom.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.custom.ItemDao;
import edu.ijse.dto.ItemDto;
import edu.ijse.entity.ItemEntity;
import edu.ijse.service.custom.ItemService;
import java.util.ArrayList;


public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    //Converts ItemDto to ItemEntity, then uses itemDao.create(entity) to save the item.
    @Override
    public String save(ItemDto itemDto) throws Exception {
      
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.create(entity) ? "Success" : "Fail";
    }

    // Converts ItemDto to ItemEntity, then uses itemDao.update(entity) to update the item.
    @Override
    public String update(ItemDto itemDto) throws Exception {
        
        ItemEntity entity = getItemEntity(itemDto);
        return itemDao.update(entity) ? "Success" : "Fail";
    }

    //Deletes an item using itemDao.delete(itemCode).
    @Override
    public String delete(String itemCode) throws Exception {
        
        return itemDao.delete(itemCode) ?  "Success" : "Fail";
    }

    //Retrieves an item using itemDao.get(itemCode) and converts the result to ItemDto.
    @Override
    public ItemDto get(String itemCode) throws Exception {
        ItemEntity entity = itemDao.get(itemCode);
        if(entity != null){
            return getItemDto(entity);
        }
        return null;
    }

    //Retrieves all items using itemDao.getAll() and converts the list of ItemEntity objects to a list of ItemDto objects.
    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = itemDao.getAll();
        if(itemEntitys != null && !itemEntitys.isEmpty()){
            ArrayList<ItemDto> itemDtos = new ArrayList<>();

            for (ItemEntity itemEntity : itemEntitys) {
                itemDtos.add(getItemDto(itemEntity));
            }

            return itemDtos;
        }
        return null;
    }

    /**
     *  Methods like getItemEntity and getItemDto convert between ItemDto 
     * (data transfer objects used in the service layer) and ItemEntity (entities used in the DAO layer). 
     * This mapping ensures that data is correctly transferred between layers without exposing internal structures.
     */
    
    private ItemEntity getItemEntity(ItemDto itemDto){
        return  new ItemEntity(
                itemDto.getItemCode(),
                itemDto.getDescription(), 
                itemDto.getPack(), 
                itemDto.getQoh(),
                itemDto.getUnitPrice());
    }

    private ItemDto getItemDto(ItemEntity entity){
        return  new ItemDto(entity.getItemCode(),
                entity.getDescription(),
                entity.getPack(), 
                entity.getQoh(),
                entity.getUnitPrice());
    }

}