package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;

public interface RoomService {
	List<Room> selectRoomByType(String type);
	
	List<Room> selectAll();
	
	Room selectOne(long id);
	
	
	//////////////////////////
	List<Room> bookableRoom(List<Reservation> reservations, List<Room> rooms);
}
