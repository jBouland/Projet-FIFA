/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
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
public class VueCoupeGlobale extends JFrame implements ActionListener {

    private ArrayList<ChampionsLeague> listeCoupe;
    private String[] tour = new String[]{
        "Poule", "1/8", "1/4", "1/2", "Finale"
    };

    private VueJourneeCoupe vJourneCoupe;
    private JLabel selectCoupe = new JLabel("Veuillez sélectionner une coupe");

    private JLabel selectTour = new JLabel("Veuillez sélectionner une tour");
    private JLabel Titre = new JLabel("Bienvenue Admin");

    private JComboBox listeCoupeJComboBox;
    private JComboBox listeTourJComboBox;

    private int tourSelect = 0;
    private ChampionsLeague CoupeActu;

    private JButton jbtGenererResultats = new JButton("Générer les résultats de la coupe");
    private JButton jbtEquipeparJournee = new JButton("Equipe/Journée");
    
   
    public VueCoupeGlobale() { // il faut que tu rajoutes ou prendre les coupe

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));

        afficheFond();

        creationComboCoupe();
        creationComboTour();

        jbtEquipeparJournee.addActionListener(this);
        jbtGenererResultats.addActionListener(this);

        init();

    }

    public void init() {

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
        mainPanel.add(jbtGenererResultats, cont);
// Ajout du petit panneau dans le gros panneau de la JFrame

        cont.gridx = 5;
        cont.gridy = 1;
        mainPanel.add(jbtEquipeparJournee, cont);

        cont.gridwidth = 5;
        cont.gridx = 0;
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
                g.drawImage((new ImageIcon("src/Ressources/fifa.jpeg")).getImage(), 0, 0, null);
            }

        });

        this.pack();
    }

    private void creationComboCoupe() {
        listeCoupeJComboBox=new JComboBox();
         for (int i = 0; i < listeCoupe.size(); i++) {
           listeCoupeJComboBox.addItem(listeCoupe.get(i).getNomCompetition());

        }
       CoupeActu=listeCoupe.get(0);
        
    }

    private void creationComboTour() {
        listeTourJComboBox = new JComboBox(tour);
   }

   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==jbtGenererResultats){
            CoupeActu.simulerPhasePoule();
            CoupeActu.simulerPhaseFinale();
            
        }
        if (ae.getSource()==jbtEquipeparJournee){
            
            
        }
        if (ae.getSource()==listeCoupeJComboBox){
            CoupeActu=listeCoupe.get(listeCoupeJComboBox.getSelectedIndex());
            
        }
        
        if (ae.getSource()==listeTourJComboBox){
            tourSelect=listeTourJComboBox.getSelectedIndex();
            
            
        }
    
    }

}
