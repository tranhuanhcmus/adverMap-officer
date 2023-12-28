package com.adsmanagement.reports;


import com.adsmanagement.reports.models.Report;
import com.adsmanagement.reports.models.ReportState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReportRepository extends JpaRepository<Report, Integer>, CrudRepository<Report, Integer> {

    Page<Report> findAll(Pageable pageable);

    Page<Report> findAllByState(Pageable pageable, ReportState state);

    Page<Report> findAllByWardIdIn(Pageable pageable, List<Integer> wardIds);

    Page<Report> findAllByWardIdInAndState(Pageable pageable, List<Integer> wardIds, ReportState state);

    Page<Report> findAllBySurfaceIdIn(Pageable pageable, List<Integer> surfaceIds);

    Page<Report> findAllBySurfaceIdInAndState(Pageable pageable, List<Integer> surfaceIds, ReportState state);

    Page<Report> findAllByWardIdInAndSurfaceIdIn(Pageable pageable, List<Integer> wardIds, List<Integer> surfaceIds);
    Page<Report> findAllByWardIdInAndSurfaceIdInAndState(Pageable pageable, List<Integer> wardIds, List<Integer> surfaceIds, ReportState state);

}