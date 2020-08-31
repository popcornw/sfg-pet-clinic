package guru.springframework.sfgpetclinic;

import java.util.List;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {

		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");

	}

	@GetMapping("/find")
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return ("owners/findOwners");
	}

	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getLastName() == null) {
			owner.setLastName("");
		}

		List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

		if (results.isEmpty()) {
			result.rejectValue("lastName", "notFound", "not found");
			return ("owners/findOwners");

		}
		
		else if (results.size()==1) {
			owner=results.iterator().next();
			return"redirect:/owners/"+owner.getId();
			
			
		}
		model.addAttribute("selections", results);
		return "owners/ownersList";
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
