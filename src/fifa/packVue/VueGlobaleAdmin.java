/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

    private int journeSelect = 0;
    private Championnat championnatActu;

    private VueCoupeGlobale fenetre;
    private Font f = new Font("Arial", Font.BOLD, 14);

    private JMenuBar menu;
    private JMenu coupe, journeem;
    private JMenu choixpays;
    private JMenuItem cl;
    private ArrayList<JMenuItem> items;
    private ArrayList<JMenuItem> itemsJournee;

    public VueGlobaleAdmin(ArrayList<Championnat> liste, VueCoupeGlobale fenetre) {
        this.listeChampionnat = liste;
        this.fenetre = fenetre;
        this.setTitle("Championnats");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();
        championnatActu = listeChampionnat.get(0);
        creationMenuChampionnat();
        init();

        cl.addActionListener(this);

    }

    public void init() {
        vc = new VueClassement(null);
        aj = new AffichageJournee(championnatActu, journeSelect);
        JPanel mainPanel = new JPanel();

        // ajout du gestionnaire de placement 
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(255, 255, 255, 65));

        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.CENTER;
        cont.ipadx = 5;

        // Ajout du petit panneau dans le gros panneau de la JFrame
        cont.gridx = 0;
        cont.gridy = 0;
        mainPanel.add(vc, cont);

        cont.gridx = 1;
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

    public void creationMenuChampionnat() {
        items = new ArrayList<>();
        menu = new JMenuBar();
        coupe = new JMenu("Coupes");
        cl = new JMenuItem("Champions League");
        coupe.add(cl);
        choixpays = new JMenu("Choix Pays");
        for (int i = 0; i < listeChampionnat.size(); i++) {
            items.add(new JMenuItem(listeChampionnat.get(i).getNomCompetition()));
            choixpays.add(items.get(i));
            items.get(i).addActionListener(this);
        }
        coupe.setFont(f);
        choixpays.setFont(f);
        menu.add(coupe);
        menu.add(choixpays);

        this.setJMenuBar(menu);
        creationMenuJourneeChampionnat();
    }

    public void creationMenuJourneeChampionnat() {
        if (journeem != null) {
            menu.remove(journeem);
        }
        itemsJournee = new ArrayList<>();
        journeem = new JMenu("Journée");
        for (int i = 1; i < (championnatActu.getEquipe().size() - 1) * 2 + 1; i++) {
            itemsJournee.add(new JMenuItem(Integer.toString(i)));
            journeem.add(itemsJournee.get(i - 1));
            itemsJournee.get(i - 1).addActionListener(this);
        }
        journeem.setFont(f);
        menu.add(journeem);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cl) {
            this.setVisible(false);
            fenetre.setVisible(true);
        }
        for (JMenuItem it : items) {
            if (ae.getSource() == it) {
                for (Championnat champ : listeChampionnat) {
                    if (champ.getNomCompetition() == it.getText()) {
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
        }
        for (JMenuItem it2 : itemsJournee) {
            if (ae.getSource() == it2) {
                aj.setJourn(Integer.parseInt(it2.getText()) - 1);
                aj.init();
            }
        }

    }

}
