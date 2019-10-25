package com.mju.band3.service;

import com.mju.band3.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();

    void insertItem(Item item);

    Item getItem(Integer itemId);

    List<Item> getItemByWaybillId(String waybillId);

    void updateItem(Item item);
}
