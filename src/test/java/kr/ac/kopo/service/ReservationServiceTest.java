package kr.ac.kopo.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationServiceTest {
	
	@Autowired
	ReservationService reservationService;
	
	@Test
	public void testDateList() {
		String[] dateList = reservationService.thirtieth();
		//for(int i=0; i<30; i++) {
			assertEquals("2018-09-05", dateList[0]);
			assertEquals("2018-10-04", dateList[29]);
		//}
	}
	
}
