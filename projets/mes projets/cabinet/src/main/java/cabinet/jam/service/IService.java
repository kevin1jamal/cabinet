package cabinet.jam.service;

import java.util.List;
import java.util.Optional;

import cabinet.jam.domaine.entities.Requerant;


public interface IService {
	
	public Requerant saveRequerantService(Requerant requerant);
	public List<Requerant> getAllrequerantService();
	public List<Requerant> rechercherUnrequerant(String nom);
	public Optional<Requerant> rechercherUnrequerant(Long id);
	public void supprimerRequerant(Long id);
	public void creerpdfrequeranr(Requerant requerant,String chemin);
	

}
