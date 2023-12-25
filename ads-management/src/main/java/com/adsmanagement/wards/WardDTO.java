package com.adsmanagement.wards;

import com.adsmanagement.districts.DistrictDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WardDTO {
    private Integer id;
    private String name;
    private DistrictDTO district;

    WardDTO(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
