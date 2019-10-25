package com.mju.band3.entity;

import java.util.Date;

public class Contract {
    private String contractId;

    private Integer contractStatus;

    private String contractDriver;

    private String contractCarnum;

    private String contractOperationLicense;

    private String contractDriverLicense;

    private String contractDrivingLicense;

    private String contractBegin;

    private Date contractBeginDate;

    private String contractEnd;

    private Date contractEndDate;

    private String contractRecive;

    private String contractRecivePhone;

    private String contractReciveAddress;

    private Double contractBond;

    private Double contractService;

    private Integer contractPayType;

    private Double contractDeposit;

    private Integer contractMoneyType;

    private Double contractMoney;

    private Double contractInsurance;

    private Double contractPrepay;

    private Date contractDate;

    private String contractRemarks;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getContractDriver() {
        return contractDriver;
    }

    public void setContractDriver(String contractDriver) {
        this.contractDriver = contractDriver == null ? null : contractDriver.trim();
    }

    public String getContractCarnum() {
        return contractCarnum;
    }

    public void setContractCarnum(String contractCarnum) {
        this.contractCarnum = contractCarnum == null ? null : contractCarnum.trim();
    }

    public String getContractOperationLicense() {
        return contractOperationLicense;
    }

    public void setContractOperationLicense(String contractOperationLicense) {
        this.contractOperationLicense = contractOperationLicense == null ? null : contractOperationLicense.trim();
    }

    public String getContractDriverLicense() {
        return contractDriverLicense;
    }

    public void setContractDriverLicense(String contractDriverLicense) {
        this.contractDriverLicense = contractDriverLicense == null ? null : contractDriverLicense.trim();
    }

    public String getContractDrivingLicense() {
        return contractDrivingLicense;
    }

    public void setContractDrivingLicense(String contractDrivingLicense) {
        this.contractDrivingLicense = contractDrivingLicense == null ? null : contractDrivingLicense.trim();
    }

    public String getContractBegin() {
        return contractBegin;
    }

    public void setContractBegin(String contractBegin) {
        this.contractBegin = contractBegin == null ? null : contractBegin.trim();
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd == null ? null : contractEnd.trim();
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractRecive() {
        return contractRecive;
    }

    public void setContractRecive(String contractRecive) {
        this.contractRecive = contractRecive == null ? null : contractRecive.trim();
    }

    public String getContractRecivePhone() {
        return contractRecivePhone;
    }

    public void setContractRecivePhone(String contractRecivePhone) {
        this.contractRecivePhone = contractRecivePhone == null ? null : contractRecivePhone.trim();
    }

    public String getContractReciveAddress() {
        return contractReciveAddress;
    }

    public void setContractReciveAddress(String contractReciveAddress) {
        this.contractReciveAddress = contractReciveAddress == null ? null : contractReciveAddress.trim();
    }

    public Double getContractBond() {
        return contractBond;
    }

    public void setContractBond(Double contractBond) {
        this.contractBond = contractBond;
    }

    public Double getContractService() {
        return contractService;
    }

    public void setContractService(Double contractService) {
        this.contractService = contractService;
    }

    public Integer getContractPayType() {
        return contractPayType;
    }

    public void setContractPayType(Integer contractPayType) {
        this.contractPayType = contractPayType;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Integer getContractMoneyType() {
        return contractMoneyType;
    }

    public void setContractMoneyType(Integer contractMoneyType) {
        this.contractMoneyType = contractMoneyType;
    }

    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getContractInsurance() {
        return contractInsurance;
    }

    public void setContractInsurance(Double contractInsurance) {
        this.contractInsurance = contractInsurance;
    }

    public Double getContractPrepay() {
        return contractPrepay;
    }

    public void setContractPrepay(Double contractPrepay) {
        this.contractPrepay = contractPrepay;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractRemarks() {
        return contractRemarks;
    }

    public void setContractRemarks(String contractRemarks) {
        this.contractRemarks = contractRemarks == null ? null : contractRemarks.trim();
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }
}