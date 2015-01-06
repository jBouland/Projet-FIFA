/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

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

    private JButton Jbuttonmoins1;
    private JButton Jbuttonplus1;
    private JButton Jbuttonplus2;
    private JButton Jbuttonmoins2;

    private JTextField JtextfieldEquipe1;
    private JTextField JtextfieldEquipe2;
    
    

    public AffichageMatch(){
       initComposant();
       
              
        
      
    }
    
    public void initComposant(){
        Jbuttonmoins1=new JButton("-");
         Jbuttonmoins2=new JButton("-");
         Jbuttonplus1=new JButton("+");
         Jbuttonmoins2=new JButton("+");
         
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
