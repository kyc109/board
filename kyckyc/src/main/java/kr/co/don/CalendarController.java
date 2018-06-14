package kr.co.don;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/calendar/")
public class CalendarController {
	
	@RequestMapping(value="/calendar.java6",method=RequestMethod.GET)
	public void calendar() {
		
	}
}
