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
    private int num_poule;
    private int num_journee;

    private Equipe equipeLocale;
    private Equipe equipeExterieure;
    private ArrayList<Arbitre> arbitre;

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public void setScore(int scoreL, int scoreEx) {
        scoreLocal = scoreL;
        scoreExterieur = scoreEx;
    }

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

    public Match(int num_poule, Equipe equipeLocale, Equipe equipeExterieure) {
        this.equipeLocale = equipeLocale;
        this.equipeExterieure = equipeExterieure;
        this.num_poule=num_poule;
    }

    public int getNum_poule() {
        return num_poule;
    }
    

    public Match mirror() {
        return new Match(equipeExterieure, equipeLocale);
    }

    @Override
    public String toString() {
        return equipeLocale.getNomEquipe() + " vs " + equipeExterieure.getNomEquipe();
    }

}
