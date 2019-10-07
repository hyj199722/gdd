package com.mju.band3.dao;

import com.mju.band3.entity.Item;
import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    Item selectByPrimaryKey(Integer itemId);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);
}