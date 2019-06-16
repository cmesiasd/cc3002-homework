package cc3002.pokemon.grass;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Grass Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class BasicGrassPokemon extends AbstractGrassPokemon implements IBasicPokemon {

    /**
     * Constructor for Grass Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicGrassPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Ability> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitBasicPokemon(this);
    }

}
