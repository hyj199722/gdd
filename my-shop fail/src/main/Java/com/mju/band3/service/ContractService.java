package com.mju.band3.service;

import com.mju.band3.entity.Contract;
import com.mju.band3.entity.Driver;

import java.util.List;
import java.util.Map;

public interface ContractService {
    Driver getDriver(Integer driverId);

    List<Contract> getContracts();

    String latestRecord();

    List<Driver> getDrivers();

    void saveContract(Contract contract);

    List<Contract> contractSearch(Map<String,Object> map);

    Contract getContract(String contractId);

    void updateContract(Contract contract);

    void upload(String iteminfo,String contractId);

    void unload(String iteminfo);

    void changeStatus(String ccontractId,Integer status);

    void uploadStatus(String waybillId);
}
