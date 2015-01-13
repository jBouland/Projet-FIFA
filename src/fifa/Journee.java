/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Corentin
 */
public class Journee {

    int num_Journee;
    Date debut;
    Date fin;
    ArrayList<Match> match_journee;
    private boolean estModifiable;

    
    
    
    
    Journee(int j) {
        num_Journee = j;
        match_journee = new ArrayList<Match>();
        this.estModifiable=true;
    }

    public boolean getEstModifiable(){
        
        return estModifiable;
        
    }
    
    public void setEstModifiable(boolean estmodif){
        this.estModifiable=estmodif;
        
    }
    
    public void setNum_Journee(int num_Journee) {
        this.num_Journee = num_Journee;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setMatch_journee(ArrayList<Match> match_journee) {
        this.match_journee = match_journee;
    }

    public int getNum_Journee() {
        return num_Journee;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public ArrayList<Match> getMatch_journee() {
        return match_journee;
    }

    void afficheMatch() {
        for (int i = 0; i < match_journee.size(); i++) {
            System.out.println(match_journee.get(i).toString());
        }
    }

    void creerMatch(int num_poule, Equipe temp1, Equipe temp2) {
        match_journee.add(new Match(num_poule, temp1, temp2));
    }

    void creerMatch(Equipe temp1, Equipe temp2) {
        match_journee.add(new Match(temp1, temp2));
    }

    boolean equipeEstDansLaJournée(Equipe e) {
        for (int i = 0; i < match_journee.size(); i++) {
            if (e == match_journee.get(i).getEquipeExterieure() || e == match_journee.get(i).getEquipeLocale()) {
                return true;
            }
        }
        return false;
    }

    void ajouterMatch(Match get) {
        match_journee.add(get);
    }

    Match inverserMatch(Match m) {
        return m.mirror();
    }

    ArrayList<Match> getMatch_group(int numPoule) {
        ArrayList<Match> retour = new ArrayList<>();
        for (Match m : match_journee) {
            if (m.getNum_poule() == numPoule) {
                retour.add(m);
            }
        }
        return retour;
    }
    
    void affiche(){
        for (Match match_journee1 : match_journee) {
            System.out.println(match_journee1);
        }
    }

}
