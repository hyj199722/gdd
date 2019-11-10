package com.mju.band3.service.impl;

import com.mju.band3.dao.*;
import com.mju.band3.entity.Bill;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Contract;
import com.mju.band3.entity.Driver;
import com.mju.band3.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    DriverMapper driverMapper;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    Bill_StatusMapper billStatusMapper;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    WaybillMapper waybillMapper;
    @Override
    public Driver getDriver(Integer driverId) {
        return driverMapper.selectByPrimaryKey(driverId);
    }

    @Override
    public List<Contract> getContracts() {
        return contractMapper.selectAll();
    }

    @Override
    public String latestRecord() {
        List<Bill_Status> billStatuses = billStatusMapper.latestRecord();
        if (billStatuses.isEmpty()) {
            return "无可填写运输合同";
        }
        for (Bill_Status billstatus : billStatuses) {
            if (billstatus.getWaybillId().startsWith("r")) {
                return billstatus.getWaybillId();
            }
        }
        return "无可填写运输合同";
    }

    @Override
    public List<Driver> getDrivers() {
        return driverMapper.selectAll();
    }

    @Override
    public void saveContract(Contract contract) {
        contractMapper.insert(contract);
        billStatusMapper.changeTheStatus(contract.getContractId());
    }

    @Override
    public List<Contract> contractSearch(Map<String, Object> map) {
        return contractMapper.contractSearch(map);
    }

    @Override
    public Contract getContract(String contractId) {
        return contractMapper.selectByPrimaryKey(contractId);
    }

    @Override
    public void updateContract(Contract contract) {
        contractMapper.updateByPrimaryKey(contract);
    }

    @Override
    public void upload(String iteminfo, String contractId) {
        String[] split = iteminfo.split(";");
        String itemId = split[0];
        String waybillId = split[1];
        Integer itemIdI = Integer.valueOf(itemId);
        itemMapper.upload(itemIdI, waybillId, contractId);
    }

    @Override
    public void unload(String iteminfo) {
        String[] split = iteminfo.split(";");
        String itemId = split[0];
        String waybillId = split[1];
        Integer itemIdI = Integer.valueOf(itemId);
        itemMapper.unload(itemIdI, waybillId);
        if (itemMapper.getItemByWaybillIdWithoutContractId(waybillId).isEmpty()&&itemMapper.unloadItems(waybillId).isEmpty()) {
            waybillMapper.changeStatus(waybillId,3);
        }
    }

    @Override
    public void changeStatus(String ccontractId, Integer status) {
        contractMapper.changeStatus(ccontractId, status);
    }

    @Override
    public void uploadStatus(String waybillId) {
        if (!itemMapper.getItemByWaybillId(waybillId).isEmpty()
                && itemMapper.getItemByWaybillIdWithoutContractId(waybillId).isEmpty()) {
            waybillMapper.changeStatus(waybillId,2);
        }
    }

}
