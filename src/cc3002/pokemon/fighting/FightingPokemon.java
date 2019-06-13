package cc3002.pokemon.fighting;

import cc3002.pokemon.AbstractPokemon;
import cc3002.Attack;
import cc3002.cost.Cost;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.grass.GrassPokemon;
import cc3002.pokemon.psychic.PsychicPokemon;

import java.util.List;

/**
 * Create Fighting Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class FightingPokemon extends AbstractPokemon {

    /**
     * Constructor for Fighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
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
