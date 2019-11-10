package com.mju.band3.dao;

import com.mju.band3.entity.Item;
import com.mju.band3.entity.Waybill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    Item selectByPrimaryKey(@Param("itemId")Integer itemId,@Param("waybillId")String waybillId);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);

    List<Item> getItemByWaybillId(String waybillId);

    void deleteItemWaybill(@Param("waybillId")String waybillId,@Param("itemId") Integer itemId);

    List<Item> getItemsByContractId(String contractId);

    List<Item> getItemByWaybillIdWithoutContractId(String waybillId);

    void upload(@Param("itemId")Integer itemId,@Param("waybillId")String waybillId,@Param("contractId")String contractId);

    void unload(@Param("itemId")Integer itemId,@Param("waybillId")String waybillId);

    void deleteByWaybillId(String waybillId);

    List<Item> unloadItems(String waybillId);

}