package com.mju.band3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Complaint {
    private Integer complaintId;

    private String waybillId;

    private String complaintDetail;

    private String complaintPerson;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date complaintDate;

    private String complaintDoType;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date complaintDoDate;

    private String complaintDoResult;

    private String complaintReplyType;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ComplaintReplyDate;

    public String getComplaintDoType() {
        return complaintDoType;
    }

    public void setComplaintDoType(String complaintDoType) {
        this.complaintDoType = complaintDoType;
    }

    public Date getComplaintDoDate() {
        return complaintDoDate;
    }

    public void setComplaintDoDate(Date complaintDoDate) {
        this.complaintDoDate = complaintDoDate;
    }

    public String getComplaintDoResult() {
        return complaintDoResult;
    }

    public void setComplaintDoResult(String complaintDoResult) {
        this.complaintDoResult = complaintDoResult;
    }

    public String getComplaintReplyType() {
        return complaintReplyType;
    }

    public void setComplaintReplyType(String complaintReplyType) {
        this.complaintReplyType = complaintReplyType;
    }

    public Date getComplaintReplyDate() {
        return ComplaintReplyDate;
    }

    public void setComplaintReplyDate(Date complaintReplyDate) {
        ComplaintReplyDate = complaintReplyDate;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId == null ? null : waybillId.trim();
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail == null ? null : complaintDetail.trim();
    }

    public String getComplaintPerson() {
        return complaintPerson;
    }

    public void setComplaintPerson(String complaintPerson) {
        this.complaintPerson = complaintPerson == null ? null : complaintPerson.trim();
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }
}