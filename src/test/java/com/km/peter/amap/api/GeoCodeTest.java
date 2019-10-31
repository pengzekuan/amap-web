package com.km.peter.amap.api;

import com.km.peter.http.Response;
import org.junit.Test;

public class GeoCodeTest {

    @Test
    public void testReversionParse() {
        GeoCode geoCode = new GeoCode("e05b5bbebb5ab06cb93d8f39eaf479ab");
        Response response = geoCode.reversionParse("102.765656", "25.090427");
        System.out.println(response.getData());
    }
}
