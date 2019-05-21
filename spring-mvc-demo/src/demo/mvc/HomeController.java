package demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //extinde @component
public class HomeController {
	
	@RequestMapping("/")
public String showPage() {
	return "main-menu";
}
}
