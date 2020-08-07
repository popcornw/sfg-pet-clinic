package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	private final SpecialityMapService specialityMapService;

	public VetServiceMap(SpecialityMapService specialityMapService) {

		this.specialityMapService = specialityMapService;
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		if (object.getSpecialties().size()>0) {
			 object.getSpecialties().forEach(specialty ->{
				if (specialty.getId()== null) {
					Specialty savedSpecialty = specialityMapService.save(specialty);
					specialty.setId(savedSpecialty.getId());
					
				}
			});
		}
		
		
		
		return super.save( object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
