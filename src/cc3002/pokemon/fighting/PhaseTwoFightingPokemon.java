package cc3002.pokemon.fighting;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Phase Two Fighting Pokemon
 *
 * @author cmesiasd
 * @version 2.0
 */
public class PhaseTwoFightingPokemon extends AbstractFightingPokemon implements IPhaseTwoPokemon {
    private int phaseOnePokemonIDPreEv;

    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public PhaseTwoFightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList, int phaseOnePokemonIDPreEv) {
        super(name, hp, id, countEnergy, attackList);
        this.phaseOnePokemonIDPreEv = phaseOnePokemonIDPreEv;
    }

    @Override
    public int getIDPhaseOnePokemonToEvolve() {
        return phaseOnePokemonIDPreEv;
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitPhaseTwoPokemon(this);
    }
}
