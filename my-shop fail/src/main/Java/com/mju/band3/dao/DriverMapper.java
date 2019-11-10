package com.mju.band3.dao;

import com.mju.band3.entity.Driver;

import java.util.List;

public interface DriverMapper {
    List<Driver> selectAll();

    Driver selectByPrimaryKey(Integer driverId);
}
