/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

public class Position {

    private int positionEquipe;
    private Equipe equipe;
    private int nombreVictoire;
    private int nombreNul;
    private int nombreDefaite;
    private int butsMarques;
    private int butsEncaisses;
    private int score;

    public int getScore() {
        return score;
    }

    public Position(Equipe equipe) {
        this.equipe = equipe;
        this.positionEquipe = 0;
        this.nombreVictoire = 0;
        this.nombreDefaite = 0;
        this.nombreNul = 0;
        this.butsMarques = 0;
        this.butsEncaisses = 0;
    }
    
    public Position(Equipe equipe, int posi_depart) {
        this.equipe = equipe;
        this.positionEquipe = posi_depart;
        this.nombreVictoire = 0;
        this.nombreDefaite = 0;
        this.nombreNul = 0;
        this.butsMarques = 0;
        this.butsEncaisses = 0;
        this.score=0;
    }

    public int getPositionEquipe() {
        return positionEquipe;
    }

    public void setPositionEquipe(int positionEquipe) {
        this.positionEquipe = positionEquipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setNom(Equipe equipe) {
        this.equipe = equipe;
    }

    public int getNombreVictoire() {
        return nombreVictoire;
    }

    public void setNombreVictoire(int nombreVictoire) {
        this.nombreVictoire = nombreVictoire;
    }

    public int getNombreNul() {
        return nombreNul;
    }

    public void setNombreNul(int nombreNul) {
        this.nombreNul = nombreNul;
    }

    public int getNombreDefaite() {
        return nombreDefaite;
    }

    public void setNombreDefaite(int nombreDefaite) {
        this.nombreDefaite = nombreDefaite;
    }

    public int getButsMarques() {
        return butsMarques;
    }

    public void setButsMarques(int butsMarques) {
        this.butsMarques = butsMarques;
    }

    public int getButsEncaisses() {
        return butsEncaisses;
    }

    public void setButsEncaisses(int butEncaisses) {
        this.butsEncaisses = butEncaisses;
    }

    public void setResultatsChampionnat(int butsMarques, int butsEncaisses) {

        this.butsMarques += butsMarques;
        this.butsEncaisses += butsEncaisses;

        if (butsMarques > butsEncaisses) {
            this.nombreVictoire++;
            score += 3;

        } else if (butsMarques < butsEncaisses) {
            this.nombreDefaite++;

        } else {
            this.nombreNul++;
            score++;
        }
    }
}
