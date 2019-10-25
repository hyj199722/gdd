package com.mju.band3.service.impl;

import com.mju.band3.dao.ComplaintMapper;
import com.mju.band3.entity.Complaint;
import com.mju.band3.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintMapper complaintMapper;
    @Override
    public List<Complaint> selectAll() {
        return complaintMapper.selectAll();
    }

    @Override
    public List<Complaint> selectAllNull() {
        return complaintMapper.selectAllNull();
    }

    @Override
    public List<Complaint> complaintSearch(Complaint complaint) {
        return complaintMapper.complaintSearch(complaint);
    }

    @Override
    public Complaint selectByPrimaryKey(Integer complaintId) {
        return complaintMapper.selectByPrimaryKey(complaintId);
    }

    @Override
    public void updateComplaintEdit(Complaint complaint) {
complaintMapper.updateComplaintEdit(complaint);
    }

    @Override
    public int deleteByPrimaryKey(Integer complaintId) {
        return complaintMapper.deleteByPrimaryKey(complaintId);
    }

    @Override
    public int updateByPrimaryKey(Complaint record) {
        return complaintMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Complaint record) {
        return complaintMapper.insert(record);
    }

    @Override
    public String selectWaybillIdId(String waybillId) {
        return complaintMapper.selectWaybillIdId(waybillId);
    }

    @Override
    public String selectWaybillIdIdNull(String waybillId) {
        return complaintMapper.selectWaybillIdIdNull(waybillId);
    }
}
