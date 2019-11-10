package com.mju.band3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Driver_Receipt {
    private Integer driverReceiptId;

    private String contractId;

    private String driverReceiptName;

    private String driverReceiptRecord;

    private String driverReceiptCheck;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date driverReceiptDate;

    public Integer getDriverReceiptId() {
        return driverReceiptId;
    }

    public void setDriverReceiptId(Integer driverReceiptId) {
        this.driverReceiptId = driverReceiptId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getDriverReceiptName() {
        return driverReceiptName;
    }

    public void setDriverReceiptName(String driverReceiptName) {
        this.driverReceiptName = driverReceiptName == null ? null : driverReceiptName.trim();
    }

    public String getDriverReceiptRecord() {
        return driverReceiptRecord;
    }

    public void setDriverReceiptRecord(String driverReceiptRecord) {
        this.driverReceiptRecord = driverReceiptRecord == null ? null : driverReceiptRecord.trim();
    }

    public String getDriverReceiptCheck() {
        return driverReceiptCheck;
    }

    public void setDriverReceiptCheck(String driverReceiptCheck) {
        this.driverReceiptCheck = driverReceiptCheck == null ? null : driverReceiptCheck.trim();
    }

    public Date getDriverReceiptDate() {
        return driverReceiptDate;
    }

    public void setDriverReceiptDate(Date driverReceiptDate) {
        this.driverReceiptDate = driverReceiptDate;
    }
}