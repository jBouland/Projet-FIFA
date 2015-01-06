/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Cette classe représente un pays.
 * Il est caracterisé par un idPays, un nom, un indiceFIFA, une liste de championnat nationaux et une liste d'équipe.
 * @author groupe Bouland
 */
public class Pays {

    private int idPays;
    private String nom;
    private int indiceFIFA;
    private ArrayList<Nationale> championnats;
    private ArrayList<Equipe> equipe;

    public Pays(int idPays, String nom) {
        this.idPays = idPays;
        this.nom = nom;

        equipe = new ArrayList();
    }

    /**
     * Effectue l'import des équipes en local depuis la base de données
     * 
     * @throw Retourne une erreur si la connexion à la base de données n'a pas pu s'effectuée.
     * @return true si l'import s'est effectué sans problème.
     */
    public boolean importEquipe() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/fifa", "root", "");
            System.err.println("Connexion établie");
            Statement lien = cnx.createStatement();

            ResultSet rs = lien.executeQuery("SELECT * FROM equipe WHERE idPays LIKE ".concat(Integer.toString(idPays)));
            while (rs.next()) {
                equipe.add(new Equipe(rs.getInt("idPays"), rs.getInt("idEquipe"), rs.getString("nomEquipe")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public void setIndiceFIFA(int indiceFIFA) {
        this.indiceFIFA = indiceFIFA;
    }

    public int getIdPays() {
        return idPays;
    }

    public String getNom() {
        return nom;
    }

    public int getIndiceFIFA() {
        return indiceFIFA;
    }
    
        public void afficheEquipe(){
        for(Equipe p : equipe){
            System.out.println(p.getNomEquipe()+" ("+p.getIdEquipe()+")");
        }
    }

    public ArrayList<Equipe> getEquipe() {
        return equipe;
    }

}
