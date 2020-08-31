package guru.springframework.sfgpetclinic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {

		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/index", "/index.html" })
	public String ListOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());

		return ("owners/index");

	}

	@GetMapping("/find")
	public String findOwners() {

		return ("notimplemented");
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
//		for (Pet pet : owner.getPets()) {
//			pet.setVisitsInternal(visits.findByPetId(pet.getId()));
//		}
		
		return mav;
	}
	

}
