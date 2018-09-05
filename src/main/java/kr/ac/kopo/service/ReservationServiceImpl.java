package kr.ac.kopo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.ReservationDao;
import kr.ac.kopo.domain.Room;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	public String[] thirtieth() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		String[] formattedDate = new String[30];
		
		for(int i=0; i<30; i++) {
			//System.out.println("date:" + dformat.format(cal.getTime()));
			formattedDate[i] = dformat.format(cal.getTime());
			cal.add(cal.DATE, +1);
		}
		return formattedDate;
	}

	@Override
	public List<Room> selectRoomType(String type) {
		return reservationDao.selectRoomType(type);
	}
	
}
