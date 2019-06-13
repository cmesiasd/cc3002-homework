package cc3002.pokemon.fire;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;

import java.util.List;

/**
 * Create Fire Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class BasicFirePokemon extends AbstractFirePokemon {

    /**
     * Constructor for Lighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicFirePokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }


}
