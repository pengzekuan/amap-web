package com.km.peter.amap.api;

import com.km.peter.amap.RequestURI;
import com.km.peter.amap.parameter.FenceParam;
import com.km.peter.amap.parameter.LocationPoint;
import com.km.peter.http.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 地理围栏
 */
public class Fence extends AMapAPI {


    public Fence(String key) {
        super(key);
    }

    public Response create(FenceParam params) {
        return this.request.post(RequestURI.GEO_FENCE_URI, this.keySet(null), params.json());
    }

    public Response getAll() {
        return this.get(null);
    }

    public Response getByGid(String gid) {
        Map<String, Object> query = new HashMap<>();
        query.put("gid", gid);
        return this.get(query);
    }

    public Response get(Map<String, Object> query) {
        return this.request.get(RequestURI.GEO_FENCE_URI, this.keySet(query));
    }

//    public Response update(String gid, FenceParam param) {
//        return this.request.patch(RequestURI.GEO_FENCE_URI);
//    }
//
//    public Response remove(String gid) {
//        return this.request.delete(RequestURI.GEO_FENCE_URI, query);
//    }

    public Response check(LocationPoint location, String uuid, Long uid) {
        Map<String, Object> query = new HashMap<>();
        if (uuid == null) {
            uuid = "869897039606735";
        }
        query.put("diu", uuid);
        if (uid != null) {

            query.put("uid", uid);
        }
        query.put("locations", location.toString() + "," + System.currentTimeMillis() / 1000);
        return this.request.get(RequestURI.GEO_FENCE_CHECK_URI, this.keySet(query));
    }
}
