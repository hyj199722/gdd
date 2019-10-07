package com.mju.band3.entity;

import java.util.Date;

public class Bill_Status {
    private Integer billId;

    private String waybillId;

    private Integer billStatus;
//    @DateTimeFormat(pattern = "yyyy/MM/dd")
//
//    @JsonFormat(
//            pattern = "yyyy-MM-dd ",
//            timezone = "GMT+8"
//    )
    private Date writeDate;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public Bill_Status() {

    }

    public Bill_Status(Integer billId, String waybillId, Integer billStatus, Date writeDate) {
        this.billId = billId;
        this.waybillId = waybillId;
        this.billStatus = billStatus;
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return "Bill_Status{" +
                "billId=" + billId +
                ", waybillId='" + waybillId + '\'' +
                ", billStatus=" + billStatus +
                ", writeDate=" + writeDate +
                '}';
    }
}