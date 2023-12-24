package com.adsmanagement.districts;

import com.adsmanagement.cities.City;
import com.adsmanagement.wards.Ward;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Ward> wards;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    public District(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public District() {

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
