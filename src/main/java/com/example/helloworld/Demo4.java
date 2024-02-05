package com.example.helloworld;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 马克
 * @date 2023/6/11
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        String str = "[{\"area\":\"黄浦区\",\"city\":\"上海城区\",\"latitude\":\"31.195995\",\"personName\":\"1\",\"personPhone\":\"13111111111\",\"province\":\"上海市\",\"organizationCode\":\"863\",\"street\":\"\",\"name\":\"1\",\"posCode\":\"11\",\"detailAddress\":\"龙华东路\",\"longitude\":\"116.795169\"}]";

//        List<PosShopVO> posShopVOS = JSONArray.parseArray(str, PosShopVO.class);

        ObjectMapper mapper = new ObjectMapper();
        List<PosShopVO> list = mapper.readValue(str, new TypeReference<List<PosShopVO>>(){});
        PosShopVO posShopVO = list.get(0);
        System.out.println("posShopVO = " + posShopVO);
    }

}

class PosShopVO {
    private static final long serialVersionUID = -1825254643392801660L;

    private String posCode;

    private String name;

    private String organizationCode;

    private String personName;

    private String personPhone;

    private String province;

    private String city;

    private String area;

    private String street;

    private String detailAddress;

    private String latitude;

    private String longitude;

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public PosShopVO(String posCode, String name, String organizationCode, String personName, String personPhone, String province, String city, String area, String street, String detailAddress, String latitude, String longitude) {
        this.posCode = posCode;
        this.name = name;
        this.organizationCode = organizationCode;
        this.personName = personName;
        this.personPhone = personPhone;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.detailAddress = detailAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PosShopVO() {

    }

    @Override
    public String toString() {
        return "PosShopVO{" +
                "posCode='" + posCode + '\'' +
                ", name='" + name + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", personName='" + personName + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", street='" + street + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
