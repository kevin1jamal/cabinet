package cabinet.jam.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cabinet.jam.domaine.entities.User;
import cabinet.jam.dto.RequerantDto;
import cabinet.jam.service.Userservice;



@Controller
public class LoginController {

	@Autowired
	private Userservice userService;

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
		
	}
	
	@RequestMapping(value= {"/","/registration"}, method = RequestMethod.GET)
	public ModelAndView registration(){
		final ModelAndView modelAndView = new ModelAndView();
		
		final User user = new User();
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		final ModelAndView modelAndView = new ModelAndView();
		final User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
			.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}
	
	@GetMapping("/creer")
	public String afficherform(@ModelAttribute RequerantDto requerantDto, Model model) {
		
		
			
		return "enregistrer";
	}
	
	@GetMapping("/connexion")
	public String connexionform(@ModelAttribute RequerantDto requerantDto, Model model) {
		
		
			
		return "connexion";
	}
	
	@GetMapping("/perdu")
	public String perduform(@ModelAttribute RequerantDto requerantDto, Model model) {
		
		
			
		return "passeperdu";
	}
	
	
}
