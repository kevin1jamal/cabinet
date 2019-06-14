package cabinet.jam.service;

import java.util.List;


import cabinet.jam.domaine.entities.Sommation;

public interface ISommationService {
	
	
	public Sommation saveSommationService(Sommation sommation);
	public List<Sommation> getAllSommation();
	public List<Sommation> rechercherParSommationRef(String ref);
	public List<Sommation> rechercherParSommationStatus(String ref);
	public Sommation rechercherParSommationId(Long id);
	public Sommation ArchiveSommation(Long id,String v);
	public void creerpdfSommation(Sommation sommation,String chemin);
	public List<Sommation> getAllSommationByArchive(String str);

}
