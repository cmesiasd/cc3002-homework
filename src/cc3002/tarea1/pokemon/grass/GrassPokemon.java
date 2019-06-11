package cc3002.tarea1.pokemon.grass;

import cc3002.tarea1.pokemon.AbstractPokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.cost.Cost;
import cc3002.tarea1.pokemon.IPokemon;
import cc3002.tarea1.pokemon.fire.FirePokemon;
import cc3002.tarea1.pokemon.water.WaterPokemon;

import java.util.List;

/**
 * Create Grass Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class GrassPokemon extends AbstractPokemon {

    /**
     * Constructor for Grass Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
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