/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Flo
 */
public class AffichageJournee extends JPanel implements ActionListener, ListSelectionListener {

    
    
    private JList<String> JlistProduit;
    
    private JButton JButton_ModifierScore;
    private JButton JButton_GenererAleatoirement;
    
    private Championnat champ;
    private int jour;
    
    
    public AffichageJournee(Championnat Championnat_,int jour_ ){
      
      champ=Championnat_;
      jour=jour_;
      JlistProduit=new JList<>();
      JButton_GenererAleatoirement=new JButton("Génerer Aléatoirement les scores");
      JButton_ModifierScore=new JButton("Modifier ce match");
       JlistProduit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       JlistProduit.addListSelectionListener(this);
       
       
       
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
   }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
       
    
    
    }

   
    
    
}
