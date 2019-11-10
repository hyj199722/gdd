package com.mju.band3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Customer_Receipt {
    private Integer customerReceiptId;

    private String waybillId;

    private String customerReceiptName;

    private String customerReceiptRecord;

    private String customerReceiptCheck;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerReceiptDate;

    public Integer getCustomerReceiptId() {
        return customerReceiptId;
    }

    public void setCustomerReceiptId(Integer customerReceiptId) {
        this.customerReceiptId = customerReceiptId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
    }

    public String getCustomerReceiptName() {
        return customerReceiptName;
    }

    public void setCustomerReceiptName(String customerReceiptName) {
        this.customerReceiptName = customerReceiptName == null ? null : customerReceiptName.trim();
    }

    public String getCustomerReceiptRecord() {
        return customerReceiptRecord;
    }

    public void setCustomerReceiptRecord(String customerReceiptRecord) {
        this.customerReceiptRecord = customerReceiptRecord == null ? null : customerReceiptRecord.trim();
    }

    public String getCustomerReceiptCheck() {
        return customerReceiptCheck;
    }

    public void setCustomerReceiptCheck(String customerReceiptCheck) {
        this.customerReceiptCheck = customerReceiptCheck == null ? null : customerReceiptCheck.trim();
    }

    public Date getCustomerReceiptDate() {
        return customerReceiptDate;
    }

    public void setCustomerReceiptDate(Date customerReceiptDate) {
        this.customerReceiptDate = customerReceiptDate;
    }
}