/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Match;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Flo
 */
public class AffichageMatch extends JPanel implements ActionListener {

    private JLabel JlabelEquipe1;
    private JLabel JlabelEquipe2;
    private JLabel Jlabeljournee;

    private JButton Jbuttonmoins1;
    private JButton Jbuttonplus1;
    private JButton Jbuttonplus2;
    private JButton Jbuttonmoins2;
    private JButton Jbuttonvalider;
    private JButton Jbuttonannuler;

    private JTextField JtextfieldEquipe1;
    private JTextField JtextfieldEquipe2;

    private Match match;
    private int numeroJournee;

    public AffichageMatch(Match match_, int numeroJournee_) {
        match = match_;
        numeroJournee = numeroJournee_;
        initComposant();

    }

    public void initComposant() {
        Jbuttonmoins1 = new JButton("-");
        Jbuttonmoins2 = new JButton("-");
        Jbuttonplus1 = new JButton("+");
        Jbuttonmoins2 = new JButton("+");
        Jbuttonvalider=new JButton("Valider");
        Jbuttonannuler=new JButton();
        
        JlabelEquipe1 = new JLabel(match.getEquipeLocale().getNomEquipe());
        JlabelEquipe2 = new JLabel(match.getEquipeExterieure().getNomEquipe());
        Jlabeljournee = new JLabel("Journée: " + numeroJournee + " le ");//ajouter un match.getDate mais non codé

        
        Jbuttonmoins1.addActionListener(this);
        Jbuttonmoins2.addActionListener(this);
        Jbuttonplus1.addActionListener(this);
        Jbuttonplus2.addActionListener(this);

        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;

        cont.gridx = 0;
        cont.gridy = 0;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
    if (ae.getSource()==Jbuttonmoins1){
        
        
        
    }
    if (ae.getSource()==Jbuttonplus1){
        
        
    }
    if (ae.getSource()==Jbuttonmoins2){
        
        
    }
    if (ae.getSource()==Jbuttonplus2){
        
        
    }
    
    
    }

}
