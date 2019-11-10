package com.mju.band3.service.impl;

import com.mju.band3.dao.ItemMapper;
import com.mju.band3.dao.WaybillMapper;
import com.mju.band3.entity.Item;
import com.mju.band3.entity.Waybill;
import com.mju.band3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private WaybillMapper waybillMapper;
    @Override
    public List<Item> getItems() {

        return itemMapper.selectAll();
    }

    @Override
    public void insertItem(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public Item getItem(Integer itemId,String waybillId) {
        return itemMapper.selectByPrimaryKey(itemId,waybillId);
    }

    @Override
    public List<Item> getItemByWaybillId(String waybillId) {

        return itemMapper.getItemByWaybillId(waybillId);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKey(item);
    }

    @Override
    public void deleteItemWaybill(String waybillId, Integer itemId) {
        itemMapper.deleteItemWaybill(waybillId,itemId);
    }

    @Override
    public List<Item> selectByContractId(String contractId) {
        return itemMapper.getItemsByContractId(contractId);
    }

    @Override
    public List<Item> selectByLocation(Map<String,String> map) {
        List<Waybill> waybills=waybillMapper.selectByLocation(map);
        List<Item> items=new ArrayList<>();
        for (Waybill w:waybills) {
            items.addAll(itemMapper.getItemByWaybillIdWithoutContractId(w.getWaybillId()));
        }
        HashSet h=new HashSet(items);
        items.clear();
        items.addAll(h);
        return items;
    }

    @Override
    public void deleteByWaybillId(String waybillId) {
        itemMapper.deleteByWaybillId(waybillId);
    }
}
