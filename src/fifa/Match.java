/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Date;

public class Match {
   private Date dateMatch;
   private int scoreLocal;
   private int scoreExterieur;
   private int idMatch;
   
   private Equipe equipeLocale;
   private Equipe equipeExterieure;
   private ArrayList<Arbitre> arbitre;

    public Equipe getEquipeLocale() {
        return equipeLocale;
    }

    public Equipe getEquipeExterieure() {
        return equipeExterieure;
    }

    public Match(Equipe equipeLocale, Equipe equipeExterieure) {
        this.equipeLocale = equipeLocale;
        this.equipeExterieure = equipeExterieure;
    }
    
    public Match mirror(){
        return new Match(equipeExterieure, equipeLocale);
    }
    
   @Override
    public String toString(){
			return equipeLocale.getNomEquipe()+" vs "+equipeExterieure.getNomEquipe();
		}
    
    
   
  

}