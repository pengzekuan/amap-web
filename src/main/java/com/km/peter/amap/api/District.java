package com.km.peter.amap.api;

import com.km.peter.amap.RequestURI;
import com.km.peter.http.Response;
import com.km.peter.http.helper.StringHelper;

import java.util.Map;

/**
 * 行政区划
 */
public class District extends AMapAPI {

    public District(String key) {
        super(key);
    }

    /**
     * 行政区划查询
     * @param query
     * @return
     */
    public Response info(Map<String, Object> query) {
        return this.request.get(StringHelper.urlBuilder(RequestURI.DISTRICT_URI, StringHelper.queryBuild(this.keySet(query))));
    }

    /**
     * 区域边界查询
     */
}
