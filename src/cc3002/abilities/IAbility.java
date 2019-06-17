package cc3002.abilities;

import cc3002.effect.IEffect;
import cc3002.energyCost.EnergyCost;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.IVisitorAbility;

public interface IAbility {
    String getName();
    String getDescription();
    EnergyCost getEnergyCost();
    int getBaseDamage();

    IEffect getEffect();
    void acceptVisitor(IVisitorAbility visitorAbility);

    IPokemon getAssociatedPokemon();

    void setAssociatedPokemon(IPokemon pokemon);

}
