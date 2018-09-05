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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationDaoTest {
	
	@Autowired
	ReservationDao reservationDao;
	
	/*@Test
	public void testSelectAll() throws Exception {
		List<Reservation> r = reservationDao.selectAll();
		assertEquals(0, r.size());
	      
		//assertEquals(3, 3);
	}*/
	
	@Test
	public void testSelectRoomType() {
		List<Room> r = reservationDao.selectRoomType("«’∏Æ¿˚¿Œ∑Î");
		assertEquals(5, r.size());
	}
}
