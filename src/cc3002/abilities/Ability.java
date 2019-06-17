package cc3002.abilities;

import cc3002.effect.IEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorAbility;

public class Ability extends AbstractAbility implements IAbility{
    private String name;
    private String description;
    private EnergyCost energyCost;
    private IPokemon associatedPokemon;
    private IEffect effect;

    /**
     * Create a new ability
     *
     * @param name Ability name
     * @param description Text description of the ability
     * @param energyCost Energy cost of the ability
     */
    public Ability(String name, String description, EnergyCost energyCost, IEffect effect) {
        super(name,description,energyCost,effect);

    }

    @Override
    public void acceptVisitor(IVisitorAbility visitorAbility) {
        visitorAbility.visitAbility(this);
    }


}
