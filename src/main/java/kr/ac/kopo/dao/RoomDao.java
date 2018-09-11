package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.domain.Room;

public interface RoomDao {
	
	Room selectOne(long id);
	
	List<Room> selectRoomType(String type);	
	
	List<Room> selectAll();
		
}
