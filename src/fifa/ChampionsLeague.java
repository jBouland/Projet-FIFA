/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

///RAJOUTER LA CONDITION DES MEMES PAYS POUR LA CREATION DES POULES
///BDD POULES ET TOURS ???
public class ChampionsLeague extends Europeenne {
    
    private ArrayList<Poule> phase_poule;
    private ArrayList<Journee> calendrier;
    private ArrayList<Tour> phase_finale;
    
    public ChampionsLeague(int idCompetition, String nomCoupeEurope, int saison, ArrayList<Equipe> equipe) {
        super(idCompetition, nomCoupeEurope, saison, equipe);
        
        phase_poule = new ArrayList<>();
        if (equipe.size() == 32) {
            for (int i = 1; i < 9; i++) {
                Poule p = new Poule(i);
                phase_poule.add(p);
            }
        } else {
            System.out.println("Il faut 32 équipes");
        }
    }
    
    public void genererResultat() {
        
        this.creerPhasePoule();
        this.simulerPhasePoule();
        this.genererDatesMatchesPoules();
        this.afficherCalendrierPhasePoule();
        this.afficherPhasePoule();
        
        this.creerPhaseFinale();
        this.simulerPhaseFinale();
        this.affichagePhaseFinale();
        
    }

    ////////////////////////////////////////////////////
    ///////// GESTION DU CALENDRIER //////////////////
    //////////////////////////////////////////////////
    private void creerCalendrier(int nbjournee) {
        calendrier = new ArrayList<Journee>();
        Equipe temp1, temp2;
        Match inv;
        Random rd = new Random();
        int randMatch;
        ArrayList<Match> matchspossibles;
        ArrayList<Boolean> matchsdispo;
        
        for (int k = 0; k < nbjournee; k++) {
            calendrier.add(new Journee(k));
        }
        
        for (int i = 0; i < phase_poule.size(); i++) { // pour chaque poule
                /* Prend les matchs dispo*/
            matchspossibles = this.matchPossiblePoule(phase_poule.get(i).getEquipes());
            matchsdispo = new ArrayList<Boolean>();
            for (int a = 0; a < nbjournee * (phase_poule.get(i).getEquipes().size() / 2); a++) {
                matchsdispo.add(Boolean.TRUE);
            }
            for (int j = 0; j < nbjournee / 2; j++) { // pour chaque journee
                /*Pour une journée il ajoute deux matchs au hazard*/
                for (int t = 0; t < (matchspossibles.size() * 2 / nbjournee); t++) {
                    randMatch = rd.nextInt(matchspossibles.size());
                    if (matchsdispo.get(randMatch) == true) { // si le match est dispo
                        temp1 = matchspossibles.get(randMatch).getEquipeLocale();
                        temp2 = matchspossibles.get(randMatch).getEquipeExterieure();
                        if (calendrier.get(j).equipeEstDansLaJournée(temp1) == false && calendrier.get(j).equipeEstDansLaJournée(temp2) == false) {//fonction test si le match n'est pas dans la journée
                            matchsdispo.set(randMatch, Boolean.FALSE);
                            matchspossibles.get(randMatch).setNum_journee(j);
                            calendrier.get(j).ajouterMatch(matchspossibles.get(randMatch));
                            inv = calendrier.get(j).inverserMatch(matchspossibles.get(randMatch));
                            inv.setNum_journee(j + (nbjournee / 2));
                            calendrier.get(j + (nbjournee / 2)).ajouterMatch(inv);
                        } else {
                            t--;
                        }
                    } else {
                        t--;
                    }
                }
                
            }
            matchspossibles.clear();
            matchsdispo.clear();
        }
        
    }
    
