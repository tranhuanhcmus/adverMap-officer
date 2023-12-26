package com.adsmanagement.surfaces;

import com.adsmanagement.spaces.models.SpaceRequest;
import com.adsmanagement.surfaces.models.SurfaceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurfaceRequestRepository extends JpaRepository<SurfaceRequest, Integer>, CrudRepository<SurfaceRequest, Integer> {
    Page<SurfaceRequest> findAll(Pageable pageable);
}