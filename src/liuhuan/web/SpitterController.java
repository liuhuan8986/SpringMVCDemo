package liuhuan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liuhuan.data.SpitterRepository;
import liuhuan.model.Spitter;
@Controller
@RequestMapping("/spiltter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String showSpittleRegister(){
		return "register";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String processRegister(Spitter spitter){ 
		spitterRepository.save(spitter);
		return "redirect:/spiltter/"+spitter.getUsername();
	}
	@RequestMapping(value = "/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username")String username,Model model){
		model.addAttribute("spiltter",spitterRepository.findSpitterByUserName(username));
		return "profile";
	}
	
}
