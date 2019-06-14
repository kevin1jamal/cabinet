package cabinet.jam.dto;

import java.io.Serializable;

public class RequerantDto implements Serializable{

	private String nom;
	private String prenom;
	private String tel;
	private String quartier;
	private Long id ;
	
	public RequerantDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RequerantDto(String nom, String prenom, String tel, String quartier,Long id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.quartier = quartier;
		this.id = id;
	}


	public  String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	
	public  long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public RequerantDto(String nom, String prenom, String tel, String quartier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.quartier = quartier;
	}


	
	
	
	
}
