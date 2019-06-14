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
public class Requerant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nom;
	private String prenom;
	private String tel;
	private String quartier;
	public Requerant(String nom, String prenom, String tel, String quartier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.quartier = quartier;
	}
	


}
