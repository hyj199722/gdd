package com.mju.band3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bill {
    private Integer billId;

    private String billBegin;

    private String billEnd;

    private String billType;

    private String billTaker;

    private String billGiver;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billDate;

    private String billLocation;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getBillBegin() {
        return billBegin;
    }

    public void setBillBegin(String billBegin) {
        this.billBegin = billBegin == null ? null : billBegin.trim();
    }

    public String getBillEnd() {
        return billEnd;
    }

    public void setBillEnd(String billEnd) {
        this.billEnd = billEnd == null ? null : billEnd.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getBillTaker() {
        return billTaker;
    }

    public void setBillTaker(String billTaker) {
        this.billTaker = billTaker == null ? null : billTaker.trim();
    }

    public String getBillGiver() {
        return billGiver;
    }

    public void setBillGiver(String billGiver) {
        this.billGiver = billGiver == null ? null : billGiver.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillLocation() {
        return billLocation;
    }

    public void setBillLocation(String billLocation) {
        this.billLocation = billLocation == null ? null : billLocation.trim();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", billBegin='" + billBegin + '\'' +
                ", billEnd='" + billEnd + '\'' +
                ", billType='" + billType + '\'' +
                ", billTaker='" + billTaker + '\'' +
                ", billGiver='" + billGiver + '\'' +
                ", billDate=" + billDate +
                ", billLocation='" + billLocation + '\'' +
                '}';
    }
}