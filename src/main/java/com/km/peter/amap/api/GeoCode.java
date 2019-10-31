package com.km.peter.amap.api;

import com.km.peter.amap.RequestURI;
import com.km.peter.http.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 地理位置解析
 */
public class GeoCode extends AMapAPI{


    public GeoCode(String key) {
        super(key);
    }

    /**
     * 地址解析
     * @param address 地址信息
     * @return Response
     */
    public Response parse(String address) {
        Map<String, Object> query = new HashMap<>();
        query.put("address", address);
        return this.request.get(RequestURI.GEO_CODE_URI, this.keySet(query));
    }

    /**
     * 逆地址解析
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    public Response reversionParse(String longitude, String latitude) {
        // 精度保留6位小数

        // 经纬度`;`分割 如：精度;纬度
        String location = spliceLocation(longitude, latitude);

        Map<String, Object> query = new HashMap<>();
        query.put("location", location);

        return this.request.get(RequestURI.REVERSION_GEO_CODE_URI, this.keySet(query));
    }
}
