/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

///RAJOUTER LA CONDITION DES MEMES PAYS POUR LA CREATION DES POULES
public class ChampionsLeague extends Europeenne {

    private ArrayList<Poule> poules;
    private ArrayList<Journee> calendrier;
    private ArrayList<Tour> tours;

    public ChampionsLeague(int idCompetition, String nomCoupeEurope, int saison, ArrayList<Equipe> equipe) {
        super(idCompetition, nomCoupeEurope, saison, equipe);
        poules = new ArrayList<>();
        if (equipe.size() == 32) {
            for (int i = 1; i < 9; i++) {
                Poule p = new Poule(i);
                poules.add(p);
            }
        } else {
            System.out.println("Il faut 32 équipes");
        }
    }

    /**
     * *************************
     * Gestion des Tours (Phases finales) *************************
     */
    public class Tour extends Journee {

        public Tour(int num_tour) {
            super(num_tour);
        }

        public void creerTour() {

        }

        public void creerTourSortiePoule(ArrayList<Equipe> chapeau1, ArrayList<Equipe> chapeau2) {
            Random rd = new Random();
            boolean continuer = true;
            int randEquipe;
            Equipe c1, c2;
            int taille = chapeau1.size();
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
                        for (Poule p : poules) {
                            if (p.memeGroupe(c1, c2) == true) {
                                continuer = false;
                            }
                        }
                        if (continuer == true) {
                            this.match_journee.add(new Match(num_Journee, c1, c2));
                            temp2.remove(c2);
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
            //Ajout à la BD ici
        }

    }

    public ArrayList<Equipe> chapeau(int numero) {
        ArrayList<Equipe> chapeau = new ArrayList<>();
        for (Poule p : poules) {
            for (Position pos : p.getClassement()) {
                if (pos.getPositionEquipe() == numero) {
                    chapeau.add(pos.getEquipe());
                    break;
                }
            }
        }
        return chapeau;
    }

    /**
     * *************************
     * Créer un Tour (Phase finale) *************************
     */
    public void creerTour(int nb_tour) {

        //creation du tour
        Tour tour = new Tour(nb_tour);

        //on recupère les deux chapeau
        ArrayList<Equipe> chapeau_1 = this.chapeau(1);
        ArrayList<Equipe> chapeau_2 = this.chapeau(2);

        //on cree le tour 
        tour.creerTourSortiePoule(chapeau_1, chapeau_2);

        //et on l'ajoute à la liste des tours
        this.tours.add(tour);

    }

    /**
     * *************************
     * Afficher les match d'un tour (phase finale) *************************
     * @param nb_tour
     */
    public void affichageTour(int nb_tour) {

        ArrayList<Match> match_tour = tours.get(nb_tour).getMatch_journee();

        System.out.println("----TOUR N° " + tours.get(nb_tour).getNum_Journee());

        for (Match m : match_tour) {

            System.out.println(m.getEquipeLocale().getNomEquipe() + " vs " + m.getEquipeExterieure().getNomEquipe());

        }
    }

    /**
     * *************************
     * Gestion des Poules (Avant les phases finales) *************************
     */
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
            tours = new ArrayList<>();
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

    }

    /**
     * *************************
     * Connaitre le numéro de la poule de l'équipe
     *
     *************************
     * @param equipe
     * @return
     */
    public int numPoule(Equipe equipe) {
        for (Poule p : poules) {
            for (Equipe eq : p.getEquipes()) {
                if (equipe == eq) {
                    return p.getNumPoule();
                }
            }
        }
        return 0;
    }

    /**
     * *************************
     * Créer une poule *************************
     */
    public void creerPoule() {
        ArrayList<Equipe> temp = equipe;

        for (int i = 0; i < 8; i++) {
            poules.get(i).creer_group(temp);
        }
        this.creerJournees(6);
    }

    /**
     * *************************
     * Récupérer un groupe
     *
     * @return
     */
    public ArrayList<Poule> getGroupes() {
        return this.poules;
    }

