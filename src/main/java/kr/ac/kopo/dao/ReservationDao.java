package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;

public interface ReservationDao {
	
	Reservation selectOne(long id);
	List<Reservation> selectAll();
//	List<Reservation> selectAllByDate(String time);
	List<Reservation> selectAllByDateAndRoomType(String time, String roomType);
	
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
}
