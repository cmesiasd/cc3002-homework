package cc3002.pokemon.water;

import cc3002.abilities.Ability;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.lighting.AbstractLightingPokemon;

import java.util.List;

public abstract class AbstractWaterPokemon extends AbstractPokemon {

    /**
     * Creates a new Pokémon.
     *  @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public AbstractWaterPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Ability> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByWaterPokemon(this);
    }

    @Override
    public void attackedByGrassPokemon(AbstractGrassPokemon grassPokemon) {
        receiveWeaknessAttack(grassPokemon);
    }

    @Override
    public void attackedByLightingPokemon(AbstractLightingPokemon lightingPokemon) {
        receiveWeaknessAttack(lightingPokemon);
    }

    @Override
    public void attackedByFightingPokemon(AbstractFightingPokemon fightingPokemon) {
        receiveResistantAttack(fightingPokemon);
    }
}
