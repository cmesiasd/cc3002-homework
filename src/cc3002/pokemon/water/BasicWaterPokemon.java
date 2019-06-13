package cc3002.pokemon.water;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.lighting.AbstractLightingPokemon;

import java.util.List;

/**
 * Create Water Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class BasicWaterPokemon extends AbstractWaterPokemon {

    /**
     * Constructor for BasicWaterPokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicWaterPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }



}
