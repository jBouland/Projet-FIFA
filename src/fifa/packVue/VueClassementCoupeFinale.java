/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Corentin
 */
public class VueClassementCoupeFinale extends JFrame {

    VueClassementCoupe vc;

    public VueClassementCoupeFinale(ArrayList<ChampionsLeague> listeCoupe) {
        this.setPreferredSize(new Dimension(1200,500));
        this.setMinimumSize(new Dimension(1200,500));
        this.setResizable(false);
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        JPanel mainPanel = new JPanel();
        
        for (int i = 0; i < listeCoupe.get(0).getPhase_poule().size(); i++) {
            vc = new VueClassementCoupe(listeCoupe.get(0).getPhase_poule().get(i));
            vc.chargementClassement(listeCoupe.get(0).getPhase_poule().get(i));
            cont.gridx = i;
            cont.gridy = 0;
            mainPanel.add(vc, cont);
        }
        this.add(mainPanel);
        this.pack();

    }

}
