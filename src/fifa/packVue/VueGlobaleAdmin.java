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
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private AffichageJournee aj;

    private JLabel selectChampionnat = new JLabel("Veuillez sélectionner un championnat");
    private JLabel selectJournee = new JLabel("Veuillez sélectionner une journée");
    private JLabel Titre = new JLabel("Bienvenue Admin");

    private JComboBox listeChampionnatJComboBox;
    private JComboBox listeJournéeJComboBox;

    private int journeSelect = 0;
    private Championnat championnatActu;

    private JButton passageCL;
    private VueCoupeGlobale fenetre;

    public VueGlobaleAdmin(ArrayList<Championnat> liste, VueCoupeGlobale fenetre) {
        this.listeChampionnat = liste;
        this.fenetre = fenetre;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();
        championnatActu = listeChampionnat.get(0);
        creationComboChampionnat();
        creationComboJournee();

        listeChampionnatJComboBox.addActionListener(this);
        listeJournéeJComboBox.addActionListener(this);

        init();

        passageCL.addActionListener(this);

    }

    public void init() {

        passageCL = new JButton("Champions League");
        vc = new VueClassement(null);
        aj = new AffichageJournee(championnatActu, journeSelect);
        JPanel mainPanel = new JPanel();

        // ajout du gestionnaire de placement 
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        mainPanel.add(Titre, cont);

        cont.gridx = 1;
        cont.gridy = 0;
        mainPanel.add(passageCL, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        mainPanel.add(selectChampionnat, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        mainPanel.add(listeChampionnatJComboBox, cont);

        cont.gridx = 2;
        cont.gridy = 1;
        mainPanel.add(selectJournee, cont);

        cont.gridx = 3;
        cont.gridy = 1;
        mainPanel.add(listeJournéeJComboBox, cont);

// Ajout du petit panneau dans le gros panneau de la JFrame
        cont.gridwidth = 5;
        cont.gridx = 0;
        cont.gridy = 2;
        mainPanel.add(vc, cont);

        cont.gridheight = 6;
        cont.gridx = 4;
        cont.gridy = 0;
        mainPanel.add(aj, cont);

        cont.gridx = 0;
        cont.gridy = 0;

        vc.chargementClassement(championnatActu);

        championnatActu.addObserver(vc);
        championnatActu.addObserver(aj);
        this.add(mainPanel, cont);
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
    }

    public void creationComboJournee() {
        listeJournéeJComboBox = new JComboBox();
        for (int i = 1; i < (championnatActu.getEquipe().size() - 1) * 2 + 1; i++) {
            listeJournéeJComboBox.addItem(i);
        }
    }


    /*public void CreationChampionnatTemp() {

     Pays test = new Pays(1, "test");
     test.importEquipe();
     test.afficheEquipe();
     Championnat chp = new Championnat("test", 1, 1, test.getEquipe());
     // chp.affiche();
     listeChampionnat.add(chp);

     }*/
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == listeChampionnatJComboBox) {
            for (Championnat champ : listeChampionnat) {
                if (champ.getNomCompetition() == null ? listeChampionnatJComboBox.getSelectedItem().toString() == null : champ.getNomCompetition().equals(listeChampionnatJComboBox.getSelectedItem().toString())) {
                    vc.chargementClassement(champ);
                    aj.setChamp(champ);
                    aj.init();
                    championnatActu = champ;
                    int temp = listeJournéeJComboBox.getItemCount();
                    for (int i = 0; i < temp - 1; i++) {
                        listeJournéeJComboBox.removeItemAt(0);
                    }
                    for (int i = 1; i < (championnatActu.getEquipe().size() - 1) * 2 + 1; i++) {
                        listeJournéeJComboBox.addItem(i);
                    }
                    listeJournéeJComboBox.removeItemAt(0);
                    listeJournéeJComboBox.setSelectedIndex(0);
                    championnatActu.addObserver(vc);
                    championnatActu.addObserver(aj);
                    this.repaint();
                    this.pack();
                }
            }
        } else if (ae.getSource() == listeJournéeJComboBox) {
            aj.setJourn(listeJournéeJComboBox.getSelectedIndex());
            aj.init();
        } else if (ae.getSource() == passageCL) {
            this.setVisible(false);
            fenetre.setVisible(true);
        }
    }

}
