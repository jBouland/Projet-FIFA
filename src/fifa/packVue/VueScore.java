/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import fifa.ChampionsLeague;
import fifa.ChampionsLeague.Poule;
import fifa.Competition;
import fifa.Match;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Corentin
 */
public class VueScore extends JFrame implements ActionListener {

    JTextField scoreLocal1, scoreExterieur1,scoreLocal2, scoreExterieur2;
    JLabel equipeA1, equipeB1,equipeA2, equipeB2;
    JButton valider;
    Competition c;
    Match m1,m2;
    VueJourneeCoupe pan;

    VueScore(Match m1, Competition c) {
        this.c = c;
        this.m1 = m1;
        this.setTitle("Score");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(150, 100));
        this.setResizable(false);

        equipeA1 = new JLabel(m1.getEquipeLocale().getNomEquipe());
        equipeB1 = new JLabel(m1.getEquipeExterieure().getNomEquipe());
        scoreLocal1 = new JTextField(m1.getScoreLocal());
        scoreExterieur1 = new JTextField(m1.getScoreExterieur());
        valider = new JButton("Valider");

        valider.addActionListener(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        mainPanel.add(equipeA1, cont);

        cont.gridx = 1;
        cont.gridy = 0;
        mainPanel.add(equipeB1, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        mainPanel.add(scoreLocal1, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        mainPanel.add(scoreExterieur1, cont);
        cont.gridx = 2;
        cont.gridy = 1;
        mainPanel.add(valider, cont);

        this.add(mainPanel);
        this.pack();

    }
    
    VueScore(Match m1,Match m2, Competition c, VueJourneeCoupe pan) {
        this.pan=pan;
        this.c = c;
        this.m1 = m1;
        this.m2 = m2;
        this.setTitle("Score");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(150, 100));
        this.setResizable(false);

        equipeA1 = new JLabel(m1.getEquipeLocale().getNomEquipe());
        equipeB1 = new JLabel(m1.getEquipeExterieure().getNomEquipe());
        scoreLocal1 = new JTextField(m1.getScoreLocal());
        scoreExterieur1 = new JTextField(m1.getScoreExterieur());
        equipeA2 = new JLabel(m2.getEquipeLocale().getNomEquipe());
        equipeB2 = new JLabel(m2.getEquipeExterieure().getNomEquipe());
        scoreLocal2 = new JTextField(m2.getScoreLocal());
        scoreExterieur2 = new JTextField(m2.getScoreExterieur());
        valider = new JButton("Valider");

        valider.addActionListener(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        mainPanel.add(equipeA1, cont);

        cont.gridx = 1;
        cont.gridy = 0;
        mainPanel.add(equipeB1, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        mainPanel.add(scoreLocal1, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        mainPanel.add(scoreExterieur1, cont);
        
        cont.gridx = 0;
        cont.gridy = 2;
        mainPanel.add(equipeA2, cont);

        cont.gridx = 1;
        cont.gridy = 2;
        mainPanel.add(equipeB2, cont);

        cont.gridx = 0;
        cont.gridy = 3;
        mainPanel.add(scoreLocal2, cont);

        cont.gridx = 1;
        cont.gridy = 3;
        mainPanel.add(scoreExterieur2, cont);
        
        cont.gridx = 2;
        cont.gridy = 4;
        mainPanel.add(valider, cont);

        this.add(mainPanel);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valider) {
            try {
                Championnat ch = (Championnat) c;
                ch.ajoutResultat(Integer.parseInt(scoreLocal1.getText()), Integer.parseInt(scoreExterieur1.getText()), m1, null);                
                this.setVisible(false);
            } catch (Exception a) {

            }
            try {
                ChampionsLeague cl = (ChampionsLeague) c;
                cl.ajoutResultat(Integer.parseInt(scoreLocal1.getText()), Integer.parseInt(scoreExterieur1.getText()), m1, null);
                cl.ajoutResultat(Integer.parseInt(scoreLocal2.getText()), Integer.parseInt(scoreExterieur2.getText()), m2, null);
                Poule po = cl.getPhase_poule().get(m1.getNum_poule()-1);
                po.majClassement(m1.getNum_journee());
                this.setVisible(false);
                pan.init();
                pan.repaint();
            } catch (Exception a) {

            }
        }
    }
}
