package controller;



public class Voiture {
	
	
	String nomvoiture;

	public String carburant;

	public String puissance;

	 public String nbporte;

	public String nbplace;

	public String prix;

	public String naturevoiture ;
	public String idvoiture ;
	//public String datef;
	/*Button modifier;*/
	 
	
	   
	

public Voiture(String idvoiture, String nomvoiture, String carburant, String puissance, String nbporte,
			 String nbplace, String prix,  String naturevoiture)/*,String dated,String datef )Button modifier)*/ {
		
		this.idvoiture=idvoiture;
		this.nomvoiture = nomvoiture;
		this.carburant = carburant;
		this.puissance = puissance;
		this.nbporte = nbporte;
		this.nbplace = nbplace;
		this.prix = prix;
		this.naturevoiture = naturevoiture;
		//this.dated=dated;
		//this.datef=datef;
}
		
		
	

	public String getIdvoiture() {
	return idvoiture;
}





public void setIdvoiture(String idvoiture) {
	this.idvoiture = idvoiture;
}





	public String getNomvoiture() {
		return nomvoiture;
	}



	public void setNomvoiture(String nomvoiture) {
		this.nomvoiture = nomvoiture;
	}



	public String getCarburant() {
		return carburant;
	}



	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}



	public String getPuissance() {
		return puissance;
	}



	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}



	public String getNbporte() {
		return nbporte;
	}



	public void setNbporte(String nbporte) {
		this.nbporte = nbporte;
	}



	public String getNbplace() {
		return nbplace;
	}



	public void setNbplace(String nbplace) {
		this.nbplace = nbplace;
	}



	public String getPrix() {
		return prix;
	}



	public void setPrix(String prix) {
		this.prix = prix;
	}



	public String getNaturevoiture() {
		return naturevoiture;
	}



	public void setNaturevoiture(String naturevoiture) {
		this.naturevoiture = naturevoiture;
	}




	

	/*public String getDatedebut() {
		return dated;
	}

	public void setDatedebut(String datedebut) {
		this.dated = datedebut;
	}

	public String getDatefin() {
		return datef;
	}

	public void setDatefin(String datefin) {
		this.datef = datefin;
	}*/
	
}