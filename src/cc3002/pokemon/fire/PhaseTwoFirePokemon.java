package cc3002.pokemon.fire;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;

import java.util.List;

public class PhaseTwoFirePokemon extends AbstractFirePokemon {
    /**
     * Creates a new Fire Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public PhaseTwoFirePokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }
}
