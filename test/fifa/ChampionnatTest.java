/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import fifa.packVue.VueGlobaleAdmin;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quentin
 */
public class ChampionnatTest {
    Pays fra;
    Pays ang;
    Pays esp;
    Pays all;
    Pays ita;
    
    Championnat chp;
    
    public ChampionnatTest() {
        
       
            
        fra = new Pays(4, "France");   
        fra.importEquipe();
        
        
        ang = new Pays(8, "Angleterre"); 
        ang.importEquipe();
        
        esp = new Pays(6, "Espagne"); 
        esp.importEquipe();
        
        all = new Pays(1, "Allemange"); 
        all.importEquipe();
        
        ita = new Pays(7, "Italie"); 
        ita.importEquipe();
       
        ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(fra);
        pays.add(ita);
        pays.add(all);
        pays.add(esp);
        pays.add(ang);
        
        chp = new Championnat("test", 1, 1, fra.getEquipe());
    }
    


  
    /**
     * Test of ajoutResultat method, of class Championnat.
     */
    @Test
    public void testAjoutResultat() {
        int scoreLocal = 1;
        int scoreExterieur = 2;
        Match match = new Match(all.getEquipe().get(0),all.getEquipe().get(1));
        Date dateMatch= new Date ( 2014,12,12);
        
        
        match.setScore(scoreLocal, scoreExterieur);
        match.setDateMatch(dateMatch);
        
       if( !chp.ajoutResultat(scoreLocal, scoreExterieur, match, dateMatch))
       fail("Le résultat n'a pas été ajouté. ");
    }
    
    
    /**
     * Test of ajoutResultat method, of class Championnat.
     */
    @Test
    public void initialisationPays() {
        System.out.println("initialisation pays");
       if(fra == null || ita == null || all == null || esp == null || ang == null)
        fail("Erreur : Un des pays ne s'est pas chargé correctement.");
    }
    
     /**
     * Test of ajoutResultat method, of class Championnat.
     */
    @Test
    public void echangerTest() {
        Position[] classement = new Position [3] ;
        classement[0] = new Position(all.getEquipe().get(0));
        classement[1] = new Position(all.getEquipe().get(1));
        classement[2] = new Position(all.getEquipe().get(2));
        
        Position FirstPositionExpected = new Position(all.getEquipe().get(2));
        Position LastPositionExpected = new Position(all.getEquipe().get(0));
        
        chp.echanger(0, 2);
        
        if(classement[0] == FirstPositionExpected && classement[2] == LastPositionExpected)
        fail("Erreur : Un des pays ne s'est pas chargé correctement.");
    }


 

}
