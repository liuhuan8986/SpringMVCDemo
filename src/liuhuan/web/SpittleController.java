package liuhuan.web;

import java.util.List;

import javax.xml.ws.Service.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import liuhuan.data.SpittleRepository;
import liuhuan.exception.SpittleNotFoundException;
import liuhuan.model.Spitter;
import liuhuan.model.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepository;
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model){
		System.out.println("spittles....11111....");                                                                
		model.addAttribute("spiltleList",spittleRepository.findSpittles(Integer.MAX_VALUE, 20));
		return "spittles";
	}
	
/*	@RequestMapping(method = RequestMethod.GET)	
	public List<Spittle> spittles(@RequestParam(value = "max",defaultValue="10000")long max,@RequestParam(value = "count",defaultValue = "20") int count){
		System.out.println("spittles...2222222.....");
		System.out.println("spittles..max="+max);
		System.out.println("spittles..count="+count);
		if(spittleRepository!=null){
			System.out.println("spittleRepository is not null");
		}
		return spittleRepository.findSpittles(max, count);
	}*/
	@RequestMapping(value="/show" ,method = RequestMethod.GET)
	public String spittles(@RequestParam("id")long spittleId,Model model){
		System.out.println("spittles...33333333.....spittleId=="+spittleId);
		model.addAttribute("spiltle",spittleRepository.findOne(spittleId));
		return "showSpillte";
	}
	
	@RequestMapping(value="/{spittleId}",method = RequestMethod.GET)
	public String spittlesByPath(@PathVariable("spittleId") long id,Model model){
		model.addAttribute("spiltle",spittleRepository.findOne(id));
		return "showSpillte";
	}
	
}
