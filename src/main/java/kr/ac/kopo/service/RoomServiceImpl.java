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
			
		if (reservations.size() != 0) {	//�ش� ��¥�� ���� Ÿ���� �濡 ���� ������ ���� ��
			while (bookableRoom.hasNext()) {	//ConcurrentModificationException �ذ� ���� �ݺ���(Iterator) ���
				Room room = bookableRoom.next();
				for (Reservation r : reservations) {
					if (room.getId() == r.getRoom().getId()) {	//���� ����� ���� room�� ����
						bookableRoom.remove();					//����� ��� rooms������ �����Ǵ� ���� Ȯ���� �� ���� 
					}
				}
			}			
		}
		
		return rooms;	//������ ���� ���� rooms �״�� ��ȯ
	}
}
