package guru.springframework.sfgpetclinicapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
@Component
public class DataLoader implements CommandLineRunner {
private final OwnerService ownerService;
private final VetService vetService;
	public DataLoader() {
		ownerService= new OwnerServiceMap();
		vetService= new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Micheal");
		owner1.setLastName("weston");
		ownerService.save(owner1);
		
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		ownerService.save(owner2);
		
		
		System.out.println("loaded owner ... ");
		
		
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("kappa");
		vet1.setLastName("joe");
		vetService.save(vet1);
		
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("hehe");
		vet2.setLastName("xddd");
		vetService.save(vet2);
		
		System.out.println("loaded vet ... ");
		
	}

}
