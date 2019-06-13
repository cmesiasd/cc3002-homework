package cc3002.pokemon.lighting;

import cc3002.abilities.Attack;
import cc3002.pokemon.AbstractPokemon;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;

import java.util.List;

/**
 * Create Lighting Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class BasicLightingPokemon extends AbstractLightingPokemon {

    /**
     * Constructor for Lighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicLightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }


}