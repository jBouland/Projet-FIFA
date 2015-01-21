/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import fifa.packVue.VueCoupeGlobale;
import fifa.packVue.VueGlobaleAdmin;
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
    private VueGlobaleAdmin fenetre;
    private VueCoupeGlobale fenetre2;

    public Instance() {
        europe = new ArrayList<Pays>();
        this.importPays();
        creerVueChampionsLeague();
        creerVueChampionnat();
        fenetre2.passagefenetre(fenetre);
    }

    public void affichePays() {
        for (Pays p : europe) {
            System.out.println(p.getNom() + " (" + p.getIdPays() + ")");
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
                Pays p = new Pays(rs.getInt("idPays"), rs.getString("nomPays"));
                p.importEquipe();
                europe.add(p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void creerVueChampionnat() {
        ArrayList<Championnat> liste = new ArrayList<>();

        for(Pays p : europe) {
            if (!p.getEquipe().isEmpty()) {
                Championnat chp = new Championnat(p.getNom(), 2014, 1, p.getEquipe());
                liste.add(chp);
            }
        }

        fenetre = new VueGlobaleAdmin(liste,fenetre2);
        fenetre.setVisible(true);
    }
    
    private void creerVueChampionsLeague() {
        ArrayList<Equipe> liste = new ArrayList<>();
        for(Pays p : europe) {
            if (!p.getEquipe().isEmpty()) {
                for (int j = 0; j < 6; j++) {
                    liste.add(p.getEquipe().get(j));
                }
            }
        }
        liste.add(europe.get(0).getEquipe().get(7));
        liste.add(europe.get(0).getEquipe().get(8));
        
        ChampionsLeague cl = new ChampionsLeague(1, "C1", 2014, liste);
        cl.creerPhasePoule();
        cl.genererDatesMatchesPoules();
        ArrayList<ChampionsLeague> c = new ArrayList<>();
        c.add(cl);
        fenetre2 = new VueCoupeGlobale(c);
        fenetre2.setVisible(false);
    }
    
    

}
