package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.domain.Reservation;

public interface ReservationService {
	String[] thirtieth();
	List<Reservation> selectAllByDateAndRoomType(String time, String roomType);
	
	int createOne(Reservation reservation);
	
	
}
