package com.km.peter.amap.api;

import com.km.peter.http.HTTPClientRequest;
import com.km.peter.http.Request;
import com.km.peter.http.RequestFactory;

import java.util.HashMap;
import java.util.Map;


public class AMapAPI {

    protected String key;

    protected Request request;

    public AMapAPI(String key) {
        this.key = key;
        this.request = RequestFactory.instance(HTTPClientRequest.class);
    }

    public static String spliceLocation(String longitude, String latitude) {
        return longitude + "," + latitude;
    }

    Map<String, Object> keySet(Map<String, Object> query) {
        if (query == null) {
            query = new HashMap<>();
        }
        query.put("key", this.key);

        return query;
    }
}
