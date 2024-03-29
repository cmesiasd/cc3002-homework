package cc3002.pokemon.lighting;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;
import cc3002.abilities.IAbility;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPhaseOnePokemon;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.visitor.IVisitorCard;

import java.util.List;

/**
 * Create Phase One Lighting Pokemon
 *
 * @author cmesiasd
 * @version 2.0
 */
public class PhaseOneLightingPokemon extends AbstractLightingPokemon implements IPhaseOnePokemon {
    private int basicPokemonIDPreEv;

    /**
     * Creates a new Pokémon.
     *
     * @param name        Pokémon's name.
     * @param hp          Pokémon's hit points.
     * @param id          Pokemon's id.
     * @param countEnergy Pokemon's counter energies
     * @param attackList  Pokémon's attacks list.
     */
    public PhaseOneLightingPokemon(String name, int hp, int id, EnergyCost countEnergy, List<IAbility> attackList, int basicPokemonIDPreEv) {
        super(name, hp, id, countEnergy, attackList);
        this.basicPokemonIDPreEv = basicPokemonIDPreEv;
    }

    @Override
    public int getIDBasicPokemonToEvolve() {
        return this.basicPokemonIDPreEv;
    }

    @Override
    public void acceptVisitor(IVisitorCard visitorCard) {
        visitorCard.visitPhaseOnePokemon(this);
    }
}
