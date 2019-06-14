package cabinet.jam.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

import cabinet.jam.domaine.entities.Exportexcel;
import cabinet.jam.domaine.entities.Requerant;
import cabinet.jam.dto.RequerantDto;
import cabinet.jam.repository.RequerantRepository;
import cabinet.jam.service.IService;


@Controller
public class CabinetController {
	
	//on injecte la couche service
		@Autowired
		private IService service;
		
		@GetMapping("/")
		public String indexlisterequerant(@ModelAttribute RequerantDto requerantDto, Model model) {
			
			//recuperation de la liste des requerants
			List<Requerant> listerequerant= service.getAllrequerantService();
			
			//pour ne pas faire circuler l'entité requerant dans le reseau, on mappe la liste d'entité avec celle de DTO pour n'avoir que des requerant DTO( ie sans Id)
			List<RequerantDto> listerequerantsDTO= Lists.transform(listerequerant, (Requerant input) -> new RequerantDto(input.getNom(),input.getPrenom(),input.getTel(),input.getQuartier(),input.getId()));
		
			//enregistrement de la liste des agriculteurs dans le model pour pouvoir la passer à la vue
			model.addAttribute("listerequerantDTO", listerequerantsDTO);
				
			return "tables";
		}
		
		//controller qui traitera les données saisies dans le formulaire
		
		@PostMapping("/list")
		public String enregistrerRequerant(@ModelAttribute RequerantDto requerantDto, Model model) {
			
			Requerant req= new Requerant();
			
			
			req.setNom(requerantDto.getNom());
			req.setPrenom(requerantDto.getPrenom());
			req.setTel(requerantDto.getTel());
			req.setQuartier(requerantDto.getQuartier());
			
			
			
			service.saveRequerantService(req);
			
			
			return "redirect:requerant.asp";
		}

		
		@GetMapping("/afficher")
		public String afficherform(@ModelAttribute RequerantDto requerantDto, Model model) {
			
			
				
			return "enregistrerRequerant";
		}
		
		@GetMapping("/requerant.asp")
		public String afficherlisterequerant(@ModelAttribute RequerantDto requerantDto, Model model) {
			
			//recuperation de la liste des requerants
			List<Requerant> listerequerant= service.getAllrequerantService();
			
			//pour ne pas faire circuler l'entité requerant dans le reseau, on mappe la liste d'entité avec celle de DTO pour n'avoir que des requerant DTO( ie sans Id)
			List<RequerantDto> listerequerantsDTO= Lists.transform(listerequerant, (Requerant input) -> new RequerantDto(input.getNom(),input.getPrenom(),input.getTel(),input.getQuartier(),input.getId()));
		
			//enregistrement de la liste des agriculteurs dans le model pour pouvoir la passer à la vue
			model.addAttribute("listerequerantDTO", listerequerantsDTO);
			model.addAttribute("requerantDto", requerantDto);
				
			return "tables";
		}
		@GetMapping("/s/{i}")
		public String effacerrequerant(@PathVariable("i") Long i) {
		    Long j = (Long)i;
 			service.supprimerRequerant(j);
 		
		    return "redirect:/requerant.asp";
		}
		@PostMapping("/{id}")
		public String updateRequerant(@PathVariable("id") Long id,RequerantDto requerantDto, Model model) {
			 Long j = (Long)id;
			 
			
		Requerant requerant = new Requerant();
		
		requerant.setNom(requerantDto.getNom());
		requerant.setPrenom(requerantDto.getPrenom());
		requerant.setQuartier(requerantDto.getQuartier());
		requerant.setTel(requerantDto.getTel());
		requerant.setId(j);
		
		
		service.saveRequerantService(requerant );
		//recuperation de la liste des requerants
		List<Requerant> listerequerant= service.getAllrequerantService();
			 List<RequerantDto> listerequerantsDTO= Lists.transform(listerequerant, (Requerant input) -> new RequerantDto(input.getNom(),input.getPrenom(),input.getTel(),input.getQuartier(),input.getId()));    
		   
			 model.addAttribute("listerequerantDTO", listerequerantsDTO);
		    return "redirect:requerant.asp";
		}
		@GetMapping("/{id}")
		public String showUpdateForm(@PathVariable("id") long id, Model model) {
			 long j = (long)id;
			 
			 
				
				Optional<Requerant>  req = service.rechercherUnrequerant(j);
				Requerant requerant = req.get();
				service.creerpdfrequeranr(requerant,requerant.getPrenom());
				
				RequerantDto requerantDto = new RequerantDto(requerant.getNom(),requerant.getPrenom(),requerant.getQuartier(),requerant.getTel(),requerant.getId());
				
		    model.addAttribute("requerantDto", requerantDto);
		    return "modifierrequerant";
		}
		
		
		
		@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
		public ModelAndView downloadExcel(Model model) {

			 List<Requerant> listerequerant= service.getAllrequerantService(); 

		   
		    return new ModelAndView(new Exportexcel(), "listerequerant", listerequerant );
		    }
		}

