/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
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
public class VueClassement extends JPanel {//pour ligue 1

    private JTable classement;
    private String[] columnNames = {"#", "EQUIPES", "Points", "J", "G", "N", "P", "BM", "BE"};
    private Object row[][];
    private Championnat championnat;

    public VueClassement(Championnat chp) {
        this.championnat = chp;
        setBorder(new TitledBorder("Classement"));

        if (championnat != null) {
            row = new Object[championnat.getEquipe().size()][9];
        }else{
               row = new Object[10][9];      
        }

        classement = new JTable(row, columnNames);
        JScrollPane scrollPane = new JScrollPane(classement);
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

        this.add(new JScrollPane(classement));
        this.setPreferredSize(new Dimension(600, 400));
    }

    public void testTable() {
        row[0][0] = "2";
        row[0][1] = "Bourg en bresse";
        row[0][2] = "1";
        row[0][3] = "0";
        row[0][4] = "0";
        row[0][5] = "1";
        row[0][6] = "1";
        row[0][7] = "1";
        row[0][8] = "1";
        /*
         row[1][0] = "1";
         row[1][1] = "Star Poulpe eat Disco Cookies";
         row[1][2] = "1";
         row[1][3] = "1";
         row[1][4] = "0";
         row[1][5] = "0";
         */
    }

    public void chargementClassement() {// remplissage du tableaux
        
        
        
    }

}
