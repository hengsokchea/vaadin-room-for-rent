package com.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.data.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long> {

}
