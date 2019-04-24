package cc3002.tarea1.grass;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.fire.FirePokemon;
import cc3002.tarea1.water.WaterPokemon;

import java.util.List;

public class GrassPokemon extends AbstractPokemon {

    public GrassPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByGrassPokemon(this);
    }

    @Override
    public void attackedByFirePokemon(FirePokemon firePokemon) {
        receiveWeaknessAttack(firePokemon);
    }

    @Override
    public void attackedByWaterPokemon(WaterPokemon waterPokemon) {
        receiveResistantAttack(waterPokemon);
    }
}
