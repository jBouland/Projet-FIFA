/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Flo
 */
public class AffichageJournee extends JPanel implements ActionListener {

    private JTable table;
    private JButton JButton_ModifierScore;
    private JButton JButton_GenererAleatoirement;

    private Championnat champ;
    private int journ;

    public AffichageJournee(Championnat Championnat_, int jour_) {

        champ = Championnat_;
        journ = jour_;
        
        table = new JTable(new MonModelTable(champ.getListeJournee().get(journ)));
        
        JButton_GenererAleatoirement = new JButton("Génerer Aléatoirement les scores");        
        JButton_ModifierScore = new JButton("Modifier ce match");
        
         this.setBorder(new TitledBorder("Journée "+journ));
         
         init();
    }
    
    
    public void init(){
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(450, 167));
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        
        cont.gridwidth=4;
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(scroll,cont);
        
        cont.gridwidth=1;
        cont.gridx=1;
        cont.gridy=0;
        this.add(JButton_GenererAleatoirement);
        
       
        
       
    }
    
    public void loadTable(){
       
        
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
    
    
    }

   
}
