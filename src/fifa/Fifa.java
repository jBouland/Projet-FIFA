/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

/**
 *
 * @author Flo
 */
public class Fifa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pays test = new Pays(1, "test");
        test.importEquipe();
        test.afficheEquipe();
        Championnat chp = new Championnat("test", 1, 1, test.getEquipe());
        chp.affiche();
    }
    
}
