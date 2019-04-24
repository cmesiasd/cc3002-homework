package cc3002.tarea1.lighting;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.fighting.FightingPokemon;

import java.util.List;

public class LightingPokemon extends AbstractPokemon {

    public LightingPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByLightingPokemon(this);
    }

    @Override
    public void attackedByFightingPokemon(FightingPokemon fightingPokemon) {
        receiveWeaknessAttack(fightingPokemon);
    }
}
