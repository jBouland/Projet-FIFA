/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import fifa.ChampionsLeague.Poule;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Flo
 */
public class VueJourneeCoupe extends JPanel implements ActionListener, Observer {

    private JTable table;

    private ChampionsLeague champ;
    private int journ;
    private JButton JButton_GenererAleatoirementJournees;

    VueJourneeCoupe(ChampionsLeague CoupeActu, int journeSelect) {
        champ = CoupeActu;
        journ = journeSelect;
        JButton_GenererAleatoirementJournees = new JButton("Génerer Aléatoirement tous les scores");
        JButton_GenererAleatoirementJournees.addActionListener(this);
        int z = journ + 1;
        this.setBorder(new TitledBorder("Journée " + z));

        init();
    }

    void init() {
        this.removeAll();
        ModelTableCoupe t = new ModelTableCoupe(champ.getListeJournee().get(journ), champ);
        table = new JTable(t);
        int z = journ + 1;
        this.setBorder(new TitledBorder("Journée " + z));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(450, 167));

        this.setLayout(new GridBagLayout());

        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        cont.gridwidth = 4;
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(scroll, cont);
        cont.insets = new Insets(10, 0, 0, 0);
        cont.gridwidth = 1;
        cont.gridx = 0;
        cont.gridy = 1;
        this.add(JButton_GenererAleatoirementJournees, cont);
        cont.insets = new Insets(10, 0, 0, 0);
        cont.gridx = 0;
        cont.gridy = 2;

        
        this.repaint();
        updateUI();
    }

    public void setChamp(ChampionsLeague champ) {
        this.champ = champ;
    }

    public void setJourn(int journ) {
        this.journ = journ;
    }
    
 

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == JButton_GenererAleatoirementJournees) {
            champ.raz();
            for (Poule p : champ.getPhase_poule()) {
                for (int i=0 ; i<p.getEquipes().size() ; i++) {
                    p.getClassement().get(i).razPosition();
                }
            }
            champ=champ.genererResultat();
            init();
            this.repaint();
        }

    }

    @Override
    public void update(Observable o, Object o1) {
        init();
    }

}
