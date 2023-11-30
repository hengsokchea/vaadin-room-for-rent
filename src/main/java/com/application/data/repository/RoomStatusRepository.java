package com.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.data.entity.*;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {

}
