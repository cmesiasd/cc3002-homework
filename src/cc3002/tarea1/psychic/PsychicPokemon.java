package cc3002.tarea1.psychic;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;

import java.util.List;

public class PsychicPokemon extends AbstractPokemon {
    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's attack cost
     * @param attackList  Pokémon's attacks.
     */
    protected PsychicPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }
}
