package cc3002.trainerCards;

import cc3002.effect.IEffect;
import cc3002.effect.ProfessorJuniperEffect;

/**
 * Implementation of Support Card
 * Professor Juniper
 *
 * @author cmesiasd
 * @version 2.0
 */
public class ProfessorJuniper extends SupportCard{
    public ProfessorJuniper() {
        super("Professor Juniper", "Descarta tu mano y roba 7 cartas", new ProfessorJuniperEffect());
    }
}
