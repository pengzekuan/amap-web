package com.km.peter.amap.api;

import com.km.peter.amap.RequestURI;
import com.km.peter.http.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径规划
 */
public class Route extends AMapAPI {
    public Route(String key) {
        super(key);
    }

    /**
     * 路线查询
     * @param originLongitude
     * @param originLatitude
     * @param destinationLongitude
     * @param destinationLatitude
     * @param options
     * @return
     */
    public Response path(String requestUri, String originLongitude, String originLatitude,
                         String destinationLongitude, String destinationLatitude,
                         Map<String, Object> options) {
        Map<String, Object> query = this.keySet(options);
        String origin = spliceLocation(originLongitude, originLatitude);
        String destination = spliceLocation(destinationLongitude, destinationLatitude);

        query.put("origin", origin);
        query.put("destination", destination);

        return this.request.get(requestUri, this.keySet(query));
    }

    /**
     * 步行路线
     * @param originLongitude
     * @param originLatitude
     * @param destinationLongitude
     * @param destinationLatitude
     * @return
     */
    public Response walking(String originLongitude, String originLatitude,
                            String destinationLongitude, String destinationLatitude) {
        return this.path(RequestURI.WALKING_ROUTE_URI, originLongitude, originLatitude,
                destinationLongitude, destinationLatitude, null);
    }

    /**
     * 交通路线（综合路线） 公交+地铁+火车+步行
     * @param originLongitude
     * @param originLatitude
     * @param destinationLongitude
     * @param destinationLatitude
     * @return
     */
    public Response transit(String originLongitude, String originLatitude, String destinationLongitude, String destinationLatitude) {
        String origin = originLongitude + "," + originLatitude;
        String destination = destinationLongitude + "," + destinationLatitude;

        Map<String, Object> query = new HashMap<>();
        query.put("origin", origin);
        query.put("destination", destination);

        // 查询物理地址 city 起点城市 cityd 目标城市



        return this.request.get(RequestURI.WALKING_ROUTE_URI, this.keySet(query));
    }
}
