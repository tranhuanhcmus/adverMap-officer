package com.adsmanagement.districts;

import com.adsmanagement.cities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    Page<District> findAllByCity_Id(Integer cityId, Pageable pageable);

    Page<District> findAll(Pageable pageable);

}