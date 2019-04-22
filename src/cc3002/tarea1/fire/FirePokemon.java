package cc3002.tarea1.fire;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;

import java.util.List;

public class FirePokemon extends AbstractPokemon {

    protected FirePokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }
}
