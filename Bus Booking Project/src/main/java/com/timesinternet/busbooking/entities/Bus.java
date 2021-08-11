package com.timesinternet.busbooking.entities;

import javax.persistence.*;



@Entity
@Table
public class Bus{
    
	@Id
    @Column(length=5)
    private String busId;
    private String routeId;
    private String busType;
   private String busProvider;
   
    
    public Bus() {
    }

    public Bus(String busId, String routeId, String busType, String busProvider) {
		super();
		this.busId = busId;
		this.routeId = routeId;
		this.busType = busType;
		this.busProvider = busProvider;
	}
    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

	public String getBusProvider() {
		return busProvider;
	}

	public void setBusProvider(String busProvider) {
		this.busProvider = busProvider;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}
}
