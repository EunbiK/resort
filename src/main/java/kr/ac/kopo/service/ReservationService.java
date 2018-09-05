package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.domain.Room;

public interface ReservationService {
	String[] thirtieth();
	List<Room> selectRoomType(String type);
}
