package cabinet.jam.dto;

import java.io.Serializable;

public class SommationDto implements Serializable {
	
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
	private String archiver;
	private Long id;
	
	
	public String getArchiver() {
		return archiver;
	}
	public void setArchiver(String archiver) {
		this.archiver = archiver;
	}
	public SommationDto(String req_nom, String req_prenom, String req_tel, String req_quartier, String motif,
			String acc_nom, String acc_prenom, String acc_tel, String acc_quartier, String status, String reference,String archiver,Long id) {
		super();
		this.req_nom = req_nom;
		this.req_prenom = req_prenom;
		this.req_tel = req_tel;
		this.req_quartier = req_quartier;
		this.motif = motif;
		this.acc_nom = acc_nom;
		this.acc_prenom = acc_prenom;
		this.acc_tel = acc_tel;
		this.acc_quartier = acc_quartier;
		this.status = status;
		this.reference = reference;
		this.archiver  = archiver ;
		this.id = id;
	}
	
	public String getReq_nom() {
		return req_nom;
	}
	public void setReq_nom(String req_nom) {
		this.req_nom = req_nom;
	}
	public String getReq_prenom() {
		return req_prenom;
	}
	public void setReq_prenom(String req_prenom) {
		this.req_prenom = req_prenom;
	}
	public String getReq_tel() {
		return req_tel;
	}
	public void setReq_tel(String req_tel) {
		this.req_tel = req_tel;
	}
	public String getReq_quartier() {
		return req_quartier;
	}
	public void setReq_quartier(String req_quartier) {
		this.req_quartier = req_quartier;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getAcc_nom() {
		return acc_nom;
	}
	public void setAcc_nom(String acc_nom) {
		this.acc_nom = acc_nom;
	}
	public String getAcc_prenom() {
		return acc_prenom;
	}
	public void setAcc_prenom(String acc_prenom) {
		this.acc_prenom = acc_prenom;
	}
	public String getAcc_tel() {
		return acc_tel;
	}
	public void setAcc_tel(String acc_tel) {
		this.acc_tel = acc_tel;
	}
	public String getAcc_quartier() {
		return acc_quartier;
	}
	public void setAcc_quartier(String acc_quartier) {
		this.acc_quartier = acc_quartier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
