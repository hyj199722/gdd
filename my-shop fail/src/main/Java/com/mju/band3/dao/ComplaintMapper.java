package com.mju.band3.dao;

import com.mju.band3.entity.Complaint;

import java.util.List;
//投诉信息的增删改查
public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer complaintId);

    int insert(Complaint record);

    Complaint selectByPrimaryKey(Integer complaintId);

    List<Complaint> selectAll();

    List<Complaint> selectAllNull();

    String selectWaybillIdIdNull(String waybillId);

    String selectWaybillIdId(String waybillId);

    void updateComplaintEdit(Complaint complaint);

    List<Complaint> complaintSearch (Complaint complaint);

    int updateByPrimaryKey(Complaint record);

}