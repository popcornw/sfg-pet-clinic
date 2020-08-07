package guru.springframework.sfgpetclinic;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
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
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedcatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();

		owner1.setFirstName("Micheal");
		owner1.setLastName("weston");
		owner1.setAddress("testttt");
		owner1.setCity("casablanca");
		owner1.setTelephone("45666666");
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();

		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("testttt");
		owner2.setCity("casablanca");
		owner2.setTelephone("45666666");
		ownerService.save(owner2);
		
 Pet mikesPet = new Pet();
 mikesPet.setBirthDate(LocalDate.now());
 mikesPet.setOwner(owner1);
 mikesPet.setPetType(savedDogPetType);
 mikesPet.setName("rex");
 owner1.getPets().add(mikesPet);
 
 
 Pet fionasCat  = new Pet();
 fionasCat.setBirthDate(LocalDate.now());
 fionasCat.setOwner(owner2);
 fionasCat.setPetType(savedcatPetType);
 fionasCat.setName("miwa");
 owner2.getPets().add(fionasCat);
		
		
		
		

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
