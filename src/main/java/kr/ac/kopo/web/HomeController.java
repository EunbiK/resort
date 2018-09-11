package kr.ac.kopo.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.domain.User;
import kr.ac.kopo.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "main")
	public String main() {
		return "main";
	}
	@RequestMapping(value = "/vip")
	public String vip() {
		return "a_01";
	}
	@RequestMapping(value = "/general")
	public String general() {
		return "a_02";
	}
	@RequestMapping(value = "/resonable")
	public String resonable() {
		return "a_03";
	}
	@RequestMapping(value = "/location")
	public String location() {
		return "b_01";
	}
	@RequestMapping(value = "/public")
	public String publicTransit() {
		return "b_02";
	}
	@RequestMapping(value = "/car")
	public String car() {
		return "b_03";
	}
	@RequestMapping(value = "/mountain")
	public String mountain() {
		return "c_01";
	}
	@RequestMapping(value = "/beach")
	public String beach() {
		return "c_02";
	}
	@RequestMapping(value = "/spa")
	public String spa() {
		return "c_03";
	}
	
	
	////COOKIE
	@RequestMapping(value = "/jsp_setCookie")
	public String jsp_setCookie() {
		return "jsp/jsp_setCookie";
	}
	@RequestMapping(value = "/jsp_getCookie")
	public String jsp_getCookie() {
		return "jsp/jsp_getCookie";
	}
	@RequestMapping(value = "/jsp_clearCookie")
	public String jsp_clearCookie() {
		return "jsp/jsp_clearCookie";
	}
	
	@RequestMapping(value = "/spring_setCookie", method=RequestMethod.GET)
	public String spring_setCookie(Model model, HttpServletResponse response) {
		logger.info("set_cookie.");
		
		//set cookie
		Cookie userIdCookie = new Cookie("userIdCookie", "777");
		userIdCookie.setPath("/");
		userIdCookie.setMaxAge(60 * 60 * 24 * 30); //하루
		response.addCookie(userIdCookie);
		
		return "spring/spring_setCookie";
	}
	
	@RequestMapping(value = "/spring_getCookie", method=RequestMethod.GET)
	public String spring_getCookie(Model model, @CookieValue(value="userIdCookie", required = false) Cookie userIdCookie) {
		logger.info("get_cookie.");
		
		//get cookie
		if (userIdCookie != null) {
			System.out.println("userIdCookie: " + userIdCookie.getValue());
		}
		
		model.addAttribute("userIdCookie", userIdCookie.getValue());
		return "spring/spring_getCookie";
	}
	
	
	/////SESSION
	
	@RequestMapping(value = "/jsp_setSession")
	public String jsp_setSession() {
		return "jsp/jsp_setSession";
	}
	@RequestMapping(value = "/jsp_getSession")
	public String jsp_getSession() {
		return "jsp/jsp_getSession";
	}
	@RequestMapping(value = "/jsp_clearSession")
	public String jsp_clearSession() {
		return "jsp/jsp_clearSession";
	}
	
	@RequestMapping(value = "/spring_setSession", method=RequestMethod.GET)
	public String spring_setSession(Model model, HttpSession session, @RequestParam Map<String, String> param) {
		logger.info("set_session.");
		
		session.setAttribute("userId", 123);
		
		return "spring/spring_setSession";
	}
	
	@RequestMapping(value = "/spring_getSession", method=RequestMethod.GET)
	public String spring_getSession(Model model, HttpSession session) {
		logger.info("get_session.");
		
		int userId = (int) session.getAttribute("userId");		//파라미터 받은게 없는데 userId 사용함
		System.out.println("userId: " + userId);
		
		model.addAttribute("userId", userId);
		
		return "spring/spring_getSession";
	}
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	@RequestMapping(value = "/admin")
	public String admin() {
		return "login/admin";
	}
	@RequestMapping(value = "/error")
	public String error() {
		return "login/error";
	}
	
	@RequestMapping(value = "/authentication")
	public String authentication(@RequestParam Map<String, String> param, HttpSession session) {
		String auth = param.get("auth");
		String pw = param.get("pw");
		
		User user = userService.selectOneByAuth(auth);
		
		if (pw.equals(user.getPassword())) {
			if (auth.equals("user")) {
				session.setAttribute("userId", 1);
				return "main";
			} else { //admin
				session.setAttribute("userId", 8);
				return "login/admin";
			}
		} else {
			return "login/error";
		}
	}
}
