package com.mju.band3.dao;

import com.mju.band3.entity.Contract;
import java.util.List;

public interface ContractMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    Contract selectByPrimaryKey(String contractId);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);
}