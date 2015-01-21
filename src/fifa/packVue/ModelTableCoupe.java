/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa.packVue;

import fifa.ChampionsLeague;
import fifa.Journee;
import static fifa.packVue.MonModelTable.isNumeric;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brice.effantin
 */
public class ModelTableCoupe extends AbstractTableModel {

    @Override
    public void setValueAt(Object o, int i, int i1) {
    }

    public boolean testValeur(String val) {

        if (isNumeric(val) == false) {
            return false;
        }
        if (Integer.parseInt(val) < 0) {
            return false;
        }
        if (Integer.parseInt(val) > 1000) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    private class Ligne {

        String equipe1, equipe2, butEquipe1, butEquipe2, date, poule;

        public Ligne(String equipe1_, String butEquipe1_, String butEquipe2_, String equipe2_, String date, String poule) {
            this.equipe1 = equipe1_;
            this.equipe2 = equipe2_;
            this.butEquipe1 = butEquipe1_;
            this.butEquipe2 = butEquipe2_;
            this.date = date;
            this.poule = poule;

        }
    }

    private String[] entetes = {"Equipe local", "But", "But", "Equipe2", "Date", "Poule"};
    private ArrayList<Ligne> liste = new ArrayList();
    private Journee journee;
    private ChampionsLeague c;

    public ModelTableCoupe(Journee j, ChampionsLeague c) {
        journee = j;
        this.c = c;
        for (int i = 0; i < j.getMatch_journee().size(); i++) {
            liste.add(new Ligne(
                    j.getMatch_journee().get(i).getEquipeLocale().getNomEquipe(),
                    Integer.toString(j.getMatch_journee().get(i).getScoreLocal()),
                    Integer.toString(j.getMatch_journee().get(i).getScoreExterieur()),
                    j.getMatch_journee().get(i).getEquipeExterieure().getNomEquipe(),
                    Integer.toString(j.getMatch_journee().get(i).getDateMatch().getDate()) + "/" + Integer.toString(j.getMatch_journee().get(i).getDateMatch().getMonth() + 1) + "/" + Integer.toString(j.getMatch_journee().get(i).getDateMatch().getYear() + 1900),
                    Integer.toString(j.getMatch_journee().get(i).getNum_poule()))
            );

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
        }
        if (column == 3) {
            return liste.get(row).equipe2;
        }
        if (column == 4) {
            return liste.get(row).date;
        } else {
            return liste.get(row).poule;
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

    private void addLigne(Ligne l) {
        liste.add(l);
        fireTableRowsInserted(liste.size() - 1, liste.size() - 1);
    }

    public void removeLigne(int index) {
        liste.remove(index);
        fireTableRowsDeleted(index, index);
    }
}