    private ArrayList<Match> matchPossiblePoule(ArrayList<Equipe> poule) {
        ArrayList<Match> matchspossibles = new ArrayList<Match>();
        Match temp;

        //creation de la phase allée
        for (int i = 0; i < poule.size(); i++) {
            for (int j = i + 1; j < poule.size(); j++) {
                temp = new Match(numPoule(poule.get(i)), poule.get(i), poule.get(j));
                matchspossibles.add(temp);
            }
        }
        return matchspossibles;
    }

    ////////////////////////////////////////////////////
    ///////// GESTION DE LA PHASE DE POULE ////////////
    //////////////////////////////////////////////////
    public void creerPhasePoule() {
        ArrayList<Equipe> temp = equipe;
        
        for (int i = 0; i < 8; i++) {
            phase_poule.get(i).creer_group(temp);
        }
        this.creerCalendrier(6);
    }
    
    public void afficherCalendrierPhasePoule() {
        
        for (Journee journee_courante : calendrier) {
            System.out.println("MATCH de la JOURNEE " + journee_courante.getNum_Journee());
            journee_courante.afficheMatch();
            System.out.println();
        }
        
    }
    
    public void afficherPhasePoule() {
        for (Poule p : phase_poule) {
            p.afficherPoule();
        }
    }
    
    public ArrayList<Equipe> chapeau(int numero) {
        ArrayList<Equipe> chapeau = new ArrayList<>();
        for (Poule p : phase_poule) {
            for (Position pos : p.getClassement()) {
                if (pos.getPositionEquipe() == numero) {
                    chapeau.add(pos.getEquipe());
                    break;
                }
            }
        }
        return chapeau;
    }
    
    public int numPoule(Equipe e) {
        for (Poule p : phase_poule) {
            for (Equipe eq : p.getEquipes()) {
                if (e == eq) {
                    return p.getNumPoule();
                }
            }
        }
        return 0;
    }
    
    public void simulerPhasePoule() {
        
        for (Journee j : calendrier) {
            for (Match m : j.getMatch_journee()) {
                m.simulerMatch();
            }
            for (Poule p : phase_poule) {
                p.majClassement(j.getNum_Journee());
            }
        }
    }
    
    void genererDatesMatchesPoules() {
        Calendrier c = new Calendrier(saison);
        ArrayList<Date> dates;
        c.CreationPouleChampionsLeague();
        dates = c.getPouleschampionsleague();
        for (Journee j : calendrier) {
            j.affecterDatesPouleChampionsLeague(j.getNum_Journee(), dates);
        }
    }

    ////////////////////////////////////////////////////
    ///////// GESTION DE LA PHASE FINALE //////////////
    //////////////////////////////////////////////////
    public void creerPhaseFinale() {

        //creation des tours
        Tour huitiemes = new Tour(8);
        Tour quarts = new Tour(4);
        Tour demis = new Tour(2);
        Tour finale = new Tour(1);

        //on recupère les deux chapeaux
        ArrayList<Equipe> chapeau_1 = this.chapeau(1);
        ArrayList<Equipe> chapeau_2 = this.chapeau(2);

        //on cree le tour 
        huitiemes.creerTourSortiePoule(chapeau_1, chapeau_2);

        //et on l'ajoute à la liste des phase_finale
        this.phase_finale.add(huitiemes);
        
        this.phase_finale.add(quarts);
        this.phase_finale.add(demis);
        this.phase_finale.add(finale);
        
    }
    
    public void simulerPhaseFinale() {
        
        Tour tour_suivant = null;
        Tour tour_courant = null;
        int i;
        for (i = 0; i < phase_finale.size() - 1; i++) {
            
            tour_courant = phase_finale.get(i);
            tour_courant.simuler_tour();
            
            if (i == phase_finale.size() - 2) {
                tour_suivant = phase_finale.get(i + 1);
                tour_suivant.creerFinale(tour_courant.getQualifiesTourSuivant());
            } else {
                tour_suivant = phase_finale.get(i + 1);
                tour_suivant.creerTourSortiTour(tour_courant.getQualifiesTourSuivant());
                
            }
            
        }
        tour_courant = phase_finale.get(i);
        tour_courant.simuler_tour();
        
    }
    
