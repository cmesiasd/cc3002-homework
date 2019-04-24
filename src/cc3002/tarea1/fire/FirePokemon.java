package cc3002.tarea1.fire;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.water.WaterPokemon;

import java.util.List;

public class FirePokemon extends AbstractPokemon {

    public FirePokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByFirePokemon(this);
    }

    @Override
    public void attackedByWaterPokemon(WaterPokemon waterPokemon) {
        receiveWeaknessAttack(waterPokemon);
    }
}
