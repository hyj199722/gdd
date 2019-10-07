package com.mju.band3.dao;

import com.mju.band3.entity.Waybill;
import java.util.List;

public interface WaybillMapper {
    int deleteByPrimaryKey(String waybillId);

    int insert(Waybill record);

    Waybill selectByPrimaryKey(String waybillId);

    List<Waybill> selectAll();

    int updateByPrimaryKey(Waybill record);
}