    public void affichagePhaseFinale() {
        
        for (Tour tour_courant : phase_finale) {
            
            tour_courant.afficher_resultats_tour();
            
        }
        
    }
    
    public class Tour extends Journee {
        
        ArrayList<Date> dates_tours;
        private int index_date;
        
        public Tour(int num_tour) {
            super(num_tour);
            
            Calendrier c = new Calendrier(saison);
            dates_tours = c.getToursChampionsLeague();
            index_date = 0;
        }
        
        public void creerTourSortiePoule(ArrayList<Equipe> chapeau1, ArrayList<Equipe> chapeau2) {
            Random rd = new Random();
            boolean continuer = true;
            int randEquipe;
            Equipe c1, c2;
            int taille = chapeau1.size();
            
            index_date = 0;//pour sélectionner les dates dans la listes des dates du tour

            ArrayList<Equipe> temp2;
            temp2 = (ArrayList<Equipe>) chapeau2.clone();
            while (temp2.isEmpty() == false) {
                this.match_journee.clear();
                temp2.clear();
                temp2 = (ArrayList<Equipe>) chapeau2.clone();
                for (int i = 0; i < taille; i++) {
                    c1 = chapeau1.get(i);
                    randEquipe = rd.nextInt(temp2.size());
                    c2 = temp2.get(randEquipe);
                    if (c1.getIdPays() != c2.getIdPays()) {
                        for (Poule p : phase_poule) {
                            if (p.memeGroupe(c1, c2) == true) {
                                continuer = false;
                            }
                        }
                        if (continuer == true) {
                            Match match_aller = new Match(num_Journee, c1, c2);
                            this.match_journee.add(match_aller);//pour le match aller
                            //match_aller.setDateMatch(dates_tours.get(index_date));
                            Match match_retour = new Match(num_Journee, c2, c1);
                            this.match_journee.add(match_retour);//pour le match retour
                            // match_aller.setDateMatch(dates_tours.get(index_date + 4));
                            temp2.remove(c2);
                            // index_date++;
                        } else {
                            continuer = true;
                            this.match_journee.clear();
                            temp2.clear();
                            temp2 = (ArrayList<Equipe>) chapeau2.clone();
                            i = 0;
                        }
                    } else {
                        this.match_journee.clear();
                        temp2.clear();
                        temp2 = (ArrayList<Equipe>) chapeau2.clone();
                        i = 0;
                    }
                }
                
            }
            
            for (Match m : match_journee) {
                int i = 0;
                while (i < 2) {
                    m.setDateMatch(dates_tours.get(i));
                }
                
            }
        }
        
        public void creerFinale(ArrayList<Equipe> eq_qualifiees) {
            
            Random rand = new Random();
            int indice;
            
            Equipe equipe1 = eq_qualifiees.get(0);//on prend la première équipe de la liste

            Equipe equipe2 = eq_qualifiees.get(1);//on recupere l'equipe associée à cet indice

            this.match_journee.add(new Match(equipe1, equipe2));//on genere un match unique avec ces deux equipes

        }
        
        public void creerTourSortiTour(ArrayList<Equipe> eq_qualifiees) {
            
            Random rand = new Random();
            int indice;
            Match match_aller, match_retour;
            
            while (eq_qualifiees.isEmpty() != true) {
                Equipe equipe1 = eq_qualifiees.get(0);//on prend la première équipe de la liste
                try {
                    indice = 1 + rand.nextInt(eq_qualifiees.size() - 1);//on sélectionne un index au hasard (entre 1 et la taille de la liste)
                    Equipe equipe2 = eq_qualifiees.get(indice);//on recupere l'equipe associée à cet indice

                    match_aller = new Match(equipe1, equipe2);//on genere un match aller avec ces deux equipes
                    match_retour = new Match(equipe2, equipe1);//...et un retour

                    this.match_journee.add(match_aller);
                    match_aller.setDateMatch(dates_tours.get(index_date));
                    this.match_journee.add(match_retour);
                    match_retour.setDateMatch(dates_tours.get(index_date + 2));

                    //et on les supprime de la liste de départ
                    eq_qualifiees.remove(equipe1);
                    eq_qualifiees.remove(equipe2);
                } catch (Exception ex) {
                    System.out.println("pb a" + this.num_Journee);
                }
            }
            
        }
        
