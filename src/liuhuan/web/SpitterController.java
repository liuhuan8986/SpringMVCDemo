package liuhuan.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import liuhuan.data.SpitterRepository;
import liuhuan.model.Spitter;
@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String showSpittleRegister(Model model){
		 Spitter spitter =  new Spitter();
		 spitter.setFirstName("默认");
		 spitter.setLastName("默认");
		 spitter.setPassword("12346");
		 spitter.setUsername("默认用户");
		model.addAttribute("spitter", spitter);
		return "register";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String processRegister(@RequestPart("profilePicture") MultipartFile profilePicture, @ModelAttribute @Valid Spitter spitter,BindingResult errors,Model model) throws IllegalStateException, IOException{
		//request.setCharacterEncoding("GBK");
		if(errors.hasErrors()){
			model.addAttribute("spitter", spitter);
			System.out.println("hasErrors...");
			return "register";
		}
		System.out.println(profilePicture.getContentType());
		System.out.println(profilePicture.getName());
		System.out.println(profilePicture.getOriginalFilename());
		System.out.println(profilePicture.getSize());
		File dir  = new File("D:\\javaEEDev\\upload");
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		File file = new File(dir, profilePicture.getOriginalFilename());
		profilePicture.transferTo(file);
		System.out.println(spitter.toString());
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+URLEncoder.encode(spitter.getUsername(), "UTF-8");
		//return "redirect:/spitter/"+spitter.getUsername();
	}
	@RequestMapping(value = "/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username")String username,Model model){
		model.addAttribute("spitter",spitterRepository.findSpitterByUserName(username));
		return "profile";
	}
	
}
