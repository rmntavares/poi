package com.example.springpoi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "pois")
public class Poi {
    @Id
    private Long id;
    private String name;
    private String description;
    private String type;
    private String collisioncenter;
    private String chargingstation;
    private String dealer;
    private String addressname;
    private String city;
    private String zipcode;
    private String lat;
    @Column (value = "long")
    private String longi;

    public Long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCollisioncenter() {
        return collisioncenter;
    }

    public void setCollisioncenter(String collisioncenter) {
        this.collisioncenter = collisioncenter;
    }

    public String getChargingstation() {
        return chargingstation;
    }

    public void setChargingstation(String chargingstation) {
        this.chargingstation = chargingstation;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
}
