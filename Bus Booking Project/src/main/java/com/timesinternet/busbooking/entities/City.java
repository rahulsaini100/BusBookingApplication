package com.timesinternet.busbooking.entities;



import javax.persistence.*;

/**
 * City class represents city in our database.
 * It contains cityId and cityName as attributes
 * @author Vikas.Sahani
 *
 */

@Entity
@Table
public class City {
    @Id
    @Column(length = 5)
    private String cityId;
    private String cityName;
    
    
    /**
     * Default constructor of City class
     */
    public City() {
    }
    /**
     * Constructs and initializes City class 
     * @param cityId
     * @param cityName
     */
    public City(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }
    
    
    /**
     * 
     * @return cityId
     */
    public String getCityId() {
        return cityId;
    }
    /**
     * sets cityId
     * @param cityId
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    /**
     * 
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }
    /**
     * sets cityName
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
