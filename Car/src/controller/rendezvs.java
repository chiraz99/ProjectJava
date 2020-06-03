package controller;







public class rendezvs {
	 public String idvoiture,nomvoiture,carburant,puissance,nbporte,nbplace,prix, naturevoiture ;
	 
	
	   
	 public rendezvs(String idvoiture, String nomvoiture, String carburant, String puissance, String nbporte,
				String nbplace, String prix, String naturevoiture ) {
			
			this.idvoiture = idvoiture;
			this.nomvoiture = nomvoiture;
			this.carburant = carburant;
			this.puissance = puissance;
			this.nbporte = nbporte;
			this.nbplace = nbplace;
			this.prix = prix;
			this.naturevoiture = naturevoiture;
	 }
	        



	



	public String getIdvoiture() {
		return idvoiture;
	}

	public void setIdvoiture(String idvoiture) {
		this.idvoiture= idvoiture;
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
	 
	    


}