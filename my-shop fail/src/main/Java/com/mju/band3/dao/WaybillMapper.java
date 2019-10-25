package com.mju.band3.dao;

import com.mju.band3.entity.Waybill;
import java.util.List;
import java.util.Map;

public interface WaybillMapper {
    int deleteByPrimaryKey(String waybillId);

    int insert(Waybill record);

    Waybill selectByPrimaryKey(String waybillId);

    List<Waybill> selectAll();

    List<Waybill> selectAllInOrder();

    int updateByPrimaryKey(Waybill record);

    List<Waybill> waybillSearch(Map<String,Object> map);

    void changeStatus(String waybillId,Integer status);
}