package com.km.peter.amap.parameter;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.km.peter.amap.annotation.param.Column;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FenceParam implements Serializable {

    // 围栏名称
    private String name;
    // 圆形围栏中心
    private LocationPoint center;
    // 圆形围栏半径 0~5000
    private int radius;
    // 多边形围栏路径
    private String points;
    private boolean enable;
    @Column(value = "valid_time")
    private String validTime;
    private String repeat;
    @Column(value = "fixed_date")
    private String fixedDate;
    private String time;
    private String desc;
    @Column(value = "alert_condition")
    private String alertCondition;

    // 多边形围栏
    public FenceParam(String name, String points) {
        this.name = name;
        this.points = points;
        this.init();
    }

    // 圆形围栏
    public FenceParam(String name, LocationPoint center, int radius) {
        this.name = name;
        this.center = center;
        this.radius = radius;
        this.init();
    }

    private void init() {
        this.enable = true;
        this.validTime = "2054-12-12";
        this.repeat = "Mon,Tues,Wed,Thur,Fri,Sat,Sun";
        this.time = "00:00,23:59;";
        this.alertCondition = "enter;leave";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationPoint getCenter() {
        return center;
    }

    public void setCenter(LocationPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getFixedDate() {
        return fixedDate;
    }

    public void setFixedDate(String fixedDate) {
        this.fixedDate = fixedDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ObjectNode json() {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        Class clz = this.getClass();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            try {
                String getMethod = "get";
                if (field.getGenericType().getTypeName().equals(boolean.class.getName())) {
                    getMethod = "is";
                }
                getMethod += fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Object value = clz.getDeclaredMethod(getMethod).invoke(this);
                String columnStr = fieldName;
                if (field.isAnnotationPresent(Column.class)) {

                    Column column = field.getDeclaredAnnotation(Column.class);
                    columnStr = column.value();
                }
                if (value != null && !"".equals(value) && !"0".equals(String.valueOf(value))) {
                    objectNode.put(columnStr, value.toString());
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return objectNode;
    }

    public String getAlertCondition() {
        return alertCondition;
    }

    public void setAlertCondition(String alertCondition) {
        this.alertCondition = alertCondition;
    }

}
