package com.mju.band3.entity;

public class Driver {
    private Integer driverId;
    private  String driverName;
    private String driverLicense;
    private String drivingLicense;
    private String driverCarnum;

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", driverCarnum='" + driverCarnum + '\'' +
                '}';
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getDriverCarnum() {
        return driverCarnum;
    }

    public void setDriverCarnum(String driverCarnum) {
        this.driverCarnum = driverCarnum;
    }
}
