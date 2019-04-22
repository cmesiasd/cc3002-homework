package cc3002.tarea1.grass;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;

import java.util.List;

public class GrassPokemon extends AbstractPokemon {
    public GrassPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

}
