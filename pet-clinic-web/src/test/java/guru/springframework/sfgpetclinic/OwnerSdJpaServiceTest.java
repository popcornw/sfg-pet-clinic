package guru.springframework.sfgpetclinic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.springdatajpa.OwnerSdJpaService;

@ExtendWith(MockitoExtension.class)
class OwnerSdJpaServiceTest {
	public static final String LAST_NAME = "string";
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@Mock
	PetRepository petRepository;
	@InjectMocks
	OwnerSdJpaService ownerService;
	Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		Set<Owner> Owners = ownerService.findAll();
		assertEquals(2, Owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = ownerService.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = ownerService.findById(1L);
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner = ownerService.save(ownerToSave);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());

	}

	@Test
	void testDelete() {
		ownerService.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerService.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner smith = ownerService.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME, smith.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

}
