package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne{
	private String numeroINSEE;
        private String nom;
        private String prenom; 
        private String adresse; 
        private String telephone; 
        private LocalDate naissance;
        private ArrayList<Licence> lesLicences;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    }

    public String getNumeroINSEE() {
        return numeroINSEE;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getNaissance() {
        return naissance;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club c ){
        if (this.numeroINSEE.equals(numero)){
        Licence lic=new Licence(this, numero, delivrance, c);
        lesLicences.add(lic);
        }
    }        
    
    public Licence derniereLicence(){
        return lesLicences.get(lesLicences.size()-1);
    }

}
