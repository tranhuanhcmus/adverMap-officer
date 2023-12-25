package com.adsmanagement.districts;

import com.adsmanagement.cities.City;
import com.adsmanagement.wards.Ward;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public DistrictDTO toDto(){
        return new DistrictDTO(id,name);
    }
}
