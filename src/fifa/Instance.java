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
 *
 * @author Corentin
 */
public class Instance {

    private ArrayList<Pays> europe;

    public Instance() {
        europe = new ArrayList<Pays>();
        this.importPays();
    }

    public void affichePays(){
        for(Pays p : europe){
            System.out.println(p.getNom()+" ("+p.getIdPays()+")");
        }
    }
    
    public void importPays() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/fifa", "root", "");
            System.err.println("Connexion établie");
            Statement lien = cnx.createStatement();

            ResultSet rs = lien.executeQuery("SELECT * FROM pays;");

            while (rs.next()) {
                europe.add(new Pays(rs.getInt("idPays"),rs.getString("nomPays")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void creerCoupeEurope(int idCompetition, String nomCoupeEurope, int saison){
        
    }    
    
}
