package cc3002.effect;

import cc3002.abilities.StrikesBack;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.StrikesBackVisitor;

public class StrikeBackEffect extends AbstractEffect {
    @Override
    public void doEffect() {
        IPokemon pokemon = this.getAbility().getAssociatedPokemon();
        StrikesBackVisitor visitor = new StrikesBackVisitor();
        pokemon.acceptVisitor(visitor);
    }
}
