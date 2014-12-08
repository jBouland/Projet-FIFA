/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

public class Position {
    private int positionEquipe;
    private Equipe nom;
    private int nombreVictoire;
    private int nombreNul;
    private int nombreDefaite;
    private int butsMarques;
    private int butEncaisses;

    public Position(Equipe nom) {
        this.nom = nom;
        this.positionEquipe=0;
        this.nombreVictoire=0;
        this.nombreDefaite=0;
        this.nombreNul=0;
        this.butsMarques=0;
        this.butsMarques=0;
    }

    public int getPositionEquipe() {
        return positionEquipe;
    }

    public void setPositionEquipe(int positionEquipe) {
        this.positionEquipe = positionEquipe;
    }

    public Equipe getNom() {
        return nom;
    }

    public void setNom(Equipe nom) {
        this.nom = nom;
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

    public int getButEncaisses() {
        return butEncaisses;
    }

    public void setButEncaisses(int butEncaisses) {
        this.butEncaisses = butEncaisses;
    }
}
