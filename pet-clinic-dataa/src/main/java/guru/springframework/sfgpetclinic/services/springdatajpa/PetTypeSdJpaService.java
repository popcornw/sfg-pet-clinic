package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSdJpaService implements PetTypeService {
private final PetTypeRepository petTypeRepository;

public PetTypeSdJpaService(PetTypeRepository petTypeRepository) {
	super();
	this.petTypeRepository = petTypeRepository;
}

@Override
public Set<PetType> findAll() {
Set<PetType> petTypes = new HashSet<>();
petTypeRepository.findAll().forEach(petTypes::add);
	return petTypes;
}

@Override
public PetType findById(Long id) {
	// TODO Auto-generated method stub
	return petTypeRepository.findById(id).orElse(null);
}

@Override
public PetType save(PetType object) {
	// TODO Auto-generated method stub
	return petTypeRepository.save(object);
}

@Override
public void delete(PetType object) {
	petTypeRepository.delete(object);
	
}

@Override
public void deleteById(Long id) {
	// TODO Auto-generated method stub
	petTypeRepository.deleteById(id);
}

}
