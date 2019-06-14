package cabinet.jam.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.google.common.collect.Lists;


import cabinet.jam.domaine.entities.Sommation;

import cabinet.jam.dto.SommationDto;
import cabinet.jam.service.ISommationService;

@Controller
public class SommationController {
	
	//on injecte la couche service
			@Autowired
			private ISommationService service;
			
			@GetMapping("/sommation.asp")
			public String afficherlistesommation(@ModelAttribute SommationDto sommationDto, Model model) {
				
				//recuperation de la liste des sommation
				
				List<Sommation> listesommation= service.getAllSommationByArchive("NON");
				
				//pour ne pas faire circuler l'entité requerant dans le reseau, on mappe la liste d'entité avec celle de DTO pour n'avoir que des requerant DTO( ie sans Id)
				List<SommationDto> listesommationsDTO= Lists.transform(listesommation, (Sommation input) -> new SommationDto(input.getReq_nom(),input.getReq_prenom(),input.getReq_tel(),input.getReq_quartier(),input.getMotif(),input.getAcc_nom(),input.getAcc_prenom(),input.getAcc_tel(),input.getAcc_quartier(),input.getStatus(),input.getReference(),input.getArchive(),input.getId()));
			
				//enregistrement de la liste des agriculteurs dans le model pour pouvoir la passer à la vue
				model.addAttribute("listesommationDTO", listesommationsDTO);
				model.addAttribute("sommationDto", sommationDto);
					
				return "sommation";
			}
			
			@GetMapping("/sommationarchive.asp")
			public String afficherlistesommationarchiver(@ModelAttribute SommationDto sommationDto, Model model) {
				
				//recuperation de la liste des sommation
				
				List<Sommation> listesommation= service.getAllSommationByArchive("OUI");
				
				//pour ne pas faire circuler l'entité requerant dans le reseau, on mappe la liste d'entité avec celle de DTO pour n'avoir que des requerant DTO( ie sans Id)
				List<SommationDto> listesommationsDTO= Lists.transform(listesommation, (Sommation input) -> new SommationDto(input.getReq_nom(),input.getReq_prenom(),input.getReq_tel(),input.getReq_quartier(),input.getMotif(),input.getAcc_nom(),input.getAcc_prenom(),input.getAcc_tel(),input.getAcc_quartier(),input.getStatus(),input.getReference(),input.getArchive(),input.getId()));
			
				//enregistrement de la liste des sommation dans le model pour pouvoir la passer à la vue
				model.addAttribute("listesommationDTO", listesommationsDTO);
				model.addAttribute("sommationDto", sommationDto);
					
				return "archiveSommation";
			}
			
			//controller qui traitera les données saisies dans le formulaire
			
			@PostMapping("/creersommation")
			public String enregistrerSommation(@ModelAttribute SommationDto sommationDto, Model model) {
				
				Sommation req= new Sommation();
				
				
				
				req.setReq_nom(sommationDto.getReq_nom());
				req.setReq_prenom(sommationDto.getReq_prenom());
				req.setReq_tel(sommationDto.getReq_tel());
				req.setReq_quartier(sommationDto.getReq_quartier());
				
				req.setAcc_nom(sommationDto.getAcc_nom());
				req.setAcc_prenom(sommationDto.getAcc_prenom());
				req.setAcc_tel(sommationDto.getAcc_tel());
				req.setAcc_quartier(sommationDto.getAcc_quartier());
				req.setMotif(sommationDto.getMotif());
				req.setReference(sommationDto.getReference());
				sommationDto.setArchiver("NON");
				req.setArchive(sommationDto.getArchiver());
				
				
				
				
				
				service.saveSommationService(req);
				
				
				return "redirect:/sommation.asp";
			}
			@PostMapping("/sr/{id}")
			public String updateRequerant(@PathVariable("id") Long id,SommationDto sommationDto, Model model) {
				
				 Long j = (Long) id ;


Sommation req = service.rechercherParSommationId(j);
				
				req.setReq_nom(sommationDto.getReq_nom());
				req.setReq_prenom(sommationDto.getReq_prenom());
				req.setReq_tel(sommationDto.getReq_tel());
				req.setReq_quartier(sommationDto.getReq_quartier());
				
				req.setAcc_nom(sommationDto.getAcc_nom());
				req.setAcc_prenom(sommationDto.getAcc_prenom());
				req.setAcc_tel(sommationDto.getAcc_tel());
				req.setAcc_quartier(sommationDto.getAcc_quartier());
				req.setMotif(sommationDto.getMotif());
				
				req.setReference(sommationDto.getReference());
				sommationDto.setArchiver("NON");
				req.setArchive(sommationDto.getArchiver());
				req.setId(j);
				
				
				
				
				
				
				service.saveSommationService(req);
				
			
				return "redirect:/sommation.asp";			}
			
			@GetMapping("/arch/{id}")
			public String effacersommation(@PathVariable("id") Long id) {
			  
				 Long j = (Long) id ;


				 Sommation req = service.ArchiveSommation(j,"OUI");
				 				
				 	
				 				service.saveSommationService(req);
				 				
				 			return "redirect:/sommation.asp";
			}
			
			@GetMapping("/archplus/{id}")
			public String desarchivesommation(@PathVariable("id") Long id) {
			  
				 Long j = (Long) id ;


				 Sommation req = service.ArchiveSommation(j,"NON");
				 				
				 	
				 				service.saveSommationService(req);
				 				
				 			return "redirect:/sommation.asp";
			}
	 		
			    

}
