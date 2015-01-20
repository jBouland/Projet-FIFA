/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import fifa.Journee;
import fifa.Pays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 */
public class MonModelTableTest {

    public MonModelTableTest() {
    }

    /**
     * Test of testValeur method, of class MonModelTable.
     */
    @Test
    public void testInt() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        
        String intTest = "5";
        MonModelTable instance = new MonModelTable(j, ch);

        if (!instance.testValeur(intTest)) {
            fail("Le paramètre est un entier positif.");
        }
    }

    @Test
    public void testDouble() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String doubleTest = "5.3";
        if (!instance.testValeur(doubleTest)) {
            fail("Le paramètre est un double.");
        }

    }

    @Test
    public void testString() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String stringTest = "Bonjour je suis un test";
        if (!instance.testValeur(stringTest)) {
            fail("Le paramètre est une chaîne de caractère");
        }
    }

    @Test
    public void testNegatif() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String negatifTest = "-5";
        if (!instance.testValeur(negatifTest)) {
            fail("Le paramètre est un entier négatif.");
        }
    }

    @Test
    public void testLettres() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String lettresTest = "DEASGHJT";
        if (!instance.testValeur(lettresTest)) {
            fail("Le paramètre est uniquement composé de lettres.");
        }
    }

    @Test
    public void testLettresEtChiffres() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String lettresEtChiffres = "12GHt123";
        if (!instance.testValeur(lettresEtChiffres)) {
            fail("Le paramètre est composé de lettres et de chiffres.");
        }
    }

    @Test
    public void testchampVide() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String champVide = "";

        if (!instance.testValeur(champVide)) {
            fail("Le paramètre est un champ vide.");
        }
    }

    @Test
    public void testValSup1000() {
        Pays test = new Pays(1, "Allemagne");
        test.importEquipe();
        Championnat ch = new Championnat("All", 2015, 1, test.getEquipe());

        Journee j = new Journee(1);
        MonModelTable instance = new MonModelTable(j, ch);
        String chiffreSup1000 = "2500";
        if (!instance.testValeur(chiffreSup1000)) {
            fail("Le paramètre est un entier supérieur à 1000.");
        }
    }

}
