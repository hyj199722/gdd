package com.mju.band3.dao;

import com.mju.band3.entity.Waybill;
import org.apache.ibatis.annotations.Param;

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

    void changeStatus(@Param("waybillId")String waybillId, @Param("status")Integer status);

    List<Waybill> selectByLocation(Map<String,String> map);
}