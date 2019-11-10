package com.mju.band3.service;

import com.mju.band3.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    List<Item> getItems();

    void insertItem(Item item);

    Item getItem(Integer itemId,String waybillId);

    List<Item> getItemByWaybillId(String waybillId);

    void updateItem(Item item);

    void deleteItemWaybill(String waybillId,Integer itemId);

    List<Item> selectByContractId(String contractId);

    List<Item> selectByLocation(Map<String,String> map);

    void deleteByWaybillId(String waybillId);

}
