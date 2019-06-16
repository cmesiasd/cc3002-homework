package cc3002.pokemon.water;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

public class PhaseTwoWaterPokemon extends AbstractWaterPokemon implements IPhaseTwoPokemon {
    private int PhaseOnePokemonIDPreEv;
    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public PhaseTwoWaterPokemon(String name, int hp, int id, EnergyCost countEnergy, List<Ability> attackList, int phaseOnePokemonIDPreEv) {
        super(name, hp, id, countEnergy, attackList);
        this.PhaseOnePokemonIDPreEv = phaseOnePokemonIDPreEv;
    }


    @Override
    public int getIDPhaseOnePokemonToEvolve() {
        return PhaseOnePokemonIDPreEv;
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitPhaseTwoPokemon(this);
    }
}
