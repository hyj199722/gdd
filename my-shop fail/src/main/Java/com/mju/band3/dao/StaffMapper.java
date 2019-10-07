package com.mju.band3.dao;

import com.mju.band3.entity.Staff;
import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);
}