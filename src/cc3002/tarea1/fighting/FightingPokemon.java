package cc3002.tarea1.fighting;

import cc3002.tarea1.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Cost;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.grass.GrassPokemon;
import cc3002.tarea1.psychic.PsychicPokemon;

import java.util.List;

public class FightingPokemon extends AbstractPokemon {

    public FightingPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByFightingPokemon(this);
    }

    @Override
    public void attackedByPsychicPokemon(PsychicPokemon psychicPokemon) {
        receiveWeaknessAttack(psychicPokemon);
    }

    @Override
    public void attackedByGrassPokemon(GrassPokemon grassPokemon) {
        receiveWeaknessAttack(grassPokemon);
    }
}