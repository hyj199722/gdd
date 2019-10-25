package com.mju.band3.dao;



import com.mju.band3.entity.Driver_Receipt;
import java.util.List;
import java.util.Map;
//司机回执的增删改查
public interface Driver_ReceiptMapper {
    int deleteByPrimaryKey(Integer driverReceiptId);

    int insert(Driver_Receipt record);

    Driver_Receipt selectByPrimaryKey(Integer driverReceiptId);

    List<Driver_Receipt> selectAll();

    String selectContractId(String ContractId);

    String selectContractIdNull(String ContractId);

    void update_driver_receipt_edit(Driver_Receipt driver_receipt);

    List<Driver_Receipt> DriverReceiptSearch(Map<String,Object> map);

    int updateByPrimaryKey(Driver_Receipt record);
}