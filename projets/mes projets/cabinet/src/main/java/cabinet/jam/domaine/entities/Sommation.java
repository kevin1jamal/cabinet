package cabinet.jam.domaine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Sommation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String req_nom;
	private String req_prenom;
	private String req_tel;
	private String req_quartier;
	private String motif;
	
	private String acc_nom;
	private String acc_prenom;
	private String acc_tel;
	private String acc_quartier;
	private String status;
	private String reference;
	private String archive;

	
	

}
