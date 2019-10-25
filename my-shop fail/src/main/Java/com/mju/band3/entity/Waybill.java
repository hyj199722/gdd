package com.mju.band3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Waybill {
    private String waybillId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date waybillDate;

    private Integer waybillStatus;

    private String waybillBegin;

    private String waybillEnd;

    private String waybillRecive;

    private String waybillReciveAddress;

    private String waybillRecivePhone;

    private String waybillSend;

    private String waybillSendAddress;

    private String waybillSendPhone;

    private Double waybillFreight;

    private Double waybillInsurance;

    private Integer waybillPayType;

    private Integer waybillReciveType;

    private Double waybillLoan;

    private Double waybillCommission;

    private String waybillSalesman;

    private Double waybillRebate;

    private String waybillFill;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date waybillFillDate;

    private String waybillRemarks;

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
    }

    public Date getWaybillDate() {
        return waybillDate;
    }

    public void setWaybillDate(Date waybillDate) {
        this.waybillDate = waybillDate;
    }

    public String getWaybillBegin() {
        return waybillBegin;
    }

    public void setWaybillBegin(String waybillBegin) {
        this.waybillBegin = waybillBegin == null ? null : waybillBegin.trim();
    }

    public String getWaybillEnd() {
        return waybillEnd;
    }

    public void setWaybillEnd(String waybillEnd) {
        this.waybillEnd = waybillEnd == null ? null : waybillEnd.trim();
    }

    public String getWaybillRecive() {
        return waybillRecive;
    }

    public void setWaybillRecive(String waybillRecive) {
        this.waybillRecive = waybillRecive == null ? null : waybillRecive.trim();
    }

    public String getWaybillReciveAddress() {
        return waybillReciveAddress;
    }

    public void setWaybillReciveAddress(String waybillReciveAddress) {
        this.waybillReciveAddress = waybillReciveAddress == null ? null : waybillReciveAddress.trim();
    }

    public String getWaybillRecivePhone() {
        return waybillRecivePhone;
    }

    public void setWaybillRecivePhone(String waybillRecivePhone) {
        this.waybillRecivePhone = waybillRecivePhone == null ? null : waybillRecivePhone.trim();
    }

    public String getWaybillSend() {
        return waybillSend;
    }

    public void setWaybillSend(String waybillSend) {
        this.waybillSend = waybillSend == null ? null : waybillSend.trim();
    }

    public String getWaybillSendAddress() {
        return waybillSendAddress;
    }

    public void setWaybillSendAddress(String waybillSendAddress) {
        this.waybillSendAddress = waybillSendAddress == null ? null : waybillSendAddress.trim();
    }

    public String getWaybillSendPhone() {
        return waybillSendPhone;
    }

    public void setWaybillSendPhone(String waybillSendPhone) {
        this.waybillSendPhone = waybillSendPhone == null ? null : waybillSendPhone.trim();
    }

    public Double getWaybillFreight() {
        return waybillFreight;
    }

    public void setWaybillFreight(Double waybillFreight) {
        this.waybillFreight = waybillFreight;
    }

    public Double getWaybillInsurance() {
        return waybillInsurance;
    }

    public void setWaybillInsurance(Double waybillInsurance) {
        this.waybillInsurance = waybillInsurance;
    }

    public Integer getWaybillPayType() {
        return waybillPayType;
    }

    public void setWaybillPayType(Integer waybillPayType) {
        this.waybillPayType = waybillPayType;
    }

    public Integer getWaybillReciveType() {
        return waybillReciveType;
    }

    public void setWaybillReciveType(Integer waybillReciveType) {
        this.waybillReciveType = waybillReciveType;
    }

    public Double getWaybillLoan() {
        return waybillLoan;
    }

    public void setWaybillLoan(Double waybillLoan) {
        this.waybillLoan = waybillLoan;
    }

    public Double getWaybillCommission() {
        return waybillCommission;
    }

    public void setWaybillCommission(Double waybillCommission) {
        this.waybillCommission = waybillCommission;
    }

    public String getWaybillSalesman() {
        return waybillSalesman;
    }

    public void setWaybillSalesman(String waybillSalesman) {
        this.waybillSalesman = waybillSalesman == null ? null : waybillSalesman.trim();
    }

    public Double getWaybillRebate() {
        return waybillRebate;
    }

    public void setWaybillRebate(Double waybillRebate) {
        this.waybillRebate = waybillRebate;
    }

    public String getWaybillFill() {
        return waybillFill;
    }

    public void setWaybillFill(String waybillFill) {
        this.waybillFill = waybillFill == null ? null : waybillFill.trim();
    }

    public Date getWaybillFillDate() {
        return waybillFillDate;
    }

    public void setWaybillFillDate(Date waybillFillDate) {
        this.waybillFillDate = waybillFillDate;
    }

    public String getWaybillRemarks() {
        return waybillRemarks;
    }

    public void setWaybillRemarks(String waybillRemarks) {
        this.waybillRemarks = waybillRemarks == null ? null : waybillRemarks.trim();
    }

    public Integer getWaybillStatus() {
        return waybillStatus;
    }

    public void setWaybillStatus(Integer waybillStatus) {
        this.waybillStatus = waybillStatus;
    }
}