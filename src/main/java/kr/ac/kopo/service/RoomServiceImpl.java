package kr.ac.kopo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.RoomDao;
import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public List<Room> selectRoomByType(String type) {
		return roomDao.selectRoomType(type);
	}

	@Override
	public List<Room> selectAll() {
		return roomDao.selectAll();
	}
	
	@Override
	public Room selectOne(long id) {
		return roomDao.selectOne(id);
	}

	
	//////////////////////////////
	@Override
	public List<Room> bookableRoom(List<Reservation> reservations, List<Room> rooms) {
		Iterator <Room> bookableRoom = rooms.iterator();
			
		if (reservations.size() != 0) {	//해당 날짜에 같은 타입의 방에 대한 예약이 있을 때
			while (bookableRoom.hasNext()) {	//ConcurrentModificationException 해결 위해 반복자(Iterator) 사용
				Room room = bookableRoom.next();
				for (Reservation r : reservations) {
					if (room.getId() == r.getRoom().getId()) {	//예약 내용과 같은 room을 제거
						bookableRoom.remove();					//디버깅 결과 rooms에서도 삭제되는 것을 확인할 수 있음 
					}
				}
			}			
		}
		
		return rooms;	//예약이 없을 때는 rooms 그대로 반환
	}
}
