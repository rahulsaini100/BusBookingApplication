package com.timesinternet.busbooking.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table
public class Bus{
    @Id

    private long busId;
    private String routeId;

    public Bus() {
    }

    public Bus(long busId, String routeId) {
        this.busId = busId;
        this.routeId = routeId;
    }

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
