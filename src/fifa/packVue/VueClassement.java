/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Championnat;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import static javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Flo
 */
public class VueClassement extends JPanel {//pour ligue 1

    private JTable classement;
    private String[] columnNames = {"#", "EQUIPES","Point", "J", "G", "N", "P","BM","BE"};
    private Object row[][] = new Object[20][9];
    private Championnat c;

    public VueClassement(Championnat x) {
        c = x;
        setBorder(new TitledBorder("Classement"));
        testTable();
        classement = new JTable(row, columnNames);
       // classement.setShowVerticalLines(false);
        JScrollPane scrollPane = new JScrollPane(classement);
        classement.setPreferredScrollableViewportSize(new Dimension(500, 120));
       classement.setEnabled(false);
        classement.getColumnModel().getColumn(1).setPreferredWidth(220);
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        classement.setDefaultRenderer(String.class, centerRenderer);
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        
        
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(new JScrollPane(classement));
        this.setSize(new Dimension(600, 300));

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
        for (int i = 1; i < 21; i++) {
            c.getEquipe().get(i);

        }

    }

    public void lockTable(){
        for (int i=0;i<classement.getRowCount();i++){
         
        }
        
        
        
    }
}
