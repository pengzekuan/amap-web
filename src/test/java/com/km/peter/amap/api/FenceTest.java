package com.km.peter.amap.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.km.peter.amap.parameter.FenceParam;
import com.km.peter.amap.parameter.LocationPoint;
import com.km.peter.http.Response;
import org.junit.Before;
import org.junit.Test;

public class FenceTest extends APITest {

    private Fence fence;

    @Before
    public void before() {
        this.fence = new Fence(KEY);
    }

    @Test
    public void testParam() throws JsonProcessingException {
        FenceParam param = new FenceParam("多边形围栏", "123.234234,343.543554");
        System.out.println(param.json());

        FenceParam param1 = new FenceParam("圆形围栏", new LocationPoint("344.333333", "445.543434"), 200);
        System.out.println(param1.json());
    }

    @Test
    public void testCreate() {
        Fence fence = new Fence(KEY);
        FenceParam param = new FenceParam("测试围栏名称",
                new LocationPoint("116.472407", "39.993322"), 3000);
        System.out.println(param.json());
        Response response = fence.create(param);
        System.out.println(response.getData());

//        StringBuffer buffer = new StringBuffer();
//        FenceParam km = new FenceParam("昆明", buffer.toString());
//        Response response1 = fence.create(km);
//        System.out.println(response.getData());
    }

    @Test
    public void testGet() {
        Response response = fence.getAll();
        System.out.println(response.getData());

        Response response1 = fence.getByGid("017e81f3-3bd8-45e3-86dc-26c3fa46729b");
        System.out.println(response1.getData());
    }

    @Test
    public void testCheck() {
        Response response = fence.check(new LocationPoint("116.472407", "39.993322"), null, null);
        System.out.println(response.getData());

        System.out.println(System.currentTimeMillis() / 1000);
    }
}
