package com.mju.band3.service;
import com.mju.band3.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    List<Complaint> selectAll();
    List<Complaint> selectAllNull();
    List<Complaint> complaintSearch (Complaint complaint);
    Complaint selectByPrimaryKey(Integer complaintId);
    void updateComplaintEdit(Complaint complaint);
    int deleteByPrimaryKey(Integer complaintId);
    int updateByPrimaryKey(Complaint record);
    int insert(Complaint record);
    String selectWaybillIdId(String waybillId);
    String selectWaybillIdIdNull(String waybillId);



}
