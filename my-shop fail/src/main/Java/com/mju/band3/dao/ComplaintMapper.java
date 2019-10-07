package com.mju.band3.dao;

import com.mju.band3.entity.Complaint;
import java.util.List;

public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer complaintId);

    int insert(Complaint record);

    Complaint selectByPrimaryKey(Integer complaintId);

    List<Complaint> selectAll();

    int updateByPrimaryKey(Complaint record);
}