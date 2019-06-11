package cc3002.pokemon.psychic;

import cc3002.Attack;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.fighting.FightingPokemon;
import cc3002.cost.Cost;
import cc3002.pokemon.IPokemon;

import java.util.List;

/**
 * Create Psychic Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class PsychicPokemon extends AbstractPokemon {

    /**
     * Constructor for Psychic Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public PsychicPokemon(String name, int hp, int id, Cost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByPsychicPokemon(this);
    }

    @Override
    public void attackedByPsychicPokemon(PsychicPokemon psychicPokemon) {
        receiveWeaknessAttack(psychicPokemon);
    }

    @Override
    public void attackedByFightingPokemon(FightingPokemon fightingPokemon) {
        receiveResistantAttack(fightingPokemon);
    }


}
