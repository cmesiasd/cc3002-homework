package cc3002.abilities;

import cc3002.effect.IEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorAbility;

public abstract class AbstractAbility implements IAbility{
    private String name;
    private String description;
    private EnergyCost energyCost;
    private IPokemon associatedPokemon;
    private IEffect effect;
    private int baseDamage;

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

    @Override
    public IEffect getEffect() {
        return this.effect;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public abstract void acceptVisitor(IVisitorAbility visitorAbility);

    @Override
    public IPokemon getAssociatedPokemon() {
        return this.associatedPokemon;
    }

    @Override
    public void setAssociatedPokemon(IPokemon pokemon) {
        this.associatedPokemon = pokemon;
    }
    //endregion
}
