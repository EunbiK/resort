package kr.ac.kopo.web.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;
import kr.ac.kopo.service.ReservationService;

@Controller
public class ReservationController {
	//private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private ReservationService reservationService;
	
	
	@RequestMapping(value = "/list")
	public String resercation(Model model) {
		String[] dateList = reservationService.thirtieth();
		model.addAttribute("dateList", dateList);
		return "d_01";
	}
	
	@RequestMapping(value = "/insertForm")
	public String insertForm(Model model, @RequestParam("type") String type, @RequestParam("date") String date) {
		List<Room> roomType = reservationService.selectRoomType(type);
		
		Reservation reservation = new Reservation();
		reservation.setTime(date);
		model.addAttribute("roomType", roomType);
		model.addAttribute("reservation",reservation);
		return "d_02";
	}
	
	@RequestMapping(value = "/insert")
	public void insert() {
		
	}
	
}
