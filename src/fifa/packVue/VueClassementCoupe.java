/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import fifa.ChampionsLeague.Poule;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Flo
 */
public class VueClassementCoupe extends JPanel{

    private JTable classement;
    private final String[] columnNames = {"#", "EQUIPES", "Points", "J", "G", "N", "P", "BM", "BE"};
    private Object row[][];
    private Poule poule;

    public VueClassementCoupe(Poule p) {
        this.poule=p;
        setBorder(new TitledBorder("Classement de la poule "+p.getNumPoule()));

        if (poule != null) {
            row = new Object[poule.getEquipes().size()][9];
        } else {
            row = new Object[10][9];
        }

        classement = new JTable(row, columnNames);
        classement.setPreferredScrollableViewportSize(new Dimension(270, 300));
        classement.setEnabled(false);
        classement.getColumnModel().getColumn(1).setPreferredWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        classement.setDefaultRenderer(String.class, centerRenderer);
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 0;
        cont.gridy = 0;

        this.add(new JScrollPane(classement), cont);
        this.setPreferredSize(new Dimension(270, 300));
    }

    private void affiche() {
        this.removeAll();
        classement.setPreferredScrollableViewportSize(new Dimension(270, 300));
        classement.setEnabled(false);
        classement.getColumnModel().getColumn(1).setPreferredWidth(220);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        classement.setDefaultRenderer(String.class, centerRenderer);
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        cont.gridx = 0;
        cont.gridy = 0;

        this.add(new JScrollPane(classement), cont);
        this.setPreferredSize(new Dimension(270, 300));
    }

    public void chargementClassement(Poule p) {// remplissage du tableaux
        if (p != null) {
            poule = p;
            row = new Object[poule.getEquipes().size()][9];
            for (int i = 0; i < poule.getEquipes().size(); i++) {
                row[i][0] = Integer.toString(i+1);
                row[i][1] = poule.getClassement().get(i).getEquipe().getNomEquipe();
                row[i][2] = poule.getClassement().get(i).getScore();
                row[i][3] = (poule.getClassement().get(i).getNombreVictoire() + poule.getClassement().get(i).getNombreNul() + poule.getClassement().get(i).getNombreDefaite());
                row[i][4] = poule.getClassement().get(i).getNombreVictoire();
                row[i][5] = poule.getClassement().get(i).getNombreNul();
                row[i][6] = poule.getClassement().get(i).getNombreDefaite();
                row[i][7] = poule.getClassement().get(i).getButsMarques();
                row[i][8] = poule.getClassement().get(i).getButsEncaisses();

            }

            classement = new JTable(row, columnNames);
            affiche();
            this.updateUI();

        }
    }


}