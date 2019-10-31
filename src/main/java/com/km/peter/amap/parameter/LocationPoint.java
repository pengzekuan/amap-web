package com.km.peter.amap.parameter;

import com.km.peter.amap.api.AMapAPI;

public class LocationPoint {

    private String longitude;

    private String latitude;

    public LocationPoint(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return AMapAPI.spliceLocation(this.longitude, this.latitude);
    }
}
