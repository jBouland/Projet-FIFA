/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.Journee;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brice.effantin
 */
public class MonModelTable extends AbstractTableModel {

    @Override
    public void setValueAt(Object o, int i, int i1) {
        if (isCellEditable(i, i1) == true) {

            if (i1 == 1) {
                liste.get(i).butEquipe1 = (String) o;
                fireTableCellUpdated(i, i1);
               int x= Integer.parseInt(liste.get(i).butEquipe1);
                System.out.println(x);
                journee.getMatch_journee().get(i).setScoreLocal(x);
            }
            if (i1==2){
                
                liste.get(i).butEquipe2 = (String) o;
                fireTableCellUpdated(i, i1);
                 int x= Integer.parseInt(liste.get(i).butEquipe1);
                
                journee.getMatch_journee().get(i).setScoreExterieur(x);
            }
            
            

           }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        if (journee.getEstModifiable() == false) {
            return false;
        } else {
            if (i1 == 1) {
                return true;
            }
            if (i1 == 2) {
                return true;
            } else {
                return false;
            }

        }
    }

    private class Ligne {

        String equipe1, equipe2, butEquipe1, butEquipe2;

        public Ligne(String equipe1_, String butEquipe1_, String butEquipe2_, String equipe2_) {
            this.equipe1 = equipe1_;
            this.equipe2 = equipe2_;
            this.butEquipe1 = butEquipe1_;
            this.butEquipe2 = butEquipe2_;
        }

    }
    private String[] entetes = {"Equipe local", "But", "But", "Equipe2"};
    private ArrayList<Ligne> liste = new ArrayList();
    private Journee journee;

    public MonModelTable(Journee j) {
        journee = j;
        for (int i = 0; i < j.getMatch_journee().size(); i++) {
            liste.add(new Ligne(j.getMatch_journee().get(i).getEquipeLocale().getNomEquipe(),
                    Integer.toString(j.getMatch_journee().get(i).getScoreLocal()),
                    Integer.toString(j.getMatch_journee().get(i).getScoreExterieur()),
                    j.getMatch_journee().get(i).getEquipeExterieure().getNomEquipe()));

        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (column == 0) {
            return liste.get(row).equipe1;
        }
        if (column == 1) {
            return liste.get(row).butEquipe1;
        }
        if (column == 2) {
            return liste.get(row).butEquipe2;
        } else {
            return liste.get(row).equipe2;
        }
    }

    @Override
    public int getRowCount() {
        try {
            return liste.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }
    /*
     public void addLigne(String prenom, String nom) {
     addLigne(new Ligne(prenom, nom));
     }
     */

    private void addLigne(Ligne l) {
        liste.add(l);
        fireTableRowsInserted(liste.size() - 1, liste.size() - 1);
    }

    public void removeLigne(int index) {
        liste.remove(index);
        fireTableRowsDeleted(index, index);
    }
}
