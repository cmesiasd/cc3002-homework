package cc3002.pokemon.psychic;

import cc3002.abilities.Ability;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.visitor.IVisitorPokemonType;

import java.util.List;


/**
 * Abstract class for Psychic Pokemon
 *
 * @author cmesiasd
 * @version 2.0
 */
public abstract class AbstractPsychicPokemon extends AbstractPokemon {
    /**
     * Creates a new Pokémon.
     *  @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public AbstractPsychicPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorPokemonType visitorPokemonType) {
        visitorPokemonType.visitPsychicPokemon(this);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByPsychicPokemon(this);
    }

    @Override
    public void attackedByPsychicPokemon(AbstractPsychicPokemon psychicPokemon) {
        receiveWeaknessAttack(psychicPokemon);
    }

    @Override
    public void attackedByFightingPokemon(AbstractFightingPokemon fightingPokemon) {
        receiveResistantAttack(fightingPokemon);
    }
}
