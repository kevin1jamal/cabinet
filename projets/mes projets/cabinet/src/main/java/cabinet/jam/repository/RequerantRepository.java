package cabinet.jam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cabinet.jam.domaine.entities.Requerant;


@Repository("requerantRepository")
public interface RequerantRepository extends JpaRepository<Requerant, Long> {

	Requerant findBytel(String tel);
	
	List<Requerant> findByNom(String nom);
	

	
	
}
