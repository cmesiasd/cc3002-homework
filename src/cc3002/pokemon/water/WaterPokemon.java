package cc3002.pokemon.water;

import cc3002.abilities.Attack;
import cc3002.energyCost.energyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.fighting.FightingPokemon;
import cc3002.pokemon.lighting.LightingPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.grass.GrassPokemon;

import java.util.List;

/**
 * Create Water Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class WaterPokemon extends AbstractPokemon {

    /**
     * Constructor for WaterPokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public WaterPokemon(String name, int hp, int id, energyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByWaterPokemon(this);
    }

    @Override
    public void attackedByGrassPokemon(GrassPokemon grassPokemon) {
        receiveWeaknessAttack(grassPokemon);
    }

    @Override
    public void attackedByLightingPokemon(LightingPokemon lightingPokemon) {
        receiveWeaknessAttack(lightingPokemon);
    }

    @Override
    public void attackedByFightingPokemon(FightingPokemon fightingPokemon) {
        receiveResistantAttack(fightingPokemon);
    }

}
