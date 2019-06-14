package cabinet.jam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabinet.jam.domaine.entities.Requerant;
import cabinet.jam.domaine.entities.Sommation;

import cabinet.jam.repository.SommationRepository;

@Service
public class ISommationServiceImpl implements ISommationService {

	@Autowired
	SommationRepository sommationRepository;
	
	@Override
	public Sommation saveSommationService(Sommation sommation) {
		// TODO Auto-generated method stub
		
		
		
		return sommationRepository.save(sommation);
	}

	@Override
	public List<Sommation> getAllSommation() {
		// TODO Auto-generated method stub
		return sommationRepository.findAll();
	}

	
	@Override
	public List<Sommation> rechercherParSommationStatus(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sommation rechercherParSommationId(Long id) {
		// TODO Auto-generated method stub
		return sommationRepository.getOne(id);
	}
	@Override
	public Sommation ArchiveSommation(Long id,String v) {
	
		Sommation som = sommationRepository.getOne(id);
		som.setArchive(v);
		
		return som ;
		}

	@Override
	public void creerpdfSommation(Sommation sommation, String chemin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sommation> rechercherParSommationRef(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sommation> getAllSommationByArchive(String str) {
		// TODO Auto-generated method stub
		return sommationRepository.findByArchive(str);
	}

	
}
