/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

public class Equipe {

    private int idEquipe;
    private String nomEquipe;

    public Equipe(int idEquipe, String nomEquipe) {
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
    
    

}
