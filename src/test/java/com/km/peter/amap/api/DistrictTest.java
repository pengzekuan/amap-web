package com.km.peter.amap.api;

import com.km.peter.http.HTTPClientRequest;
import com.km.peter.http.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DistrictTest {
    private District district;

    @Before
    public void before() {
        this.district = new District("e05b5bbebb5ab06cb93d8f39eaf479ab");
    }

    @Test
    public void testDistrict() {
        Map<String, Object> query = new HashMap<>();
        query.put("extensions", "all");
        query.put("subdistrict", 0);
        query.put("keywords", "昆明市");
        Response response = this.district.info(query);
        System.out.println(response.getData());
    }

    @Test
    public void test() {
        HTTPClientRequest request = new HTTPClientRequest();
//        Request request = RequestFactory.instance(HTTPClientRequest.class);
        System.out.println(request);
    }
}
