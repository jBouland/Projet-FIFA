/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Flo
 */
public class VueJourneeCoupe extends JPanel {

    
     private JTable table;
    
    private ChampionsLeague champ;
    private int journ;
    
       
    
    VueJourneeCoupe(ChampionsLeague CoupeActu, int journeSelect) {
       
        champ = CoupeActu;
        journ = journeSelect;
        //  table = new JTable(new ModelTableCoupe(champ.getListeJournee().get(journ) ,champ));
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
