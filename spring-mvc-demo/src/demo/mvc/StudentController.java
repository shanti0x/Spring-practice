package demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//creez o metoda pt a arata formularul
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		//creez ob student
		Student theStudent = new Student();
		
		//aduc ob student in model
		
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName()
		+ " " + theStudent.getLastName());
		
		return "student-confirmation";
		}
}
