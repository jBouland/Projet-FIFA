/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

    public Match(Equipe equipeLocale, Equipe equipeExterieure) {
        this.equipeLocale = equipeLocale;
        this.equipeExterieure = equipeExterieure;
    }

    public Match(int num_poule, Equipe equipeLocale, Equipe equipeExterieure) {
        this.equipeLocale = equipeLocale;
        this.equipeExterieure = equipeExterieure;
        this.num_poule = num_poule;
    }

    public ArrayList<Equipe> getEquipesMatch() {
        ArrayList<Equipe> retour = new ArrayList<>();
        retour.add(equipeLocale);
        retour.add(equipeExterieure);
        return retour;
    }

    public Match mirror() {
        return new Match(equipeExterieure, equipeLocale);
    }

    @Override
    public String toString() {
        return "(Poule " + num_poule + ") " + equipeLocale.getNomEquipe() + " " + scoreLocal + " - " + scoreExterieur + " " + equipeExterieure.getNomEquipe();
    }

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

    public int getNum_poule() {
        return num_poule;
    }

    public int getScoreLocal() {
        return scoreLocal;
    }

    public void setScoreLocal(int scoreLocal) {
        this.scoreLocal = scoreLocal;
    }

    public int getScoreExterieur() {
        return scoreExterieur;
    }

    public void setScoreExterieur(int scoreExterieur) {
        this.scoreExterieur = scoreExterieur;
    }

    public int getNum_journee() {
        return num_journee;
    }

    public void setNum_journee(int num_journee) {
        this.num_journee = num_journee;
    }

    public ArrayList<Arbitre> getArbitre() {
        return arbitre;
    }

    public void setArbitre(ArrayList<Arbitre> arbitre) {
        this.arbitre = arbitre;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setNum_poule(int num_poule) {
        this.num_poule = num_poule;
    }

    public void setEquipeLocale(Equipe equipeLocale) {
        this.equipeLocale = equipeLocale;
    }

    public void setEquipeExterieure(Equipe equipeExterieure) {
        this.equipeExterieure = equipeExterieure;
    }

    public void simulerMatch() {

        Random rd = new Random();

        this.scoreLocal = rd.nextInt(5);
        this.scoreExterieur = rd.nextInt(5);

    }

    public Equipe getEquipeVictorieuse() {

        if (scoreLocal > scoreExterieur) {

            return equipeLocale;
        }

        if (scoreExterieur > scoreLocal) {

            return equipeExterieure;
        }

        if (scoreExterieur == scoreLocal) {

            scoreExterieur++;
            return equipeExterieure;

        }

        return null;
    }

}
