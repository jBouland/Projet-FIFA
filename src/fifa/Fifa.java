/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import fifa.packVue.VueGlobaleAdmin;

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
        
    }
    
}
