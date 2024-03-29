package cc3002.pokemon.fire;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IBasicPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Basic Fire Pokemon
 *
 * @author cmesiasd
 * @version 2.0
 */
public class BasicFirePokemon extends AbstractFirePokemon implements IBasicPokemon {

    /**
     * Constructor for Lighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicFirePokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitBasicPokemon(this);
    }

}
