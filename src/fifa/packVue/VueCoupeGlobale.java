/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public final class VueCoupeGlobale extends JFrame implements ActionListener {

    private ArrayList<ChampionsLeague> listeCoupe;
    private String[] tour = new String[]{
        "Poule J1", "Poule J2", "Poule J3", "Poule J4", "Poule J5", "Poule J6", "1/8", "1/4", "1/2", "Finale"
    };

    private VueJourneeCoupe vJourneCoupe;
    private JLabel selectCoupe = new JLabel("Veuillez sélectionner une coupe");

    private JLabel selectTour = new JLabel("Veuillez sélectionner une tour");
    private JLabel Titre = new JLabel("Bienvenue Admin");

    private JComboBox listeCoupeJComboBox;
    private JComboBox listeTourJComboBox;

    private int tourSelect = 0;
    private ChampionsLeague CoupeActu;
    private VueClassementCoupeFinale fenetreClassement;
    private JButton classement;
    private VueGlobaleAdmin fenetre;
    private JButton passageChamp;

    public VueCoupeGlobale(ArrayList<ChampionsLeague> liste) { // il faut que tu rajoutes ou prendre les coupe
        this.setTitle("Champions League");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();
        listeCoupe = liste;
        creationComboCoupe();
        creationComboTour();
        listeTourJComboBox.addActionListener(this);
        classement = new JButton("Classement");
        classement.addActionListener(this);
        //jbtEquipeparJournee.addActionListener(this);
        //jbtGenererResultats.addActionListener(this);

        this.init(liste);

        passageChamp.addActionListener(this);

    }

    public void init(ArrayList<ChampionsLeague> liste) {

        listeCoupe = liste;

        passageChamp = new JButton("Championnats");

        vJourneCoupe = new VueJourneeCoupe(CoupeActu, tourSelect);
        JPanel mainPanel = new JPanel();

        // ajout du gestionnaire de placement 
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        mainPanel.add(Titre, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        mainPanel.add(selectCoupe, cont);

        cont.gridx = 1;
        cont.gridy = 0;
        mainPanel.add(passageChamp, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        mainPanel.add(listeCoupeJComboBox, cont);

        cont.gridx = 2;
        cont.gridy = 1;
        mainPanel.add(selectTour, cont);

        cont.gridx = 3;
        cont.gridy = 1;
        mainPanel.add(listeTourJComboBox, cont);

        cont.gridx = 4;
        cont.gridy = 1;
        mainPanel.add(classement, cont);

        /* cont.gridx = 4;
         cont.gridy = 1;
         mainPanel.add(jbtGenererResultats, cont);*/
// Ajout du petit panneau dans le gros panneau de la JFrame
        /*cont.gridx = 5;
         cont.gridy = 1;
         mainPanel.add(jbtEquipeparJournee, cont);*/
        cont.gridheight = 3;
        cont.gridx = 5;
        cont.gridy = 2;
        mainPanel.add(vJourneCoupe, cont);

        cont.gridx = 0;
        cont.gridy = 0;

        //  vJourneCoupe.chargementClassement(CoupeActu);
        this.add(mainPanel, cont);
        this.pack();

    }

    public void afficheFond() {
        GridBagConstraints cont = new GridBagConstraints();
        cont.gridwidth = 6;
        cont.gridx = 0;
        cont.gridy = 0;

        this.setContentPane(new JPanel() {

            public void paintComponent(Graphics g) {
                g.drawImage((new ImageIcon("src/Ressources/cl.jpeg")).getImage(), 0, 0, 1280,720 , null);
            }

        });

        this.pack();
    }

    private void creationComboCoupe() {
        listeCoupeJComboBox = new JComboBox();
        for (int i = 0; i < listeCoupe.size(); i++) {
            listeCoupeJComboBox.addItem(listeCoupe.get(i).getNomCompetition());

        }
        CoupeActu = listeCoupe.get(0);

    }

    private void creationComboTour() {
        listeTourJComboBox = new JComboBox(tour);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /* if (ae.getSource() == jbtGenererResultats) {
         CoupeActu.simulerPhasePoule();
         CoupeActu.simulerPhaseFinale();

         }
         if (ae.getSource() == jbtEquipeparJournee) {

         }*/
        if (ae.getSource() == listeCoupeJComboBox) {
            CoupeActu = listeCoupe.get(listeCoupeJComboBox.getSelectedIndex());

        }

        if (ae.getSource() == listeTourJComboBox) {
            try{
            tourSelect = listeTourJComboBox.getSelectedIndex();
            vJourneCoupe.setJourn(tourSelect);
            vJourneCoupe.init();
            this.pack();
            }catch(Exception e){
                
            }
        }

        if (ae.getSource() == classement) {
            VueClassementCoupeFinale vccf = new VueClassementCoupeFinale(listeCoupe);
            vccf.setVisible(true);
        }
        if (ae.getSource() == passageChamp) {
            this.setVisible(false);
            fenetre.setVisible(true);
        }

    }

    public void passagefenetre(VueGlobaleAdmin fenetre) {
        this.fenetre = fenetre;
    }


}
