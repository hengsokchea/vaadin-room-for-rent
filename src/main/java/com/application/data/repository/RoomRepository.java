package com.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.data.entity.Room;

public interface  RoomRepository extends JpaRepository<Room, Long> {

}
