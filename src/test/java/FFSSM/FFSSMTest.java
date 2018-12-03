/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author lnetto
 */
public class FFSSMTest {
    private Club club;
    private Moniteur julien,patrick;
    private Plongee plonge1, plonge2;
    private Plongeur quentin,louise,marc;
    private Site plage;
    private Licence q,l,m;
   
  
    
    @Before
    public void setUp(){
        Calendar d1=new GregorianCalendar(1970,05,26);
        Calendar d2=new GregorianCalendar(1970,07,26);
        Calendar d7=new GregorianCalendar(2000,04,26);
        Calendar d8=new GregorianCalendar(2000,07,26);
        club=new Club(patrick, "les plongeurs fous", "05.53.41.19.01");
        julien=new Moniteur("xvkvkl25", "Hugi", "julien", " 12 reu du muguet castres", "05.53.25.26.58", d1, 15, 8);
        patrick=new Moniteur("hdkss58","Gusman","Patrick","15 rue des arc-en-ciel,Bordeaux","05.26.89.35.12",d2,56,9);
        plage= new Site("plage","12 rue des chevaux");
        plonge1=new Plongee(plage,patrick,d8,500,48);
        plonge2=new Plongee(plage,patrick,d8,500,48);
        quentin=new Plongeur("gdyehdk254","Aguettaz","Quentin", "12 reu des alouettes","05.53.65.28.59", d1,8);
        louise=new Plongeur("gdyehdk254","kuiz","Louise", "12 rue des alouettes","05.53.65.28.59", d1,8);
        marc=new Plongeur("gdyhgdk254","Assic","Marc", "12 reu des mouettes","05.53.65.28.59", d2,8);
        q=new Licence(quentin, "gdyjdld5", d7, 8,  club);
        l=new Licence(louise, "jdkdkyjdld5", d7, 8,  club);
        m=new Licence(marc, "gjzolshdld5", d2, 8,  club);
        louise.ajouteLicence(l);
        quentin.ajouteLicence(q);
        
    }
    
    @Test
    public void testMoniteur(){
        Calendar d3=new GregorianCalendar(2018,05,20);
        Calendar d4=new GregorianCalendar(2018,07,20);
        Calendar d5=new GregorianCalendar(2019,05,20);
        assertEquals(null,julien.employeur());
        julien.nouvelleEmbauche(club, d3);
        assertEquals(null,julien.employeur());
        assertEquals(julien.listEmbauche.get(julien.listEmbauche.size()-1).estTerminee(),false);
        julien.listEmbauche.get(julien.listEmbauche.size()-1).setFin(d4);
        assertEquals(julien.listEmbauche.get(julien.listEmbauche.size()-1).estTerminee(),true);
        assertEquals(julien.employeur(),club);
        julien.nouvelleEmbauche(club, d4);
        assertEquals(julien.listEmbauche.size(),2);
        julien.nouvelleEmbauche(club, d5);
        assertEquals(julien.listEmbauche.size(),3);
    }
    
    @Test
    public void testAjoutParticipant(){
        assertEquals(plonge1.listePlongeur.size(),0);
        plonge1.ajouteParticipant(marc);
        assertEquals(plonge1.listePlongeur.size(),1);
        plonge1.ajouteParticipant(louise);
        assertEquals(plonge1.listePlongeur.size(),2);          
    } 
    
    @Test
    public void testAjoutLicence(){
       assertEquals(marc.listeLicence.size(),0);
       marc.ajouteLicence(m);
       assertEquals(marc.listeLicence.size(),1);
       
       
    }
    
    @Test
    public void testConformeLicence(){
        Calendar d9=new GregorianCalendar(2001,07,26);
        Calendar d4=new GregorianCalendar(2000,07,26);
        assertTrue(l.estValide(d4));
        assertFalse(l.estValide(d9)); 
    }
    
    @Test
    public void testConformePlongee(){
        plonge1.ajouteParticipant(louise);
        plonge1.ajouteParticipant(quentin);   
        assertTrue(plonge1.estConforme());
        plonge1.ajouteParticipant(marc);
        assertFalse(plonge1.estConforme());
    }
    
    @Test
    public void testClub(){
        club.organisePlongee(plonge1);
        plonge1.ajouteParticipant(quentin);
        plonge1.ajouteParticipant(marc);
        assertEquals(1, club.listePlongee.size());
        assertEquals(1,club.plongeesNonConformes().size());
    }

    
    
    
}
