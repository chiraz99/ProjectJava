package controller;

public class Client {
public String idperson,nom,mdp,pays,genre;

	

public Client(String idperson, String nom, String mdp, String pays, String genre) {
	super();
	this.idperson = idperson;
	this.nom = nom;
	this.mdp = mdp;
	this.pays = pays;
	this.genre = genre;
}



public String getIdperson() {
	return idperson;
}



public void setIdperson(String idperson) {
	this.idperson = idperson;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getMdp() {
	return mdp;
}



public void setMdp(String mdp) {
	this.mdp = mdp;
}



public String getPays() {
	return pays;
}



public void setPays(String pays) {
	this.pays = pays;
}



public String getGenre() {
	return genre;
}



public void setGenre(String genre) {
	this.genre = genre;
}

}