    /**
     * *************************
     * Connaitre les matchs possibles d'une poule *************************
     */
    private ArrayList<Match> matchPossiblePoule(ArrayList<Equipe> poule) {
        ArrayList<Match> matchspossibles = new ArrayList<>();
        Match temp;
        //creation de la phase aller
        for (int i = 0; i < poule.size(); i++) {
            for (int j = i + 1; j < poule.size(); j++) {
                temp = new Match(numPoule(poule.get(i)), poule.get(i), poule.get(j));
                matchspossibles.add(temp);
            }
        }
        return matchspossibles;
    }

    /**
     * *************************
     * Afficher le Calendrier pour 6 journées *************************
     */
    void afficherCalendrierPour6() {
        for (int j = 0; j < 6; j++) {
            System.out.println("JOURNEE " + j);
            calendrier.get(j).afficheMatch();
            System.out.println();
        }
    }

    /**
     * *************************
     * Afficher le classement de chaque poules *************************
     */
    void afficherClassement() {
        for (Poule p : poules) {
            System.out.println("Poule " + p.getNumPoule());
            for (Position pos : p.getClassement()) {
                System.out.println(pos.getPositionEquipe() + " " + pos.getEquipe().getNomEquipe() + " " + pos.getScore() + " " + pos.getNombreVictoire() + "/" + pos.getNombreNul() + "/" + pos.getNombreDefaite() + " - " + pos.getButsMarques() + "/" + pos.getButsEncaisses());
            }
        }
    }

    /**
     * *************************
     * Créer une Journée *************************
     */
    private void creerJournees(int nbjournee) {
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

        for (int i = 0; i < poules.size(); i++) { // pour chaque poule
                /* Prend les matchs dispo*/
            matchspossibles = this.matchPossiblePoule(poules.get(i).getEquipes());
            matchsdispo = new ArrayList<Boolean>();
            for (int a = 0; a < nbjournee * (poules.get(i).getEquipes().size() / 2); a++) {
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
                            inv.setNum_poule(numPoule(temp2)); // Rajouté pour le num de poule
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
        /*
         for (int i = 0; i < poules.size(); i++) {
         matchspossibles = this.matchPossiblePoule(poules.get(i));
         matchsdispo = new ArrayList<Boolean>();
         for (int a = 0; a < nbjournee * (poules.get(i).size() / 2); a++) {
         matchsdispo.add(Boolean.TRUE);
         }
         for (int j = 0; j < nbjournee; j++) { // pour chaque journee
         calendrier.add(new Journee(j));
         for (int t = 0; t < (matchspossibles.size() / nbjournee); t++) {
         randEquipe = rd.nextInt(matchspossibles.size());
         if (matchsdispo.get(randEquipe)==true) { // si le match est dispo
         temp1=matchspossibles.get(randEquipe).getEquipeLocale();
         temp2=matchspossibles.get(randEquipe).getEquipeExterieure();
         if (calendrier.get(j).equipeEstDansLaJournée(temp1)==false || calendrier.get(j).equipeEstDansLaJournée(temp2)==false) {//fonction test si le match n'est pas dans la journée
         matchsdispo.set(randEquipe, Boolean.FALSE);
         calendrier.get(j).ajouterMatch(matchspossibles.get(randEquipe));
         }
         }
         }
         }
         }*/
    }

    /**
     * *************************
     * Créer les résultats de la phase de poule aléatoirement
     * *************************
     */
    public void resultatAleatoire() {
        Random rd = new Random();
        int randA, randB;
        for (Journee j : calendrier) {
            for (Match m : j.getMatch_journee()) {
                randA = rd.nextInt(5);
                randB = rd.nextInt(5);
                m.setScoreLocal(randA);
                m.setScoreExterieur(randB);
            }
            for (Poule p : poules) {
                p.majClassement(j.getNum_Journee());
            }
        }
    }

}
