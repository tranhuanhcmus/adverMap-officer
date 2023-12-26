package com.adsmanagement.surfaces;

import com.adsmanagement.surfaces.models.Surface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurfaceRepository extends JpaRepository<Surface, Integer>, CrudRepository<Surface, Integer> {
    Page<Surface> findAllBySpaceIdIn(List<Integer> spaceIds, Pageable pageable);
}