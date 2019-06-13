package cc3002.pokemon.fire;

import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

import java.util.List;

public abstract class AbstractFirePokemon extends AbstractPokemon {

    /**
     * Creates a new Fire Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public AbstractFirePokemon(String name, int hp, int id, EnergyCost countEnergy, List<Attack> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void attack(IPokemon other, int index) {
        this.selectAttack(index);
        other.attackedByFirePokemon(this);
    }

    @Override
    public void attackedByWaterPokemon(AbstractWaterPokemon waterPokemon) {
        receiveWeaknessAttack(waterPokemon);
    }
}
