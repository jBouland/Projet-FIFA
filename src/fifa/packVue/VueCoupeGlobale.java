/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

    private int tourSelect = 0;
    private ChampionsLeague CoupeActu;
    private VueClassementCoupeFinale fenetreClassement;
    private VueGlobaleAdmin fenetre;

    private JMenuBar menu;
    private JMenu championnatm, journeem, classementm;
    private JMenuItem acceschampionnat, accesclassement;
    private ArrayList<JMenuItem> itemsJournee;
    private Font f = new Font("Arial", Font.BOLD, 14);

    public VueCoupeGlobale(ArrayList<ChampionsLeague> liste) { // il faut que tu rajoutes ou prendre les coupe
        this.setTitle("Champions League");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();
        listeCoupe = liste;
        creationMenuChampionnat();
        CoupeActu = listeCoupe.get(0);

        this.init(liste);

    }

    public void init(ArrayList<ChampionsLeague> liste) {

        listeCoupe = liste;

        vJourneCoupe = new VueJourneeCoupe(CoupeActu, tourSelect);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255, 65));

        // ajout du gestionnaire de placement 
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.RELATIVE;
        cont.ipadx = 5;

        cont.gridheight = 3;
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth = 100;
        mainPanel.add(vJourneCoupe, cont);
        cont.gridwidth = 1;
        cont.gridx = 0;
        cont.gridy = 1;

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
                g.drawImage((new ImageIcon("src/Ressources/cl.jpeg")).getImage(), 0, 0, 1280, 720, null);
            }

        });

        this.pack();
    }

    public void creationMenuChampionnat() {
        /*items = new JComboBox();

         for (int i = 0; i < listeChampionnat.size(); i++) {
         listeChampionnatJComboBox.addItem(listeChampionnat.get(i).getNomCompetition());

         }*/
        menu = new JMenuBar();

        championnatm = new JMenu("Championnats");
        acceschampionnat = new JMenuItem("Ligues Nationales");
        championnatm.add(acceschampionnat);
        championnatm.setFont(f);
        menu.add(championnatm);

        classementm = new JMenu("Classements");
        accesclassement = new JMenuItem("Phases de Groupe");
        classementm.add(accesclassement);
        classementm.setFont(f);
        menu.add(classementm);

        acceschampionnat.addActionListener(this);
        accesclassement.addActionListener(this);
        this.setJMenuBar(menu);
        creationMenuJourneeCoupe();
    }

    public void creationMenuJourneeCoupe() {
        itemsJournee = new ArrayList<>();
        journeem = new JMenu("Journées");
        for (int i = 0; i < tour.length; i++) {
            itemsJournee.add(new JMenuItem(tour[i]));
            journeem.add(itemsJournee.get(i));
            itemsJournee.get(i).addActionListener(this);
        }
        journeem.setFont(f);
        menu.add(journeem);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /*if (ae.getSource() == listeCoupeJComboBox) {
         CoupeActu = listeCoupe.get(listeCoupeJComboBox.getSelectedIndex());

         }

         if (ae.getSource() == listeTourJComboBox) {
         try {
         tourSelect = listeTourJComboBox.getSelectedIndex();
         vJourneCoupe.setJourn(tourSelect);
         vJourneCoupe.init();
         this.pack();
         } catch (Exception e) {

         }
         }*/

        if (ae.getSource() == accesclassement) {
            VueClassementCoupeFinale vccf = new VueClassementCoupeFinale(listeCoupe);
            vccf.setVisible(true);
        }
        if (ae.getSource() == acceschampionnat) {
            this.setVisible(false);
            fenetre.setVisible(true);
        }

        int k = 0;
        for (JMenuItem it2 : itemsJournee) {
            if (ae.getSource() == it2) {
                try {
                    tourSelect = k;
                    vJourneCoupe.setJourn(tourSelect);
                    vJourneCoupe.init();
                    this.pack();
                    break;
                } catch (Exception e) {

                }
            }
            k++;
        }

        /*for (JMenuItem it : items) {
         if (ae.getSource() == it) {
         for (Championnat champ : listeChampionnat) {
         if (champ.getNomCompetition() == it.getText()) {
         //if (champ.getNomCompetition() == null ? listeChampionnatJComboBox.getSelectedItem().toString() == null : champ.getNomCompetition().equals(listeChampionnatJComboBox.getSelectedItem().toString())) {
         vc.chargementClassement(champ);
         aj.setChamp(champ);
         aj.setJourn(0);
         aj.init();
         championnatActu = champ;
         this.creationMenuJourneeChampionnat();

         championnatActu.addObserver(vc);
         championnatActu.addObserver(aj);
         this.repaint();
         this.pack();
         }
         }
         }
         }*/
    }

    public void passagefenetre(VueGlobaleAdmin fenetre) {
        this.fenetre = fenetre;
    }

}
