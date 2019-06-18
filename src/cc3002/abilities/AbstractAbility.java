package cc3002.abilities;

import cc3002.effect.IEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorAbility;

/**
 * Abstract Class for abilities
 *
 * @author cmesiasd
 * @version 2.0
 */
public abstract class AbstractAbility implements IAbility{
    private String name;
    private String description;
    private EnergyCost energyCost;
    private IPokemon associatedPokemon;
    private IEffect effect;
    private int baseDamage;

    /**
     * Abstract constructor for abilities.
     *
     * @param name Ability's name
     * @param description Ability's description
     * @param energyCost Ability's energy cost
     * @param effect Ability's effect
     */
    public AbstractAbility(String name, String description, EnergyCost energyCost, IEffect effect) {
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
        this.effect = effect;
        this.baseDamage = 0;
    }

    //region Propierties

    /**
     * @return Ability's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Ability's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Ability's EnergyCost
     */
    public EnergyCost getEnergyCost() {
        return energyCost;
    }

    /**
     * @return A effect's Ability
     */
    @Override
    public IEffect getEffect() {
        return this.effect;
    }

    /**
     * @return Base Damages's Ability
     */
    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Ability accepts a visitor
     * @param visitorAbility visitor
     */
    @Override
    public abstract void acceptVisitor(IVisitorAbility visitorAbility);

    /**
     * @return associated Pokemon with a ability
     */
    @Override
    public IPokemon getAssociatedPokemon() {
        return this.associatedPokemon;
    }

    /**
     * @param pokemon a Pokemon
     */
    @Override
    public void setAssociatedPokemon(IPokemon pokemon) {
        this.associatedPokemon = pokemon;
    }
    //endregion
}
