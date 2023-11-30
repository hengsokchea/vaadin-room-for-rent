package com.application.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.data.entity.Floor;
import com.application.data.entity.Room;
import com.application.data.repository.FloorRepository;
import com.application.data.repository.RoomRepository;

@Service 
public class RoomService {
    private final RoomRepository roomRepository ;
	private final FloorRepository floorRepository ;

	public RoomService(RoomRepository roomRepository,FloorRepository floorRepository ) {
		this.roomRepository=roomRepository;
		this.floorRepository=floorRepository;
	}
	public List<Room> findAllRoom() {
		return roomRepository.findAll();
	}
    public void saveRoom(Room room) {
        if (room == null) { 
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        roomRepository.save(room);
    }
    
    public void deleteRoom(Room room) {
    	roomRepository.delete(room);
    }
    
    public List<Floor> findAllFloor() {
    	return	floorRepository.findAll();
    	
    }
}
