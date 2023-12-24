package com.adsmanagement.wards;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

public interface WardRepository extends JpaRepository<Ward, Integer> {
    Page<Ward> findAllByDistrict_Id(Integer districtId, Pageable pageable);
    Page<Ward> findAllByDistrict_IdIn(List<Integer> districtIds, Pageable pageable);

}