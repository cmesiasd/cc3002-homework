package cc3002.pokemon.fighting;

import cc3002.abilities.Ability;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.visitor.IVisitorPokemonType;

import java.util.List;

public abstract class AbstractFightingPokemon extends AbstractPokemon {
    /**
     * Creates a new Pokémon.
     *  @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public AbstractFightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorPokemonType visitorPokemonType) {
        visitorPokemonType.visitFightingPokemon(this);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByFightingPokemon(this);
    }

    @Override
    public void attackedByPsychicPokemon(AbstractPsychicPokemon psychicPokemon) {
        receiveWeaknessAttack(psychicPokemon);
    }

    @Override
    public void attackedByGrassPokemon(AbstractGrassPokemon grassPokemon) {
        receiveWeaknessAttack(grassPokemon);
    }
}
