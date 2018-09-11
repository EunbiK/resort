package kr.ac.kopo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;
import kr.ac.kopo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationDaoTest {
	
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	UserDao userDao;
	
	/*@Test
	public void testSelectAll() throws Exception {
		List<Reservation> r = reservationDao.selectAll();
		assertEquals(0, r.size());
	      
		//assertEquals(3, 3);
	}*/
	
//	@Test
//	public void testSelectRoomType() {
//		List<Room> r = roomDao.selectRoomType("钦府利牢冯");
//		assertEquals(5, r.size());
//	}
//	
//	@Test
//	public void testSelectOneByAuth() {
//		User u = userDao.selectOneByAuth("user");
//		assertEquals("1234", u.getPassword());
//		User a = userDao.selectOneByAuth("admin");
//		assertEquals("5678", a.getPassword());
//	}
	
//	@Test
//	public void testSelectAllByDate() {
//		List<Reservation> reservations = reservationDao.selectAllByDate("2018-09-06");
//		
//		for (Reservation r: reservations) {
//			System.out.println(r.getId());
//		}
//	}
	
	@Test
	public void testSelectAllByDateAndRoomType() {
		List<Reservation> reservations = reservationDao.selectAllByDateAndRoomType("2018-09-06", "钦府利牢冯");
		
		for (Reservation r: reservations) {
			System.out.println(r.getId() + " " + r.getRoom().getId());
		}
	}
	
	
	
	
}
