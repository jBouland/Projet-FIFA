/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import static fifa.packVue.MonModelTable.isNumeric;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class AffichageJournee extends JPanel implements ActionListener, MouseListener, Observer {

    private JTable table;
    private MonModelTable modeleTable;
    private JButton genererTout;
    private JButton genererJournee;
    private Championnat champ;
    private int journ;

    public AffichageJournee(Championnat championnat, int jour) {

        champ = championnat;
        journ = jour;
        modeleTable = new MonModelTable(champ.getListeJournee().get(journ), champ);
        table = new JTable(modeleTable);

        genererTout = new JButton("Génerer Aléatoirement tous les scores");
        genererJournee = new JButton("Génerer Aléatoirement les scores de la journée");
        genererTout.addActionListener(this);
        genererJournee.addActionListener(this);

        int z = journ + 1;
        this.setBorder(new TitledBorder("Journée " + z));

        init();

    }

    public void init() {
        removeAll();
        table = new JTable(new MonModelTable(champ.getListeJournee().get(journ), champ));
        int z = journ + 1;
        this.setBorder(new TitledBorder("Journée " + z));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(600, 200));

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
        cont.gridy = 2;
        this.add(genererTout, cont);
        cont.insets = new Insets(10, 0, 0, 0);
        cont.gridx = 0;
        cont.gridy = 3;

        this.add(genererJournee, cont);
        table.addMouseListener(this);
        updateUI();
    }

    public void setChamp(Championnat champ) {
        this.champ = champ;
    }

    public void setJourn(int journ) {
        this.journ = journ;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == genererTout) {
            champ.razClassement();
            champ.genererResultat();
            /*init();*/
        } else if (ae.getSource() == genererJournee) {
            champ.genererResultat(journ);
            init();
        } else if (ae.getSource() == table) {

        }
        /* else if (ae.getSource() == validerTout) {

         int local;
         int exter;

         for (int i = 0; i < table.getRowCount(); i++) { 
         local = Integer.parseInt(table.getValueAt(i, 1).toString());
         exter = Integer.parseInt(table.getValueAt(i, 2).toString());
         champ.ajoutResultat(local, exter, champ.getListeJournee().get(journ).getMatch_journee().get(i), null);
                
         }

         }*/

    }

    @Override
    public void update(Observable o, Object o1) {
        init();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            try {
                Point p = e.getPoint();
                JTable source = (JTable) e.getSource();
                int i = source.rowAtPoint(p);
                if (champ.getListeJournee().get(journ).getMatch_journee().get(i).isEstModifie() == false) {
                    VueScore vs = new VueScore(champ.getListeJournee().get(journ).getMatch_journee().get(i), champ);
                    vs.setVisible(true);
                    //init();
                }
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
