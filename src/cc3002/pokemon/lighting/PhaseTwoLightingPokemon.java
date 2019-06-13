package cc3002.pokemon.lighting;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;

import java.util.List;

public class PhaseTwoLightingPokemon extends AbstractLightingPokemon {
    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public PhaseTwoLightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }
}