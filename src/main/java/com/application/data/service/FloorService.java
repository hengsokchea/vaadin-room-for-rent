package com.application.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.data.entity.Floor;
import com.application.data.entity.Room;
import com.application.data.repository.FloorRepository;
import com.application.data.repository.RoomRepository;

@Service
public class FloorService {
	 private final FloorRepository repository ;
	 

	public FloorService(FloorRepository repository) {
		super();
		this.repository = repository;
	}
	public List<Floor> findAllFloor() {
		return repository.findAll();
	}
    public void saveFloor(Floor floor) {
        if (floor == null) { 
            System.err.println("Floor is null. Are you sure you have connected your form to the application?");
            return;
        }
        repository.save(floor);
    }
    
    public void deleteFloor(Floor floor) {
    	repository.delete(floor);
    }
    
	 

}
