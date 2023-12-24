package com.adsmanagement.spaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceRequestRepository extends JpaRepository<SpaceRequest, Integer>, CrudRepository<SpaceRequest, Integer> {
}