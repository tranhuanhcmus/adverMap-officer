package com.adsmanagement.spaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Integer>, CrudRepository<Space, Integer> {
    Page<Space> findAllByWardIdIn(List<Integer> wardIds, Pageable pageable);
}