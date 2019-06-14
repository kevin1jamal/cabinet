package cabinet.jam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cabinet.jam.domaine.entities.*;

@Repository("sommationRepository")
public interface SommationRepository extends JpaRepository<Sommation, Long> {

 
	
	
	Sommation findByReference(String ref);
	List<Sommation> findByStatus(String sta);
	List<Sommation> findByArchive(String arch);
	
	
	 

}
