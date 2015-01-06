/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import fifa.packVue.VueGlobaleAdmin;
import java.util.ArrayList;

/**
 *
 * @author Flo
 */
public class Fifa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 1, 1, test.getEquipe());
        ch.affiche();
        VueGlobaleAdmin fenetre = new VueGlobaleAdmin();
        fenetre.setVisible(true);
        
        /// Test pour affichage sans vue
        Pays fra = new Pays(4, "France");   
        fra.importEquipe();
        fra.afficheEquipe();
        Pays ang = new Pays(8, "Angleterre"); 
        ang.importEquipe();
        ang.afficheEquipe();
        Pays esp = new Pays(6, "Espagne"); 
        esp.importEquipe();
        esp.afficheEquipe();
        Pays all = new Pays(1, "Allemange"); 
        all.importEquipe();
        all.afficheEquipe();
        Pays ita = new Pays(7, "Italie"); 
        ita.importEquipe();
        ita.afficheEquipe();
        ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(fra);
        pays.add(ita);
        pays.add(all);
        pays.add(esp);
        pays.add(ang);
        
        Championnat chp = new Championnat("test", 1, 1, fra.getEquipe());
        chp.affiche();
       
        ArrayList<Equipe> liste = new ArrayList<>();
        for(int i=0 ; i<5 ;i++){
            for(int j=0 ; j<6 ; j++){
                liste.add(pays.get(i).getEquipe().get(j));
            }
        }
        liste.add(pays.get(0).getEquipe().get(7));
        liste.add(pays.get(0).getEquipe().get(8));
        /*for (int i = 0; i < 32; i++) {
            liste.add(new Equipe(i, "Equipe" + i, 1, 1, 0, 0, 0, 0, 0));
        }*/
        
        ChampionsLeague cl = new ChampionsLeague(1, "C1", 2014, liste);
        cl.creerPoule();

        ArrayList<ChampionsLeague.Poule> ret = cl.getGroupes();
        for (int i = 0; i < ret.size(); i++) {
            System.out.println("Groupe "+i);
            for (int j = 0; j < 4; j++) {
                System.out.println(ret.get(i).getEquipes().get(j).getNomEquipe());
            }
            System.out.println("------");
        }
        cl.afficherCalendrierPour6();
        cl.resultatAleatoire();
        cl.afficherClassement();
        cl.creerTour(8);
        cl.affichageTour(0);
        
       
        /*test.importEquipe();
         test.afficheEquipe();*/
        
    }
    
}
