package com.mju.band3.entity;

public class Item {
    private Integer itemId;

    private String waybillId;

    private String itemName;

    private Integer itemNum;

    private Double itemWeight;

    private Integer itemWrap;

    private Double itemSize;

    private Double itemValue;

    private Integer itemShip;

    private Double itemInsurance;

    private Integer itemPay;

    private String contractId;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Integer getItemPay() {
        return itemPay;
    }

    public void setItemPay(Integer itemPay) {
        this.itemPay = itemPay;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Integer getItemWrap() {
        return itemWrap;
    }

    public void setItemWrap(Integer itemWrap) {
        this.itemWrap = itemWrap;
    }

    public Double getItemSize() {
        return itemSize;
    }

    public void setItemSize(Double itemSize) {
        this.itemSize = itemSize;
    }

    public Double getItemValue() {
        return itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

    public Integer getItemShip() {
        return itemShip;
    }

    public void setItemShip(Integer itemShip) {
        this.itemShip = itemShip;
    }

    public Double getItemInsurance() {
        return itemInsurance;
    }

    public void setItemInsurance(Double itemInsurance) {
        this.itemInsurance = itemInsurance;
    }
}