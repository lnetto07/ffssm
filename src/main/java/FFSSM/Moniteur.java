/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> listEmbauche=new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome, int niv) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niv);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
        if(listEmbauche.isEmpty()){
            return null;
        }
        Club employeur=listEmbauche.get(listEmbauche.size()-1).getEmployeur();
        if(listEmbauche.get(listEmbauche.size()-1).estTerminee()){
            return employeur;
        }
        else{
            return null;
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
        Embauche e=new Embauche(debutNouvelle,this,employeur);
        if (listEmbauche.isEmpty()){
            listEmbauche.add(e);
        }
        else{
            if (listEmbauche.get(listEmbauche.size()-1).estTerminee()){
                listEmbauche.add(e);
        }
            else{
                listEmbauche.get(listEmbauche.size()-1).setFin(debutNouvelle);
                listEmbauche.add(e);
        }
    }
    }

    public List<Embauche> emplois() {
        return listEmbauche;
    }

}
