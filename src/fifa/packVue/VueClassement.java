/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
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
public class VueClassement extends JPanel implements Observer{//pour ligue 1

    private JTable classement;
    private final String[] columnNames = {"#", "EQUIPES", "Points", "J", "G", "N", "P", "BM", "BE"};
    private Object row[][];
    private Championnat championnat;

    public VueClassement(Championnat chp) {
        this.championnat = chp;
        setBorder(new TitledBorder("Classement"));

        if (championnat != null) {
            row = new Object[championnat.getEquipe().size()][9];
        } else {
            row = new Object[10][9];
        }

        classement = new JTable(row, columnNames);
        classement.setPreferredScrollableViewportSize(new Dimension(400, 400));
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
        this.setPreferredSize(new Dimension(400, 400));
    }

    private void affiche() {
        this.removeAll();
        classement.setPreferredScrollableViewportSize(new Dimension(400, 400));
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
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void chargementClassement(Championnat ct) {// remplissage du tableaux
        if (ct != null) {
            championnat = ct;
            row = new Object[championnat.getEquipe().size()][9];
            for (int i = 0; i < championnat.getEquipe().size(); i++) {
                row[i][0] = Integer.toString(i+1);
                row[i][1] = championnat.getClassement(i).getEquipe().getNomEquipe();
                row[i][2] = championnat.getClassement(i).getScore();
                row[i][3] = (championnat.getClassement(i).getNombreVictoire() + championnat.getClassement(i).getNombreNul() + championnat.getClassement(i).getNombreDefaite());
                row[i][4] = championnat.getClassement(i).getNombreVictoire();
                row[i][5] = championnat.getClassement(i).getNombreNul();
                row[i][6] = championnat.getClassement(i).getNombreDefaite();
                row[i][7] = championnat.getClassement(i).getButsMarques();
                row[i][8] = championnat.getClassement(i).getButsEncaisses();

            }

            classement = new JTable(row, columnNames);
            affiche();
            this.updateUI();

        }
    }

    @Override
    public void update(Observable o, Object o1) {
        chargementClassement(championnat);
    }

}
