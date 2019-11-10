package com.mju.band3.dao;

import com.mju.band3.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ContractMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    Contract selectByPrimaryKey(String contractId);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);

    List<Contract> contractSearch(Map<String,Object> map);

    void changeStatus(@Param("contractId")String contractId,@Param("status") Integer status);


}