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

    public Championnat() {
        super();
    }

    public Championnat(String nomCompetition, int saison, int idCompetition, ArrayList<Equipe> equipe) {
        super(nomCompetition, saison, idCompetition, equipe);
        nbEquipe = equipe.size();
        nbJournee = 2 * (nbEquipe - 1);
        rencontres = new Match[nbJournee][nbEquipe / 2];
    }

    private void genererMatches() {
        Collections.shuffle(equipe);
        //c'est ici qu'on mélange l'équipe.
        ArrayList<Match> listeMatch = new ArrayList();

        for (int i = 0; i < nbEquipe; i++) {
            for (int j = i + 1; j < nbEquipe; j++) {
                listeMatch.add(new Match(equipe.get(i), equipe.get(j)));
            }
        }

        boolean[][] equipesDispo = new boolean[nbJournee/2][nbEquipe];

        while (!listeMatch.isEmpty()) {
            for (int i = 0; i < nbJournee/2; i++) {
                for (int j = 0; j < nbEquipe / 2; j++) {
                    if (rencontres[i][j] == null) {
                        if (!equipesDispo[j][equipe.indexOf(listeMatch.get(0).getEquipeLocale())]
                                && !equipesDispo[j][equipe.indexOf(listeMatch.get(0).getEquipeExterieure())]) {

                            rencontres[i][j] = listeMatch.get(0);
                            listeMatch.remove(0);

                            equipesDispo[j][equipe.indexOf(rencontres[i][j].getEquipeLocale())] = true;
                            equipesDispo[j][equipe.indexOf(rencontres[i][j].getEquipeExterieure())] = true;
                        }
                    }
                }
            }
        }
        for(int i = nbJournee/2; i< nbJournee; i++){
            for(int j = 0; j < nbEquipe/2; j++){
                rencontres[i][j]=rencontres[i-(nbJournee/2)][j].mirror();
            }
        }
        

    }

    //verifie si l'équipe a a jouer le match aller avec l'équpe b
    private boolean checkJouer(Equipe a, Equipe b) {

        for (int i = 0; i < nbJournee; i++) {
            for (int j = 0; j < nbEquipe / 2; j++) {
                if (rencontres[i][j].getEquipeLocale().getIdEquipe() == a.getIdEquipe()) {
                    if (rencontres[i][j].getEquipeExterieure().getIdEquipe() == b.getIdEquipe()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
