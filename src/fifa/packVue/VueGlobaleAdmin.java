/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import fifa.Pays;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Flo
 */
public class VueGlobaleAdmin extends JFrame implements ActionListener {

    private ArrayList<Championnat> listeChampionnat;

    private int[] journee;

    private VueClassement vc;
    private VueMatchAdmin vm;

    private JLabel selectChampionnat = new JLabel("Veuillez sélectionner un championnat");
    private JLabel selectJournee = new JLabel("Veuillez sélectionner une journée");
    private JLabel Titre = new JLabel("Bienvenue Admin");

    private JComboBox listeChampionnatJComboBox;
    private JComboBox listeJournéeJComboBox;

    private int journeSelect = 1;
    private Championnat championnatActu;

    public VueGlobaleAdmin() {
        listeChampionnat = new ArrayList<Championnat>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();
        CreationChampionnatTemp();
        creationComboChampionnat();
        creationComboJournee();

        init();

    }

    public void init() {

        vc = new VueClassement(null);
        //  vm=new VueMatchAdmin( listeChampionnat.get(listeChampionnatJComboBox.getSelectedIndex()),listeJournéeJComboBox.getSelectedItem() );
        JPanel pano = new JPanel();
        JPanel pano2 = new JPanel();

        // ajout du gestionnaire de placement 
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        pano.add(Titre, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        pano.add(selectChampionnat, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        pano.add(listeChampionnatJComboBox, cont);

        cont.gridx = 2;
        cont.gridy = 1;
        pano.add(selectJournee, cont);

        cont.gridx = 3;
        cont.gridy = 1;
        pano.add(listeJournéeJComboBox, cont);

        cont.gridwidth = 5;
        cont.gridx = 0;
        cont.gridy = 2;
        pano.add(vc, cont);

        cont.gridx = 2;
        cont.gridy = 2;
//          pano.add(vm);
        this.add(pano, cont);
        this.pack();

    }

    public void afficheFond() {
        GridBagConstraints cont = new GridBagConstraints();
        cont.gridwidth = 6;
        cont.gridx = 0;
        cont.gridy = 0;

        this.setContentPane(new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                g.drawImage((new ImageIcon("src/Ressources/fifa.jpeg")).getImage(), 0, 0, null);
            }

        });

        this.pack();
    }

    public void creationComboChampionnat() {
        listeChampionnatJComboBox = new JComboBox();

        for (int i = 0; i < listeChampionnat.size(); i++) {
            listeChampionnatJComboBox.addItem(listeChampionnat.get(i).getNomCompetition());

        }

        listeChampionnatJComboBox.addItem("Championnat");

        listeChampionnatJComboBox.addItem("Ligue 1");

    }

    public void creationComboJournee() {
        listeJournéeJComboBox = new JComboBox();
        for (int i = 1; i < 40; i++) {
            listeJournéeJComboBox.addItem(i);
        }
    }

    public void CreationChampionnatTemp() {

        Pays test = new Pays(1, "test");
        test.importEquipe();
        test.afficheEquipe();
        Championnat chp = new Championnat("test", 1, 1, test.getEquipe());
        // chp.affiche();
        listeChampionnat.add(chp);

    }

    public void affichageJlist() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
