/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Competition extends Observable {

    String nomCompetition;
    int saison;
    int idCompetition;

    public ArrayList<Equipe> equipe;
    public ArrayList<Match> match;

    public Competition() {

    }

    public Competition(String nomCompetition, int saison, int idCompetition, ArrayList<Equipe> equipe) {
        this.nomCompetition = nomCompetition;
        this.saison = saison;
        this.idCompetition = idCompetition;
        this.equipe = equipe;
    }
    
    

    public String getNomCompetition() {
        return nomCompetition;
    }

    public int getSaison() {
        return saison;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public ArrayList<Equipe> getEquipe() {
        return equipe;
    }

    public ArrayList<Match> getMatch() {
        return match;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public void setSaison(int saison) {
        this.saison = saison;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public void setEquipe(ArrayList<Equipe> equipe) {
        this.equipe = equipe;
    }

    public void setMatch(ArrayList<Match> match) {
        this.match = match;
    }
    
    

}
