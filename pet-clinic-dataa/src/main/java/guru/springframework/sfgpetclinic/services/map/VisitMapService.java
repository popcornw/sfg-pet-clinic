package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
	private final VisitRepository visitRepository;

	public VisitMapService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}

	@Override
	public Visit save(Visit visit) {

		if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("invalid visit");}
		return super.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		// TODO Auto-generated method stub
super.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
super.deleteById(id);
	}

}
