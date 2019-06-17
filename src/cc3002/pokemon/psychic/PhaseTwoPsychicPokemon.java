package cc3002.pokemon.psychic;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

public class PhaseTwoPsychicPokemon extends AbstractPsychicPokemon implements IPhaseTwoPokemon {
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
    public PhaseTwoPsychicPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList, int phaseOnePokemonIDPreEv) {
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
