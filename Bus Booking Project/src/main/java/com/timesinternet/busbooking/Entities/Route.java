package com.timesinternet.busbooking.Entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table
public class Route {
    @Id
    @Column(length = 5)
     private String routeId;
     private String fromCityId;
    private String toCityId;
    private Time departureTime;
    private Time arrivalTime;

    public Route() {
    }

    public Route(String routeId, String fromCityId, String toCityId, Time departureTime, Time arrivalTime) {
        this.routeId = routeId;
        this.fromCityId = fromCityId;
        this.toCityId = toCityId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(String fromCityId) {
        this.fromCityId = fromCityId;
    }

    public String getToCityId() {
        return toCityId;
    }

    public void setToCityId(String toCityId) {
        this.toCityId = toCityId;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
