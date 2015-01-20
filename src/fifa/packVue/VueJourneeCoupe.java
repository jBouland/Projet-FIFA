/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
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
public class VueJourneeCoupe extends JPanel implements ActionListener, Observer{

    
     private JTable table;
    
    private ChampionsLeague champ;
    private int journ;
    private JButton JButton_GenererAleatoirementJournees;
    private JButton JButton_GenererAleatoirementJournee;
    
       
    
    VueJourneeCoupe(ChampionsLeague CoupeActu, int journeSelect) {     
        champ = CoupeActu;
        journ = journeSelect;
        JButton_GenererAleatoirementJournees = new JButton("Génerer Aléatoirement tous les scores");
        JButton_GenererAleatoirementJournee = new JButton("Génerer Aléatoirement les scores de la journée");
        JButton_GenererAleatoirementJournees.addActionListener(this);
        int z = journ + 1;
        this.setBorder(new TitledBorder("Journée " + z));

        init();
    }
    
    private void init() {
        removeAll();
        table = new JTable(new ModelTableCoupe(champ.getListeJournee().get(journ),champ));
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

        this.add(JButton_GenererAleatoirementJournee, cont);

        
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
            champ.genererResultat();
        }

    }

    @Override
    public void update(Observable o, Object o1) {
        init();
       
    }

}
