package ma.cigma.springsecurity.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.cigma.springsecurity.service.model.User;
import ma.cigma.springsecurity.service.IUserService;
import ma.cigma.springsecurity.domaine.UserRegistrationDto;

	@Controller
	@RequestMapping("/registration")
	public class UserRegistrationController {

	    @Autowired
	    private IUserService userService;

	    @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }

	    @GetMapping
	    public String showRegistrationForm(Model model) {
	        return "registration";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
	                                      BindingResult result){

	        User existing = userService.findByUsername(userDto.getUsername());
	        if (existing != null){
	            result.rejectValue("username", null, "There is already a user registered with that username");
	        }

	        if (result.hasErrors()){
	            return "registration";
	        }

	        userService.save(userDto);
	        return "redirect:/registration?success";
	    }

}
