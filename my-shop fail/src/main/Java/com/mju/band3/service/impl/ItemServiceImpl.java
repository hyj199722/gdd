package com.mju.band3.service.impl;

import com.mju.band3.dao.ItemMapper;
import com.mju.band3.entity.Item;
import com.mju.band3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Item> getItems() {

        return itemMapper.selectAll();
    }

    @Override
    public void insertItem(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public Item getItem(Integer itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<Item> getItemByWaybillId(String waybillId) {

        return itemMapper.getItemByWaybillId(waybillId);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKey(item);
    }
}
