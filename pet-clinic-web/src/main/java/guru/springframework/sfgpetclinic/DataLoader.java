package guru.springframework.sfgpetclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType=petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedcatPetType=petTypeService.save(cat);
		
		
		
		
		Owner owner1 = new Owner();

		owner1.setFirstName("Micheal");
		owner1.setLastName("weston");
		ownerService.save(owner1);

		Owner owner2 = new Owner();

		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		ownerService.save(owner2);

		System.out.println("loaded owner ... ");

		Vet vet1 = new Vet();

		vet1.setFirstName("kappa");
		vet1.setLastName("joe");
		vetService.save(vet1);

		Vet vet2 = new Vet();

		vet2.setFirstName("hehe");
		vet2.setLastName("xddd");
		vetService.save(vet2);

		System.out.println("loaded vet ... ");

	}

}
