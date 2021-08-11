package com.timesinternet.busbooking.entities;



import javax.persistence.*;

@Entity
@Table
public class City {
    @Id
   @Column(length = 5)
    private String cityId;
    private String cityName;

    public City() {
    }

    public City(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
