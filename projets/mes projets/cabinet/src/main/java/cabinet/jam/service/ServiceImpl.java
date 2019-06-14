package cabinet.jam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabinet.jam.domaine.entities.Requerant;
import cabinet.jam.repository.RequerantRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class ServiceImpl implements IService {
	
	@Autowired
	RequerantRepository requerantRepository;
	  
	  
	
	public Requerant saveRequerantService(Requerant requerant) {
		
		return requerantRepository.save(requerant);
	}

	
	
	
	


	


	public List<Requerant> getAllrequerantService() {
		// TODO Auto-generated method stub
		return requerantRepository.findAll();
	}


	public List<Requerant> rechercherUnrequerant(String nom) {
		// TODO Auto-generated method stub
		return requerantRepository.findByNom(nom);
	}







	@Override
	public Optional<Requerant> rechercherUnrequerant(Long id) {
		// TODO Auto-generated method stub
		return  requerantRepository.findById(id);
	}







	@Override
	public void supprimerRequerant(Long id) {
	
		requerantRepository.deleteById(id);
		
		
	}










	@Override
	public void creerpdfrequeranr(Requerant requerant , String chemin) {
		// TODO Auto-generated method stub
		
		final String FILE_NAME = chemin+".pdf";
		String prenom = "Prenom : "+requerant.getPrenom();
		
		String nom = "Nom : "+requerant.getNom()+"                                                           "+prenom;
		
		String quartier = "Quartier : "+requerant.getQuartier();
		String tel = "Telephone : "+requerant.getTel()+"                                                            "+quartier;
		
		String titre = "FICHE DU REQUERANT ";
		
		
		
		
		Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            //open
            document.open();

            
            Font t = new Font();
           
            t.setSize(20);
            t.setStyle(Font.UNDERLINE);

           
            Paragraph p = new Paragraph();
            p.setFont(t);
            p.add(titre);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingAfter(5);
          
            

            document.add(p);
            
            
            Paragraph v2 = new Paragraph();
            document.add(v2);
            
            Paragraph v3 = new Paragraph();
            
            document.add(v3);

            Paragraph p2 = new Paragraph();
            p2.setPaddingTop(100);
            p2.add(nom); //no alignment

            document.add(p2);
            
            Paragraph p3 = new Paragraph();
            p3.add(tel); //no alignment
           
            document.add(p3);
           
            /*
            
            Font p4f = new Font();
            p4f.setColor(45, 16, 5);
            p4f.setStyle(Font.UNDERLINE);
            Paragraph p4 = new Paragraph();
            p4.add(quartier); //no alignment
            
            document.add(new Paragraph(quartier, p4f));

            document.add(p4);
 */
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);

            document.add(new Paragraph("les meilleurs diplomes du developpeur sont les projets", f));

            //close
            document.close();
            

            System.out.println("Done");
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

    
		
	}

}