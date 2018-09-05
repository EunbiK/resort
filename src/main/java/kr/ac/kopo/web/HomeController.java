package kr.ac.kopo.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
}
