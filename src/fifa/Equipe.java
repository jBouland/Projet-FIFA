/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

public class Equipe {

    private int idEquipe;
    private String nomEquipe;
    private int idPays;
    private int classementAnneePrecedente;
    private int vainqueurCoupe;
    private int idChampionnat;
    private int idCoupe1;
    private int idCoupe2;
    private int idCoupeEurope;

    public Equipe(int idEquipe, String nomEquipe) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
    }

    public Equipe(int idPays, int idEquipe, String nomEquipe) {
        this.idPays = idPays;
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
    }

    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getClassementAnneePrecedente() {
        return classementAnneePrecedente;
    }

    public void setClassementAnneePrecedente(int classementAnneePrecedente) {
        this.classementAnneePrecedente = classementAnneePrecedente;
    }

    public int getVainqueurCoupe() {
        return vainqueurCoupe;
    }

    public void setVainqueurCoupe(int vainqueurCoupe) {
        this.vainqueurCoupe = vainqueurCoupe;
    }

    public int getIdChampionnat() {
        return idChampionnat;
    }

    public void setIdChampionnat(int idChampionnat) {
        this.idChampionnat = idChampionnat;
    }

    public int getIdCoupe1() {
        return idCoupe1;
    }

    public void setIdCoupe1(int idCoupe1) {
        this.idCoupe1 = idCoupe1;
    }

    public int getIdCoupe2() {
        return idCoupe2;
    }

    public void setIdCoupe2(int idCoupe2) {
        this.idCoupe2 = idCoupe2;
    }

    public int getIdCoupeEurope() {
        return idCoupeEurope;
    }

    public void setIdCoupeEurope(int idCoupeEurope) {
        this.idCoupeEurope = idCoupeEurope;
    }
}
