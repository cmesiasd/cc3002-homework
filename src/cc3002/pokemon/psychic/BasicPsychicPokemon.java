package cc3002.pokemon.psychic;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Psychic Pokemon
 *
 * @author cmesiasd
 * @version 1.0
 */
public class BasicPsychicPokemon extends AbstractPsychicPokemon implements IBasicPokemon {

    /**
     * Constructor for Psychic Pokemon
     *
     * @param name Pokemon's name
     * @param hp Pokemon's hit points
     * @param id Pokemon's id
     * @param countEnergy Pokemon's counter energies
     * @param attackList Pokemon's attacks list
     */
    public BasicPsychicPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Ability> attackList) {
        super(name, hp, id, countEnergy, attackList);
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitBasicPokemon(this);
    }

}