        public void simuler_tour() {
            Random rd = new Random();
            int scoreA, scoreB;//random pour les deux scores

            for (Match m : match_journee) {//pour tout les matchs du tour
                scoreA = rd.nextInt(5);
                scoreB = rd.nextInt(5);
                m.setScoreLocal(scoreA);
                m.setScoreExterieur(scoreB);
            }
            
        }
        
        public void afficher_resultats_tour() {
            
            System.out.println();
            System.out.println("----Match du tour N° " + this.getNum_Journee() + "----");
            
            for (Match m : match_journee) {
                
                System.out.println(m.getEquipeLocale().getNomEquipe() + " vs " + m.getEquipeExterieure().getNomEquipe());
                
            }
            Equipe locale, exte;
            System.out.println();
            System.out.println("RESULTATS du " + num_Journee + "eme de finale");
            for (Match m : match_journee) {//pour tout les matchs du tour
                locale = m.getEquipeLocale();
                exte = m.getEquipeExterieure();
                
                System.out.println("DATE: " + m.getDateMatch() + " " + locale.getNomEquipe() + " " + m.getScoreLocal() + " - " + m.getScoreExterieur() + " " + exte.getNomEquipe());
            }
            
            if (num_Journee == 1) {
                
                System.out.println("Le champion est ");
                
            }
            
        }
        
        public ArrayList<Equipe> getQualifiesTourSuivant() {
            ArrayList<Equipe> list_retour = new ArrayList();
            int total_but_equipeA, total_but_equipeB, tot_ext_equipeA, tot_ext_equipeB;
            Match match_aller, match_retour;
            for (int i = 0; i < match_journee.size(); i = i + 2) {
                match_aller = match_journee.get(i);
                match_retour = match_journee.get(i + 1);
                
                total_but_equipeA = +match_aller.getScoreLocal() + match_retour.getScoreExterieur();//l'equipe A est l'équipe à domicile lors du match aller
                tot_ext_equipeA = +match_retour.getScoreExterieur();
                
                total_but_equipeB = +match_aller.getScoreExterieur() + match_retour.getScoreLocal();
                tot_ext_equipeB = +match_retour.getScoreLocal();
                
                if (total_but_equipeA == total_but_equipeB) {
                    if (tot_ext_equipeA == tot_ext_equipeB) {
                        list_retour.add(match_aller.getEquipeLocale());
                    }
                    
                    if (tot_ext_equipeA > tot_ext_equipeB) {
                        list_retour.add(match_aller.getEquipeLocale());
                    }
                    if (tot_ext_equipeA < tot_ext_equipeB) {
                        list_retour.add(match_aller.getEquipeExterieure());
                    }
                    
                } else {
                    if (total_but_equipeA > total_but_equipeB) {
                        list_retour.add(match_aller.getEquipeLocale());
                    }
                    if (total_but_equipeA < total_but_equipeB) {
                        list_retour.add(match_aller.getEquipeExterieure());
                    }
                    
                    if (total_but_equipeA == total_but_equipeB) {
                        list_retour.add(match_aller.getEquipeLocale());
                    }
                    
                }
            }
            return list_retour;
        }
    }
    
    public class Poule {
        
        int numPoule;
        ArrayList<Equipe> equipes;
        ArrayList<Position> classement;
        
        public int getNumPoule() {
            return numPoule;
        }
        
