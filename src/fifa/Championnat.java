/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;
import java.util.Collections;

public class Championnat extends Nationale {

    private int nbEquipe;
    private int nbJournee;
    private Match[][] rencontres;
    private Position[] classement;
    

    public Championnat() {
        super();
        nbEquipe = equipe.size();
        nbJournee = 2 * (nbEquipe - 1);
        rencontres = new Match[nbJournee][nbEquipe / 2];
        classement = new Position[this.equipe.size()];
        genererMatches();
    }

    public Championnat(String nomCompetition, int saison, int idCompetition, ArrayList<Equipe> equipe) {
        super(nomCompetition, saison, idCompetition, equipe);
        nbEquipe = equipe.size();
        nbJournee = 2 * (nbEquipe - 1);
        rencontres = new Match[nbJournee][nbEquipe / 2];
        genererMatches();
    }

    private boolean genererMatches() {
        Collections.shuffle(this.equipe);
        //c'est ici qu'on mélange l'équipe.
        ArrayList<Match> listeMatch = new ArrayList();

        for (int i = 0; i < nbEquipe; i++) {
            for (int j = i + 1; j < nbEquipe; j++) {
                listeMatch.add(new Match(this.equipe.get(i), this.equipe.get(j)));
            }
        }

        boolean[][] equipesDispo = new boolean[nbJournee / 2][nbEquipe];
        boolean continuer = true;
        while (!listeMatch.isEmpty()) {
            for (int i = 0; i < nbJournee / 2; i++) {
                if (!listeMatch.isEmpty()) {

                    if (!equipesDispo[i][this.equipe.indexOf(listeMatch.get(0).getEquipeLocale())]
                            && !equipesDispo[i][this.equipe.indexOf(listeMatch.get(0).getEquipeExterieure())]) {
                        continuer = true;
                        for (int j = 0; j < nbEquipe / 2; j++) {
                            if (continuer) {
                                if (rencontres[i][j] == null) {
                                    rencontres[i][j] = listeMatch.get(0);
                                    listeMatch.remove(0);

                                    equipesDispo[i][this.equipe.indexOf(rencontres[i][j].getEquipeLocale())] = true;
                                    equipesDispo[i][this.equipe.indexOf(rencontres[i][j].getEquipeExterieure())] = true;

                                    continuer = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = nbJournee / 2; i < nbJournee; i++) {
            for (int j = 0; j < nbEquipe / 2; j++) {
                rencontres[i][j] = rencontres[i - (nbJournee / 2)][j].mirror();
            }
        }
        return false;
    }

   

    public void affiche() {
        for (int i = 0; i < nbJournee; i++) {
            System.out.println("** Journée "+i+" **");
            for (int j = 0; j < nbEquipe / 2; j++) {
                System.out.println(j+" "+rencontres[i][j]);
            }
        }
    }

}
