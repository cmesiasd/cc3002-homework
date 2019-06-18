package cc3002.pokemon.fighting;

import cc3002.abilities.Ability;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.abilities.Attack;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Basic Fighting Pokemon
 *
 * @author cmesiasd
 * @version 2.0
 */
public class BasicFightingPokemon extends AbstractFightingPokemon implements IBasicPokemon {

    /**
     * Constructor for Fighting Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicFightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitBasicPokemon(this);
    }

}
