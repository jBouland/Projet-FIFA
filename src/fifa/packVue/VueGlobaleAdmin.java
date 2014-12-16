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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Flo
 */
public class VueGlobaleAdmin extends JFrame implements ActionListener {

    private ArrayList<Championnat> listeChampionnat;
    private int[] journee;
    private VueClassement vc;
    private VueMatchAdmin vm;
    private JLabel selectChampionnat = new JLabel("Veuillez sélectionner un championnat");
    private JLabel selectJournee = new JLabel("Veuillez sélectionner une journée");

    private JComboBox listeChampionnatJComboBox;
    private JComboBox listeJournéeJComboBox;
    private JLabel Titre = new JLabel("Bievenue Admin");

    public VueGlobaleAdmin() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1000, 800));

        creationComboChampionnat();
        creationComboJournee();

        init();

    }

    public void init() {
       Championnat c=new Championnat();
        vc=new VueClassement(null);
        JPanel pano = new JPanel();
        
        // ajout du gestionnaire de placement 
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.HORIZONTAL;
        cont.ipadx = 5;

        cont.gridx = 0;
        cont.gridy = 0;
        pano.add(Titre, cont);

        cont.gridx = 0;
        cont.gridy = 1;
        pano.add(selectChampionnat, cont);

        cont.gridx = 1;
        cont.gridy = 1;
        pano.add(listeChampionnatJComboBox, cont);

        cont.gridx = 2;
        cont.gridy = 1;
        pano.add(selectJournee, cont);

        cont.gridx = 3;
        cont.gridy = 1;
        pano.add(listeJournéeJComboBox, cont);
        
        
        
        cont.gridwidth = 5;
        cont.gridx = 0;
        cont.gridy = 2;
        pano.add(vc);

        cont.gridx = 2;
        cont.gridy = 2;
        pano.add(vm);

        this.add(pano);
        this.pack();

    }

    public void creationComboChampionnat() {

        listeChampionnatJComboBox = new JComboBox();
        listeChampionnatJComboBox.addItem("Championnat");

        listeChampionnatJComboBox.addItem("League1");

        /* for (int i=0;i<listeChampionnat.size();i++){
         listeChampionnatJComboBox.addItem(listeChampionnat.get(i).getNomCompetition());
            
         }   */
    }

    public void creationComboJournee() {
        listeJournéeJComboBox = new JComboBox();
        for (int i = 1; i < 40; i++) {
            listeJournéeJComboBox.addItem(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
    }

}
