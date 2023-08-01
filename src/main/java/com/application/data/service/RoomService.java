package com.application.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.data.entity.Room;
import com.application.data.repository.RoomRepository;

@Service 
public class RoomService {
    private final RoomRepository roomRepository ;

	public RoomService(RoomRepository roomRepository ) {
		this.roomRepository=roomRepository;
	}
	public List<Room> findAllRoom() {
		return roomRepository.findAll();
	}
}
