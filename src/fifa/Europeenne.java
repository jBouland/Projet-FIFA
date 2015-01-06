/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifa;

import java.util.ArrayList;

public abstract class Europeenne extends Competition {

    public Europeenne(int idCompetition, String nomCoupeEurope, int saison, ArrayList<Equipe> equipe) {
        super(nomCoupeEurope, idCompetition, saison, equipe);
    }
    
}
