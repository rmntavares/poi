package com.example.springpoi.model;

import org.springframework.data.annotation.Id;

public class Poi {
    @Id
   private Long id;
    private String name;
   private String description;
   private String type;
  private String collisionCenter;
   private String chargingStation;
   private String dealer;
    private String addressName;
   private String city;
   private String zipCode;
    private String Lat;
    private String Long;

    public Long getId() {
        return id;
    }

    public void setUID(Long id) {
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

    public String getCollisionCenter() {
        return collisionCenter;
    }

    public void setCollisionCenter(String collisionCenter) {
        this.collisionCenter = collisionCenter;
    }

    public String getChargingStation() {
        return chargingStation;
    }

    public void setChargingStation(String chargingStation) {
        this.chargingStation = chargingStation;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }
}
