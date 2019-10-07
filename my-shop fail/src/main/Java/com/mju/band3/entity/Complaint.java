package com.mju.band3.entity;

import java.util.Date;

public class Complaint {
    private Integer complaintId;

    private String waybillId;

    private String complaintDetail;

    private String complaintPerson;

    private Date complaintDate;

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