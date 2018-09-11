package kr.ac.kopo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.ReservationDao;
import kr.ac.kopo.domain.Reservation;

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
			formattedDate[i] = dformat.format(cal.getTime());
			cal.add(cal.DATE, +1);
		}
		return formattedDate;
	}

	@Override
	public List<Reservation> selectAllByDateAndRoomType(String time, String roomType) {
		return reservationDao.selectAllByDateAndRoomType(time, roomType);
	}
	
	@Override
	public int createOne(Reservation reservation) {
		return reservationDao.createOne(reservation);
	}


	
	
	
}
