/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Corentin
 */
public class Calendrier {

    Calendar c;
    int annee;
    Date d;
    ArrayList<Date> championnat, pouleschampionsleague, coupe_nationale;

    public Calendrier(int a) {
        this.annee = a;
        championnat = new ArrayList<>();
        pouleschampionsleague = new ArrayList();
        coupe_nationale = new ArrayList();
        c = GregorianCalendar.getInstance();
    }

    public ArrayList<Date> getChampionnat() {
        return championnat;
    }

    public ArrayList<Date> getPouleschampionsleague() {
        return pouleschampionsleague;
    }

    public ArrayList<Date> getCoupe_nationale() {
        return coupe_nationale;
    }

    public void CreationCoupeetChampionnat() {

        c.setWeekDate(annee, 32, 6);

        //System.out.println("Debut du championnat: "+c.getTime().toString());
        //6 / 2 / 6 / 2
        int i;
        for (i = 0; i < 16; i++) {
            if (i != 6 || i != 7 || i != 14 || i != 15) {
                for (int j = 0; j < 3; j++) {
                    championnat.add(c.getTime());
                    c.add(Calendar.DATE, +1);
                }
                c.add(Calendar.DATE, +4);
            } else {
                c.add(Calendar.DATE, +6);
            }
        }
        //4 / 3
        for (i = i; i < 20; i++) {
            for (int j = 0; j < 3; j++) {
                championnat.add(c.getTime());
                c.add(Calendar.DATE, +1);
            }
            c.add(Calendar.DATE, +4);
        }
        c.add(Calendar.DATE, +21);
        //9 / 2 / 9
        for (i = i; i < 43; i++) {
            if (i != 31 || i != 32) {
                for (int j = 0; j < 3; j++) {
                    championnat.add(c.getTime());
                    c.add(Calendar.DATE, +1);
                }
                c.add(Calendar.DATE, +4);
            } else {
                c.add(Calendar.DATE, +6);
            }
        }

    }

    public void CreationPouleChampionsLeague() {

        c.setWeekDate(annee, 38, 3);

        //------- Les POULES ------------//
        //Schema: 1/2/1/3/1/2/1/3/1/2/1
        int i;
        for (i = 0; i < 19; i++) {
            if (i == 0 || i == 3 || i == 7 || i == 10 || i == 14 || i == 17) {
                for (int j = 0; j < 2; j++) {
                    pouleschampionsleague.add(c.getTime());
                    c.add(Calendar.DATE, +1);
                }
c.add(Calendar.DATE, -2);
            } else {
                c.add(Calendar.DATE, +7);
            }

        }
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

}
