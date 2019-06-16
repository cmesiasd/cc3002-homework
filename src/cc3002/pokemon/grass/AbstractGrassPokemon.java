package cc3002.pokemon.grass;

import cc3002.abilities.Ability;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

import java.util.List;

public abstract class AbstractGrassPokemon extends AbstractPokemon {
    /**
     * Creates a new Pokémon.
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public AbstractGrassPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Ability> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByGrassPokemon(this);
    }

    @Override
    public void attackedByFirePokemon(AbstractFirePokemon firePokemon) {
        receiveWeaknessAttack(firePokemon);
    }

    @Override
    public void attackedByWaterPokemon(AbstractWaterPokemon waterPokemon) {
        receiveResistantAttack(waterPokemon);
    }
}