        public boolean memeGroupe(Equipe e1, Equipe e2) {
            boolean temp = false;
            for (Equipe p : equipes) {
                if (p == e1) {
                    temp = true;
                    break;
                }
            }
            if (temp == true) {
                for (Equipe p : equipes) {
                    if (p == e2) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        public Poule(int i) {
            this.numPoule = i;
            equipes = new ArrayList<>();
            classement = new ArrayList<>();
            phase_finale = new ArrayList<>();
        }
        
        public ArrayList<Equipe> getEquipes() {
            return equipes;
        }
        
        public void setEquipes(ArrayList<Equipe> equipes) {
            this.equipes = equipes;
        }
        
        public void creer_group(ArrayList<Equipe> participants) {
            int i = 0;
            
            int randEquipe;
            Equipe t;
            Random rd = new Random();
            
            while (i < 4) {
                randEquipe = rd.nextInt(participants.size());
                t = participants.get(randEquipe);
                this.equipes.add(t);
                participants.remove(t);
                classement.add(new Position(t, i + 1));
                
                i++;
            }
            
        }
        
        public ArrayList<Position> getClassement() {
            return classement;
        }
        
        private Position getPositionEquipe(Equipe e) {
            for (Position p : classement) {
                if (p.getEquipe() == e) {
                    return p;
                }
            }
            return null;
        }
        
        private void majClassement(int num_journee) {
            
            ArrayList<Match> liste_match = calendrier.get(num_journee).getMatch_group(this.numPoule);
            for (Match m : liste_match) {
                for (Equipe e : m.getEquipesMatch()) {
                    if (e == m.getEquipeLocale()) {
                        getPositionEquipe(e).setResultatsChampionnat(m.getScoreLocal(), m.getScoreExterieur());
                    } else {
                        getPositionEquipe(e).setResultatsChampionnat(m.getScoreExterieur(), m.getScoreLocal());
                    }
                }
            }
            
            Position pos_tmp;
            Position[] temp = classement.toArray(new Position[classement.size()]);
            int ecartE1 = 0, ecartE2 = 0;
            for (int i = 0; i < classement.size(); i++) {
                for (int j = 0; j < classement.size(); j++) {
                    if (temp[i].getScore() >= temp[j].getScore()) {//si le nombre de points est supérieur
                        if (temp[i].getScore() != temp[j].getScore()) {
                            pos_tmp = temp[j];
                            temp[j] = temp[i];
                            temp[i] = pos_tmp;
                            i--;
                            break;
                        } else {//si egalite dans le nombre de points
                            ecartE1 = temp[i].getButsMarques() - temp[i].getButsEncaisses();
                            ecartE2 = temp[j].getButsMarques() - temp[j].getButsEncaisses();
                            if (ecartE1 > ecartE2) {
                                pos_tmp = temp[j];
                                temp[j] = temp[i];
                                temp[i] = pos_tmp;
                                i--;
                                break;
                            } else if (ecartE1 == ecartE2) {
                                pos_tmp = temp[j];
                                temp[j] = temp[i];
                                temp[i] = pos_tmp;
                                break;
                            }
                        }
                    }
                }
            }
            classement = new ArrayList<Position>(Arrays.asList(temp));
            int i = 1;
            for (Position p : classement) {
                p.setPositionEquipe(i++);
            }
        }
        
        void afficherPoule() {
            System.out.println("------------");
            System.out.println("Poule " + numPoule);
            for (Position pos : classement) {
                System.out.println(pos.getPositionEquipe() + " " + pos.getEquipe().getNomEquipe() + " " + pos.getScore() + " " + pos.getNombreVictoire() + "/" + pos.getNombreNul() + "/" + pos.getNombreDefaite() + " - " + pos.getButsMarques() + "/" + pos.getButsEncaisses());
            }
            System.out.println("------------");
        }
        
    }
    
}
