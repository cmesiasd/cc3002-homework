package cc3002.tarea1.pokemon.fire;

import cc3002.tarea1.pokemon.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.cost.Cost;
import cc3002.tarea1.pokemon.IPokemon;
import cc3002.tarea1.pokemon.water.WaterPokemon;

import java.util.List;

/**
 * Create Fire Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class FirePokemon extends AbstractPokemon {

    /**
     * Constructor for Lighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
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
