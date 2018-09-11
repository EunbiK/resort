package kr.ac.kopo.web.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;
import kr.ac.kopo.domain.User;
import kr.ac.kopo.service.ReservationService;
import kr.ac.kopo.service.RoomService;
import kr.ac.kopo.service.UserService;

@Controller
public class ReservationController {
	//private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	
	@RequestMapping(value = "/list")
	public String resercation(Model model) {
		String[] dateList = reservationService.thirtieth();
		
		List<List<Room>> resonableGroup = new ArrayList<List<Room>>();
		List<List<Room>> generalGroup = new ArrayList<List<Room>>();
		List<List<Room>> vipGroup = new ArrayList<List<Room>>();

		
		for(String time : dateList) {
			List<Room> resonableRooms = selectBookableRoom("resonable", time);
			List<Room> generalRooms = selectBookableRoom("general", time);
			List<Room> vipRooms = selectBookableRoom("vip", time);
			
			resonableGroup.add(resonableRooms);
			generalGroup.add(generalRooms);
			vipGroup.add(vipRooms);
		}
		
		model.addAttribute("dateList", dateList);
		model.addAttribute("resonableGroup", resonableGroup);
		model.addAttribute("generalGroup", generalGroup);
		model.addAttribute("vipGroup", vipGroup);
		return "d_01";
	}
	
	@RequestMapping(value = "/insertForm")
	public String insertForm(Model model, @RequestParam(value="type", required=false) String type,
							 			  @RequestParam(value="date", required=false) String time) {
		
		if (type != null & time != null) {
			Reservation reservation = new Reservation();
			reservation.setTime(time);
			
			model.addAttribute("reservation",reservation);
			model.addAttribute("bookableRoom", selectBookableRoom (type, time));
			
		} else {	//�����ϱ�� �ٷ� ������ ���
			model.addAttribute("all", "all");
			model.addAttribute("dateList", reservationService.thirtieth());
			model.addAttribute("bookableRoom", roomService.selectAll());
		}
		
		return "d_02";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute Reservation reservation, @ModelAttribute User user, @RequestParam("roomId") Long roomId) {
		/*User user = userService.selectOne(1);			//�켱
		reservation.setUser(user);						//�켱*/		
		
		
		userService.createOne(user);
		reservation.setUser(user);
		
		
		Room room = roomService.selectOne(roomId);
		reservation.setRoom(room);
		
		reservationService.createOne(reservation);
		return "redirect:/list";
	}
	
	
	
	public List<Room> selectBookableRoom (String type, String time) {
		//�Ķ���Ϳ� ���� roomType����
		String roomType;
		if (type.equals("resonable")) roomType = "�ո����η�";
		else if (type.equals("general")) roomType = "�Ϲݷ�";
		else roomType = "VIP��";
		
		List<Reservation> reservations =  reservationService.selectAllByDateAndRoomType(time, roomType);	//�ش� ��¥&�ش� �� Ÿ�Կ� ���� ���� ��������
		List<Room> rooms = roomService.selectRoomByType(roomType);	//Ÿ�Կ� ���� room ��������
		
		return roomService.bookableRoom(reservations, rooms);
	}
	
}
